
package model;

public class Booking {
    private int id;
    private String username;   // ✅ Add this line
    private String type;
    private String itemName;
    private String date;

    // Default constructor
    public Booking() {}

    // Constructor for displaying bookings without ID
    public Booking(String username, String type, String itemName, String date) {
        this.username = username;
        this.type = type;
        this.itemName = itemName;
        this.date = date;
    }

    // Full constructor
    public Booking(int id, String username, String type, String itemName, String date) {
        this.id = id;
        this.username = username;
        this.type = type;
        this.itemName = itemName;
        this.date = date;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getType() {
        return type;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDate() {
        return date;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
