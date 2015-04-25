import java.io.*;
import java.util.*;

public class B {
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(
			System.in));
	static StringTokenizer st = new StringTokenizer("");
	static long m = 1000000007;
    
	public static void main(String[] args) throws Exception {
		int cases = readInt();
		for (int i = 0; i < cases; i++) {
			long d = readLong();
			
			long out = 8 * pow9(d-1) % m;
			System.out.println(out);
		}
	}
	
	static long pow9(long d) {
		if (d < 18) {
			return simplepow9(d) % m;
		}
		if (d % 2 == 0) {
			long temp = pow9(d/2);
			return ((temp % m) * (temp % m)) % m; 
		} else {
			long temp = pow9(d/2);
			return (9*(temp % m) * (temp % m)) % m;
		}
	}
	
	static long simplepow9(long d) {
		long a = 1;
		for (long i = 0; i < d; i++) {
			a *= 9;
		}
		return a;
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
	
	static long readLong() throws Exception {
		return Long.parseLong(readString());
	}

	// Read next input-token as double.
	static double readDouble() throws Exception {
		return Double.parseDouble(readString());
	}
}