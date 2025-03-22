import java.util.ArrayList;

public class UpdateElementInArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list1=new ArrayList<>();
        list1.add(1);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        System.out.println("ArrayList before Update : "+list1);

        list1.set(0,0);
        System.out.println("ArrayList After Update :"+list1);
    }
}
