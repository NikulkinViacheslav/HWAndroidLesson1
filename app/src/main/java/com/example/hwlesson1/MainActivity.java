package com.example.hwlesson1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView twCalc, twRes;
    private Button btnAC, btnDel, btnEquals, btnDot, btnDiv, btnMult, btnSub, btnAdd;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private String current, result;
    private boolean isDot, isOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        current = "";
        result = "";
        isDot = false;
        isOperator = false;

        twCalc = findViewById(R.id.twCalc);
        twRes = findViewById(R.id.twRes);
        btnAC = findViewById(R.id.btnAC);
        btnDel = findViewById(R.id.btnDel);
        btnEquals = findViewById(R.id.btnEquals);
        btnDot = findViewById(R.id.btnDot);
        btnDiv = findViewById(R.id.btnDiv);
        btnMult = findViewById(R.id.btnMult);
        btnSub = findViewById(R.id.btnSub);
        btnAdd = findViewById(R.id.btnAdd);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnAC.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
    }

    public void displayExpression() {
        twCalc.setText(current);
    }

    public void displayResult() {
        twRes.setText(result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn0:
                current = current + "0";
                displayExpression();
                break;
            case R.id.btn1:
                current = current + "1";
                displayExpression();
                break;
            case R.id.btn2:
                current = current + "2";
                displayExpression();
                break;
            case R.id.btn3:
                current = current + "3";
                displayExpression();
                break;
            case R.id.btn4:
                current = current + "4";
                displayExpression();
                break;
            case R.id.btn5:
                current = current + "5";
                displayExpression();
                break;
            case R.id.btn6:
                current = current + "6";
                displayExpression();
                break;
            case R.id.btn7:
                current = current + "7";
                displayExpression();
                break;
            case R.id.btn8:
                current = current + "8";
                displayExpression();
                break;
            case R.id.btn9:
                current = current + "9";
                displayExpression();
                break;
            case R.id.btnDot:
                if (current.isEmpty()) {           // если строка пуста - пишем ноль с точкой
                    current = "0.";
                    isDot = true;
                }
                if (!isDot) {            // если точка не введена - пишем точку
                    current = current + ".";
                    isDot = true;
                }
                displayExpression();
                break;
            case R.id.btnAC:
                clear();
                displayExpression();
                displayResult();
                break;
            case R.id.btnDel:
                backSpace();
                displayExpression();
                break;
            case R.id.btnDiv:
                isDot = false;
                if (!current.isEmpty()) {          // если строка не пуста
                    if (current.substring(current.length()-1, current.length()).equals(".")) {   // если последний символ - точка
                        backSpace();            // удаляем последний символ
                    }
                    if (!isOperator) {           // если оператор еще не введен
                        current = current + " / ";            // добавляем оператор через пробелы
                        isOperator = true;       // true - ставим флаг, что оператор введен
                    }
                }
                displayExpression();
                break;
            case R.id.btnMult:
                isDot = false;
                if (!current.isEmpty()) {
                    if (current.substring(current.length()-1, current.length()).equals(".")) {
                        backSpace();
                    }
                    if (!isOperator) {
                        current = current + " * ";
                        isOperator = true;
                    }
                }
                displayExpression();
                break;
            case R.id.btnSub:
                isDot = false;
                if (!current.isEmpty()) {
                    if (current.substring(current.length()-1, current.length()).equals(".")) {
                        backSpace();
                    }
                    if (!isOperator) {
                        current = current + " - ";
                        isOperator = true;
                    }
                }
                displayExpression();
                break;
            case R.id.btnAdd:
                isDot = false;
                if (!current.isEmpty()) {
                    if (current.substring(current.length()-1, current.length()).equals(".")) {
                        backSpace();
                    }
                    if (!isOperator) {
                        current = current + " + ";
                        isOperator = true;
                    }
                }
                displayExpression();
                break;
            case R.id.btnEquals:
                // если последний символ не является оператором или пробелом
                if (isOperator && !current.substring(current.length()-1, current.length()).equals(" ")) {
                    String[] operands = current.split(" ");
                    switch (operands[1].charAt(0)) {
                        case '/':
                            result = Double.toString(Double.parseDouble(operands[0]) / Double.parseDouble(operands[2]));
                            break;
                        case '*':
                            result = Double.toString(Double.parseDouble(operands[0]) * Double.parseDouble(operands[2]));
                            break;
                        case '+':
                            result = Double.toString(Double.parseDouble(operands[0]) + Double.parseDouble(operands[2]));
                            break;
                        case '-':
                            result = Double.toString(Double.parseDouble(operands[0]) - Double.parseDouble(operands[2]));
                            break;
                    }
                    current = current + " = " + result;
                    displayExpression();
                    displayResult();
                }
                break;
        }
    }

    public void clear() {
        current = "";
        result = "";
        isDot = false;
        isOperator = false;
    }

    public void backSpace() {
        if (!current.isEmpty()) {
            if (current.substring(current.length()-1, current.length()).equals(".")) {
                isDot = false;
            }
            if (current.substring(current.length()-1, current.length()).equals(" ")) {
                current = current.substring(0, current.length()-3);
                isOperator = false;
            } else {
                current = current.substring(0, current.length()-1); // если строка не пуста - удаляем последний символ
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("curr", current);
        outState.putString("res", result);
        outState.putBoolean("dot", isDot);
        outState.putBoolean("opera", isOperator);
        outState.putString("twCalc", twCalc.getText().toString());
        outState.putString("twRes", twRes.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        current = savedInstanceState.getString("curr");
        result = savedInstanceState.getString(("res"));
        isDot = savedInstanceState.getBoolean("dot");
        isOperator = savedInstanceState.getBoolean("opera");
        twCalc.setText(savedInstanceState.getString("twCalc"));
        twRes.setText(savedInstanceState.getString("twRes"));
    }
}