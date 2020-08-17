package com.app.finalpracticalcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView display;
    private Button one, two, three, four, five, six, seven, eight, nine, zero, doubleZero, decimal,divide, multiply, add, subtract, equal, clear, clearALl;

    private String num1 = "0";
    private String num2 = "0";
    private boolean operationSelected = false;
    private String operation = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        one = findViewById(R.id.one_button);
        one.setOnClickListener(this);

        two = findViewById(R.id.two_button);
        two.setOnClickListener(this);

        three = findViewById(R.id.three_button);
        three.setOnClickListener(this);

        four = findViewById(R.id.four_button);
        four.setOnClickListener(this);

        five = findViewById(R.id.five_button);
        five.setOnClickListener(this);

        six = findViewById(R.id.six_button);
        six.setOnClickListener(this);

        seven = findViewById(R.id.seven_button);
        seven.setOnClickListener(this);

        eight = findViewById(R.id.eight_button);
        eight.setOnClickListener(this);

        nine = findViewById(R.id.nine_button);
        nine.setOnClickListener(this);

        zero = findViewById(R.id.zero_button);
        zero.setOnClickListener(this);

        doubleZero = findViewById(R.id.double_zero_button);
        doubleZero.setOnClickListener(this);

        decimal = findViewById(R.id.decimal_button);
        decimal.setOnClickListener(this);

        clearALl = findViewById(R.id.clear_all_button);
        clearALl.setOnClickListener(this);

        clear = findViewById(R.id.clear_button);
        clear.setOnClickListener(this);

        divide = findViewById(R.id.divide_button);
        divide.setOnClickListener(this);

        multiply = findViewById(R.id.multiply_button);
        multiply.setOnClickListener(this);

        add = findViewById(R.id.add_button);
        add.setOnClickListener(this);

        subtract = findViewById(R.id.subtract_button);
        subtract.setOnClickListener(this);

        equal = findViewById(R.id.equal_button);
        equal.setOnClickListener(this);
    }

    public void changeDisplay(String character, boolean operationSelected){
        if (!operationSelected){
            if (num1.length() <= 9){
                if (num1 == "0" || num1 == "00"){
                    if(character == "."){
                        num1 = num1 + character;
                    }
                    else {
                        num1 = character;
                    }
                }
                else{
                    if(character == "." && num1.indexOf(".") != -1){
                        num1 = num1;
                    }
                    else{
                        num1 = num1 + character;
                    }

                }
                display.setText(NumberFormat.getInstance().format(Float.parseFloat(num1)));
            }
        }
        else{
            if (num2.length() <= 9){
                if (num2 == "0" || num2 == "00"){
                    if(character == "."){
                        num2 = num2 + character;
                    }
                    else {
                        num2 = character;
                    }
                }
                else{
                    if(character == "." && num2.indexOf(".") != -1){
                        num2 = num2;
                    }
                    else{
                        num2 = num2 + character;
                    }

                }
                display.setText(NumberFormat.getInstance().format(Float.parseFloat(num2)));
            }
        }
    }

    public void clearLastChar(boolean operationSelected){
        if(operationSelected){
            num2 = num2.substring(0, num2.length() -1);
            if (num2.length() == 0){
                num2 = "0";
            }
            display.setText(NumberFormat.getInstance().format(Float.parseFloat(num2)));
        }
        else{
            num1 = num1.substring(0, num1.length() -1);
            if (num1.length() == 0){
                num1 = "0";
            }
            display.setText(NumberFormat.getInstance().format(Float.parseFloat(num1)));
        }
    }

    public void calculate(){

            float response = 0;
            switch (operation){
                case "div":
                    response = Float.parseFloat(num1) / Float.parseFloat(num2);
                    break;
                case "mul":
                    response = Float.parseFloat(num1) * Float.parseFloat(num2);
                    break;
                case "add":
                    response = Float.parseFloat(num1) + Float.parseFloat(num2);
                    break;
                case "sub":
                    response = Float.parseFloat(num1) - Float.parseFloat(num2);
                    break;
                default:
                    response = 0;
            }
            display.setText(NumberFormat.getInstance().format(response));
            clearAll();

    }

    public void clearAll(){
        num1 = "0";
        num2 = "0";
        operationSelected = false;
        operation = "";
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.one_button:
                changeDisplay("1", operationSelected);
                break;
            case R.id.two_button:
                changeDisplay("2", operationSelected);
                break;

            case R.id.three_button:
                changeDisplay("3", operationSelected);
                break;

            case R.id.four_button:
                changeDisplay("4", operationSelected);
                break;

            case R.id.five_button:
                changeDisplay("5", operationSelected);
                break;

            case R.id.six_button:
                changeDisplay("6", operationSelected);
                break;

            case R.id.seven_button:
                changeDisplay("7", operationSelected);
                break;

            case R.id.eight_button:
                changeDisplay("8", operationSelected);
                break;

            case R.id.nine_button:
                changeDisplay("9", operationSelected);
                break;

            case R.id.zero_button:
                if (display.getText() != "0"){
                    changeDisplay("0", operationSelected);
                }
                break;

            case R.id.double_zero_button:
                if (display.getText() != "0"){
                    changeDisplay("00", operationSelected);
                }
                break;

            case R.id.decimal_button:
                changeDisplay(".", operationSelected);
                break;

            case R.id.clear_all_button:
                clearAll();
                display.setText(NumberFormat.getInstance().format(Float.parseFloat(num1)));
                break;

            case R.id.clear_button:
                clearLastChar(operationSelected);
                break;

            case R.id.divide_button:
                operation = "div";
                operationSelected = true;
                break;

            case R.id.multiply_button:
                operation = "mul";
                operationSelected = true;
                break;

            case R.id.add_button:
                operation = "add";
                operationSelected = true;
                break;

            case R.id.subtract_button:
                operation= "sub";
                operationSelected = true;
                break;

            case R.id.equal_button:
                calculate();
            default:
                break;
        }
    }
}