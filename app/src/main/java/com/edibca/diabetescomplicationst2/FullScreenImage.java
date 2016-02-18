package com.edibca.diabetescomplicationst2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import Class_General.General;

public class FullScreenImage extends AppCompatActivity {
    public ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_screen_image);
        imagen = (ImageView) findViewById(R.id.imageZoom);
        imagen.setImageDrawable(General.DRAWABLE);

        //imagen.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

}

