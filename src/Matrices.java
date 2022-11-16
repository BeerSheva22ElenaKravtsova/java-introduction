
public class Matrices {

	public static int[][] createRandomMatrix(int rows, int columns, int minValue, int maxValue) {
		int res[][] = new int[rows][columns];// rows - number of arrays, columns - number of indexes in each
												// array(column)
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				res[i][j] = (int) Numbers.getRandomNumber(minValue, maxValue);
			}
		}
		System.out.println(res.length);
		return res;
	}

// matrix transposition
	static public int[][] transp(int[][] matrix) {
		int[][] res = new int[matrix[0].length][matrix.length];
		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				res[i][j] = matrix[j][i];
			}
		}
		return res;
	}
}