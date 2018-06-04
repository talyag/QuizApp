package com.example.android.quizapp;

/*
 *Fonts used for the project:
 *Poiret One (https://fonts.google.com/specimen/Poiret+One)
 *Playfair Display (https://fonts.google.com/specimen/Playfair+Display)
 *
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        String scoreMessage = getString(R.string.final_score, score);
        Toast.makeText(this, scoreMessage,
                Toast.LENGTH_SHORT).show();

    }

    /**
     * Calculates total questions answered correctly
     *
     * @return score
     */

    private int calculateScore() {
        int score = 0;

        //stores answers from all checkQ methods
        boolean[] answers = new boolean[5];
        answers[0] = checkQ1();
        answers[1] = checkQ2();
        answers[2] = checkQ3();
        answers[3] = checkQ4();
        answers[4] = checkQ5();

        //loops through answers and adds to score for each correct answer
        for (int i = 0; i < answers.length; i++)
            if (answers[i]) {
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
        //cast correct answer in a temp variable
        RadioButton radio = (RadioButton) findViewById(R.id.radio_ans1_3);

        //store the state of this answer in a variable
        boolean ansQ1 = radio.isChecked();

        return ansQ1;

    }

    /**
     * Checks state of question 2 checkBox group
     *
     * @return ansQ2
     */

    private boolean checkQ2() {
        boolean ansQ2;

        //Check state of all checkboxes
        CheckBox checkOne = (CheckBox) findViewById(R.id.check_ans2_1);
        boolean ans2_1 = checkOne.isChecked();

        CheckBox checkTwo = (CheckBox) findViewById(R.id.check_ans2_2);
        boolean ans2_2 = checkTwo.isChecked();

        CheckBox checkThree = (CheckBox) findViewById(R.id.check_ans2_3);
        boolean ans2_3 = checkThree.isChecked();

        CheckBox checkFour = (CheckBox) findViewById(R.id.check_ans2_4);
        boolean ans2_4 = checkFour.isChecked();

        //When state of all four checkboxes is as follows, consider answer correct
        if (ans2_1 == true && ans2_2 == false && ans2_3 == true && ans2_4 == false) {
            ansQ2 = true;

            //If not, consider answer incorrect
        } else {
            ansQ2 = false;
        }

        return ansQ2;

    }

    /**
     * Checks answer to question 3
     *
     * @return ansQ3
     */

    private boolean checkQ3() {
        boolean ansQ3;

        //cast editable answer in a temp variable
        EditText ansThreeText = (EditText) findViewById(R.id.number_ans3);

        //convert editable to string
        String ans3 = ansThreeText.getText().toString();

        //check if string equals correct answer
        if (ans3.equals("322")) {
            ansQ3 = true;

        } else {
            ansQ3 = false;
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
        if (ans4.equals(getString(R.string.mothers_day_apostrophe))) {
            ansQ4 = true;

        } else if (ans4.equals(getString(R.string.mothers_day))) {
            ansQ4 = true;

        } else {
            ansQ4 = false;
        }

        return ansQ4;

    }

    /**
     * Checks state of question 5 radio group
     *
     * @return ansQ5
     */

    private boolean checkQ5() {
        //cast correct answer in a temp variable
        RadioButton radio = (RadioButton) findViewById(R.id.radio_ans5_1);

        //store the state of this answer in a variable
        boolean ansQ5 = radio.isChecked();

        return ansQ5;

    }


}
