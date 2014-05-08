import java.util.Random;

public class MathQuiz {	
	//Frågan och svaret
	public String qe;
	public int answer;
	Mode mode;
	
	public MathQuiz(){
		mode = new Mode(5, 3, 2);
		easyQ();
	}
	
	public String answer(){
		System.out.print(qe + "\n");
		return ("svaret är: " + answer);
	}
	
	public void generateQuestion()throws Exception{
		switch(mode.getMode()){
			case 1:
				easyQ();
				break;
			case 2:
				throw new Exception("Wow you're clever!");
		}
	}
	
	//Enklaste svårighetsgraden
	private void easyQ(){
		Random randomGenerator = new Random();
		int randInt, q1, q2;
		
		//Olika frågor, t.ex. plus, minus och gånger
		randInt = randomGenerator.nextInt(2);
		
		//Genererar basen till frågorna
		q1 = randomGenerator.nextInt(20) - 10;
		q2 = randomGenerator.nextInt(20) - 10;
		//Frågorna
		switch(randInt){
			//plus
			case 0:
				answer = q1 + q2;
				qe = generateString(q1 + " + " + q2);
				break;
			//minus
			case 1:
				answer = q1 - q2;
				qe = generateString(q1 + " - " + q2);
				break;
			//gånger
			case 2:
				answer = q1 * q2;
				qe = generateString(q1 + " × " + q2);
				break;
		}
		
	}
	
	//Genererar en sträng som en fråga
	private String generateString(String q){
		String ret = "Vad är: " + q + "?";
		return ret;
	}
	
	//Genererar fel svar inom ett spann (spann på 10 och svar på 5 ger mellan 0 och 10)
	public int generateFault(int range){
		Random randomGenerator = new Random();
		int randInt;
		randInt = answer + randomGenerator.nextInt(range) - range/2;
		
		return randInt;
	}
}
