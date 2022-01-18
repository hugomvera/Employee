import java.time.*;
import java.util.*;
import java.io.*;

/*
//writing objects
ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("myfile.dat"))

Employee e = new Employee("John Doe",123,1980,9,0);

oos.writeObject(e);

 */


/*
//Reading Objects
ObjectInputStream ois = new ObjectInputStream( new FileInputStream("myfile.dat"))

Employee e = new Employee("John Doe",123,1980,9,0);

ois.readObject(e);

 */


public class Employee implements Serializable {

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDate=" + hireDate
                ;
    }

    public String toStringSimple() {
        return  name + "," + salary+ ","+ hireDate.getYear() + ","+ hireDate.getMonthValue()+ ","+ hireDate.getDayOfMonth();
    }

    private String name;
    private double salary;
    private LocalDate hireDate;

    public Employee(String n, double s,int year,int month, int day){
        name =n;
        salary=s;
        hireDate = LocalDate.of(year,month,day);
    }

    public Employee(){
        name ="John Doe";
        salary=0;
        hireDate = LocalDate.of(1000,1,1);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }





    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }




}
