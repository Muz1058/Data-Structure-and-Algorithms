import java.util.Scanner;

class Node{
    String job;
    Node next;

    public Node(String Job){
        this.job=Job;
        next=null;
    }
}
class PrinterLinkedList{
    Node front,rear;

    public PrinterLinkedList(){
        front=rear=null;
    }

    public void enqueue(String Job){
        Node newNode=new Node(Job);
        if(rear==null){
            front=rear=newNode;
        }
        else {
            rear.next=newNode;
            rear=newNode;
        }
    }
    public String dequeue(){
        if(front ==null){
            System.out.println("Queue is empty.");
            return null;
        }

        String dequeued=front.job;
        front=front.next;
        return dequeued;
    }
    public void display() {
        Node current = front;
        if (current == null) {
            System.out.println("Queue is empty!");
            return;
        }
        while (current != null) {
            System.out.print(current.job + " ");
            current = current.next;
        }
        System.out.println();
    }
    public String peek() {
        if (front == null) {
            System.out.println("Queue is empty.");
            return null;
        }
        System.out.println("Current job at front: " + front.job);
        return front.job;
    }

}


public class Printer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrinterLinkedList queue = new PrinterLinkedList();
        int choice;

        do {
            System.out.println("\n--- Print Job Management ---");
            System.out.println("1. Add a new print job");
            System.out.println("2. Process next print job");
            System.out.println("3. View current job at front");
            System.out.println("4. Display all jobs");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter job name: ");
                    String jobName = scanner.nextLine();
                    queue.enqueue(jobName);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.peek();
                    break;
                case 4:
                    queue.display();
                    break;
                case 5:
                    System.out.println("Exiting Print Job Manager...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
