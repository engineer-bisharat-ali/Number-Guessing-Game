package com.example.numberguessinggame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String MSG ="com.example.numberguessinggame Number Guessing Game.Lostpage";

    int currentNumber = 10;
    public int randomNumber ;
    TextView remaining;

    double editText_input_number;
    EditText editText;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.submit_of_number);
        TextView remaining = findViewById(R.id.remaining_number);
        EditText editText = findViewById(R.id.input_guess_number);
        TextView textView = findViewById(R.id.low_high);



        // Submit button action
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,Lostpage.class);
                Intent intent2 =new Intent(MainActivity.this,WiningPage.class);
                intent.putExtra("MY_kEY",randomNumber);
                intent2.putExtra("MY_kEY2",randomNumber);
//                Intent intent2 =new Intent(MainActivity.this,WiningPage.class);
//                intent2.putExtra("MY_kEY",randomNumber);

                if (currentNumber > 0)
                    currentNumber--;
                remaining.setText(String.valueOf(currentNumber));

                if (currentNumber==0){

                    startActivity(intent);

                }

               double editText_input_number = Double.parseDouble(editText.getText().toString());
                editText.setText("");

               if (editText_input_number==randomNumber) {
//                   Intent i=new Intent(MainActivity.this,WiningPage.class);
                   startActivity(intent2);
               }
               else if(editText_input_number < randomNumber){
                   textView.setText("Your Guess is Too Low ! Try Again");
               }

               else if(editText_input_number > randomNumber){
                   textView.setText("Your Guess is Too High ! Try Again");

               }

            }
        });


        generateRandomNumber();

    }



    private int generateRandomNumber() {
        final int min = 1;
        final int max = 100;
        Random random = new Random();
        randomNumber = random.nextInt(101) + 1;
        return randomNumber ;
    }

//    private int guessNumber(){
//        if (currentNumber2 > 10)
//          currentNumber2--;
//        remaining.setText(String.valueOf(currentNumber2));
//
//        return currentNumber2;
//    }



//    private void showPlayAgainDialog() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Congratulations You Win ! ");
//        builder.setMessage("The Number is "+randomNumber);
//        builder.setPositiveButton("Play Again ", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                // restart the game here
//
//                generateRandomNumber();
//                remaining.setText("salman");
//
//            }
//        }).setNegativeButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                // dismiss the dialog
//                dialog.dismiss();
//            }
//        });
//        AlertDialog dialog = builder.create();
//        dialog.show();
//    }

    public void onBackPressed() {
// display exit message
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Exit");
        builder.setMessage("Are you sure you want to exit the app?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish(); // close the app
            }
        });
        builder.setNegativeButton("No", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }



}