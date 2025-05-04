

package model;

public class Car {
    private int id;
    private String model;
    private String company;
    private double price;  // Field matches 'price' now
    private String description;

    public Car(int id, String model, String company, double price, String description) {
        this.id = id;
        this.model = model;
        this.company = company;
        this.price = price;
        this.description = description;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getCompany() {
        return company;
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

    public void setModel(String model) {
        this.model = model;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setPrice(double price) {  // ✅ Corrected setter
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
