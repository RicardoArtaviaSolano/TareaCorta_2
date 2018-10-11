package com.example.ricardo.tareacorta2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button bubbleButton;
    public Button insertionButton;


    public void init(){
        bubbleButton = (Button) findViewById(R.id.bubbleButton);
        insertionButton = (Button)findViewById(R.id.insertionButton);



        bubbleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent graficar1 = new Intent(MainActivity.this,bubbleGraf.class);
                startActivity(graficar1);
            }
        });

        insertionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent graficar2 = new Intent(MainActivity.this,insertionGraf.class);
                startActivity(graficar2);
            }
        });

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
}
