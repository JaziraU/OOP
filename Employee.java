import java.util.ArrayList;
import java.util.Random;

public class Employee {



    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String employeeId;
    private String startDate;
    private String title;
    private String department;


    public Employee(String firstName, String lastName, String phoneNumber, String email, String startDate, String title, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.employeeId = generateEmployeeId();
        this.startDate = startDate;
        this.title = title;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", startDate='" + startDate + '\'' +
                ", title='" + title + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    /*
    1- Create instance variables for employee firstName, lastName, phoneNumber, email, employeeId, startDate,
    title, department)
    2- Create getter and setter for instance variables
    3- Create the constructor to set the value to the instance variables
    4- Create one method to create the employeeId length of 20. This employee id must have letters as well.

       */

    public  Employee createEmployee(String firstName, String lastName, String phoneNumber,String email, String startDate, String title, String department){
       // Employee employee =new Employee(firstName,lastName,email,employeeId,startDate,title,department);

    /*
    this method need to return Employee according to the parameter
    call the constructor inside this method.
     */
      //  String firstName, String lastName, String phoneNumber, String email, String startDate, String title, String department
        return new Employee( firstName,lastName,phoneNumber,email,startDate,title,department);
    }

    public static String generateEmployeeId(){
        ArrayList<Character> letters= new ArrayList<>();
        for (char i = 97; i <123 ; i++) {
            char character=i;
            letters.add(character);
        }
        for (char i = 48; i < 58; i++) {
            letters.add(i);
        }

        String id="";
        for (int i = 0; i < 8; i++) {
            id+= letters.get(randomNumber(letters.size()));

        }
        id+="-";
        for (int i = 0; i < 4; i++) {
            id+= letters.get(randomNumber(letters.size()));

        }
        id+="-";
        for (int i = 0; i < 4; i++) {
            id+= letters.get(randomNumber(letters.size()));

        }
        id+="-";
        for (int i = 0; i < 4; i++) {
            id+= letters.get(randomNumber(letters.size()));

        }
        return id;

















        

        /*
        this method needs to return the employeeId Length of 20 which includes numbers as well.
        EmployeeId structure must be length of 20 UUID
        Example: 61c49c2e-7dcd-11ea-bc55
         */
    }


    public static int randomNumber(int boundary){
        Random random=new Random();
        int randomInt= random.nextInt(boundary);
        return randomInt;
    }



}
