import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test
	@Disabled
	void dataTypeTest() {
		int b = 10;
		short a = 20;
		var h = 20;
		char c = 'd';
		long l = (long) 10.1;
		byte b1 = (byte) 1000;
		a = (short) l;
		float f = 10.2f;
		int b2 = 0xfffffff1;
		assertEquals(-15, b2);
	}

	@Test
	@Disabled
	void operatorsTest() {
		int a = 10;
		assertEquals(13, a + 3);
		assertEquals(1, a % 3);
		int number = 123;
		assertEquals(3, getThirdDigit(number));
		assertEquals(2, getSecondDigit(number));
		assertEquals(1, getFirstDigit(number));
	}

	private Integer getFirstDigit(int number) {
		number = number / 100;
		int x = number % 10;
		return x;
	}

	private Integer getSecondDigit(int number) {
		number = number / 10;
		int y = number % 10;
		return y;
	}

	private Integer getThirdDigit(int number) {
		int a = number % 10;
		return a;
	}

	@Test
	@Disabled
	void getBitValueTest() {
		long number = 0x3ab7f5;
		assertEquals(1, BitOperations.getBitValue(number, 5));
		assertEquals(0, BitOperations.getBitValue(number, 11));
		assertEquals(0, BitOperations.getBitValue(number, 1));
		assertEquals(1, BitOperations.getBitValue(number, 2));
		assertEquals(-1, BitOperations.getBitValue(number, -2));
	}

	@Test
	@Disabled
	void setBitValueTest() {
		long number = 0x3ab7f5; // 0011 1010 1011 0111 11_1_1 0101
		assertEquals(0x3ab7d5, BitOperations.setBitValue(number, 5, false));
		assertEquals(0x3ab7f5, BitOperations.setBitValue(number, 5, true));
	}

	@Test
	@Disabled
	void revertBitValueTest() {
		long number = 0x3ab7f5; // 001110101011011111_1_10101
		assertEquals(0x3ab7d5, BitOperations.invertBitValue(number, 5));
		assertEquals(0x3ab7f4, BitOperations.invertBitValue(number, 0));
	}

	@Test
	@Disabled
	void NewTest() {
		long number = -1;
		assertEquals(1, BitOperations.getBitValue(number, 63));
		number = BitOperations.invertBitValue(number, 63);
		assertEquals(0, BitOperations.getBitValue(number, 63));
	}

	@Test
	@Disabled
	void getNDigitsTest() {
		assertEquals(6, Numbers.getNDigits(767676));
		assertEquals(6, Numbers.getNDigits(-767676));
		assertEquals(1, Numbers.getNDigits(0));
	}

	@Test
	@Disabled
	void leadingZerosTest() {
		assertEquals(58, BitOperations.leadingZeros(0x3a)); // 111010
		assertEquals(34, BitOperations.leadingZeros(0x3afde567)); // 111010111111011110010101100111
		assertEquals(42, BitOperations.leadingZeros(0x3ab7d5)); // 1110101011011111010101
		assertEquals(42, BitOperations.leadingZeros(0x3ab7f0)); // 1110101011011111110000
		assertEquals(34, BitOperations.leadingZeros(0x3ab7d575)); // 111010101101111101010101110101
	}

	@Test
	@Disabled
	void onesInNumberTest() {
		assertEquals(4, BitOperations.onesInNumber(0x3a)); // 111010
		assertEquals(15, BitOperations.onesInNumber(0x3ab7d5)); // 1110101011011111010101
		assertEquals(15, BitOperations.onesInNumber(0x3ab7e5)); // 1110101011011111100101
		assertEquals(16, BitOperations.onesInNumber(0x3ab7f5)); // 1110101011011111110101
	}

	@Test
	@Disabled
	void isHappyNumberTest() {
		assertTrue(Numbers.isHappyNumber(123321));
		assertTrue(Numbers.isHappyNumber(-123321));
		assertTrue(Numbers.isHappyNumber(758848));
		assertFalse(Numbers.isHappyNumber(957843));
		assertFalse(Numbers.isHappyNumber(9578434));
		assertFalse(Numbers.isHappyNumber(-9578434));
		assertEquals(true, Numbers.isHappyNumber(123321));
		assertEquals(false, Numbers.isHappyNumber(0));
	}

	@Test
	@Disabled
	void isHappyNumberTest1() {
		int expectedTrue = 123321;
		int expectedFalse = 123467;
		assertEquals(true, Numbers.isHappyNumber1(expectedTrue));
		assertEquals(false, Numbers.isHappyNumber1(expectedFalse));
	}

	@Test
	@Disabled
	void getDigitsTest() {
		int expected[] = { 1, 2, 3, 4 };
		assertArrayEquals(expected, Numbers.getDigits(1234));
	}

	@Test
	void getNumberFromDigitsTest() {
		int expectedNumber = 1234;
		assertEquals(expectedNumber, Numbers.getNumberFromDigits(new int[] { 1, 2, 3, 4 }));
	}

	@Test
	void verifyTest() {
		assertTrue(IsraelIdentity.verify(123456782));
		assertTrue(IsraelIdentity.verify(346826100));
		assertFalse(IsraelIdentity.verify(123456783));
	}

	@Test
	void generateRandomIdTest() {
		assertTrue(IsraelIdentity.verify(IsraelIdentity.generateRandomId()));
	}

	@Test
	void addsNumberTest() {
		int expected[] = { 1, 2, 3, 4, 89 };
		assertArrayEquals(expected, MyArrays.addsNumber(new int[] { 1, 2, 3, 4 }, 89));
	}

	@Test
	void removeNumberTest() {
		assertArrayEquals(new int[] { 1, 2, 4 }, MyArrays.removeNumber(new int[] { 1, 2, 3, 4 }, 2));
		assertArrayEquals(new int[] { 1, 2, 3, 4 }, MyArrays.removeNumber(new int[] { 1, 2, 3, 4 }, -2));
		assertArrayEquals(new int[] { 1, 2, 3, 4 }, MyArrays.removeNumber(new int[] { 1, 2, 3, 4 }, 8));
	}

	@Test
	void insertSortedTest() {
		assertArrayEquals(new int[] { 1, 2, 3, 3, 4 }, MyArrays.insertSorted(new int[] { 1, 2, 3, 4 }, 3));
		assertArrayEquals(new int[] { 0, 1, 2, 3, 4 }, MyArrays.insertSorted(new int[] { 1, 2, 3, 4 }, 0));
		assertArrayEquals(new int[] { -100, 1, 2, 3, 4 }, MyArrays.insertSorted(new int[] { 1, 2, 3, 4 }, -100));
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, MyArrays.insertSorted(new int[] { 1, 2, 3, 4 }, 5));
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, MyArrays.insertSorted(new int[] { 1, 2, 4, 5 }, 3));
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, MyArrays.insertSorted(new int[] { 1, 2, 4, 5 }, 3));
	}
}
