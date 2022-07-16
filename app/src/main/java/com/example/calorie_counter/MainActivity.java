package com.example.calorie_counter;

import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {
EditText weight,age,height;
RadioGroup radioGroup;
RadioButton maleRadioButton;
Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);
        weight=findViewById(R.id.weight);
        age=findViewById(R.id.age);
        height=findViewById(R.id.height);
        radioGroup=findViewById(R.id.gender);
        maleRadioButton=findViewById(R.id.male);
        maleRadioButton.setChecked(true);


    }
    public void submit(View v)
    {
        String weight=this.weight.getText().toString();
        String height=this.height.getText().toString();
        String age=this.age.getText().toString();
        int equationType=0;
        int selectedGender=radioGroup.getCheckedRadioButtonId();
        int maleId=R.id.male;
        double basicMetabolicRate=0,mildWeightLoss=0,mediumWeightLoss=0,heavyWeightLoss=0;
        Bundle b=new Bundle();
        if(selectedGender==maleId)
        {
            System.out.println("male chosen");
            equationType=1;
        }
        else
        {
            System.out.println("female chosen");
            equationType=2;
        }
        if (weight.equals("")||age.equals("")||height.equals(""))
        {
            Toast.makeText(this,
                    "Please enter valid details", Toast.LENGTH_LONG).show();
        }
        else
        {

            basicMetabolicRate=10*Double.parseDouble(weight)+6.25*Double.parseDouble(height)-5*Integer.parseInt(age);
//            System.out.println(10*Double.parseDouble(weight));
//            System.out.println(6.25*Double.parseDouble(height));
//            System.out.println(Integer.parseInt(age));
//            System.out.println(basicMetabolicRate);
            if(equationType==1)
            {
                basicMetabolicRate=basicMetabolicRate+5;

            }
            else
            {
                basicMetabolicRate=basicMetabolicRate-161;
            }
            basicMetabolicRate=basicMetabolicRate*1.2;
            mildWeightLoss=basicMetabolicRate-250;
            mediumWeightLoss=basicMetabolicRate-500;
            heavyWeightLoss=basicMetabolicRate-1000;
            b.putDouble("maintainWeight",basicMetabolicRate);
            b.putDouble("mildWeightLoss",mildWeightLoss);
            b.putDouble("mediumWeightLoss",mediumWeightLoss);
            b.putDouble("heavyWeightLoss",heavyWeightLoss);
            Intent intent = new Intent(this, result_screen.class);
            intent.putExtras(b);
            startActivity(intent);
        }

    }
}