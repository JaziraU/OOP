import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EmployeeAppRunner {

    private static Scanner scanner = new Scanner(System.in);
    static HRDepartment appleHR = new HRDepartment("SF", "Apple");


    public static void main(String[] args) {


        welcome();
        printOptions();
        String option;

        /*
        implement the choice logic
         */
        do {
            option = scanner.next();
            makeAChoice(option);
        } while (!option.equals("0"));
    }

    private static void makeAChoice(String choice) {

        switch (choice) {
            case "0":
                System.out.println("Thank you for using our application");
                break;
            case "1":
                createNewEmployee();
                break;
            case "2":

                printEmployeeInfo();
                // NOTE: ask user order type of this list. There should be three types of order according to their name--> Default order, ascending or descending order
                // If the user enter:
                // "default" then the user should see the list in insertion order,
                // "ascending" print this list ascending order
                // "descending" print this list descending order
                break;
            case "3":
                printEmailAddress();

                // NOTE: ask user to enter Department Name then print all employee email addresses according to this email address
                break;
            case "4":

                updateEmailAddress();
                break;

            case "5":
                updatePhoneNumber();
                break;

            case "6":
                updateEmployeeTitle();
                break;
            case "7":
                printWithEmployeeId();
                break;
            case "8":
                removeEmployee();
                break;
            case "9":
                printDepartmentNumber();
                break;
            case "10":
                printOptions();
                break;

        }
    }

    public static void welcome() {

        System.out.println("Welcome to the Employee Management System");
    }

    public static void printOptions() {

        System.out.println("Hello! Please choose on of the following options");
        System.out.println("1 - For new employee");
        System.out.println("2 - To print all employee names, titles and employee ids");
        System.out.println("3 - To print all employee email address");
        System.out.println("4 - To update the employee email address");
        System.out.println("5 - To update the employee phone number");
        System.out.println("6 - To update the employee title");
        System.out.println("7 - To search the employee with employee id and print all other employee information");
        System.out.println("8 - To remove the employee");
        System.out.println("9 - To print all the department names with department employee number");
        System.out.println("10 - To print available options");
        System.out.println("0 - To exit");
    }

    public static int checkId(String id) {
        int position = -1;
        for (int i = 0; i < appleHR.getAllCards().size(); i++) {
            if (appleHR.getAllCards().get(i).getEmployeeId().equalsIgnoreCase(id)) {
                position = i;
            }

        }
        return position;
    }

    public static void printDepartmentNumber() {
        boolean flag = true;
        while (flag) {
            System.out.println("Which department's you want to print employee numbers? ");
            String department = scanner.next();
            if (department.equalsIgnoreCase("finance") ||
                    department.equalsIgnoreCase("marketing") ||
                    department.equalsIgnoreCase("IT") ||
                    department.equalsIgnoreCase("HR") ||
                    department.equalsIgnoreCase("purchasing") ||
                    department.equalsIgnoreCase("sales")
            ) {
                int count = 0;
                flag = false;
                for (int i = 0; i < appleHR.getAllCards().size(); i++) {
                    if (appleHR.getAllCards().get(i).getDepartment().equalsIgnoreCase(department)) {
                        count++;
                    }
                }
                System.out.println(department + " has " + count + " employees");

            } else
                System.out.println("Please enter  one of the department names (Finance, Marketing, IT, HR, Purchasing, Sales)");
        }
    }


    public static void removeEmployee() {
        boolean flag = true;
        while (flag) {

            System.out.println("Please enter ID to remove all information from the system");
            String id = scanner.next();

            int position = checkId(id);

            if (position == -1) {
                System.out.println("Please enter a valid ID");
            } else {
                flag = false;
                appleHR.getAllCards().remove(position);
                System.out.println("Your information has been removed successfully");
            }
        }


    }


    public static void printWithEmployeeId() {
        boolean flag = true;
        while (flag) {

            System.out.println("Please enter ID to print your information");
            String id = scanner.next();

            int position = checkId(id);

            if (position == -1) {
                System.out.println("Please enter a valid ID");
            } else {
                flag = false;
                System.out.println(appleHR.getAllCards().get(position).toString());


            }
        }

    }

    public static void updateEmployeeTitle() {
        boolean flag = true;
        while (flag) {

            System.out.println("Please enter your ID to update your title");
            String id = scanner.next();

            int position = checkId(id);

            if (position == -1) {
                System.out.println("Please enter a valid ID");
            } else {
                flag = false;
                System.out.println("Please enter  your new title to update");
                String title = scanner.next();
                appleHR.getAllCards().get(position).setTitle(title);
                System.out.println("Your information has been updated successfully." +
                        "You are a " + title + "now");


            }
        }


    }


    public static void updatePhoneNumber() {
        boolean flag = true;
        while (flag) {

            System.out.println("Please enter your ID to update your phone number");
            String id = scanner.next();

            int position = checkId(id);

            if (position == -1) {
                System.out.println("Please enter a valid ID");
            } else {
                flag = false;

                boolean flag2 = true;
                while (flag2) {
                    System.out.println("Please enter phone number to update");
                    String phoneNumber = scanner.next();

                    String regex1 = "^\\d{10}$";
                    Pattern pattern1 = Pattern.compile(regex1);
                    Matcher matcher1 = pattern1.matcher(phoneNumber);
                    boolean result1 = matcher1.matches();

                    if (result1) {
                        appleHR.getAllCards().get(position).setPhoneNumber(phoneNumber);
                        System.out.println("Your information has been updated successfully");
                        flag2 = false;
                    } else {
                        System.out.println("Please enter 10 digit phone number");
                    }
                }
            }


        }

    }


    public static boolean updateEmailAddress() {
        boolean flag = true;
        while (flag) {


            System.out.println("Please enter your ID to update your email address");
            String id = scanner.next();

            int position = checkId(id);

            if (position == -1) {
                System.out.println("Please enter a valid ID");
            } else {
                flag = false;

                boolean flag2 = true;
                while (flag2) {


                    System.out.println("Please enter new email address to update");
                    String email = scanner.nextLine();

                    if (email.contains("@gmail.com") || email.contains("yahoo.com")) {
                        appleHR.getAllCards().get(position).setEmail(email);
                        System.out.println("Your email address updated successfully with " + email);
                        flag2 = false;
                        return true;
                    } else {
                        System.out.println("Please enter an email with gmail.com or yahoo.com");
                    }
                }
            }
        }
        return false;
    }

    public static void printEmailAddress() {
        boolean flag = true;
        while (flag) {
            System.out.println("Which department's you want to print email addresses? ");
            String department = scanner.next();
            if (department.equalsIgnoreCase("finance") ||
                    department.equalsIgnoreCase("marketing") ||
                    department.equalsIgnoreCase("IT") ||
                    department.equalsIgnoreCase("HR") ||
                    department.equalsIgnoreCase("purchasing") ||
                    department.equalsIgnoreCase("sales")
            ) {
                flag = false;
                for (int i = 0; i < appleHR.getAllCards().size(); i++) {
                    if (appleHR.getAllCards().get(i).getDepartment().equalsIgnoreCase(department)) {
                        System.out.println("Email address is " + appleHR.getAllCards().get(i).getEmail());
                    }

                }
            } else
                System.out.println("Please enter  one of the department names (Finance, Marketing, IT, HR, Purchasing, Sales)");
        }


    }


    public static void printEmployeeInfo() {
        boolean flag = true;
        while (flag) {


            System.out.println("What order type you want to see the info.1 for default" +
                    "2 for ascending 3 for descending");

            int orderType = scanner.nextInt();
            if (orderType == 1 || orderType == 2 || orderType == 3) {
                flag = false;
                switch (orderType) {
                    case 1:
                        for (int i = 0; i < appleHR.getAllCards().size(); i++) {
                            System.out.println("Employee name :" + appleHR.getAllCards().get(i).getFirstName() +
                                    "Employee title :" + appleHR.getAllCards().get(i).getTitle() +
                                    "Employee Id :" + appleHR.getAllCards().get(i).getEmployeeId());
                        }
                        break;
                    case 2:

                        ArrayList<String> names = new ArrayList<>();

                        for (int i = 0; i < appleHR.getAllCards().size(); i++) {
                            names.add(("Employee name :" + appleHR.getAllCards().get(i).getFirstName() +
                                    "Employee title :" + appleHR.getAllCards().get(i).getTitle() +
                                    "Employee Id :" + appleHR.getAllCards().get(i).getEmployeeId()));
                        }

                        Collections.sort(names);

                        for (String info : names) {
                            System.out.println(info);
                        }
                        break;


                    case 3:
                        ArrayList<String> names2 = new ArrayList<>();

                        for (int i = 0; i < appleHR.getAllCards().size(); i++) {
                            names2.add(("Employee name :" + appleHR.getAllCards().get(i).getFirstName() +
                                    "Employee title :" + appleHR.getAllCards().get(i).getTitle() +
                                    "Employee Id :" + appleHR.getAllCards().get(i).getEmployeeId()));
                        }

                        Collections.sort(names2);

                        Collections.reverse(names2);
                        for (String info : names2) {
                            System.out.println(info);
                        }

                }

            } else System.out.println("Please enter a number between 1-3");

        }
    }


    public static void createNewEmployee() {

        boolean flag = true;
        while (flag) {
            System.out.println("Please enter  first name for employee");
            String newName = scanner.next();
            System.out.println("Please enter your last name ");
            String lastName = scanner.next();


            String fullName = newName + lastName;
            String regex = "^[a-zA-Z\\s]+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(fullName);
            boolean result = matcher.matches();

            if (result) {

                boolean flag2 = true;
                while (flag2) {

                    System.out.println("Please enter phone number");
                    String phoneNumber = scanner.next();

                    String regex1 = "^\\d{10}$";
                    Pattern pattern1 = Pattern.compile(regex1);
                    Matcher matcher1 = pattern1.matcher(phoneNumber);
                    boolean result1 = matcher1.matches();


                    if (result1) {

                        boolean flag3 = true;
                        while (flag3) {


                            System.out.println("Please enter your email");
                            String email = scanner.next();


                            if (email.contains("@gmail.com") || email.contains("yahoo.com")) {

                                System.out.println("Please enter start Date");
                                String startDate = scanner.next();

                                System.out.println("Please enter title");
                                String title = scanner.next();

                                boolean flag4 = true;
                                while (flag4) {


                                    System.out.println("Please enter department");
                                    String department = scanner.next();


                                    if (department.equalsIgnoreCase("finance") ||
                                            department.equalsIgnoreCase("marketing") ||
                                            department.equalsIgnoreCase("IT") ||
                                            department.equalsIgnoreCase("HR") ||
                                            department.equalsIgnoreCase("purchasing") ||
                                            department.equalsIgnoreCase("sales")
                                    ) {


                                        Employee employee = new Employee(newName, lastName, phoneNumber, email, startDate, title, department);
                                        appleHR.addEmployee(employee);
                                        System.out.println("You created an employee." +
                                                "Employee name is : " + employee.getFirstName() +
                                                "Employee Id is : " + employee.getEmployeeId());
                                        flag4 = false;

                                    } else {
                                        System.out.println("Please enter  one of the department names (Finance, Marketing, IT, HR, Purchasing, Sales)");
                                    }

                                }


                                //   The Company has 6 different department Finance, Marketing, IT, HR, Purchasing and Sales department.


                                flag3 = false;
                            } else {
                                System.out.println("Please enter an  email  with gmail.com or yahoo.com");
                                flag3 = true;

                            }
                        }


                        flag2 = false;
                    } else {
                        System.out.println("Please enter 10 digit valid phone number");
                    }
                }


                flag = false;
            } else {
                System.out.println("Please provide valid name and last name");

            }
        }


        // NOTE: Employee firstName and LastName can not include any digit or symbol only upper or lower cases letter and each of them length can not be less 3
        // NOTE: Employee email address can be only gmail or yahoo account.
        // NOTE: Employee phone number must be 10 digit
        // NOTE: Employee Department can not be other than given 6 department.


    }
}
