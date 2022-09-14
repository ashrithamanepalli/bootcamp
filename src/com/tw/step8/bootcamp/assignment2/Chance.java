package com.tw.step8.bootcamp.assignment2;

public class Chance {
    private final double probability;

    //outcomes
    public Chance(double probability){
        this.probability = probability;
    }

//    public Chance simultaneousWith(Chance anotherChance){
//        return new Chance(probability * anotherChance.probability);
//    }

    // calculateChanceOfGettingBoth/Any

    public static  Chance calculateChanceOfGettingBoth(Chance firstChance, Chance secondChance){
        return new Chance(firstChance.probability * secondChance.probability);
    }

    public static Chance calculateChanceOfGettingAtLeastOne(Chance firstChance, Chance secondChance){
        double firstEvent = firstChance.probability;
        double complementOfFirst = 1 - firstEvent;
        double secondEvent = secondChance.probability;
        double complementOfSecond = 1 - secondEvent;

        return new Chance(firstEvent*secondEvent
                + firstEvent*complementOfSecond
                + secondEvent* complementOfFirst);
    }

    public Chance atLeastOnceOrBothWith(Chance anotherChance){
        double firstEvent = this.probability;
        double complementOfFirst = 1 - firstEvent;
        double secondEvent = anotherChance.probability;
        double complementOfSecond = 1 - secondEvent;

        return new Chance(firstEvent*secondEvent
                + firstEvent*complementOfSecond
                + secondEvent* complementOfFirst);
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
