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

    Scanner scanner = new Scanner(System.in);
    Question q;

    int nextQuestion = 0;
    public Quiz()
    {

        EntityManager em = Persistence.createEntityManagerFactory("demo")
                .createEntityManager();

        TypedQuery<Question> query = em.createQuery("select q from Question q", Question.class);
        List<Question> questions = query.getResultList();
    }

    public boolean showQuestionAndAnswer()
    {
        if (nextQuestion >= questions.size())
        {
            finish();

        }
        Question q = questions.get(nextQuestion);
        q.getAnswersList().clear();
            List<Answer> answers = q.getAnswersList();
            Question question = null;
            System.out.println(question.getText());

            for (int i = 0; i < answers.size(); i++) {
                Answer a = answers.get(i);
                System.out.println((i+1) + ")" + a.getText());
            }
            System.out.print("Your answer: ");
            int userAnswer = Integer.parseInt(scanner.nextLine());
            checkAnswer(q, userAnswer);
            return true;

    }

    private void finish()
    {


    }

    private  void checkAnswer (Question question, int userAnswer)
    {

    }
}
