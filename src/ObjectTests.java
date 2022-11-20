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
	}

	@Test
	void sortStringNumbersTest() {
		String[] array1 = { "-1", "1", "2", "118", "-11", "2", "0", "127", "-128" };
		Strings.sortStringNumbers(array1);
		assertArrayEquals(new String[] { "-128", "-11", "-1", "0", "1", "2", "2", "118", "127" }, array1);			
	}
}