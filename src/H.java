import java.io.*;
import java.util.*;

public class H {
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(
			System.in));
	static StringTokenizer st = new StringTokenizer("");
    
	public static void main(String[] args) throws Exception {
		int cases = readInt();
		for (int i = 0; i < cases; i++) {
			readInt();
			int monthsInYear = readInt();
			
			int currentDayNumber = 0;
			int fridayThirteens = 0;
			
			for (int month = 0; month < monthsInYear; month++) {
				int daysInMonth = readInt();
				
				for (int day = 1; day <= daysInMonth; day++) {
					//System.out.println(day + " " + month + " " + currentDayNumber);
					if (day == 13 && currentDayNumber == 5) {
						fridayThirteens++;
					}

					currentDayNumber++;
					if (currentDayNumber > 6) {
						currentDayNumber = 0;
					}

				}
			}
			
			System.out.println(fridayThirteens);
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