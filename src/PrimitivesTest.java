import static org.junit.jupiter.api.Assertions.*;

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
		void getBitValueTest() {
			long number = 0x3ab7f5;
			assertEquals(1, BitOperations.getBitValue(number, 5));
			assertEquals(0, BitOperations.getBitValue(number, 11));
			assertEquals(0, BitOperations.getBitValue(number, 1));
			assertEquals(1, BitOperations.getBitValue(number, 2));
			assertEquals(-1, BitOperations.getBitValue(number, -2));
		}

		@Test
		void setBitValueTest() {
			long number = 0x3ab7f5; // 0011 1010 1011 0111 11_1_1 0101
			assertEquals(0x3ab7d5, BitOperations.setBitValue(number, 5, false));
			assertEquals(0x3ab7f5, BitOperations.setBitValue(number, 5, true));
		}

		
		@Test
		void revertBitValueTest() {
			long number = 0x3ab7f5; //001110101011011111_1_10101
			assertEquals(0x3ab7d5, BitOperations.revertBitValue(number, 5));
			assertEquals(0x3ab7f4, BitOperations.revertBitValue(number, 0));

		}

		@Test
		void NewTest() {
			long number = -1;
			assertEquals(1, BitOperations.getBitValue(number, 63));
			number = BitOperations.revertBitValue(number, 63);
			assertEquals(0, BitOperations.getBitValue(number, 63));
		}	
}






