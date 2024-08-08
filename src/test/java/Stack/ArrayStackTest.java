package Stack;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {
    @Test
    void shouldPushElement(){
        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);

        int expected = 4;
        int result = arrayStack.size();

        assertEquals(expected,result);

    }

    @Test
    void shouldPopElement(){
        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);

        int expected = arrayStack.pop();
        int result = 4;

        assertEquals(expected, result);
        assertEquals(3, arrayStack.size());
    }

    @Test
    void shouldThrowEmptyStackException(){
        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();

        int expected = arrayStack.pop();
        assertEquals(new EmptyStackException(), expected); // 테스트 어떻게 할지?

    }
}