package com.mssslkova.tamagotchi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

public class TopActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        ImageButton ButtonBack = (ImageButton)findViewById(R.id.backButton);
        ListView listView = (ListView)findViewById(R.id.listView);
        RecordDao dao = new RecordDao(getApplicationContext());
        MyAdapter adapter = new MyAdapter(this, dao.getAll());
        listView.setAdapter(adapter);
        ButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    Intent intent = new Intent(TopActivity.this, ChooseActivity.class);
                    startActivity(intent);
                    finish();
                }
                catch(Exception e){}
            }
        });
    }
}
