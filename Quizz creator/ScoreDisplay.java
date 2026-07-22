import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreDisplay extends TextBox
{
    private int score;
    private boolean setUp;
    public ScoreDisplay(int score)
    {
        super("Click to reveal your score!", 70,Color.BLACK, Color.WHITE, Color.BLACK);
        this.score = score;
        this.setUp = false;
    }
    /**
     * Act - do whatever the ScoreDisplay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(!setUp && Greenfoot.mouseClicked(this))
        {
            image = new GreenfootImage("Your score is \n"+score+"!", 70, Color.BLACK, Color.WHITE, Color.BLACK);
            setImage(image);
            ReturnBox returnBox = new ReturnBox();
            getWorld().addObject(returnBox, 500, 500);
        }
    }
}
