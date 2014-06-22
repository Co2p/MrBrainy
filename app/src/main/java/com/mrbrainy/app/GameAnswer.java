package com.mrbrainy.app;

/**
 *
 */
public class GameAnswer {
    private String answer;
    private boolean isRightAnswer;

    public GameAnswer(String pAnswer,boolean pIsRightAnswer){
        answer=pAnswer;
        isRightAnswer=pIsRightAnswer;
    }

    public String getAnswer(){
        return answer;
    }
    public boolean getisRightAnswer(){
        return isRightAnswer;
    }


}
