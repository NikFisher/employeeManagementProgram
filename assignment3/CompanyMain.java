package assignment3;

import java.util.Scanner;

public class CompanyMain {
    // case numbers for the main menu
    private static final int REGISTER_EMPLOYEE = 1;
    private static final int REMOVE_EMPLOYEE = 2;
    private static final int RETRIEVE_EMPLOYEE_INFORMATION = 3;
    private static final int UPDATE_EMPLOYEE_INFORMATION = 4;
    private static final int PRINT_REGISTERED_EMPLOYEES = 5;
    private static final int PRINT_GROSS_EXPENSES = 6;
    private static final int PRINT_NET_EXPENSES = 7;
    private static final int PRINT_NUMBER_OF_REGISTERED_EMPLOYEES = 8;
    private static final int SET_DIRECTORS_BENEFIT = 9;
    private static final int PROMOTE_OR_DEMOTE_EMPLOYEE = 10;
    private static final int SORT_EMPLOYEES_ALPHABETICALLY = 11;
    Scanner input;
    ReusaxCorp program;

    public CompanyMain () {
        input = new Scanner(System.in);
        program = new ReusaxCorp();
    }
    // update employee is a method which makes you specifiy which employee you want to update as the constructor for each of them differs so you will require different information
    // for each type of employee
    public void updateEmployee() {
        String ID = "";
        System.out.println("");
        System.out.println("What kind of employee would you like to update? ");
        System.out.println("a) Normal employee");
        System.out.println("b) Manager");
        System.out.println("c) Director");
        System.out.println("d) Intern");
        String employeeType = input.nextLine();

        System.out.println("What would you like to update? ");
        System.out.println("a) name ");
        System.out.println("b) salary ");
        if (employeeType.equals("b")||employeeType.equals("c")) {
            System.out.println("c) degree ");
        }
        if (employeeType.equals("c")) {
            System.out.println("d) department");
        }
        if (employeeType.equals("d")) {
            System.out.println("c) GPA");
        }
        String option = input.nextLine();
        if (option.equalsIgnoreCase("a") && (employeeType.equalsIgnoreCase("a")||employeeType.equalsIgnoreCase("b")||employeeType.equalsIgnoreCase("c")||employeeType.equalsIgnoreCase("d"))) {
            System.out.println("Enter the employee's ID and the employee's new name");
            ID = input.nextLine();
            if (program.findEmployee(ID) == (null)) {
                System.out.println("An employee of ID:" + ID + " is not registered in the system.");
            } else {
                String newName = input.nextLine();
                program.changeName(ID, newName);
                System.out.println("The employee's new name is " + newName);
            }
        } else if (option.equalsIgnoreCase("b") && (employeeType.equalsIgnoreCase("a")||employeeType.equalsIgnoreCase("b")||employeeType.equalsIgnoreCase("c")||employeeType.equalsIgnoreCase("d"))) {
            System.out.println("Enter the employee's ID and the employee's new salary: ");
            ID = input.nextLine();
            if (program.findEmployee(ID) == (null)) {
                System.out.println("An employee of ID:" + ID + " is not registered in the system.");
            } else {
                double newIncome = input.nextDouble();
                program.changeSalary(ID, newIncome);
                System.out.println("The employee's new gross salary is " + newIncome + " SEK per month");
            }
        }else if (employeeType.equalsIgnoreCase("b")||employeeType.equalsIgnoreCase("c")&& option.equalsIgnoreCase("c")) {
            System.out.println("Enter the employee's ID and the employee's new degree: ");
            ID = input.nextLine();
            if (program.findEmployee(ID) == (null)) {
                System.out.println("An employee of ID:" + ID + " is not registered in the system.");
            }else {
                String newDegree = input.nextLine();
                program.changeDegree(ID, newDegree);
                System.out.println("The employee's new degree is a " + newDegree);
            }
        }else if (employeeType.equalsIgnoreCase("c")&&option.equalsIgnoreCase("d")) {
            System.out.println("Enter the director's ID and the director's new department: ");
            ID = input.nextLine();
            if (program.findEmployee(ID) == (null)) {
                System.out.println("An employee of ID:" + ID + " is not registered in the system.");
            }else {
                String newDepartment = input.nextLine();
                program.changeDepartment(ID, newDepartment);
                System.out.println("The director's new department is: " + newDepartment);
            }
        }else if (employeeType.equalsIgnoreCase("d") && option.equalsIgnoreCase("c")) {
            System.out.println("Enter the intern's ID and the intern's new GPA: ");
            ID = input.nextLine();
            if (program.findEmployee(ID) == (null)) {
                System.out.println("An employee of ID:" + ID + " is not registered in the system.");
            }else {
                int newGPA = input.nextInt();
                program.changeGPA(ID, newGPA);
                System.out.println("The intern's new GPA is " + newGPA);
            }
        }
    }
    // registerEmployee method makes you specifiy which employee you want to register as again you have different information required for each employee constructor
    public void registerEmployee() {
        String ID = "";
        String name = "";
        double grossSalary = 0.0;
        String degree = "";
        String department = "";
        int GPA= 0;

        System.out.println("Which type of employee would you like to register?");
        System.out.println("a. Normal employee");
        System.out.println("b. Manager");
        System.out.println("c. Director");
        System.out.println("d. Intern");
        String pick = input.nextLine();
        if (pick.equalsIgnoreCase("a")||pick.equalsIgnoreCase("b")||pick.equalsIgnoreCase("c")||pick.equalsIgnoreCase("d")) {
            System.out.println("Enter the ID:");
            ID = input.nextLine();
            System.out.println("Enter the name:");
            name = input.nextLine();
            System.out.println("Enter the gross salary:");
            grossSalary = input.nextDouble();
            input.nextLine();
        }if (pick.equalsIgnoreCase("b")||pick.equalsIgnoreCase("c")) {
            System.out.println("Enter the degree:");
            degree = input.nextLine();
        }if (pick.equalsIgnoreCase("c")) {
            System.out.println("Enter the department:");
            department = input.nextLine();
        }if (pick.equalsIgnoreCase("d")) {
            System.out.println("Enter the GPA:");
            GPA = input.nextInt();
        }
        if (pick.equalsIgnoreCase("a")) {
            program.registerEmployee(ID, name, grossSalary);
        }else if (pick.equalsIgnoreCase("b")){
            program.registerManager(ID, name, grossSalary, degree);
        }else if (pick.equalsIgnoreCase("c")) {
            program.registerDirector(ID, name, grossSalary, degree, department);
        }else if (pick.equalsIgnoreCase("d")) {
            program.registerIntern(ID, name, grossSalary, GPA);
        }
    }
    //promote employee, allows you to promote and demote employees and input the information required for that position.
    public void promoteEmployee() {
        System.out.println("Which position whould you like to move the employee to?");
        System.out.println("a) Normal Employee");
        System.out.println("b) Intern");
        System.out.println("c) Manager");
        System.out.println("d) Director");
        String pick = input.nextLine();
        if (pick.equalsIgnoreCase("a")) {
            System.out.println("Enter the ID");
            String ID = input.nextLine();
            program.promoteToEmployee(ID);
        }else if (pick.equalsIgnoreCase("b")) {
            System.out.println("Enter the ID and the GPA");
            String ID = input.nextLine();
            int GPA = input.nextInt();
            program.demoteToIntern(ID, GPA);
        }else if (pick.equalsIgnoreCase("c")) {
            System.out.println("Enter the ID and the degree");
            String ID = input.nextLine();
            String degree = input.nextLine();
            program.promoteToManager(ID, degree);
        }else if(pick.equalsIgnoreCase("d")) {
            System.out.println("Enter the ID, degree and department");
            String ID = input.nextLine();
            String degree = input.nextLine();
            String department = input.nextLine();
            program.promoteToDirector(ID, degree, department);
        }
    }
    // printing menu options
    public void menu() {
        System.out.println("======Welcome to Resaux Corp======");
        System.out.println(" Choose an option below: ");
        System.out.println("");
        System.out.println("1. Register an employee");
        System.out.println("2. Remove an employee");
        System.out.println("3. Retrieve an employee's information");
        System.out.println("4. Update an employee's information");
        System.out.println("5. Print all employees registered");
        System.out.println("6. Print gross expenses");
        System.out.println("7. Print net expenses");
        System.out.println("8. Print number of registered employees");
        System.out.println("9. Set the directors' benefit");
        System.out.println("10. Promote or demote an employee");
        System.out.println("11. Get list of employees in alphabetical order");
    }
    // run method is basically our main menu, its a loop so you can always go back to the main menu, cases are determined by which number you enter and the value are the attributes entered at the start of the class
    public void run() {

        int option;
        do {
            menu();
            System.out.print(" Type the option number: ");

            option = input.nextInt();
            input.nextLine();

            switch (option) {
                case REGISTER_EMPLOYEE :
                    registerEmployee();
                    break;

                case REMOVE_EMPLOYEE :
                    System.out.println("Enter the ID");
                    String ID = input.nextLine();
                    program.removeEmployee(ID);
                    break;
                case RETRIEVE_EMPLOYEE_INFORMATION :
                    System.out.println("Enter the ID");
                    ID = input.nextLine();
                    Employee employee = program.findEmployee(ID);
                    if(employee ==(null)){
                        System.out.println("Error: employee cannot be found");
                    }
                    else
                        System.out.println(employee);
                    break;

                case UPDATE_EMPLOYEE_INFORMATION :
                    updateEmployee();
                    break;
                case PRINT_REGISTERED_EMPLOYEES :
                    System.out.println(program.getAllEmployees());
                    break;

                case PRINT_GROSS_EXPENSES :
                    System.out.println(program.calculateGrossExpenses());
                    break;

                case PRINT_NET_EXPENSES :
                    System.out.println(program.calculateNetExpenses());
                    break;
                case PRINT_NUMBER_OF_REGISTERED_EMPLOYEES :
                    System.out.println(program.calculateRegisteredEmployees());
                    break;
                case SET_DIRECTORS_BENEFIT :
                    System.out.println("Enter the directors benefit");
                    double newBenefit = input.nextDouble();
                    input.nextLine();
                    program.setDirectorsBenefit(newBenefit);
                    break;
                case PROMOTE_OR_DEMOTE_EMPLOYEE :
                    promoteEmployee();
                    break;
                case SORT_EMPLOYEES_ALPHABETICALLY :
                    System.out.println(program.listAlpbabetically());
                    break;
                default:
                    System.out.println("Option "+option+" is not valid.");
                    System.out.println();
                    break;
            }

        }while (option != 12);
    }

    public static void main(String[] args) {

        CompanyMain test = new CompanyMain();
        test.run();

    }
}
