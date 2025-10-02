package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KadaneTest {

    @Test
    void testSingleElement() {
        Kadane kadane = new Kadane();
        int[] arr = {5};
        assertEquals(5, kadane.kadane(arr));
    }

    @Test
    void testAllNegative() {
        Kadane kadane = new Kadane();
        int[] arr = {-2, -3, -1, -4};
        assertEquals(-1, kadane.kadane(arr));
    }

    @Test
    void testMixedValues() {
        Kadane kadane = new Kadane();
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, kadane.kadane(arr));
    }

    @Test
    void testEmptyArray() {
        Kadane kadane = new Kadane();
        assertThrows(IllegalArgumentException.class, () -> kadane.kadane(new int[]{}));
    }
//тестовая
    @Test
    void testNullArray() {
        Kadane kadane = new Kadane();
        assertThrows(IllegalArgumentException.class, () -> kadane.kadane(null));
    }
}
