package com.mrbrainy.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AboutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    public void coolButton(View v){
        Intent intent = new Intent(this, Start.class);
        startActivity(intent);
    }
}
