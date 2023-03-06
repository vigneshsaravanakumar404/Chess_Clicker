package com.example.chessclicker;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    ViewFragment viewFragment = new ViewFragment();
    UpgradesFragment upgradesFragment = new UpgradesFragment();

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();



        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                    return true;
                case R.id.view:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, upgradesFragment).commit();
                    return true;
                case R.id.upgrades:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, viewFragment).commit();
                    return true;
            }

            return false;
        });

    }
}

