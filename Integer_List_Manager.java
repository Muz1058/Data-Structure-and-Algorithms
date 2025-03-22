import java.util.ArrayList;
import java.util.Collections;

public class Integer_List_Manager {
    public static int findSmallNumber(ArrayList<Integer> list){
        int minimum=list.get(0);

        for ( int num:list){
            if(minimum>num){
                minimum=num;
            }
        }
        return minimum;
    }
    public static int findMaxNumber(ArrayList<Integer> list){
        int max=list.getFirst();

        for ( int num:list){
            if(max<num){
                max=num;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list1=new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(5);
        list1.add(4);

        System.out.println("ArrayList : "+list1);

        //•	Insert numbers into the list.
        list1.add(0,0);

        System.out.println("ArrayList After Insertion : "+list1);
        // •	Find the largest and smallest number.

        System.out.println("Smallest Number in ArrayList : "+findSmallNumber(list1));
        System.out.println("Largest Number in ArrayList : "+findMaxNumber(list1));

        //•	Sort the list in ascending order.
        Collections.sort(list1);
        System.out.println("ArrayList After sorting: "+list1);
    }
}
