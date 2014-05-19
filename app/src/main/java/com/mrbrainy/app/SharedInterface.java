package com.mrbrainy.app;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;

/**
 * Created by gordon on 11/05/14.
 *
 * Will take care of inteface elements that need a lot of code to change
 *
 */
public class SharedInterface {

    public static void setBackground(int caseNr, LinearLayout layout, Resources resources){
        Drawable drawable;


        switch (caseNr){

            case 1:
                drawable = resources.getDrawable(R.drawable.bglevel1);
                layout.setBackground(drawable);
                break;

            case 2:
                drawable = resources.getDrawable(R.drawable.bglevel2);
                layout.setBackground(drawable);
                break;


            case 3:
                drawable = resources.getDrawable(R.drawable.bglevel3);
                layout.setBackground(drawable);
                break;


            case 4:
                drawable = resources.getDrawable(R.drawable.bglevel4);
                layout.setBackground(drawable);
                break;

            case 5:
                drawable = resources.getDrawable(R.drawable.bglevel5);
                layout.setBackground(drawable);
                break;

            case 6:
                drawable = resources.getDrawable(R.drawable.bglevel6);
                layout.setBackground(drawable);
                break;

            case 7:
                drawable = resources.getDrawable(R.drawable.bglevel7);
                layout.setBackground(drawable);
                break;

            case 8:
                drawable = resources.getDrawable(R.drawable.bglevel8);
                layout.setBackground(drawable);
                break;

            default:
                drawable = resources.getDrawable(R.drawable.bglevel9);
                layout.setBackground(drawable);
                break;
        }
    }
}
