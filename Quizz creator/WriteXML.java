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

public class WriteXML
{
     Document doc = null;
     String title = "N/A";
     Element questions = null;
    public  void setUp()throws ParserConfigurationException
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        doc  = db.newDocument();
    }
    public  void createXML(String pTitle)throws ParserConfigurationException
    {
        setUp();
        Element QDeck = doc.createElement("QuestionDeck");
        Element rootElem = QDeck;
        doc.appendChild(rootElem);

        QDeck.setAttribute("Title" , pTitle);
        this.title = pTitle;

        questions = doc.createElement("Questions");
        rootElem.appendChild(questions);
 
    }
    
    public  void addQuestion(Question Pquestion, Answer answerA, Answer answerB, Answer answerC, Answer answerD)
    {
        Element question = doc.createElement("Question");
        questions.appendChild(question);
        Answer[] answerList = {answerA, answerB, answerC, answerD};
        
        question.setTextContent(Pquestion.getQuestion());
        

        
        for (int i = 0; i < 4 ; i++){
            Element answer = doc.createElement("Answer");
            question.appendChild(answer);

            answer.setTextContent(answerList[i].getAnswer());
            if(answerList[i].getCorrect() == true)
            {
                answer.setAttribute("Correct", "true");
            }
            else
            {
                answer.setAttribute("Correct", "false");
            }

        }

        

    }
    
    public  void finishXML() throws TransformerException, IOException
    {
        FileOutputStream output = new FileOutputStream("Quizzes\\"+title+".xml");
        writeXml(doc, output);
        /**
        try ()
        {
        }
        catch (IOException e)
        {
            System.out.println("IO error");
        }
        */
    }
    
    public static void test () throws ParserConfigurationException, TransformerException
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

        try (FileOutputStream output = new FileOutputStream("Quizzes\\"+title+".xml"))
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
