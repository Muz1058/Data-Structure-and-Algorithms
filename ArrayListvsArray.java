import java.util.Arrays;
import java.util.LinkedList;

class ArrayListvsArray {
    public static void main(String[] args) {

        

        LinkedList<String> friendsArrayList = new LinkedList<>();

        LinkedList<Integer> numbers = new LinkedList<Integer>();


        LinkedList<String> friendsArrayList2 =
                new LinkedList<>(Arrays.asList("Ali", "Ahmed", "Hassan", "Amna"));

        System.out.println(friendsArrayList2);
       
        System.out.println(friendsArrayList2.get(1));

        
        System.out.println(friendsArrayList2.size());

        friendsArrayList2.add("Maria");
        System.out.println(friendsArrayList2);

        
    
        friendsArrayList2.set(0, "Ayesha");

        System.out.println(friendsArrayList2.get(0));

        //remove the element
        friendsArrayList2.remove(0);
        System.out.println(friendsArrayList2);

        friendsArrayList2.remove("Maria");
        System.out.println(friendsArrayList2);

        //no method for removing from an array
       
        System.out.println(friendsArrayList2);

    }
}
