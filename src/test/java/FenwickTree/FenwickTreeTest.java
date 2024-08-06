package FenwickTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FenwickTreeTest {

    @Test
    public void shouldAddElements(){
        FenwickTree fwt = new FenwickTree(5);
        fwt.add(0, 1);
        fwt.add(1,2);
        fwt.add(2,3);
        fwt.add(3,4);
        fwt.add(4,5);

        
    }

}