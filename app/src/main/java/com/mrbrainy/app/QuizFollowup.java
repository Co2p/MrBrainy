package com.mrbrainy.app;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        resources = getResources();

        setBackground();
    }

    private void setBackground(){
        Drawable drawable;



        Intent intent = new Intent();
        long caseNr = intent.getLongExtra(BrainGame.LEVEL_INFO, -1);

        System.out.println(caseNr);

        switch ((int) caseNr){

            case 1:
                drawable = resources.getDrawable(R.drawable.bglevel1);
                linearLayout.setBackground(drawable);
                break;

            case 2:
                drawable = resources.getDrawable(R.drawable.bglevel2);
                linearLayout.setBackground(drawable);
                break;


            case 3:
                drawable = resources.getDrawable(R.drawable.bglevel3);
                linearLayout.setBackground(drawable);
                break;


            case 4:
                drawable = resources.getDrawable(R.drawable.bglevel4);
                linearLayout.setBackground(drawable);
                break;

            case 5:
                drawable = resources.getDrawable(R.drawable.bglevel5);
                linearLayout.setBackground(drawable);
                break;

            case 6:
                drawable = resources.getDrawable(R.drawable.bglevel6);
                linearLayout.setBackground(drawable);
                break;

            case 7:
                drawable = resources.getDrawable(R.drawable.bglevel7);
                linearLayout.setBackground(drawable);
                break;

            case 8:
                drawable = resources.getDrawable(R.drawable.bglevel8);
                linearLayout.setBackground(drawable);
                break;

            default:
                drawable = resources.getDrawable(R.drawable.bglevel9);
                linearLayout.setBackground(drawable);
                break;
        }
    }
}
