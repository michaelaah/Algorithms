/**
 * This class provides helpful methods for getting prime numbers and testing
 * if a given number is prime. Note: prime numbers are integers greater than
 * one with no positive divisors besides one and itself.
 */
import java.util.ArrayList;

public class PrimeCalculator {

  // Class variable
  private int primeNum;

  /**
   * Constructor allowing the client to begin the object with a number already
   * stored in the instance variable.
   * @param initial The number to assign the instance variable to
   */
  public PrimeCalculator(int initial){
    this.primeNum = initial;
  }

  /**
   * No argument constructor. Initializes the instance variable to zero.
   */
  public PrimeCalculator(){
    this.primeNum = 0;
  }

  /**
   * Calculates the next prime number that is greater than the object's
   * instance variable.
   * @return The next larger prime number.
   */
  public int getNextPrime(){
    if (this.primeNum == 0 || this.primeNum == 1){
      this.primeNum++;
      if (this.primeNum == 1){
        this.primeNum++;
      }
      return this.primeNum;
    }
    this.primeNum++;
    if (isPrime(this.primeNum)){
      return this.primeNum;
    } else {
      while (! isPrime(this.primeNum)){
        this.primeNum++;
      }
      return this.primeNum;
    }
  }

  /**
   * Calculates and returns the next higher prime number based on a starting
   * number n.
   * @param n The beginning number to get the next higher prime number to.
   * @return The next higher prime number.
   */
  public int getNextHigherPrime(int n){
    if (n < 0){
      n = 0;
    }
    if (isPrime(n)){
      n++;
      if (n == 1){
        n++;
      }
    }
    while (! isPrime(n)){
      n++;
    }
    return n;
  }

  /**
   * Tests if a given number n is prime or not.
   * @param n The number to test if it is prime or not
   * @return True if the number is prime
   */
  public boolean isPrime(int n){
    if (n < 0){
      return false;
    }
    for (int i = 2; i < n; i++){
      if (n % i == 0){
        return false;
      }
    }
    return true;
  }

  /**
   * The getListOfPrimes method fills and returns a list of n prime numbers.
   * @param n The number of prime numbers the client wishes to retrieve
   * @return An ArrayList of prime numbers
   */
  public ArrayList<Integer> getListOfPrimes(int n){
    ArrayList<Integer> listOfPrimes = new ArrayList<Integer>();
    PrimeCalculator pNumber = new PrimeCalculator();
    while (n > 0){
      int number = pNumber.getNextPrime();
      if (isPrime(number)){
        listOfPrimes.add(number);
        n--;
      }
    }

    return listOfPrimes;
  }
  
  
  public ArrayList<Integer> getPrimeFactors(int num){
    ArrayList<Integer> primeList = new ArrayList<Integer>();
    if (isPrime(num)){
      primeList.add(num);
      primeList.add(1);
      
      return primeList;
      
    } else {
      getFactors(primeList,num);
      
      return primeList;
    }
  }
  
  
  private void getFactors(ArrayList<Integer> primeList, int num) {
    if (isPrime(num)) {
      primeList.add(num);
      
    } else {
      int divisor = 2;
      if (num % divisor == 0) {
        int quotient = num / divisor;
        primeList.add(divisor);
        getFactors(primeList, quotient);
        
      } else {
        while (num % divisor != 0) {
          divisor++;
        }
        
        int quotient = num / divisor;
        primeList.add(divisor);
        if (! isPrime(quotient)){
          getFactors(primeList,quotient);
          
        } else {
          if (isPrime(quotient)) {
            primeList.add(quotient);
          }
        }
      }
    }
  }

}
