package Arrays;

public interface List {
    void add(int value);
    void add(int index, int value);
    void remove(int index);
    int get(int index);
    int indexOf(int value);
    int lastIndexOf(int value);
    void set(int index, int value);
    int size();
    boolean isEmpty();
    boolean contains(int value);
    void clear();
    int[] toArray();
}
