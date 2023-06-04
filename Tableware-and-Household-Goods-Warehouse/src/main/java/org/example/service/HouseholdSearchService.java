package org.example.service;

import org.example.dao.Household;

import java.util.List;

public class HouseholdSearchService {
    public static void searchWareHousehold(List<Household> inventory, String searchParameter, String searchValue, List<Household> results) {
        try {
            for (Household household : inventory) {
                if (searchParameter.equalsIgnoreCase("id")) {
                    if (household.getId() == Integer.parseInt(searchValue)) {
                        results.add(household);
                    }
                } else if (searchParameter.equalsIgnoreCase("name")) {
                    if (household.getName().toLowerCase().contains(searchValue.toLowerCase())) {
                        results.add(household);
                    }
                } else if (searchParameter.equalsIgnoreCase("category")) {
                    if (household.getCategory().toLowerCase().contains(searchValue.toLowerCase())) {
                        results.add(household);
                    }
                } else if (searchParameter.equalsIgnoreCase("price")) {
                    if (household.getPrice() == Double.parseDouble(searchValue)) {
                        results.add(household);
                    }
                } else if (searchParameter.equalsIgnoreCase("quantity")) {
                    if (household.getQuantity() == Integer.parseInt(searchValue)) {
                        results.add(household);
                    }
                } else {
                    System.out.println("Invalid search parameter.");
                    return;
                }
            }

            if (results.isEmpty()) {
                System.out.println("No products found.");
                return;
            }

            System.out.println("Search results:");
            System.out.println("-----------------------------------------");
            System.out.printf("%-4s %-20s %-25s %-6s %-8s\n", "ID", "Name", "Category", "Price", "Quantity");
            System.out.println("-----------------------------------------");

            for (Household household : results) {
                System.out.printf("%-4d %-20s %-25s %-6.2f %-8d\n",
                        household.getId(), household.getName(), household.getCategory(),
                        household.getPrice(), household.getQuantity());
            }

            System.out.println("-----------------------------------------");

        } catch (NumberFormatException e) {
            System.out.println("Invalid search value. Please provide a valid value.");
        }
    }


}
