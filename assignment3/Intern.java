package assignment3;

public class Intern extends Employee {
    //intern benefit if their GPA is over a certain amount
    private static final double INTERN_BENEFIT = 1000.0;

    private int GPA;
    // intern constructor, ID name and gross salary from parent class
    public Intern (String ID, String name, double grossSalary, int GPA) {
        super (ID, name, grossSalary);
        this.GPA = GPA;
    }
    //getters and setters
    public int getGPA() {
        return GPA;
    }
    public void setGPA(int GPA) {
        this.GPA = GPA;
    }
    public double getGrossSalary() {
        double internSalary = originalGrossSalary();
        if (this.GPA <= 5) {
            internSalary = 0;
        }else if (this.GPA > 5 && GPA < 8) {
            internSalary = originalGrossSalary();
        }else if (this.GPA >= 8) {
            internSalary = originalGrossSalary() + INTERN_BENEFIT;
        }return internSalary;
    }
    public double getNetSalary() {
        double netSalary = getGrossSalary();
        return netSalary;
    }
}

