import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * Write a description of class Question here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Answer extends TextBox
{
    private String answer = null;
    private GreenfootImage image = null;
    private String answerOption;
    private boolean correct;
    private String choice;
    private ReadXML readXML;
    private int answerNumber;
    private boolean setUp;
    private boolean selected;
    private int answering;
    public Answer(String answer, String mode)
    {
        super("Insert Answer", 35,Color.BLACK, Color.WHITE, Color.BLACK);
        correct = false;
        answerOption = answer;
        this.mode = mode;
    }
    public Answer(String answer, String mode, ReadXML readXML)
    {
        super("Insert Answer", 35,Color.BLACK, Color.WHITE, Color.BLACK);
        correct = false;
        answerOption = answer;
        this.mode = mode;
        this.readXML = readXML;
        this.setUp = false;
    }
    /**
     * Act - do whatever the Question wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(mode.equals("WRITE"))
        {
 
                if (Greenfoot.mouseClicked(this))
                {
                    answer = JOptionPane.showInputDialog("Enter Answer:");
                    choice = JOptionPane.showInputDialog("Is this answer correct? (answer yes if true):");
                    if (choice.toLowerCase().equals ("yes"))
                    {
                        correct = true;
                    }
                    else
                    {
                        correct = false;
                    }
                }
                update();
            }
        else if (mode.equals("READ"))
        {
            if(!setUp)
                {
                    if (answerOption.equals("A"))
                    {
                        answerNumber = 1;
                    }
                    else if (answerOption.equals("B"))
                    {
                        answerNumber = 2;
                    }
                    else if (answerOption.equals("C"))
                    {
                        answerNumber = 3;
                    }
                    else if (answerOption.equals("D"))
                    {
                        answerNumber = 4;
                    }
                    else
                    {
                        answerNumber = 0;
                    }
                    answer = readXML.getAnswerContent(getWorld().getObjects(Question.class).get(0).getQuestionNum(), answerNumber);
                    correct = readXML.getAnswerCorrect(getWorld().getObjects(Question.class).get(0).getQuestionNum(), answerNumber);
                    update();
                    setUp = true;
                    }
                    
                
                if (Greenfoot.mouseClicked(this))
                {
                    Object[] options= {"Yes", "CANCEL"};  
                    answering = JOptionPane.showOptionDialog(null, "Click OK to continue to the next question." , "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                    if (answering == 0)
                    {
                        if(getWorld().getObjects(Question.class).get(0).getQuestionNum() < readXML.getNumOfQuestions()){
                        if (correct)
                        {
                            Greenfoot.setWorld(new ReadingQuiz(getWorld().getObjects(Question.class).get(0).getQuestionNum() + 1, readXML, getWorld().getObjects(QuestionCounter.class).get(0).getScore() + 1));
                        }
                        else
                        {
                            Greenfoot.setWorld(new ReadingQuiz(getWorld().getObjects(Question.class).get(0).getQuestionNum() + 1, readXML, getWorld().getObjects(QuestionCounter.class).get(0).getScore()));
                        }
                    }
                        else
                        {
                            Greenfoot.setWorld(new FinishScreen(getWorld().getObjects(QuestionCounter.class).get(0).getScore()));
                        }
                        
                    }
                }
            }
            else
            {
                Greenfoot.stop();
                System.out.println("something is wrong with the mode IN ANSWER");                
            }
    }
    
    public void update()
    {
        if(answer != null)
        {
        image = new GreenfootImage(answerOption+": "+answer, 35, Color.BLACK, Color.WHITE, Color.BLACK);
        setImage(image);
    }
    }
    
    public String getAnswer()
    {
        return answer;
    }
    public boolean getCorrect()
    {
        return correct;
    }
}
