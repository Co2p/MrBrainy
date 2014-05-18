package com.mrbrainy.app;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.RelativeLayout;

/**
 * Created by gordon on 11/05/14.
 *
 * Will take care of inteface elements that need a lot of code to change
 *
 */
public class SharedInterface {

    public static void setBackground(int caseNr, RelativeLayout relativeLayout, Resources resources){
        Drawable drawable;


        switch (caseNr){

            case 1:
                drawable = resources.getDrawable(R.drawable.bglevel1);
                relativeLayout.setBackground(drawable);
                break;

            case 2:
                drawable = resources.getDrawable(R.drawable.bglevel2);
                relativeLayout.setBackground(drawable);
                break;


            case 3:
                drawable = resources.getDrawable(R.drawable.bglevel3);
                relativeLayout.setBackground(drawable);
                break;


            case 4:
                drawable = resources.getDrawable(R.drawable.bglevel4);
                relativeLayout.setBackground(drawable);
                break;

            case 5:
                drawable = resources.getDrawable(R.drawable.bglevel5);
                relativeLayout.setBackground(drawable);
                break;

            case 6:
                drawable = resources.getDrawable(R.drawable.bglevel6);
                relativeLayout.setBackground(drawable);
                break;

            case 7:
                drawable = resources.getDrawable(R.drawable.bglevel7);
                relativeLayout.setBackground(drawable);
                break;

            case 8:
                drawable = resources.getDrawable(R.drawable.bglevel8);
                relativeLayout.setBackground(drawable);
                break;

            default:
                drawable = resources.getDrawable(R.drawable.bglevel9);
                relativeLayout.setBackground(drawable);
                break;
        }
    }
}
