package com.example.mrbrainy.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.Queue;
import java.util.Random;


public class BrainGame extends ActionBarActivity {

    private RadioGroup AnswerGroup;
    private RadioButton  AnswerButton;
    private Button btnDisplay;
    private int pageNumber;
    private String questionString;
    private MathQuiz quiz;
    private Queue alternatives;
    private Random altRandomizer;
    //Texts
    private TextView qText, pageNr;
    //AnswerButtons
    private Button alt1, alt2, alt3, alt4, alt5;

    @Override
    //Vad gör den här Gordon?!
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_game);
        quiz = new MathQuiz();
        pageNumber = 1;
        altRandomizer = new Random(42);

        alt1 = (Button) findViewById(R.id.a1);
        alt2 = (Button) findViewById(R.id.a2);
        alt3 = (Button) findViewById(R.id.a3);
        alt4 = (Button) findViewById(R.id.a4);
        alt5 = (Button) findViewById(R.id.a5);

        try {
            newQuestion();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    //Generates a new question and adds it to the display
    protected void newQuestion() throws Exception {
        questionString = quiz.generateQuestion();

        qText = (TextView) findViewById(R.id.question);
        qText.setText("Vad är: " + questionString + "?");

        pageNr = (TextView) findViewById(R.id.questionNumber);
        pageNr.setText("Question " + pageNumber);

        alternatives.add(quiz.getAnswer());

        for (int i=0; i<4; i++) {
            alternatives.add(quiz.getFalseAns(quiz.getAnswer()));
        }



        alt1.setText(quiz.getAnswer());
        alt2.setText(quiz.getFalseAns(quiz.getAnswer()));
        alt3.setText(quiz.getFalseAns(quiz.getAnswer()));
        alt4.setText(quiz.getFalseAns(quiz.getAnswer()));
        alt5.setText(quiz.getFalseAns(quiz.getAnswer()));



    }


    //When the "next" button is pressed the app should determine if the answer is correct
    //If it is mode.add should be called, else mode.remove
    //in both cases the next question needs to be fetched
    public void addListenerOnButton(){


        btnDisplay.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view){
                int selectedId = AnswerGroup.getCheckedRadioButtonId();
                AnswerButton = (RadioButton) findViewById(selectedId);


                if(AnswerButton.equals(null)){
                    return;
                }
                /*if(AnswerButton.equals(realAnswer)){
                    quiz.mode.add();
                }*/
                else
                    quiz.mode.remove();


                Toast.makeText(BrainGame.this,
                        AnswerButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    protected void incrementPage(){

    }
}