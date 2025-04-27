import java.util.LinkedList;
import java.util.Queue;

class Customer{

    private final int ticketNumber;
    private String name;
    private String issueDescription;

    public Customer(int ticketNumber, String name, String issue) {
        this.ticketNumber = ticketNumber;
        this.name = name;
        this.issueDescription = issue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    @Override
    public String toString() {
        return "Ticket #" + ticketNumber + ": " + name + " - " + issueDescription;
    }
}
class CustomerHelpDeskQueue{
    Queue<Customer> urgentQueue=new LinkedList<>();
    Queue<Customer> normalQueue=new LinkedList<>();
    private int ticketNumber=100;
    public void enqueue(String name,String issue){
        enqueue(name,issue,"normal");
    }

    public void enqueue(String name,String issue,String priority){
        if (isBlank(name) || isBlank(issue) || isBlank(priority)) {
            System.out.println("Error: Name and issue description must not be blank.");
        }

        Customer newCustomer = new Customer(ticketNumber++, name.trim(), issue.trim());

        if (priority.equalsIgnoreCase("urgent")) {
            urgentQueue.add(newCustomer);
            System.out.println("Urgent ticket created: " + newCustomer);
        }
        else {
            normalQueue.add(newCustomer);
            System.out.println("Normal ticket created: " + newCustomer);
        }

    }

    public void dequeue() {
        if (!urgentQueue.isEmpty()) {
            Customer served = urgentQueue.poll();
            System.out.println("Serving URGENT Customer:" + served);
        }
        else if (!normalQueue.isEmpty()) {
            Customer served = normalQueue.poll();
            System.out.println("Serving NORMAL Customer:" + served);
        }
        else {
            System.out.println("No customer to serve in the queue.");
        }
    }
    public void peek() {
        if (!urgentQueue.isEmpty()) {
            Customer next = urgentQueue.peek();
            System.out.println("Next URGENT customer: " + next);
        } else if (!normalQueue.isEmpty()) {
            Customer next = normalQueue.peek();
            System.out.println("Next NORMAL customer: " + next);
        } else {
            System.out.println("No customers in queue.");
        }
    }

    public void displayQueue() {

        if (urgentQueue.isEmpty() && normalQueue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Current Queue:");
        for (Customer customer : urgentQueue) {
            System.out.println("[URGENT] ==>> " + customer);
        }
        for (Customer customer : normalQueue) {
            System.out.println("[NORMAL] ==>> " + customer);
        }
    }


    private boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }


}

public class CustomerHelpDesk {
    public static void main(String[] args) {

        CustomerHelpDeskQueue helpdesk = new CustomerHelpDeskQueue();

        helpdesk.enqueue("Ali", "Cannot Access Email");

        helpdesk.enqueue("Bilal", "Laptop not start");

        helpdesk.enqueue("Amjad", "Forgot my password", "urgent");

        helpdesk.enqueue("Hamza", "Printer is not working");

        helpdesk.enqueue("Ahmad", "System is crash", "urgent");

        helpdesk.displayQueue();

        helpdesk.peek();
        helpdesk.dequeue();
        helpdesk.dequeue();
        helpdesk.displayQueue();

    }
}
