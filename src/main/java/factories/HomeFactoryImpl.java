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
        String[] splitHomeLine = lines.get(0).split(separator);
        Map<HomeProperty, String> homeDetails = new EnumMap<>(HomeProperty.class);
        for (int i=0; i<splitHomeLine.length; i++) {
            homeDetails.put(HomeProperty.values()[i], splitHomeLine[i]);
        }

        List<Room> rooms = new ArrayList<>();
        for (int i=0; i < Integer.valueOf(homeDetails.get(HomeProperty.ROOMS_COUNT)); i++){
            Room room = roomFactory.createRoom(lines, separator);
            rooms.add(room);
        }

        Home home = new Home(homeDetails.get(HomeProperty.HOME_NAME), homeDetails.get(HomeProperty.ADDRESS), Integer.valueOf(homeDetails.get(HomeProperty.HOMEMADE_COUNT)), rooms);
        return home;
    }
}
