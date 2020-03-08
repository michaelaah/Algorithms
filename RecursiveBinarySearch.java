/**
 * Below is an algorithm to perform Binary search on a sorted array of integers.
 * Note: the binary search algorithm is within the BinarySearch method, the
 * main method below contains test cases.
 */
public class RecursiveBinarySearch {

    public static void main(String[] args) {

        // Instantiate an integer array.
        int[] array = new int[100];

        // Filling array with numbers 0 through, and including, 99.
        for (int i = 0; i < array.length ; i++) {
            array[i] = i;
        }

        /*
         * Declaring and assigning the low and high variables to be used
         * with each BinarySearch method call.
         */
        int low = 0;
        int high = array.length;

        /*
         * Several test cases follow below where the element being searched
         * for changes - meaning the target variable is assigned to new values
         * with each BinarySearch method call.
         */
        int target = 0;
        System.out.println(BinarySearch(array,low,high,target));
        System.out.println("Expected: " + (target >= low && target <= array.length -1));

         target = 181;
        System.out.println(BinarySearch(array,low,high,target));
        System.out.println("Expected: " + (target >= low && target <= array.length -1));

        target = 9;
        System.out.println(BinarySearch(array,low,high,target));
        System.out.println("Expected: " + (target >= low && target <= array.length -1));

        target = -12;
        System.out.println(BinarySearch(array,low,high,target));
        System.out.println("Expected: " + (target >= low && target <= array.length -1));

        target = 89;
        System.out.println(BinarySearch(array,low,high,target));
        System.out.println("Expected: " + (target >= low && target <= array.length -1));

        target = 99;
        System.out.println(BinarySearch(array,low,high,target));
        System.out.println("Expected: " + (target >= low && target <= array.length -1));

        target = 100;
        System.out.println(BinarySearch(array,low,high,target));
        System.out.println("Expected: " + (target >= low && target <= array.length -1));

    }

    /**
     * The BinarySearch method searches a sorted integer array and returns 
     * true if the element being searched for is found, else false is returned.
     * @param array The array to perform the search on
     * @param low The lowest index to begin the search from
     * @param high The highest index to begin the search at - typically array.length
     * @param target The element to search for
     * @return true of the element is found within the array, else false
     */
    public static boolean BinarySearch(int[] array, int low, int high, int target){
        if (high >= low){                         // If high is above or equal to low
            int mid = (high + low) / 2;           // Calculate the mid variable

            // If the calculated mid is out of the array's bounds
            if (mid > array.length - 1){ 
                return false;                      // return false
            }
            if (array[mid] == target){  // If the mid of the array equals the target integer
                return true;                       // return true
            }
            if (array[mid] > target){  // If mid of the array is greater than target integer

                // Recursive call with mid entered as the high parameter variable
                return BinarySearch(array,low,--mid,target);    
            } else {            // Else, mid of the array is less than the target integer
                
                // Recursive call with mid entered as the low parameter variable
                return BinarySearch(array,++mid,high,target);
            }
        } else {        // Else, high and low have crossed and the target has not been found
            
            return false;                       // return false
        }
    }
}
