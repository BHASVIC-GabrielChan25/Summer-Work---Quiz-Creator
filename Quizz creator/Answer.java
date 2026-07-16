import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * Write a description of class Question here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Answer extends TextBoxWrite
{
    private String answer = null;
    private GreenfootImage image = null;
    private String answerOption;
    private boolean correct;
    private String choice;
    public Answer(String answer)
    {
        super("Insert Answer", 35,Color.BLACK, Color.WHITE, Color.BLACK);
        correct = false;
        answerOption = answer;
    }
    /**
     * Act - do whatever the Question wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            answer = JOptionPane.showInputDialog("Enter Answer:");
            choice = JOptionPane.showInputDialog("Is this answer correct? (answer yes if true):");
            if (choice.toLowerCase().equals ("yes"))
            {
                correct = true;
            }
            else
            {
                correct = false;
            }
        }
        update();
    }
    
    public void update()
    {
        if(answer != null)
        {
        image = new GreenfootImage(answerOption+": "+answer, 35, Color.BLACK, Color.WHITE, Color.BLACK);
        setImage(image);
    }
    }
    
    public String getAnswer()
    {
        return answer;
    }
    public boolean getCorrect()
    {
        return correct;
    }
}
