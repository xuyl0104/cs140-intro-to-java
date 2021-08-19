package lab05;

import java.util.Random;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Lab820Tests {
    Lab820 lab820;

    @BeforeEach
    void setUp() {
        // initialize lab820 instance before each test.
        lab820 = new Lab820();
    }

    @Test
    @DisplayName("A: lab820 is not null object")
    void testLab820() {
        assertNotNull(lab820);
    }

    @Test
    @DisplayName("B: the arr is null")
    void testArrIsNull() {
        assertEquals("no elements", lab820.least2(null));
    }

    @Test
    @DisplayName("C: the arr is empty")
    void testArrEmpty() {
        assertEquals("no elements", lab820.least2(new int[] {}));
    }

    @Test
    @DisplayName("D: only one element in the arr")
    void testArrOnlyOneElement() {
        assertEquals("only " + 10, lab820.least2(new int[] {10}));
    }

    @Test
    @DisplayName("E1: at least two elements in the arr")
    void testArrAtLeastTwoElements1() {
        assertEquals("2 3", lab820.least2(new int[] {2, 3, 4, 6, 7, 8, 3}));
    }
    
    @Test
    @DisplayName("E2: at least two elements in the arr")
    void testArrAtLeastTwoElements2() {
        assertEquals("2 2", lab820.least2(new int[] {2, 3, 4, 2, 7, 8, 3}));
    }

    @Test
    @DisplayName("E3: at least two elements in the arr")
    void testArrAtLeastTwoElements3() {
        assertEquals("2 3", lab820.least2(new int[] {5, 10, 5, 3, 21, 2}));
    }
    
    @Test
    @DisplayName("E4: at least two elements in the arr")
    void testArrAtLeastTwoElements4() {
        assertEquals("3 3", lab820.least2(new int[] {5, 10, 5, 3, 21, 3}));
    }

    @Test
    @DisplayName("F1: arr is randomly generated")
    void testArrRandomlyGenerated1() {
        int[] arr = generateArrayRandomly();
        assertEquals(returnStringOfArr(arr), lab820.least2(arr));
    }
    
    @Test
    @DisplayName("F2: arr is randomly generated")
    void testArrRandomlyGenerated2() {
        int[] arr = generateArrayRandomly();
        assertEquals(returnStringOfArr(arr), lab820.least2(arr));
    }
    
    @Test
    @DisplayName("F3: arr is randomly generated")
    void testArrRandomlyGenerated3() {
        int[] arr = generateArrayRandomly();
        assertEquals(returnStringOfArr(arr), lab820.least2(arr));
    }


    int[] generateArrayRandomly() {
        int[] test = new int[100];
        Random rand = new Random();
        for(int j = 0; j < test.length; ++j) {
            test[j] = rand.nextInt(200);
        }
        return test;
    }

    String returnStringOfArr(int[] arr) {
        Arrays.sort(arr);
        return arr[0] + " " + arr[1];
    }
    
}
