package Bai2.entity;

public class patients {
    private int id;
    private String full_name;
    private double temperature;
    private int heart_rate;
    public patients() {
    }

    public patients(int id, String full_name, double temperature, int heart_rate) {
        this.id = id;
        this.full_name = full_name;
        this.temperature = temperature;
        this.heart_rate = heart_rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getHeart_rate() {
        return heart_rate;
    }

    public void setHeart_rate(int heart_rate) {
        this.heart_rate = heart_rate;
    }

    @Override
    public String toString() {
        return "patients{" +
                "id=" + id +
                ", full_name='" + full_name + '\'' +
                ", temperature=" + temperature +
                ", heart_rate=" + heart_rate +
                '}';
    }
}
