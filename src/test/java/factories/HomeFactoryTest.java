package factories;

import models.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HomeFactoryTest {

    private final HomeFactory homeFactory = new HomeFactoryImpl();

    @Test
    public void testCreateHome() {
        //given
        final List<String> homeStr = Arrays.asList(
                "Dom na zielonym wzgórzu%Ulica zielona 33/24%3%2",
                "Pokoj mamy%#00ff00%10.5%25%2",
                "Biurko%10%3.5%0.0%2%1.5%0.7%30.3",
                "Lampka%10%35%0.7%0.1%0.1%0.1%0.5",
                "Pokoj taty%#ffffff%10.5%23%1",
                "Lampka%10%35%0.7%0.1%0.1%0.1%0.5"
        );
        final String separator = "%";
        final Element biurko = new Element("Biurko", new Position(10.0f, 3.5f, 0.0f), 30.3f, new Size(2.0f, 1.5f, 0.7f));
        final Element lampka = new Element("Lampka", new Position(10.0f, 35f, 0.7f), 0.5f, new Size(0.1f, 0.1f, 0.1f));
        final Room pokojMamy = new Room("Pokoj mamy", "#00ff00", 25.0f, 10.5f, Arrays.asList(biurko, lampka));
        final Room pokojTaty = new Room("Pokoj taty", "#ffffff", 23.0f, 10.5f, Arrays.asList(lampka));
        final Home home = new Home("Dom na zielonym wzgórzu", "Ulica zielona 33/24", 3, Arrays.asList(pokojMamy, pokojTaty));

        //is
        Home result = homeFactory.createHome(homeStr, separator);


        //expected
        Assert.assertEquals(home, result);
    }
}
