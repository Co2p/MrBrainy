package com.mrbrainy.app;

import android.content.Context;
import android.text.format.Time;
import java.io.FileOutputStream;


/**
 * Created by isny0005 on 19/05/14.
 */
public class Highscore{
    private double score;

    public void initScore(){
        System.out.println("Initializing score");
        score = 0;
    }

    public void addScore(int time, int level, int mode){
        //Time is in milliseconds
        System.out.println("Adding score to scoretable");
        score = score + ((time/1000) * 1 + (level/10));
    }

    //Adds the current score into a highscore file
    public void addHighscore(){
        String FILENAME = "highscore";
        String insert;

        System.out.println("Inserting highscore");
        Time now = new Time();
        now.setToNow();
        System.out.println("Current time is: " + now);

        //Generates string to insert into highscore
        insert = now + " " + score + "\n";
        System.out.println("String = " + insert);

        System.out.println("Writing highscore...");
        //Inserting score and date/time into a file
        //TODO Här måste context förstås och skickas in, ingen aning om hur det funkar...
        /*try{
            FileOutputStream fos = Context.openFileOutput(FILENAME, Context.MODE_APPEND);
            fos.write(insert.getBytes());
            fos.close();
        }
        catch(Exception e){
            System.out.print(e);
        }*/
    }
}
