/*
 * The SetOperations class implements several Set mathematical operations.
 * (searching a list for duplicates, getting a list of duplicates, removing
 * duplicates from a list, union operation, intersection operation, power set
 * operation, combining two arrays, subset operation, and strict subset operation).
 * Note: This class uses arrays and ArrayLists to help implement sets and set
 * operation behavior.
 */
import java.util.ArrayList;

public class SetOperations {

  /**
   * No Argument Constructor.
   */
  public SetOperations(){}

  /**
   * The hasDuplicates method tests if any one element is duplicated in the
   * parameter array.
   * @param intArray The array to search for a duplicate in
   * @return True, if a duplicate is found
   */
  public boolean hasDuplicates(int[] intArray){
    boolean hasDuplicates = false;
    if (intArray.length > 0){
      for (int i = 0; i < intArray.length; i++) {
        int firstElem = intArray[i];
        for (int j = i + 1; j < intArray.length; j++){
          int secondElem = intArray[j];
          if (firstElem == secondElem){
            hasDuplicates = true;
          }
        }
      }
    }

    return hasDuplicates;
  }

  /**
   * The removeDuplicates method removes duplicates from a parameter array.
   * @param intArray The array to remove duplicates from
   * @return An array without duplicates
   */
  public int[] removeDuplicates(int[] intArray){
    ArrayList<Integer> altArray = new ArrayList<Integer>();
    int iter = 0;
    sortArray(intArray);

    for (int i = 0; i < intArray.length - 1; i++) {
      int first = intArray[i];
      int second = intArray[i+1];
      if (first != second){
        altArray.add(first);
        iter++;
      }
    }

    if (intArray.length > 0) {
      altArray.add(iter, intArray[(intArray.length - 1)]);
    }
    int[] newArray = new int[altArray.size()];

    for (int i = 0; i < newArray.length; i++) {
      newArray[i] = altArray.get(i);
    }

    return newArray;
  }

  /**
   * The getNumberOfDuplicates method returns the number of duplicated elements
   * in the parameter array.
   * @param intArray The array to count the number of duplicates in
   * @return The integer amount of duplicated elements in the parameter array
   */
  public int getNumberOfDuplicates(int[] intArray){
    int duplicates = 0;
    for (int i = 0; i < intArray.length; i++) {
      int first = intArray[i];
      for (int j = i + 1; j < intArray.length; j++) {
        int second = intArray[j];
        if (first == second){
          duplicates++;
        }
      }
    }

    return duplicates;
  }

  /**
   * The sortArray method sorts the parameter array variable.
   * @param array The array to sort
   */
  public void sortArray(int[] array){
    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if(array[i] > array[j]){
          int tempVar = array[i];
          array[i] = array[j];
          array[j] = tempVar;
        }
      }
    }
  }

  /**
   * The powerSet method creates an ArrayList of Strings representing the
   * power set of the parameter array variable.
   * @param intArray The array to get the power set of
   * @return A String ArrayList representing the power set of the parameter array
   */
  public ArrayList<String> powerSet(int[] intArray){
    /* With n distinct elements in a given set, we can expect 2^4 subsets /
     * permutations / configurations of the set.
     */
    ArrayList<String> stringList = new ArrayList<String>();
    int size = intArray.length;
    String element = "";  // String variable to append to as the array is traversed.
    
    for (int i = 0; i < (1 << size); i++) {
      element += "{ ";
      for (int j = 0; j < size; j++) {
        if ((i & (1 << j)) > 0){
          element += intArray[j] + " ";
        }
      }
      element += "}";
      stringList.add(element);
      element = "";
    }

    return stringList;
  }

  /**
   * The union method derives the union of two array parameter variables.
   * @param array1 The first array to get the union of
   * @param array2 The second array to get the union of
   * @return An array representing the union of the first and second parameter
   * array variables
   */
  public int[] union(int[] array1, int[] array2){
    int[] newArray = new int[array1.length + array2.length];
    for (int i = 0; i < array1.length; i++) {
      newArray[i] = array1[i];
    }

    int start = array1.length;
    int newSize = array1.length + array2.length;

    for (int i = start; i < newSize; i++) {
      newArray[i] = array2[i - start];
    }

    return removeDuplicates(newArray);
  }

  /**
   * The intersection method derives the set intersection of the first parameter
   * array and the second parameter array.
   * @param array1 The first array variable to get the intersection of
   * @param array2 The second array variable to get the intersection of
   * @return An array representing the intersection fo the two array variables
   */
  public int[] intersection(int[] array1, int[] array2){
    int[] combined = combineArrays(array1,array2);

    return getDuplicatesList(combined);
  }

  /**
   * Teh getDuplicatesList method derives and returns all the duplicates of
   * the given list parameter.
   * @param array1 The array parameter variable to get the list of duplicate
   * elements of
   * @return An array of all the duplicated elements from the parameter variable
   */
  public int[] getDuplicatesList(int[] array1){
    int duplicates = getNumberOfDuplicates(array1);
    int[] listOfDuplicates = new int[duplicates];
    int index = 0;

    for (int i = 0; i < array1.length; i++) {
      for (int j = 1 + i; j < array1.length; j++) {
        if (array1[i] == array1[j]){
          listOfDuplicates[index] = array1[i];
          index++;
        }
      }
    }

    sortArray(listOfDuplicates);

    return removeDuplicates(listOfDuplicates);
  }

  /**
   * The combineArrays method combines two parameter array variables into one.
   * @param array1 The first array to combine
   * @param array2 The second array to combine
   * @return An array that is the combination of both the parameter arrays
   */
  public int[] combineArrays(int[] array1, int[] array2){
    int[] newArray = new int[array1.length + array2.length];
    for (int i = 0; i < array1.length; i++) {
      newArray[i] = array1[i];
    }

    int start = array1.length;
    int newSize = array1.length + array2.length;

    for (int i = start; i < newSize; i++) {
      newArray[i] = array2[i - start];
    }

    sortArray(newArray);

    return newArray;
  }

  /**
   * The isSubset method determines if the given subset parameter variable
   * is a subset of the set parameter variable.
   * @param subset The subset to test if it is a subset
   * @param set The set of the set to test if it contains a matching
   * parameter subset element
   * @return True if the subset parameter variable is a subset
   */
  public boolean isSubset(int[] subset, int[] set){
    sortArray(subset);
    sortArray(set);
    ArrayList<String> powerSet = powerSet(set);

    // create a string representation of the subset
    String element = "";
    if (subset.length > 0){
      element += "{ ";
      for (int i = 0; i < subset.length; i++) {
        element += subset[i] + " ";
      }
      element += "}";
    }

    for (int i = 0; i < powerSet.size(); i++) {
      if (powerSet.get(i).equals(element)){
        return true;
      }
    }

    return false;
  }

  /**
   * The isSubset method determines if the given subset parameter variable
   * is a subset of the set parameter variable.
   * @param subset The subset to test if it is a subset
   * @param powerSet The powerSet of the set to test if it contains a matching
   * parameter subset element
   * @return True if the subset parameter variable is a subset
   */
  public boolean isSubset(int[] subset, ArrayList<String> powerSet){
    sortArray(subset);

    String element = "";
    if (subset.length > 0){
      element += "{ ";
      for (int i = 0; i < subset.length; i++) {
        element += subset[i] + " ";
      }
      element += "}";
    }

    for (int i = 0; i < powerSet.size(); i++) {
      if (powerSet.get(i).equals(element)){
        return true;
      }
    }

    return false;
  }

  /**
   * The isStrictSubset method determines if the given subset parameter variable
   * is a strict subset of the set parameter variable.
   * @param subset The subset to test if it is a strict subset
   * @param set The set to be compared to to test if something is a strict
   * subset of
   * @return True if the subset parameter variable is a strict subset of the set
   * parameter variable
   */
  public boolean isStrictSubset(int[] subset, int[] set){
    sortArray(subset);
    sortArray(set);
    ArrayList<String> powerSet = powerSet(set);
    powerSet.remove(powerSet.size() - 1);

    return isSubset(subset,powerSet);
  }

  /**
   * The getSize method returns the size of a given array parameter.
   * @param setArray The set (array) to get the size of
   * @return An integer representation of the size of the set (array)
   */
  public int getSize(int[] setArray){
    int[] distinctElements = removeDuplicates(setArray);

    if (distinctElements.length < 1){
      return 1;
    } else {
      return distinctElements.length;
    }

  }
  
  /**
   * The difference method performs the Set difference operation on two set
   * parameter variables.
   * @param array1 The minuend of the set difference operation
   * @param array2 The subtrahend of the set difference operation
   * @return An array representing a set of the difference operation performed
   * on the two set parameter variables
   */
  public int[] difference(int[] array1, int[] array2){
    ArrayList<Integer> intList = new ArrayList<Integer>();
    for (int i = 0; i < array1.length; i++) {
      if (!(contains(array1[i],array2))){
        intList.add(array1[i]);
      }
    }

    int[] difference = new int[intList.size()];

    for (int i = 0; i < intList.size(); i++) {
      difference[i] = intList.get(i);
    }

    return removeDuplicates(difference);
  }

  /**
   * The contains method searches a given array for a specific element.
   * @param item The element to search for
   * @param array The array to search within
   * @return True if the element is found within the array parameter variable
   */
  public boolean contains(int item, int[] array){
    for (int i = 0; i < array.length; i++) {
      if (array[i] == item){
        return true;
      }
    }

    return false;
  }
  
  /**
   * The equal method determines if two sets are equal.
   * @param array1 The first set to test for equality
   * @param array2 The second set to test for equality
   * @return true of the sets are equal
   */
  public boolean equal(int[] array1, int[] array2){
    int[] set1 = removeDuplicates(array1);
    int[] set2 = removeDuplicates(array2);

    if (set1.length != set2.length){
      return false;
    } else {
      for (int i = 0; i < set1.length; i++) {
        if (set1[i] != set2[i]){
          return false;
        }
      }
      return true;
    }
  }

}
