package Bai5.entity;

public class patients {
    private int id;
    private String fullname;
    private int age;
    private String department;
    private String checkin;
    private String checkout;
    private double priceofday;
    public patients() {
    }

    public patients(int id, String fullname, int age, String department, String checkin, String checkout, double priceofday) {
        this.id = id;
        this.fullname = fullname;
        this.age = age;
        this.department = department;
        this.checkin = checkin;
        this.checkout = checkout;
        this.priceofday = priceofday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public double getPriceofday() {
        return priceofday;
    }

    public void setPriceofday(double priceofday) {
        this.priceofday = priceofday;
    }

    @Override
    public String toString() {
        return "patients{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                ", priceofday=" + priceofday +
                '}';
    }
}
