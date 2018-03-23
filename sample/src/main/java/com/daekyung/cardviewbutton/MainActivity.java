package com.daekyung.cardviewbutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CardViewButton cardViewButtonGoogle = findViewById(R.id.button_google_login);
        CardViewButton cardViewButtonFacebook = findViewById(R.id.button_face_book_login);
        CardViewButton cardViewButtonPoint = findViewById(R.id.button_get_point);
        CardViewButton cardViewButtonHome = findViewById(R.id.button_go_home);

        cardViewButtonGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "google", Toast.LENGTH_SHORT).show();
            }
        });
        cardViewButtonFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "facebook", Toast.LENGTH_SHORT).show();
            }
        });
        cardViewButtonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "point", Toast.LENGTH_SHORT).show();
            }
        });
        cardViewButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "home", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
