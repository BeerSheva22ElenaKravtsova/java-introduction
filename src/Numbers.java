
public class Numbers {

	private static final int N_HAPPY_NUMBERS_DIGITS = 6;

	static public int getNDigits(long number) { // divide by 10 until it 0, if there was a while do - then with the
												// number 1 there would be a number
		int res = 0;
		do {
			number /= 10;
			res++;
		} while (number != 0);
		return res;
	}

	/**
	 * 
	 * @param number
	 * @return true only if number comprises of 6 digits and sum of first 3 digits
	 *         equals the sum of last 3 digits
	 */
	static public boolean isHappyNumber(int number) {
		boolean mark = false;
		if (getNDigits(number) == 6) {
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i < 6; i++) {
				int num = number % 10;
				number /= 10;
				if (i < 3) {
					sum1 += num;
				} else {
					sum2 += num;
				}
			}
			if (sum1 == sum2) {
				mark = true;
			}
		}
		return mark;
	}

//  at classroom:
	static public boolean isHappyNumber1(int number) {
		boolean res = false;
		if (getNDigits(number) == N_HAPPY_NUMBERS_DIGITS) {
			int halfDigits = N_HAPPY_NUMBERS_DIGITS / 2;
			int numberPartDivider = (int) Math.pow(10, halfDigits);
			int sumFirstPart = getSumDigits(number / numberPartDivider);
			res = sumFirstPart == getSumDigits(number % numberPartDivider);

		}
		return res;

	}

	public static int getSumDigits(int number) {
		int res = 0;
		do {
			res += number % 10;
			number /= 10;
		} while (number != 0);
		return res;

	}

//there is a number, from it get an array of digits
	public static int[] getDigits(int number) {
		int res[] = new int[getNDigits(number)]; // on the right in square brackets we define the length, it can be an
													// expression
		for (int i = res.length - 1; i >= 0; i--) { // fill in from right to left, since the last digits in the number
													// are first
			res[i] = number % 10;
			number /= 10;

		}
		return res;
	}

	// there is an array of digits to get a number from it
	// multiply each past result by 10 + the current digit
	public static int getNumberFromDigits(int[] digits) {
		int res = 0;
		for (int i = 0; i < digits.length; i++) { // traversing the array from left to right
			res = res * 10 + digits[i];
		}
		return res;
	}

}
	
	