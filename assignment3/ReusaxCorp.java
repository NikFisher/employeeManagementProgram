package assignment3;

import java.util.ArrayList;
import java.util.Collections;

public class ReusaxCorp {
    private ArrayList <Employee> employees;
    static double directorsBenefit;


    public ReusaxCorp() {
        // our arraylist of employees, basically the company roster
        employees = new ArrayList <Employee>();
        directorsBenefit = 0;
    }
    //registering employees and the information you need to pass into their constructors
    public void registerEmployee (String ID, String name, double grossSalary) {
        Employee newEmployee = new Employee (ID, name, grossSalary);
        employees.add(newEmployee);
    }
    public void registerManager (String ID, String name, double grossSalary, String degree) {
        Manager newManager = new Manager (ID, name, grossSalary, degree);
        employees.add(newManager);
    }
    public void registerDirector (String ID, String name, double grossSalary, String degree, String department) {
        Director newDirector = new Director ( ID, name, grossSalary, degree, department);
        employees.add(newDirector);
    }
    public void registerIntern (String ID, String name, double grossSalary, int GPA) {
        Intern newIntern = new Intern (ID, name, grossSalary, GPA);
        employees.add(newIntern);
    }
    // goes through the arraylist employees and finds the employee you*re searching for ID wise
    public Employee findEmployee (String employeeID) {
        for (int i = 0; i < this.employees.size(); i++ ) {
            Employee currentEmployee = employees.get(i);
            if (currentEmployee.getID().equals(employeeID)){
                return currentEmployee;
            }else {

            }
        }
        return null;
    }
    //deletes the employee searched through via ID
    public void removeEmployee (String ID) {
        Employee sackedEmployee = findEmployee(ID);
        employees.remove(sackedEmployee);
    }
    //changes the name of the employee
    public void changeName(String ID, String newName) {
        Employee employee = findEmployee(ID);
        employee.setName(newName);
    }
    public void changeSalary (String ID, Double newGrossSalary) {
        Employee employee = findEmployee(ID);
        employee.setGrossSalary(newGrossSalary);
    }
    public void changeDegree (String ID, String newDegree) {
        Manager manager = (Manager) findEmployee(ID);
        manager.setDegree(newDegree);
    }
    public void changeDepartment (String ID, String newDepartment) {
        Director director = (Director) findEmployee(ID);
        director.setDepartment(newDepartment);
    }
    public void changeGPA (String ID, int newGPA) {
        Intern intern = (Intern) findEmployee(ID);
        intern.setGPA(newGPA);
    }
    // goes through the entire array and prints all of the employees
    public String getAllEmployees() {
        String allEmployees = "";
        for (Employee x : employees) {
            allEmployees += x;
        }
        return allEmployees;
    }
    public int calculateRegisteredEmployees(){
        int registeredEmployees = employees.size();
        return registeredEmployees;
    }
    //adds up all the gross salaries of the employees and returns that number
    public double calculateGrossExpenses(){
        double grossExpenses = 0;
        for (Employee x : employees){
            grossExpenses += x.getGrossSalary();
        }
        return grossExpenses;
    }
    //adds up all the net salaries of the employees and returns that number
    public double calculateNetExpenses(){
        double netExpenses = 0;
        for(Employee x :employees){
            netExpenses +=x.getNetSalary();
        }
        return netExpenses;
    }
    public double getDirectorsBenefit() {
        return directorsBenefit;
    }
    public void setDirectorsBenefit(double newDirectorsBenefit) {
        directorsBenefit = newDirectorsBenefit;
    }
    //promoters and demoters
    public void promoteToEmployee(String ID) {
        Employee employee = findEmployee(ID);
        String name = employee.getName();
        double grossSalary = employee.originalGrossSalary();
        removeEmployee(ID);
        Employee newEmployee = new Employee (ID, name, grossSalary);
        employees.add(newEmployee);
    }
    public void promoteToManager(String ID, String degree) {
        Employee employee = findEmployee(ID);
        String name = employee.getName();
        double grossSalary = employee.originalGrossSalary();
        removeEmployee(ID);
        Manager newManager = new Manager (ID, name, grossSalary, degree);
        employees.add(newManager);
    }
    public void promoteToDirector(String ID, String degree, String department) {
        Employee employee = findEmployee(ID);
        String name = employee.getName();
        double grossSalary = employee.originalGrossSalary();
        removeEmployee(ID);
        Director newDirector = new Director (ID, name, grossSalary, degree, department);
        employees.add(newDirector);
    }
    public void demoteToIntern(String ID, int GPA) {
        Employee employee = findEmployee(ID);
        String name = employee.getName();
        double newGrossSalary = employee.originalGrossSalary();
        removeEmployee(ID);
        Intern newIntern = new Intern (ID, name, newGrossSalary, GPA);
        employees.add(newIntern);
    }
    //Method that sorts employees alphabetically
    public ArrayList<Employee> listAlpbabetically(){
        Collections.sort(employees);
        return employees;
    }
}

