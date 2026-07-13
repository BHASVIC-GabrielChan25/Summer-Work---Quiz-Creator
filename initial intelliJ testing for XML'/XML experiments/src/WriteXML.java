import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class WriteXML {

    public static void writeXML () throws ParserConfigurationException, TransformerException
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc  = db.newDocument();
        Scanner inp = new Scanner (System.in);
        boolean nextQuestion = true;



        Element QDeck = doc.createElement("QuestionDeck");
        Element rootElem = QDeck;
        doc.appendChild(rootElem);

        System.out.println("What is the name of your question deck?:");
        String title = inp.nextLine();
        QDeck.setAttribute("title" , title);


        Element questions = doc.createElement("Questions");
        rootElem.appendChild(questions);



        while (nextQuestion)
        {
            Element question = doc.createElement("Question");
            questions.appendChild(question);

            System.out.println("Enter Question:");
            question.appendChild(doc.createElement("Content"));
            String text = inp.nextLine();
            question.getElementsByTagName("Content").item(0).setTextContent(text);


            System.out.println("Press 1 to finish deck ");
            String answer = inp.nextLine();
            if (answer.equals( "1"))
            {
                nextQuestion = false;
            }
            else {
                System.out.println("Next Question.\n----------------------------------------------");
            }
        }

        try (FileOutputStream output = new FileOutputStream(title+".xml"))
        {
            writeXml(doc, output);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }




    }

    private static void writeXml(Document doc,
                                 OutputStream output)
            throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        //make it pretty
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);

    }

}
