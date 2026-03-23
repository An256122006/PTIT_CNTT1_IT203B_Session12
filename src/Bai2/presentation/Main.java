package Bai2.presentation;
import Bai2.Dao.PatientDao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientDao patientDao=new PatientDao();
        System.out.print("Moi ban nhap temperature: ");
        String input = sc.nextLine().replace(",", ".");
        double temp = Double.parseDouble(input);
        boolean up=patientDao.update(temp,1);
        if(up){
            System.out.println("Cap nhat thanh cong");
        }else {
            System.out.println("Cap nhat that bai");
        }
    }
}
