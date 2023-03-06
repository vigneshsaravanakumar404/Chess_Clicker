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
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import java.util.Random;

public class HomeFragment extends Fragment {

    int animationTime, eloPerClick;
    Random random = new Random();


    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // start up Variables
        ImageView imageView = view.findViewById(R.id.imageView);
        eloPerClick = 0;
        animationTime = 100;

        // ImageView Code
        imageView.setMaxWidth(50);
        imageView.setMaxHeight(50);

        // Animation Code
        final ScaleAnimation scaleAnimation = new ScaleAnimation(0.9F, 1F, 0.9F, 1F, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
        final ScaleAnimation scaleAnimationReverse = new ScaleAnimation(1F, 0.9F, 1F, 0.9F, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
        scaleAnimation.setDuration(animationTime);
        scaleAnimationReverse.setDuration(animationTime);
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

            // Animated +0
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                int x = (int) event.getRawX();
                int y = (int) event.getRawY();


                // TextView Parameters
                ConstraintLayout layout = view.findViewById(R.id.relativeLayout);
                TextView scoreView = new TextView(getContext());
                scoreView.setText("+" + eloPerClick);
                scoreView.setTextColor(Color.WHITE);
                //scoreView.setBackgroundColor(Color.WHITE);
                scoreView.setGravity(Gravity.CENTER);

                // Layout Parameters
                scoreView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                        ConstraintLayout.LayoutParams.WRAP_CONTENT,
                        ConstraintLayout.LayoutParams.WRAP_CONTENT
                );
                layoutParams.leftMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.width = scoreView.getMeasuredWidth
                        ();
                layoutParams.height = scoreView.getMeasuredHeight();

                // Apply Layout Permissions
                scoreView.setLayoutParams(layoutParams);
                scoreView.setX((x - scoreView.getMeasuredWidth() / 2f) + random.nextInt(74) - 37);
                scoreView.setY((y - scoreView.getMeasuredHeight() / 2f) - 315);

                // Add and delete scoreTexVView
                layout.addView(scoreView);
                new Handler().postDelayed(() -> layout.removeView(scoreView), 500);
            }

            return true;
        });
        return view;

    }
}

// Requirements
//TODO: ADD IMAGE ON CLICK AND ANIMATE IT
//TODO: ANIMATE +0
//TODO: OTHER REQUIREMENTS


// Features:
// Forced to Portrait
//TODO: SOUND EFFECTS
//TODO: FRAGMENTS FOR EACH MENU
//TODO: ACHIEVEMENTS
//TODO: LOTS OF UPGRADES
//TODO: SPECIAL UPGRADES
//TODO: STATS
//TODO: VISUAL/VISUAL MENU FOR ALL AUTO GENERATED ELO METHODS
//TODO: SAVE DATA
//TODO: ADD BADGES FOR THE NUMBER OF UPGRADES AVAILABLE