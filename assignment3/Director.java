package assignment3;

public class Director extends Manager {
    // which department they belong to
    private String department;
    // constructor method, ID, name, grossSalary, and degree are inherited from the superclass, however you need to enter the department they belong to
    public Director (String ID, String name, double grossSalary, String degree, String department) {
        super (ID, name, grossSalary, degree);

        this.department = department;
    }
    //get net salary for director, based on tax brackets outlined in the instructions.
    public double getNetSalary() {
        double netSalary = 0.0;
        if (getGrossSalary()<30000.0) {
            netSalary = getGrossSalary() - getGrossSalary() * 0.10;
        }else if(getGrossSalary()>=30000.0 && getGrossSalary()<=50000.0) {
            netSalary = getGrossSalary() - getGrossSalary()* 0.20;
        }else if (getGrossSalary()>50000.0) {
            netSalary = getGrossSalary() - (30000.0 * 0.20) - ((getGrossSalary()- 30000.0) * 0.40);
        }return netSalary;
    }
    // getters and setters
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public double getGrossSalary() {
        double directorSalary = 0;
        directorSalary = originalGrossSalary() + ReusaxCorp.directorsBenefit + getBonus();
        return directorSalary;
    }
}
