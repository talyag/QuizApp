package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the score as a toast
     */

    public void displayScore(View view) {
        int score = calculateScore();
        String scoreMessage = "Your score is " + score + " out of 5";
        Toast.makeText(this, scoreMessage,
                Toast.LENGTH_SHORT).show();

    }

    /**
     * Calculates total questions answered correctly
     * @return score
     */

    private int calculateScore() {
        int score = 0;
        boolean ansQ1 = checkQ1();
        boolean ansQ2 = checkQ2();
        boolean ansQ3 = checkQ3();
        boolean ansQ4 = checkQ4();
        boolean ansQ5 = checkQ5();

        if (ansQ1) {
            score += 1;
        }

        if (ansQ2) {
            score += 1;
        }

        if (ansQ3) {
            score += 1;
        }

        if (ansQ4) {
            score += 1;
        }

        if (ansQ5) {
            score += 1;
        }

        return score;

    }

    /**
     * Checks state of question 1 radio group
     *
     * @return ansQ1
     */
    private boolean checkQ1() {
        RadioButton radio = (RadioButton) findViewById(R.id.radio_ans1_3);
        boolean ansQ1 = radio.isChecked();
        return ansQ1;

    }

    /**
     * Checks state of question 2 checkBox group
     *
     * @return ansQ2
     */

    private boolean checkQ2() {
        boolean ansQ2 = false;

        CheckBox checkOne = (CheckBox) findViewById(R.id.check_ans2_1);
        boolean ans2_1 = checkOne.isChecked();

        CheckBox checkTwo = (CheckBox) findViewById(R.id.check_ans2_2);
        boolean ans2_2 = checkTwo.isChecked();

        CheckBox checkThree = (CheckBox) findViewById(R.id.check_ans2_3);
        boolean ans2_3 = checkThree.isChecked();

        CheckBox checkFour = (CheckBox) findViewById(R.id.check_ans2_4);
        boolean ans2_4 = checkFour.isChecked();

        if (ans2_1 == true && ans2_2 == false && ans2_3 == true && ans2_4 == false) {
            ansQ2 = true;

        }

        return ansQ2;

    }

    /**
     * Checks answer to question 3
     *
     * @return ansQ3
     */

    private boolean checkQ3() {
        boolean ansQ3 = false;

        EditText ansThreeText = (EditText) findViewById(R.id.number_ans3);
        String ansThreeStr = ansThreeText.getText().toString();
        int ans3 = Integer.parseInt(ansThreeStr);

        if (ans3 == 322) {
            ansQ3 = true;

        }

        return ansQ3;

    }

    /**
     * Checks answer to question 4
     *
     * @return ansQ4
     */

    private boolean checkQ4() {
        boolean ansQ4;

        EditText ansFourText = (EditText) findViewById(R.id.text_ans4);
        String ans4 = ansFourText.getText().toString();

        //convert answer to lower case in case player input is not capitalized
        ans4 = ans4.toLowerCase();

        //checks for two versions of string in case player input does not use punctuation
        if (ans4.equals("mother's day")) {
            ansQ4 = true;

        } else if (ans4.equals("mothers day")) {
            ansQ4 = true;

        } else {
            ansQ4 = false;
        }

        return ansQ4;

    }

    /**
     * Checks state of question 4 radio group
     *
     * @return ansQ4
     */

    private boolean checkQ5() {
        RadioButton radio = (RadioButton) findViewById(R.id.radio_ans5_1);
        boolean ansQ5 = radio.isChecked();
        return ansQ5;

    }


}
