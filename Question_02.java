import java.util.LinkedList;
import java.util.ListIterator;

class VipGuest {
    String guestName;
    String attractionName;

    public VipGuest(String guestName, String attractionName) {
        this.guestName = guestName;
        this.attractionName = attractionName;
    }

    @Override
    public String toString() {
        return guestName + " at " + attractionName;
    }
}

class VIPGuestTrail {
    LinkedList<VipGuest> guest;

    public VIPGuestTrail() {
        guest = new LinkedList<>();
    }

    public void addNewGuest(String guestName, String attractionName) {
        VipGuest newGuest = new VipGuest(guestName, attractionName);
        guest.add(newGuest);
        System.out.println("Added VIP: " + newGuest);
    }

    public void removeVipGuest(String guestName) {
        ListIterator<VipGuest> iterator = guest.listIterator();
        while (iterator.hasNext()) {
            VipGuest current = iterator.next();
            if (current.guestName.equalsIgnoreCase(guestName)) {
                iterator.remove();
                System.out.println("Removed VIP: " + guestName);
                return;
            }
        }
    }

    public void display() {
        System.out.println("Guests are: ");
        for (VipGuest name : guest) {
            System.out.println(name);
        }
    }

    public void displayForward() {
        ListIterator<VipGuest> li = guest.listIterator();
        System.out.println("VIP Guests in forward order:");
        while (li.hasNext()) {
            VipGuest guest = li.next();
            System.out.println(guest);
        }
    }

    public void displayBackward() {
        ListIterator<VipGuest> li = guest.listIterator(guest.size());
        System.out.println("VIP Guests in backward order:");
        while (li.hasPrevious()) {
            VipGuest guest = li.previous();
            System.out.println(guest);
        }
    }
}

class RiderQueue {

    class Node {
        String riderName;
        Node next;

        Node(String name) {
            this.riderName = name;
            this.next = null;
        }
    }

    private Node front = null;
    private Node rear = null;

    public void addRider(String name) {
        Node newNode = new Node(name);
        if (front == null) {
            front = newNode;
            rear = newNode;
            rear.next = front;// maintain circular
        } else {
            rear.next = newNode;
            rear = newNode;
            rear.next = front;
        }
        System.out.println(name + " added to the queue.");
    }

    public void removeRider() {
        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }

        String name = front.riderName;

        if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.next;
            rear.next = front;
        }

        System.out.println(name + " removed from the queue.");
    }

    public void displayQueue() {
        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }

        Node temp = front;
        System.out.println("Current Riders in Queue:");
        do {
            System.out.println(temp.riderName);
            temp = temp.next;
        } while (temp != front);
    }
}

public class Question_02 {
    public static void main(String[] args) {
        VIPGuestTrail trail = new VIPGuestTrail();

        trail.addNewGuest("Ali", "Haunted House");
        trail.addNewGuest("Zara", "Ferris Wheel");
        trail.addNewGuest("Bilal", "Water Slide");
        trail.addNewGuest("Sara", "Bumper Cars");
        System.out.println();
        trail.displayForward();
        trail.displayBackward();
        System.out.println();
        trail.removeVipGuest("Bilal");
        trail.displayForward();
        System.out.println();
        RiderQueue queue = new RiderQueue();
        queue.addRider("Ahmed");
        queue.addRider("Fatima");
        queue.addRider("Usman");
        queue.addRider("Hina");
        queue.addRider("Junaid");
        System.out.println();
        queue.removeRider();
        queue.removeRider();

        queue.displayQueue();
    }
}