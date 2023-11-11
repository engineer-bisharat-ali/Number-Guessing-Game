package com.example.numberguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lostpage extends AppCompatActivity  {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lostpage);

        int randomNumber = getIntent().getIntExtra("MY_kEY", 0);
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText("Lost ! Determined Number is "+randomNumber);

        Button lost_play_again = findViewById(R.id.lost_play_agin);
        lost_play_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lostpage.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}