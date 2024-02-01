/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import static constants.FileNames.EMPLOYEE_FILENAME;
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
 class EmployeeUserDatabase extends SystemDatabase {

    public EmployeeUserDatabase() {
        super(EMPLOYEE_FILENAME);
    }

    @Override
    public EmployeeUser createRecordFrom(String line) {
        String separate[] = line.split(",");
        if (separate.length == 5) {
            EmployeeUser obj = new EmployeeUser(separate[0], separate[1], separate[2], separate[3], separate[4]);
            return obj;
        }
        return null;
    }
}
