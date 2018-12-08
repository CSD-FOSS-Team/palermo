package com.csdfossteam.palermo.core.util;

/**
 * A dynamic description of a amount based on a given a target maximum value.
 *
 * @author Akritas Akritidis
 */
public final class Amount {

    public static Amount fixed(int value) {
        return new Amount(value, value, 1);
    }

    public static Amount ofMin(int min, float percent) {
        return new Amount(min, Integer.MAX_VALUE, percent);
    }

    public static Amount ofMax(int max, float percent) {
        return new Amount(0, max, percent);
    }

    public static Amount of(float percent) {
        return new Amount(0, Integer.MAX_VALUE, percent);
    }

    public static Amount of(int min, int max, float percent) {
        return new Amount(min, max, percent);
    }

    //

    private final int min;
    private final int max;
    private final float percent;

    private Amount(int min, int max, float percent) {
        this.min = min;
        this.max = max;
        this.percent = percent;
    }

    /**
     * Get the the result based on the given value
     */
    public int get(int x) {
        int value = (int) (x * percent);
        return x < min ? min : x > max ? max : value;
    }

    /**
     * Get the complementary of the result based on the given value
     */
    public int getCompl(int x) {
        return x - get(x);
    }
}
