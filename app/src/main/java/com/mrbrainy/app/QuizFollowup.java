package com.mrbrainy.app;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.LinearLayout;


public class QuizFollowup extends ActionBarActivity {
    private Resources resources;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_followup);
        resources = getResources();
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        Intent intent = getIntent();

        int caseNr = intent.getIntExtra(BrainGame.LEVEL_INFO, -1);
        SharedInterface.setBackground(caseNr, linearLayout, resources);


    }


}
