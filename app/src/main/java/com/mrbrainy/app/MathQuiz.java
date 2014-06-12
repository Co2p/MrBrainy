package com.mrbrainy.app;

import java.util.Random;


public class MathQuiz {	
	//Frågan och svaret
	private String questionString;
	private int answer;
    private Random randomGenerator = new Random();
	private Mode mode;
    private int difficulty = 20;
    private int level;
    private int questionSign;

    //
	public MathQuiz(int maxL, int streak, int falseQ ){
		mode = new Mode(maxL, streak, falseQ);
        level = maxL;
		questionGen();
	}
	
	public int getAnswer(){
		return answer;
	}

    //Generates a faulty answer within a window
    // (a window that's 10 and answer on 5 returns between 0 and 10)
    //sign, 0 = plus and 1 = minus.
    public int getFalseAns(int ans, boolean sign){
        Random randomGenerator = new Random();
        int range = (Math.abs(ans)/10);
        int randInt;

        if(range<10){
            range=(range+10);
        }

        do {
            randInt = (ans + randomGenerator.nextInt(range) - range / 2);
        }while(randInt==ans);

        //Generates answers with different sign if question contains a minus
        if(sign || ans < 0){
            if(randomGenerator.nextInt(2) == 1) {
                randInt *= -1;
            }
        }
        return randInt;
    }

    public Mode getMode(){return mode;}
	
	public String generateQuestion(){
        String questionString;
        questionString=questionGen();

        if(!(level==mode.getMode())) {
            difficulty = difficulty/2 + difficulty;
            level=mode.getMode();
        }
        return questionString;
	}
	
	//
	private String questionGen(){

		int randInt, var1, var2, var3;

		//Generates a number that decides what mathmatical question to give in the case switch
		randInt = randomGenerator.nextInt(4);
		
		//Generates the basenumbers for each question
        var1 = numGen(difficulty);
        var2 = numGen(difficulty);

		//The questions
		switch(randInt){
			//plus
			case 0:
				answer = var1 + var2;
                questionString = qString(var1, "+", var2);
                questionSign = 0;
				break;
			//minus
			case 1:
				answer = var1 - var2;
				questionString = qString(var1, "-", var2);
                questionSign = 1;
				break;
			//multiply
			case 2:
				answer = var1 * var2;
				questionString = qString(var1, "×", var2);
                questionSign = 2;
				break;
            //divide
            case 3:
                answer = var1;
                do {
                    var2 = (randomGenerator.nextInt(difficulty / 4) - difficulty / 8) + 1;
                }while (var2==0);
                var3 = var1 * var2;
                System.out.println("var 1: " + var1);
                System.out.println("var 2: " + var2);
                System.out.println("var 3: " + var3);
                questionString = qString(var3, "÷", var2);
                questionSign = 3;
		}
        return questionString;
	}

    //Returns the question as a string, if the second variable is negative brackets will
        // be put round it
    private String qString(int var1, String sign, int var2){
        if(var2<0){
            return var1 + " " + sign + " " + "(" + var2 + ")";
        }
        else
            return var1 + " " +  sign + " " + var2;
    }

    //returns what sign the last question had
    public int getSign(){
        return questionSign;
    }

    //Returns the basenumbers for each question
    private int numGen(int difficulty){
        return randomGenerator.nextInt(difficulty) - difficulty/2;
    }
}
