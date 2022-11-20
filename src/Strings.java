import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Strings {
	/**
	 * @param str1
	 * @param str2
	 * @return true if string2 is anagram of string1:
	 * - the same length 2;
	 * - the same symbols just in different order2
	 * complexity O[N]
	 * two passes
	 */
	public static boolean isAnagram(String str1, String str2) {
		int counter = 0;
		int str1Length = str1.length();
		if (str1 != null && str2 != null && str1Length == str2.length()) {
			int[] arrayOfMarks = new int[Character.MAX_VALUE + 1];
			int symbol1, symbol2;
			for (int i = 0; i < str1Length; i++) {
				symbol1 = str1.charAt(i);
				arrayOfMarks[symbol1]++;
				symbol2 = str2.charAt(i);
				arrayOfMarks[symbol2]--;
				if (symbol1 == symbol2 || (symbol1 != symbol2 && arrayOfMarks[symbol2] == 0)) {
					counter++;
				}
				if (symbol1 != symbol2 && arrayOfMarks[symbol1] == 0) {
					counter++;
				}
			}
		}
		return counter == str1Length;
	}

	/**
	 * @param str contains decimal presentation of a number from Byte.MIN_VALUE to Byte.MAX_VALUE 
	 * (verification in the method is not required).
	 * @return method sorts input array on the place (it returns nothing).
	 * Has complexity O[N]
	 */
	public static void sortStringNumbers(String[] array) {
		int[] arrayOfMarks = new int[(Byte.MAX_VALUE+1)*2];
		int number;
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			number = Integer.parseInt(array[i]);
			arrayOfMarks[number + 128] += 1;
		}
		for (int j = 0; j < arrayOfMarks.length; j++) {
			if (arrayOfMarks[j] != 0) {
				do {
					array[k] = String.valueOf(j - 128);
					arrayOfMarks[j]--;
					k++;
				} while (arrayOfMarks[j] != 0);
			}
		}
	}
}