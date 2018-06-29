package com.example.zhakonze.quizapp;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    // Question 1
    RadioButton ques1_1;
    // Question 2
    EditText ques2_answer;
    // Question 3
    RadioButton ques3_2;
    // Question 4
    CheckBox ques4_1;
    CheckBox ques4_2;
    CheckBox ques4_3;
    CheckBox ques4_4;
    // Question 5
    RadioButton ques5_1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the keyboard
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_main);
    }


    public void submitAnswers(View view) {
        CharSequence resultsDisplay;
        Log.e(LOG_TAG, " " + this.findViewById(R.id.ques3_3));
        int answer1_score;
        int answer2_score;
        int answer3_score;
        int answer4_score;
        int answer5_score;
        int final_score;

        /*------------------------------------------------------------------------------------------
         Question 1 - Correct Answer is #1 "Africa"
          ----------------------------------------------------------------------------------------*/
        Boolean answer1;

        ques1_1 = (RadioButton) this.findViewById(R.id.ques1_1);
        answer1 = ques1_1.isChecked();
        if (answer1) {
            answer1_score = 1;
        } else {
            answer1_score = 0;
        }

        /*------------------------------------------------------------------------------------------
         Question 2 - Correct Answer is "Britain"
        ------------------------------------------------------------------------------------------*/
        String answer2;
        ques2_answer = (EditText) this.findViewById(R.id.ques2_answer);
        answer2 = ques2_answer.getText().toString().toUpperCase();
        if (answer2.equals("Britain") || answer2.equals("BRITAIN")) {
            answer2_score = 1;
        } else {
            answer2_score = 0;
        }

        /*------------------------------------------------------------------------------------------
         Question 3 - Correct Answer is #2 "1964"
        ------------------------------------------------------------------------------------------*/
        Boolean answer3;

        ques3_2 = (RadioButton) this.findViewById(R.id.ques3_2);
        answer3 = ques3_2.isChecked();
        if (answer3) {
            answer3_score = 1;
        } else {
            answer3_score = 0;
        }

        /*------------------------------------------------------------------------------------------
         Question 4 - Correct Answer is #2 & #3 "4 , An Eagle"
        ------------------------------------------------------------------------------------------*/
        Boolean answer4_choice1;
        Boolean answer4_choice2;
        Boolean answer4_choice3;
        Boolean answer4_choice4;

        ques4_1 = (CheckBox) this.findViewById(R.id.ques4_1);
        ques4_2 = (CheckBox) this.findViewById(R.id.ques4_2);
        ques4_3 = (CheckBox) this.findViewById(R.id.ques4_3);
        ques4_4 = (CheckBox) this.findViewById(R.id.ques4_4);

        answer4_choice1 = ques4_1.isChecked();
        answer4_choice2 = ques4_2.isChecked();
        answer4_choice3 = ques4_3.isChecked();
        answer4_choice4 = ques4_4.isChecked();
        if (!answer4_choice1 && answer4_choice2 && answer4_choice3 && !answer4_choice4) {
            answer4_score = 1;
        } else {
            answer4_score = 0;
        }

        /*------------------------------------------------------------------------------------------
         Question 5 - Correct Answer is #1 "Dr Kenneth Kaunda"
        ------------------------------------------------------------------------------------------*/
        Boolean answer5;

        ques5_1 = (RadioButton) this.findViewById(R.id.ques5_1);
        answer5 = ques5_1.isChecked();
        if (answer5) {
            answer5_score = 1;
        } else {
            answer5_score = 0;
        }

        /*------------------------------------------------------------------------------------------
         Final Score
        ------------------------------------------------------------------------------------------*/
        final_score = answer1_score + answer2_score + answer3_score + answer4_score + answer5_score;

        if (final_score == 5) {
            resultsDisplay = "Great Work! You scored 5 out of 5";
        } else {
            resultsDisplay = "Would you like to Try again? You scored " + final_score + " out of 5";
        }

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, resultsDisplay, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}