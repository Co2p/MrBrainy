package com.mrbrainy.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mrbrainy.app.R;

public class About extends ActionBarActivity {

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
