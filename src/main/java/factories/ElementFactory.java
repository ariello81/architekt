package factories;

import models.Element;

public interface ElementFactory {
    Element createElement(String line, String separator);
}
