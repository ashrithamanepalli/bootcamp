package com.tw.step8.bootcamp.assignment2;

public class Chance {
    private final double probability;

    public Chance(double probability) {
        this.probability = probability;
    }

    public Chance and(Chance anotherChance) {
        return new Chance(this.probability * anotherChance.probability);
    }

    public Chance or(Chance secondChance) {
        Chance complementOfFirst = this.complement();
        Chance complementOfSecond = secondChance.complement();

        return new Chance(1 - (complementOfFirst.probability * complementOfSecond.probability));
    }

    public Chance complement() {
        return new Chance(1 - this.probability);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chance)) return false;

        Chance chance = (Chance) o;

        return Double.compare(chance.probability, probability) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(probability);
        return (int) (temp ^ (temp >>> 32));
    }
}
