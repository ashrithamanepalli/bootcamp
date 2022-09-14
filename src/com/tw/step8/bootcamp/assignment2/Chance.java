package com.tw.step8.bootcamp.assignment2;

public class Chance {
    private final double probability;

    private Chance(double probability) {
        this.probability = probability;
    }

    public static Chance createChance(double probability) throws InvalidProbabilityException {
        if (probability >= 0 && probability <= 1) {
            return new Chance(probability);
        }
        throw new InvalidProbabilityException(probability);
    }

    public Chance and(Chance anotherChance) throws InvalidProbabilityException {
        return createChance(this.probability * anotherChance.probability);
    }

    public Chance or(Chance secondChance) throws InvalidProbabilityException {
        Chance complementOfFirst = this.complement();
        Chance complementOfSecond = secondChance.complement();

        return createChance(1 - (complementOfFirst.probability * complementOfSecond.probability));
    }

    public Chance complement() throws InvalidProbabilityException {
        return createChance(1 - this.probability);
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
