package at.spengergasse;

import at.spengergasse.entities.Question;
import at.spengergasse.entities.Quiz;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        EntityManager em = Persistence.createEntityManagerFactory("demo")
                .createEntityManager();

        TypedQuery<Question> query = em.createQuery("select q from Question q", Question.class);
        List<Question> questions = query.getResultList();


        Quiz q = new Quiz();

        q.start();
//        for (Question q : questions)
//        {
//            System.out.println(q);
//        }

        em.close();
    }
}

