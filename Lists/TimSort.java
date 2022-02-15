/**
 * This class holds the TimSort algorithm, a blend of both Insertion Sort and Merge Sort.
 * 
 * Description: The algorithm breaks up the list to sort into segments of size 32 (the last 
 * segment may be some size les than 32). Insertion sort is then performed within each of
 * the segments. After each segment has been sorted, merge sort is used to sort all segments,
 * merging them into one large sorted list in non decreasing order.
 */

public class TimSort {

    static final int MIN_BLOCK_SIZE = 32;

    public static void sort(int[] array) {

        // If array is smaller than the min block size, use insertion sort to sort the entire array.
        if (array.length <= MIN_BLOCK_SIZE){
            insertionSortRange(array,0,array.length);

            // Else, break array into sub blocks sort, then merge sort the sub blocks.
        } else {
            
            // Calculate the number of subBlocks in array.
            int subBlocks = array.length / MIN_BLOCK_SIZE;

            // For each subBlock in the array.
            for (int i = 0; i < subBlocks; i++) {

                // Calculate the begin and end indices.
                int begin = i * MIN_BLOCK_SIZE;
                int end   = begin + MIN_BLOCK_SIZE;

                // Pass the array and begin and end indexes into the insertionSort algorithm.
                insertionSortRange(array,begin,end);
            }

            // Call insertion sort algorithm on last elements in the array that are less than a whole subBlock.
            insertionSortRange(array,subBlocks * MIN_BLOCK_SIZE, array.length);

            // FOr each subBlock in the array.
            for (int i = 0; i < subBlocks; i++) {

                // Calculate the end and mid indices.
                int end = i * MIN_BLOCK_SIZE + 2 * MIN_BLOCK_SIZE;
                int mid = end - MIN_BLOCK_SIZE;

                // If the end index is out of range.
                if (end > array.length){

                    // Call mergrSort algorithm on the the array from [left .. mid] and [mid .. array.length].
                    mergeRange(array,0,mid, array.length);
                }else {

                    // Call the mergeSort algorithm on the array from [left .. mid] and [mid .. end].
                    mergeRange(array,0,mid,end);
                }
            }
        }
    }
    /**
     * The insertionSortRange algorithm performs Insertion Sort over a range [left, right] of a larger array (arr).
     * int[] arr The array to be sorted.
     * int left The index of the left end of the array, the left most end to consider for sorting.
     * int right The index of the right end of the array, the right most end to consider for sorting.
     */
    // Insertion sort algorithm modified to sort over the range from left to right in the arr array.
    public static void insertionSortRange(int[] arr, int left, int right){

        for (int i = left + 1; i < right; i++) {
            int current = arr[i];
            int j = i - 1;

            while (j >= left && current < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
    }
    
    /**
     * The mergeRange algorithm performs Merge Sort over a range [left, right] of a larger array (arr).
     * int[] arr The array to be sorted.
     * int left The index of the left end of the array, the left most end to consider for sorting.
     * int mid The mid point of the elements to consider for sorting, demarcating the left and right sides.
     * int right The index of the right end of the array, the right most end to consider for sorting.
     */
    public static void mergeRange(int[] arr, int left, int mid, int right){
        int[] leftArr  = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];

        // Copy elements over into new left and right sub arrays.
        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < (right - mid); i++) {
            rightArr[i] = arr[mid + i];
        }

        // Iterators for the left, right, and arr arrays.
        int leftIter  = 0;
        int rightIter = 0;
        int arrIter   = left;

        // Sort two sorted sub arrays into one array (arr) for the length of either sub array.
        while (leftIter < leftArr.length && rightIter < rightArr.length){
            if (leftArr[leftIter] < rightArr[rightIter]){
                arr[arrIter] = leftArr[leftIter];
                leftIter++;
            }else {
                arr[arrIter] = rightArr[rightIter];
                rightIter++;
            }
            arrIter++;
        }

        // If there are any elements left over in the left sub array, add them to array arr.
        while (leftIter < leftArr.length-1){
            arr[arrIter] = leftArr[leftIter];
            leftIter++;
            arrIter++;
        }

        // If there are any elements left over in the right sub array, add them to array arr.
        while (rightIter < rightArr.length-1){
            arr[arrIter] = rightArr[rightIter];
            rightIter++;
            arrIter++;
        }

    }
}
