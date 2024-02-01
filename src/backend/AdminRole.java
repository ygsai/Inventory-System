package backend;

import static constants.FileNames.EMPLOYEE_FILENAME;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AdminRole  {

    private EmployeeUserDatabase database;

    public AdminRole() throws IOException {
        this.database = new EmployeeUserDatabase();
        database.readFromFile();
    }

    public void addEmployee(String employeeId, String name, String email, String address, String phoneNumber) throws IOException {
        if (!database.contains(employeeId)) {
            EmployeeUser obj = new EmployeeUser(employeeId, name, email, address, phoneNumber);
            database.insertRecord(obj);
        } else {
            System.out.println("Employee already exist");
        }
    }

    public EmployeeUser[] getListOfEmployees() {
        ArrayList<Record> listREC = database.returnAllRecords();
        EmployeeUser[] arrayREC = new EmployeeUser[listREC.size()];
        arrayREC = listREC.toArray(arrayREC);
        return arrayREC;
    }
public boolean contains(String key) {
     ArrayList<Record> listREC = database.returnAllRecords();
        for (int i = 0; i < listREC.size(); i++) {
            if (key.equals(listREC.get(i).getSearchKey())) {
                return true;
            }
        }
        return false;
    }
    public void removeEmployee(String key) throws IOException {
        if (database.contains(key)) {
            database.deleteRecord(key);
        } else {
            System.out.println("Employee ID doesn't exist");
        }
    }
    public void logout() throws IOException {
        database.saveToFile();
    }

//    public static void main(String[] args) throws IOException {
//        AdminRole adr = new AdminRole();
//        adr.addEmployee("e1123", "yugo", "yugo@alexu.com", "23oskf-street", "012938475");
//        adr.addEmployee("E1123", "blaba", "rlkt@dkd.cm", "3039ssdf", "0293929");
//        EmployeeUser[] emparr = adr.getListOfEmployees();
//        adr.removeEmployee("e124");
//        adr.removeEmployee("e1123");
//        adr.logout();
//    }
}
