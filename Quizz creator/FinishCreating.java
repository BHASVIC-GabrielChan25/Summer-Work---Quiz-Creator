import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
import javax.xml.transform.*;
import java.io.IOException;

/**
 * Write a description of class ProceedCreating here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinishCreating extends TextBox
{
    WriteXML write;
    int choice;
    public FinishCreating(WriteXML writeXML)
    {
        super("Finish creating", 35,Color.BLACK, Color.WHITE, Color.BLACK);
        this.write = writeXML;
    }   
    /**
     * Act - do whatever the ProceedCreating wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            
            Object[] options= {"Yes", "CANCEL"};  
            choice = JOptionPane.showOptionDialog(null, "Are you going to finish the quiz?" , "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if(choice == 0)
            {
                if (emptyCheck())
                {   
                    try
                    {
                        saveQuestionDeck();
                    }
                    catch (TransformerException e)
                    {
                        System.out.println("Transformer error");
                        Greenfoot.stop();
                    } 
                    catch (IOException ie)
                    {
                        System.out.println("IO error");
                        ie.printStackTrace();
                        Greenfoot.stop();
                    }
                    Greenfoot.setWorld(new MainMenu());
            
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "There is an empty field!");
                }
            }
        }
    }
    
    public boolean emptyCheck()
    {
        if (getWorld().getObjects(Question.class).get(0).getQuestion() == null || 
                getWorld().getObjects(Answer.class).get(0).getAnswer() == null || 
                getWorld().getObjects(Answer.class).get(1).getAnswer() == null || 
                getWorld().getObjects(Answer.class).get(2).getAnswer() == null || 
                getWorld().getObjects(Answer.class).get(3).getAnswer() == null)
        {
            return false;
        }
        return true;   
    }
    
    public  void saveQuestionDeck() throws TransformerException, IOException
    {
        this.write.addQuestion(getWorld().getObjects(Question.class).get(0),getWorld().getObjects(Answer.class).get(0),getWorld().getObjects(Answer.class).get(1),getWorld().getObjects(Answer.class).get(2),getWorld().getObjects(Answer.class).get(3));
        this.write.finishXML();
        
    }
}
