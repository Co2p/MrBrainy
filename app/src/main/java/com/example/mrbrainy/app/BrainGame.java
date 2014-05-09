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
import android.content.Intent;


public class BrainGame extends ActionBarActivity {

    private RadioGroup AnswerGroup;
    private RadioButton  AnswerButton;
    private Button btnDisplay;
    private int pageNumber;
    private String questionString;
    private MathQuiz quiz;
    private TextView qText;
    private TextView pageNr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_game);
        quiz = new MathQuiz();
        pageNumber = 1;
        try {
            newQuestion();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void newQuestion() throws Exception {

        questionString = quiz.generateQuestion();

        qText = (TextView) findViewById(R.id.question);
        qText.setText(questionString);

        pageNr = (TextView) findViewById(R.id.questionNumber);
        pageNr.setText("Question " + pageNumber);

        quiz.get

    }


    //When the "next" button is pressed the app should determine if the answer is correct
    //If it is mode.add should be called, else mode.remove
    //in both cases the next question needs to be fetched
    public void addListenerOnButton(){
        AnswerGroup = (RadioGroup) findViewById(R.id.radioAnswerGroup);
        btnDisplay = (Button) findViewById(R.id.next);
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