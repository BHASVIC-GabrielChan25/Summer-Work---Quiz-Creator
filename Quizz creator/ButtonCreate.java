import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButtonCreate extends Actor
{
    WriteXML write;
    String name;
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ButtonCreate(WriteXML writeXML)
    {
        getImage().scale(getImage().getWidth() *2, getImage().getHeight() *2);
        write = writeXML;
    }
    public void act()  
    {
        if (Greenfoot.mouseClicked(this))
        {
            try
            {
                setUpQuiz(); 
            }
            catch (ParserConfigurationException e)
            {
                System.out.println("Parser problem");
                Greenfoot.stop();
                e.printStackTrace();
            }
            Greenfoot.setWorld(new CreatingQuiz(1,write));
        }
    }
    public void setUpQuiz() throws ParserConfigurationException
    {
        name = JOptionPane.showInputDialog("Enter the title of the quiz");
        write.createXML(name);
    }
}
