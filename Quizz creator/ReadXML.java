import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


public class ReadXML{
    
    
    private String filePath;
    
    ReadXML(String filePath)
    {
        this.filePath = filePath;
    }
    
    public Document getQuiz(String filePath)
    {
        Document document;
        try{
        File file = new File("Quizzes\\"+filePath);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();            
        document = db.parse(file);
        document.getDocumentElement().normalize();
        return document;
    }
    
    catch (Exception e)
    {
        System.out.println("Something is wrong when getting the quiz");
        return null;
    }
    }
    public String getQuestion (int questionNumber)
    {
        
        NodeList questionList = getQuiz(filePath).getElementsByTagName("Question");
        Node question = questionList.item(questionNumber - 1);

        String[] splicedString = question.getTextContent().split("\n");
        String questionContent = splicedString[1].strip();
        return questionContent;
    }
    
    public String getAnswerContent(int questionNumber, int answerNumber)
    {
        
        String AnswerContent = getQuiz(filePath).getElementsByTagName("Answer").item(answerNumber-1 +(questionNumber-1 )*4).getTextContent();
        
        
        
        return AnswerContent;
    }
    
    public Boolean getAnswerCorrect(int questionNumber, int answerNumber)
    {
        Document doc = getQuiz(filePath);
        if (doc.getElementsByTagName("Answer").item(answerNumber-1 +(questionNumber-1 )*4).getAttributes().item(0).getTextContent().equals("true"))
        {
            return true;
        }
        return false;
    }
    
    public int getNumOfQuestions()
    {
        return getQuiz(filePath).getElementsByTagName("Question").getLength();
    }
    
    public void test(String filePath)
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
