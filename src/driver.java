import java.io.*;

public class driver {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        EmployeeList employeList = new EmployeeList();
        EmployeeList employeListOut = new EmployeeList();


//
        System.out.println("added to the firstt element!@@@@@@@@@@@@@@@@@@@@@@@2");
        //made a em1
        Employee em1 = new Employee("william",1999,1999,1,1);
        Employee em2 = new Employee("william2",1999,1999,1,1);
        //added to a list
        employeListOut.addList(em1);
        employeListOut.addList(em2);

      employeListOut.toString();

      employeListOut.writeText();

        System.out.println("reading the file");
      employeListOut.readText();



      String test1 = "william2,1999.0,1999,JANUARY,1";
      String[] splitted = test1.split(",");
      System.out.println(splitted[3]);




    }
        }


