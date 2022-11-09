public class IsraelIdentity {

	/**
	 * @param id
	 * @return true if for right id otherwise false 9 digits control sum 
	 * should be multiple of 10 (кратное 10) with no remainder (sum % 10 == 0) 
	 * for even indexes (0, 2, 4, 6, 8) digits as is
	 * for odd indexes (1, 3, 5, 7, 9) digit = digit * 2, if > 9 then sum of inner digits is taken
	 * example, 123456782 => 1 + 4 (2*2) + 3 + 8 (4*2) + 5 + 3(6*2=12=>1+2) + 7 + 7 (8*2=16=>1+6) + 2 = 40 => true
	 */
	public static boolean verify(int id) {
		int ar[] = Numbers.getDigits(id);
		int digit;
		int sum = 0;
		for (int i = 0; i < ar.length; i++) {
			if (i % 2 == 0) {
				sum += ar[i];
			} else {
				digit = ar[i] * 2;
				sum += digit <= 9 ? digit : (Numbers.getSumDigits(digit));
			}
		}
		return sum % 10 == 0;
	}

	/**
	 * @return random of 9 digits matching right Israel id cycle not more than 9
	 *         iterations
	 */
	public static int generateRandomId() {
		int randomInt = SportLotoAppl.getUniqueRandomInt(100000000, 999999999);
		randomInt = (int)(randomInt / 10) * 10;
		while (verify(randomInt) != true) {
			randomInt++;
		}
		return randomInt;
	}
}