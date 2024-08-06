package UnionFind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnionFindIIITest {

    @Test
    void shouldUnifyElements(){
        UnionFindIII nf3 = new UnionFindIII(7);

        nf3.unify(1,3);
        nf3.unify(3,5);
        boolean connected = nf3.connected(1,5);

        assertTrue(connected);
    }

}