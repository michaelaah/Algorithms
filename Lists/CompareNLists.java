/**
 * This program is written to provide an algorithm to compare N lists of
 * items to each other without duplicating comparisons. For example, with lists
 * A, B, and C, the algorithm below compares (AB), (AC), and (BC), and so on
 * for N lists. Below is the main method where the program begins at run time.
 * NOTE: The CompareNLists class below uses an ArrayList structure to assist with
 * this algorithm.
 */
public class CompareNLists {

    public static void main(String[] args) {

       // Creating 4 integer arrays with the following elements.
        int[] a = {1,2,3,1};
        int[] b = {2,3,1};
        int[] c = {3,1,2};
        int[] d = {1,3,2};

        // Creating an adjacent String array to track the integer array names.
        String[] names = {"A","B","C","D"};

        /* Instantiating a listOfLists ArrayList object and adding each integer
         * array to it.
         */
        ArrayList<int[]> listOfLists = new ArrayList<int[]>();
        listOfLists.add(a);
        listOfLists.add(b);
        listOfLists.add(c);
        listOfLists.add(d);

        /* For loop up to number of items to compare. Retrieve and store
         * a list from the i index in a temporary local variable.
         */
        for (int i = 0; i < listOfLists.size(); i++) {
            int[] temp1 = listOfLists.get(i);

            /* For loop up to the number of items to compare. Retrieve and store
             * a list from the j index (where j = i + 1) in a temporary local variable.
             */
            for (int j = i + 1; j < listOfLists.size(); j++) {
                int[] temp2 = listOfLists.get(j);

                /* For loop up to the number of elements in the i index of
                 * the first array from the listOfLists object.
                 */
                for (int k = 0; k < temp1.length; k++) {

                    /* For loop up to the number of elements in the j index
                     * of the second array from the listOfLists object.
                     */
                    for (int l = 0; l < temp2.length ; l++) {

                        /* Comparison of each element in the k and l index of
                         * i and j lists from the listOfLists object.
                         */
                        if (temp1[k] == temp2[l]){
                            System.out.println("Match found at indicies: ("+ k + ", " + l + ")");
                            System.out.print("Array " + names[i] + ": " + temp1[k] + " Array ");
                            System.out.print(" " + names[j] + ": " + temp2[l]);
                        }
                    }
                }
            }
        }
    }
    
}
