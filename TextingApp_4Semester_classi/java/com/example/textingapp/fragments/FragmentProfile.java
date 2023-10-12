package com.example.textingapp.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.textingapp.R;
import com.example.textingapp.activities.SignInActivity;
import com.example.textingapp.databinding.ActivityMainBinding;
import com.example.textingapp.pripomocki.Konstante;
import com.example.textingapp.pripomocki.Preference;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessaging;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentProfile extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private ActivityMainBinding binding;
    private Preference preferenceManager;

    private String mParam1;
    private String mParam2;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    public FragmentProfile() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        preferenceManager = new Preference(getActivity().getApplicationContext());
        loadUserDetails();
        getToken();
        setListeners();

        super.onViewCreated(view, savedInstanceState);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentProfile.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentProfile newInstance(String param1, String param2) {
        FragmentProfile fragment = new FragmentProfile();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    private void loadUserDetails()
    {
        TextView textView = (TextView)getView().findViewById(R.id.textName);
        textView.setText(preferenceManager.getString(Konstante.KLJUC_IME));

        byte[] bytes = Base64.decode(preferenceManager.getString(Konstante.KLJUC_SLIKA),Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);

        RoundedImageView roundedImageView = (RoundedImageView)getView().findViewById(R.id.imageProfile);
        roundedImageView.setImageBitmap(bitmap);
    }

    private void setListeners()
    {
        ImageButton imageButton = (ImageButton)getView().findViewById(R.id.imageButtonSignOut);
        imageButton.setOnClickListener(v -> signOut());
    }

    private void signOut()
    {
        showToast("Signing out...");
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        DocumentReference documentReference =
                database.collection(Konstante.KLJUC_UPORABNIKI).document(
                        preferenceManager.getString(Konstante.KLJUC_ID_UPORABNIKA)
                );

        HashMap<String,Object> updates = new HashMap<>();
        updates.put(Konstante.KLJUC_FCM_TOKEN, FieldValue.delete());
        documentReference.update(updates)
                .addOnSuccessListener(unused -> {
                    preferenceManager.clear();
                    startActivity(new Intent(getActivity().getApplicationContext(), SignInActivity.class));
                    //finish();
                })
                .addOnFailureListener(e -> showToast("Unable to sign out"));

    }

    private void showToast(String message)
    {

        Toast.makeText(getActivity().getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    private void getToken()
    {

        FirebaseMessaging.getInstance().getToken().addOnSuccessListener(this::updateToken);

        /*
        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            @Override
            public void onComplete(@NonNull Task<InstanceIdResult> task) {

                updateToken(FirebaseInstanceId.getInstance().getToken());

            }
        });
*/
    }

    private void updateToken(String token)
    {
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        DocumentReference documentReference =
                database.collection(Konstante.KLJUC_UPORABNIKI).document(
                        preferenceManager.getString(Konstante.KLJUC_ID_UPORABNIKA)
                );

        documentReference.update(Konstante.KLJUC_FCM_TOKEN,token)
                .addOnFailureListener(e -> showToast("Unable to update token"));
    }


}