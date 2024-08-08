package Stack;

public interface ArrayStackInterface<T> {
    public boolean isEmpty();
    public void push(T nextItem);
    public T pop();
    public T top();
    public void clear();
}
