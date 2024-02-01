/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author yugoslavia
 */
public class Product implements Record {

    private String productID;
    private String productName;
    private String manufacturerName;
    private String supplierName;
    private int quantity;
    private float price;

    public Product(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price) {
        this.productID = productID;
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.supplierName = supplierName;
        if (quantity >= 0) {
            this.quantity = quantity;
        }
        if (price >= 0) {
            this.price = price;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        do {
            if (quantity >= 0) {
                this.quantity = quantity;
            } else {
                System.out.println("Enter a positive quantity");
            }
        } while (quantity < 0);
    }

    public void setPrice(float price) {
        do {
            if (price >= 0) {
                this.price = price;
            } else {
                System.out.println("Enter a positive price");
            }
        } while (price < 0);
    }

    @Override
    public String lineRepresentation() {
        return productID + "," + productName + "," + manufacturerName + "," + supplierName + "," + quantity + "," + price;
    }

    @Override
    public String getSearchKey() {
        return productID;
    }

//    public static void main(String[] args) {
//        Product pr = new Product("p1223", "prod1", "india", "marwan", 10, 1000);
//        pr.setQuantity(100);
//        System.out.println("Product's ID:" + pr.getSearchKey());
//        System.out.println("Product's Data:" + pr.lineRepresentation());
//    }

}
