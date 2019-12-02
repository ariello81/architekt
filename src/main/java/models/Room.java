package models;

import java.util.List;
import java.util.Objects;

public class Room {
    private final String name;
    private final String colorHex;
    private final Float area;
    private final Float height;
    private final List<Element> elements;

    public Room(String name, String roomColorHex, Float area, Float height, List<Element> elements) {
        this.name = name;
        this.colorHex = roomColorHex;
        this.area = area;
        this.height = height;
        this.elements = elements;
    }

    public String getName() {
        return name;
    }

    public String getColorHex() {
        return colorHex;
    }

    public Float getArea() {
        return area;
    }

    public Float getHeight() {
        return height;
    }

    public List<Element> getElements() {
        return elements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(name, room.name) &&
                Objects.equals(colorHex, room.colorHex) &&
                Objects.equals(area, room.area) &&
                Objects.equals(height, room.height) &&
                Objects.equals(elements, room.elements);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, colorHex, area, height, elements);
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", colorHex='" + colorHex + '\'' +
                ", area=" + area +
                ", height=" + height +
                ", elements=" + elements +
                '}';
    }
}
