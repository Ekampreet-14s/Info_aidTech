import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Student {
    private String rollNumber;
    private String name;
    private String address;
    private String phoneNumber;

    public Student(String rollNumber, String name, String address, String phoneNumber) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Roll Number: " + rollNumber + "\nName: " + name + "\nAddress: " + address + "\nPhone Number: "
                + phoneNumber;
    }
}

class StudentRecord {
    private List<Student> studentList;

    public StudentRecord() {
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void removeStudent(String rollNumber) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getRollNumber().equals(rollNumber)) {
                iterator.remove();
                System.out.println("Student with Roll Number " + rollNumber + " removed.");
                return;
            }
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    public void displayStudent(String rollNumber) {
        for (Student student : studentList) {
            if (student.getRollNumber().equals(rollNumber)) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    public void displayAllStudents() {
        for (Student student : studentList) {
            System.out.println(student);
            System.out.println("------------------------");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentRecord studentRecord = new StudentRecord();

        while (true) {
            System.out.println("\nStudent Record Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Student by Roll Number");
            System.out.println("4. Display All Students");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll Number: ");
                    String rollNumber = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();

                    Student newStudent = new Student(rollNumber, name, address, phoneNumber);
                    studentRecord.addStudent(newStudent);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Roll Number to remove: ");
                    String rollNumberToRemove = scanner.nextLine();
                    studentRecord.removeStudent(rollNumberToRemove);
                    break;

                case 3:
                    System.out.print("Enter Roll Number to display: ");
                    String rollNumberToDisplay = scanner.nextLine();
                    studentRecord.displayStudent(rollNumberToDisplay);
                    break;

                case 4:
                    System.out.println("All Students:");
                    studentRecord.displayAllStudents();
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
