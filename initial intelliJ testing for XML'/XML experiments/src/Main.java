import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.Scanner;


public class Main {
    public Main() throws ParserConfigurationException, TransformerException {
        Scanner scan = new Scanner(System.in);
        System.out.println("1 for writing, 2 for reading");
        String option = scan.nextLine();
        if (option.equals( "2")) {
            System.out.println("Enter quiz name (excluding .xml)");
            String fileName = scan.nextLine();
            new ReadXML().readFile("Quizzes\\"+fileName+".xml");
        }
        else if (option.equals("1"))
        {
            new WriteXML().writeXML();
        }

    }
}

public void main(String[] args) throws ParserConfigurationException, TransformerException {new Main();}
