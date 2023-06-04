import org.example.dao.Household;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.example.service.HouseholdSearchService.searchWareHousehold;

public class HouseholdSearchServiceTest {


    @Test
    public void testSearchWareHousehold() {
        List<Household> inventory = new ArrayList<>();
        inventory.add(new Household(1, "Chair", "Furniture", 49.99, 10));
        inventory.add(new Household(2, "Table", "Furniture", 99.99, 5));
        inventory.add(new Household(3, "Lamp", "Lighting", 19.99, 15));

        List<Household> results = new ArrayList<>();

        searchWareHousehold(inventory, "id", "2", results);
        System.out.println("Search by id - Expected: Table");
        printResults(results);
        results.clear();

        searchWareHousehold(inventory, "name", "lamp", results);
        System.out.println("Search by name - Expected: Lamp");
        printResults(results);
        results.clear();

        searchWareHousehold(inventory, "category", "Furniture", results);
        System.out.println("Search by category - Expected: Chair, Table");
        printResults(results);
        results.clear();

        searchWareHousehold(inventory, "price", "19.99", results);
        System.out.println("Search by price - Expected: Lamp");
        printResults(results);
        results.clear();

        searchWareHousehold(inventory, "quantity", "10", results);
        System.out.println("Search by quantity - Expected: Chair");
        printResults(results);
        results.clear();

        searchWareHousehold(inventory, "invalid", "value", results);
        System.out.println("Search with invalid parameter - Expected: Invalid search parameter.");
        printResults(results);
        results.clear();
    }

    private static void printResults(List<Household> results) {
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
    }

}
