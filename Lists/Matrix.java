/*
 * This class implements a Matrix object. More methods are yet to come.
 */
public class Matrix {

  // Class Variables
  private int rows;
  private int columns;
  private double[][] matrix;

  // Constructor
  public Matrix(int rows, int columns){
    this.rows = rows;
    this.columns = columns;
    this.matrix = new double[rows][columns];
  }

  // Class Variable Accessor Methods
  public int getRows() {
    return rows;
  }

  public int getColumns() {
    return columns;
  }

  public double[][] getMatrix() {
    return matrix;
  }

  /**
   * The setElement method sets a specific element if the matrix to the value
   * passed as an argument.
   * @param row The row of the element to set
   * @param column The column of the element to set
   * @param value The value to assign to that element
   */
  public void setElement(int row, int column, double value){
    if (row <= this.rows && column <= this.columns){
      this.matrix[row][column] = value;
    }

    else {
      throw new IndexOutOfBoundsException();
    }

  }

  /**
   * The getElement method returns the value of the matrix at a specific element.
   * @param row The row of the element to access
   * @param column The column of the element to access
   * @return The value at the row and column index of the matrix
   */
  public double getElement(int row, int column) {
    if (row <= this.rows && column <= this.columns) {
      return this.matrix[row][column];

    } else {
      throw new IndexOutOfBoundsException();
    }

  }

  /**
   * The clear method sets all elements within the matrix to 0.
   */
  public void clearMatrix(){
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.columns; j++) {
        this.matrix[i][j] = 0;
      }
    }

  }

  /**
   * The toString method returns a String representation of the Matrix object.
   * @return A String representation of the matrix object
   */
  public String toString() {
    if (this.matrix.length < 1) {
      return "This Matrix is empty";
    } else {
      String toPrint = "";
      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
          String element = String.format("%.0f", matrix[i][j]);
          toPrint += element + "\t";
        }
        toPrint += "\n";
      }

      return toPrint;
    }

  }


}
