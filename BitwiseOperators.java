// This program demonstrates the functionality of several bitwise operations.

public class BitwiseOperators {

    public static void main(String[] args) {

        int wigit = 42;
        int figit = 29;

        System.out.println("wigit: " + wigit);
        System.out.println("figit: " + figit);

        // Binary Representation
        // 42 = 0010 1010
        // 29 = 0001 1101

        System.out.println("wigit in binary: " + Integer.toBinaryString(wigit));
        System.out.println("figit in binary: " + Integer.toBinaryString(figit));

        int and = wigit & figit;
        System.out.println("And: " + and);
        // Expecting 0000 1000 = 2^3 = 8

        int or = wigit | figit;
        System.out.println("Or: " + or);
        // Expecting 0011 1111 = 2^5 + 2^4 + 2^3 + 2^2 + 2^1 + 2^0 = 63

        int xOr = wigit ^ figit;
        System.out.println("Xor: " + xOr);
        // Expecting 0011 0111 = 2^5 + 2^4 + + 2^2 + 2^1 + 2^0 = 55

        int oneComp = ~ wigit;
        System.out.println("Ones Compliment: " + oneComp);
        // Expecting 0010 1011 = 2^5 + 2^3 + 2^1 + 2^0 = -43

        int leftShift = wigit << 3;  // 3 represents the number of bits you want to shift left
        System.out.println("Left Shift: " + leftShift);
        // Expecting 0001 0101 0000 = 2^8 + 2^6 + 2^4 = 336
        
        int rightShit = wigit >> 2; // 2 represents the number of bits you want to shift right
        System.out.println("Right Shift: " + rightShit);
        // Expecting 0000 1010 = 2^3 + 2^1 = 10
    }
}
