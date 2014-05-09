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
    private String pageString;
    private String realAnswer;
    private int pageNumber = 1;
    private Mode mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_game);
        mode = new Mode(5, 3, 2);
        String pageString = new String("Question nr: " + pageNumber);
        TextView page = (TextView) findViewById(R.id.pageN);
        page.setText(pageString);

    }


    public void addListenerOnButton(){
        AnswerGroup = (RadioGroup) findViewById(R.id.radioAnswerGroup);
        btnDisplay = (Button) findViewById(R.id.next);
        btnDisplay.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view){
                int selectedId = AnswerGroup.getCheckedRadioButtonId();
                AnswerButton = (RadioButton) findViewById(selectedId);

                if(AnswerButton.equals(realAnswer)){
                    mode.add();
                }
                else
                    mode.remove();

                Toast.makeText(BrainGame.this,
                        AnswerButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    protected void incrementPage(){

    }
}