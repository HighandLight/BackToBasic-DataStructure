//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//Interface용


import Arrays.DoublyLinkedLIstII;
import Arrays.DoublyLinkedList;

public class Main {
    public static void main(String[] args){
        DoublyLinkedLIstII<Integer> dl2 = new DoublyLinkedLIstII<Integer>();
        dl2.addFirst(1);
        dl2.addFirst(2);
        dl2.addFirst(3);
        dl2.addFirst(4);
        System.out.println(dl2.toString());
    }

}