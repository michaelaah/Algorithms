/**
 * The StoreLists class describes an object that stores an ArrayList
 * of integer arrays.
 */

import java.util.ArrayList;

public class StoreLists {

  /* Class variables to store a list of int arrays and the StoreLists size*/
  private ArrayList<int[]>  list;
  private int size;

  /**
   * StoreLists constructor creates an instance of the StoreLists object.
   * @param size the number of integer arrays to store in the StoreLists object
   */
  public StoreLists(int size){
    this.size = size;
    this.list = new ArrayList<>(this.size);
  }

  /**
   * The add method adds an integer array to the StoreLists object.
   * @param x the integer array to add.
   */
  public void add(int[] x) {
    if (this.list.size() < this.size) {
      this.list.add(x);
    }
  }

  /**
   * The getSize getter method returns the StoreLists object's size class variable.
   * @return the size instance variable
   */
  public int getSize() {

    return size;
  }

  /**
   * The getArray getter method returns an integer array at a specific index
   * in the StoreLists object.
   * @param i the index of the integer array to retrieve
   * @return an integer array at the corresponding index from the StoreLists object
   */
    public int[] getArray(int i){
      if (i < this.size){
        return this.list.get(i);
      }

      throw new IndexOutOfBoundsException();
    }

}
