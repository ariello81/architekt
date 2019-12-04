package factories;

import models.Element;
import models.Home;
import models.Position;
import models.Size;
import models.properties.ElementProperty;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static javax.swing.text.StyleConstants.Size;

public class ElementFactoryImpl implements ElementFactory {
    @Override
    public Element createElement(String line, String separator) {
        String[] elementSplitLine = line.split(separator);
        Map<ElementProperty, String> elementDetails = new EnumMap<>(ElementProperty.class);
        for (int i=0; i<elementSplitLine.length; i++){
            elementDetails.put(ElementProperty.values()[i], elementSplitLine[i]);
        }
        Position position = new Position(Float.valueOf(elementDetails.get(ElementProperty.POSITION_X)), Float.valueOf(elementDetails.get(ElementProperty.POSITION_Y)),
                Float.valueOf(elementDetails.get(ElementProperty.POSITION_Z)));
        models.Size size = new Size(Float.valueOf(elementDetails.get(ElementProperty.LENGTH)), Float.valueOf(elementDetails.get(ElementProperty.WIDTH)),
                Float.valueOf(elementDetails.get(ElementProperty.HEIGHT)));
        // create one element by line
        return new Element(elementDetails.get(ElementProperty.ELEMENT_NAME), position, Float.valueOf(elementDetails.get(ElementProperty.WEIGHT)), size);
    }
}
