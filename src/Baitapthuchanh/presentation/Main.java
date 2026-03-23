package Baitapthuchanh.presentation;

import Baitapthuchanh.Dao.DoctorDao;
import Baitapthuchanh.entity.Doctors;
import Baitapthuchanh.Connect.Doctor;

import java.lang.management.MonitorInfo;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DoctorDao doctorDao=new DoctorDao();
        Connection connection = Doctor.getConnection();
        if (connection != null) {
            System.out.println("Kết nối thành công");
        } else {
            System.out.println("Kết nối thất bại");
        }

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Find doctor by specialty");
            System.out.println("2. Update Password");
            System.out.println("3. Caculate duty");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Choose not valid!");
                continue;
            }
            switch (choice) {
                case 1:
                    String Specialty=sc.nextLine();
                    List<Doctors>doctors=new ArrayList<>();
                    doctors=doctorDao.findDoctors(Specialty);
                    doctors.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("moi ban nhap id:");
                    while (true){
                        try {
                            int id=Integer.parseInt(sc.nextLine());
                            System.out.print("moi ban nhap new pass:");
                            String newpass=sc.nextLine();
                            doctorDao.update(id,newpass);
                            break;
                        }catch (NumberFormatException e){
                            System.out.println("id not valid!");
                            continue;
                        }
                    }
                    break;
                case 3:
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Choose not valid!");
            }
        }while (choice !=4);
    }
}
