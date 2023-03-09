package com.example.chessclicker;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;


public class MainActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    UpgradesFragment upgradesFragment = new UpgradesFragment();
    AtomicInteger score;


    ArrayList<Upgrade> upgradesList = new ArrayList<Upgrade>();

    String[] names, descriptions;
    int[] images;
    long[] a;
    double[] r;
    ListView listView;
    private int[] currentLevels;
    private long[] currentBuyCosts;
    private double[] currentEloPerSeconds;
    private double cps;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Full Screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
            }

            return false;
        });


        // Other other stuff
        View view = getLayoutInflater().inflate(R.layout.fragment_upgrades, null);
        listView = view.findViewById(R.id.list_view);

        names = new String[]{"Blunder Prevention", "Tactics", "Brilliant Move Factory", "Botez Gambit", " Oh no my Queen!", "Premoves", "Speed", "Endgame", "\"Special Assistance\"", "Stockfish"};
        descriptions = new String[]{"Prevents you from making blunder", "Harness the power of Mikhail Tal himself", "Increase your chances of brilliancies", "Harness the true powers of your queen", "Premove like Andrew Tang", "Play your opponent's mind instead of the game", "Play blitz and bullet like the god himself", "Harness the power of Magnus Carlsen", "Defeat the world champion in one move", "Achieve perfection itself"};
        images = new int[]{R.drawable.pawn, R.drawable.pawn, R.drawable.pawn, R.drawable.pawn, R.drawable.pawn, R.drawable.pawn, R.drawable.pawn, R.drawable.pawn, R.drawable.pawn, R.drawable.pawn};
        r = new double[]{0.1, 0.5, 4, 10, 40, 100, 400, 6_666, 98_765, 98_765};
        a = new long[]{15, 100, 500, 3_000, 10_000, 40_000, 40_000, 1_666_666, 123_456_789, 3_999_999_999L};
        currentEloPerSeconds = new double[]{1, 2, 8, 47, 260, 1_400, 7_800, 44_000, 260_000, 1_600_000, 10_000_000, 65_000_000, 430_000_000, 2_900_000_000L, 21_000_000_000L, 150_000_000_000L, 1_100_000_000_000L, 8_300_000_000_000L, 65_280_000_000_000L};
        currentLevels = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        currentBuyCosts = a;

        Upgrade one = new Upgrade(this, names[0], descriptions[0], images[0], a[0], r[0]);
        Upgrade two = new Upgrade(this, names[1], descriptions[1], images[1], a[1], r[1]);
        Upgrade three = new Upgrade(this, names[2], descriptions[2], images[2], a[2], r[2]);
        Upgrade four = new Upgrade(this, names[3], descriptions[3], images[3], a[3], r[3]);
        Upgrade five = new Upgrade(this, names[4], descriptions[4], images[4], a[4], r[4]);
        Upgrade six = new Upgrade(this, names[5], descriptions[5], images[5], a[5], r[5]);
        Upgrade seven = new Upgrade(this, names[6], descriptions[6], images[6], a[6], r[6]);
        Upgrade eight = new Upgrade(this, names[7], descriptions[7], images[7], a[7], r[7]);
        Upgrade nine = new Upgrade(this, names[8], descriptions[8], images[8], a[8], r[8]);
        Upgrade ten = new Upgrade(this, names[9], descriptions[9], images[9], a[9], r[9]);

        upgradesList.add(one);
        upgradesList.add(two);
        upgradesList.add(three);
        upgradesList.add(four);
        upgradesList.add(five);
        upgradesList.add(six);
        upgradesList.add(seven);
        upgradesList.add(eight);
        upgradesList.add(nine);
        upgradesList.add(ten);

        CustomAdapter adapter = new CustomAdapter(this, R.layout.fragment_upgrades, upgradesList, MainActivity.this);
        listView.setAdapter(adapter);
        Log.d("TAG", "EH");

    }
}

