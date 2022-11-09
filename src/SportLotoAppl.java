import java.util.Arrays;

public class SportLotoAppl {

	static long mask = 0L;

	public static void main(String[] args) {
		for (int i = 0; i < 6; i++) {
			System.out.print(getUniqueRandomInt(1, 49) + " ");

		}
	}

	/**
	 * Application displays out 6 random numbers from 1 to 49 inclusive number can't
	 * be repeated in a sequence of 6 random numbers no additional collections /
	 * arrays
	 */
	public static int getUniqueRandomInt(int min, int max) {
		int res = 0;
		do {
			res = (int) (min + Math.random() * (max - min + 1));
		} while (BitOperations.getBitValue(mask, res) == 1);
		mask = BitOperations.setBitValue(mask, res, true);
		return res;
	}

}