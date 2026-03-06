
import java.util.HashMap;
import java.util.Map;

class HashMap {

    private HashMap<String, Integer> inventory;

    // Constructor to initialize inventory
    public RoomInventory() {
        inventory = new HashMap<>();

        // Register initial room types
        inventory.put("Standard Room", 10);
        inventory.put("Deluxe Room", 5);
        inventory.put("Suite", 2);
    }

    // Get availability of a room type
    public int getAvailability(String roomType) {
        if (inventory.containsKey(roomType)) {
            return inventory.get(roomType);
        }
        return 0;
    }

    // Update room availability
    public void updateAvailability(String roomType, int change) {
        if (inventory.containsKey(roomType)) {
            int current = inventory.get(roomType);
            inventory.put(roomType, current + change);
        } else {
            System.out.println("Room type not found.");
        }
    }

    // Display inventory
    public void displayInventory() {
        System.out.println("\nCurrent Room Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

public class UseCase3InventorySetup {

    public static void main(String[] args) {

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Display current inventory
        inventory.displayInventory();

        // Check availability
        System.out.println("\nAvailable Deluxe Rooms: "
                + inventory.getAvailability("Deluxe Room"));

        // Update inventory (simulate booking)
        inventory.updateAvailability("Deluxe Room", -1);

        System.out.println("\nAfter booking 1 Deluxe Room:");
        inventory.displayInventory();

        // Update inventory (adding room back)
        inventory.updateAvailability("Suite", 1);

        System.out.println("\nAfter adding 1 Suite:");
        inventory.displayInventory();
    }
}

