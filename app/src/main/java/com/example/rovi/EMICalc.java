package com.example.rovi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import java.lang.*;

public class EMICalc extends AppCompatActivity {
    SeekBar sb1,sb2,sb3;
    TextView tv2,tv3,tv4,tv5;
    public void calculate()
    {
        float year=Float.parseFloat(tv5.getText().toString());
        float amount=Float.parseFloat(tv3.getText().toString());
        amount= (amount*100000);
        float rate=Float.parseFloat(tv4.getText().toString());
        rate= (rate/100);
        double emi=(amount * rate *(Math.pow((1+rate),(year))) )/(Math.pow((1+rate),(year-1))) ;
        tv2.setText(emi+"");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emicalc);
        sb1= findViewById(R.id.sb1);
        sb2= findViewById(R.id.sb2);
        sb3= findViewById(R.id.sb3);

        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        tv4=findViewById(R.id.tv4);
        tv5=findViewById(R.id.tv5);
        sb1.setProgress(10);
        sb2.setProgress(10);
        sb3.setProgress(10);
        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int p1=10;
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                p1=progress;
                tv3.setText(p1+"");
                calculate();
            }
            public void onStartTrackingTouch(SeekBar seekBar){
                calculate();
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(EMICalc.this,"Your Amount(in lakhs) = "+p1,Toast.LENGTH_SHORT).show();
                tv3.setText(p1+"");
                calculate();
            }

        });
        sb2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int p2=10;
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                p2=progress;
                tv4.setText(p2+ "");
                calculate();
            }
            public void onStartTrackingTouch(SeekBar seekBar){
                calculate();
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(EMICalc.this,"Your Rate = "+p2,Toast.LENGTH_SHORT).show();
                tv4.setText(p2+ "");
                calculate();
            }
        });
        sb3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int p3=10;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                p3 = progress;
                tv5.setText(p3+"");
                calculate();
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                calculate();
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(EMICalc.this, "Your Year = " + p3, Toast.LENGTH_SHORT).show();
                tv5.setText(p3+ "");
                calculate();
            }
        });


    }
}

