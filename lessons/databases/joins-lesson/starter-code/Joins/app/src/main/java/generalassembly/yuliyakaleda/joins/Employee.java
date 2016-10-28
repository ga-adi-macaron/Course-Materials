package generalassembly.yuliyakaleda.joins;

public class Employee {
  private String name;
  private String address;
  private int age;
  private double salary;

  public Employee(String name, int age, String address, int salary) {
    this.name = name;
    this.age = age;
    this.address = address;
    this.salary = salary;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }
}
