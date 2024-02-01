/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author yugoslavia
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomerProduct implements Record {

    private String customarSSN;
    private String productID;
    private LocalDate purchaseDate = LocalDate.now();

    public CustomerProduct(String customarSSN, String productID, LocalDate purchaseDate) {
        this.customarSSN = customarSSN;
        this.productID = productID;
        this.purchaseDate = purchaseDate;
    }

    public String getCustomerSSN() {
        return customarSSN;
    }

    public String getProductID() {
        return productID;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    @Override
    public String lineRepresentation() {
        String rep = String.join(",", getCustomerSSN(), getProductID(), getPurchaseDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")).toString());
        return rep;
    }

    @Override
    public String getSearchKey() {
        return getCustomerSSN() + "," + getProductID() + "," + getPurchaseDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
//
//    public static void main(String[] args) {
//        CustomerProduct cstmpdt = new CustomerProduct("976666358", "M3665", LocalDate.parse("10-12-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
//        System.out.println(cstmpdt.lineRepresentation());
//        System.out.println(cstmpdt.getSearchKey());
//    }

}
