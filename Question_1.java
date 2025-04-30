//Question no 1:
//The City Central Library has decided to modernize its book and membership tracking by building a new digital system. The library needs to track the borrowing and returning of books, maintain a dynamic list of members, and manage a catalog of available books.
//They have hired you to create a basic system that will handle these tasks using simple but efficient data structures. The system must ensure that borrowed books are handled properly, members are updated dynamically, and the book catalog remains easy to search and maintain.
//Situation:
//        1.	Borrowed Books Management:
//        •	Every time a member borrows a book, it is added to the top of the borrowed books record.
//•	When a member returns a book, the most recently borrowed book must be removed first.
//        •	Use Java’s built-in library class to implement this functionality.
//2.	Membership Management:
//        •	Members can register (add themselves) and unregister (remove themselves) at any time.
//•	The membership list should allow adding, removing, and displaying members.
//        •	Use Java’s built-in class for this purpose.
//3.	Library Book Catalog:
//        •	The entire collection of available books is stored in a custom singly linked list. Use a custom implementation to implement this task.
//•	Each Node should store:
//	Book Title
//	Author Name
//•	The linked list must support:
// Adding a new book to the catalog.
//	Removing a book by its title.
//	Displaying all books currently available in the catalog.
//Tasks to Perform in main():
//        •	Add three books to the catalog.
//        •	Register four members.
//•	Remove (unregister) two members.
//        •	Simulate borrowing three books.
//        •	Simulate returning one book.
//        •	Display:
//o	Current list of registered members
//o	Current borrowed books
//o	Current available book catalog

import java.util.ArrayList;
import java.util.Stack;

class BorrowBookManager{
    Stack<String> stack;

    public BorrowBookManager() {
        stack=new Stack<>();
    }
    public void borrowBook(String bookTittle){
        stack.push(bookTittle);
        System.out.println(bookTittle+"has been borrowed");
    }
    public void removeBook(){
        if(stack.isEmpty()){
            System.out.println("no book to return");
        }
        String returnBook=stack.pop();
        System.out.println(returnBook+"has been returned");
    }
    public void display(){
        if(stack.isEmpty()){
            System.out.println("no book to return");
        }
        System.out.println("borrow on top");
        for (String books:stack){
            System.out.println(books+" ");
        }
    }
}
class MembershipManager{
    ArrayList<String> array;

    public MembershipManager() {
        array=new ArrayList<>();
    }
    public void registerMember(String name){
        if(array.contains(name)){
            System.out.println(name+" has already registered");
        }
        else{
            if(array.add(name)){
                System.out.println(name+" member has been registered");
            }
        }
    }
    public void unregisteredMember(String name){
        if(array.remove(name)){
            System.out.println(name+ " has been unregistered");
        }
        else{
            System.out.println(name+" not found in the list");
        }
    }
    public void displayMember(){
        if(array.isEmpty()){
            System.out.println("no members in array");
        }
        for (String member:array){
            System.out.println(member);
        }
    }
}
class BookCatalog {
    class Node {
        String tittle;
        String author;
        Node next;

        public Node(String tittle, String author) {
            this.tittle = tittle;
            this.author = author;
            this.next = null;
        }
    }

    Node head;

    public void addBook(String tittle, String author) {
        Node newNode = new Node(tittle, author);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void removeBook(String title) {
        if (head == null) {
            System.out.println("Catalog is empty.");
            return;
        }
        if (head.tittle.equalsIgnoreCase(title)) {
            head = head.next;
            System.out.println("Book" + title + " removed from the catalog.");
            return;
        }
    }

    public void displayCatalog() {
        if (head == null) {
            System.out.println("No books in catalog.");
            return;
        }
        Node temp = head;
        System.out.println("Available Books in Catalog:");
        while (temp != null) {
            System.out.println(temp.tittle + " by " + temp.author);
            temp = temp.next;
        }
    }
}
    public class Question_1 {
        public static void main(String[] args) {
//        bm.borrowBook("javaBook");
//        bm.borrowBook("English book");
//        bm.borrowBook("math boob");
//        bm.removeBook();

//        MembershipManager ms=new MembershipManager();
//        ms.registerMember("Ansir");
//        ms.registerMember("Mia Sab");
//
//        ms.registerMember("Ansir");
//
//        ms.unregisteredMember("Ansir");

            MembershipManager members = new MembershipManager();

            members.registerMember("Ahmad");
            members.registerMember("Sara");
            members.registerMember("Usman");
            members.registerMember("Hina");

            members.unregisteredMember("Usman");
            members.unregisteredMember("Hina");

            BookCatalog catalog = new BookCatalog();

            catalog.addBook("Java Programming", "Alice Johnson");
            catalog.addBook("Data Structures", "Bob Smith");
            catalog.addBook("Design Patterns", "Carol White");

            BorrowBookManager bm = new BorrowBookManager();
            bm.borrowBook("Java Programming");
            bm.borrowBook("Data Structures");
            bm.borrowBook("Design Patterns");

            bm.removeBook();

            members.displayMember();
            System.out.println();
            bm.display();
            System.out.println();
            catalog.displayCatalog();

        }
    }
