
public class Numbers {

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
}