package com.tw.step8.bootcamp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    @Test
    void shouldReturnArea(){
        Rectangle rectangle = new Rectangle(2, 3);
        double expected = 6;
        assertEquals(expected, rectangle.area());
    }
}