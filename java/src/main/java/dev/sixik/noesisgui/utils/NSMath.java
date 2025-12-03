package dev.sixik.noesisgui.utils;

public class NSMath {

    public static final float FLT_EPSILON = 1.192092896e-07F;
    public static final float EPSILON = 10.0f * FLT_EPSILON;

    public static int clamp(int val, int minVal, int maxVal) {
        return Math.min(Math.max(minVal, val), maxVal);
    }

    public static float clamp(float val, float minVal, float maxVal) {
        return Math.min(Math.max(minVal, val), maxVal);
    }

    public static float lerp(float x, float y, float t) {
        return x + t * (y - x);
    }

    public static int lerp(int x, int y, int t) {
        return x + t * (y - x);
    }

    public static float powf(float v, float v1) {
        return (float) Math.pow(v, v1);
    }

    public static boolean isZero(float val) {
        return isZero(val, EPSILON);
    }

    public static boolean isZero(float val, float epsilon) {
        return Math.abs(val) < epsilon;
    }

    public static boolean isOne(float val) {
        return isOne(val, EPSILON);
    }

    public static boolean isOne(float val, float epsilon) {
        return Math.abs(val - 1.0f) < epsilon;
    }

    public static boolean isInfinity(final int value) {
        return value == Integer.MIN_VALUE || value == Integer.MAX_VALUE;
    }

    public static boolean isInfinity(final float value) {
        return value == Float.MIN_VALUE || value == Float.MAX_VALUE;
    }
}
