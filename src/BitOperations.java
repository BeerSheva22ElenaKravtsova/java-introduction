
/**
 *right nBit value [0, 63] - в диапазоне 
 * all methods will return - 1 in the case of wrong nBit value
 * @author elena
 *
 */

public class BitOperations {

	// особенность локальной переменной в том что вызываем метод, передаем туда значения, при его вызове локальные переменные булут принимать эти значения
	// метод - единица кода, которая содержит некоторые действия, при этом мы получаем результат и возможно его возвращаем
	// параметры - переменные данной функции
	// операторы есть логические, если битвайс
	
	/**
	 * number - any number
	 * return nBit - number of bit
	 * return value of bit with number nBit
	 *  
	 * @param args
	 */
	
	public static int getBitValue(long number, int nBit) {
		int res = -1;
		if  (checkNbit(nBit)) {
			long mask = 1 << nBit; // это число со всеми битами, которые будут 0, кроме бита с номером nBit
			if ((number & mask) == 0) {//не важно какое значение бита в исходном числе, но если этот бит будет выполнять битвайс опрециб с 0 то рещультат 0
				res = 0;
			} else {
				res = 1;
			}
		}
		return res; // все битовые операции в JAVA разрешены только на целочисленных типах
	}
	
	// метод проверяет значение nBit - это логический оператор
	private static boolean checkNbit(int nBit) {
		// TODO Auto-generated method stub
		return nBit < 64 && nBit > -1;
	}

	/**
	 * 
	 * @param number - any number
	 * @param nBit - bit number
	 * @param b - true for 1 / false for 0
	 * @return new number in which value of bit will have a given value
	 */
	
	
	static public long setBitValue(long number, int nBit, boolean b) {
		//TODO
		return -1;
	}
	
	
	/**
	 * 
	 * @param number - any number
	 * @param nBit - bit number
	 * @return new number in which nBit'h will be replaced (old value 0 new value 1)
	 */
	static public long revertBitValue(long number, int nBit) {
		// TODO
		return -1;
	}

}
