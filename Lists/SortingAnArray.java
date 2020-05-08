/**
 * The algorithm below sorts an integer array in ascendig order
 * (where the lowest integer is at the top of the array or in the first index).
 */
public class SortingAnArray {

    public static void main(String[] args) {
        
        // Instantiating and populating an int array.
        int[] array = {6,4,2,5,0,1,3};
      
        // Print out current state of the array to the console.
        System.out.print("Current Array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("\n");

        /* Below is the algorithm that performs the sorting.
         * The sorting algorithm below consists of a nested for loop
         * with the nested for loop having the iterator equal to the
         * first for loop's iterator + 1. (as denoted below, j = i + 1).
         * if the if condition is true, the elements in indexes i and j
         * are switched, else the loop continues to iterate.
         */
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] > array[j]){
                    int tempVar = array[i];
                    array[i] = array[j];
                    array[j] = tempVar;
                }
            }
        }
        
        // Printing out the array after running the sorting algorithm.
        System.out.print("Sorted Array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("\n");

    }
}
