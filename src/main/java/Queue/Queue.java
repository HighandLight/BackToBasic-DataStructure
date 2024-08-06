package Queue;

import java.util.LinkedList;

public class Queue <T> implements Iterable<T>{

    private java.util.LinkedList<T> list = new LinkedList<T>();

    public Queue(){}

    public Queue(T firstElem){
        offer(firstElem);
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public T peek(){
        if(isEmpty()) throw new RuntimeException("main.Queue Empty");
        return list.peekFirst();
    }

    public T poll(){
        if(isEmpty()) throw new RuntimeException("main.Queue Empty");
        return list.removeFirst();
    }

    public void offer(T elem){
        list.addLast(elem);
    }

    @Override
    public java.util.Iterator<T> iterator(){
        return list.iterator();
    }

}