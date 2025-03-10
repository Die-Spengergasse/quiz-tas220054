package at.spengergasse;

import at.spengergasse.entities.Answer;
import at.spengergasse.entities.Question;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class Quiz
{
    private List<Question> questions;

    private Scanner scanner = new Scanner(System.in);

    public Quiz()
    {

        EntityManager em = Persistence.createEntityManagerFactory("demo")
                .createEntityManager();

        TypedQuery<Question> query = em.createQuery("select q from Question q", Question.class);
        List<Question> questions = query.getResultList();
    }

    public void showQuestionAndAnswer()
    {
        Question question = null;
        System.out.println(question.getText());
        //List<Answer> answers = questions.getAnswerList();
        for ( int i = 0; i < questions.size(); i++ )
        {
            //Answer a = answers.get(i);
           // System.out.println((i+1) + ")" + a.getText());
        }
        System.out.print("Your answer: ");
        int userAnswer = Integer.parseInt(scanner.nextLine());
    }
}
