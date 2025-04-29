
//1. Implement Two Stacks in a Single Array
//Write a program to implement two stacks using a single array such that neither stack
//overflows until the array is full.

class TwoStacksArray{
    int []arr;
    int top1,top2,size;

    public TwoStacksArray(int size){
        this.size=size;
        arr=new int [size];
        top1=-1;
        top2=size;
    }

    void push1(int value){
        if(top1<top2-1){
            arr[++top1]=value;
        }
        else {
            System.out.println("Stack 1 overflow. Cannot add "+value+" to the stack");
        }

    }
    void push2(int value){
        if(top2>top1){
            arr[--top2]=value;
        }
        else {
            System.out.println("Stack 2 overflow. Cannot add "+value+" to the stack");
        }
    }
     int pop1(){
        if(top1<0){
            System.out.println("Stack 1 is Underflow");
            return -1;
        }
        else {
            return arr[top1--];
        }
    }
     int pop2(){
        if(top2==size){
            System.out.println("Stack 2 is Underflow");
            return -1;
        }
        else {
            return arr[top2++];
        }
    }
    void printStacks(){
        if(top1<0){
            System.out.println("Stack 1 is Underflow");
            return ;
        }
        System.out.print("Stack 1 :: ");
        for (int i=0;i<=top1 ;i++){
            System.out.print(arr[i]+"  ");
        }
        if(top2==size){
            System.out.println("Stack 2 is Underflow");
            return ;
        }
        System.out.println();
        System.out.print("Stack 2 :: ");
        for (int i=size-1;i>=top2 ;i--){
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
    }
}


public class Implement_Two_Stacks_in_a_Single_Array {
    public static void main(String[] args) {
        TwoStacksArray ts = new TwoStacksArray(10);

        ts.push1(1);
        ts.push1(2);
        ts.push1(3);

        ts.push2(10);
        ts.push2(9);
        ts.push2(8);

        ts.printStacks();

        System.out.println("Popped from Stack 1: " + ts.pop1());
        System.out.println("Popped from Stack 2: " + ts.pop2());

        ts.printStacks();

    }
}
