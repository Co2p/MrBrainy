package com.mrbrainy.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;


public class BrainGame extends ActionBarActivity {

    protected int pageNumber;
    private int realAns;
    private MathQuiz quiz;
    private TextView qText, pageNr, levelText;
    //AnswerButtons
    private Button alt1, alt2, alt3, alt4, alt5;

    @Override
    //Finds the buttons and saves them in variables
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_game);
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
        if (realAns<1){
            alt1.setText(String.valueOf(quiz.getAnswer()));
            alt2.setText(String.valueOf(quiz.getFalseAns(quiz.getAnswer())));
            alt3.setText(String.valueOf(quiz.getFalseAns(quiz.getAnswer())));
            alt4.setText(String.valueOf((quiz.getAnswer())));
            alt5.setText(String.valueOf((quiz.getAnswer())));
        }
        else if (realAns<2){
            alt1.setText(String.valueOf(quiz.getFalseAns(quiz.getAnswer())));
            alt2.setText(String.valueOf(quiz.getAnswer()));
            alt3.setText(String.valueOf(quiz.getFalseAns(quiz.getAnswer())));
            alt4.setText(String.valueOf(quiz.getFalseAns(quiz.getAnswer())));
            alt5.setText(String.valueOf(quiz.getFalseAns(quiz.getAnswer())));
        }
        else if (realAns<3){
            alt1.setText(String.valueOf(quiz.getFalseAns(quiz.getAnswer())));
            alt2.setText(String.valueOf(quiz.getFalseAns(quiz.getAnswer())));
            alt3.setText(String.valueOf(quiz.getAnswer()));
            alt4.setText(String.valueOf(quiz.getFalseAns(quiz.getAnswer())));
            alt5.setText(String.valueOf(quiz.getFalseAns(quiz.getAnswer())));
        }
        else if (realAns<4){
            alt1.setText(String.valueOf(quiz.getFalseAns(quiz.getAnswer())));
            alt2.setText(String.valueOf(quiz.getFalseAns(quiz.getAnswer())));
            alt3.setText(String.valueOf(quiz.getFalseAns(quiz.getAnswer())));
            alt4.setText(String.valueOf(quiz.getAnswer()));
            alt5.setText(String.valueOf(quiz.getFalseAns(quiz.getAnswer())));
        }
        else if (realAns<5){
            alt1.setText(String.valueOf(quiz.getFalseAns(quiz.getAnswer())));
            alt2.setText(String.valueOf(quiz.getFalseAns(quiz.getAnswer())));
            alt3.setText(String.valueOf(quiz.getFalseAns(quiz.getAnswer())));
            alt4.setText(String.valueOf(quiz.getFalseAns(quiz.getAnswer())));
            alt5.setText(String.valueOf(quiz.getAnswer()));
        }
    }


    public void button1(View v){
        answerEvent(realAns==0);
    }

    public void button2(View v){
        answerEvent(realAns==1);
    }

    public void button3(View v){
        answerEvent(realAns==2);
    }

    public void button4(View v){
        answerEvent(realAns==3);
    }

    public void button5(View v){
        answerEvent(realAns==4);
    }

    private void answerEvent(boolean ansBool) {
        if (ansBool){
            quiz.getMode().add();
        }
        else
            quiz.getMode().remove();

        newQuestion();
    }
}