/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package backend;

/**
 *
 * @author yugoslavia
 */
public class EmployeeUser implements Record {

    private String employeeId;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    public EmployeeUser(String employeeId, String name, String email, String address, String phoneNumber) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getSearchKey() {
        return employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String lineRepresentation() {
        String rep = String.join(",", employeeId, name, email, address, phoneNumber);
        return rep;
    }

//    public static void main(String[] args) {
//        EmployeeUser emp = new EmployeeUser("124390", "hsfhrs", "bfhdo@.com", "123street", "1563557890");
//        System.out.println(emp.getSearchKey());
//        String l1 = emp.lineRepresentation();
//        System.out.println(l1);
//    }
}
