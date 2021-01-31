package com.example.android.breadquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int numCorrect = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method checks the answer to the quiz once the button is clicked.
     */
    public void checkAnswer(View view){
        // Check answer for Question 1
        RadioButton correct1 = (RadioButton) findViewById(R.id.radio_correct_ingredients);
        boolean right1 = correct1.isChecked();

        if (right1 == true) {
            numCorrect += 1;
        }

        // Check answer for Question 2
        RadioButton correct2 = (RadioButton) findViewById(R.id.radio_correct_flour);
        boolean right2 = correct2.isChecked();

        if (right2 == true) {
            numCorrect += 1;
        }

        // Check answer for Question 3
        CheckBox checkboxSoft = (CheckBox) findViewById(R.id.checkbox_soft);
        CheckBox checkboxMoist = (CheckBox) findViewById(R.id.checkbox_moist);
        CheckBox checkboxFlaky = (CheckBox) findViewById(R.id.checkbox_flaky);

        boolean softChecked = checkboxSoft.isChecked();
        boolean moistChecked = checkboxMoist.isChecked();
        boolean flakyChecked = checkboxFlaky.isChecked();

        if (softChecked == true && moistChecked == true && flakyChecked == false){
            numCorrect += 1;
        }

        // Check answer for Question 4
        EditText input = (EditText) findViewById(R.id.answer_four);
        String answer = input.getText().toString();

        if (answer.toLowerCase().equals("gluten")) {
            numCorrect += 1;
        }

        // Check answer for Question 5
        CheckBox checkboxKosher = (CheckBox) findViewById(R.id.checkbox_kosher);
        CheckBox checkboxFat = (CheckBox) findViewById(R.id.checkbox_fat);
        CheckBox checkboxLift = (CheckBox) findViewById(R.id.checkbox_lift);

        boolean kosherChecked = checkboxKosher.isChecked();
        boolean fatChecked = checkboxFat.isChecked();
        boolean liftChecked = checkboxLift.isChecked();

        if (fatChecked == true && liftChecked == true && kosherChecked == false) {
            numCorrect += 1;
        }

        if (numCorrect == 5) {
            Toast.makeText(this, "Congratulations! You've gotten all the answers correct!", Toast.LENGTH_LONG).show();
            return;
        } else {
            Toast.makeText(this, "You answered " + numCorrect + " questions correctly, " + (5 - numCorrect) + " questions incorrectly.", Toast.LENGTH_LONG).show();
        }

        numCorrect = 0;
    }
}