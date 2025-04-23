
import java.util.ArrayList;
import java.util.Scanner;
class Student {
    String rollNo;
    String name;
    String course;
    double GPA;

    public Student(String rollNo, String name, String course, double GPA) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Course: " + course + ", GPA: " + GPA;
    }
}




public class  StudentManagerArrayList{
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added.");
    }

    public void removeStudent(String rollNo) {
        for (Student s : students) {
            if (s.rollNo.equals(rollNo)) {
                students.remove(s);
                System.out.println("Student removed: " + s.name);
                return;
            }
        }
        System.out.println("Student not found.");
    }


    public void updateGPA(String rollNo, double newGPA) {
        for (Student s : students) {
            if (s.rollNo.equals(rollNo)) {
                s.GPA = newGPA;
                System.out.println("GPA updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void searchStudent(String rollNo) {
        for (Student s : students) {
            if (s.rollNo.equals(rollNo)) {
                System.out.println("Student found: " + s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void printAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    public static void main(String[] args) {
        StudentManagerArrayList manager = new StudentManagerArrayList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Management Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Update GPA");
            System.out.println("4. Search Student");
            System.out.println("5. Print All Students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    String rollNo = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();
                    System.out.print("Enter GPA: ");
                    double gpa = scanner.nextDouble();
                    manager.addStudent(new Student(rollNo, name, course, gpa));
                    break;
                case 2:
                    System.out.print("Enter Roll No to remove: ");
                    rollNo = scanner.nextLine();
                    manager.removeStudent(rollNo);
                    break;
                case 3:
                    System.out.print("Enter Roll No to update GPA: ");
                    rollNo = scanner.nextLine();
                    System.out.print("Enter new GPA: ");
                    gpa = scanner.nextDouble();
                    manager.updateGPA(rollNo, gpa);
                    break;
                case 4:
                    System.out.print("Enter Roll No to search: ");
                    rollNo = scanner.nextLine();
                    manager.searchStudent(rollNo);
                    break;
                case 5:
                    manager.printAllStudents();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

}

