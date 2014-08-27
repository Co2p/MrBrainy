package com.mrbrainy.app;

import android.content.Context;
import android.text.format.Time;
import java.io.FileOutputStream;


/**
 * Created by Isidor on 19/05/14.
 * Updated 27/8 2014 by Isidor
 */
public class Highscore {
    private double score;

    public void initScore(){
        System.out.println("Initializing score");
        score = 0;
    }
    /*  addScore
     *  Adds a score to the current games Highscore,
     *  timeCount = time left
     *  level = current level
     *  The current time for completing a question is 10s.
     *
     *  Scoresystem: 200 is max score for time and level, the score for time and level
     *  is added after calculation and divided by 4 so the max score for each question should
     *  be around 100.
     */
    public void addScore(long timeCount, int level){
        //Time is in milliseconds
        int currentScore;
        System.out.println("Adding score to scoretable, level, time: " + timeCount/100 + ", " + level*10);
        currentScore = (int)(((timeCount/100)+100) + ((level*10) + 100))/2-100;
        System.out.println("Score = " + currentScore + "!");
        score = score + currentScore;
    }

    public double getScore(){
        return score;
    }

    //Adds the current score into a Highscore file
    public void addHighscore(){
        String FILENAME = "Highscore";
        String insert;

        System.out.println("Inserting Highscore");
        Time now = new Time();
        now.setToNow();
        System.out.println("Current time is: " + now);

        //Generates string to insert into Highscore
        insert = now + " " + score + "\n";
        System.out.println("String = " + insert);

        System.out.println("Writing Highscore...");
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
