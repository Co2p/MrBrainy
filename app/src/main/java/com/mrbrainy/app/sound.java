package com.mrbrainy.app;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by gordoncooper on 30/07/14.
 */
public class sound {

    private int[] mountainKing = new int[] {1, 2, 3, 4, 6, 3, 6, 5, 2, 5, 4, 2, 4, 1, 2, 3, 4, 6, 3, 6, 10, 9, 3, 6, 8};
    private int offset = 0;

    private MediaPlayer correct1;
    private MediaPlayer correct2;
    private MediaPlayer correct3;
    private MediaPlayer correct4;
    private MediaPlayer correct5;
    private MediaPlayer correct6;
    private MediaPlayer correct7;
    private MediaPlayer correct8;
    private MediaPlayer correct9;
    private MediaPlayer correct10;
    private MediaPlayer correct11;
    private MediaPlayer correct12;

    public sound(Context context) {
        correct1 = MediaPlayer.create(context, R.raw.a2);
        correct2 = MediaPlayer.create(context, R.raw.b2);
        correct3 = MediaPlayer.create(context, R.raw.c3);
        correct4 = MediaPlayer.create(context, R.raw.d3);
        correct5 = MediaPlayer.create(context, R.raw.dm3);
        correct6 = MediaPlayer.create(context, R.raw.e3);
        correct7 = MediaPlayer.create(context, R.raw.fm3);
        correct8 = MediaPlayer.create(context, R.raw.g3);
        correct9 = MediaPlayer.create(context, R.raw.gm3);
        correct10 = MediaPlayer.create(context, R.raw.a3);
        correct11 = MediaPlayer.create(context, R.raw.b3);
        correct12 = MediaPlayer.create(context, R.raw.c4);
    }

    public void playCorrect(){
        if(offset>mountainKing.length){
            offset=0;
        }

        switch (mountainKing[offset]){

            case 0:
                correct1.start();
                break;
            case 1:
                correct2.start();
                break;
            case 2:
                correct3.start();
                break;
            case 3:
                correct4.start();
                break;
            case 4:
                correct5.start();
                break;
            case 5:
                correct6.start();
                break;
            case 6:
                correct7.start();
                break;
            case 7:
                correct8.start();
                break;
            case 8:
                correct9.start();
                break;
            case 9:
                correct10.start();
                break;
            case 10:
                correct11.start();
                break;
            case 11:
                correct12.start();
                break;

            default:
                System.out.println("Sound problems!");
        }

        offset++;

    }
}
