package assignment3;

public class Manager extends Employee {
    //salary bonuses for degrees
    private static final double BACHELOR_BONUS = 0.10;
    private static final double MASTER_BONUS = 0.20;
    private static final double	PHD_BONUS = 0.35;
    private String degree;
    private double bonus;
    // constructor, have to enter degree as ID, name, and salary are inherited from parent class
    public Manager(String ID, String name, double grossSalary, String degree) {
        super(ID, name, grossSalary);

        this.degree = degree;
        this.bonus = 0.0;

    }
    //getters and setters
    public String getDegree () {
        return degree;
    }
    public void setDegree(String degree) {
        this.degree = degree;
    }

    //get bonus for having a certain type of degree.
    public double getBonus() {
        if (degree.equalsIgnoreCase("BSc")||degree.equalsIgnoreCase("BSc.")) {
            this.bonus = originalGrossSalary() * BACHELOR_BONUS;
        }else if (degree.equalsIgnoreCase("MSc")||degree.equalsIgnoreCase("MSc.")) {
            this.bonus = originalGrossSalary() * MASTER_BONUS;
        }else if (degree.equalsIgnoreCase("PhD")||degree.equalsIgnoreCase("PhD.")) {
            this.bonus = originalGrossSalary() * PHD_BONUS;
        }	return bonus;
    }
    public double getGrossSalary() {
        double managerSalary = 0;
        managerSalary = originalGrossSalary()+ getBonus();
        return managerSalary;
    }
}