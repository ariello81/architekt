import factories.HomeFactory;
import factories.HomeFactoryImpl;
import models.Home;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeLoaderImpl implements HomeLoader {

    public static final String SEPARATOR = "%";

    HomeFactory homeFactory = new HomeFactoryImpl();

    @Override
    public Home loadHome(String fileName, String separator) {
        List<String> lines = readFile(fileName);
        Home home = homeFactory.createHome(lines, separator);
        return home;
    }


    private List<String> readFile(String fileName){
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = reader.readLine()) != null ){
                System.out.println(line);
                lines.add(line);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

}
