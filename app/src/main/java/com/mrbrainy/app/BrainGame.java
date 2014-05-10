package com.mrbrainy.app;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;


public class BrainGame extends ActionBarActivity {

    protected int pageNumber;
    private int realAns;
    private MathQuiz quiz;
    private TextView qText, pageNr, levelText;
    private RelativeLayout relativeLayout;
    private Resources resources;
    //AnswerButtons
    private Button alt1, alt2, alt3, alt4, alt5;

    @Override
    //Finds the buttons and saves them in variables
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_game);
        relativeLayout  = (RelativeLayout) findViewById(R.id.relativeLayout);
        resources = getResources();
        quiz = new MathQuiz();
        pageNumber = 0;

        alt1 = (Button)findViewById(R.id.a1);
        alt2 = (Button)findViewById(R.id.a2);
        alt3 = (Button)findViewById(R.id.a3);
        alt4 = (Button)findViewById(R.id.a4);
        alt5 = (Button)findViewById(R.id.a5);

        newQuestion();
    }

    //Generates a new question and adds it to the display
    protected void newQuestion(){
        pageNumber++;

        String questionString = quiz.generateQuestion();

        //Displays the question
        qText = (TextView) findViewById(R.id.question);
        qText.setText("Vad är: " + questionString + "?");

        //Displays the question number
        pageNr = (TextView) findViewById(R.id.questionNumber);
        pageNr.setText("Question " + pageNumber);

        //Displays the current level
        levelText = (TextView) findViewById(R.id.level);
        levelText.setText("Level " + quiz.getMode().getMode());

        //Randomizes the order of the answers
        Random altRandomizer = new Random();
        realAns = altRandomizer.nextInt(5);

        System.out.println("The answer is button number: " + (realAns+1) );
        setButtonText();

    }

    //Randomizes the order of the answers
    private void setButtonText(){
        //Puts the real answer inte an array and inserts several faulty answers aswell
        ArrayList<String> answers = new ArrayList<String>();

        answers.add(0, String.valueOf(quiz.getAnswer()));

        //Randomize in faulty answers into array
        for(int i = 1; i < 5; i++){
            String fault = String.valueOf(quiz.getFalseAns(quiz.getAnswer()));
            while(answers.contains(fault)){
                fault = String.valueOf(quiz.getFalseAns(quiz.getAnswer()));
            }
            answers.add(i, fault);
        }

        //Shuffle the array
        long seed = System.nanoTime();
        Collections.shuffle(answers, new Random(seed));

        //Insert real answer position
        realAns = answers.indexOf(String.valueOf(quiz.getAnswer()));

        //Insert answers into game
        alt1.setText(answers.get(0));
        alt2.setText(answers.get(1));
        alt3.setText(answers.get(2));
        alt4.setText(answers.get(3));
        alt5.setText(answers.get(4));
    }

    //Catches a onClick event for the button alt1/R.id.a1
    public void button1(View v){
        answerEvent(realAns==0);
    }

    //Catches a onClick event for the button alt2/R.id.a2
    public void button2(View v){
        answerEvent(realAns == 1);
    }

    //Catches a onClick event for the button alt3/R.id.a3
    public void button3(View v){
        answerEvent(realAns == 2);
    }

    //Catches a onClick event for the button alt4/R.id.a4
    public void button4(View v){
        answerEvent(realAns == 3);
    }

    //Catches a onClick event for the button alt5/R.id.a5
    public void button5(View v){
        answerEvent(realAns==4);
    }

    //Processes all of the onClick events, catches a bool, of true it
        //will add to the correct answers in the mode class, otherwise
        // it will remove.
    private void answerEvent(boolean ansBool) {
        boolean newLvl;
        if (ansBool){
            newLvl = quiz.getMode().add();

            /*if (newLvl){

                switch (quiz.getMode().getMode()){

                }
            }*/
        }
        else
            quiz.getMode().remove();

        newQuestion();
    }
}