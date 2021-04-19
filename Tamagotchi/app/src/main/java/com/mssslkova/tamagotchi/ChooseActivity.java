package com.mssslkova.tamagotchi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ChooseActivity extends AppCompatActivity {

    int i;
    String string;
    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        name = (EditText)findViewById(R.id.choose_edit_text);
        ImageButton buttonChoose = (ImageButton)findViewById(R.id.choose_button);
        ImageButton choose_cat1 = (ImageButton)findViewById(R.id.choose_cat1);
        ImageButton choose_cat2 = (ImageButton)findViewById(R.id.choose_cat2);
        i = 0;
        choose_cat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    i = 1;
                } catch (Exception e) {
                }
            }
        });
        choose_cat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    i = 2;
                } catch (Exception e) {
                }
            }
        });
        buttonChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i != 0 && name != null) {
                    try {
                        Intent intent = new Intent(ChooseActivity.this, ProfileActivity.class);
                        intent.putExtra("i", i);
                        string = name.getText().toString();
                        intent.putExtra("name", string);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                    }
                }
            }
        });
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
