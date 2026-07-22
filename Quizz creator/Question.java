import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * Write a description of class Question here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Question extends TextBox
{
    private String question = null;
    private GreenfootImage image = null;
    private int questionNumber;
    private ReadXML readXML;
    public Question(int number, String mode)
    {
        super("Insert Question", 70,Color.BLACK, Color.WHITE, Color.BLACK);
        questionNumber = number;
        this.mode = mode;
        this.readXML = new ReadXML(null);
    }
    public Question(int number, String mode, ReadXML readXML)
    {
        super("Insert Question", 70,Color.BLACK, Color.WHITE, Color.BLACK);
        questionNumber = number;
        this.mode = mode;
        this.readXML = readXML;
    }
    /**
     * Act - do whatever the Question wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (mode.equals("WRITE"))   
        {
            if (Greenfoot.mouseClicked(this))
            {
                question = JOptionPane.showInputDialog("Enter question:");
            }
            update();
        }
        else if (mode.equals("READ"))
        {
            question = readXML.getQuestion(questionNumber);
            update();
        }
        else
        {
            Greenfoot.stop();
            System.out.println("Something is wrong with the mode IN QUESTION");             
        }
    }
    
    
    public void update()
    {
        if(question != null){
        image = new GreenfootImage(question, 70, Color.BLACK, Color.WHITE, Color.BLACK);
        setImage(image);
        }
    }
    
    public String getQuestion()
    {
        return question;
    }
    
    public int getQuestionNum()
    {
        return questionNumber;
    }
}
