import java.util.Random;

public class MathQuiz {	
	//Fr�gan och svaret
	public String qe;
	public int answer;
	Mode mode;
	
	public MathQuiz(){
		mode = new Mode(5, 3, 2);
		easyQ();
	}
	
	public String answer(){
		System.out.print(qe + "\n");
		return ("svaret �r: " + answer);
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
	
	//Enklaste sv�righetsgraden
	private void easyQ(){
		Random randomGenerator = new Random();
		int randInt, q1, q2;
		
		//Olika fr�gor, t.ex. plus, minus och g�nger
		randInt = randomGenerator.nextInt(2);
		
		//Genererar basen till fr�gorna
		q1 = randomGenerator.nextInt(20) - 10;
		q2 = randomGenerator.nextInt(20) - 10;
		//Fr�gorna
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
			//g�nger
			case 2:
				answer = q1 * q2;
				qe = generateString(q1 + " � " + q2);
				break;
		}
		
	}
	
	//Genererar en str�ng som en fr�ga
	private String generateString(String q){
		String ret = "Vad �r: " + q + "?";
		return ret;
	}
	
	//Genererar fel svar inom ett spann (spann p� 10 och svar p� 5 ger mellan 0 och 10)
	public int generateFault(int range){
		Random randomGenerator = new Random();
		int randInt;
		randInt = answer + randomGenerator.nextInt(range) - range/2;
		
		return randInt;
	}
}
