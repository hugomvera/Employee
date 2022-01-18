import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lesson1IOStream {
    public  static void main (String args[]) throws IOException, ClassNotFoundException {

        //going over the inputs
        for(int i=0;i<args.length;i++){
            System.out.println(args[i]);

        }

        if(args[0].contains("--help")){
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&& help &&&&&&&&&&&&&&&&&&&&&&&&&&&");
            System.out.println("& This is a program that will keep track of employees \t \t ");
            System.out.println("& The menu options are as follow\t \t  \t ");

            System.out.println("& Menu options\t \t \t \t \t ");
            System.out.println("& press c to create a new employee\t \t  \t \t");
            System.out.println("& press s to show employees\t \t \t");
            System.out.println("& press d to delete employees based on index number\t \t  \t ");

            System.out.println("& some of the flags are besides help \t \t \t ");
            System.out.println("&  --text (writes/reads as text file\t \t \t  ");
            System.out.println("& --binary writes/reads as binary file \t \t \t ");
            System.out.println("&  --object (writes/reads as object file\t \t \t ");
            System.out.println("&&&&&&&&&&&&&&&&&&&&&& end of help&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        }



        EmployeeList emL = new EmployeeList();
        boolean flagEnd = false;
        String fType = "";
        if(args[0].contains("--text")){ fType="text";}
        if(args[0].contains("--binary")){ fType="binary";}
        if(args[0].contains("--object")){ fType="object";}
        String option = "";

        while(flagEnd == false){
        System.out.println("##########  menu options ##############");
        System.out.println("# \t Menu options");
        System.out.println("# \tpress c to create a new employee");
        System.out.println("# \t press s to show employees");
        System.out.println("# \t press d to delete employees based on index number");
        System.out.println("# \t press w to write employees to a file");
        System.out.println("# \t press r to read employees from a file");
            System.out.println("# \t press q quit");
        System.out.println("########## end of  menu options ########");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        String read = myObj.nextLine();  // Read user input
        System.out.println("you have pressed: " + read);  // Output user input
            // this is for if there is an text
            if( read.contains("w") && fType=="text") {
                try {
                    emL.writeText();
                } catch (RuntimeException e) {
                    System.out.println(e);
                }
            }
            if( read.contains("r") && fType=="text")
            {
                System.out.println("Reading Text");
                try{emL.readText();}
                catch (RuntimeException e){ System.out.println(e);}

            }

        // this is for if there is an object
        if( read.contains("w") && fType=="object"){
            try{emL.writeObjects();
                System.out.println("Wrote objects");}
            catch (RuntimeException e){ System.out.println(e);}
        }
        if( read.contains("r") && fType=="object")
        {
            System.out.println("Reading Object");
            try{emL.readObjects();}
        catch (RuntimeException e){ System.out.println(e);}

        }
        if( read.contains("d")){
                System.out.println("please put in the number");
                int del = myObj.nextInt();
                emL.removeListIndex(del);
            }
        if( read.contains("s")){emL.listPrint();}
        if( read.contains("c"))
            {   System.out.println("please put in the name:");
                String name = myObj.nextLine();
                System.out.println("please put in salary:");
                String salary = myObj.nextLine();
                System.out.println("please put in year:");
                String year = myObj.nextLine();
                System.out.println("please put in month:");
                String month = myObj.nextLine();
                System.out.println("please put in day:");
                String day = myObj.nextLine();

                try {
                    //emL.addList(name,Integer.parseInt(salary),Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));
                    Employee emT = new Employee(name,Integer.parseInt(salary),Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));
                    emL.addList(emT);
                    //  Block of code to try
                }
                catch(Exception e) {
                    System.out.println("There was an incorrect input:" + e.toString());
                    //  Block of code to handle errors
                }
            }
        if( read.contains("q")){System.exit(0);}
        }
    }

    private static void menu() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username");

        String userName = myObj.nextLine();  // Read user input
        System.out.println("Username is: " + userName);  // Output user input

    }
}
