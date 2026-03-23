package Bai4.presentation;
import Bai4.dao.resultDao;
import Bai4.entity.result;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        resultDao resultDao = new resultDao();

        while (true) {
            result result = new result();

            System.out.print("Nhập tên bệnh nhân: ");
            result.setFullname(sc.nextLine());

            System.out.print("Nhập kết quả xét nghiệm: ");
            result.setDepcripsion(sc.nextLine());

            result.setDate(String.valueOf(new java.sql.Timestamp(System.currentTimeMillis())));

            resultDao.insert(result);

            System.out.print("Tiếp tục nhập? (y/n): ");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("n")) {
                break;
            }
        }
        resultDao.getall();
    }
}
