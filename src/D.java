import java.io.*;
import java.util.*;

public class D {
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
//	static BufferedReader stdin = new BufferedReader(new InputStreamReader(new File("src/D.txt")));
	
	static StringTokenizer st = new StringTokenizer("");
    
	public static void main(String[] args) throws Exception {
		int cases = readInt();
		for (int i = 0; i < cases; i++) {
			String correctWord = readMyLine();
			String word0 = readMyLine(); // Does not need prev writen
			
			String word1 = readMyLine();
			String word2 = readMyLine();
			String word3 = readMyLine();
			
			int score0 = findScore(correctWord, word0) - 1;
			int score1 = findScore(correctWord, word1);
			int score2 = findScore(correctWord, word2);
			int score3 = findScore(correctWord, word3);
			
			int suggestionMin = Math.min(score1, Math.min(score2,  score3)); 
			
			System.out.println(Math.min(suggestionMin, score0));
		}
	}

	private static String readMyLine() throws Exception {
		return stdin.readLine();
	}
	
	public static int findScore(String correctWord,String word){
		int i = 0;
		int minLength = Math.min(correctWord.length(), word.length());
		for (; i < minLength; i++) {
			if (correctWord.charAt(i) != word.charAt(i))
				break;
		}
		
		return (correctWord.length() - i) + (word.length() - i) + 1;
	}

	// Read next input-token as string.
	static String readString() throws Exception {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(stdin.readLine());
		}
		return st.nextToken();
	}

	// Read next input-token as integer.
	static int readInt() throws Exception {
		return Integer.parseInt(readMyLine());
	}

	// Read next input-token as double.
	static double readDouble() throws Exception {
		return Double.parseDouble(readMyLine());
	}
}