package com.ted.myvectordrawable;

import android.graphics.drawable.Animatable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSquareClick(View view) {
        startAnim(view);
    }

    private void startAnim(View view) {
        ImageView imageView = (ImageView)view;
        Animatable animatable = (Animatable) imageView.getDrawable();
        if (animatable.isRunning()){
            animatable.start();
        }
        animatable.start();
    }

    public void onSearchClick(View view) {
        startAnim(view);
    }
}
