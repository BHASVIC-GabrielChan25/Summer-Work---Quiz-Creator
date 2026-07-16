import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        prepare();

    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        ButtonCreate buttonCreate = new ButtonCreate(new WriteXML());
        addObject(buttonCreate,280,310);
        TextBox createText = new TextBox("Create a quiz", 40, Color.BLACK, Color.WHITE, new Color(0,0,0,0));
        addObject(createText, 280, 230);
        ButtonRead buttonRead = new ButtonRead();
        addObject(buttonRead,700,310);
        TextBox readText = new TextBox("View a quiz", 40, Color.BLACK, Color.WHITE, new Color(0,0,0,0));
        addObject(readText, 700, 230);
    }
}
