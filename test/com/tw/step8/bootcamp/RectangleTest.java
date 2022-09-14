package com.tw.step8.bootcamp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    @Test
    void shouldReturnArea(){
        Dimension dimension = new Dimension(2, 3);
        Rectangle rectangle = new Rectangle(dimension);
        double expected = 6;
        assertEquals(expected, rectangle.area());
    }

    @Test
    void shouldCalculatePerimeter(){
        Dimension dimension = new Dimension(2, 3);
        Rectangle rectangle = new Rectangle(dimension);
        double expected = 10;
        assertEquals(expected, rectangle.perimeter());
    }
}