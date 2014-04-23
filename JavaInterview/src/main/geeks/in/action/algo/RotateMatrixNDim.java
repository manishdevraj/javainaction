package geeks.in.action.algo;

/**
 * Rotate matrix left or right
 * 
 * @author manishdevraj
 * 
 */
public class RotateMatrixNDim {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 0, 1, 2 },
				{ 3, 4, 5, 6 } };
		System.out.println("Original matrix:");
		showMatrix(matrix);

		int[][] lMatrix = rotateMatrixLeft(matrix);
		System.out.println("Rotated to left matrix:");
		showMatrix(lMatrix);

		int[][] rMatrix = rotateMatrixRight(matrix);
		System.out.println("Rotated to right matrix:");
		showMatrix(rMatrix);

	}

	private static void showMatrix(int[][] matrix) {
		int w = matrix.length;
		int h = matrix[0].length;
		for (int i = 0; i < h; ++i) {
			System.out.println("");
			for (int j = 0; j < w; ++j) {
				System.out.print(matrix[i][j]);
			}
		}
		System.out.println("");

	}

	public static int[][] rotateMatrixRight(int[][] matrix) {
		/* W and H are already swapped */
		int w = matrix.length;
		int h = matrix[0].length;
		int[][] ret = new int[h][w];
		for (int i = 0; i < h; ++i) {
			for (int j = 0; j < w; ++j) {
				ret[i][j] = matrix[w - j - 1][i];
			}
		}
		return ret;
	}

	public static int[][] rotateMatrixLeft(int[][] matrix) {
		/* W and H are already swapped */
		int w = matrix.length;
		int h = matrix[0].length;
		int[][] ret = new int[h][w];
		for (int i = 0; i < h; ++i) {
			for (int j = 0; j < w; ++j) {
				ret[i][j] = matrix[j][h - i - 1];
			}
		}
		return ret;
	}

}
