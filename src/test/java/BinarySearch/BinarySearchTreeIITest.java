package BinarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeIITest {

    @Test
    public void test(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.add(1);
        bst.add(2);
        bst.add(3);
        bst.add(4);
        bst.add(5);

        bst.remove(1);
        bst.remove(2);
        bst.remove(3);
        bst.remove(4);
        bst.remove(5);

        int height = bst.height();
        assertEquals(0, height);
    }
}