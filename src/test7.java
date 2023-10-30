/* 经理与员工工资案例 */
interface Mposition {
  double mposition = 1.2;

  void rise();
}

interface Sposition {
  double sposition = 1.1;

  void rise();
}

interface Ssposition {
  double Ssposition = 2;

  void rise();
}

interface Position extends Mposition, Sposition, Ssposition {

  void rise();
}

class Staff implements Position {
  String name;
  String address;
  int id;
  int years;
  float salary;
  double position;
  String type;

  class specialStaff extends Staff {
    public void rise() {
      this.setPosition(Position.Ssposition);
      this.setSalary(this.getSalary() * this.getPosition());
      System.out.println(this.gettype() + " wage is:" + this.getSalary());
    }

    public specialStaff() {

    }

    public specialStaff(String name, String address, int id, int years, int salary) {
      super(name, address, id, years, salary);
    }

    void show() {
      this.settype("BossSon");
      System.out.println(
          "我叫" + this.name + "我来自" + this.address + "我来公司" + this.years + "年了" + "我的工号是" + this.id);
      System.out.println("我的职位是" + this.type);
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String gettype() {
    return type;
  }

  public void settype(String type) {
    this.type = type;
  }

  public float getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = (float) salary;
  }

  public double getPosition() {
    return position;
  }

  public void setPosition(double position) {
    this.position = position;
  }

  public void rise() {
    if (this instanceof Manger) {
      this.setPosition(Position.mposition);
      this.settype("manger");

      // System.out.println(this.getName() + "最初工资为" + this.getSalary());
    } else {
      this.setPosition(Position.sposition);
      this.settype("normal");
      // System.out.println(this.getName() + "最初工资为" + this.getSalary());
    }

    this.setSalary(this.getSalary() * this.getPosition());
    System.out.println(this.gettype() + " wage is:" + this.getSalary());
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

  void show() {
    this.settype("normal");
    System.out.println(
        "我叫" + this.name + "我来自" + this.address + "我来公司" + this.years + "年了" + "我的工号是" + this.id);
    System.out.println("我的职位是" + this.type);

  }

}

class Manger extends Staff {

  public Manger() {

  }

  public Manger(String name, String address, int id, int years, int salary) {
    super(name, address, id, years, salary);
  }

  void show() {
    this.settype("manger");
    System.out.println(
        "我叫" + this.name + "我来自" + this.address + "我来公司" + this.years + "年了" + "我的工号是" + this.id);
    System.out.println("我的职位是" + this.type);
  }
}

public class test7 {

  public static void main(String[] args) {
    Staff s = new Staff("张三", "北京", 001, 2, 1000);
    Staff m = new Manger("李四", "上海", 002, 10, 10000);
    Staff.specialStaff ss = s.new specialStaff("王五", "北京", 000, 1, 20000);
    s.show();
    s.rise();
    m.show();
    m.rise();
    ss.show();
    ss.rise();

  }
}
