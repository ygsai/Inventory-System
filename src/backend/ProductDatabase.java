/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import static constants.FileNames.PRODUCT_FILENAME;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author yugoslavia
 */
 class ProductDatabase extends SystemDatabase {

    public ProductDatabase() {
        super(PRODUCT_FILENAME);
    }

    @Override
    public Product createRecordFrom(String line) {
        String[] parts = line.split(",");
        if (parts.length == 6) {
            return new Product(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), Float.parseFloat(parts[5]));
        }
        return null;
    }

//    public static void main(String[] args) throws IOException {
//        ProductDatabase pdb = new ProductDatabase();
//        pdb.readFromFile();
//        Product prdt = pdb.createRecordFrom("P2394,Laptop,Apple,TechSupplier,10,1500");
//        pdb.insertRecord(prdt);
//        pdb.deleteRecord("P2394");
//        pdb.saveToFile();
//    }
}
