import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ObjectTests {

	@Test
	@Disabled
	void wrapperTest() {
		Integer a = 10;
		Integer b = 11;
		assertEquals(++a, b);
		Integer c = 200;
		Integer d = 201;
		assertEquals(++c, d);
		assertTrue(a == b);
		assertFalse(c == d);// checks links
		assertTrue(c.equals(d)); // checks the content
	}

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
	void ipV4OctetTest() {
		assertTrue("0".matches(Strings.ipV4Octet()));
		assertTrue("9".matches(Strings.ipV4Octet()));
		assertTrue("11".matches(Strings.ipV4Octet()));
		assertTrue("199".matches(Strings.ipV4Octet()));
		assertTrue("255".matches(Strings.ipV4Octet()));
		assertTrue("247".matches(Strings.ipV4Octet()));
		assertFalse("01".matches(Strings.ipV4Octet()));
		assertFalse("000".matches(Strings.ipV4Octet()));
		assertFalse("00".matches(Strings.ipV4Octet()));
		assertFalse("001".matches(Strings.ipV4Octet()));
		assertFalse("020".matches(Strings.ipV4Octet()));
		assertFalse("256".matches(Strings.ipV4Octet()));
		assertFalse("0256".matches(Strings.ipV4Octet()));

	}

	@Test
	void ipV4Test() {
		assertTrue("0.0.0.0".matches(Strings.ipV4()));
		assertTrue("100.0.0.0".matches(Strings.ipV4()));
		assertTrue("255.255.255.255".matches(Strings.ipV4()));
		assertFalse("01.0.0.0".matches(Strings.ipV4()));
		assertFalse("000.0.0.0".matches(Strings.ipV4()));
		assertFalse("00.0.0.0".matches(Strings.ipV4()));
		assertFalse("001000.0".matches(Strings.ipV4()));
		assertFalse("020.0.0.0.".matches(Strings.ipV4()));
		assertFalse("256.0.0.0".matches(Strings.ipV4()));
	}

}