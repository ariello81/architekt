package factories;

import models.Home;
import models.Room;
import models.properties.HomeProperty;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class HomeFactoryImpl implements HomeFactory {
    RoomFactory roomFactory = new RoomFactoryImpl();

    @Override
    public Home createHome(List<String> lines, String separator) {
        int indexLine = 0;
        String homeLine = lines.get(indexLine);
        String[] splitHomeLine = homeLine.split(separator);
        Map<HomeProperty, String> homeDetails = new EnumMap<>(HomeProperty.class);
        for (int i=0; i<splitHomeLine.length; i++) {
            homeDetails.put(HomeProperty.values()[i], splitHomeLine[i]);
        }
        indexLine++;

        int roomsCount = Integer.valueOf(homeDetails.get(HomeProperty.ROOMS_COUNT));

        List<Room> rooms = new ArrayList<>();
        for (int i=0; i < roomsCount; i++){
            List<String> roomDetailsList = new ArrayList<>(lines.subList(indexLine, lines.size()));
            Room room = roomFactory.createRoom(roomDetailsList, separator);
            int roomElementsCount = room.getElements().size();
            indexLine += roomElementsCount + 1;
            rooms.add(room);
        }

        return new Home(homeDetails.get(HomeProperty.HOME_NAME), homeDetails.get(HomeProperty.ADDRESS), Integer.valueOf(homeDetails.get(HomeProperty.HOMEMADE_COUNT)), rooms);
    }
}
