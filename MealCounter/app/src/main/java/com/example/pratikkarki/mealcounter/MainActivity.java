package com.example.pratikkarki.mealcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView myTextView;
    Button button1;
    Button button2;
    Button button3;
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = findViewById(R.id.text2);
        button1 =  findViewById(R.id.button1);
        button2 =  findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMeal();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeMeal();
            }
        });
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchSecondActivity();
            }
        });
    }

    private void launchSecondActivity(){
        Intent intent = new Intent( this, SecondActivity.class);
        startActivity(intent);
    }

    void addMeal (){
            x++;
        myTextView.setText(x+"");
    }
    void removeMeal (){
        x--;
        myTextView.setText(x+"");
    }
}
