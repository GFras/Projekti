package com.example.textingapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.textingapp.R;
import com.example.textingapp.adapters.UsersAdapter;
import com.example.textingapp.databinding.ActivityUsersBinding;
import com.example.textingapp.fragments.FragmentProfile;
import com.example.textingapp.listeneri.UserListener;
import com.example.textingapp.models.User;
import com.example.textingapp.pripomocki.Konstante;
import com.example.textingapp.pripomocki.Preference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class UsersActivity extends BaseActivity implements UserListener {

    private ActivityUsersBinding binding;
    private Preference preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUsersBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        preferenceManager = new Preference(getApplicationContext());
        setListeners();
        getUsers();
    }

    private void setListeners()
    {

        binding.imageBack.setOnClickListener(v -> onBackPressed());
    }


    private void getUsers()
    {
        loading(true);
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        database.collection(Konstante.KLJUC_UPORABNIKI)
                .get()
                .addOnCompleteListener(task -> {
                    loading(false);
                    String currentUserId = preferenceManager.getString(Konstante.KLJUC_ID_UPORABNIKA);

                    if(task.isSuccessful()&&task.getResult()!=null) {
                        List<User> users = new ArrayList<>();
                        for (QueryDocumentSnapshot queryDocumentSnapshot : task.getResult()) {
                            if (currentUserId.equals(queryDocumentSnapshot.getId())) {
                                continue;
                            }
                            User user = new User();
                            user.name = queryDocumentSnapshot.getString(Konstante.KLJUC_IME);
                            user.email = queryDocumentSnapshot.getString(Konstante.KLJUC_MAIL);
                            user.image = queryDocumentSnapshot.getString(Konstante.KLJUC_SLIKA);
                            user.token = queryDocumentSnapshot.getString(Konstante.KLJUC_FCM_TOKEN);
                            user.id = queryDocumentSnapshot.getId();

                           //System.out.println("tak je "+queryDocumentSnapshot.getString(Konstante.KLJUC_FCM_TOKEN));
                            users.add(user);
                        }
                        if (users.size() > 0) {
                            UsersAdapter usersAdapter = new UsersAdapter(users, this);
                            binding.usersRecyclerView.setAdapter(usersAdapter);
                            binding.usersRecyclerView.setVisibility(View.VISIBLE);
                        }

                        else

                        {
                            showErrorMessage();
                        }

                    }
                        else
                    {
                            showErrorMessage();
                    }
                });
    }

    private void showErrorMessage()
    {
        binding.textErrorMessage.setText(String.format("%s","No user available"));
        binding.textErrorMessage.setVisibility(View.VISIBLE);
    }

    private void loading(Boolean isLoading)
    {
        if(isLoading)
        {
            binding.progressBar.setVisibility(View.VISIBLE);
        }
        else
        {
            binding.progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onUserClicked(User user) {
        Intent intent = new Intent(getApplicationContext(),ChatActivity.class);
        intent.putExtra(Konstante.KLJUC_USER, user);
        startActivity(intent);
        finish();
    }
}