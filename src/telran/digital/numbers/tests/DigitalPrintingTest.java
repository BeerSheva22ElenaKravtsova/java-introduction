package telran.digital.numbers.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static telran.digital.numbers.DigitalNumbersPrinting.*;

public class DigitalPrintingTest {

	@Test
	@Disabled
	void lineTest() {
		System.out.println(line(10, 30));
	}

	@Test
	@Disabled
	void verticalLineTest() {
		displayStrings(verticalLine(30, 10, 0));
	}

	@Test
	@Disabled
	void twoVerticalLinesTest() {
		displayStrings(twoVerticalLines(30, 10, 5));
	}
	
	@Test
	@Disabled
	void zeroTest() {
		displayStrings(zero(30, 5, 4));
	}
	
	@Test
	@Disabled
	void oneTest() {
		displayStrings(one(30, 5, 4));
	}
	
	@Test
	@Disabled
	void twoTest() {
		displayStrings(two(30, 7, 7));
	}
	
	@Test
	@Disabled
	void threeTest() {
		displayStrings(three(30, 8, 8));
	}
	
	@Test
	@Disabled
	void fourTest() {
		displayStrings(four(30, 7, 7));
	}
	
	@Test
	@Disabled
	void fiveTest() {
		displayStrings(five(30, 8, 8));
	}
	
	@Test
	@Disabled
	void sixTest() {
		displayStrings(six(30, 7, 7));
	}
	
	@Test
	@Disabled
	void sevenTest() {
		displayStrings(seven(30, 9, 9));
	}
	
	@Test
	@Disabled
	void eigthTest() {
		displayStrings(eigth(30, 8, 8));
	}
	
	@Test
	@Disabled
	void nineTest() {
		displayStrings(nine(30, 7, 7));
	}
	
	@Test
	void displayDigitalNumberTest() {
	displayDigitalNumber(1234567890, 10, 6, 8);
	}
}
