package com.ssafy.startcampchat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ChatLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_login);

        findViewById(R.id.enter_btn).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ChatActivity.class);

                EditText nameEt = findViewById(R.id.name_et);
                intent.putExtra("name", nameEt.getText().toString());

                startActivity(intent);
                finish();
            }
        });
    }
}