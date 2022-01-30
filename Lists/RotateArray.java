public class RotateArray{
  
  public static void rotate(int[] input, int distance){
        int d     = distance;
        int[] top = new int[d];

        for (int i = 0; i < d; i++) {
            top[i] = input[i];
        }

        int diff     = input.length - d;
        int[] bottom = new int[diff];
        int iter     = 0;
    
        for (int i = d; i < input.length; i++) {
            bottom[iter] = input[i];
            iter++;
        }

    
        for (int i = 0; i < diff; i++) {
            input[i] = bottom[i];
        }
    
        iter = 0;
        for (int i = diff; i < diff + d; i++) {
            input[i] = top[iter];
            iter++;
        }
    }
  
}
