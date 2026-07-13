import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


public class ReadXML
{
    public void readFile(String filePath)
    {
        try {
            File file = new File(filePath);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            document.getDocumentElement().normalize();
            System.out.println(document.getDocumentElement().getAttribute("title"));

            NodeList nList = document.getElementsByTagName("Question");

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                Element element = (Element) node;
                System.out.println(element.getElementsByTagName("Content").item(0).getTextContent() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
