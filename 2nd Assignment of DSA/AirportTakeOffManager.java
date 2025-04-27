import java.util.LinkedList;
import java.util.Queue;

class Aircraft {
    String flightNumber;
    String destination;

    public Aircraft(String flightNumber, String destination) {
        this.flightNumber = flightNumber;
        this.destination = destination;
    }


    public String toString() {
        return "Flight: #" + flightNumber + " --> Destination: " + destination;
    }
}

class RunwaySystem {
    Queue<Aircraft> queue = new LinkedList<>();

    public boolean isFlightNumberUnique(String flightNumber) {
        for (Aircraft flight : queue) {
            if (flight.flightNumber.equalsIgnoreCase(flightNumber)) {
                return false;
            }
        }
        return true;
    }

    public boolean isBlank(String str){
        return str==null||str.trim().isEmpty();
    }

    public void addFlight(String flightNumber, String destination) {
        if (isBlank(flightNumber)||isBlank(destination)) {
            System.out.println("FlightNumber and destination should not blank.");
            return;
        }
        if (!isFlightNumberUnique(flightNumber)) {
            System.out.println("Error --> Flight number '" + flightNumber + "' already exist.");
            return;
        }
        Aircraft newFlight = new Aircraft(flightNumber.trim(), destination.trim());
        queue.offer(newFlight);
        System.out.println("Added --> " + newFlight);
    }

    public void authorizeTakeoff() {
        if (queue.isEmpty()) {
            System.out.println("No flight for takeoff.");
            return;
        }
        Aircraft flight = queue.poll();
        System.out.println("Authorized for Takeoff: " + flight);
    }

    public void peekNextFlight() {
        if (queue.isEmpty()) {
            System.out.println("No flight for takeoff.");
            return;
        }
        System.out.println("Next Flight --> " + queue.peek());
    }

    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("No flight in queue.");
            return;
        }
        System.out.println("\nFlights waiting for takeoff:");
        for (Aircraft flight : queue) {
            System.out.println(" ==>> " + flight);
        }
    }
}

public class AirportTakeOffManager {
    public static void main(String[] args) {
        RunwaySystem runway = new RunwaySystem();

        runway.addFlight("PK301", "Lahore");
        runway.addFlight("EK712", "Dubai");
        runway.addFlight("BA215", "London");
        runway.addFlight("PK301", "Karachi");

        runway.displayQueue();

        runway.peekNextFlight();
        runway.authorizeTakeoff();
        runway.authorizeTakeoff();

        runway.displayQueue();
    }
}
