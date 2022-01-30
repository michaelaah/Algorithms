/* This class file contains a method to rotate an array left by 'distance' number of indices. 
 * This rotation is performed within the array parameter.
 */

public class RotateArray{
  
  public static void rotate(int[] input, int distance){
        int d     = distance;
        int[] top = new int[d];

        // Copy elements to be the new right side of the array.
        for (int i = 0; i < d; i++) {
            top[i] = input[i];
        }

        int diff     = input.length - d;
        int[] bottom = new int[diff];
        int iter     = 0;
    
        // Copy elements to be the new left side of the array.
        for (int i = d; i < input.length; i++) {
            bottom[iter] = input[i];
            iter++;
        }

        // Make bottom array the new left side of the input array.
        for (int i = 0; i < diff; i++) {
            input[i] = bottom[i];
        }
    
        iter = 0;
    
        // Make top array the new right side of the input array.
        for (int i = diff; i < diff + d; i++) {
            input[i] = top[iter];
            iter++;
        }
    }
  
}
