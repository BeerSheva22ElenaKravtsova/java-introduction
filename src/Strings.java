import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Strings {
	/**
	 * @param str1
	 * @param str2
	 * @return true if string2 is anagram of string1: - the same length 2; - the
	 *         same symbols just in different order2 complexity O[N] two passes
	 */
	public static boolean isAnagram(String str1, String str2) {
		boolean res = false;
		if (str1.length() == str2.length()) {
			int[] helper = new int[Byte.MAX_VALUE]; // 127, the condition of the problem is only numbers and letters
			fillHelper(helper, str1);
			res = true;
			int index = 0;
			int length = str1.length();
			while (index < length && res) {
				int indexSymbol = str2.charAt(index); // this is not an array, but a method, so it's better to take it
														// out separately
				if (helper[indexSymbol] == 0) {
					res = false;
				} else {
					helper[indexSymbol]--;
					index++;
				}
			}
		}
		return res;
	}

	private static void fillHelper(int[] helper, String str1) {
		int length = str1.length();
		for (int i = 0; i < length; i++) {
			int index = str1.charAt(i);
			helper[index]++;
		}
	}

	/**
	 * @param str contains decimal presentation of a number from Byte.MIN_VALUE to
	 *            Byte.MAX_VALUE (verification in the method is not required).
	 * @return method sorts input array on the place (it returns nothing). Has
	 *         complexity O[N]
	 */
	public static void sortStringNumbers(String[] array) {
		int offset = Byte.MAX_VALUE + 1;// how much to move
		int[] helper = new int[offset * 2];
		fillHelper(helper, array, offset);
		sortFromHelper(array, helper, offset);
	}

	private static void sortFromHelper(String[] array, int[] helper, int offset) {
		int arrayIndex = 0;
		for (int i = 0; i < helper.length; i++) {
			for (int j = 0; j < helper[i]; j++) {// it can only be entered if i!=0
				array[arrayIndex] = getStringNumberFromIndex(i, offset);
			}
		}
	}

	private static String getStringNumberFromIndex(int index, int offset) {
		int number = index - offset;
		return Integer.toString(number);
	}

	private static void fillHelper(int[] helper, String[] array, int offset) {
		for (int i = 0; i < array.length; i++) {
			int index = getIndexFromStringNumber(array[i], offset);
			helper[index]++;
		}
	}

	private static int getIndexFromStringNumber(String string, int offset) {
		int number = Integer.parseInt(string);
		return number + offset;
	}

	/**
	 * may begin with a small or large letter, or a $ sign may begin with underscore
	 * (but it cannot be the only character) after this can be any characters in any
	 * number
	 * @return
	 */
	public static String javaNameExp() {
		return "([a-zA-Z$][\\w$]*)|(_[\\w$]+)";
	}

	public static String ipV4Octet() {
		return "([0-9]|[1-9][0-9]|[1][0-9]{2}|[2][0-4][0-9]|[2][5][0-5])";
	}

	public static String ipV4() {
		String ipV4 = "";
		for (int i = 0; i < 3; i++) {
			ipV4 += ipV4Octet() + "\\.";
		}
		return ipV4 + ipV4Octet();
	}
}