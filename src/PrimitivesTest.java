// типы данных и переменные int short long float double byte char boolean



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test
	@Disabled // это делает тест неработающим - для проверки руководителем
//	void dataTypeTest() {
//		int b = 10;
//		short a = 20;
//		var h = 20; // var принимает тип int, он определяется по значению, которое мы туда передали
//		char c = 'd'; // 
//		long l = (long) 10.1; //(long) - приведение к типу (обрезает его конец) - называется сделать кастинг
//		byte b1 = (byte) 1000; // max значение 127
//		a = (short) l; // здесь кастинг ничего не изменит, тк и там, и там могут храниться значения, доступные для обоих видов переменных
//		float f = 10.2f; // приведение к типу переменной f
//		int b2 = 0xfffffff1; // 0x значит что будет число в 16-чной системе, информация, которая содержится в этом числе, f = 1111 = 1 байт; ff = 11111111 = 2 байта; у каждого байта есть номер; int = 4 байта = 32 единицы информации (32 бита); итого здесь 4 байта х 2 = 32 байта; то есть это все единицы; х в числе означает что дальше будет ***; отрицательное число означает, что если к нему мы добавляем тоже самое число, только положительное, то будет = 0;
//		assertEquals(-15, b2); //assert - функция "предположить что значения переменных равны", JAVA делает преобразование, если типы разные, преобразует их в тип больший
//	}
		// HW
		// написать 3 метода 
		// 1 - дать значение последней цифры 
		// значение 3 цифры
		// значение 2 цифры
		
		// оператор остаток от деления 
		
		@Test
		@Disabled 
		void operatorsTest() {
//			int a = 10;
//			assertEquals(13, a + 3);
//			assertEquals(1, a % 3);
			int number = 123;
			assertEquals(3, getThirdDigit(number));
			assertEquals(2, getSecondDigit(number));
			assertEquals(1, getFirstDigit(number));
	}

// через остаток от деления
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
	}


