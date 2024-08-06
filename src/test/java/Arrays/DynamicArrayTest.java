package Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {
    public static Stream<Arguments> provideContains() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), 1, true),
                Arguments.of(Arrays.asList(1, 2, 3), 4, false)
        );
    }

    @Test
    void shouldReturnAsAnArray() {
        List dynamicArray = new DynamicArray();

        int[] expected = new int[0];
        int[] result = dynamicArray.toArray();

        assertEquals(expected.length, result.length);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 17, 26, 50, 100, 1000, 10000, 100000})
    void shouldReturnAnArrayIncludingExpectedElement(int size) {
        List dynamicArray = new DynamicArray();

        // [0, 1, 2, 3, 4]
        int[] expected = IntStream.range(0, size).toArray();

        for (int element : expected) {
            dynamicArray.add(element);
        }

        int[] result = dynamicArray.toArray();

        assertEquals(expected.length, result.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void shouldRemoveTheElement() {
        List dynamicArray = new DynamicArray();

        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);

        dynamicArray.remove(1);

        int[] expected = {1, 3};
        int[] result = dynamicArray.toArray();

        assertEquals(expected.length, result.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void shouldThrowIndexOutOfBoundsException(int index) {
        List dynamicArray = new DynamicArray();

        IndexOutOfBoundsException indexOutOfBoundsException =
                assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.remove(index));

        assertEquals(DynamicArray.INDEX_BOUNDS_ERROR_MESSAGE, indexOutOfBoundsException.getMessage());
    }

    @Test
    void shouldReturnTrueWhenThereIsNoElement() {
        List dynamicArray = new DynamicArray();

        boolean result = dynamicArray.isEmpty();

        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenThereIsAnyElements() {
        List dynamicArray = new DynamicArray();

        dynamicArray.add(1);

        boolean result = dynamicArray.isEmpty();

        assertFalse(result);
    }

    @ParameterizedTest
    @MethodSource("Arrays.DynamicArrayTest#provideContains")
    void shouldReturnTrueWhenThereIsTheElement(Iterable<Integer> elements, int target, boolean expected) {
        List dynamicArray = new DynamicArray();

        for (int element : elements) {
            dynamicArray.add(element);
        }

        boolean result = dynamicArray.contains(target);

        assertEquals(expected, result);
    }

    @Test
    void shouldClearAllElements() {
        List dynamicArray = new DynamicArray();

        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);

        dynamicArray.clear();

        int[] expected = new int[0];
        int[] result = dynamicArray.toArray();

        assertEquals(expected.length, result.length);
    }

    @Test
    void shouldReturnTheFirstIndexOfTheElement() {
        List dynamicArray = new DynamicArray();

        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);

        int expected = 1;
        int result = dynamicArray.indexOf(2);

        assertEquals(expected, result);
    }

    @Test
    void indexOfShouldReturnMinusOneWhenThereIsNoSuchElement() {
        List dynamicArray = new DynamicArray();

        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);

        int expected = -1;
        int result = dynamicArray.indexOf(4);

        assertEquals(expected, result);
    }

    @Test
    void shouldReturnTheLastIndexOfTheElement() {
        List dynamicArray = new DynamicArray();

        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(2);

        int expected = 3;
        int result = dynamicArray.lastIndexOf(2);

        assertEquals(expected, result);
    }

    @Test
    void lastIndexOfShouldReturnMinusOneWhenThereIsNoSuchElement() {
        List dynamicArray = new DynamicArray();

        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);

        int expected = -1;
        int result = dynamicArray.lastIndexOf(4);

        assertEquals(expected, result);
    }

    @Test
    void shouldSetTheElement() {
        List dynamicArray = new DynamicArray();

        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);

        dynamicArray.set(1, 4);

        int[] expected = {1, 4, 3};
        int[] result = dynamicArray.toArray();

        assertEquals(expected.length, result.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    void shouldThrowIndexOutOfBoundsExceptionWhenSet(int index) {
        List dynamicArray = new DynamicArray();

        IndexOutOfBoundsException indexOutOfBoundsException =
                assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.set(index, 1));

        assertEquals(DynamicArray.INDEX_BOUNDS_ERROR_MESSAGE, indexOutOfBoundsException.getMessage());
    }

    @Test
    void shouldAddElementToTheIndex() {
        List dynamicArray = new DynamicArray();

        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(1, 4);

        int[] expected = {1, 4, 2, 3};
        int[] result = dynamicArray.toArray();

        assertEquals(expected.length, result.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    @Test
    void shouldAddElementToTheEndWhenTheListContainsMoreThanDefaultCapacity() {
        List dynamicArray = new DynamicArray();

        for (int i = 0, size = DynamicArray.DEFAULT_CAPACITY + 1; i < size; i++) {
            dynamicArray.add(i);
        }

        int expected = 4;

        dynamicArray.add(1, expected);

        assertEquals(expected, dynamicArray.toArray()[1]);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 4})
    void shouldThrowIndexOutOfBoundsExceptionWhenAdd(int index) {
        List dynamicArray = new DynamicArray();

        IndexOutOfBoundsException indexOutOfBoundsException =
                assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.add(index, 1));

        String expectedMessage = "The index must be gte to zero and lte to size";
        assertEquals(expectedMessage, indexOutOfBoundsException.getMessage());
    }

    @Test
    void shouldReturnTheElementAtTheIndex() {
        List dynamicArray = new DynamicArray();

        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);

        int expected = 2;
        int result = dynamicArray.get(1);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    void shouldThrowIndexOutOfBoundsExceptionWhenGet(int index) {
        List dynamicArray = new DynamicArray();

        IndexOutOfBoundsException indexOutOfBoundsException =
                assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.get(index));

        assertEquals(DynamicArray.INDEX_BOUNDS_ERROR_MESSAGE, indexOutOfBoundsException.getMessage());
    }

    @Test
    void shouldReturnTheSize() {
        List dynamicArray = new DynamicArray();

        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);

        int expected = 3;
        int result = dynamicArray.size();

        assertEquals(expected, result);
    }
}