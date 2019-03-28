package assignment3;

public class Employee implements Comparable <Employee>{
    // basic attributes of every employee
    private String ID;
    private String name;
    private double grossSalary;
    // constructor, every employee needs an ID, name, and salary
    public Employee (String ID, String name, double grossSalary) {

        this.ID = ID;
        this.name = name;
        this.grossSalary = grossSalary;
    }
    // net salary calculation, no need for an attribute if you can calculate it based off another attribute
    public double getNetSalary() {
        double netSalary = grossSalary - (grossSalary * 0.1);
        return netSalary;
    }
    //our tostring if we want to print an employee object
    public String toString () {
        String x = System.lineSeparator();
        String employeeInformation = this.name + "'s gross salary is of " + getGrossSalary() + " SEK per month" + x;
        return employeeInformation;
    }
    // our equals method, an employee is only the same if they share the same ID
    public boolean equals (Employee employee) {
        if ( this.ID.equals(employee.getID())) {
            return true;
        }else {
            return false;
        }
    }
    // getters and setters
    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }
    public double originalGrossSalary() {
        return grossSalary;
    }
    //Method for sorting employees alphabetically
    public int compareTo(Employee otherEmployee) {
        String firstName = this.getName().toUpperCase();
        String secondName = otherEmployee.getName().toUpperCase();
        if (firstName == secondName) {
            if (this.grossSalary>otherEmployee.grossSalary) {
                return 0;
            }else {
                return 1;
            }
        }else {
            return firstName.toUpperCase().compareTo(secondName.toUpperCase());
        }
    }
}