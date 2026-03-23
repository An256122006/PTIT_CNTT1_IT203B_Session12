package Bai1.entity;

public class doctor {
  private int id;
  private String code;
  private String pass;
  public doctor(){

  }

    public doctor(int id, String code, String pass) {
        this.id = id;
        this.code = code;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    @Override
    public String toString() {
        return "id=" + id + ", code=" + code + ", pass=" + pass;
    }
}
