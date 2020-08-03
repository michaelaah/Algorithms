
public class Exponential {

  int number;
  int power;

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

  public int getValue(){

    int value = this.number;
    for (int i = 1; i < this.power; i++) {
      value *= this.number;
    }

    return value;
  }

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
