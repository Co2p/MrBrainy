package com.mrbrainy.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * @author Gordon Cooper and Isidor Nygren
 * Displays info about the app
 */
public class AboutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    /**
     * Goes back to the main menu
     * @param v required id for android
     */
    public void coolButton(View v){
        Intent intent = new Intent(this, Start.class);
        startActivity(intent);
    }
}
