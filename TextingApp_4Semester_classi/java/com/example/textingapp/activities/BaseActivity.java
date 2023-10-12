package com.example.textingapp.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.textingapp.pripomocki.Konstante;
import com.example.textingapp.pripomocki.Preference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class BaseActivity extends AppCompatActivity {

    private DocumentReference documentReference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Preference preference = new Preference(getApplicationContext());
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        documentReference = database.collection(Konstante.KLJUC_UPORABNIKI)
                .document(preference.getString(Konstante.KLJUC_ID_UPORABNIKA));
    }

    @Override
    protected void onPause() {
        super.onPause();
        documentReference.update(Konstante.KLJUC_DOSEGLJIVOST,0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        documentReference.update(Konstante.KLJUC_DOSEGLJIVOST,1);
    }
}
