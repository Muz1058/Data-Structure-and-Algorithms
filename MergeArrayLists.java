import java.util.ArrayList;


public class MergeArrayLists {
    public static void main(String[] args) {
ArrayList<Integer> list1=new ArrayList<>();
ArrayList<Integer> list2=new ArrayList<>();
list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list2.add(6);
        list2.add(7);
        list2.add(8);
        list2.add(6);
        list2.add(10);
        System.out.println("List 1 before Merge : "+list1);
        System.out.println("List 2 before Merge : "+list2);
        list1.addAll(list2);

        System.out.println("After Merging List 2 in ti List 1 : "+ list1);


    }
}
