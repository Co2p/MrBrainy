package com.example.mrbrainy.app;

public class Mode {
	//Sv�righetsgraden
	private int mode = 0;
	private int ENHmax;
	private int correctQ;
	private int faultMode = 0;
	private int faultQ;
	public int ENH = 0;
	
	//max är hur många svårighetsgrader det finns (börjar på 0)
	//och qGoal är hur många frågor som behövs besvaras rätt för att
	//det ska gå över till nästa svårighetsgrad
	//falseQ är hur många fel användaren kan svara innan den hoppar tillbaks
	//ett snäpp i svårighetsgraden
	public Mode(int maxLevels, int qGoal, int falseQ){
		ENHmax = maxLevels-1;
		correctQ = qGoal;
		faultQ = falseQ;
	}
	//l�gger till f�r varje korrekt fr�ga, 
	public void add(){
		faultMode = 0;
		mode++;
		if(mode >= correctQ){
			mode = 0;
			if(ENH < ENHmax){
				ENH++;
			}
		}
	}
	//om användaren svarar fel, s�tt antal r�tt svarade fr�gor till 0
	//�ndra �ven s� att om av�ndaren skrivit ett antal fel svar p� raken
	//s� g� bak�t ett steg i sv�righetsgraden
	public void remove(){
		mode = 0;
		if(faultMode >= faultQ && ENH > 0){
			ENH--;
		}
	}
	
	public int getMode(){
		return ENH+1;
	}
}
