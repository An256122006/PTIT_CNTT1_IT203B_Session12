package Baitapthuchanh.entity;

public class Doctors {
    private int id;
    private String fullName;
    private String specialty;
    private int experienceYears;
    private double baseSalary;
    private String password;

    public Doctors() {
    }

    public Doctors(int id, String fullName, String specialty, int experienceYears, double baseSalary, String password) {
        this.id = id;
        this.fullName = fullName;
        this.specialty = specialty;
        this.experienceYears = experienceYears;
        this.baseSalary = baseSalary;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Doctors [id=" + id + ", fullName=" + fullName + ", specialty=" + specialty + ", experienceYears=" + experienceYears + ", baseSalary=" + baseSalary + ", password=" + password + "]";
    }
}
