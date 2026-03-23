package Bai1.presentation;
import Bai1.Connect.HopspitalConnect;
import Bai1.Dao.HopitalDao;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
       Connection connection=HopspitalConnect.getConnection();
       if (connection!=null){
           System.out.println("Kết nối thành công");
       }else {
           System.out.println("Kết nối thất bại");
       }
       HopitalDao hopitalDao=new HopitalDao();
       hopitalDao.getDoctors("chubabi","123");
    }
}
