import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	 * @return index value if number exists otherwise -1 O[N] - search number in
	 *         unsorted array
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
	 * @return the first index value, otherwise (no number in a given array) the
	 *         method should return the same negative value as the Java standard
	 *         Arrays.binarySearch does
	 */
	public static int binarySearchFirstIndex(int arraySorted[], int number) {
		int left = 0;
		int right = arraySorted.length - 1;
		int middle = arraySorted.length / 2;
		while (left <= right && arraySorted[left] != number) {
			if (number <= arraySorted[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (left + right) / 2;
		}
		return left < arraySorted.length && arraySorted[left] == number ? left : -left - 1;
	}

	static public void bubbleSort(int[] array) {
		int unsortedLength = array.length;
		do {
			unsortedLength = moveGreaterRight(array, unsortedLength - 1);
		} while (unsortedLength != 0);
	}

	static private int moveGreaterRight(int[] array, int length) {
		int res = 0;
		for (int i = 0; i < length; i++) {
			if (array[i] > array[i + 1]) {
				res = i + 1;
				swap(array, i, i + 1);
			}
		}
		return res;
	}

	static private void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	/**
	 * @param array - the array is unsorted
	 * @return true if the array is unsorted but only one swap between two numbers
	 *         is required for getting a sorted array
	 */
	public static boolean isOneSwapForSorted(int array[]) {
		int index1 = -1;
		int index2 = -1;
		int length = array.length - 1;
		int equaledCount = 0;
		boolean res = true;
		int i = 0;
		while (i < length && res) {
			if (array[i] > array[i + 1]) {
				if (index1 == -1) {
					index1 = i - equaledCount;
					if (equaledCount > 0) {
						index2 = i + 1;
					}
				} else if (index2 != -1) {
					res = false;
				} else {
					index2 = i + 1;
				}
			} else if (array[i] == array[i + 1]) {
				equaledCount++;
			} else if (array[i] < array[i + 1]) {
				if (equaledCount != 0 && index1 != -1 && index2 == -1 && array[i] < array[index1]) {
					index2 = i;
				}
				equaledCount = 0;
			}
			i++;
		}
		return index1 != -1 && res ? checkIndexes(array, index1, index2) : false;

	}

	private static boolean checkIndexes(int[] array, int index1, int index2) {

		return index2 == -1 ? checkOneIndex(array, index1) : checkTwoIndexes(array, index1, index2);
	}

	private static boolean checkTwoIndexes(int[] array, int index1, int index2) {

		return (index2 == array.length - 1 || array[index1] <= array[index2 + 1]) && array[index2] <= array[index1 + 1]
				&& (index1 == 0 || array[index2] >= array[index1 - 1]);

	}

	private static boolean checkOneIndex(int[] array, int index) {
		return (index == array.length - 2 || array[index] <= array[index + 2])
				&& (index == 0 || array[index + 1] >= array[index - 1]);
	}

	/**
	 * 
	 * @param array of short positive numbers
	 * @param sum
	 * @return true if array contains two numbers sum of which equals a given sum
	 */
	static public boolean isSum2(short[] array, short sum) {
		boolean res = false;
		boolean[] helper = new boolean[sum >= 0 ? + sum + 1 : 0x7fff + 1]; // 1 because it is necessary to make indexing, and indexes with 0, 0x7fff is the max value of short (short = 2 bytes)
		int index = 0;
		while (index < array.length && !res) { // !res = break
			short diff = (short) (sum - array[index]); // because short doesn't have negative values
			if (diff >= 0) {
				if (helper[diff]) {// == true
					res = true;
				} else {
					helper[array[index]] = true;
				}
			}
			index++;
		}
		return res;
	}
}