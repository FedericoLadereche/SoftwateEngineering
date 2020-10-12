package com.algorithms.search;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BinarySearchTest {

    @Test
    public void searchNullArrayTest() {
        Integer[] nullArray = null;
        Integer anyValue = 0;

        Exception expectedNullArrayException = assertThrows(NullPointerException.class, () -> new BinarySearch().searchIterative(nullArray, anyValue));

        String nullArrayExceptionMessage = expectedNullArrayException.getMessage();

        assertEquals("Boom! Null array baby", nullArrayExceptionMessage);
    }

    @Test
    public void searchEmptyArrayTest() {
        Integer[] emptyArray = new Integer[] {};
        Integer anyValue = 0;

        assertFalse(new BinarySearch().searchIterative(emptyArray, anyValue), "False value expected!");
    }

    @Test
    public void searchOneElementNotPresentTest() {
        Integer [] oneElementArray = new Integer [] {1};
        Integer notPresentValue = 0;

        assertFalse(new BinarySearch().searchIterative(oneElementArray, notPresentValue));
    }

    @Test
    public void searchOneElementPresentTest() {
        Integer [] oneElementArray = new Integer [] {1};
        Integer notPresentValue = 1;

        assertTrue(new BinarySearch().searchIterative(oneElementArray, notPresentValue));
    }

    @Test
    public void searchTwoElementNotPresentTest() {
        Integer [] oneElementArray = new Integer [] {1, 5};
        Integer notPresentValue = 4;

        assertFalse(new BinarySearch().searchIterative(oneElementArray, notPresentValue));
    }

    @Test
    public void searchTwoElementPresentUperTest() {
        Integer [] oneElementArray = new Integer [] {1, 5};
        Integer presentValue = 5;

        assertTrue(new BinarySearch().searchIterative(oneElementArray, presentValue));
    }

    @Test
    public void searchTwoElementPresentLowerTest() {
        Integer [] oneElementArray = new Integer [] {1, 5};
        Integer presentValue = 1;

        assertTrue(new BinarySearch().searchIterative(oneElementArray, presentValue));
    }

    @Test
    public void searchThreeElementNotPresentTest() {
        Integer [] oneElementArray = new Integer [] {1, 3, 5};
        Integer notPresentValue = 4;

        assertFalse(new BinarySearch().searchIterative(oneElementArray, notPresentValue));
    }

    @Test
    public void searchThreeElementLowerBoundPresentTest() {
        Integer [] oneElementArray = new Integer [] {1, 3, 5};
        Integer presentValue = 1;

        assertTrue(new BinarySearch().searchIterative(oneElementArray, presentValue));
    }

    @Test
    public void searchThreeElementMiddlePresentTest() {
        Integer [] oneElementArray = new Integer [] {1, 3, 5};
        Integer presentValue = 3;

        assertTrue(new BinarySearch().searchIterative(oneElementArray, presentValue));
    }

    @Test
    public void searchThreeElementUpperBundPresentTest() {
        Integer [] oneElementArray = new Integer [] {1, 3, 5};
        Integer presentValue = 5;

        assertTrue(new BinarySearch().searchIterative(oneElementArray, presentValue), "The element must be present");
    }

    @Test
    public void searchTest() {
        Integer [] oneElementArray = new Integer [] {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21};
        Integer presentValue = 21;

        assertTrue(new BinarySearch().searchIterative(oneElementArray, presentValue), "The element must be present");
    }

}