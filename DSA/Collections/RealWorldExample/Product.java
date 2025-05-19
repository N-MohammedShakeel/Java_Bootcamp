package Java_Bootcamp.DSA.Collections.RealWorldExample;

// Class to represent a Product (for inventory demo)
class Product {
    private String sku;
    private String name;
    private int quantity;

    public Product(String sku, String name, int quantity) {
        this.sku = sku;
        this.name = name;
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{sku=" + sku + ", name=" + name + ", quantity=" + quantity + "}";
    }
}
