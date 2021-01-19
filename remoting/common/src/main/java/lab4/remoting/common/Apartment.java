package lab4.remoting.common;

import java.io.Serializable;

public class Apartment /*implements Serializable*/ {

    private Long id;
    private String address;
    private String category;
    private String description;
    private String yearOfConstruction;
    private double price;

    public Apartment(Long id, String address, String category, String description, String yearOfConstruction, double price) {
        this.id = id;
        this.address = address;
        this.category = category;
        this.description = description;
        this.yearOfConstruction = yearOfConstruction;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYearOfConstruction() {
        return yearOfConstruction;
    }

    public void setYearOfConstruction(String yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", yearOfConstruction='" + yearOfConstruction + '\'' +
                ", price=" + price +
                '}';
    }
}
