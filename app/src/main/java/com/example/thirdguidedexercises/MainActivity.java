package com.example.thirdguidedexercises;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText num1, num2;
    Button sum, ave;
    Toast toast;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.etNum1GE3);
        num2 = findViewById(R.id.etNum2GE3);
        sum = findViewById(R.id.btnSumGE3);
        ave = findViewById(R.id.btnAveGE3);

        setupListeners();
    }

    private void setupListeners() {
        sum.setOnClickListener(v -> compute("sum"));
        ave.setOnClickListener(v -> compute("average"));
    }

    private void compute(String type) {
        String strNum1 = num1.getText().toString().trim();
        String strNum2 = num2.getText().toString().trim();

        if (strNum1.isEmpty()){
            num1.setError("Please enter a number");
            return;
        }
        if (strNum2.isEmpty()){
            num2.setError("Please enter a number");
            return;
        }

        double firstNum, secondNum;
        try {
            firstNum = Double.parseDouble(strNum1);
            secondNum = Double.parseDouble(strNum2);
        } catch (NumberFormatException e) {
            displayErrorMessage("Invalid number format");
            return;
        }

        double result;
        if (type.equals("sum")) {
            result = firstNum + secondNum;
            showToast("SUM: " + result);
        } else if (type.equals("average")) {
            result = (firstNum + secondNum) / 2;
            showToast("AVERAGE: " + result);
        }
    }

    private void displayErrorMessage(String message) {
        toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        view = toast.getView();
        if (view != null) {
            view.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        }
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
