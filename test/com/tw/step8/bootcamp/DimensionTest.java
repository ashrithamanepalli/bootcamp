package com.tw.step8.bootcamp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DimensionTest {
    @Test
    void shouldReturnHeight(){
        Dimension dimension = new Dimension(2,3);
        assertEquals(2, dimension.getHeight());
    }

    @Test
    void shouldReturnWidth(){
        Dimension dimension = new Dimension(2,3);
        assertEquals(3, dimension.getWidth());
    }
}