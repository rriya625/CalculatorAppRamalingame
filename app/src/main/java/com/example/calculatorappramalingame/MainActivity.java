package com.example.calculatorappramalingame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void switchScreens(View view){

        if(view.getId() == R.id.additionButton){
            Intent intent = new Intent(this, AdditionActivity.class);
            startActivity(intent);
        }
        else if (view.getId() == R.id.subtractionButton){
            Intent intent = new Intent(this, SubtractionActivity.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.multiplicationButton){
            Intent intent = new Intent(this, MultiplicationActivity.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.divisionButton){
            Intent intent = new Intent(this, DivisionActivity.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.exponentialButton){
            Intent intent = new Intent(this, ExponentialActivity.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.integerDivisionButton){
            Intent intent = new Intent(this, IntegerDivisionActivity.class);
            startActivity(intent);
        }
    }
}

