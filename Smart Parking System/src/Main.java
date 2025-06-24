import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//class LogLinkedList {
//    private LogNode head;
//    private LogNode tail;
//
//    // Internal log node class
//    private static class LogNode {
//        String message;
//        LogNode next;
//
//        public LogNode(String message) {
//            this.message = message;
//            this.next = null;
//        }
//    }
//    public LogNode getHead() {
//        return head;
//    }
//
//    // Add a log entry at the end
//    public void add(String message) {
//        LogNode newNode = new LogNode(message);
//        if (head == null) {
//            head = tail = newNode;
//        } else {
//            tail.next = newNode;
//            tail = newNode;
//        }
//    }
//
//    // Print all logs
//    public void printLogs() {
//        System.out.println("\n--- Parking Logs ---");
//        LogNode current = head;
//        while (current != null) {
//            System.out.println(current.message);
//            current = current.next;
//        }
//    }
//
//    // (Optional) Clear the logs
//    public void clear() {
//        head = tail = null;
//    }
//}
//

class LogLinkedList {
    private LogNode head;
    private LogNode tail;

    // Make this public so AnalyticsEngine can access it
    public static class LogNode {
        public String message;
        public LogNode next;

        public LogNode(String message) {
            this.message = message;
            this.next = null;
        }
    }

    // Add a log entry at the end
    public void add(String message) {
        LogNode newNode = new LogNode(message);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Print all logs
    public void printLogs() {
        System.out.println("\n--- Parking Logs ---");
        LogNode current = head;
        while (current != null) {
            System.out.println(current.message);
            current = current.next;
        }
    }

    // Return the head node for external traversal (AnalyticsEngine)
    public LogNode getHead() {
        return head;
    }

    // Optional: Clear all logs
    public void clear() {
        head = tail = null;
    }
}


 class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity + 1]; // index 1-based for easy math
    }

    public boolean insert(int value) {
        if (size >= capacity) {
            System.out.println("MaxHeap is full. Cannot insert: " + value);
            return false;
        }
        heap[++size] = value;
        heapifyUp(size);
        return true;
    }

    public Integer extractMax() {
        if (size == 0) return null;

        int max = heap[1];
        heap[1] = heap[size--];
        heapifyDown(1);
        return max;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printHeap() {
        System.out.print("MaxHeap: ");
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    private void heapifyUp(int i) {
        while (i > 1 && heap[i / 2] < heap[i]) {
            swap(i, i / 2);
            i = i / 2;
        }
    }

    private void heapifyDown(int i) {
        int largest = i;
        int left = 2 * i;
        int right = 2 * i + 1;

        if (left <= size && heap[left] > heap[largest])
            largest = left;

        if (right <= size && heap[right] > heap[largest])
            largest = right;

        if (largest != i) {
            swap(i, largest);
            heapifyDown(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}



class CircularQueue{
    private int[] queue;
    private int front,rear,size,capacity;
    public CircularQueue(int capacity){
        this.capacity=capacity;
        this.queue=new int[capacity];
        front=size=0;
        this.rear=-1;

    }
    public boolean enqueue(int value){
        if(isFull()){
            throw new RuntimeException("Queue is full,Cannot add slot '"+value+"'");
        }
        rear=(rear+1)%capacity;
        queue[rear]=value;
        size++;
        return true;
    }
    public int dequeue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is Empty.No slot to assign.");
        }
        int slot=queue[front];
        front=(front+1)%capacity;
        size--;
        return slot;
    }
    public int peek(){
        if(isEmpty()) return Integer.parseInt(null);
        return queue[front];
    }
    public void displayQueue(){
        if (isEmpty()){
            System.out.println("Queue is Empty.....");
            return;
        }
        for (int i = 0; i < size; i++) {
            int index=(front+i)%capacity;
            System.out.print(queue[index]+"-->");
        }
    }


    public boolean isFull(){
        return size==capacity;
    }
    public boolean isEmpty(){
        return size==0;
    }

}

class Vehicle{
    private String plateNumber;
    private boolean isVip;
    private int slotNumber;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public Vehicle(String plateNumber, boolean isVip, int slotNumber, LocalDateTime entryTime) {
        this.plateNumber = plateNumber;
        this.isVip = isVip;
        this.slotNumber = slotNumber;
        this.entryTime = entryTime;
        this.exitTime = null;
    }

    // Getter & setter for exitTime
    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }



    public Duration getStayDuration() {
        if (exitTime == null) return Duration.ZERO;
        return Duration.between(entryTime, exitTime);
    }


    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }


}
class ParkingSlotManager {
    private CircularQueue regularSlots;
    private MaxHeap vipSlots;

    public ParkingSlotManager(int regularCapacity, int vipCapacity) {
        regularSlots = new CircularQueue(regularCapacity);
        vipSlots = new MaxHeap(vipCapacity);

        // Initialize regular and VIP slots
        for (int i = 1; i <= regularCapacity; i++) {
            regularSlots.enqueue(i);  // regular: 1 to N
        }
        for (int i = 1; i <= vipCapacity; i++) {
            vipSlots.insert(i);       // VIP: 1 to M (max heap handles priority)
        }
    }

    public Integer allocateSlot(boolean isVIP) {
        if (isVIP) {
            if (!vipSlots.isEmpty()) {
                return vipSlots.extractMax();
            } else {
                System.out.println("No VIP slots available. Trying regular...");
                return regularSlots.dequeue();
            }
        } else {
            return regularSlots.dequeue();
        }
    }

    public void releaseSlot(int slotNumber, boolean isVIP) {
        if (isVIP) {
            vipSlots.insert(slotNumber);
        } else {
            regularSlots.enqueue(slotNumber);
        }
    }

    public void printSlotStatus() {
        System.out.println("Available Regular Slots:");
        regularSlots.displayQueue();

        System.out.println("Available VIP Slots:");
        vipSlots.printHeap();
    }
}

 class ParkingSystem {
    private ParkingSlotManager slotManager;
    private Vehicle[] vehicleRegistry;
    private int vehicleCapacity = 1000;
    private LogLinkedList logs; // now using custom linked list

    public ParkingSystem(int regularSlots, int vipSlots) {
        this.slotManager = new ParkingSlotManager(regularSlots, vipSlots);
        this.vehicleRegistry = new Vehicle[vehicleCapacity];
        this.logs = new LogLinkedList();
    }

    private int getIndex(String plateNumber) {
        return Math.abs(plateNumber.hashCode()) % vehicleCapacity;
    }

    public void checkInVehicle(String plateNumber, boolean isVIP) {
        int index = getIndex(plateNumber);
        if (vehicleRegistry[index] != null) {
            System.out.println("Vehicle already parked: " + plateNumber);
            return;
        }

        Integer assignedSlot = slotManager.allocateSlot(isVIP);
        if (assignedSlot == null) {
            System.out.println("No slots available.");
            return;
        }

        Vehicle vehicle = new Vehicle(plateNumber, isVIP, assignedSlot, java.time.LocalDateTime.now());
        vehicleRegistry[index] = vehicle;

        logs.add("IN: " + plateNumber + " | Slot: " + assignedSlot + " | Time: " + vehicle.getEntryTime());
        System.out.println("Vehicle parked at slot: " + assignedSlot);
    }

    public void checkOutVehicle(String plateNumber) {
        int index = getIndex(plateNumber);
        Vehicle vehicle = vehicleRegistry[index];

        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        vehicle.setExitTime(java.time.LocalDateTime.now());
        java.time.Duration stay = vehicle.getStayDuration();

        slotManager.releaseSlot(vehicle.getSlotNumber(), vehicle.isVip());

        logs.add("OUT: " + plateNumber + " | Slot: " + vehicle.getSlotNumber()
                + " | Duration: " + stay.toMinutes() + " mins");

        vehicleRegistry[index] = null;
        System.out.println("Vehicle exited. Stay: " + stay.toMinutes() + " minutes.");
    }

    public void printLogs() {
        logs.printLogs();
    }
     public void forceCheckIn(Vehicle vehicle) {
         int index = getIndex(vehicle.getPlateNumber());
         if (vehicleRegistry[index] != null) {
             System.out.println("Vehicle already exists: " + vehicle.getPlateNumber());
             return;
         }
         vehicleRegistry[index] = vehicle;
         logs.add("IN: " + vehicle.getPlateNumber() + " | Slot: " + vehicle.getSlotNumber()
                 + " | Time: " + vehicle.getEntryTime());
         System.out.println("FORCED CHECK-IN: " + vehicle.getPlateNumber() + " at slot " + vehicle.getSlotNumber());
     }

     public void forceCheckOut(String plateNumber, LocalDateTime exitTime) {
         int index = getIndex(plateNumber);
         Vehicle vehicle = vehicleRegistry[index];

         if (vehicle == null) {
             System.out.println("Vehicle not found: " + plateNumber);
             return;
         }

         vehicle.setExitTime(exitTime);
         Duration stay = vehicle.getStayDuration();

         slotManager.releaseSlot(vehicle.getSlotNumber(), vehicle.isVip());

         logs.add("OUT: " + plateNumber + " | Slot: " + vehicle.getSlotNumber()
                 + " | Duration: " + stay.toMinutes() + " mins");

         vehicleRegistry[index] = null;
         System.out.println("FORCED CHECK-OUT: " + plateNumber + " after " + stay.toMinutes() + " minutes.");
     }

     public ParkingSlotManager getSlotManager() {
         return slotManager;
     }

     public LogLinkedList getLogs() {
         return logs;
     }

 }

class AnalyticsEngine {
    private LogLinkedList logs;

    public AnalyticsEngine(LogLinkedList logs) {
        this.logs = logs;
    }

    public void generateReport() {
        LogLinkedList.LogNode current = logs.getHead();

        int totalVehicles = 0;
        int totalMinutes = 0;
        int[] hourlyEntryCount = new int[24]; // 0-23 hours
        int vipCount = 0;
        int regularCount = 0;

        while (current != null) {
            String log = current.message;

            if (log.startsWith("IN:")) {
                totalVehicles++;

                // Extract hour of entry
                try {
                    String[] parts = log.split("\\|");
                    String plate = parts[0].split(":")[1].trim();
                    String timeStr = parts[2].split(": ", 2)[1].trim();

                    LocalDateTime entryTime = LocalDateTime.parse(timeStr);
                    int hour = entryTime.getHour();
                    hourlyEntryCount[hour]++;

                    if (plate.startsWith("VIP")) vipCount++;
                    else regularCount++;

                } catch (Exception e) {
                    System.out.println("Failed to parse IN log: " + log);
                }
            }

            if (log.startsWith("OUT:")) {
                try {
                    String[] parts = log.split("\\|");
                    String durationStr = parts[2].split(":")[1].trim().split(" ")[0];
                    int minutes = Integer.parseInt(durationStr);
                    totalMinutes += minutes;
                } catch (Exception e) {
                    System.out.println("Failed to parse OUT log: " + log);
                }
            }

            current = current.next;
        }

        // Calculate peak hour
        int peakHour = 0;
        for (int i = 1; i < 24; i++) {
            if (hourlyEntryCount[i] > hourlyEntryCount[peakHour]) {
                peakHour = i;
            }
        }

        double averageStay = (totalVehicles > 0) ? ((double) totalMinutes / totalVehicles) : 0;

        // Print report
        System.out.println("\n==== Analytics Report ====");
        System.out.println("Total Vehicles Parked: " + totalVehicles);
        System.out.println("VIP Vehicles: " + vipCount + ", Regular Vehicles: " + regularCount);
        System.out.printf("Average Stay Duration: %.2f minutes\n", averageStay);
        System.out.println("Peak Hour (Most Entries): " + peakHour + ":00");
        System.out.println("==========================\n");
    }
}

public class Main {
    public static void main(String[] args) {
        // Step 1: Initialize the system
        ParkingSystem system = new ParkingSystem(5, 2); // 5 regular slots, 2 VIP slots

        // Step 2: Manually set entry times
        LocalDateTime vipEntryTime = LocalDateTime.of(2025, 6, 21, 11, 0);  // 11:00 AM
        LocalDateTime regEntryTime = vipEntryTime.plusMinutes(15);         // 11:15 AM

        // Step 3: Allocate slots manually
        Integer vipSlot = system.getSlotManager().allocateSlot(true);
        Integer regSlot = system.getSlotManager().allocateSlot(false);

        // Step 4: Create Vehicle objects
        Vehicle vipVehicle = new Vehicle("VIP-9823", true, vipSlot, vipEntryTime);
        Vehicle regVehicle = new Vehicle("REG-7842", false, regSlot, regEntryTime);

        // Step 5: Manually insert into system (like a forced check-in)
        system.forceCheckIn(vipVehicle);
        system.forceCheckIn(regVehicle);

        // Step 6: Simulate check-out (after 2.3 hrs for REG, 4 hrs for VIP)
        LocalDateTime regExitTime = regEntryTime.plusHours(2).plusMinutes(18);
        LocalDateTime vipExitTime = vipEntryTime.plusHours(4);

        system.forceCheckOut("REG-7842", regExitTime);
        system.forceCheckOut("VIP-9823", vipExitTime);

        // Step 7: Show Logs
        system.printLogs();

        // Step 8: Show Analytics
        AnalyticsEngine engine = new AnalyticsEngine(system.getLogs());
        engine.generateReport();
    }
}

