package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class bmiactivity extends AppCompatActivity {

android.widget.Button mrecalculatebmi;

    TextView mbmidisplay,mbmicatagory,mgender;
    Intent intent;
    ImageView mimageview;
    String mbmi;
    float intbmi;

    String height ;
    String weight ;
    float intheight,intweight;
    RelativeLayout mbackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("result");
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent=getIntent();
        mbmidisplay=findViewById(R.id.bmidisplay);
        mbmicatagory=findViewById(R.id.bmicatagory);
        mbackground=findViewById(R.id.contentlayout);
        mgender=findViewById(R.id.genderdisplay);
        mimageview=findViewById(R.id.imageview);
        mrecalculatebmi=findViewById(R.id.Recalculatebmi);


        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");
        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        intheight=intheight/100;
        intbmi=intweight/(intheight*intheight);
        mbmi=Float.toString(intbmi);

        if (intbmi<16)
        {
            mbmicatagory.setText("Severe thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
        }
        else if (intbmi<16.9 && intbmi>16)

            {
                mbmicatagory.setText("Moderate thinness");
                mbackground.setBackgroundColor(Color.RED);
                mimageview.setImageResource(R.drawable.warning);
            }
        else if (intbmi<18.4 && intbmi>17)

        {
            mbmicatagory.setText("Mild thinness");
            mbackground.setBackgroundColor(Color.YELLOW);
            mimageview.setImageResource(R.drawable.warning);
        }
        else if (intbmi<25 && intbmi>18.4)

        {
            mbmicatagory.setText("Normal");
            mbackground.setBackgroundColor(Color.GREEN);
            mimageview.setImageResource(R.drawable.ok);
        }
        else if (intbmi<29.4 && intbmi>25)

        {
            mbmicatagory.setText("Overweight");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
         else
        {
            mbmicatagory.setText("Obese Class I");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }

         mgender.setText(intent.getStringExtra("gender"));
         mbmidisplay.setText(mbmi);



        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent=new Intent (bmiactivity.this,MainActivity.class);
              startActivity(intent);
              finish();

          }
      });

    }
}
