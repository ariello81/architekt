package models;

import java.util.Objects;

public class Size {
    private final Float length;
    private final Float width;
    private final Float height;

    public Size(Float length, Float width, Float height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Float getLength() {
        return length;
    }

    public Float getWidth() {
        return width;
    }

    public Float getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Size size = (Size) o;
        return Objects.equals(length, size.length) &&
                Objects.equals(width, size.width) &&
                Objects.equals(height, size.height);
    }

    @Override
    public int hashCode() {

        return Objects.hash(length, width, height);
    }

    @Override
    public String toString() {
        return "Size{" +
                "length=" + length +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
