package com.tw.step8.bootcamp;

public class Rectangle {

    private Dimension dimension;

    public Rectangle(Dimension dimension) {
        this.dimension = dimension;
    }

    public double area() {
        return this.dimension.getHeight() * this.dimension.getWidth();
    }

    public double perimeter() {
        return 2 * (this.dimension.getHeight() + this.dimension.getWidth());
    }
}
