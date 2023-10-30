/* 经理与员工工资案例 */
interface Mposition {
  double mposition = 1.2;

  void rise();
}

interface Sposition {
  double sposition = 1.1;

  void rise();
}

interface Position extends Mposition, Sposition {

  void rise();
}

class Staff implements Position {
  String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  String address;
  int id;
  int years;
  float salary;

  public float getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = (float) salary;
  }

  double position;

  public double getPosition() {
    return position;
  }

  public void setPosition(double position) {
    this.position = position;
  }

  public void rise() {
    if (this instanceof Manger) {
      this.setPosition(Position.mposition);
      this.setName("manger");
      this.setSalary(10000);
      // System.out.println(this.getName() + "最初工资为" + this.getSalary());
    } else {
      this.setPosition(Position.sposition);
      this.setName("normal");
      this.setSalary(1000);
      // System.out.println(this.getName() + "最初工资为" + this.getSalary());
    }

    this.setSalary(this.getSalary() * this.getPosition());
    System.out.println(this.getName() + " wage is:" + this.getSalary());
  }

  public Staff() {

  }

  public Staff(String name, String address, int id, int years, int salary) {
    this.name = name;
    this.address = address;
    this.id = id;
    this.years = years;
    this.salary = salary;

  }

}

class Manger extends Staff {

  public Manger() {

  }

  public Manger(String name, String address, int id, int years, int salary) {
    super(name, address, id, years, salary);
  }

}

public class test7 {

  public static void main(String[] args) {
    Staff s = new Staff();
    Staff m = new Manger();

    s.rise();
    m.rise();

  }
}
