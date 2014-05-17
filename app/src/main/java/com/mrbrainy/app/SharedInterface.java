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

    public static void setBackground(int caseNr, LinearLayout linearLayout, Resources resources){
        Drawable drawable;


        switch (caseNr){

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
