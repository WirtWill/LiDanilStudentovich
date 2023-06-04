package org.example.controller;

import org.example.dao.Household;

import java.util.List;
import java.util.Scanner;

import static org.example.service.HouseholdStorageService.displaySortedWareHousehold;

public class HouseholdController {

    public static void displayHousehold(List<Household> households) {
        Scanner scanner = new Scanner(System.in);
        String prompt = "Select a sorting criterion (ID, name, category, price, or quantity): ";
        System.out.print(prompt);
        String order = scanner.nextLine().trim().toLowerCase();
        displaySortedWareHousehold(order, households);
    }
}
