package telran.text;

import java.util.Arrays;

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
	 * 
	 * @return
	 */
	public static String javaNameExp() {
		return "([a-zA-Z$][\\w$]*)|(_[\\w$]+)";
	}

	public static String ipV4Octet() {
		return "([01]?\\d\\d?|2([0-4]\\d|5[0-5]))";
	}

	public static String ipV4() {
		String octetExp = ipV4Octet();
		return String.format("(%1$s\\.){3}%1$s", octetExp);
	}

	private static String arithmeticExpression() {
		String operatorExp = operator();
		String operandExp = operand();
		return String.format("%1$s(%2$s%1$s)*", operandExp, operatorExp);
	}

	private static String operand() {
		String numberExp = numberExp();
		String variableExp = javaNameExp();
		return String.format("(\\(*(%s|%s)\\)*)", numberExp, variableExp);
	}

	private static String numberExp() {
		return "(\\d+\\.?\\d*|\\.\\d+)";
	}

	public static boolean isArithmeticExpression(String expression) {
		expression = expression.replaceAll("\\s+", "");
		return expression.matches(arithmeticExpression());
	}

	private static String operator() {
		return "([-+*/])";
	}

	/**
	 * @param expession
	 * @param values
	 * @param names     - sorted array - variable names sorted (a,b,c,d)
	 * @return computed value of a given expression or Double.Nan (not a number)
	 */
	public static Double computeArithmenticExpression(String expression, double values[], String names[]) {
		Double res = Double.NaN;
		names = getUpdatedNames(names);
		values = getUpdatedValues(values, names);
		if (isArithmeticExpression(expression) && checkBraces(expression)) {
			expression = expression.replaceAll("[\\s()]+", "");
			String operands[] = expression.split(operator());
			String operators[] = expression.split(operand());
			res = getOperandValue(operands[0], values, names);
			int index = 1;
			while (index < operands.length && !res.isNaN()) {
				double operandValue = getOperandValue(operands[index], values, names);
				res = computeOperation(res, operandValue, operators[index]);
				index++;
			}
		}
		return res;
	}

	private static double[] getUpdatedValues(double[] values, String[] names) {
		if (values == null) {
			values = new double[0];
		}
		if (values.length != names.length) {
			values = Arrays.copyOf(values, names.length);
		}
		return values;
	}

	private static String[] getUpdatedNames(String[] names) {

		return names == null ? new String[0] : names;
	}

	private static Double computeOperation(Double operand1, double operand2, String operator) {
		Double res = Double.NaN;
		if (!Double.isNaN(operand2)) {// if the second operand is not NaN then I perform the action
			switch (operator) {
			case "+":
				res = operand1 + operand2;
				break;
			case "-":
				res = operand1 - operand2;
				break;
			case "*":
				res = operand1 * operand2;
				break;
			case "/":
				res = operand1 / operand2;
				break;
			default:
				res = Double.NaN;// if another operator which we do not have
			}
		}
		return res;
	}

	private static Double getOperandValue(String operand, double[] values, String[] names) {
		Double res = Double.NaN;
		int a;
		if (operand.matches(numberExp())) {
			res = Double.valueOf(operand);
		} else {
			int index = Arrays.binarySearch(names, operand);
			if (index > -1) {
				res = values[index];
			}
		}
		return res;
	}

	public static boolean checkBraces(String expression) {
		int count = 0;
		int index = 0;
		int length = expression.length();
		while (index < length && count > -1) {
			char symb = expression.charAt(index);
			if (symb == '(') {
				count++;
			} else if (symb == ')') {
				count--;
			}
			index++;
		}
		return count == 0;
	}

}