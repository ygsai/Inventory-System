package backend;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class EmployeeRole {

    private ProductDatabase productsDatabase;
    private CustomerProductDatabase customerProductDatabase;

    public EmployeeRole() throws IOException {
        this.productsDatabase = new ProductDatabase();
        this.customerProductDatabase = new CustomerProductDatabase();
        customerProductDatabase.readFromFile();
        productsDatabase.readFromFile();
    }

    public void addProduct(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price) throws IOException {
        if (quantity < 0) {
            System.out.println("Quantity should be a positive value.");
        } else {
            Product product = new Product(productID, productName, manufacturerName, supplierName, quantity, price);
            productsDatabase.insertRecord(product);
            

        } 
    }

    public Product[] getListOfProducts() {
        ArrayList<Record> listREC = productsDatabase.returnAllRecords();
        Product[] arrayREC = new Product[listREC.size()];
        arrayREC = listREC.toArray(arrayREC);
        return arrayREC;
    }

    public CustomerProduct[] getListOfPurchasingOperations() {
        ArrayList<Record> customerProducts = customerProductDatabase.returnAllRecords();
        CustomerProduct[] customerProductArray = new CustomerProduct[customerProducts.size()];
        customerProducts.toArray(customerProductArray);
        return customerProductArray;
    }

    public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate) throws IOException {
        Product product =  (Product) productsDatabase.getRecord(productID);

        if (product != null && product.getQuantity() > 0) {
            product.setQuantity(product.getQuantity() - 1);

            CustomerProduct purchase = new CustomerProduct(customerSSN, productID, purchaseDate);
            customerProductDatabase.insertRecord(purchase);
            
            return true;
        }
        return false;
    }

    public double returnProduct(String customerSSN, String productID, LocalDate purchaseDate, LocalDate returnDate) throws IOException {
        Product product = (Product) productsDatabase.getRecord(productID);
        String searchKey = customerSSN + "," + productID + "," + purchaseDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        long daysBetween = purchaseDate.until(returnDate).getDays();
        if (returnDate.isBefore(purchaseDate) || product == null || (!(customerProductDatabase.contains(searchKey))) || daysBetween > 14) {
            return -1;
        }
        product.setQuantity(product.getQuantity() + 1);
        customerProductDatabase.deleteRecord(searchKey);
        
        return product.getPrice();
    }

    public boolean contains(String key) {
     ArrayList<backend.Record> listREC = productsDatabase.returnAllRecords();
        for (int i = 0; i < listREC.size(); i++) {
            if (key.equals(listREC.get(i).getSearchKey())) {
                return true;
            }
        }
        return false;
    }
    
    public void logout() throws IOException {
        productsDatabase.saveToFile();
        customerProductDatabase.saveToFile();
    }
}
