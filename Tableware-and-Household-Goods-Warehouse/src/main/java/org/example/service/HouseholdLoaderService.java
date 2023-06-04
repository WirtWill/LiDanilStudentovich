package org.example.service;

import org.example.dao.Household;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HouseholdLoaderService {
    public static List<Household> loadHousehold() {
        List<Household> inventory = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/org/example/dao/Household.csv"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 5) {
                    int id = Integer.parseInt(fields[0]);
                    String name = fields[1];
                    String category = fields[2];
                    double price = Double.parseDouble(fields[3]);
                    int quantity = Integer.parseInt(fields[4]);
                    Household item = new Household(id, name, category, price, quantity);
                    inventory.add(item);
                } else {
                    System.err.println("Invalid data format in Household.csv file: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading Household.csv file: " + e.getMessage());
        }

        return inventory;
    }

}
