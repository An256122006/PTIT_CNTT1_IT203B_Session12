package Bai3.entity;

public class surgeries {
    private int id;
    private String name;
    private double base_cost;
    private double insurance_percent;
    public surgeries(){

    }

    public surgeries(int id, String name, double base_cost, double insurance_percent) {
        this.id = id;
        this.name = name;
        this.base_cost = base_cost;
        this.insurance_percent = insurance_percent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBase_cost() {
        return base_cost;
    }

    public void setBase_cost(double base_cost) {
        this.base_cost = base_cost;
    }

    public double getInsurance_percent() {
        return insurance_percent;
    }

    public void setInsurance_percent(double insurance_percent) {
        this.insurance_percent = insurance_percent;
    }

    @Override
    public String toString() {
        return "surgeries{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", base_cost=" + base_cost +
                ", insurance_percent=" + insurance_percent +
                '}';
    }
}