package com.mrbrainy.app;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

/**
 * @author Gordon Cooper and Isidor Nygren
 * Controls the in game ui and some logic
 */
public class GameActivity extends ActionBarActivity {

    protected int pageNumber;
    protected int realAns;
    protected MathQuiz quiz;
    protected TextView qText, pageNr, levelText;
    private LinearLayout linearLayout;
    private int progressStatus = 0;
    private ProgressBar progress;
    private Resources resources;
    private Highscore score;
    CountDownTimer timeFunc;



    protected ArrayList<ButtonHolder> buttonListeners = new ArrayList<ButtonHolder>();
    //This sends stuff to QuizFollowup
    public final static String LEVEL_INFO = "com.mrbrainy.app.LEVEL_INFO";


    /**
     * Constructor... creates a relativeLayout variable, resources variable and a new game (quiz)
     * initiates the buttons and the question number.
     * it also launches the first question.
     * @param savedInstanceState android stuff, NO TOUCH!
     */
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



        buttonListeners.add(new ButtonHolder(this,(Button)findViewById(R.id.a1)));
        buttonListeners.add(new ButtonHolder(this,(Button)findViewById(R.id.a2)));
        buttonListeners.add(new ButtonHolder(this,(Button)findViewById(R.id.a3)));
        buttonListeners.add(new ButtonHolder(this,(Button)findViewById(R.id.a4)));
        buttonListeners.add(new ButtonHolder(this,(Button)findViewById(R.id.a5)));
        buttonListeners.add(new ButtonHolder(this,(Button)findViewById(R.id.a6)));



        System.out.println("Generating new question...");
        newQuestion();
    }

    /**
     * Generates a new question and adds it to the display
     */
    protected void newQuestion(){

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

    /**
     * Randomizes the order of the answers
     */
    protected void setButtonText(){
        //Puts the real answer into an array and inserts several faulty answers aswell
        ArrayList<String> answers = new ArrayList<String>();

        answers.add(0, String.valueOf(quiz.getAnswer()));

        //Randomize in faulty answers into array
        for(int i = 1; i < 6; i++){
            String fault = String.valueOf(quiz.getFalseAns(quiz.getAnswer(), quiz.getSign() == 1));
            while(answers.contains(fault)){
                System.out.println("Already in array!");
                fault = String.valueOf(quiz.getFalseAns(quiz.getAnswer(), quiz.getSign() == 1));
            }
            answers.add(i, fault);
        }
        System.out.println("Shufflin' array");

        //Shuffle the array
        long seed = System.nanoTime();
        Collections.shuffle(answers, new Random(seed));

        //Insert real answer position
        realAns = answers.indexOf(String.valueOf(quiz.getAnswer()));
        System.out.println("The answer is button number: " + (realAns+1) );

        int index=0;
        //Insert answers into game
        for(String answer: answers){
            buttonListeners.get(index).setCaption(answer);
            if(index==realAns){
                buttonListeners.get(index).setIsRightAnswer(true);
            }
            index++;
        }
    }

    /**
     * Puts the colour back on the buttons
     * Should the colour be randomized?
     */
    private void resetButtons(){
        for(ButtonHolder button :buttonListeners){
            button.resetColor();
        }

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

    private void initAnswerDelay(final int time, final boolean answerRight){

        System.out.println("Timer initierad");
         CountDownTimer timer = new CountDownTimer(time, 100){
            //Render text everytime the timer counts down one second
            public void onTick(long mill) {

            }

            //When finished, set the question marked as false and move
            //on to the next question
            public void onFinish() {
                onAfterAnswerDelay(answerRight);


            }
        };
        timer.start();
    }

    protected void timerReset(){
        System.out.println("Resetting timer...");
        timeFunc.start();
    }


    /**
     * Pauses the game for a specified time
     * @param time the specified time
     */
    protected void pauseQuiz(int time)  {
        System.out.println("Pausing");
        timeFunc.cancel();

        //Pauses the thread for (param) milliseconds
        Wait.sec(time);
    }

    /**
     * Processes all of the onClick events, catches a bool, of true it will add to the
     * correct answers in the mode class, otherwise it will remove.
     * If the max level has been reached, the activity QuizFollowup will be called
     * @param ansBool true if the answer was correct false otherwise
     */
    protected void answerEvent(boolean ansBool) {
        timeFunc.cancel();

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

        //Changes the background depending on the level
        if (currentLevel != quiz.getMode().level){
            SharedInterface.updateBackground();
            SharedInterface.getBackground(linearLayout, resources);
        }

        newQuestion();
    }

    public double getPoints(){
        return score.getScore();
    }


    /**
     * Brings up the pause menu when the back button is pressed
     */
    @Override
    public void onBackPressed() {
        timeFunc.cancel();
        Intent intent = new Intent(this, PausedActivity.class);
        startActivity(intent);
    }


    public void onAnswer(boolean isRightAnswer,ButtonHolder pHolder){

        if(isRightAnswer){
            pHolder.setButtonBackground( R.drawable.button_correct);
        }else{
            pHolder.setButtonBackground( R.drawable.button_incorrect);
        }

        timeFunc.cancel();
        initAnswerDelay(1500,isRightAnswer);

    }

    private void onAfterAnswerDelay(final boolean answerRight){
                   resetButtons();
                  answerEvent(answerRight);
    }

    public void resume(){
        newQuestion();
    }
}