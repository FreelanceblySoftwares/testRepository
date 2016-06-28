import java.io.*;
class LookAndSay {
	
	private static String findNthTermInLookAndSaySequence(int n) {
		String term = "11";
		int count = 0;
		String []terms = new String[n];
		terms[0] = "1";
		//terms[1] = "11";
		char[] termArray;  //1 11 12
			for(count = 2; count < n; count++) {
				termArray = terms[count - 1].toCharArray();
				terms[count] = generateNextTerm(termArray);
			}
		
		return terms[n - 1];
	}
	
	private static String generateNextTerm(char[] termArray) {
		int digitCounter = 0;
		String nextTerm = "";
		char previousDigit = termArray[0];
		for(int count = 0; count < termArray.length; count++) {
			digitCounter++;
			if(count == termArray.length -2 && termArray[count] == termArray[count+1] ) {
				digitCounter++;
				nextTerm = nextTerm + String.valueOf(digitCounter) + String.valueOf(termArray[count]);
				break;
			}
			if(count <= termArray.length -2) {
				if(termArray[count] != termArray[count + 1]){
					nextTerm = nextTerm + String.valueOf(digitCounter) + String.valueOf(termArray[count]);
					digitCounter = 0;
				}
			} else {
				nextTerm = nextTerm + String.valueOf(digitCounter) + String.valueOf(termArray[count]);
				
			}
			
		} 
		return nextTerm;
	}
	
	public static void main(String []args) {
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
				//Reading the the value of n for which value to be printed in output
				System.out.println("Enter value of N:");
				int n = Integer.parseInt(br.readLine());
				
				System.out.println("Nth term is: " + findNthTermInLookAndSaySequence(n));
			
				
		} catch(IOException exception) {
			exception.printStackTrace();
		}
	}
}