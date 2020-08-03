/**
 * The Exponential class represents an exponential number, for example 7 would
 * be represented a 7^1, 3 squared would be 3^2, and so on.
 */
public class Exponential {

  // Class Variables
  int number;
  int power;

  // Constructor
  public Exponential(int number, int power){
    this.number = number;
    this.power = power;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public int getPower() {
    return power;
  }

  public void setPower(int power) {
    this.power = power;
  }

    /**
   * The getValue method returns the number exponentiated power times.
   * @return The evaluated value of the exponential
   */
  public int getValue(){

    int value = this.number;
    for (int i = 1; i < this.power; i++) {
      value *= this.number;
    }

    return value;
  }

    /**
   * The toString method returns a string representation of the exponential object.
   * @return A formatted String denoting the base and power of the exponential
   */
  public String toString(){

    return this.number + "^" + this.power;
  }

  public boolean equals(Object number){

    if (number instanceof Exponential){
      Exponential expo = (Exponential) number;
      if (this.number == expo.number && this.power == expo.power ){

        return true;
      } else {

        return false;
      }
    } else {

      return false;
    }
  }


}
