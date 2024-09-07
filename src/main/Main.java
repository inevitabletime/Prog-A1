package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("*STUDENT MANAGEMENT APPLICATION*");
            System.out.println("************************************************************************");
            System.out.println("Enter (1) to launch menu or any other key to exit");

            String input = scanner.nextLine();
            if (input.equals("1")) {
                showMenu(scanner);
            } else {
                System.out.println("Exiting application. Goodbye!");
                System.exit(0);
            }
        }
    }

    private static void showMenu(Scanner scanner) {
        while (true) {
            System.out.println("*Please select one of the following menu items*");
            System.out.println("(1) Capture a new student");
            System.out.println("(2) Search for a student");
            System.out.println("(3) Delete a student");
            System.out.println("(4) Print student report");
            System.out.println("(5) Exit application");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    captureNewStudent(scanner);
                    break;
                case "2":
                    searchStudent(scanner);
                    break;
                case "3":
                    deleteStudent(scanner);
                    break;
                case "4":
                    printStudentReport();
                    break;
                case "5":
                    System.out.println("Exiting application. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
            System.out.println("Enter (1) to launch menu or any other key to exit");
            String continueOption = scanner.nextLine();
            if (!continueOption.equals("1")) {
                System.out.println("Exiting application. Goodbye!");
                System.exit(0);
            }
        }
    }

    private static void captureNewStudent(Scanner scanner) {
        System.out.println("*CAPTURE A NEW STUDENT*");
        System.out.println("**********************************************");
        System.out.println("Enter the student id : ");
        String id = scanner.nextLine();

        System.out.println("Enter the student name : ");
        String name = scanner.nextLine();

        int age = -1;
        while (age < 16) {
            System.out.println("Enter the student age : ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age < 16) {
                    System.out.println("You have entered an incorrect student age!!!");
                }
            } catch (NumberFormatException e) {
                System.out.println("You have entered an incorrect student age!!!");
            }
        }

        System.out.println("Enter the student email : ");
        String email = scanner.nextLine();

        System.out.println("Enter the student course : ");
        String course = scanner.nextLine();

        Student.saveStudent(id, name, age, email, course);

        System.out.println("Student details have been successfully saved");
    }

    private static void searchStudent(Scanner scanner) {
        System.out.println("Enter the student id to search : ");
        String searchId = scanner.nextLine();

        Student student = Student.searchStudent(searchId);
        if (student != null) {
            System.out.println("******************************************");
            System.out.println("Student Id : " + student.getStudentId());
            System.out.println("Student Name : " + student.getStudentName());
            System.out.println("Student Age : " + student.getStudentAge());
            System.out.println("Student Email : " + student.getStudentEmail());
            System.out.println("Student Course : " + student.getStudentCourse());
            System.out.println("******************************************");
        } else {
            System.out.println("**********************************************");
            System.out.println("Student with Student id : " + searchId + " was not found!");
            System.out.println("**********************************************");
        }
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.println("Enter the Student Id to delete : ");
        String deleteId = scanner.nextLine();

        Student.deleteStudent(deleteId);
        Student student = Student.getStudentById(deleteId);
        if (student == null) {
            System.out.println("**********************************************************************************");
            System.out.println("Student with Student Id: " + deleteId + " WAS deleted!");
            System.out.println("******************************************************************************");
        } else {
            System.out.println("Student with Student Id: " + deleteId + " was not found!");
        }
    }

    private static void printStudentReport() {
        int count = 1;
        for (Student student : Student.getStudentList()) {
            System.out.println("*STUDENT " + count++ + "*");
            System.out.println("*****************************************");
            System.out.println("Student Id : " + student.getStudentId());
            System.out.println("Student Name : " + student.getStudentName());
            System.out.println("Student Age : " + student.getStudentAge());
            System.out.println("Student Email : " + student.getStudentEmail());
            System.out.println("Student Course : " + student.getStudentCourse());
            System.out.println("*****************************************");
        }
    }
}
