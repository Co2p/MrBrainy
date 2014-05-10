package com.mrbrainy.app;

public class Mode {
	//Difficuly
	private int mode = 0;
	private int ENHmax;
	private int correctQ;
	private int faultMode = 0;
	private int faultQ;
	public int level = 0;
	
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

	//lägger till för varje korrekt fråga,
	public boolean add(){
		faultMode = 0;
		mode++;
		if(mode >= correctQ){
			mode = 0;
			if(level < ENHmax){
				level++;
                return true;
			}
		}
        return false;
	}

	//om användaren svarar fel, sätt antal rätt svarade frågor till 0
	//ändra även så att om avändaren skrivit ett antal fel svar på raken
	//så gå bakåt ett steg i svårighetsgraden
	public void remove(){
		mode = 0;
		if(faultMode >= faultQ && level > 0){
			level--;
		}
	}
	
	public int getMode(){
		return level+1;
	}

    public int getProgressToNext(){
        return mode;
    }

    public int getStepSize(){
        return correctQ;
    }
}