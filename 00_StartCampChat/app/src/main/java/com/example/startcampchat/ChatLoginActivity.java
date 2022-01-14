package com.example.startcampchat;

import static android.view.View.OnClickListener;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ChatLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_login);

        findViewById(R.id.enter_btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ChatActivity.class); //안드로이드 시스템한테 나 chatActivity 객체가 필요해~ 하고 요청하는것.
                //new chatactivity 만들어서 intent에 return

                startActivity(intent);
                finish();

            }
        });

    }
}