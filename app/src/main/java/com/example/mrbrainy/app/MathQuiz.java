package com.example.mrbrainy.app;

import java.util.Random;


public class MathQuiz {	
	//Frågan och svaret
	private String qe;
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
        String qe;
		switch(mode.getMode()){
			case 1:
				qe=easyQ();
                return qe;
			case 2:
				throw new Exception("Wow you're clever!");
		}
        return "something's wrong";
	}
	
	//Enklaste svårighetsgraden
	private String easyQ(){
		Random randomGenerator = new Random();
		int randInt, q1, q2;
		
		//Olika fr�gor, t.ex. plus, minus och g�nger
		randInt = randomGenerator.nextInt(2);
		
		//Generates the basenumbers for each question
		q1 = randomGenerator.nextInt(20) - 10;
		q2 = randomGenerator.nextInt(20) - 10;
		//The questions
		switch(randInt){
			//plus
			case 0:
				answer = q1 + q2;
				qe = (q1 + " + " + q2);
				break;
			//minus
			case 1:
				answer = q1 - q2;
				qe = (q1 + " - " + q2);
				break;
			//multiplication
			case 2:
				answer = q1 * q2;
				qe = (q1 + " * " + q2);
				break;
		}
        return qe;
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
