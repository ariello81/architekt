package models;

import java.util.Objects;

public class Position {
    private final Float positionX;
    private final Float positionY;
    private final Float positionZ;

    public Position(Float positionX, Float positionY, Float positionZ) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;
    }

    public Float getPositionX() {
        return positionX;
    }

    public Float getPositionY() {
        return positionY;
    }

    public Float getPositionZ() {
        return positionZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(positionX, position.positionX) &&
                Objects.equals(positionY, position.positionY) &&
                Objects.equals(positionZ, position.positionZ);
    }

    @Override
    public int hashCode() {

        return Objects.hash(positionX, positionY, positionZ);
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionX=" + positionX +
                ", positionY=" + positionY +
                ", positionZ=" + positionZ +
                '}';
    }
}
