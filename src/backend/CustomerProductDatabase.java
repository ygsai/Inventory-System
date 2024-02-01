/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import static constants.FileNames.CUSTOMERPRODUCT_FILENAME;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author yugoslavia
 */
 class CustomerProductDatabase extends SystemDatabase {

    public CustomerProductDatabase() {
        super(CUSTOMERPRODUCT_FILENAME);
    }

    @Override
    public CustomerProduct createRecordFrom(String line) {
        String separate[] = line.split(",");
        if (separate.length == 3) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            CustomerProduct obj = new CustomerProduct(separate[0], separate[1], LocalDate.parse(separate[2], formatter));
            return obj;
        }
        return null;
    }

//    public static void main(String[] args) throws IOException {
//        CustomerProductDatabase custdb = new CustomerProductDatabase();
//        custdb.readFromFile();
//        CustomerProduct cust = custdb.createRecordFrom("7845345678, P2568,12-02-2022");
//        custdb.insertRecord(cust);
//        custdb.deleteRecord("P2394");
//        CustomerProduct cust2 = custdb.createRecordFrom("7890123, j3434,02-12-2022");
//        custdb.insertRecord(cust2);
//        custdb.saveToFile();
//
//    }

}