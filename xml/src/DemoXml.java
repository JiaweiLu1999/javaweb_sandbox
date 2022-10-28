import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class DemoXml {
    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(DemoXml.class.getClassLoader().getResourceAsStream("employees.xml"));
        Element root = document.getRootElement();
        List<?> list = root.elements("employee");
        for (Object e: list) {
            if (e instanceof Element) {
                System.out.println(((Element) e).element("name").getText());
            }
        }
    }
}
