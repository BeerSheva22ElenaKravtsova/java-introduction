package telran.digital.numbers;

public class DigitalNumbersPrinting {

	private static final String SYMBOL = "*";
	private static final int INTERVAL = 2;

	public static void displayDigitalNumber(int number, int offset, int width, int height) {
		int[] digits = getDigits(number);
		String[] res = getStringDigit(digits[0], offset, width, height);
		for (int i = 1; i < digits.length; i++) {
			res = stringAddition(res, digits[i], INTERVAL, width, height);
		}
		displayStrings(res);
	}

	private static String[] stringAddition(String[] res, int digits, int offset, int width, int height) {
		String[] stringDigit = getStringDigit(digits, offset, width, height);
		for (int j = 0; j < res.length; j++) {
			res[j] += stringDigit[j];
		}
		return res;
	}

	static public int getNDigits(int number) {
		int res = 0;
		do {
			number /= 10;
			res++;
		} while (number != 0);
		return res;
	}

	public static int[] getDigits(int number) {
		int res[] = new int[getNDigits(number)];
		for (int i = res.length - 1; i >= 0; i--) {
			res[i] = number % 10;
			number /= 10;
		}
		return res;
	}

	public static String[] getStringDigit(int number, int offset, int width, int height) {
		String[] res = null;
		switch (number) {
		case 0:
			res = zero(offset, width, height);
			break;
		case 1:
			res = one(offset, width, height);
			break;
		case 2:
			res = two(offset, width, height);
			break;
		case 3:
			res = three(offset, width, height);
			break;
		case 4:
			res = four(offset, width, height);
			break;
		case 5:
			res = five(offset, width, height);
			break;
		case 6:
			res = six(offset, width, height);
			break;
		case 7:
			res = seven(offset, width, height);
			break;
		case 8:
			res = eigth(offset, width, height);
			break;
		case 9:
			res = nine(offset, width, height);
			break;
		default:
			break;
		}
		return res;
	}

	public static void displayStrings(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
	}

	public static String line(int offset, int length) {
		return " ".repeat(offset) + SYMBOL.repeat(length);
	}

	public static String[] verticalLine(int offset, int height, int width) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width);
		}
		return res;
	}

	public static String[] twoVerticalLines(int offset, int width, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 2) + SYMBOL;
		}
		return res;
	}

	public static String[] zero(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] lines = twoVerticalLines(offset, width, height - 2);
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height - 1] = line(offset, width);
		return res;
	}

	public static String[] one(int offset, int width, int height) {
		return verticalLine(offset + width - 1, height, 0);
	}

	public static String[] two(int offset, int width, int height) {
		String[] res = new String[height];
		String line = line(offset, width);
		String[] line1 = verticalLine(offset + width - 1, height / 2 - 1, 0);
		System.arraycopy(line1, 0, res, 1, line1.length);
		String[] line2 = verticalLine(offset, height / 2, width - 1);
		System.arraycopy(line2, 0, res, height / 2, line2.length);
		res[0] = line;
		res[getCenterLineOfDigit(height)] = line;
		res[height - 1] = line;
		return res;
	}

	private static int getCenterLineOfDigit(int height) {
		return height / 2 - ((height - 1) % 2);
	}

	public static String[] three(int offset, int width, int height) {
		String[] res = new String[height];
		String line = line(offset, width);
		String[] line1 = verticalLine(offset + width - 1, height / 2 - 1, 0);
		System.arraycopy(line1, 0, res, 1, line1.length);
		String[] line2 = verticalLine(offset + width - 1, height / 2, 0);
		System.arraycopy(line2, 0, res, height / 2, line2.length);
		res[0] = line;
		res[getCenterLineOfDigit(height)] = line;
		res[height - 1] = line;
		return res;
	}

	public static String[] four(int offset, int width, int height) {
		String[] res = new String[height];
		String[] line1 = twoVerticalLines(offset, width, getCenterLineOfDigit(height));
		System.arraycopy(line1, 0, res, 0, line1.length);
		String[] line2 = verticalLine(offset + width - 1, height / 2, 0);
		System.arraycopy(line2, 0, res, 1 + line1.length, line2.length);
		res[getCenterLineOfDigit(height)] = line(offset, width);
		return res;
	}

	public static String[] five(int offset, int width, int height) {
		String[] res = new String[height];
		String line = line(offset, width);
		String[] line1 = verticalLine(offset, height / 2 - 1, width - 1);
		System.arraycopy(line1, 0, res, 1, line1.length);
		String[] line2 = verticalLine(offset + width - 1, height / 2, 0);
		System.arraycopy(line2, 0, res, height / 2, line2.length);
		res[0] = line;
		res[getCenterLineOfDigit(height)] = line;
		res[height - 1] = line;
		return res;
	}

	public static String[] six(int offset, int width, int height) {
		String[] res = new String[height];
		String line = line(offset, width);
		String[] line1 = verticalLine(offset, height / 2, width - 1);
		System.arraycopy(line1, 0, res, 1, line1.length);
		String[] line2 = twoVerticalLines(offset, width, getCenterLineOfDigit(height));
		System.arraycopy(line2, 0, res, height / 2, line2.length);
		res[0] = line;
		res[getCenterLineOfDigit(height)] = line;
		res[height - 1] = line;
		return res;
	}

	public static String[] seven(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] line1 = verticalLine(offset + width - 1, height - 1, 0);
		System.arraycopy(line1, 0, res, 1, line1.length);
		return res;
	}

	public static String[] eigth(int offset, int width, int height) {
		String[] res = new String[height];
		String line = line(offset, width);
		String[] line1 = twoVerticalLines(offset, width, getCenterLineOfDigit(height));
		System.arraycopy(line1, 0, res, 1, line1.length);
		System.arraycopy(line1, 0, res, height / 2, line1.length);
		res[0] = line;
		res[getCenterLineOfDigit(height)] = line;
		res[height - 1] = line;
		return res;
	}

	public static String[] nine(int offset, int width, int height) {
		String[] res = new String[height];
		String line = line(offset, width);
		String[] line1 = twoVerticalLines(offset, width, getCenterLineOfDigit(height));
		System.arraycopy(line1, 0, res, 1, line1.length);
		String[] line2 = verticalLine(offset + width - 1, height / 2, 0);
		System.arraycopy(line2, 0, res, height / 2, line2.length);
		res[0] = line;
		res[getCenterLineOfDigit(height)] = line;
		res[height - 1] = line;
		return res;
	}
}