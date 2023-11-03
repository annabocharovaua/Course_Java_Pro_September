package Task13.src;

import java.time.LocalDate;

public class Product {
    private int id;
    private String type;
    private double price;
    private boolean isDiscountAvailable;
    private LocalDate dateAdded;

    public Product(int id, String type, double price, boolean isDiscountAvailable, LocalDate dateAdded) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.isDiscountAvailable = isDiscountAvailable;
        this.dateAdded = dateAdded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDiscountAvailable() {
        return isDiscountAvailable;
    }

    public void setDiscountAvailable(boolean discountAvailable) {
        isDiscountAvailable = discountAvailable;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", isDiscountAvailable=" + isDiscountAvailable +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
