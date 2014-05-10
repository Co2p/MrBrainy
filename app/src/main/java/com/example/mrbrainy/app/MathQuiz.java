package com.example.mrbrainy.app;

import java.util.Random;


public class MathQuiz {	
	//Frågan och svaret
	private String questionString;
	private int answer;
	Mode mode;
	
	public MathQuiz(){
		mode = new Mode(5, 3, 2);
		easyQ();
	}
	
	public int getAnswer(){
		return answer;
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
		Random randomGenerator = new Random();
		int randInt, var1, var2;
		
		//Olika fr�gor, t.ex. plus, minus och g�nger
		randInt = randomGenerator.nextInt(2);
		
		//Generates the basenumbers for each question
		var1 = randomGenerator.nextInt(20) - 10;
		var2 = randomGenerator.nextInt(20) - 10;
		//The questions
		switch(randInt){
			//plus
			case 0:
				answer = var1 + var2;

                if(var2<0){
                    questionString = (var1 + "+" + "(" + var2 + ")");
                }
                else
                    questionString = (var1 + " + " + var2);

				break;
			//minus
			case 1:
				answer = var1 - var2;
                if(var2<0){
                    questionString = (var1 + "-" + "(" + var2 + ")");
                }
                else
				    questionString = (var1 + " - " + var2);

				break;
			//multiplication
			case 2:
				answer = var1 * var2;
                if(var2<0){
                    questionString = (var1 + "*" + "(" + var2 + ")");
                }
                else
				    questionString = (var1 + " * " + var2);
				break;
		}
        return questionString;
	}
	
	//Generates a faulty answer within a window
	// (a window that's 10 and answer on 5 returns between 0 and 10)
	public int getFalseAns(int range){
		Random randomGenerator = new Random();
		int randInt;
		randInt = answer + randomGenerator.nextInt(range) - range/2;
		
		return randInt;
	}
}
