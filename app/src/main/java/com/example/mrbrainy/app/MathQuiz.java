package com.example.mrbrainy.app;

import java.util.Random;


public class MathQuiz {	
	//Frågan och svaret
	private String questionString;
	private int answer;
    private Random randomGenerator = new Random();
	Mode mode;
    private String plus = new String("+");
    private String minus = new String("-");
    private String multiply = new String("*");
    private String divide = new String("÷");

	
	public MathQuiz(){
		mode = new Mode(5, 3, 2);
		easyQ();
	}
	
	public int getAnswer(){
		return answer;
	}

    //Generates a faulty answer within a window
    // (a window that's 10 and answer on 5 returns between 0 and 10)
    public int getFalseAns(int range){
        Random randomGenerator = new Random();
        int randInt;
        randInt = answer + randomGenerator.nextInt(range) - range/2;

        return randInt;
    }
	
	public String generateQuestion()throws Exception{
        String questionString;
		switch(mode.getMode()){
			case 1:
				questionString=easyQ();
                return questionString;
			case 2:
				throw new Exception("Wow you're clever!");
		}
        return "something's wrong";
	}
	
	//Enklaste svårighetsgraden
	private String easyQ(){
        int difficulty = 20;

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
                questionString = qString(var1, plus, var2);
				break;
			//minus
			case 1:
				answer = var1 - var2;
				questionString = qString(var1, minus, var2);

				break;
			//multiplication
			case 2:
				answer = var1 * var2;
				questionString = qString(var1, multiply, var2);
				break;
            case 3:
                answer = var1;
                var3 = var1 * randomGenerator.nextInt(difficulty) - difficulty/2;
                questionString = qString(var3, divide, var2);
		}
        return questionString;
	}

    //Returns the question as a string, if the second variable is negative brackets will
        // be put round it
    private String qString(int var1, String sign, int var2){
        if(var2<0){
            return var1 + sign + "(" + var2 + ")";
        }
        else
            return var1 + sign + var2;
    }

    //Returns the basenumbers for each question
    private int numGen(int difficulty){
        int var = randomGenerator.nextInt(difficulty) - difficulty/2;
        return var;
    }
}
