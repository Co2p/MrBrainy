package com.mrbrainy.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.Spinner;

public class Start extends ActionBarActivity {
    Spinner chooseDifficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_about) {
            Intent aboutIntent = new Intent(this, About.class);
            startActivity(aboutIntent);
        }
        if (id == R.id.action_settings) {
            //Intent settingsIntent = new Intent(this, SettingsActivity.class);
            //startActivity(settingsIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    public void startGame(View view){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    private void populateSpinner(){
    }
}
