import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class QuestionCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuestionCounter extends TextBoxWrite
{
    boolean done;
    public QuestionCounter()
    {
        super("Question ", 35,Color.BLACK, Color.WHITE, Color.BLACK);
        done = false;
    }
    /**
     * Act - do whatever the QuestionCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(!done)
        {
        setImage( new GreenfootImage("Question " +getWorld().getObjects(Question.class).get(0).getQuestionNum(), 35, Color.BLACK, Color.WHITE, Color.BLACK));
        }
    }
}
