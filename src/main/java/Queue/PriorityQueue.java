package Queue;

import java.util.*;
public class PriorityQueue <T extends Comparable<T>>{  // 제네릭 타입을 정의.  T 중 Comparable T를 상속하는 T만 갖도록 (PQ - 비교가능해야 하기에, Comparable)

    private int heapSize = 0;
    private int heapCapacity = 0;
    private List<T> heap = null;

    public PriorityQueue(){
        this(1);
    }

    public PriorityQueue(T[] elems){
        heapSize = elems.length;
        heapCapacity = elems.length;
        heap = new ArrayList<T>(heapCapacity); // 인터페이스 사요하는 이유와 동일

        for(int i = 0; i < elems.length; ++i){
            heap.add(elems[i]);
        }

    }

    public PriorityQueue(int size){
        heap = new ArrayList<>(size);
    }

    public int size(){
        return heapSize;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void clear(){
//        heap.clear();
        for(int i = 0; i < heapSize; ++i){
            heap.set(i, null);
        }
        heapSize = 0;
    }

    public T peek(){
        if(isEmpty()) return null;
        return heap.get(0);
    }

    public void swap(int i, int j){

        T iElem = heap.get(i);
        T jElem = heap.get(j);

        heap.set(i, jElem);
        heap.set(j, iElem);


    }

    public boolean less(int i, int j) {
        T left = heap.get(i);
        T right = heap.get(j);

        return left.compareTo(right) <= 0;
    }

    public void sink(int i){

        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = left;

        if(less(right, left)){
            smallest = right;
        }

        if(less(smallest, i)){
            swap(i, smallest);
            sink(smallest);
        }

    }

//    public T removeAt(int index){
//        if(index < 0 || index >= heapSize) throw new IndexOutOfBoundsException("Invalid Index : " + index);
////        if(isEmpty()) return null; // 위의 조건식에서 처리
//        swap(index, heapSize );
//        /*
//        index  번쨰 요소를 data 로 초기화
//        data 와 마지막 요소를 swap
//        sink
//        마지막 요소를 null로 초기화
//         */
//
//        heapSize--;
//
//
//    }

















}
