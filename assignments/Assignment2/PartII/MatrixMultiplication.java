import java.util.*;

class MatrixMultiplication {
	
	public static double[][] multiply(double[][] m1, double[][] m2) {

		int m = m1.length;
		double[][] result = new double[m][m];

		for(int i = 0; i < m; i++){
			for(int j = 0; j < m; j++){
				result[i][j] = 0;
				for(int k = 0; k < m1[0].length; k++){
					result[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		
		return result;
	}
	
    
    public static void main(String[] args) {
    	
    	/* just to show you what will happen:  
    	 
    	double[][] matrix = new double[4][5];
    	for (int i = 0; i< 4; i++) {
    		System.out.println(Arrays.toString(matrix[i]));
    	}
    	
    	*/
    	
    	Scanner input = new Scanner(System.in);
    	System.out.print("Enter two integers spearated by a space for rows and columns: ");
		int m = input.nextInt();
		int n = input.nextInt();

		if(m < 1 || n < 1){
			System.out.println("\nThe row and column values must be greater than zero");
			input.close();
			return;
		}

		// System.out.println("\n" + m + "   " + n);
		double[][] matrixOne = new double[m][n];
		double[][] matrixTwo = new double[n][m];
		double[][] result = new double[m][m];


		for(int i = 0; i < m; i++){ // try with matrix1.length ??
			for(int j = 0; j < n; j++){
				matrixOne[i][j] = Math.random() * 10;
				matrixTwo[j][i] = Math.random() * 10;
			}
		}

		// printing the randomly generated matrices
		System.out.println("Matrix 1: \n");
		for(int i = 0; i < matrixOne.length; i++){ // try with matrix1.length ??
			for(int j = 0; j < matrixOne[0].length; j++){
				System.out.print(matrixOne[i][j] +  "\t");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Matrix 2: \n");
		for(int i = 0; i < matrixTwo.length; i++){ // try with matrix1.length ??
			for(int j = 0; j < matrixTwo[0].length; j++){
				System.out.print(matrixTwo[i][j] +  "\t");
			}
			System.out.println();
		}
		System.out.println();

		result = multiply(matrixOne, matrixTwo);
		System.out.println("Matrix multiplication result: \n");
		for(int i = 0; i < result.length; i++){ 
			for(int j = 0; j < result[0].length; j++){
				System.out.print(result[i][j] +  "\t");
			}
			System.out.println();
		}

		input.close();

		return;


    	
    }
}
