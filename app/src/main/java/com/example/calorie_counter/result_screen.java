package com.example.calorie_counter;

import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDelegate;

public class result_screen extends AppCompatActivity {
double maintainWeight,mildWeightLoss,mediumWeightLoss,heavyWeightLoss;
TextView maintainRate,mildMaintainRate,mediumMaintainRate,heavyMaintainRate;
Button back;
    Bundle b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_result_screen);


        b=getIntent().getExtras();
        maintainWeight=b.getDouble("maintainWeight");
        mildWeightLoss=b.getDouble("mildWeightLoss");
        mediumWeightLoss=b.getDouble("mediumWeightLoss");
        heavyWeightLoss=b.getDouble("heavyWeightLoss");
        maintainRate=findViewById(R.id.maintain);
        mildMaintainRate=findViewById(R.id.mild);
        mediumMaintainRate=findViewById(R.id.medium);
        heavyMaintainRate=findViewById(R.id.extreme);
        maintainRate.setText(Math.round(maintainWeight)+" cal/day");
        mildMaintainRate.setText(Math.round(mildWeightLoss)+" cal/day");
        mediumMaintainRate.setText(Math.round(mediumWeightLoss)+" cal/day");
        heavyMaintainRate.setText(Math.round(heavyWeightLoss)+" cal/day");

    }
    public void back(View v)
    {
        super.onBackPressed();
    }
}