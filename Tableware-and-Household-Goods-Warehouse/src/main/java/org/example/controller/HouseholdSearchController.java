package org.example.controller;

import org.example.dao.Household;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.service.HouseholdSearchService.searchWareHousehold;

public class HouseholdSearchController {
    public static void searchProducts(List<Household> households) {
        Scanner scanner = new Scanner(System.in);
        String criterionPrompt = "Select a search criterion (ID, name, category, price, or quantity): ";
        String valuePrompt = "Enter the search value: ";

        System.out.print(criterionPrompt);
        String parameter = scanner.nextLine().trim().toLowerCase();

        System.out.print(valuePrompt);
        String value = scanner.nextLine().trim().toLowerCase();

        List<Household> results = new ArrayList<>();
        searchWareHousehold(households, parameter, value, results);
    }


}
