package com.example.pratikkarki.first_app;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView myTextView;
    Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = findViewById(R.id.my_text_view);
        myButton = findViewById(R.id.button);

        myTextView.setText("I just changed the text!");
        myButton.setBackgroundColor(Color.CYAN);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeText();
            }
        });
    }

    void changeText() {
        String text = myTextView.getText().toString();
        text = text + "!";
        myTextView.setText(text);
    }

}
