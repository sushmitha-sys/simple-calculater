package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button clear;
    private Button plus;
    private Button minus;
    private Button mul;
    private Button div;
    private Button mod;
    private Button pow;
    private Button dot;
    private Button equal;
    private TextView info;
    private TextView res;
    private final char ADDITION='+';
    private final char SUBTRACTION='-';
    private final char MULTIPLICATION='*';
    private final char DIVISION='/';
    private final char POWER='^';
    private final char MODULUS='%';
    private final char EQU='0';
    private double val1=Double.NaN;
    private double val2;
    private char ACTION;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIView();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"9");
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION=ADDITION;
                res.setText(String.valueOf(val1)+'+');
                info.setText(null);

            }

        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION=SUBTRACTION;
                res.setText(String.valueOf(val1)+'-');
                info.setText(null);

            }

        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION=MULTIPLICATION;
                res.setText(String.valueOf(val1)+'*');
                info.setText(null);

            }

        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION=DIVISION;
                res.setText(String.valueOf(val1)+'/');
                info.setText(null);

            }

        });
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION=MODULUS;
                res.setText(String.valueOf(val1)+'%');
                info.setText(null);

            }

        });
        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION=POWER;
                res.setText(String.valueOf(val1)+'^');
                info.setText(null);

            }

        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION=EQU;
                res.setText(res.getText().toString() + String.valueOf(val2) +"=" + String.valueOf(val1));
                //5+4=9 5+=val1 val2=4  = val1=9
                info.setText(null);

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().length()>0){
                    CharSequence name=info.getText().toString();
                    info.setText(name.subSequence(0,name.length()-1));
                }
                else{
                    val1=Double.NaN;
                    val2=Double.NaN;
                    info.setText(null);
                    res.setText(null);
                }
            }
        });


    }
    private void setupUIView(){
        one=(Button)findViewById(R.id.bt1);
        two=(Button)findViewById(R.id.two);
        three=(Button)findViewById(R.id.three);
        four=(Button)findViewById(R.id.four);
        five=(Button)findViewById(R.id.five);
        six=(Button)findViewById(R.id.six);
        seven=(Button)findViewById(R.id.seven);
        eight=(Button)findViewById(R.id.eight);
        nine=(Button)findViewById(R.id.nine);
        plus=(Button)findViewById(R.id.add);
        minus=(Button)findViewById(R.id.sub);
        mul=(Button)findViewById(R.id.mul);
        zero=(Button)findViewById(R.id.zero);
        pow=(Button)findViewById(R.id.pow);
        clear=(Button)findViewById(R.id.clear);
        equal=(Button)findViewById(R.id.equal);
        dot=(Button)findViewById(R.id.dot);
        mod=(Button)findViewById(R.id.mod);
        div=(Button)findViewById(R.id.div);
        info=(TextView)findViewById(R.id.display);
        res=(TextView)findViewById(R.id.res);
    }
    private void compute(){
        if(!Double.isNaN(val1)){
            val2=Double.parseDouble(info.getText().toString());
            switch(ACTION){
                case ADDITION:val1=val1 +val2;break;
                case SUBTRACTION:val1=val1 -val2;break;
                case MULTIPLICATION:val1=val1 *val2;break;
                case DIVISION:val1=val1 /val2;break;
                case POWER: double r=val1;
                for(int i=1;i<val2;i++){
                    r=r*val1;
                } val1=r;
                break;
                case MODULUS:val1=val1 %val2;break;
                case EQU: break;
            }
        }
        else
        {
            val1=Double.parseDouble(info.getText().toString());
        }
    }
}