package com.example.chessclicker;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;


public class MainActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    ViewFragment viewFragment = new ViewFragment();
    UpgradesFragment upgradesFragment = new UpgradesFragment();
    AtomicInteger score;


    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Full Screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        // Other stuff
        score = new AtomicInteger(0);

        // Fragments
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

