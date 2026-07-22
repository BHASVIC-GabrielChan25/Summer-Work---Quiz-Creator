import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ReturnBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ReturnBox extends TextBox
{
    public ReturnBox()
    {
        super("Click to return to main menu.", 70,Color.BLACK, Color.WHITE, Color.BLACK);

    }
    /**
     *
     * Act - do whatever the ReturnBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new MainMenu()); 
        }
    }
}
