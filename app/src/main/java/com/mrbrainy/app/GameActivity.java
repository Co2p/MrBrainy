package com.mrbrainy.app;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;


public class GameActivity extends ActionBarActivity {

    protected int pageNumber;
    private int realAns;
    private MathQuiz quiz;
    private TextView qText, pageNr, levelText;
    private LinearLayout linearLayout;
    private int progressStatus = 0;
    private ProgressBar progress;
    private Resources resources;
    private Wait wait = new Wait();
    private Highscore score;
    CountDownTimer timeFunc;
    //AnswerButtons
    private Button alt1, alt2, alt3, alt4, alt5, alt6;
    //This sends stuff to QuizFollowup
    public final static String LEVEL_INFO = "com.mrbrainy.app.LEVEL_INFO";



    //Constructor... creates a relativeLayout variable, resources variable and a new game (quiz)
        //initiates the buttons and the question number.
        //it also launches the first question.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_game);
        linearLayout  = (LinearLayout) findViewById(R.id.linearLayout);
        resources = getResources();

        //Creates a quiz object with 7 levels, a streak of 5 to level up,
        // and two mistakes to loose level.
        quiz = new MathQuiz(7, 5, 2);

        //Creates a new timer with 20 seconds
        timer(20000);

        score = new Highscore();
        pageNumber = 0;

        progress = (ProgressBar) findViewById(R.id.progressBar);
        progress.setMax(100);

        alt1 = (Button)findViewById(R.id.a1);
        alt2 = (Button)findViewById(R.id.a2);
        alt3 = (Button)findViewById(R.id.a3);
        alt4 = (Button)findViewById(R.id.a4);
        alt5 = (Button)findViewById(R.id.a5);
        alt6 = (Button)findViewById(R.id.a6);

        System.out.println("Generating new question...");
        newQuestion();
    }

    private void timer(final int time){
        //Timer for question (10 secs)
        System.out.println("Timer initierad");
        timeFunc = new CountDownTimer(time, 100){
            //Render text everytime the timer counts down one second
            public void onTick(long mill) {
                //qTimer.setText("tid = " + mill / 1000);
                progressStatus = ((int) mill/200);
                progress.setProgress(progressStatus);
            }
            //When finished, set the question marked as false and move
            //on to the next question
            public void onFinish() {
                answerEvent(false);
            }
        };
    }

    private void timerReset(){
        System.out.println("Resetting timer...");
        timeFunc.start();
    }

    //Generates a new question and adds it to the display
    protected void newQuestion(){
        resetButtons();

        System.out.println("Creating question strings...");
        pageNumber++;

        String questionString = quiz.generateQuestion();

        //Displays the question
        qText = (TextView) findViewById(R.id.question);
        qText.setText(getResources().getString(R.string.what_is_q) + " " + questionString + "?");

        //Displays the question number
        pageNr = (TextView) findViewById(R.id.questionNumber);
        pageNr.setText(getResources().getString(R.string.question_nr) + " " + pageNumber);

        //Displays the current level
        levelText = (TextView) findViewById(R.id.level);
        levelText.setText(getResources().getString(R.string.level) + " " + quiz.getMode().getMode());

        setButtonText();

        //set new timer
        System.out.println("Setting the timer...");
        timerReset();

    }

    //Randomizes the order of the answers
    private void setButtonText(){
        //Puts the real answer into an array and inserts several faulty answers aswell
        ArrayList<String> answers = new ArrayList<String>();

        answers.add(0, String.valueOf(quiz.getAnswer()));

        System.out.println("Randomizing faulty answers...");

        //Randomize in faulty answers into array
        for(int i = 1; i < 6; i++){
            System.out.println("Randomizing question: " + i);
            String fault = String.valueOf(quiz.getFalseAns(quiz.getAnswer()));
            while(answers.contains(fault)){
                System.out.println("Already in array!");
                fault = String.valueOf(quiz.getFalseAns(quiz.getAnswer()));
            }
            answers.add(i, fault);
        }
        System.out.println("Shufflin' array");
        //Shuffle the array
        long seed = System.nanoTime();
        Collections.shuffle(answers, new Random(seed));
        System.out.println("Inserting real answer position");
        //Insert real answer position
        realAns = answers.indexOf(String.valueOf(quiz.getAnswer()));
        System.out.println("The answer is button number: " + (realAns+1) );
        System.out.println("Inserting answers into game...");
        //Insert answers into game
        alt1.setText(answers.get(0));
        alt2.setText(answers.get(1));
        alt3.setText(answers.get(2));
        alt4.setText(answers.get(3));
        alt5.setText(answers.get(4));
        alt6.setText(answers.get(5));
    }

    //Puts the colour back on the buttons
    //Should these be randomized?
    private void resetButtons(){
        alt1.setBackgroundResource(R.drawable.redbutton);
        alt2.setBackgroundResource(R.drawable.yellowbutton);
        alt3.setBackgroundResource(R.drawable.bluebutton);
        alt4.setBackgroundResource(R.drawable.cyanbutton);
        alt5.setBackgroundResource(R.drawable.greenbutton);
        alt6.setBackgroundResource(R.drawable.pinkbutton);
    }

    //Catches a onClick event for the button alt1/R.id.a1
    public void button1(View v){
        boolean right = realAns==0;
        if (!right){
            alt1.setBackgroundResource(R.drawable.greybutton);
            pauseQuiz(2000);
        }
        answerEvent(right);
    }

    //Catches a onClick event for the button alt2/R.id.a2
    public void button2(View v){
        boolean right = realAns==1;
        if (!right){
            alt1.setBackgroundResource(R.drawable.greybutton);
            pauseQuiz(2000);
        }
        answerEvent(right);
    }

    //Catches a onClick event for the button alt3/R.id.a3
    public void button3(View v){
        boolean right = realAns==2;
        if (!right){
            alt3.setBackgroundResource(R.drawable.greybutton);
            pauseQuiz(2000);
        }
        answerEvent(right);
    }

    //Catches a onClick event for the button alt4/R.id.a4
    public void button4(View v){
        boolean right = realAns==3;
        if (!right){
            alt4.setBackgroundResource(R.drawable.greybutton);
            pauseQuiz(2000);
        }
        answerEvent(right);
    }

    //Catches a onClick event for the button alt5/R.id.a5
    public void button5(View v){
        boolean right = realAns==4;
        if (!right){
            alt5.setBackgroundResource(R.drawable.greybutton);
            pauseQuiz(2000);
        }
        answerEvent(right);
    }

    //Catches a onClick event for the button alt6/R.id.a6
    public void button6(View v) {
        boolean right = realAns==5;
        if (!right){
            alt6.setBackground(resources.getDrawable(R.drawable.greybutton));
            pauseQuiz(2000);
        }
        answerEvent(right);
    }

    //Pauses the game for a specified time
    private void pauseQuiz(int time)  {
        System.out.println("Feed");
        timeFunc.cancel();

        //Pauses the thread for (param) milliseconds
        wait.sec(time);

    }

    //Processes all of the onClick events, catches a bool, of true it
        //will add to the correct answers in the mode class, otherwise it will remove.
        // If the max level has been reached, the activity QuizFollowup will be called
    private void answerEvent(boolean ansBool) {

        //if this is true the max level has been reached
        boolean endOfGame=false;
        int currentLevel=quiz.getMode().level;

        if (ansBool){
            System.out.println("Right");
            endOfGame=quiz.getMode().add();
        }
        else {
            quiz.getMode().remove();

            System.out.println("Wrong");
        }

        if (endOfGame){
            Intent intent = new Intent(this, FollowupActivity.class);
            intent.putExtra(LEVEL_INFO, quiz.getMode().getMode());

            startActivity(intent);
        }

        //Changes the background depending on the level NOT!
        if (currentLevel != quiz.getMode().level){
            SharedInterface.setBackground(quiz.getMode().level, linearLayout, resources);
            //getResources(R.drawable.bglevel1).setColorFilter(0, 155, 155, 155);
        }

        newQuestion();
    }

    public double getPoints(){
        return score.getScore();
    }


    //Currently only stops the back button functionality, in the future will bring the pause menu
    @Override
    public void onBackPressed() {
        timeFunc.cancel();
        Intent intent = new Intent(this, PausedActivity.class);
        startActivity(intent);
    }

    public void resume(){

    }

}