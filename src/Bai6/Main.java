package Bai6;

import java.util.Scanner;

import static Bai6.PreparedStatement.*;

public class Main {
    public static void main(String[] args) {
        int choice=0;
        do {
            Scanner sc = new Scanner(System.in);

            System.out.println("1. Update stock");
            System.out.println("2. Find by price");
            System.out.println("3. Total prescription");
            System.out.println("4. Daily revenue");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    updateMedicineStock(1, 20);
                    break;
                case 2:
                    findMedicinesByPriceRange(10, 20);
                    break;
                case 3:
                    calculatePrescriptionTotal(1);
                    break;
                case 4:
                    getDailyRevenue("2026-03-23");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 5);
    }
}