package factories;

import models.Home;

import java.util.List;

public interface HomeFactory {
    Home createHome(List<String> lines, String separator);
}
