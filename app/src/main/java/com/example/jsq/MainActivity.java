package com.example.jsq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.display);
        MyLister my=new MyLister();
        findViewById(R.id.button_0).setOnClickListener(my);
        findViewById(R.id.button_1).setOnClickListener(my);
        findViewById(R.id.button_2).setOnClickListener(my);
        findViewById(R.id.button_3).setOnClickListener(my);
        findViewById(R.id.button_4).setOnClickListener(my);
        findViewById(R.id.button_5).setOnClickListener(my);
        findViewById(R.id.button_6).setOnClickListener(my);
        findViewById(R.id.button_7).setOnClickListener(my);
        findViewById(R.id.button_8).setOnClickListener(my);
        findViewById(R.id.button_9).setOnClickListener(my);
        findViewById(R.id.button_cl).setOnClickListener(my);
    }

    class MyLister implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            String st = tv.getText().toString();
            switch (view.getId()) {
                case R.id.button_0:
                    if ((st.equals("0"))){
                        tv.setText("0");
                    } else {
                        tv.setText(st + "0");
                    }
                    break;
                case R.id.button_1:
                    tv.setText(st + "1");
                    break;
                case R.id.button_2:
                    tv.setText(st + "2");
                    break;
                case R.id.button_3:
                    tv.setText(st + "3");
                    break;
                case R.id.button_4:
                    tv.setText(st + "4");
                    break;
                case R.id.button_5:
                    tv.setText(st + "5");
                    break;
                case R.id.button_6:
                    tv.setText(st + "6");
                    break;
                case R.id.button_7:
                    tv.setText(st + "7");
                    break;
                case R.id.button_8:
                    tv.setText(st + "8");
                    break;
                case R.id.button_9:
                    tv.setText(st + "9");
                    break;
                case R.id.button_cl:
                    tv.setText("");
                    break;
            }
        }
    }
}
