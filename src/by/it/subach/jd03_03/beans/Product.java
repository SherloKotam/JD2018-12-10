package by.it.subach.jd03_03.beans;

import java.text.NumberFormat;
import java.util.Locale;

public class Product {

    private long id;
    private String name;
    private double price;
    private String description;
    private long categories_id;

    public Product() {
    }

    public Product(long id, String name, double price, String description, long categories_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.categories_id = categories_id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {

        return price;
    }

    public String getDescription() {
        return description;
    }

    public long getCategories_id() {
        return categories_id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategories_id(long categories_id) {
        this.categories_id = categories_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
