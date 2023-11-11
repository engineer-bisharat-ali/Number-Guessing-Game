package com.example.numberguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class WiningPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wining_page);




        int randomNumber = getIntent().getIntExtra("MY_kEY2", 0);
        TextView textView3 = findViewById(R.id.textView3);
        textView3.setText(""+randomNumber);

        Button playagain = findViewById(R.id.play_again_button);
        playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WiningPage.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}