import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class StudentManagerLinkedList {
    private LinkedList<Student> students = new LinkedList<>();

    public void addFirst(Student s) {
        students.addFirst(s);
        System.out.println("Student added at beginning.");
    }

    public void addLast(Student s) {
        students.addLast(s);
        System.out.println("Student added at end.");
    }

    public void removeFirst() {
        if (!students.isEmpty()) {
            students.removeFirst();
            System.out.println("First student removed.");
        } else {
            System.out.println("List is empty.");
        }
    }

    public void removeLast() {
        if (!students.isEmpty()) {
            students.removeLast();
            System.out.println("Last student removed.");
        } else {
            System.out.println("List is empty.");
        }
    }


    public void removeByRollNo(String rollNo) {
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

    public void traverseForward() {
        System.out.println("Traversing Forward:");
        ListIterator<Student> iterator = students.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void traverseBackward() {
        System.out.println("Traversing Backward:");
        ListIterator<Student> iterator = students.listIterator(students.size());
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }

    public static void main(String[] args) {
        StudentManagerLinkedList manager = new StudentManagerLinkedList();
        manager.addLast(new Student("S101", "Hassan", "CS", 3.4));
        manager.addFirst(new Student("S100", "Ayesha", "SE", 3.9));
        manager.traverseForward();

        manager.updateGPA("S101", 3.95);
        manager.searchStudent("S101");

        manager.removeByRollNo("S100");
        manager.traverseBackward();

        manager.removeFirst();

    }
}
