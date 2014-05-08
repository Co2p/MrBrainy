public class Mode {
	//Svårighetsgraden
	private int mode = 0;
	private int ENHmax;
	private int correctQ;
	private int faultMode = 0;
	private int faultQ;
	public int ENH = 0;
	
	//max är hur många svårighetsgrader det finns (börjar på 0)
	//och q är hur många frågor som behövs besvaras rätt för att
	//det ska gå över till nästa svårighetsgrad
	//fq är hur många fel användaren kan svara innan den hoppar tillbaks
	//ett snäpp i svårighetsgraden
	public Mode(int max, int q, int fq){
		ENHmax = max-1;
		correctQ = q;
		faultQ = fq;
	}
	//lägger till för varje korrekt fråga, 
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
	//om användaren svarar fel, sätt antal rätt svarade frågor till 0
	//ändra även så att om avändaren skrivit ett antal fel svar på raken
	//så gå bakåt ett steg i svårighetsgraden
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
