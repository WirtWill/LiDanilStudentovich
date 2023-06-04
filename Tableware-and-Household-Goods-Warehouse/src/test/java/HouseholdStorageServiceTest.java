import org.example.dao.Household;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.example.service.HouseholdStorageService.displaySortedWareHousehold;

public class HouseholdStorageServiceTest {

    @Test
    public void testDisplaySortedWareHousehold() {
        List<Household> household = new ArrayList<>();
        household.add(new Household(3, "Lamp", "Lighting", 19.99, 15));
        household.add(new Household(1, "Chair", "Furniture", 49.99, 10));
        household.add(new Household(2, "Table", "Furniture", 99.99, 5));

        System.out.println("Sort by ID:");
        displaySortedWareHousehold("id", household);

        System.out.println("Sort by price:");
        displaySortedWareHousehold("price", household);

        System.out.println("Sort by name:");
        displaySortedWareHousehold("name", household);

        System.out.println("Sort by quantity:");
        displaySortedWareHousehold("quantity", household);

        System.out.println("Sort by category:");
        displaySortedWareHousehold("category", household);

        System.out.println("Sort by invalid criterion:");
        displaySortedWareHousehold("invalid", household);

    }
}
