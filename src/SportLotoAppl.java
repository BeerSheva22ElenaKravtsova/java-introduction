public class SportLotoAppl {

	private static final int MIN = 1;
	private static final int MAX = 49;

	public static void main(String[] args) {
		SportLoto();
	}

	/**
	 * Application displays out 6 random numbers from 1 to 49 inclusive number can't
	 * be repeated in a sequence of 6 random numbers no additional collections /
	 * arrays
	 */
	public static void SportLoto() {
		int number;
		long mask = 0L;
		int counter = 0;
		do {
			number = getRandomInt(MIN, MAX);
			if (BitOperations.getBitValue(mask, number) == 0) {
				mask = BitOperations.setBitValue(mask, number, true);
				counter++;
				System.out.print(number + " ");
			}
		} while (counter < 6);

	}

	public static int getRandomInt(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}
}

//public static void main(String[] args) {
//	int number, number1, number2, number3, number4, number5;
//	do {
//		number = getRandomInt(1, 49);
//		number1 = getRandomInt(1, 49);
//		number2 = getRandomInt(1, 49);
//		number3 = getRandomInt(1, 49);
//		number4 = getRandomInt(1, 49);
//		number5 = getRandomInt(1, 49);
//	} while (number == number1 || number == number2 || number == number3 || number == number4 || number == number5
//			|| number1 == number2 || number1 == number3 || number1 == number4 || number1 == number5
//			|| number2 == number3 || number2 == number4 || number2 == number5 || number3 == number4
//			|| number3 == number5 || number4 == number5);
//	System.out.println(number + " " + number1 + " " + number2 + " " + number3 + " " + number4 + " " + number5);
//}

//System.out.print("" + 100 + " " + 200);
//System.out.println();