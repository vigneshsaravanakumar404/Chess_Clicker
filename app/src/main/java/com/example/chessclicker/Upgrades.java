package com.example.chessclicker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Upgrades extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] names, descriptions;
    private final int[] images;
    private final long[] a;
    private final double[] r;

    private int[] currentLevels;
    private long[] currentBuyCosts;
    private double[] currentEloPerSeconds;
    private double cps;


    public Upgrades(Activity context) {
        super(context, R.layout.custom_list_item); //TODO: SUPER ALL PARAMETERS

        this.context = context;
        names = new String[]{"Blunder Prevention", "Tactics", "Brilliant Move Factory", "Botez Gambit", " Oh no my Queen!", "Premoves", "Speed", "Endgame", "\"Special Assistance\"", "Stockfish"};
        descriptions = new String[]{"Prevents you from making blunder", "Harness the power of Mikhail Tal himself", "Increase your chances of brilliancies", "Harness the true powers of your queen", "Premove like Andrew Tang", "Play your opponent's mind instead of the game", "Play blitz and bullet like the god himself", "Harness the power of Magnus Carlsen", "Defeat the world champion in one move", "Achieve perfection itself"};
        images = new int[]{};
        r = new double[]{0.1, 0.5, 4, 10, 40, 100, 400, 6_666, 98_765, 98_765};
        a = new long[]{15, 100, 500, 3_000, 10_000, 40_000, 40_000, 1_666_666, 123_456_789, 3_999_999_999L};


        cps = 0;
        currentEloPerSeconds = new double[]{1, 2, 8, 47, 260, 1_400, 7_800, 44_000, 260_000, 1_600_000, 10_000_000, 65_000_000, 430_000_000, 2_900_000_000L, 21_000_000_000L, 150_000_000_000L, 1_100_000_000_000L, 8_300_000_000_000L, 65_280_000_000_000L};
        currentLevels = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        currentBuyCosts = a;
    }


    public double setCps()
    {
        double sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += currentLevels[i] * r[i];
        }
        cps = sum;
        return cps;
    }



    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.custom_list_item, null, true);

        // Set the name, description, and image for each row
        TextView nameTextView = rowView.findViewById(R.id.item_text);
        nameTextView.setText(names[position]);

        return rowView;
    }
}
