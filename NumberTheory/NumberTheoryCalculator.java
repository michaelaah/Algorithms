/**
 * This class provides methods for finding the quotient, remainder, and prime
 * factors of a given number and for finding the LCM, GCD, and the Bezout identity
 * of a given 2 numbers.
 */

import java.util.ArrayList;

public class NumberTheoryCalculator {

  // Constructor
  public NumberTheoryCalculator(){}


  /**
   * The getPrimeFactors method returns a list of prime factors for a given
   * parameter variable.
   * @param num The number to get the prime factors of
   * @return An ArrayList of prime factors
   */
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

  /**
   * The getFactors method fills a parameter ArrayList variable with the
   * prime factors of the given int parameter variable.
   * @param primeList The list to add the prime factors to
   * @param num The integer to find the prime factors of
   */
  private void getFactors(ArrayList<Integer> primeList, int num) {
    if (isPrime(num)) {
      primeList.add(num);

    } else {
      int divisor = 2;
      if (num % divisor == 0) {
        int quotient = num / divisor;
        primeList.add(divisor);
        getFactors(primeList,quotient);

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
   * The getLCM method returns the LCM of two parameter variables.
   * @param a The first number to get the LCM of
   * @param b The second number to get the LCM of
   * @return The LCM of the two parameter integers
   */
  public int getLCM(int a, int b){
    ArrayList<Integer> aList = getPrimeFactors(a);
    ArrayList<Integer> bList = getPrimeFactors(b);

    ArrayList<Exponential> aExpoList = getExponentialList(aList);
    ArrayList<Exponential> bExpoList = getExponentialList(bList);

    ArrayList<Exponential> LCMlist = buildLCMList(aExpoList,bExpoList);
    int lcm = 1;
    for (int i = 0; i < LCMlist.size(); i++) {
      lcm *= LCMlist.get(i).getValue();

    }

    return lcm;
  }

  /**
   * The getGCD method returns the GCD of two parameter variables.
   * @param a The first number to get the GCD of
   * @param b The second number to get the GCD of
   * @return The GCD of the two parameter integers
   */
  public int getGCD(int a, int b){
    ArrayList<Integer> aList = getPrimeFactors(a);
    ArrayList<Integer> bList = getPrimeFactors(b);

    ArrayList<Exponential> aExpoList = getExponentialList(aList);
    ArrayList<Exponential> bExpoList = getExponentialList(bList);

    ArrayList<Exponential> GCDList = buildGCDList(aExpoList,bExpoList);
    int gcd = 1;
    for (int i = 0; i < GCDList.size(); i++) {
      gcd *= GCDList.get(i).getValue();

    }

    return gcd;

  }

  /**
   * The getLCMList method returns a list denoting the prime factors of the
   * LCM of two integer parameters.
   * @param a The first number to get the lCM of.
   * @param b The second number to get the LCM of.
   * @return An ArrayList of Exponential objects of the LCM in prime factor form.
   */
  public ArrayList<Exponential> getLCMList(int a, int b){
    ArrayList<Integer> aList = getPrimeFactors(a);
    ArrayList<Integer> bList = getPrimeFactors(b);

    ArrayList<Exponential> aExpoList = getExponentialList(aList);
    ArrayList<Exponential> bExpoList = getExponentialList(bList);

     return buildLCMList(aExpoList,bExpoList);
  }

  /**
   * The getGCDList method takes two integer parameters and calls the buildGCD list
   * method after passing the prime factor lists associated with these two integer 
   * parameters.
   * @param a The first integer to find the GCD of
   * @param b The second integer to find the GCD of
   * @return An Exponential ArrayList object representation of the GCD
   */
  public ArrayList<Exponential> getGCDList(int a, int b){
    ArrayList<Integer> aList = getPrimeFactors(a);
    ArrayList<Integer> bList = getPrimeFactors(b);

    ArrayList<Exponential> aExpoList = getExponentialList(aList);
    ArrayList<Exponential> bExpoList = getExponentialList(bList);

    return buildGCDList(aExpoList,bExpoList);
  }



  /**
   * The removeTHeDuplicate method removes all instances of the integer parameter
   * variable from the arrayList object.
   * @param arrayList The arrayList to remove the duplicates from.
   * @param a The number to remove all duplicates of in the arrayList.
   */
  public void removeTheDuplicate(ArrayList<Integer> arrayList, int a){

    arrayList.removeIf(number -> number == a);
  }

  /**
   * The getExponentialList method returns an exponential representation of the
   * list given as input.
   * @param arrayList The list to represent the numbers in their exponential form
   * @return A list of numbers in their exponential form
   */
  public ArrayList<Exponential> getExponentialList(ArrayList<Integer> arrayList){
    ArrayList<Exponential> expoList = new ArrayList<Exponential>();

    int size = arrayList.size();
    while (size > 0){
      Exponential expo = getExpo(arrayList);
      expoList.add(expo);
      removeTheDuplicate(arrayList,arrayList.get(0));
      size = arrayList.size();
    }

    return expoList;
  }

  /**
   * The getExpo method takes an ArrayList of integers are returns an Exponential
   * object representation of the first element in the ArrayList.
   * @param arrayList The arrayList to get the exponential form of for the first
   *                  element.
   * @return The Exponential objet representation of an integer.
   */
  private Exponential getExpo (ArrayList<Integer> arrayList){
    int number = arrayList.get(0);
    int count = 1;
    for (int i = 1; i < arrayList.size(); i++) {
      if (arrayList.get(i) == number){
        count++;
      }
    }

    Exponential expo = new Exponential(number,count);

    return expo;
  }

  /**
   * The buildLCMList method takes two Exponential ArrayLists and builds an
   * Exponential ArrayList that contains the exponential representations of the prime
   * factors of the LCM.
   * @param list1 The first list of prime factors to find the LCM for
   * @param list2 The second list of prime factors to find the LCM for
   * @return A list of prime factors in exponential form
   */
  private ArrayList<Exponential> buildLCMList(ArrayList<Exponential> list1,
                                              ArrayList<Exponential> list2){

    ArrayList<Exponential> expoList = new ArrayList<Exponential>();
    ArrayList<Exponential> biggerList = null;
    ArrayList<Exponential> smallerList = null;

    if (list1.size() >= list2.size()){
      biggerList = list1;
      smallerList = list2;
    } else {
      biggerList = list2;
      smallerList = list1;
    }

      for (int i = 0; i < biggerList.size(); i++) {
        int base1 = biggerList.get(i).getNumber();
        int power1 = biggerList.get(i).getPower();

        for (int j = 0; j < smallerList.size(); j++) {
          int base2 = smallerList.get(j).getNumber();
          int power2 = smallerList.get(j).getPower();

          if (base1 == base2){
            if (power1 >= power2){
              expoList.add(biggerList.get(i));
            } else {
              expoList.add(smallerList.get(j));
            }
          }
        }

        if (!contains(biggerList.get(i).getNumber(), smallerList)){
          expoList.add(biggerList.get(i));
        }

      }

    for (int i = 0; i < smallerList.size(); i++) {
      if (!contains(smallerList.get(i).getNumber(), biggerList)){
        expoList.add(smallerList.get(i));
      }

    }

    sortExpoList(expoList);

    return expoList;
  }

  /**
   * The buildGCDList method creates a list of the exponential form of the GCD numbers
   * of two Expoonential object arrayLists.
   * @param list1 The first Exponential object arraylist to find the GCD of
   * @param list2 The second Exponential object arraylist to find the GCD of
   * @return A list of the exponential representation of the GCD
   */
  private ArrayList<Exponential> buildGCDList(ArrayList<Exponential> list1,
                                              ArrayList<Exponential> list2){

    ArrayList<Exponential> gcdList = new ArrayList<Exponential>();
    ArrayList<Exponential> biggerList = null;
    ArrayList<Exponential> smallerList = null;

    if (list1.size() >= list2.size()){
      biggerList = list1;
      smallerList = list2;
    } else {
      biggerList = list2;
      smallerList = list1;
    }

    for (int i = 0; i < biggerList.size(); i++) {
      int base1 = biggerList.get(i).getNumber();
      int power1 = biggerList.get(i).getPower();

      for (int j = 0; j < smallerList.size(); j++) {
        int base2 = smallerList.get(j).getNumber();
        int power2 = smallerList.get(j).getPower();

        if (base1 == base2){
          if (power1 <= power2){
            gcdList.add(biggerList.get(i));
          } else {
            gcdList.add(smallerList.get(j));
          }
        }
      }

    }

    sortExpoList(gcdList);

    if (gcdList.size() == 0){
      gcdList.add(new Exponential(1,1));
    }

    return gcdList;


  }

  /**
   * The contains method searches an Arraylist of Exponential objects and
   * determines if the list parameter contains the integer parameter in it.
   * @param number The integer to search the Exponential list for
   * @param expoList The Exponential list to search
   * @return True if the Exponential list contains the integer
   */
  private boolean contains(int number, ArrayList<Exponential> expoList){
    for (int i = 0; i < expoList.size(); i++) {
      if (number == expoList.get(i).getNumber()){
        return true;
      }
    }
    return false;
  }

  /**
   * The sortExpoList function sorts an ArrayList of Exponential objects.
   * @param expoList The list of Exponential objects to sort
   */
  private void sortExpoList(ArrayList<Exponential> expoList){

    for (int i = 0; i < expoList.size(); i++) {
      for (int j = i + 1; j < expoList.size(); j++) {

        if (expoList.get(i).getNumber() > expoList.get(j).getNumber()){
          Exponential temp = expoList.get(i);
          expoList.set(i,expoList.get(j));
          expoList.set(j,temp);
        }

      }

    }
  }
  
    /**
   * The getQuotient method returns the quotient of two numbers.
   * @param a The first number to find the quotient of
   * @param b The second number to find the quotient of
   * @return The quotient relating the two numbers
   */
  public int getQuotient(int a, int b){
    if(b < a){

      return a / b;
    } else {

      return b / a;
    }
  }

  /**
   * The getRemainder method calculates the remainder of two numbers
   * @param a The first number to find the remainder of
   * @param b The second number to find the remainder of
   * @return The remainder relating the two numbers
   */
  public int getRemainder(int a, int b){
    int quotient = getQuotient(a,b);
    if (a == quotient * b){

      return 0;
    } else {

      if(a > b) {

        return a - (quotient * b);
      } else {

        return a;
      }
    }
  }
  
    /**
   * The getBezoutIdentity method returns the GCD and the two integers that
   * fulfill the Bezout Identity equation.
   * @param a The first number to get the Bezout identity of
   * @param b The second number to get the Bezout identity of
   * @return An integer array in the order: GCD of a and b, the Bezout identity
   * of a, and the Bezout identity of b
   */
    public int[] getBezoutIdentity(int a, int b){
    boolean flipped = false;
    if (b > a){
      flipped = true;
      int temp = b;
      b = a;
      a = temp;
    }

    if (b <= 0){
      int[] baseIdentity = {a,1,0};

      return baseIdentity;
    } else {

      int quotient = getQuotient(a,b);
      int remainder = getRemainder(a,b);
      int[] stepIdentity = getBezoutIdentity(b,remainder);
      int third = stepIdentity[1] - (quotient * stepIdentity[2]);
      int[] bezoutIdentity = {stepIdentity[0],stepIdentity[2], third};

      if (flipped){
        int temp = bezoutIdentity[1];
        bezoutIdentity[1] = bezoutIdentity[2];
        bezoutIdentity[2] = temp;

        return bezoutIdentity;
      } else {

        return bezoutIdentity;
      }
    }
  }

}
