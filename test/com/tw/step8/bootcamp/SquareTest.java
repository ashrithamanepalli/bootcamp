package com.tw.step8.bootcamp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
    @Test
    void shouldReturnAreaOfSquare(){
        Square square = new Square(4);
        assertEquals(16, square.area());
    }

    @Test
    void shouldReturnPerimeterOfSquare(){
        Square square = new Square(6);
        assertEquals(24, square.perimeter());
    }
}