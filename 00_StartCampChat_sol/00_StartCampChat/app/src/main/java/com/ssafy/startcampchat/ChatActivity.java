package com.ssafy.startcampchat;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private ChatRecyclerViewAdapter adapter;
    private List<ChatItem> chatItems;
    private DatabaseReference rtDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        String name = getIntent().getStringExtra("name");

        chatItems = new ArrayList<>();

        adapter = new ChatRecyclerViewAdapter(chatItems, name);
        RecyclerView rcView = findViewById(R.id.chat_recycler);
        rcView.setAdapter(adapter);
        rcView.setLayoutManager(new LinearLayoutManager(rcView.getContext(), RecyclerView.VERTICAL, false));

        initFirebaseDatabase();

        findViewById(R.id.send_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText messageEt = findViewById(R.id.message_et);
                String message = messageEt.getText().toString();
                rtDB.push().setValue(new ChatItem("", name, message, System.currentTimeMillis()));
                messageEt.getText().clear();
            }
        });
    }

    private void initFirebaseDatabase() {
        rtDB = FirebaseDatabase.getInstance().getReference("chat-message");

        ChildEventListener eventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                ChatItem item = snapshot.getValue(ChatItem.class);
                if (item != null) {
                    item.setFirebaseKey(snapshot.getKey() != null ? snapshot.getKey() : "");
                    chatItems.add(item);

                    adapter.notifyDataSetChanged();
                    ((RecyclerView) findViewById(R.id.chat_recycler)).smoothScrollToPosition(chatItems.size());
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };

        rtDB.addChildEventListener(eventListener);
    }
}