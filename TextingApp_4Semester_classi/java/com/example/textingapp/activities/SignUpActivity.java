package com.example.textingapp.activities;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.provider.SyncStateContract;
import android.util.Base64;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;


import com.example.textingapp.databinding.ActivitySignInBinding;
import com.example.textingapp.databinding.ActivitySignUpBinding;
import com.example.textingapp.pripomocki.Konstante;
import com.example.textingapp.pripomocki.Preference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.regex.Pattern;
import android.content.Context;
import android.content.SharedPreferences;

public class SignUpActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;
    private String encodedSlika;
    private Preference preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferenceManager = new Preference(getApplicationContext());
        setListeners();
    }

    private void setListeners() {

        binding.textSignIn.setOnClickListener(v -> onBackPressed());
        binding.ButtonSignUp.setOnClickListener(v -> {
            if (isValidSignUpDetails()) {
                signUp();
            }
        });

        binding.layoutImage.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            chooseImage.launch(intent);
        });
    }

    private void showToast(String message)
    {
        Toast.makeText(getApplicationContext(), message , Toast.LENGTH_SHORT).show();
    }
    
    private void signUp()
    {

        loading(true);
        FirebaseFirestore baza = FirebaseFirestore.getInstance();
        HashMap<String,Object> user = new HashMap<>();
        user.put(Konstante.KLJUC_IME, binding.inputName.getText().toString());
        user.put(Konstante.KLJUC_MAIL, binding.inputEmail.getText().toString());
        user.put(Konstante.KLJUC_GESLO, binding.inputPassword.getText().toString());
        user.put(Konstante.KLJUC_SLIKA, encodedSlika);

        baza.collection(Konstante.KLJUC_UPORABNIKI)
                .add(user)
                .addOnSuccessListener(documentReference -> {

                    loading(false);
                    preferenceManager.putBoolean(Konstante.KLJUC_PRIJAVLJEN,true);
                    preferenceManager.putString(Konstante.KLJUC_ID_UPORABNIKA,documentReference.getId());
                    preferenceManager.putString(Konstante.KLJUC_IME,binding.inputName.getText().toString());
                    preferenceManager.putString(Konstante.KLJUC_SLIKA,encodedSlika);

                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                })
                .addOnFailureListener(exception -> {

                    loading(false);
                    showToast(exception.getMessage());

                });
    }

    private String encodeImage(Bitmap bitmap)
    {
        int previewWidth=150;
        int previewHeight=bitmap.getHeight() * previewWidth/bitmap.getWidth();

        Bitmap previewBitmap = Bitmap.createScaledBitmap(bitmap,previewWidth,previewHeight,false);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        previewBitmap.compress(Bitmap.CompressFormat.JPEG,50,byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    private final ActivityResultLauncher<Intent> chooseImage = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),result ->
            {
                if(result.getResultCode() == RESULT_OK)
                {
                    if(result.getData()!=null)
                    {
                        Uri imageUri = result.getData().getData();
                        try {
                            InputStream inputStream = getContentResolver().openInputStream(imageUri);
                            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            binding.imageProfile.setImageBitmap(bitmap);

                            binding.textAddImage.setVisibility(View.GONE);
                            encodedSlika=encodeImage(bitmap);
                        }
                        catch (FileNotFoundException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            }
    );

    private Boolean isValidSignUpDetails()
    {
        if(encodedSlika == null)
        {
            showToast("Select profile image");
            return false;
        }
        else if(binding.inputName.getText().toString().trim().isEmpty())
        {
            showToast("Enter name");
            return false;
        }

        else if(binding.inputEmail.getText().toString().trim().isEmpty())
        {
            showToast("Enter email");
            return false;
        }

        else if(!Patterns.EMAIL_ADDRESS.matcher(binding.inputEmail.getText().toString()).matches())
        {
            showToast("Enter valid email");
            return false;
        }

        else if(binding.inputPassword.getText().toString().trim().isEmpty())
        {
            showToast("Enter Password");
            return false;
        }

        else if(binding.inputConfirmPassword.getText().toString().trim().isEmpty())
        {
            showToast("Confirm your password");
            return false;
        }

        else if(!binding.inputPassword.getText().toString().equals(binding.inputConfirmPassword.getText().toString()))
        {
            showToast("Password must be the same");
            return false;
        }

        else
        {
            return true;
        }
    }

    private void loading(Boolean loada)
    {
        if(loada)
        {
            binding.ButtonSignUp.setVisibility(View.INVISIBLE);
            binding.progressBar.setVisibility(View.VISIBLE);
        }

        else

        {
            binding.ButtonSignUp.setVisibility(View.VISIBLE);
            binding.progressBar.setVisibility(View.INVISIBLE);
        }
    }

}