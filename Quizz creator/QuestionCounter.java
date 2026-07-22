import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class QuestionCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuestionCounter extends TextBox
{
    private boolean done;
    private int score;
    public QuestionCounter()
    {
        super("Question ", 35,Color.BLACK, Color.WHITE, Color.BLACK);
        done = false;
    }
    public QuestionCounter(int score)
    {
        super("Question ", 35,Color.BLACK, Color.WHITE, Color.BLACK);
        done = false;
        this.score = score;
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
    public int getScore()
    {
        return score;
    }
}
