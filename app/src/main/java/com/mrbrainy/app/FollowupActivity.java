package com.mrbrainy.app;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;


public class FollowupActivity extends ActionBarActivity {
    private Resources resources;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_followup);
        resources = getResources();
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        Intent intent = getIntent();

        int caseNr = intent.getIntExtra(GameActivity.LEVEL_INFO, -1);
        SharedInterface.setBackground(caseNr, relativeLayout, resources);
    }

}