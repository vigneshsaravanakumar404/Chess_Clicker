package com.example.chessclicker;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import java.util.Random;

public class HomeFragment extends Fragment {

    int scaleAnimationTime, translateAnimationTime, eloPerClick;
    Random random = new Random();


    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Setup
        ImageView imageView = view.findViewById(R.id.imageView);
        eloPerClick = 0;
        scaleAnimationTime = 100;
        translateAnimationTime = 500;
        imageView.setMaxWidth(50);
        imageView.setMaxHeight(50);


        // Scale Animation
        final ScaleAnimation scaleAnimation = new ScaleAnimation(0.9F, 1F, 0.9F, 1F, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
        final ScaleAnimation scaleAnimationReverse = new ScaleAnimation(1F, 0.9F, 1F, 0.9F, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
        scaleAnimation.setDuration(scaleAnimationTime);
        scaleAnimationReverse.setDuration(scaleAnimationTime);
        scaleAnimationReverse.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.startAnimation(scaleAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        // Main Image Clicker
        imageView.setOnTouchListener((v, event) -> {

            // Animate The Clicker
            v.startAnimation(scaleAnimationReverse);

            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                int x = (int) event.getRawX();
                int y = (int) event.getRawY();


                // Particle Parameters
                TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, -1f);
                translateAnimation.setDuration(translateAnimationTime);
                ConstraintLayout layout = view.findViewById(R.id.relativeLayout);

                TextView scoreView = new TextView(getContext());
                scoreView.setText("+" + eloPerClick);
                scoreView.setTextColor(Color.WHITE);
                scoreView.setGravity(Gravity.CENTER);
                scoreView.startAnimation(translateAnimation);

                ImageView boardView = new ImageView(getContext());
                boardView.setImageResource(R.drawable.board);
                boardView.startAnimation(translateAnimation);
                boardView.setAlpha(0.5f);

                // Layout Parameters
                scoreView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.leftMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.width = scoreView.getMeasuredWidth();
                layoutParams.height = scoreView.getMeasuredHeight();

                // Apply Layout Parameters
                scoreView.setLayoutParams(layoutParams);
                scoreView.setX((x - scoreView.getMeasuredWidth() / 2f) + random.nextInt(74) - 37);
                scoreView.setY((y - scoreView.getMeasuredHeight() / 2f) - 315);

                boardView.setLayoutParams(layoutParams);
                boardView.setX((x - 10f)); // Set x position to be in the center of the 20 pixel width
                boardView.setY((y - 10f) - 265); // Set y position to be in the center of the 20 pixel height

                // Add and delete Particles
                layout.addView(scoreView);
                layout.addView(boardView);
                new Handler().postDelayed(() -> layout.removeView(scoreView), translateAnimationTime);
                new Handler().postDelayed(() -> layout.removeView(boardView), translateAnimationTime);


            }
            return true;
        });
        return view;

    }
}

// Requirements
//TODO: Upgrades
//TODO: FORMAT/COMMENT/ORGANIZE CODE
//TODO: RENAME EVERYTHING
//TODO: PICK BETTER COLORS


// Features:
// Forced to Portrait
// Custom Vector assets
// Cost/Income Progression
// Circular Image View
//TODO: SOUND EFFECTS
//TODO: PUT IN CUSTOM VECTOR ASSETS
//TODO: ACHIEVEMENTS
//TODO: LOTS OF UPGRADES
//TODO: SPECIAL UPGRADES
//TODO: STATS
//TODO: VISUAL/VISUAL MENU FOR ALL AUTO GENERATED ELO METHODS
//TODO: SAVE DATA
//TODO: ADD BADGES FOR THE NUMBER OF UPGRADES AVAILABLE
//TODO: REMOVE ACTION BAR
//TODO: MAKE APP NAME
//TODO: CREATE SPLASH SCREEN
//TODO: NAME APP


// Resources
/* Blunder Prevention (Chess.com Bluncer image), Tactics (mikhial Tal), Brilliant Move Factory (Chess.com Brilliant moves icon),Botez Gambit (Botze Sisters), Oh no my Queen (Eric rosen), Premoves (Andrew Tang), Speed (Hikaru), Endgame (Magnus Carlsen),, "Special Assistance" (Haans Nieman), Stockfish (Computer)*/