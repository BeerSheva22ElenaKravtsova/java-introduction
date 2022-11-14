import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
		newArray[array.length] = number;
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
		int[] res = array; // this is a link, so the length may change
		if (index >= 0 && index < array.length) {
			res = new int[array.length - 1];
			System.arraycopy(array, 0, res, 0, index);
			System.arraycopy(array, index + 1, res, index, res.length - index);
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
		if (index < 0) {
			index = -(index + 1);
		}
		return insertAtIndex(arraySorted, number, index);
	}

	private static int[] insertAtIndex(int[] array, int number, int index) {
		int[] res = new int[array.length + 1];
		System.arraycopy(array, 0, res, 0, index);
		res[index] = number;
		System.arraycopy(array, index, res, index + 1, array.length - index);
		return res;
	}

	/**
	 * 
	 * @param arraySorted
	 * @param number
	 * @return index value if number exists otherwise -1 O[N] - search number in unsorted array
	 */

	public static int binarySearch(int arraySorted[], int number) {
		int left = 0;
		int right = arraySorted.length - 1;
		int middle = right / 2;
		while (left <= right && arraySorted[middle] != number) {
			if (number < arraySorted[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (left + right) / 2;
		}
		return left > right ? -1 : middle;
	}

	/**
	 * @param arraySorted
	 * @param number
	 * @return the first index value, otherwise (no number in a given array) the method should return the same negative 
	 * value as the Java standard Arrays.binarySearch does
	 */
	public static int binarySearchFirstIndex(int arraySorted[], int number) {
		int left = 0;
		int right = arraySorted.length - 1;
		int middle = right / 2;
		while (left <= right && !(number == arraySorted[middle] && (number > arraySorted[middle - 1] || middle == 0))) {
			if (number < arraySorted[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (left + right) / 2;

		}
		return left > right ? -middle-1 : middle;
	}
	
	public static int[] bubbleSort(int array[]) {
		if (array != null && isSortedArray(array) == false) {
			for (int i = 0; i < array.length - 1; i++) {
				moveGreaterRight(array, array.length - 1 - i);
			}
		}
		return array;
	}

	private static boolean isSortedArray(int[] array) {
		boolean res = true;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				res = false;
				break;
			}
		}
		return res;
	}

	public static void moveGreaterRight(int[] array, int length) {
		int temp;
		for (int i = 0; i < length; i++) {
			if (array[i] > array[i + 1]) {
				temp = array[i + 1];
				array[i + 1] = array[i];
				array[i] = temp;
			}
		}
	}

	/**
	 * @param array - the array is unsorted
	 * @return true if the array is unsorted but only one swap between two numbers is required for getting a sorted array
	 */
	public static boolean isOneSwapForSorted(int[] array) {
		int counter = 0;
		int firstDigit = 0;
		int SecondDigit = 0;
		int i = 1;
		boolean res = false;
		while (i < array.length && counter < 3) {
			if (array[i - 1] > array[i]) {
				counter++;
				if (firstDigit == 0) {
					firstDigit = i;
				} else {
					SecondDigit = i;
				}
			}
			i++;
		}
		if (counter == 1) {
			if ((firstDigit - 1 == 0) && (array[firstDigit - 1] <= array[firstDigit + 1])) {
				res = true;
			} else if ((firstDigit == array.length - 1) && (array[firstDigit] >= array[firstDigit - 2])) {
				res = true;
			} else if ((array[firstDigit - 1] <= array[firstDigit + 1])
					&& (array[firstDigit] >= array[firstDigit - 2])) {
				res = true;
			}
		}
		if (counter == 2) {
			if ((firstDigit - 1 == 0) && (SecondDigit == array.length - 1)) {
				if ((array[firstDigit - 1] >= array[SecondDigit - 1]) && (array[SecondDigit] <= array[firstDigit])) {
					res = true;
				}
			} else if (firstDigit - 1 == 0) {
				if ((array[firstDigit - 1] >= array[SecondDigit - 1])
						&& (array[firstDigit - 1] <= array[SecondDigit + 1])
						&& (array[SecondDigit] <= array[firstDigit])) {
					res = true;
				}
			} else if (SecondDigit == array.length - 1) {
				if ((array[firstDigit - 1] >= array[SecondDigit - 1]) && (array[SecondDigit] <= array[firstDigit])
						&& (array[SecondDigit] >= array[firstDigit - 2])) {
					res = true;
				}
			} else if ((array[firstDigit - 1] >= array[SecondDigit - 1])
					&& (array[firstDigit - 1] <= array[SecondDigit + 1]) && (array[SecondDigit] <= array[firstDigit])
					&& (array[SecondDigit] >= array[firstDigit - 2])) {
				res = true;
			}
		}
		return res;
	}
}