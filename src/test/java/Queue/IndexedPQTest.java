package Queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexedPQTest {

    @Test
    void shouldInsertElement(){
        IndexedPQ ipq = new IndexedPQ(19);
        ipq.insert(2,9);
        ipq.insert(0,0);
        ipq.insert(1,5);
        ipq.insert(3,19);
        ipq.insert(4,7);

        int expected = 19;
        int result = ipq.size();

        assertEquals(expected, result);
    }

}