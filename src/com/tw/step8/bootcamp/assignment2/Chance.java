package com.tw.step8.bootcamp.assignment2;

public class Chance {
    private final double value;

    private Chance(double value) {
        this.value = value;
    }

    public static Chance createChance(double probability) throws InvalidProbabilityException {
        if (probability >= 0 && probability <= 1) {
            return new Chance(probability);
        }
        throw new InvalidProbabilityException(probability);
    }

    public Chance and(Chance anotherChance) throws InvalidProbabilityException {
        return createChance(this.value * anotherChance.value);
    }

    public Chance or(Chance anotherChance) throws InvalidProbabilityException {
        Chance complementOfFirst = this.complement();
        Chance complementOfSecond = anotherChance.complement();

        Chance intersectionOfComplements = complementOfFirst.and(complementOfSecond);

        return intersectionOfComplements.complement();
    }

    public Chance complement() throws InvalidProbabilityException {
        return createChance(1 - this.value);
    }

    @Override
    public String toString() {
        return "Chance{" +
                "probability=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chance)) return false;

        Chance chance = (Chance) o;

        return Double.compare(chance.value, value) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(value);
        return (int) (temp ^ (temp >>> 32));
    }

    public boolean isWithinDelta(Chance anotherChance, double delta) {
        return Math.abs(this.value - anotherChance.value) <= delta;
    }
}
