/**
 * This program is written to provide an algorithm to compare 3 or lists of
 * items to each other without duplicating comparisons. For example, with lists
 * A, B, and C, the algorithm below compares (AB), (AC), and (BC), and so on
 * for N lists. Below is the main method where the program begins at run time.
 * The CompareNLists class below also uses the StoreLists class.
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
        
        int numOfArrays = 4;

        /* Instantiating a StoreLists object and adding each integer array
         * to the object.
         */
        StoreLists lists = new StoreLists(4);
        lists.add(a);
        lists.add(b);
        lists.add(c);
        lists.add(d);

        /* For loop up to number of items to compare. Retrieve and store
         * a list from the i index in a temporary local variable.
         */
        for (int i = 0; i < lists.getSize(); i++) {          
            int[] temp1 = lists.getArray(i);
            
            /* For loop up to the number of items to compare. Retrieve and store
             * a list from the j index (where j = i + 1) in a temporary local variable.
             */
            for (int j = i + 1; j < lists.getSize(); j++) {   
            int[] temp2 = lists.getArray(j);
            
            /* For loop up to the number of elements in the i index of 
             * the first array from the StoreLists object.
             */
                for (int k = 0; k < temp1.length; k++) {   
                    /* For loop up to the number of elements in the j index 
                     * of the second array from the StoreLists object.
                     */
                    for (int l = 0; l < temp2.length ; l++) {
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
