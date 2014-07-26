package com.mrbrainy.app;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;

/**
 * Created by gordon on 11/05/14.
 *
 * Will take care of inteface elements that are static, and change for several activities at once.
 *
 */
public final class SharedInterface {

    private static int caseNr=0;

    public static void updateBackground(){
        caseNr++;
        if (caseNr>5){
            caseNr=0;
        }
    }

    public static void getBackground(LinearLayout layout, Resources resources){
        Drawable drawable;

        if (caseNr>5){
            caseNr=0;
        }

        switch (caseNr){

            case 1:
                layout.setBackgroundColor(resources.getColor(R.color.purple));
                break;

            case 2:
                layout.setBackgroundColor(resources.getColor(R.color.pink));
                break;


            case 3:
                layout.setBackgroundColor(resources.getColor(R.color.orange));
                break;


            case 4:
                layout.setBackgroundColor(resources.getColor(R.color.yellow));
                break;

            case 5:
                layout.setBackgroundColor(resources.getColor(R.color.green));
                break;


            default:
                layout.setBackgroundColor(resources.getColor(R.color.blue));
                break;
        }
    }
}
