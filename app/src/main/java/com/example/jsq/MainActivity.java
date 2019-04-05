package com.example.jsq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static TextView tv;
    public static TextView tv_top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.display);
        tv_top = findViewById(R.id.display_top);


        findViewById(R.id.button_0).setOnClickListener(this);
        findViewById(R.id.button_1).setOnClickListener(this);
        findViewById(R.id.button_2).setOnClickListener(this);
        findViewById(R.id.button_3).setOnClickListener(this);
        findViewById(R.id.button_4).setOnClickListener(this);
        findViewById(R.id.button_5).setOnClickListener(this);
        findViewById(R.id.button_6).setOnClickListener(this);
        findViewById(R.id.button_7).setOnClickListener(this);
        findViewById(R.id.button_8).setOnClickListener(this);
        findViewById(R.id.button_9).setOnClickListener(this);
        findViewById(R.id.button_cl).setOnClickListener(this);
        findViewById(R.id.button_dia).setOnClickListener(this);
        findViewById(R.id.button_add).setOnClickListener(this);
        findViewById(R.id.button_sub).setOnClickListener(this);
        findViewById(R.id.button_sqrt).setOnClickListener(this);
        findViewById(R.id.button_mul).setOnClickListener(this);
        findViewById(R.id.button_ce).setOnClickListener(this);
        findViewById(R.id.button_cl).setOnClickListener(this);
        findViewById(R.id.button_Enter).setOnClickListener(this);
        findViewById(R.id.button_div).setOnClickListener(this);
    }

    private String operator = ""; // 操作符
    private String firstNum = ""; // 前一个操作数
    private String nextNum = ""; // 后一个操作数
    private String result = ""; // 当前的计算结果
    private String showText = ""; // 显示的文本内容
    public static BigDecimal a;

    @Override
    public void onClick(View v) {


        String input = ((TextView) v).getText().toString();

        if (input.equals("+") || input.equals("-") || input.equals("×") || input.equals("÷") || input.equals("=")) {
            if (firstNum.length() == 0) {
                firstNum = tv.getText().toString();
                tv_top.append("\n");
                tv_top.append(firstNum);
                showText = "";
                operator = input;
                tv.setText(showText);
            } else {
                if ((tv.getText().toString().length() != 0)) {
                    a = new BigDecimal(firstNum);
                    js(tv.getText().toString());
                    firstNum = a.toString();
                    tv_top.append("\n");
                    tv_top.append(firstNum);
                    showText = "";
                    tv.setText(showText);
                    operator = input;
                    if (input.equals("=")) {
                        operator = "";
                    }
                } else {
                    operator = input;
                }
            }
        } else {
            showText += input;
            tv.setText(showText);
        }
        if (input.equals("C")) {
            showText = "";
            firstNum = "";
            operator = "";
            tv.setText(showText);
            tv_top.setText("");
        }
    }

    public void js(String st2) {
        BigDecimal b = new BigDecimal(st2);

        if (operator.equals("+")) a = a.add(b);
        if (operator.equals("-")) a = a.subtract(b);
        if (operator.equals("×")) a = a.multiply(b);
        if (operator.equals("÷")) {
            if(st2.equals("0")){
                showText = "";
                firstNum = "";
                operator = "";
                tv.setText(showText);
                tv_top.setText("");
                Toast.makeText(MainActivity.this,"除数不能为0！！",Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                a = a.divide(b);
            } catch (Exception e) {
                a = a.divide(b, 10, BigDecimal.ROUND_HALF_UP);
            }
        }
    }
}




