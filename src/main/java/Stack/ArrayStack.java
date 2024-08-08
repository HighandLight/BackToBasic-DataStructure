package Stack;

import java.util.EmptyStackException;

public class ArrayStack<T> implements ArrayStackInterface<T>{

    private T stack[];
    private int topIndex;
    private static final int DEFAULT_CAPACITY = 64;
    private final T ERROR = null;

    public ArrayStack(){
        stack = (T[]) new Object[DEFAULT_CAPACITY];
        topIndex = -1;
    }

    public ArrayStack(int n){
        stack = (T[]) new Object[n];
        topIndex = -1;
    }

    public int size(){
        return topIndex + 1;
    }

    @Override
    public boolean isEmpty(){
        return size() == 0;
    }

    public boolean isFull(){
        return topIndex == stack.length - 1;
    }

    @Override
    public void push(T newItem){
        if(isFull()) throw new IndexOutOfBoundsException("Full Stack!");
        else stack[++topIndex] = newItem;
    }

    @Override
    public T pop() {
        if(isEmpty()) throw new EmptyStackException();
        return stack[topIndex--];
    }

    @Override
    public T top() {
        if(isEmpty()) throw new EmptyStackException();
        else return stack[topIndex];
    }

    @Override
    public void clear() {
        stack = (T[]) new Object[stack.length];
        topIndex = -1;
    }

}
