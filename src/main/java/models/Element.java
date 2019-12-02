package models;

import java.util.Objects;

public class Element {
    private final String elementName;
    private final Position position;
    private final Float weight;
    private final Size size;

    public Element(String elementName, Position position, Float weight, Size size) {
        this.elementName = elementName;
        this.position = position;
        this.weight = weight;
        this.size = size;
    }

    public String getElementName() {
        return elementName;
    }

    public Position getPosition() {
        return position;
    }

    public Float getWeight() {
        return weight;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return Objects.equals(elementName, element.elementName) &&
                Objects.equals(position, element.position) &&
                Objects.equals(weight, element.weight) &&
                Objects.equals(size, element.size);
    }

    @Override
    public int hashCode() {

        return Objects.hash(elementName, position, weight, size);
    }

    @Override
    public String toString() {
        return "Element{" +
                "elementName='" + elementName + '\'' +
                ", position=" + position +
                ", weight=" + weight +
                ", size=" + size +
                '}';
    }
}
