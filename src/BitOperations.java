import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * right nBit value [0, 63] - all methods will return -1 in the case of wrong
 * nBit value
 */

public class BitOperations {

	private static final int N_BITS = 64; // value cannot be changed

	/**
	 * @param number - any number
	 * @param nBit   - number of bit
	 * @return value of bit with number nBit
	 */
	static public int getBitValue(long number, int nBit) {
		int res = -1;
		if (checkNbit(nBit)) {
			long mask = getMask(nBit);
			res = (number & mask) == 0 ? 0 : 1;
		}
		return res;
	}

	private static boolean checkNbit(int nBit) {
		return nBit < N_BITS && nBit > -1;
	}

	static long getMask(int nBit) { // on the left is long, on the right of the assignment operator is an
											// expression int, an operation is performed for int
		return 1L << nBit; // all bits are 0 expect bit with number nBit
	}

	/**
	 * @param number - any number
	 * @param nBit   - bit number
	 * @param value  - true for 1 / false for 0
	 * @return new number in which value of bit will have a given value
	 */
	static public long setBitValue(long number, int nBit, boolean value) {
		long res = -1;
		if (checkNbit(nBit)) {
			long mask = getMask(nBit);
			res = value ? number | mask : number & ~mask; // по умолчанию value = true
		}
		return res;
	}

	/**
	 * @param number - any number
	 * @param nBit   - bit number
	 * @return new number in which nBit'h will be inverted (old value 0 new value 1)
	 */
	static public long invertBitValue(long number, int nBit) {
		return checkNbit(nBit) ? number ^ getMask(nBit) : -1;
	}

//  at classroom:
	static public long invertBitValue1(long number, int nBit) {
		long res = -1;
		if (checkNbit(nBit)) {
			long mask = getMask(nBit);
			res = number ^ mask;
		}
		return res;
	}

	// the function counts the number of insignificant zeros up to the first one
	// (while - loop until the first 1 is encountered)
	static public int leadingZeros(long number) {
		int res = 0;
		int nBit = N_BITS - 1; // =63 (course numbering from 0)
		while (nBit >= 0 && getBitValue(number, nBit) == 0) {
			nBit--; // the same: nBit = nBit -1; nBit -=1
			res++;
		}
		return res;
	}

	// the function counts the number of bits set to 1 (for - we need to go through
	// all the bits)
	static public int onesInNumber(long number) {
		int res = 0;
		for (int i = 0; i < N_BITS; i++) {
			if (getBitValue(number, i) == 1) {
				res++; // the same: res += getBitValue(number, i);
			}
		}
		return res;
	}
}