package com.example.textingapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import com.example.textingapp.adapters.ChatAdapter;
import com.example.textingapp.models.ChatMessage;
import com.example.textingapp.models.User;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.view.View;

import com.example.textingapp.R;
import com.example.textingapp.databinding.ActivityChatBinding;
import com.example.textingapp.pripomocki.Konstante;
import com.example.textingapp.pripomocki.Preference;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class ChatActivity extends BaseActivity {

    private ActivityChatBinding binding;
    private User receiverUser;
    private List<ChatMessage> chatMessages;
    private ChatAdapter chatAdapter;
    private Preference preference;
    private FirebaseFirestore database;
    private String conversionId = null;

    private Boolean isReceiverAvailable = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();
        loadReceiverDetails();

        init();
        listenMessages();
    }

    private void init()
    {
        preference = new Preference(getApplicationContext());
        chatMessages = new ArrayList<>();
        chatAdapter = new ChatAdapter(
                chatMessages,
                getBitmapFromEncodedString(receiverUser.image),
                preference.getString(Konstante.KLJUC_ID_UPORABNIKA)
        );

        binding.chatRecyclerView.setAdapter(chatAdapter);
        database = FirebaseFirestore.getInstance();

    }

    private void sendMessage()
    {
        HashMap<String, Object> message = new HashMap<>();
        message.put(Konstante.KLJUC_POSILJATELJ_ID, preference.getString(Konstante.KLJUC_ID_UPORABNIKA));
        message.put(Konstante.KLJUC_PREJEMNIK_ID, receiverUser.id);
        message.put(Konstante.KLJUC_SPOROCILO, binding.inputMessage.getText().toString());
        message.put(Konstante.KLJUC_CAS, new Date());   //pazi na DATE

        database.collection(Konstante.KLJUC_KOLEKCIJA_CHAT).add(message);
        if(conversionId!=null)
        {
            updateConversion(binding.inputMessage.getText().toString());
        }
        else
        {
            HashMap<String,Object> conversion = new HashMap<>();
            conversion.put(Konstante.KLJUC_POSILJATELJ_ID,preference.getString(Konstante.KLJUC_ID_UPORABNIKA));
            conversion.put(Konstante.KLJUC_IME_POSILJATELJA,preference.getString(Konstante.KLJUC_IME));
            conversion.put(Konstante.KLJUC_SLIKA_POSILJATELJA,preference.getString(Konstante.KLJUC_SLIKA)); //??
            conversion.put(Konstante.KLJUC_PREJEMNIK_ID, receiverUser.id);
            conversion.put(Konstante.KLJUC_IME_PREJEMNIKA,receiverUser.name);
            conversion.put(Konstante.KLJUC_SLIKA_PREJEMNIKA,receiverUser.image);
            conversion.put(Konstante.KLJUC_ZADNJO_SPOROCILO,binding.inputMessage.getText().toString());
            conversion.put(Konstante.KLJUC_CAS,new Date());
            addConversion(conversion);

        }
        binding.inputMessage.setText(null);
    }

    private void listenAvailabilityOfReceiver()
    {
        database.collection(Konstante.KLJUC_UPORABNIKI).document(
                receiverUser.id
        ).addSnapshotListener(ChatActivity.this,(value,error) -> {
            if(error!=null)
            {
                return;
            }
            if(value!=null)
            {
                if(value.getLong(Konstante.KLJUC_DOSEGLJIVOST)!=null)
                {
                    int availability = Objects.requireNonNull(
                            value.getLong(Konstante.KLJUC_DOSEGLJIVOST)
                    ).intValue();
                    isReceiverAvailable = availability == 1;
                }
            }
            if(isReceiverAvailable)
            {
                binding.textAvailability.setVisibility(View.VISIBLE);
            }

            else
            {
                binding.textAvailability.setVisibility(View.GONE);
            }
        });
    }


    private void listenMessages()
    {
        database.collection(Konstante.KLJUC_KOLEKCIJA_CHAT)
                .whereEqualTo(Konstante.KLJUC_POSILJATELJ_ID,preference.getString(Konstante.KLJUC_ID_UPORABNIKA))
                .whereEqualTo(Konstante.KLJUC_PREJEMNIK_ID,receiverUser.id)
                .addSnapshotListener(eventListener);
        database.collection(Konstante.KLJUC_KOLEKCIJA_CHAT)
                .whereEqualTo(Konstante.KLJUC_POSILJATELJ_ID,receiverUser.id)
                .whereEqualTo(Konstante.KLJUC_PREJEMNIK_ID,preference.getString(Konstante.KLJUC_ID_UPORABNIKA))
                .addSnapshotListener(eventListener);
    }

    private final EventListener<QuerySnapshot> eventListener = (value, error) ->
    {
        if(error!=null)
        {
            return;
        }

        if(value!=null)
        {
            int count = chatMessages.size();
            for (DocumentChange documentChange : value.getDocumentChanges())
            {
                if(documentChange.getType() == DocumentChange.Type.ADDED)
                {
                    ChatMessage chatMessage = new ChatMessage();
                    chatMessage.senderId = documentChange.getDocument().getString(Konstante.KLJUC_POSILJATELJ_ID);
                    chatMessage.receiverId = documentChange.getDocument().getString(Konstante.KLJUC_PREJEMNIK_ID);
                    chatMessage.message = documentChange.getDocument().getString(Konstante.KLJUC_SPOROCILO);
                    chatMessage.dateTime = getReadableDataTime(documentChange.getDocument().getDate(Konstante.KLJUC_CAS));
                    chatMessage.dateObject = documentChange.getDocument().getDate(Konstante.KLJUC_CAS);

                    chatMessages.add(chatMessage);
                }
            }

            Collections.sort(chatMessages,(obj1, obj2) -> obj1.dateObject.compareTo(obj2.dateObject));
            if(count==0)
            {
                chatAdapter.notifyDataSetChanged();
            }

            else
            {
                chatAdapter.notifyItemRangeChanged(chatMessages.size(),chatMessages.size());
                binding.chatRecyclerView.smoothScrollToPosition(chatMessages.size()-1);
            }

            binding.chatRecyclerView.setVisibility(View.VISIBLE);

        }

        binding.progressBar.setVisibility(View.GONE);

        if(conversionId==null)
        {
            checkForConversion();
        }

    };


    private Bitmap getBitmapFromEncodedString(String encodedImage)
    {
        byte[] bytes = Base64.decode(encodedImage, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes,0,bytes.length);
    }

    private void loadReceiverDetails()
    {
        receiverUser=(User) getIntent().getSerializableExtra(Konstante.KLJUC_USER);
        binding.textName.setText(receiverUser.name);
    }

    private void setListeners()
    {
        binding.imageBack.setOnClickListener(v -> onBackPressed());
        binding.Send.setOnClickListener(v -> sendMessage());    //Poslji sporocilo
    }

    private String getReadableDataTime(Date date)
    {
        return new SimpleDateFormat("MMMM dd, yyyy - hh:mm a", Locale.getDefault()).format(date);
    }

    private void addConversion(HashMap<String,Object> conversion)
    {
        database.collection(Konstante.KLJUC_KOLEKCIJA_POGOVOROV)
                .add(conversion)
                .addOnSuccessListener(documentReference -> conversionId = documentReference.getId());
    }

    private void updateConversion(String message)
    {
        DocumentReference documentReference =
                database.collection(Konstante.KLJUC_KOLEKCIJA_POGOVOROV).document(conversionId);
        documentReference.update(
                Konstante.KLJUC_ZADNJO_SPOROCILO,message,
                Konstante.KLJUC_CAS, new Date()
        );
    }

    private void checkForConversion()
    {
        if(chatMessages.size()!=0)
        {
            checkForConversionRemotely(
                    preference.getString(Konstante.KLJUC_ID_UPORABNIKA),
                    receiverUser.id
            );
            checkForConversionRemotely(
                    receiverUser.id,
                    preference.getString(Konstante.KLJUC_ID_UPORABNIKA) //Sketchy
            );
        }
    }

    private void checkForConversionRemotely(String senderId, String receiverId)
    {
        database.collection(Konstante.KLJUC_KOLEKCIJA_POGOVOROV)
                .whereEqualTo(Konstante.KLJUC_POSILJATELJ_ID,receiverId)
                .get()
                .addOnCompleteListener(conversionOnCompleteListener);
    }


    private final OnCompleteListener<QuerySnapshot> conversionOnCompleteListener = task -> {
        if(task.isSuccessful() && task.getResult() != null && task.getResult().getDocuments().size() > 0)
        {
            DocumentSnapshot documentSnapshot = task.getResult().getDocuments().get(0);
            conversionId = documentSnapshot.getId();
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        listenAvailabilityOfReceiver();
    }
}