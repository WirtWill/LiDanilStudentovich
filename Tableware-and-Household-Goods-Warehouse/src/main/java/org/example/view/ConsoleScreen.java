package org.example.view;

import static org.example.controller.ConsoleViewController.manageHousehold;

public class ConsoleScreen {

    public static void main(String[] args) {
        String warehouseName = "Tableware and Household Goods Warehouse";
        String creationDate = "May 28, 2023";
        String developerName = "John Smith";
        String developerEmail = "johnsmith@example.com";

        System.out.println(warehouseName + " (Created on " + creationDate + ")");
        System.out.println("Developer: " + developerName + " (" + developerEmail + ")");

        System.out.println("\nMenu Choices:");
        System.out.println("A. Search for warehouse items");
        System.out.println("B. Display all warehouse items");
        System.out.println("C. Quit the program");

        manageHousehold();
    }

}
