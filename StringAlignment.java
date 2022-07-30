public class StringAlignment{

  public static void main(String[] args) {

        // Example Strings S and T.
        String str1 = "AGATACATCA";
        String str2 = "GATTAGATACAT";

        // The size of each String plus one.
        int lengthN = str1.length() + 1;
        int lengthM = str2.length() + 1;

        // Declaring a matrix to store the values while computing string alignment.
        int[][] strMatrix = new int[lengthN][lengthM];

        String[][] top     = new String[lengthN][lengthM];
        String [][] bottom = new String[lengthN][lengthM];

        // Starting Position is 2 empty strings.
        top[0][0] = "";
        bottom[0][0] = "";

        // For the first column of the matrix, insert i into [i][0].
        for (int i = 1; i < lengthN; i++) {
            strMatrix[i][0] = i;
            top[i][0] = top[i-1][0] + str1.charAt(i-1);
            bottom[i][0] = "-" + bottom[i-1][0];
        }

        // For the first row of the matrix, insert i into [0][i].
        for (int i = 1; i < lengthM; i++) {
            strMatrix[0][i] = i;
            top[0][i] = "-" + top[0][i-1];
            bottom[0][i] = bottom[0][i-1] + str2.charAt(i-1);
        }

        // Set the initial band to be the minimum of the lengths of the two strings to be aligned.
        int band = Math.min(str1.length(), str2.length());

        // From 1 up to the length of String 1.
        for (int i = 1; i < lengthN; i++) {

            // Calculate the outerBand variable here as the length of this row minus the current band.
            int outerBand = strMatrix[i].length - band;

            // From 1 up to the length of String 2.
            for (int j = 1; j < lengthM; j++) {

                // Calling and storing the value of the compareStr function.
                int compared = compareStr(str1, i - 1, str2, j - 1);

                // Storing the values from the matrix in these three variables.
                int leftSide = strMatrix[i][j-1] + 1;
                int topSide  = strMatrix[i-1][j] + 1;
                int diagonal = strMatrix[i-1][j-1] + compared;

                // Index (i,j) in the matrix is equal to the returned minimum of these three values.
                strMatrix[i][j] = min(leftSide, topSide, diagonal);

                // CHANGE HERE:
                /*
                 * If i minus j is within the band and if j minus i is within the outerBand, then enter the if statement
                 * and determine the appropriate values to be stored in top and bottom.
                 */
                if(i - j < band  && j - i < outerBand){

                    // CHANGE HERE:
                    /*
                     * If i or j minus the band is less than or equal to the band, update the band value.
                     * This band value should only be updated when traversing through the matrix within
                     * the prior calculated band.
                     */
                    if(i - band <= band || j - band <= band){
                        band = strMatrix[i][j];
                    }

                    /*
                     * Determining which location was a match with strMatrix[i][j] and then moving the corresponding
                     * String value from top and bottom into that [i][j] position.
                     */
                    if (strMatrix[i][j] == diagonal) {
                        top[i][j] = top[i - 1][j - 1] + str1.charAt(i - 1);
                        bottom[i][j] = bottom[i - 1][j - 1] + str2.charAt(j - 1);
                    } else {
                        if (strMatrix[i][j] == leftSide) {
                            top[i][j] = top[i][j - 1] + "-";
                            bottom[i][j] = bottom[i][j - 1] + str2.charAt(j - 1);
                        } else {
                            top[i][j] = top[i - 1][j] + str1.charAt(i - 1);
                            bottom[i][j] = bottom[i - 1][j] + "-";
                        }
                    }

                }

            }
        }

        // Print the two aligned strings to the console.
        // The optimal alignment is in the bottom rightmost index of the two dimensional matrices.
        System.out.println(top[lengthN -1][lengthM -1]);
        System.out.println(bottom[lengthN -1][lengthM -1]);

        System.out.println("\n" + stringMtx(strMatrix));

    }

    /**
     * The compareStr function takes 2 strings and 2 integers as parameters, compares the character in string 1 at index
     * with the character in string 2 at index b. If the characters are the same 0 is returned, otherwise 1 is returned.
     * @param str1 The first string to compare a character from
     * @param a The index of the character in string 1 to be compared
     * @param str2 The second string to compare a character from
     * @param b The index of the character in string 2 to be compared
     * @return If the characters are the same 0 is returned, otherwise 1 is returned.
     */
    static int compareStr(String str1, int a, String str2, int b) {

        // If a is within bounds of str1 and b is within bounds of str2.
        if (a >= 0 && a < str1.length() && b >= 0 && b < str2.length()) {

            // If the character at index a in str1 equals the character at index b in str2.
            if(str1.charAt(a) == str2.charAt(b)) {
                return 0;

                // Otherwise the character at index a in str1 does not equal the character at index b in str2.
            } else {
                return 1;
            }

            // Else a is not within bounds of str1 or b is not within bounds of str2.
        } else {

            // Return the smallest integer value.
            return Integer.MIN_VALUE;
        }

    }

    /**
     * The min function finds the minimum between the three integer parameters and returns that minimum integer.
     * @param a integer to be compared to find the minimum
     * @param b integer to be compared to find the minimum
     * @param c integer to be compared to find the minimum
     * @return The minimum value among the three integer parameters
     */
    public static int min(int a, int b, int c) {

        // return the Math.min value of the three parameters.
        return Math.min(Math.min(a,b),c);
    }


    /**
     * The stringMtx generates and returns a String representation of the matrix parameter.
     * @param mtx The matrix to compute a String representation of.
     * @return A String representing the matrix parameter.
     */
    public static String stringMtx(int[][] mtx){
        String result = "";

        for (int i = 0; i < mtx.length; i++) {
            for (int j = 0; j < mtx[0].length; j++) {
                result += String.format("%-" + 4 + "s", mtx[i][j]);
            }
            result += "\n";
        }

        return result;
    }

}
