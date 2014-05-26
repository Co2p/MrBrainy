package com.mrbrainy.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class PausedActivity extends ActionBarActivity {
    private double score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paused);
    }

    @Override
    public void onBackPressed(){
        System.out.println("No you dont!");
    }

    //TODO needs to resume the paused game, this just starts a new one!
    public void resume(View v){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void mainMenu(View v) {
        Intent intent = new Intent(this, Start.class);
        startActivity(intent);
    }



}
