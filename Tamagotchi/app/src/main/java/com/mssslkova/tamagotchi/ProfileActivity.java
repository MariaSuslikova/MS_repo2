package com.mssslkova.tamagotchi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    static ImageView imageview;
    public TextView textview1;
    public TextView textview2;
    public TextView textview3;
    public TextView textview4;
    String value1;
    String value2;
    String value3;
    String value4;
    String name;
    long endtime;
    float sec;
    public int i;
    public int i1;
    public int i2;
    public int i3;
    public int i4;
    ImageButton eat;
    ImageButton drink;
    ImageButton wash;
    ImageButton play;
    long starttime;
    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            value1 = textview1.getText().toString();
            i1 = Integer.parseInt(value1);
            textview1.setText("" + (i1 - 10));
            value2 = textview2.getText().toString();
            i2 = Integer.parseInt(value2);
            textview2.setText("" + (i2 - 10));
            value3 = textview3.getText().toString();
            i3 = Integer.parseInt(value3);
            textview3.setText("" + (i3 - 10));
            value4 = textview4.getText().toString();
            i4 = Integer.parseInt(value4);
            textview4.setText("" + (i4 - 10));
            timerHandler.postDelayed(this, 3*1000);
            if ((i1 < 20) || (i2 < 20) || (i3 < 20) || (i4 < 20)){
                try
                {
                    timerHandler.removeCallbacks(timerRunnable);
                    endtime = System.currentTimeMillis();
                    sec = (endtime - starttime)/1000;
                    Intent intent = new Intent(ProfileActivity.this, DieActivity.class);
                    intent.putExtra("livetime", sec);
                    intent.putExtra("name", name);
                    startActivity(intent);
                    finish();
                }
                catch(Exception e){}
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        final long t = 0;
        imageview = findViewById(R.id.profile_imageview);
        Intent intent = getIntent();
        if (intent != null) {
            name = intent.getStringExtra("name");
            i = intent.getIntExtra("i", 0);
            if (i == 1)
            {
                imageview.setImageResource(R.drawable.catik1);
            }
            if (i == 2)
            {
                imageview.setImageResource(R.drawable.catik2);
            }
        }
        textview1 = (TextView)findViewById(R.id.profile_textview_one);
        textview2 = (TextView)findViewById(R.id.profile_textview_two);
        textview3 = (TextView)findViewById(R.id.profile_textview_three);
        textview4 = (TextView)findViewById(R.id.profile_textview_four);
        starttime = System.currentTimeMillis();//время начала жизни
        timerHandler.postDelayed(timerRunnable, 5*1000);
        eat = (ImageButton)findViewById(R.id.imageButton4);
        drink = (ImageButton)findViewById(R.id.imageButton7);
        wash = (ImageButton)findViewById(R.id.imageButton6);
        play = (ImageButton)findViewById(R.id.imageButton5);
        eat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value4 = textview4.getText().toString();
                i4 = Integer.parseInt(value4);
                if (i4 < 100) {
                    textview4.setText("" + (i4 + 10));
                }
            }
        });
        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value3 = textview3.getText().toString();
                i3 = Integer.parseInt(value3);
                if (i3 < 100) {
                    textview3.setText("" + (i3 + 10));
                }
            }
        });
        wash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value2 = textview2.getText().toString();
                i2 = Integer.parseInt(value2);
                if (i2 < 100) {
                    textview2.setText("" + (i2 + 10));
                }
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1 = textview1.getText().toString();
                i1 = Integer.parseInt(value1);
                if (i1 < 100) {
                    textview1.setText("" + (i1 + 10));
                }
            }
        });
    }
}
