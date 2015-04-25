import java.io.*;
import java.util.*;

public class A {
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(
			System.in));
	static StringTokenizer st = new StringTokenizer("");
    
	public static void main(String[] args) throws Exception {
		int cases = readInt();
		for (int i = 0; i < cases; i++) {
			int R = readInt();
			int t = readInt();
			int j = readInt();
			
			System.out.println(Math.PI*t > j ? "Yes" : "No");
		}
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
		return Integer.parseInt(readString());
	}

	// Read next input-token as double.
	static double readDouble() throws Exception {
		return Double.parseDouble(readString());
	}
}