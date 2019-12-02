package factories;

import models.Room;

import java.util.List;

public interface RoomFactory {
    Room createRoom(List<String> lines, String separator);
}
