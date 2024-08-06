package BinarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AVLTreeRecursiveIITest {

    @Test
    void shouldUpdateHeight(){

        AVLTreeRecursiveII avl = new AVLTreeRecursiveII();

        avl.insert(40);
        avl.insert(41);
        avl.insert(43);
        avl.insert(44);
        avl.insert(45);
        avl.insert(46);
        avl.insert(47);
        avl.insert(48);
        avl.insert(10);
        avl.insert(20);
        avl.insert(22);
        avl.insert(17);
        avl.insert(97);
        avl.insert(30);
        avl.insert(55);
        avl.insert(56);
        avl.insert(56);
        avl.insert(56);
        avl.insert(56);
        avl.insert(56);
        avl.insert(56);
        avl.insert(57);

        int exp = 5;
        int res = avl.height();

        assertEquals(exp, res);

    }
}