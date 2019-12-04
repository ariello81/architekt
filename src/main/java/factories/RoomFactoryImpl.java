package factories;

import models.Element;
import models.Room;
import models.properties.RoomProperty;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class RoomFactoryImpl implements RoomFactory {
    ElementFactory elementFactory = new ElementFactoryImpl();

    @Override
    public Room createRoom(List<String> lines, String separator) {

        int indexLine = 0;
        String roomLine = lines.get(indexLine);
        String[] splitRoomLine = roomLine.split(separator);
        Map<RoomProperty, String> roomDetails = new EnumMap<>(RoomProperty.class);
        for (int i=0; i<splitRoomLine.length; i++) {
            roomDetails.put(RoomProperty.values()[i], splitRoomLine[i]);
        }
        indexLine++;

        int elementsCount = Integer.valueOf(roomDetails.get(RoomProperty.COUNT_ELEMENTS));

        List<Element> elements = new ArrayList<Element>();
        for (int i=0; i<elementsCount; i++){
            String line = lines.get(indexLine);
            Element element = elementFactory.createElement(line, separator);
            indexLine++;
            elements.add(element);
        }

        return new Room(roomDetails.get(RoomProperty.ROOM_NAME), roomDetails.get(RoomProperty.ROOM_COLOR_HEX), Float.valueOf(roomDetails.get(RoomProperty.AREA)),
                Float.valueOf(roomDetails.get(RoomProperty.HEIGHT)), elements);
    }
}
