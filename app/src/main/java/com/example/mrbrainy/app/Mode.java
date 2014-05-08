public class Mode {
	//Sv�righetsgraden
	private int mode = 0;
	private int ENHmax;
	private int correctQ;
	private int faultMode = 0;
	private int faultQ;
	public int ENH = 0;
	
	//max �r hur m�nga sv�righetsgrader det finns (b�rjar p� 0)
	//och q �r hur m�nga fr�gor som beh�vs besvaras r�tt f�r att
	//det ska g� �ver till n�sta sv�righetsgrad
	//fq �r hur m�nga fel anv�ndaren kan svara innan den hoppar tillbaks
	//ett sn�pp i sv�righetsgraden
	public Mode(int max, int q, int fq){
		ENHmax = max-1;
		correctQ = q;
		faultQ = fq;
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
	//om anv�ndaren svarar fel, s�tt antal r�tt svarade fr�gor till 0
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
