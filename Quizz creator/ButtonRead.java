import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButtonRead extends Actor
{   
    ReadXML readXML;
    String quizChoice;
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ButtonRead()
    {
        getImage().scale(getImage().getWidth() *2, getImage().getHeight() *2);
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            quizChoice = JOptionPane.showInputDialog("Enter the quiz name you want to load (file name excluding the .xml)");
            if (quizChoice != null)
            {
            readXML = new ReadXML(quizChoice + ".xml");
            Greenfoot.setWorld(new ReadingQuiz(1, readXML, 0));
            }
        }    
    }
}
