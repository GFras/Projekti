package com.example.textingapp.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.textingapp.R;
import com.example.textingapp.activities.ChatActivity;
import com.example.textingapp.activities.UsersActivity;
import com.example.textingapp.adapters.RecentConversationsAdapter;
import com.example.textingapp.databinding.ActivityMainBinding;
import com.example.textingapp.listeneri.ConversionListener;
import com.example.textingapp.models.ChatMessage;
import com.example.textingapp.models.User;
import com.example.textingapp.pripomocki.Konstante;
import com.example.textingapp.pripomocki.Preference;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FragmentMain extends Fragment implements ConversionListener {

    private ActivityMainBinding binding;
    private Preference preferenceManager;
    private List<ChatMessage> conversations;
    private RecentConversationsAdapter conversationsAdapter;
    private FirebaseFirestore database;

    private String mParam1;
    private String mParam2;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        preferenceManager = new Preference(getActivity().getApplicationContext());

        init();
        loadUserDetails();
        getToken();
        setListeners();
        listenConversations();

        super.onViewCreated(view, savedInstanceState);
    }

    private void init()
    {
        conversations = new ArrayList<>();
        conversationsAdapter = new RecentConversationsAdapter(conversations, this);

        RecyclerView recyclerView = (RecyclerView)getView().findViewById(R.id.conversationsRecyclerView);
        recyclerView.setAdapter(conversationsAdapter);      //Mogoce ne dela
        database = FirebaseFirestore.getInstance();

    }

    private void setListeners()
    {
        FloatingActionButton floatingActionButton = (FloatingActionButton)getView().findViewById(R.id.newChat);
        floatingActionButton.setOnClickListener(v ->
                startActivity(new Intent(getActivity().getApplicationContext(), UsersActivity.class)));
    }

    private void loadUserDetails()
    {
        TextView textView = (TextView)getView().findViewById(R.id.textName);
        textView.setText(preferenceManager.getString(Konstante.KLJUC_IME));
    }

    private void showToast(String message)
    {
        Toast.makeText(getActivity().getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    private void listenConversations()
    {
        database.collection(Konstante.KLJUC_KOLEKCIJA_POGOVOROV)
                .whereEqualTo(Konstante.KLJUC_POSILJATELJ_ID, preferenceManager.getString(Konstante.KLJUC_ID_UPORABNIKA))
                .addSnapshotListener(eventListener);
        database.collection(Konstante.KLJUC_KOLEKCIJA_POGOVOROV)
                .whereEqualTo(Konstante.KLJUC_PREJEMNIK_ID,preferenceManager.getString(Konstante.KLJUC_ID_UPORABNIKA))
                .addSnapshotListener(eventListener);
    }

    private final EventListener<QuerySnapshot> eventListener = ((value, error) -> {
        if(error != null)
        {
            return;
        }

        if(value!=null)
        {
            for(DocumentChange documentChange : value.getDocumentChanges())
            {
                if(documentChange.getType() == DocumentChange.Type.ADDED)
                {
                    String senderId = documentChange.getDocument().getString(Konstante.KLJUC_POSILJATELJ_ID);
                    String receiverId = documentChange.getDocument().getString(Konstante.KLJUC_PREJEMNIK_ID);
                    ChatMessage chatMessage = new ChatMessage();
                    chatMessage.senderId = senderId;
                    chatMessage.receiverId = receiverId;

                    if(preferenceManager.getString(Konstante.KLJUC_ID_UPORABNIKA).equals(senderId))
                    {
                        chatMessage.conversionImage = documentChange.getDocument().getString(Konstante.KLJUC_SLIKA_PREJEMNIKA);
                        chatMessage.conversionName = documentChange.getDocument().getString(Konstante.KLJUC_IME_PREJEMNIKA);
                        chatMessage.conversionId = documentChange.getDocument().getString(Konstante.KLJUC_PREJEMNIK_ID);
                    }

                    else
                    {
                        chatMessage.conversionImage = documentChange.getDocument().getString(Konstante.KLJUC_SLIKA_POSILJATELJA);
                        chatMessage.conversionName = documentChange.getDocument().getString(Konstante.KLJUC_IME_POSILJATELJA);
                        chatMessage.conversionId = documentChange.getDocument().getString(Konstante.KLJUC_POSILJATELJ_ID);
                    }

                    chatMessage.message = documentChange.getDocument().getString(Konstante.KLJUC_ZADNJO_SPOROCILO);
                    chatMessage.dateObject = documentChange.getDocument().getDate(Konstante.KLJUC_CAS);
                    conversations.add(chatMessage);

                }

                else if(documentChange.getType() == DocumentChange.Type.MODIFIED)
                {
                    for(int i=0;i<conversations.size();i++)
                    {
                        String senderId = documentChange.getDocument().getString(Konstante.KLJUC_POSILJATELJ_ID);
                        String receiverId = documentChange.getDocument().getString(Konstante.KLJUC_PREJEMNIK_ID);

                        if(conversations.get(i).senderId.equals(senderId) && conversations.get(i).receiverId.equals(receiverId))
                        {
                            conversations.get(i).message = documentChange.getDocument().getString(Konstante.KLJUC_ZADNJO_SPOROCILO);
                            conversations.get(i).dateObject = documentChange.getDocument().getDate(Konstante.KLJUC_CAS);
                            break;
                        }
                    }
                }

            }

            Collections.sort(conversations,(obj1,obj2) -> obj2.dateObject.compareTo(obj1.dateObject));
            conversationsAdapter.notifyDataSetChanged();

            RecyclerView recyclerView = (RecyclerView)getView().findViewById(R.id.conversationsRecyclerView);   //Fix za fragmente
            ProgressBar progressBar = (ProgressBar)getView().findViewById(R.id.progressBar);

            recyclerView.smoothScrollToPosition(0);
            recyclerView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);

        }
    });

    private void getToken()
    {

        FirebaseMessaging.getInstance().getToken().addOnSuccessListener(this::updateToken);
      /*
        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            @Override
            public void onComplete(@NonNull Task<InstanceIdResult> task) {

                Log.e("newToken",FirebaseInstanceId.getInstance().getToken());
                updateToken(FirebaseInstanceId.getInstance().getToken());

            }
*/
/*
        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                String newToken = instanceIdResult.getToken();
                updateToken(newToken);
                Log.e("newToken",newToken);
            }
        });
*/
      //  });

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

    @Override
    public void onConversionClicked(User user) {
        Intent intent = new Intent(getActivity().getApplicationContext(), ChatActivity.class);
        intent.putExtra(Konstante.KLJUC_USER,user);
        startActivity(intent);
    }
}