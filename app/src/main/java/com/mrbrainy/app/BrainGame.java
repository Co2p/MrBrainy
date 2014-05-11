package com.mrbrainy.app;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;


public class BrainGame extends ActionBarActivity {

    protected int pageNumber;
    private int realAns;
    private MathQuiz quiz;
    private TextView qText, pageNr, levelText;
    private LinearLayout linearLayout;
    private int progressStatus = 0;
    private ProgressBar progress;
    private Resources resources;
    //AnswerButtons
    private Button alt1, alt2, alt3, alt4, alt5;

    //Constructor... creates a relativeLayout variable, resources variable and a new game (quiz)
        //initiates the buttons and the question number.
        //it also launches the first question.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_game);
        linearLayout  = (LinearLayout) findViewById(R.id.linearLayout);
        resources = getResources();

        quiz = new MathQuiz();
        pageNumber = 0;

        progress = (ProgressBar) findViewById(R.id.progressBar);
        progress.setMax(100);

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
        progressStatus = ((quiz.getMode().getProgressToNext()*100)/(quiz.getMode().getStepSize()));
        System.out.println(quiz.getMode().getProgressToNext());
        System.out.println(quiz.getMode().getStepSize());
        System.out.println(progressStatus);
        progress.setProgress(progressStatus);

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

        setButtonText();

    }

    //Randomizes the order of the answers
    private void setButtonText(){
        //Puts the real answer inte an array and inserts several faulty answers aswell
        ArrayList<String> answers = new ArrayList<String>();

        Random altRandomizer = new Random();
        realAns = altRandomizer.nextInt(5);

        System.out.println("The answer is button number: " + (realAns+1) );
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
        //will add to the correct answers in the mode class, otherwise it will remove.
    private void answerEvent(boolean ansBool) {
        Drawable drawable;

        Toast toast;
        CharSequence textRight = "RIGHT!";
        CharSequence textWrong = "Wrong";
        int duration = Toast.LENGTH_SHORT;

        if (ansBool){
            System.out.println("RIGHT ANSWER!");
            quiz.getMode().add();

            toast = Toast.makeText(this, textRight, duration);
            toast.show();

            //Changes the background depending on the level
            switch (quiz.getMode().getMode()){



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
        else {
            quiz.getMode().remove();
            toast = Toast.makeText(this, textWrong, duration);
            toast.show();

            System.out.println("WRONG ANSWER!");
        }
        newQuestion();
    }
}