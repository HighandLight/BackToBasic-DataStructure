package Temp;

import java.util.*;

class Entry<K, V> {

    int hash;
    K key;
    V value;

    public Entry(K key, V value){
        this.key = key;
        this.value = value;
        this.hash = key.hashCode();
    }
}

@SuppressWarnings("unchecked")
public class HashTableSeparateChaining<K,V> implements Iterable<K> {

    /*
       해시 함수를 사용하는 이유? 출력값으로 입력값을 알 수 있는 경우
       return (keyHash & 0x7FFFFFFF) % capacity   부분의 의미?d
       resize 메서드에서 insert를 활용하는 방법 -> 기존의 것들을 변수 선언
     */

    private static final int DEFAULT_CAPACITY = 3;
    private static final double DEFAULT_LOADFACTOR = 0.75; //O(n)의 검색 -> 성능 이슈
    int capacity = 1;
    int size = 0;
    double maxLoadFactor;

     private LinkedList<Entry<K,V>>[] linkedList;

    public HashTableSeparateChaining() {
        this(DEFAULT_CAPACITY, DEFAULT_LOADFACTOR);
    }

    public HashTableSeparateChaining(int capacity){
        this(capacity, DEFAULT_LOADFACTOR);
    }

    public HashTableSeparateChaining(int capacity, double maxLoadFactor){
        if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity" + capacity);
        if (maxLoadFactor < 0) throw new IllegalArgumentException("Illegal Load Factor" + maxLoadFactor);
        this.capacity = Math.max(capacity, DEFAULT_CAPACITY);
        this.maxLoadFactor = maxLoadFactor;

        linkedList = new LinkedList[capacity];
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int normalizeIndex(int keyHash){
        return (keyHash & 0x7FFFFFFF) % capacity;
    }

    public void resizeBucket(){

        capacity *= 2;
        LinkedList<Entry<K,V>>[] newLinkedList = new LinkedList[capacity];

        for(int i = 0; i < linkedList.length ; ++i){
            for(Entry<K,V> entry : linkedList[i]){
                if(linkedList[i] != null){
                    int bucketIndex = normalizeIndex(entry.hash);
                    LinkedList<Entry<K, V>> bucket = newLinkedList[bucketIndex];
                    if(bucket == null) newLinkedList[bucketIndex] = bucket = new LinkedList<>();
                    bucket.add(entry);
                }
                linkedList[i] = null;
            }

        }
    }

//    public K insert(K key, V value){
//        if(key == null) throw new IllegalArgumentException("Illegal Key : NULL");
//        Entry<K, V> newEntry = new Entry<>(key, value);
//        int bucketIndex = normalizeIndex(newEntry.hash);
//        return
//    }

    public V insert(K key, V value){
        if(key == null) throw new IllegalArgumentException("Illegal Key : NULL");
        Entry<K, V> newEntry = new Entry<>(key, value);
        int bucketIndex = normalizeIndex(newEntry.hash);
//        System.out.println(bucketIndex);
        return bucketInsert(bucketIndex, newEntry);
    }
    public V add(K key, V value){
        return insert(key, value);
    }

    public V remove(K key){
        if( key == null) return null;
        int bucketIndex = normalizeIndex(key.hashCode());
        return bucketRemove(bucketIndex, key);
    }

    public V get(K key){
        if(key == null) return null;
        int bucketIndex = normalizeIndex(key.hashCode());
        Entry<K, V> entry = bucketFind(bucketIndex, key);
        if(entry != null) return entry.value;

        return null;
    }

    public V bucketInsert(int bucketIndex, Entry<K,V> entry){

        Entry<K, V> existingEntry = bucketFind(bucketIndex, entry.key);

        LinkedList<Entry<K, V>> bucket = linkedList[bucketIndex];
        if(bucket == null) linkedList[bucketIndex] = bucket = new LinkedList<>();


        if(existingEntry == null){

            if(size / capacity >= maxLoadFactor) resizeBucket();
            bucket.add(entry);
            size++;

        }else{
            V existingValue = existingEntry.value;
            existingEntry.value = entry.value;
            return existingValue;
        }
        return null;
    }
    public V bucketRemove(int bucketIndex, K key){
        Entry<K, V> entry = bucketFind(bucketIndex, key);
        if(entry != null){
            LinkedList<Entry<K, V>> ll = linkedList[bucketIndex];
            ll.remove(entry);
            size--;
            if(ll.size() == 0){
                linkedList[bucketIndex] = null;
                return null;
            }
            return entry.value;
        }

        return null;
    }
    public Entry<K, V> bucketFind(int bucketIndex, K key){
        if(key == null) return null;
        LinkedList<Entry<K, V>> bucket = linkedList[bucketIndex];
        if(bucket == null) return null;
        for(Entry<K, V> entry : bucket) {
            if(entry.key.equals(key)) return entry;
        }
        return null;
    }


    @Override
    public Iterator<K> iterator() {
        return null;
    }
}
