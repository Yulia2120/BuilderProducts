package Models;

public class Product {

    private int id;
    private String productName;
    private double weight;
    private double price;
    private int quantity;
    protected   Category category;
    protected Company company;

    public Product(int id, String name, double weight, double price, int quantity, Category category, Company company){
        this.id = id;
        this.productName = name;
        this.weight = weight;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.company = company;
    }

    public Product(int id) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public  double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public Company getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Product: {" +
                " id: " + id + "\t"+
                " productName: '" + productName + '\'' +"\t\t"+
                " weight: " + weight +"\t\t"+
                " price: " + price + "\t\t"+
                " quantity: " + quantity + "\t\t"+
                 getCategory() + '\'' +"\t\t"+
                 getCompany() + '\'' +"\t"+
                '}' + "\n";
    }

}
