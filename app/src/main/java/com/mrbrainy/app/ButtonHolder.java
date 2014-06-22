package com.mrbrainy.app;


import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;


/**
 * Contains a button
 */
public class ButtonHolder implements android.view.View.OnClickListener{

     private Drawable orgColor;
     private Button button;
     private String caption="";
     private boolean isRightAnswer;


    private GameActivity gameLogic;

    public void resetColor(){

        button.setBackground(orgColor);
        button.refreshDrawableState();
    }

    public ButtonHolder(GameActivity pGameLogic,Button button){
        gameLogic = pGameLogic;
        setButton(button);
    }

    public void onClick(View v){


        gameLogic.onAnswer(isRightAnswer,this);
    }



    public void setButtonBackground(int pBackground){
        button.setBackgroundResource(pBackground);
        button.refreshDrawableState();
    }



    private void setButton(Button pButton) {
        this.button = pButton;
        orgColor = button.getBackground();
        button.setText(caption);
        button.setOnClickListener(this);
    }






    public void setCaption(String caption) {
        this.caption = caption;
        if(button!=null){
            button.setText(caption);
        }
    }


    public void setIsRightAnswer(boolean isRightAnswer) {
        this.isRightAnswer = isRightAnswer;
    }
}
