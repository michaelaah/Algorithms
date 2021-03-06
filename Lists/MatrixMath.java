/**
* The program below displays the algorithms to multiply, add, and subtract two matricies.
* The algorithms to multiply, add, and subtract two matricies are listed as static methods
* below the main method below.
*/
public class MatrixMath {

    public static void main(String[] args) {
        
        // Declaring 2D array variables matrix1 and matrix2 to be multiplied.
        double[][] matrix1 = {{2,3,1},
                             {2,-7,4}};

        double[][] matrix2 = {{3,4,5},
                              {1,1,4},
                              {2,1,4}};
        
        // Declaring 2D array variables matrix3 and matrix4 to be added.
        double[][] matrix3 = {{7,-1},
                              {5,-4}};

        double[][] matrix4 = {{2,5},
                              {4,3}};
        
        // Declaring 2D array variables matrix5 and matrix6 to be subtracted.
        double[][] matrix5 = {{1,4},
                              {10,-4}};

        double[][] matrix6 = {{6,3},
                              {4,-3}};
        
        
        /* Declaring a local variable to call the multiplyMatrices, addMatrices,
         * and subtractMatricies methods, and print the returned matrix values.
         */
        double[][] result = multiplyMatrices(matrix1,matrix2);
        System.out.println(stringMatrix(result));

        double[][] result2 = addMatricies(matrix3,matrix4);
        System.out.println(stringMatrix(result2));
        
        double[][] result3 = subtractMatricies(matrix5,matrix6);
        System.out.println(stringMatrix(result3));
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

        if (matrix1[0].length == matrix2.length){
            double[][] matrix = new double[matrix1.length][matrix2[0].length];

            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix2[0].length; j++) {
                    for (int k = 0; k < matrix1[0].length; k++) {

                        matrix[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }

            return matrix;

        } else {

            throw new IndexOutOfBoundsException("\nIncompatible matrices" +
                    " for multiplication.\nNumber of rows of the first " +
                    "matrix must be the same as the number of columns of" +
                    " the second matrix.");
        }
    }

    /**
     * The addMatricies method takes two matricies as parameters, adds them
     * together, and returns a 2D array (matrix) with the values added. If the
     * two matricies are not compatible to be added an exception is thown.
     * @param matrix1 The first matrix to add to the second
     * @param matrix2 The second matrix to add to the first
     * @return A matrix containing the result of adding matrix1 with matrix2
     */
    public static double [][] addMatricies (double [][] matrix1, double [][] matrix2){

        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length){
            throw new IndexOutOfBoundsException("\nIncompatible matrices" +
                    " for addition.\nNumber of rows and columns of the first "
                    + "matrix must be the same as the number of rows and "
                    + "columns of the second matrix.");
        } else {

            double [][] matrix = new double[matrix1.length][matrix2.length];

            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix2.length; j++) {
                    matrix[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }

            return matrix;
        }
    }
    
    /**
     * The subtractMatricies method takes two matricies as parameters, subtracts
     * them from each other, and returns a 2D array with the values subtracted.
     * @param matrix1 The first matrix to subtract the second
     * @param matrix2 The second matrix to subtract from the first
     * @return A matrix containing the result of subtracting matrix2 from matrix1
     */
    public static double [][] subtractMatricies (double [][] matrix1, double [][] matrix2){

        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length){
            throw new IndexOutOfBoundsException("\nIncompatible matrices" +
                    " for subtraction.\nNumber of rows and columns of the first "
                    + "matrix must be the same as the number of rows and "
                    + "columns of the second matrix.");
        } else {

            double [][] matrix = new double[matrix1.length][matrix2.length];

            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix2.length; j++) {
                    matrix[i][j] = matrix1[i][j] - matrix2[i][j];
                }
            }

            return matrix;
        }
    }

    /**
     * The stringMatrix function returns a String representation of a given matrix.
     * @param matrix The matrix to represent as a String
     * @return A String representation of the matrix parameter
     */
    public static String stringMatrix (double[][] matrix){
        String toPrint = "";
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length ; j++) {
                String element = String.format("%.0f",matrix[i][j]);
                toPrint += element + "\t";
            }
            toPrint += "\n";
        }

        return toPrint;
    }
}
