package org.example.controller;

import org.example.dao.Household;

import java.util.List;
import java.util.Scanner;

import static org.example.controller.HouseholdController.displayHousehold;
import static org.example.controller.HouseholdSearchController.searchProducts;
import static org.example.service.HouseholdLoaderService.loadHousehold;

public class ConsoleViewController {

    public static void manageHousehold() {
        List<Household> household = loadHousehold();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter your choice (A-C): ");
            String action = scanner.nextLine().toUpperCase();

            if (action.equals("A")) {
                searchProducts(household);
            } else if (action.equals("B")) {
                displayHousehold(household);
            } else if (action.equals("C")) {
                System.out.println("Exiting the program...");
                scanner.close();
                return;
            } else {
                System.out.println("Invalid action. Please enter a valid action (A-C).");
            }
        }

    }
}
