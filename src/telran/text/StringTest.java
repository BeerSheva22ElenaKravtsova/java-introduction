package telran.text;

import static org.junit.jupiter.api.Assertions.*;

import static telran.text.Strings.*;
import org.junit.jupiter.api.*;

class StringTest {

	@Test
	@Disabled
	void stringTest() {
		String hello = "hello";
		char[] helloAr = hello.toCharArray(); // hello - this is link to Object
		assertEquals('h', helloAr[0]); // constant h = 1st letter in array helloAr
		System.out.println((int) helloAr[0]); // to get int from constant "h"
		System.out.println((char) 104);
		assertEquals(5, hello.length());// check length
	}

	@Test
	void isAnagramTest() {
		String word = "yellow";
		assertTrue(Strings.isAnagram(word, "loweyl"));
		assertTrue(Strings.isAnagram(word, "elolyw"));
		assertTrue(Strings.isAnagram(word, "wolley"));
		assertTrue(Strings.isAnagram(word, "loleyw"));
		assertFalse(Strings.isAnagram(word, ""));
		assertFalse(Strings.isAnagram(word, "yellob"));
		assertFalse(Strings.isAnagram(word, "yello"));
		assertFalse(Strings.isAnagram(word, "yelllo"));
		assertTrue(Strings.isAnagram("yttttoooo", "ooootttty"));
	}

	@Test
	@Disabled
	void sortStringNumbersTest() {
		String[] array1 = { "-1", "1", "2", "118", "-11", "2", "0", "127", "-128" };
		Strings.sortStringNumbers(array1);
		assertArrayEquals(new String[] { "-128", "-11", "-1", "0", "1", "2", "2", "118", "127" }, array1);
	}

	@Test
	void javaVariableTest() {
		assertTrue("java".matches(Strings.javaNameExp()));
		assertFalse("1java".matches(Strings.javaNameExp()));
		assertFalse("_".matches(Strings.javaNameExp()));
		assertTrue("__".matches(Strings.javaNameExp()));
		assertTrue("java_1_2".matches(Strings.javaNameExp()));
		assertTrue("$".matches(Strings.javaNameExp()));
		assertFalse("$ _".matches(Strings.javaNameExp()));

	}

	@Test
	void ipV4TestTrue() {
		assertTrue("1.2.3.4".matches(ipV4()));
		assertTrue("199.249.255.209".matches(ipV4()));
		assertTrue("99.99.99.05".matches(ipV4()));
	}

	@Test
	void ipV4TestFalse() {
		assertFalse("*.19.10.10".matches(ipV4()));
		assertFalse("256.19.10.10".matches(ipV4()));
		assertFalse("300.19.10.10".matches(ipV4()));
		assertFalse("255.19.10".matches(ipV4()));
		assertFalse("255.19.10.10.".matches(ipV4()));
		assertFalse("255.19".matches(ipV4()));
	}

	@Test
	void computeExpressionTest() {
		assertEquals(10.5, computeArithmenticExpression("2 + 2 + 1 * 2 + 0.5", null, null));
		assertTrue(Double.isNaN(computeArithmenticExpression("2 # 2 ++ 10", null, null)));
		assertEquals(10.5,
				computeArithmenticExpression("a + 2 + c * 2 + 0.5", new double[] { 2, 1 }, new String[] { "a", "c" }));
		assertTrue(Double.isNaN(
				computeArithmenticExpression("a + 2 + c * 2 + d23", new double[] { 2, 1 }, new String[] { "a", "c" })));
		assertTrue(Double.isNaN(
				computeArithmenticExpression(")a + 2 + c * 2 + 23", new double[] { 2, 1 }, new String[] { "a", "c" })));
		assertTrue(Double.isNaN(computeArithmenticExpression("a + ((2 + c) * 2 + 23", new double[] { 2, 1 },
				new String[] { "a", "c" })));
		assertTrue(Double.isNaN(
				computeArithmenticExpression("a + 2 + 1c * 2", new double[] { 2, 1 }, new String[] { "a", "c" })));
		assertTrue(Double.isNaN(
				computeArithmenticExpression("a + 2 + c * .", new double[] { 2, 1 }, new String[] { "a", "c" })));
	}

	@Test
	void operandTest() {
		String expression1 = "1.2";
		String expression2 = "1";
		String expression3 = ".2";
		String expression4 = "1.";
		String expression5 = "a";
		assertTrue(expression1.matches(operand()));
		assertTrue(expression2.matches(operand()));
		assertTrue(expression3.matches(operand()));
		assertTrue(expression4.matches(operand()));
		assertTrue(expression5.matches(operand()));
	}

	@Test
	void arithmeticExpressionTest() {
		String expression1 = "1.2";
		String expression2 = "1";
		String expression3 = ".2";
		String expression4 = "1.";
		String expression5 = "a";
		assertTrue(expression1.matches(operand()));
		assertTrue(expression2.matches(operand()));
		assertTrue(expression3.matches(operand()));
		assertTrue(expression4.matches(operand()));
		assertTrue(expression5.matches(operand()));
	}

	@Test
	void getOperandValueTest() {
		double[] values = { 1, 2, 3 };
		String[] names = { "a", "b", "c" };
		assertTrue(Double.isNaN(getOperandValue("z", values, names)));
	}

	@Test
	void checkBracesTest() {
		String a = "1(2)(34)";
		assertTrue(checkBraces(a));
	}
}
