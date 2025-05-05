package com.example.exponentcalcquestion3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textViewAnswer, textViewEquation;
    MaterialButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    MaterialButton button_clear;
    int B;
    int E;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link the TextViews to the layout UI components
        textViewAnswer = findViewById(R.id.textViewAnswer);
        textViewEquation = findViewById(R.id.textViewEquation);

       // Assign button IDs and set click listeners for number buttons and the clear button
        assignId(button0, R.id.button_0);
        assignId(button1, R.id.button_1);
        assignId(button2, R.id.button_2);
        assignId(button3, R.id.button_3);
        assignId(button4, R.id.button_4);
        assignId(button5, R.id.button_5);
        assignId(button6, R.id.button_6);
        assignId(button7, R.id.button_7);
        assignId(button8, R.id.button_8);
        assignId(button9, R.id.button_9);
        assignId(button_clear, R.id.button_clear);


    }

    // Exponent button
    public void power(View view){
        String baseInput = textViewEquation.getText().toString().trim();

        // If input is empty, show warning
        if (baseInput.isEmpty()) {
            Toast.makeText(this, "Please enter a base number first", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            B = Integer.valueOf(baseInput);
            textViewAnswer.setText(baseInput);
            textViewEquation.setText("");
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid input for base", Toast.LENGTH_SHORT).show();
        }
    }

    // Calculate button
    public void calculate(View view){
        String exponentInput = textViewEquation.getText().toString().trim();

        // Check if exponent input is empty
        if (exponentInput.isEmpty()) {
            Toast.makeText(this, "Please enter an exponent", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            E = Integer.valueOf(exponentInput);
            int result = (int)Math.pow(B, E);
            textViewAnswer.setText(B + "^" + E + " = " + result);
            textViewEquation.setText("");
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid input for exponent", Toast.LENGTH_SHORT).show();
        }



}


    void assignId(MaterialButton btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        textViewEquation.setText(buttonText);

        if (buttonText.equals("CLEAR")) {
            textViewEquation.setText("");
            textViewAnswer.setText("");

        }



    }
}
