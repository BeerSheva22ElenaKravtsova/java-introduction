
public class SportLotoAppl {

	/**
	 * Application displays out 6 random numbers from 1 to 49 inclusive number can't
	 * be repeated in a sequence of 6 random numbers no additional collections /
	 * arrays
	 */
	public static void main(String[] args) {
		int number, number1, number2, number3, number4, number5;
		do {
			number = getRandomInt(1, 49);
			number1 = getRandomInt(1, 49);
			number2 = getRandomInt(1, 49);
			number3 = getRandomInt(1, 49);
			number4 = getRandomInt(1, 49);
			number5 = getRandomInt(1, 49);
		} while (number == number1 || number == number2 || number == number3 || number == number4 || number == number5
				|| number1 == number2 || number1 == number3 || number1 == number4 || number1 == number5
				|| number2 == number3 || number2 == number4 || number2 == number5 || number3 == number4
				|| number3 == number5 || number4 == number5);
		System.out.println(number + " " + number1 + " " + number2 + " " + number3 + " " + number4 + " " + number5);
	}

	public static int getRandomInt(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}

}

//System.out.print("" + 100 + " " + 200);
//System.out.println();
