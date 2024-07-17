package Arrays;


public class DoublyLinkedLIstII <T> implements Iterable<T>{
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    public static class Node<T>{
        private T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(T data, Node<T> prev, Node<T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void addFirst(T elem){
        if(isEmpty()){
            head = tail = new Node<T>(elem, null, null);
        }else{
            head.prev = new Node<T>(elem, null, head);
            head = head.prev;
        }
        size++;
    }

    public void addLast(T elem){
        if(isEmpty()){
            head = tail = new Node<T> (elem, null, null);
        }else{
            tail.next = new Node<T>(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public void addAt(int index, T elem){
        ensureIndexInBound(index);

        if(index == 0){
            addFirst(elem);
        }

        if(index == size){
            addLast(elem);
        }

        Node<T> temp = head;

        for(int i = 0; i < index; ++ i){
            temp = temp.next;
        }

        Node<T> newNode = new Node<T>(elem, temp.prev, temp);
        temp.prev.next = newNode;
        temp.prev = newNode;

        size++;
    }

    public T peekFirst(){
        ensureNonEmpty();
        return head.data;
    }

    public T peekLast(){
        ensureNonEmpty();
        return tail.data;
    }

    public T peekAt(int index){
        ensureIndexInBound(index);

        Node<T> temp = head;
        for(int i = 0; i < index; ++i){
            temp = temp.next;
        }
        return temp.data;
    }

    public T removeFirst(){
        ensureNonEmpty();
        T data = head.data;
        head = head.next;

        size --;
        if(isEmpty()) tail = null;
        else {
            head.prev.next = null;
            head.prev = null;
        }
        return data;
    }
    public T removeLast(){
        ensureNonEmpty();
        T data = tail.data;
        tail = tail.prev;
        // a b c d e
        size --;

        if(isEmpty()) head = null;
        else{
            tail.next.prev = null;
            tail.next = null;
        }

        return data;
    }

    public T removeAt(int index){
        ensureIndexInBound(index);
        // a b c d e
        /*
       (b, d 연결)
            c.prev.next = c.next
            c.next.prev = c.prev
        (GC 고려)
            c.prev = null, c.next = null
         */
        Node<T> temp = head;
        for(int i = 0; i < index; ++i){
            temp = temp.next;
        }
        T data = temp.data;

        if(index == 0) return removeFirst();
        if(index == size) return removeLast();

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        temp.prev = null;
        temp.next = null;

        return data;

    }




    private void ensureIndexInBound(int index) {
        if(index <0 || index > size){
            throw new RuntimeException("illegal index");
        }
    }

    private void ensureNonEmpty() {
        if(isEmpty()) throw new RuntimeException("Empty List");
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private DoublyLinkedLIstII.Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append('[');
        Node<T> temp = head;
        sb.append(temp.data);
// a b [c d
        while(temp.next != null){
            sb.append("] - [");

            temp = temp.next;
            sb.append(temp.data);
        }
        sb.append("] - [");
        sb.append(temp.data);
        sb.append(']');

        return sb.toString();
        //[1]-[2]-[3]
        //String Builder vs String Buffer
        //Stream API
        // Iterable -> String Joiner

    }

}
