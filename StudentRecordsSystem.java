import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentRecordsSystem {
    private ArrayList<Integer> studentRollNumbers;

    public StudentRecordsSystem() {
        studentRollNumbers = new ArrayList<>();
    }

    public void insertRollNumber(int rollNumber, int position) {
        if (position < 0 || position > studentRollNumbers.size()) {
            System.out.println("Invalid position.");
            return;
        }
        studentRollNumbers.add(position, rollNumber);
    }

    public boolean searchRollNumber(int rollNumber) {
        return studentRollNumbers.contains(rollNumber);
    }

    public boolean deleteRollNumber(int rollNumber) {
        return studentRollNumbers.remove(Integer.valueOf(rollNumber));
    }

    public int countEnrolledStudents() {
        return studentRollNumbers.size();
    }

    public int findHighestRollNumber() {
        if (studentRollNumbers.isEmpty()) {
            System.out.println("No students enrolled.");
            return -1;
        }
        return Collections.max(studentRollNumbers);
    }

    public void displayAllStudents() {
        System.out.println("Enrolled Students: " + studentRollNumbers);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentRecordsSystem recordsSystem = new StudentRecordsSystem();
        int choice;

        do {
            System.out.println("\nStudent Records System Menu:");
            System.out.println("1. Insert Roll Number");
            System.out.println("2. Search Roll Number");
            System.out.println("3. Delete Roll Number");
            System.out.println("4. Count Enrolled Students");
            System.out.println("5. Find Highest Roll Number");
            System.out.println("6. Display All Students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    System.out.print("Enter position: ");
                    int position = scanner.nextInt();
                    recordsSystem.insertRollNumber(rollNumber, position);
                    break;
                case 2:
                    System.out.print("Enter roll number to search: ");
                    rollNumber = scanner.nextInt();
                    System.out.println("Enrolled: " + recordsSystem.searchRollNumber(rollNumber));
                    break;
                case 3:
                    System.out.print("Enter roll number to delete: ");
                    rollNumber = scanner.nextInt();
                    System.out.println("Deleted: " + recordsSystem.deleteRollNumber(rollNumber));
                    break;
                case 4:
                    System.out.println("Number of enrolled students: " + recordsSystem.countEnrolledStudents());
                    break;
                case 5:
                    System.out.println("Highest Roll Number: " + recordsSystem.findHighestRollNumber());
                    break;
                case 6:
                    recordsSystem.displayAllStudents();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 0);
        scanner.close();
    }
}
