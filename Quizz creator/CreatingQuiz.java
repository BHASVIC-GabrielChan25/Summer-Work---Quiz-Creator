import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CreatingQuiz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreatingQuiz extends World
{
    private int questionNumber;
    WriteXML write;
    /**
     * Constructor for objects of class CreatingQuiz.
     * 
     */
    public CreatingQuiz(int number , WriteXML writeXML)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        this.questionNumber = number;
        this.write = writeXML;
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Question question = new Question(questionNumber, "WRITE");
        addObject(question,500,80);
        Answer answer = new Answer("A", "WRITE");
        addObject(answer,250,330);
        Answer answer2 = new Answer("B", "WRITE");
        addObject(answer2,750,330);
        Answer answer3 = new Answer("C", "WRITE");
        addObject(answer3,250,480);
        Answer answer4 = new Answer("D", "WRITE");
        addObject(answer4,750,480);
        Proceed proceed = new Proceed(this.write);
        addObject(proceed, 940,570);
        QuestionCounter counter = new QuestionCounter();
        addObject(counter, 900, 30);
        FinishCreating finish = new FinishCreating(this.write);
        addObject(finish, 100,570);
    }
}
