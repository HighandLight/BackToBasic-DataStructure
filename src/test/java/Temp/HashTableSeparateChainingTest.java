package Temp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableSeparateChainingTest {

    private HashTableSeparateChaining<String, Integer> hashTable;
    @Test
    void shouldItInsertNewValue(){
        hashTable = new HashTableSeparateChaining<>();
        Integer newValue = hashTable.add("a", 1);
        Integer newValue2 = hashTable.add("b", 1);
        Integer newValue3 = hashTable.add("c", 1);
        Integer newValue4 = hashTable.add("d", 1);
        Integer newValue5 = hashTable.add("e", 1);
        Integer newValue6 = hashTable.add("f", 1);
        Integer newValue7 = hashTable.add("g", 1);
        Integer newValue8 = hashTable.add("h", 1);
        Integer newValue9 = hashTable.add("i", 1);
        Integer newValue10 = hashTable.add("j", 1);
        Integer newValue11 = hashTable.add("k", 1);

        assertEquals(11, hashTable.size());

    }

    @Test
    void shouldItRemove(){
        hashTable = new HashTableSeparateChaining<>();
        Integer newValue = hashTable.add("a", 1);
        Integer newValue2 = hashTable.add("b", 1);
        Integer newValue3 = hashTable.add("c", 1);

        hashTable.remove("b");

        assertEquals(2, hashTable.size());
    }

    @Test
    void shouldFindByKey(){
        hashTable = new HashTableSeparateChaining<>();
        Integer newValue = hashTable.add("a", 1);
        Integer newValue2 = hashTable.add("b", 2);
        Integer newValue3 = hashTable.add("c", 3);

        int result = hashTable.get("b");
        int expected = 2;
        assertEquals(expected, result);

    }

    @Test
    void insert() {
    }

    @Test
    void add() {
    }

    @Test
    void bucketInsert() {
    }

    @Test
    void bucketFind() {
    }
}