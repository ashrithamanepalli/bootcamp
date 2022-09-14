package com.tw.step8.bootcamp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    @Test
    void shouldReturnArea() {
        Rectangle rectangle1 = Rectangle.createRectangle(2, 3);
        Rectangle rectangle2 = Rectangle.createRectangle(2, 3.2);

        double expected1 = 6;
        double expected2 = 6.4;

        assertEquals(expected1, rectangle1.area());
        assertEquals(expected2, rectangle2.area());
    }


    @Test
    void shouldCalculatePerimeter() {
        Rectangle rectangle1 = Rectangle.createRectangle(2, 3);
        Rectangle rectangle2 = Rectangle.createRectangle(2, 3.2);

        double expected1 = 10;
        double expected2 = 10.4;

        assertEquals(expected1, rectangle1.perimeter());
        assertEquals(expected2, rectangle2.perimeter());
    }
}