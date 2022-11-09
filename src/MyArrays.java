import java.util.Arrays;

public class MyArrays {

	/**
	 * 
	 * @param array
	 * @param number
	 * @return new array with added at end a given number
	 *
	 */
	public static int[] addsNumber(int[] array, int number) {
		int[] newArray = Arrays.copyOf(array, array.length + 1);
		newArray[newArray.length - 1] = number;
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param index
	 * @return new array with no number at a given index in a given array if index
	 *         does not exist in a given array it returns the same array
	 */
	public static int[] removeNumber(int[] array, int index) {
		int[] res = array;
		if (index >= 0 && index < array.length) {
			res = new int[array.length - 1];
			System.arraycopy(array, 0, res, 0, index);
			System.arraycopy(array, index + 1, res, index, array.length - index - 1);
		}
		return res;
	}

	/**
	 * @param arraySorted
	 * @param number
	 * @return new array with inserted number at an index for keeping array sorted
	 */
	public static int[] insertSorted(int[] arraySorted, int number) {
		int index = Arrays.binarySearch(arraySorted, number);
		int[] res = new int[arraySorted.length + 1];
		if (index < 0) {
			index = -index - 1;
		}
		System.arraycopy(arraySorted, 0, res, 0, index);
		res[index] = number;
		System.arraycopy(arraySorted, index, res, index + 1, arraySorted.length - index);
		return res;
	}
}