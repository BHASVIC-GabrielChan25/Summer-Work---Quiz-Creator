import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinishScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinishScreen extends World
{
    private int score;
    /**
     * Constructor for objects of class FinishScreen.
     * 
     */
    public FinishScreen(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        this.score = score;
        prepare();
    }
    
    public void prepare()
    {
        ScoreDisplay scoreDisplay = new ScoreDisplay(score);
        addObject(scoreDisplay , 500,300);
        

    }
}
