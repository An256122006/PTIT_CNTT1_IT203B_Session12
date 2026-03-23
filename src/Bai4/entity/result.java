package Bai4.entity;

public class result {
    private int id;
    private String fullname;
    private String depcripsion;
    private String date;
    public result(){

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

    public String getDepcripsion() {
        return depcripsion;
    }

    public void setDepcripsion(String depcripsion) {
        this.depcripsion = depcripsion;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public result(int id, String fullname, String depcripsion, String date) {
        this.id = id;
        this.fullname = fullname;
        this.depcripsion = depcripsion;
        this.date = date;
    }

    @Override
    public String toString() {
        return "result{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", depcripsion='" + depcripsion + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
