import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EmployeeList implements Serializable {
    List<Employee> data = new ArrayList<Employee>();
    static int counter = 0;
    //create a user  add it
    public void addList(String n, double s,int year,int month, int day){


        Employee em1 = new Employee(n,s,year,month,day);
        if( !(this.duplicateName(em1)) ){
            data.add(em1);
            System.out.println("added to the list");
        }
        else {
            System.out.println("Duplicate did not added it");
        }

    }

    //create a user  add
    public void addList(Employee em){

        Employee em1 = em;
        if( !(this.duplicateName(em1)) ){
            data.add(em1);
            System.out.println("added to the list");
            System.out.println(em1.toString());
            counter = 1+ counter;
        }
        else{
            System.out.println("did not added  to the list");
            System.out.println(em1.toString());
        }

    }

    //delete an user by name
    public void removeListIndex(int index){
        data.remove(index);
    }

    //modify an an user
    //TODO
    //TODO add different ways to write objkects
    //TODO write read files
    //todo write read ...

    //print user list
    public void listPrint(){
        System.out.println("Printing out the employees there are " + data.size());


        for(int i= 0 ; i<data.size();i++)
       System.out.println( i+":"+data.get(i).toString());
    }

    public int length(){
        return counter;
    }

    public  Employee get(int i){
        return data.get(i);
    }

    ObjectInputStream ois;

    public void readObjects() throws IOException, ClassNotFoundException{
        try {

            ois = new ObjectInputStream(new FileInputStream("myfile.dat"));
            int outInteger = (int) ois.readObject();

            for(int i=0; i<outInteger;i++){
                Employee out=(Employee)ois.readObject();
                this.addList(out);
            }
        }
        catch (Exception e ){
            System.out.println(e);
        }
        finally {
            ois.close();
        }

    }

    ObjectOutputStream oos;
    public void writeObjects() throws  IOException, ClassNotFoundException{
        try {
           oos= new ObjectOutputStream(new FileOutputStream("myfile.dat"));
            oos.writeObject(this.length());
            for(int i=0; i<this.length();i++){
                oos.writeObject(this.get(i));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        finally {
            oos.close();
        }

    }

    public boolean duplicateName(Employee emCheck){
        boolean flag = false;
        for(int i=0; i<counter;i++)
        {
            if(data.get(i).getName().contains(emCheck.getName()) ){
                flag = true;
            }
        }
        return flag;
    }


    FileWriter  myWriter;
    public void writeText() throws IOException {
        try {
              myWriter = new FileWriter("Data.txt");
            myWriter.write(this.length()+"\n");
            for(int i=0; i<this.length();i++){
                myWriter.write(this.get(i).toStringSimple()+"\n" );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        finally {
            myWriter.close();
        }
    }

    public void readText() {
        try {
            System.out.println("########################int the readText function############################");
            File myObj = new File("Data.txt");
            Scanner myReader = new Scanner(myObj);
            int count = myReader.nextInt();

            int whileCount = 0 ;

            while (myReader.hasNextLine()) {
                //read a line

                String data = myReader.nextLine();

                if(whileCount==0){
                    whileCount++;
                    continue;
                }

                System.out.println("string is " + data);
                //trying to split the data
                String[] listParameters = data.trim().split(",");
                int length = listParameters.length;
                System.out.println("the lenght of the array is "+ length);
                //System.out.println(listParameters[1]);

                //System.out.println();


                //System.out.println(listParameters[1]);

                //String[] sp = data.split("[,]", 0);
                //System.out.println("sp to string is" + sp[1]);
                //System.out.println("the first is" + sp[2]);
//                int i =0;
//                ArrayList<String> tempA = new ArrayList<String>();
//                System.out.println("tempA");
//                for(String myStr: sp) {
//                    System.out.println("within the for loop" + i );
//                    System.out.println(myStr);
//                    tempA.add(myStr);
//                    i++;
//                }
               // Employee toAdd = new Employee(temp.get(0),Double.parseDouble(temp.get(1)),Integer.parseInt(temp.get(2)),Integer.parseInt(temp.get(3)),Integer.parseInt(temp.get(4)));



                String nameOut= listParameters[0];
                System.out.println("the name to be written is " + nameOut);
                double salaryOut =Double.parseDouble(listParameters[1]);
                System.out.println("the salary out will be  " + salaryOut);
                int year =Integer.parseInt(listParameters[2]);
                System.out.println("the year is "+ year);
                int month =Integer.parseInt(listParameters[3]);
                System.out.println("the month is "+ month);
                int day =Integer.parseInt(listParameters[4]);
                System.out.println("the day is "+ day);

                System.out.println("makeing the employee");

                Employee tempEmployee = new Employee(nameOut,salaryOut,year,month,day);
               this.addList(tempEmployee);


            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
