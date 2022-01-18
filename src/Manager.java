import java.time.*;
import java.util.*;

public class Manager extends Employee {

    public Manager(String n, double s, int year, int month, int day) {
        super(n, s, year, month, day);
    }

    private Employee secratary;

    public void setSecratary(Employee sec){
        secratary = sec;
    }

}
