public class MatrixMultiplication {

    public static void main(String[] args) {
        double[][] matrix1 = {{2,3,1},
                             {2,-7,4}};

        double[][] matrix2 = {{3,4,5},
                              {1,1,4},
                              {2,1,4}};

        double[][] result = multiplyMatrices(matrix1,matrix2);
        System.out.println(stringMatrix(result));

    }

    /**
     * The multiplyMatrices function takes two matrices as inputs, checks if
     * they can be multiplied, performs the multiplication if the two matrices
     * are compatible, and returns a matrix containing the result. Else, an
     * exception is thrown.
     * @param matrix1 The first matrix to multiply
     * @param matrix2 The second matrix to multiply
     * @return A matrix containing the result of matrix1 multiplied by matrix2
     */
    public static double [][] multiplyMatrices (double [][] matrix1, double [][] matrix2) {

        // If the number of the rows of matrix1 are equal to the number of columns of matrix2.
        if (matrix1[0].length == matrix2.length){
            
            /* 
            * Instantiate a local matrix variable with the number of rows as the number of rows 
            * of matrix 1 and the number of columns as the number of columns of matrix2. 
            */
            double[][] matrix = new double[matrix1.length][matrix2[0].length];

            /**
            * First for loop set to iterate until the number of rows of matrix1, the second until
            * the number of columns of matrix2, and the third for loop until the number of rows of
            * matrix1.
            */
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix2[0].length; j++) {
                    for (int k = 0; k < matrix1[0].length; k++) {

                        matrix[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }

            // Return the matrix variable to the client.
            return matrix;

            // Else, the number of rows of matrix1 are not equal to the number of columns of matrix2.
        } else {

            // Create and throw the below exception.
            throw new IndexOutOfBoundsException("\nIncompatible matrices" +
                    " for multiplication.\nNumber of rows of the first " +
                    "matrix must be the same as the number of columns of" +
                    " the second matrix.");
        }
    }

    /**
     * The stringMatrix function returns a String representation of a given matrix.
     * @param matrix The matrix to represent as a String
     * @return A String representation of the matrix parameter
     */
    public static String stringMatrix (double[][] matrix){
        String toPrint = "";         // Declare local String variable to append to.
        
        // Double for loop to iterate over the matrix (2D array).
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length ; j++) {
                
                // Format and append each element of the of the matrix to the local variable.
                String element = String.format("%.0f",matrix[i][j]);
                // Append a tab character to the String variable for formatting.
                toPrint += element + "\t";
            }
            // Append a new line character to represent the next row on a new line.
            toPrint += "\n";
        }

        // Return the String variable to the client.
        return toPrint;
    }
}
