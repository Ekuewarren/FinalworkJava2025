

package model;

public class Activity {
    private int id;
    private String name;
    private String location;
    private double price;
    private String description;

    // Constructor
    public Activity(int id, String name, String location, double price, String description) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.description = description;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
