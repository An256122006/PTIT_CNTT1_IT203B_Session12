package Bai3.presentation;
import Bai3.Dao.surgeriesDao;
import Bai3.entity.surgeries;
public class Main {
    public static void main(String[] args) {
          surgeriesDao surgeriesDao=new surgeriesDao();
          double totalCost=0;
          totalCost=surgeriesDao.calculateInsuranceCost(1,totalCost);
        System.out.println(totalCost);
    }
}
