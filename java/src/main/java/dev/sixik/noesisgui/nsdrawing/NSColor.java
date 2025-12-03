package dev.sixik.noesisgui.nsdrawing;

import dev.sixik.noesisgui.utils.NSMath;

import java.util.Objects;

public final class NSColor {

    public float r;
    public float g;
    public float b;
    public float a;

    public NSColor() {
        this(0, 0, 0, 0);
    }

    public NSColor(int r, int g, int b, int a) {
        this(r / 255f, g / 255f, b / 255f, a / 255f);
    }

    public NSColor(float r, float g, float b, float a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public NSColor setA(int a) {
        this.a = a / 255f;
        return this;
    }

    public NSColor setR(int r) {
        this.r = r / 255f;
        return this;
    }

    public NSColor setG(int g) {
        this.g = g / 255f;
        return this;
    }

    public NSColor setB(int b) {
        this.b = b / 255f;
        return this;
    }

    public NSColor setA(float a) {
        this.a = a;
        return this;
    }

    public NSColor setR(float r) {
        this.r = r;
        return this;
    }

    public NSColor setG(float g) {
        this.g = g;
        return this;
    }

    public NSColor setB(float b) {
        this.b = b;
        return this;
    }

    public int getPackedBGRA() {
        return getPackedBGRA(r, g, b, a);
    }

    public int getPackedRGBA() {
        return getPackedRGBA(r, g, b, a);
    }

    public float getScR() {
        return SRGBToinear(r);
    }

    public float getScG() {
        return SRGBToinear(g);
    }

    public float getScB() {
        return SRGBToinear(b);
    }

    public float getScA() {
        return SRGBToinear(a);
    }

    public NSColor setScR(float v) {
        this.r = linearToSRGB(v);
        return this;
    }

    public NSColor setScG(float v) {
        this.g = linearToSRGB(v);
        return this;
    }

    public NSColor setScB(float v) {
        this.b = linearToSRGB(v);
        return this;
    }

    public NSColor setScA(float v) {
        this.a = linearToSRGB(v);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NSColor color = (NSColor) o;
        return Float.compare(r, color.r) == 0 && Float.compare(g, color.g) == 0 && Float.compare(b, color.b) == 0 && Float.compare(a, color.a) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, g, b, a);
    }

    @Override
    public String toString() {
        return "NSColor{" +
                "r=" + r +
                ", g=" + g +
                ", b=" + b +
                ", a=" + a +
                '}';
    }

    public static NSColor fromPackedBGRA(int color) {
        return new NSColor(((color >> 16) & 255) / 255.0f, ((color >> 8) & 255) / 255.0f,
                (color & 255) / 255.0f, (color >> 24) / 255.0f);
    }

    public static NSColor fromPackedRGBA(int color) {
        return new NSColor((color & 255) / 255.0f, ((color >> 8) & 255) / 255.0f,
                ((color >> 16) & 255) / 255.0f, (color >> 24) / 255.0f);
    }

    public static NSColor frominearRGB(float r, float g, float b, float a) {
        return new NSColor(linearToSRGB(r), linearToSRGB(g), linearToSRGB(b), a);
    }

    public static NSColor black() {
        return fromPackedBGRA(0xFF000000);
    }

    public static NSColor blue() {
        return fromPackedBGRA(0xFF0000FF);
    }

    public static NSColor cyan() {
        return fromPackedBGRA(0xFF00FFFF);
    }

    public static NSColor darkGray() {
        return fromPackedBGRA(0xFFA9A9A9);
    }

    public static NSColor gray() {
        return fromPackedBGRA(0xFF808080);
    }

    public static NSColor green() {
        return fromPackedBGRA(0xFF00FF00);
    }

    public static NSColor lightGray() {
        return fromPackedBGRA(0xFFD3D3D3);
    }

    public static NSColor magenta() {
        return fromPackedBGRA(0xFFFF00FF);
    }

    public static NSColor orange() {
        return fromPackedBGRA(0xFFFFA500);
    }

    public static NSColor red() {
        return fromPackedBGRA(0xFFFF0000);
    }

    public static NSColor white() {
        return fromPackedBGRA(0xFFFFFFFF);
    }

    public static NSColor yellow() {
        return fromPackedBGRA(0xFFFFFF00);
    }

    public static NSColor pink() {
        return fromPackedBGRA(0xFFFFC0CB);
    }

    public static float SRGBToinear(float v_)
    {
        float v = NSMath.clamp(v_, 0.0f, 1.0f);

        if (v <= 0.04045)
        {
            return v / 12.92f;
        }
        else
        {
            return NSMath.powf((v + 0.055f) / 1.055f, 2.4f);
        }
    }

    public static float linearToSRGB(float v_)
    {
        final float v = NSMath.clamp(v_, 0.0f, 1.0f);
        if (v < 0.0031308f)
        {
            return 12.92f * v;
        }
        else
        {
            return 1.055f * NSMath.powf(v, 0.41666f) - 0.055f;
        }
    }

    public static int getPackedBGRA(float r, float g, float b, float a)
    {
        final int red = (int) (255.0f * NSMath.clamp(r, 0.0f, 1.0f) + 0.5f);
        final int green = (int) (255.0f * NSMath.clamp(g, 0.0f, 1.0f) + 0.5f);
        final int blue = (int) (255.0f * NSMath.clamp(b, 0.0f, 1.0f) + 0.5f);
        final int alpha = (int) (255.0f * NSMath.clamp(a, 0.0f, 1.0f) + 0.5f);
        return (alpha << 24) | (red << 16) | (green << 8) | blue;
    }

    public static int getPackedRGBA(float r, float g, float b, float a)
    {
        final int red = (int) (55.0f * NSMath.clamp(r, 0.0f, 1.0f) + 0.5f);
        final int green = (int) (255.0f * NSMath.clamp(g, 0.0f, 1.0f) + 0.5f);
        final int blue = (int) (255.0f * NSMath.clamp(b, 0.0f, 1.0f) + 0.5f);
        final int alpha = (int) (255.0f * NSMath.clamp(a, 0.0f, 1.0f) + 0.5f);
        return (alpha << 24) | (blue << 16) | (green << 8) | red;
    }
}
