package org.example.service;

import org.example.dao.Household;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HouseholdStorageService {

    public static void displaySortedWareHousehold(String sortBy, List<Household> wareHousehold) {
        List<Household> households = new ArrayList<>(wareHousehold);
        Comparator<Household> comparator;

        switch (sortBy) {
            case "id":
                comparator = Comparator.comparingInt(Household::getId);
                break;
            case "name":
                comparator = Comparator.comparing(Household::getName);
                break;
            case "category":
                comparator = Comparator.comparing(Household::getCategory);
                break;
            case "price":
                comparator = Comparator.comparingDouble(Household::getPrice);
                break;
            case "quantity":
                comparator = Comparator.comparingInt(Household::getQuantity);
                break;
            default:
                System.out.println("Invalid sorting criterion.");
                return;
        }

        households.sort(comparator);

        System.out.println("Warehouse Household List (sorted by " + sortBy + "):");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-4s %-20s %-25s %-6s %-8s\n", "ID", "Name", "Category", "Price", "Quantity");
        System.out.println("--------------------------------------------------");

        for (Household household : households) {
            System.out.printf("%-4d %-20s %-25s %-6.2f %-8d\n",
                    household.getId(), household.getName(), household.getCategory(),
                    household.getPrice(), household.getQuantity());
        }

        System.out.println("--------------------------------------------------");
    }

}
