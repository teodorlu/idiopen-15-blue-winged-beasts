import java.io.*;
import java.util.*;

public class I {
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(
			System.in));
	static StringTokenizer st = new StringTokenizer("");
    
	public static void main(String[] args) throws Exception {
		int cases = readInt();
		for (int i = 0; i < cases; i++) {
			String line = stdin.readLine();
			String simonSays = "simon says ";
			if (line.startsWith(simonSays)) {
				String cmd = line.substring(simonSays.length());
				System.out.println(cmd);
			} else { 
				System.out.println();
			}
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