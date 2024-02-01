/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author yugoslavia
 */
 abstract class SystemDatabase {

    private ArrayList<Record> records;
    private String fileName;

    public SystemDatabase(String fileName) {
        this.records = new ArrayList<>();
        this.fileName = fileName;
    }

    public void readFromFile() throws IOException {
        File readEU = new File(fileName);
        try {
            Scanner scan = new Scanner(readEU);
            while (scan.hasNextLine()) {
                String fileOBJ = scan.nextLine();
                this.records.add(createRecordFrom(fileOBJ));
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not Found");
        }
    }

    public abstract Record createRecordFrom(String line);

    public ArrayList<Record> returnAllRecords() {
        return records;
    }

    public Record getRecord(String key) {
        for (int i = 0; i < this.records.size(); i++) {
            if (key.equals(this.records.get(i).getSearchKey())) {
                return this.records.get(i);
            }
        }
        return null;
    }

    public boolean contains(String key) {
        for (int i = 0; i < this.records.size(); i++) {
            if (key.equals(this.records.get(i).getSearchKey())) {
                return true;
            }
        }
        return false;
    }

    public void insertRecord(Record record) {
        if (record != null) {
            if (!contains(record.getSearchKey())) {
                this.records.add(record);
            } else {
                System.out.println("Employee is already added");
            }
        }
    }

    public void deleteRecord(String key) {
        if (contains(key)) {
            this.records.remove(getRecord(key));
        } else {
            System.out.println("There's no employee with this id");
        }
    }

    public void saveToFile() throws IOException {

        try {
            FileWriter fwf = new FileWriter(fileName);
            for (int i = 0; i < this.records.size(); i++) {
                fwf.write(this.records.get(i).lineRepresentation());
                fwf.write(System.lineSeparator());
            }
            fwf.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not Found");
        }
    }
}
