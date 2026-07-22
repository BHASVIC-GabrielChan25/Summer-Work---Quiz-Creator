import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextBox extends Actor
{
    protected GreenfootImage image = null;
    protected String mode = null;
    /**
     * Act - do whatever the TextBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public TextBox(String message, int size, Color foreground, Color background , Color outline)
    {
        try{
        setImage(new GreenfootImage(message , size, foreground, background, outline));


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    
    }
    public void act()
    {
        // Add your action code here.
    }
}
