package com.example.textingapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;
import com.example.textingapp.R;
import com.example.textingapp.databinding.ActivitySignInBinding;
import com.example.textingapp.pripomocki.Konstante;
import com.example.textingapp.pripomocki.Preference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;

public class SignInActivity extends AppCompatActivity {

    private ActivitySignInBinding binding;
    private Preference preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Ustvari instanco razreda Preference za upravljanje nastavitev
        preferenceManager = new Preference(getApplicationContext());

        // Preveri, ali je uporabnik že prijavljen
        if(preferenceManager.getBoolean(Konstante.KLJUC_PRIJAVLJEN)) {
            // Če je uporabnik že prijavljen -> glavna aktivnost
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish(); // Zaključi trenutno aktivnost
        }


        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Nastavi poslušalce
        setListeners();
    }

    private void setListeners(){
        // Nastavi poslušalca za gumb
        binding.textCreateNewAccount.setOnClickListener(v ->
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class)));

        // Nastavi poslušalca za gumb sign in
        binding.ButtonSignIn.setOnClickListener(v -> {
            if(ValidSignIn()) {
                SignIn();
            }
        });
    }

    private void SignIn() {
        // Prikaži indikator nalaganja
        loading(true);

        // Pridobi instanco Firebase Firestore
        FirebaseFirestore baza = FirebaseFirestore.getInstance();


        baza.collection(Konstante.KLJUC_UPORABNIKI)
                .whereEqualTo(Konstante.KLJUC_MAIL, binding.inputEmail.getText().toString())
                .whereEqualTo(Konstante.KLJUC_GESLO, binding.inputPassword.getText().toString())
                .get()
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful() && task.getResult() != null
                            && task.getResult().getDocuments().size() > 0) {
                        DocumentSnapshot documentSnapshot = task.getResult().getDocuments().get(0);

                        // Shrani informacije o prijavljenem uporabniku v nastavitve
                        preferenceManager.putBoolean(Konstante.KLJUC_PRIJAVLJEN, true);
                        preferenceManager.putString(Konstante.KLJUC_ID_UPORABNIKA, documentSnapshot.getId());
                        preferenceManager.putString(Konstante.KLJUC_IME, documentSnapshot.getString(Konstante.KLJUC_IME));
                        preferenceManager.putString(Konstante.KLJUC_SLIKA, documentSnapshot.getString(Konstante.KLJUC_SLIKA));

                        // Preusmeri na glavno aktivnost
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else {

                        loading(false);
                        showToast("Unable to sign in");
                    }
                });
    }

    private void loading(Boolean isLoading) {
        if(isLoading) {
            // Skrij gumb za prijavo in prikaži indikator nalaganja
            binding.ButtonSignIn.setVisibility(View.INVISIBLE);
            binding.progressBar.setVisibility(View.VISIBLE);
        } else {
            // Skrij indikator nalaganja in prikaži gumb za prijavo
            binding.progressBar.setVisibility(View.INVISIBLE);
            binding.ButtonSignIn.setVisibility(View.VISIBLE);
        }
    }

    private void showToast(String message) {
        // Prikaži kratko sporočilo
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private Boolean ValidSignIn() {
        if (binding.inputEmail.getText().toString().trim().isEmpty()) {
            // Preveri, če je e-poštni naslov prazen
            showToast("Enter email");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.inputEmail.getText().toString()).matches()) {
            // Preveri, če je e-poštni naslov veljaven
            showToast("Enter valid email");
            return false;
        } else if (binding.inputPassword.getText().toString().trim().isEmpty()) {
            // Preveri, če je geslo prazno
            showToast("Enter Password");
            return false;
        } else {

            return true;
        }
    }
}
