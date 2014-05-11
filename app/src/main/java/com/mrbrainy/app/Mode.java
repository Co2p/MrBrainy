package com.mrbrainy.app;

public class Mode {
	//Difficuly
	private int progress = 0;
	private int maxLevel;
	private int streak;
	private int faultMode = 0;
	private int falseQ;
	public int level = 0;

    //maxLevel decides how many levels there are (starting at 0)
    //streak decides how long a streak needs to be to reach the next level
    //falseQ decides how many mistakes the user kan make before the level is lowered
	public Mode(int newMaxLevel, int newStreak, int newFalseQ){
		maxLevel = newMaxLevel-1;
		streak = newStreak;
		falseQ = newFalseQ;
	}

    //adds to progress until progress == streak, then the level is raised
    // and the mistakes are reset
	public boolean add(){
		faultMode = 0;
		progress++;
		if(progress >= streak){
			progress = 0;
            faultMode = 0;
			if(level < maxLevel){
				level++;
			}
            else
                return true;
		}
        return false;
	}

    //if the user answers wrong the progress is reset, if there have been a falseQ
    //number of mistakes the level is lowered
	public void remove(){
		progress = 0;
        faultMode++;
		if(faultMode >= falseQ && level > 0){
			level--;
		}
	}
	
	public int getMode(){
		return level+1;
	}

    public int getProgress(){
        return progress;
    }

    public int getStepSize(){
        return streak;
    }
}