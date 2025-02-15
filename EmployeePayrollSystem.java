import java.util.*;
public class EmployeePayrollSystem{

    public static void main(String[] args) {
        System.out.println("welcome to employee payrole system !!!");

        Payroll p=new Payroll();
        FulltimeEmployee emp1=new FulltimeEmployee(1,"seeta",1000);
        FulltimeEmployee emp2=new FulltimeEmployee(2,"Ram",2000);
        ParttimeEmployee  emp3=new ParttimeEmployee(3,"rayan",40,100);
        p.addEmployee(emp1);
        p.addEmployee(emp2);
        p.addEmployee(emp3);

        p.displayEmployee();

        p.deleteEmployee(3);
        p.displayEmployee();

        p.updateEmployee(1,"janaki");
        p.displayEmployee();


    }
}

abstract class Employee{

    private int id;
    private String name;

    public Employee(int id,String name)
    {
        this.id=id;
        this.name=name;
    }
    public int getId()
    {
        return id;
    }

    public  String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public abstract double calculateSalary();

    public String toString()
    {
        return "id :"+id+" name :"+name+" salary :"+calculateSalary()+" ";
    }
}
class FulltimeEmployee extends Employee{

    private double monthlySalary;

    public FulltimeEmployee(int id,String name,double salary)
    {
        super(id,name);
        monthlySalary=salary;
    }
    public double calculateSalary()
    {
        return monthlySalary;
    }
}

class ParttimeEmployee  extends Employee{

    private int noHoursWorked;
    private double hourlyRate;

    public ParttimeEmployee(int id,String name,int noHoursWorked,double hourlyRate)
    {
        super(id,name);
        this.noHoursWorked=noHoursWorked;
        this.hourlyRate=hourlyRate;


    }

    public double calculateSalary()
    {
        return (hourlyRate*noHoursWorked);
    }

    

}

class Payroll{

    ArrayList<Employee>employeeList;

    public Payroll()
    {
        employeeList=new ArrayList();
    }

    public void  addEmployee(Employee employee)
    {
            employeeList.add(employee);
    }

    public void displayEmployee()
    {
        System.out.println("our employees are...");
        for(Employee emp: employeeList)
        {
            System.out.println(emp);
        }
    }

    public void deleteEmployee(int id)
    {
        Employee employeeToRemove=null;
        for(Employee emp:employeeList)
        {
            if(id==emp.getId())
            {
               employeeToRemove=emp;
               break;
            }
            

        }
            if(employeeToRemove !=null)
            {
                employeeList.remove(employeeToRemove);
            }
            else{
                System.out.println("coresponding employee does not exist...");
            }
    }

    public void updateEmployee(int id,String name)
    {
        for(Employee emp :employeeList)
        {
            if(id==emp.getId()){
                emp.setName(name);
            }
        }
    }

}