package com.example.tema1refacere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activitate2 extends AppCompatActivity {
    private Button btnNextActiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitate2);

        btnNextActiv=findViewById(R.id.simion_maria_btn_next1);
        btnNextActiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activitate2.this, ActivitateIntrebari.class );
                startActivity(intent);
            }
        });
    }
}