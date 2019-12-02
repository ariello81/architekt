package models;

import java.util.List;
import java.util.Objects;

public class Home {
    private final String name;
    private final String address;
    private final int householdCount;
    private final List<Room> rooms;

    public Home(String homeName, String address, int householdCount, List<Room> rooms) {
        this.name = homeName;
        this.address = address;
        this.householdCount = householdCount;
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getHouseholdCount() {
        return householdCount;
    }

    public List<Room> getRooms() {
        return rooms;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Home home = (Home) o;
        return householdCount == home.householdCount &&
                Objects.equals(name, home.name) &&
                Objects.equals(address, home.address) &&
                Objects.equals(rooms, home.rooms);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, address, householdCount, rooms);
    }

    @Override
    public String toString() {
        return "models.Home{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", householdCount=" + householdCount +
                ", rooms=" + rooms +
                '}';
    }
}
