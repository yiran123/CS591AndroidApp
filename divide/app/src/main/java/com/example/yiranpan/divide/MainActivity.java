package com.example.yiranpan.divide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;




public class MainActivity extends AppCompatActivity {




    private EditText answer;
    private Button btnSubmit;
    private TextView number1;
    private TextView number2;
    private TextView score;
    private TextView yourAnswer;
    private int value1;
    private int value2;
    private int count;
    private String divide;
    private int counter = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        count = 0;
        yourAnswer = (TextView) findViewById(R.id.yourAnswer);
        answer = (EditText) findViewById(R.id.answer);
        score = (TextView) findViewById(R.id.score);
        number1 = (TextView) findViewById(R.id.number1);
        number2 = (TextView) findViewById(R.id.number2);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);


        //set up two random numbers with no remainder
        final Random rand1 = new Random();
        final Random rand2 = new Random();

        value1 = rand1.nextInt(100);
        value2 = rand2.nextInt(100) + 1;


        while (value1 % value2 != 0) {
            value1 = rand1.nextInt(100);
            value2 = rand2.nextInt(100) + 1;

        }
        number1.setText(String.valueOf(value1));
        number2.setText(String.valueOf(value2));


        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                //counter to get 10 questions
                counter += 1;

                //get the input
                String result = answer.getText().toString();

                divide = String.valueOf(value1 / value2);

                //count is the score
                if (result.equals(divide)) {
                    count++;
                }

                //Continue to generate random numbers
                value1 = rand1.nextInt(100);
                value2 = rand2.nextInt(100) + 1;


                while (value1 % value2 != 0) {
                    value1 = rand1.nextInt(100);
                    value2 = rand2.nextInt(100) + 1;

                }
                number1.setText(String.valueOf(value1));
                number2.setText(String.valueOf(value2));

                //10 questions
                if (counter == 10) {
                    score.setText(String.valueOf(count));
                }

            }

        });
    }

    public String intToStr(Integer i)
    {
        return i.toString();
    }

    public int strToInt(String S)
    {
        return Integer.parseInt(S);
    }


}


