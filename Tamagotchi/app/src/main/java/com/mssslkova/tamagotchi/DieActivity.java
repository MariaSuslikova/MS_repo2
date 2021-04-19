package com.mssslkova.tamagotchi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class DieActivity extends AppCompatActivity {

    String name;
    float livetime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_die);
        ImageButton ButtonBack = (ImageButton)findViewById(R.id.backButton);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        livetime = intent.getFloatExtra("livetime", 0);
        RecordEntity enity = new RecordEntity(name, livetime);
        RecordDao dao = new RecordDao(getApplicationContext());
        //dao.delete();
        dao.insert(enity);
        ButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    Intent intent = new Intent(DieActivity.this, TopActivity.class);
                    startActivity(intent);
                    finish();
                }
                catch(Exception e){}
            }
        });
    }
}
