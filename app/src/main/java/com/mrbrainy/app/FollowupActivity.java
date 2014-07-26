package com.mrbrainy.app;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

/**
 * @author Gordon Cooper and Isidor Nygren
 * Gives the user feedback after a game.
 */
public class FollowupActivity extends ActionBarActivity {
    private Resources resources;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_followup);
        resources = getResources();
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        Intent intent = getIntent();

        int caseNr = intent.getIntExtra(GameActivity.LEVEL_INFO, -1);
        SharedInterface.getBackground(linearLayout, resources);
    }

}