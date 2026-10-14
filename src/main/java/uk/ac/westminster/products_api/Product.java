
package uk.ac.westminster.products_api;

public class Product {
    private Long id;
    private String name;
    private double price;
    private Address address;

    public Product() {}

    public Product(Long id, String name, double price, Address address) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Address getAddress() {
        return address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
