import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * Write a description of class Question here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Question extends TextBoxWrite
{
    private String question = null;
    private GreenfootImage image = null;
    private int questionNumber;
    public Question(int number)
    {
        super("Insert Question", 70,Color.BLACK, Color.WHITE, Color.BLACK);
        questionNumber = number;

    }
    /**
     * Act - do whatever the Question wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            question = JOptionPane.showInputDialog("Enter question:");
        }
        update();
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
