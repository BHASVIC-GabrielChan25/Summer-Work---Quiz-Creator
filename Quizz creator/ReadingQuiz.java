import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ReadingQuiz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ReadingQuiz extends World
{
    private int questionNumber;
    private ReadXML readXML;
    private int score;
    /**
     * Constructor for objects of class ReadingQuiz.
     * 
     */
    public ReadingQuiz(int questionNumber, ReadXML readXML, int score)
    {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        this.questionNumber = questionNumber;
        this.readXML = readXML;
        this.score = score;
        prepare();
    }

    
    public void prepare()
    {
        Question question = new Question(questionNumber, "READ", readXML);
        addObject(question,500,80);
        Answer answer = new Answer("A", "READ", readXML);
        addObject(answer,250,330);
        Answer answer2 = new Answer("B", "READ", readXML);
        addObject(answer2,750,330);
        Answer answer3 = new Answer("C", "READ", readXML);
        addObject(answer3,250,480);
        Answer answer4 = new Answer("D", "READ", readXML);
        addObject(answer4,750,480);
        QuestionCounter counter = new QuestionCounter(score);
        addObject(counter, 900, 30);

    }
}
