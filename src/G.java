import java.io.*;
import java.util.*;

public class G {
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(
			System.in));
	static StringTokenizer st = new StringTokenizer("");
	static int maxIndexedPrime = (int) Math.pow(16, 5);
	static boolean[] notPrimes = new boolean[maxIndexedPrime];
	static HashSet<Integer> primesSet = new HashSet<>();
	static int chances, numberOfPrimes;
	static boolean debug = false;

	public static void main(String[] args) throws Exception {
		calculatePrimes();
		//runTests();
		int cases = readInt();
		for (int i = 0; i < cases; i++) {
			String number = readString();

			int decimal = parseInt(number);
			int binary = parseBinary(number);
			int octal = parseOctal(number);
			int hex = parseHex(number);

			if (debug) {
				System.out.println(String.format(
						"Interperated as %d, %d, %d, %d", decimal, binary,
						octal, hex));
			}

			chances = 0;
			numberOfPrimes = 0;

			addPoints(decimal);
			addPoints(binary);
			addPoints(octal);
			addPoints(hex);

			printOutput(number);
		}
	}

	private static void calculatePrimes() {
		// now search for 1 bit positions
		notPrimes[0] = notPrimes[1] = true;
		for (int i = 2; i * i < maxIndexedPrime; i++)
			if (!notPrimes[i])
				for (int j = i + i; j < maxIndexedPrime; j += i)
					notPrimes[j] = true;

		for (int i = 0; i < maxIndexedPrime; i++) {
			if (!notPrimes[i] && i != 0 && i != 1) {
				primesSet.add(i);
			}
		}
	}

	private static void calculatePrimesBig() {
		// now search for 1 bit positions
		primesSet.clear();
		int numPrimes = (int) Math.pow(16, 10);
		for (int i = 2; i * i < maxIndexedPrime; i++)
			if (!notPrimes[i])
				for (int j = i + i; j < maxIndexedPrime; j += i)
					notPrimes[j] = true;

		for (int i = 0; i < maxIndexedPrime; i++) {
			if (!notPrimes[i] && i != 0 && i != 1) {
				primesSet.add(i);
			}
		}
	}

	private static void runTests() {
		for (int i = 0; i < 1000; i++) {
			if (isLargePrime(i) != (!notPrimes[i]))
				System.out.println(String.format(
						"Wrong at %d: islargeprime is %b, notnotprime is %b.",
						i, isLargePrime(i), !notPrimes[i]));
			// if (isLargePrime(i))
			// System.out.println("Large prime: " + i);
		}
		// System.out.println(primesSet);

	}

	private static void addPoints(int number) {
		if (number != -1) {
			chances++;
			if (isPrime(number)) {
				numberOfPrimes++;
			}
		}
	}

	private static void printOutput(String number) {
		if (chances == 4 && numberOfPrimes == 2) {
			chances = 2;
			numberOfPrimes = 1;
		} else if (chances == numberOfPrimes && chances != 0) {
			chances = numberOfPrimes = 1;
		}
		if (numberOfPrimes == 0)
			chances = 1;

		if (debug) {
			System.out.println(number);
		}
		System.out.println(numberOfPrimes + "/" + chances);
	}

	private static boolean isPrime(int number) {
		if (number < maxIndexedPrime)
			return !notPrimes[number];
		else
			return isLargePrime(number);
	}

	private static boolean isLargePrime(int number) {
		if (number < 2) {
			return false;
		}
		for (int p : primesSet) {
			if (number % p == 0 && number != p) {
				// System.out.println("is large prime? " + number +
				// " no, because " + p);
				return false;
			}
		}
		System.out.println("is large prime" + number);
		return true;
	}

	private static int parseHex(String number) {
		try {
			return Integer.parseInt(number, 16);
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	private static int parseOctal(String number) {
		try {
			return Integer.parseInt(number, 8);
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	private static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	private static int parseBinary(String number) {
		try {
			return Integer.parseInt(number, 2);
		} catch (NumberFormatException e) {
			return -1;
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