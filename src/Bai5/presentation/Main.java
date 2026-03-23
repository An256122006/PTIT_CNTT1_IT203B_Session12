package Bai5.presentation;

import Bai5.Dao.PatientDao;
import Bai5.entity.patients;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientDao patientDao = new PatientDao();
        while (true) {
            try {
                System.out.println("\n===== MENU =====");
                System.out.println("1. Danh sách bệnh nhân");
                System.out.println("2. Thêm bệnh nhân");
                System.out.println("3. Cập nhật bệnh án");
                System.out.println("4. Xuất viện & tính phí");
                System.out.println("5. Thoát");

                System.out.print("Chọn: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        patientDao.getAll();
                        break;
                    case 2:
                        while (true) {
                            patients patients = new patients();
                            System.out.print("Tên: ");
                            String name = sc.nextLine();
                            patients.setFullname(name);
                            System.out.print("Tuổi: ");
                            while (true){
                                try {
                                    int age = Integer.parseInt(sc.nextLine());
                                    patients.setAge(age);
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Lỗi nhập tuổi! Vui lòng nhập lại.");
                                    System.out.print("Tuổi: ");
                                }
                            }

                            System.out.print("Khoa: ");
                            String dep = sc.nextLine();
                            patients.setDepartment(dep);
                            patients.setCheckin(String.valueOf(new java.sql.Timestamp(System.currentTimeMillis())));
                            System.out.print("nhap gia tien:");
                            patients.setPriceofday(Double.parseDouble(sc.nextLine()));
                            patientDao.inserntPatient(patients);
                            System.out.println("✔ Thêm thành công!");
                            System.out.print("Tiếp tục? (y/n): ");
                            String choices = sc.nextLine();
                            if (choices.equalsIgnoreCase("n")) {
                                break;
                            }
                        }
                        break;
                    case 3:
                        System.out.print("id:");
                        while (true){
                            try {
                                int idfind=Integer.parseInt(sc.nextLine());
                               Optional<patients>patientsOptional =patientDao.find(idfind);
                               if(patientsOptional.isPresent()){
                                   patients patients = patientsOptional.get();
                                   System.out.print("Tên: ");
                                   String name = sc.nextLine();
                                   patients.setFullname(name);
                                   System.out.print("Tuổi: ");
                                   while (true){
                                       try {
                                           int age = Integer.parseInt(sc.nextLine());
                                           patients.setAge(age);
                                           break;
                                       } catch (NumberFormatException e) {
                                           System.out.println("Lỗi nhập tuổi! Vui lòng nhập lại.");
                                           System.out.print("Tuổi: ");
                                       }
                                   }
                                   System.out.print("Khoa: ");
                                   String dep = sc.nextLine();
                                   patients.setDepartment(dep);
                                   System.out.print("nhap gia tien:");
                                   while (true){
                                       try {
                                           double price = Double.parseDouble(sc.nextLine());
                                           patients.setPriceofday(price);
                                           break;
                                       } catch (NumberFormatException e) {
                                           System.out.println("Lỗi nhập giá tiền! Vui lòng nhập lại.");
                                           System.out.print("nhap gia tien:");
                                       }
                                   }
                                   boolean up=patientDao.update(patients);
                                   if(up){
                                       System.out.println("✔ sua thành công!");
                                   }else {
                                       System.out.println("Sua that bai!");
                                   }
                                   break;
                               }else {
                                   System.out.println("Không tìm thấy!");
                                   break;
                               }
                            } catch (NumberFormatException e) {
                                System.out.println("Lỗi nhập id! Vui lòng nhập lại.");
                                System.out.print("id:");
                            }
                        }
                        break;
                    case 4:
                        System.out.println("moi ban nhap id");
                        int id=Integer.parseInt(sc.nextLine());
                        Optional<patients>p = patientDao.find(id);
                        if(p.isPresent()){
                            patients patientstemp=p.get();
                            patientstemp.setCheckout(String.valueOf(new java.sql.Timestamp(System.currentTimeMillis())));
                            patientDao.update(patientstemp);
                            patientDao.calculate(id,0);
                            patientDao.Delete(id);
                        }else {
                            System.out.println("Không tìm thấy!");
                        }

                        break;
                    case 5:
                        System.out.println("Thoát...");
                        return;
                    default:
                        System.out.println("Chọn sai!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Lỗi nhập liệu! Vui lòng nhập lại.");
            }
        }
    }
}

