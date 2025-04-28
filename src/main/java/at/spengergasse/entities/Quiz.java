package at.spengergasse.entities;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class Quiz
{
    private List<Question> questions;
    private int rightAnswer = 0;
    Scanner scanner = new Scanner(System.in);
    //Question q;

   // int nextQuestion = 0;
    public Quiz() {

        EntityManager em = Persistence.createEntityManagerFactory("demo")
                .createEntityManager();

        TypedQuery<Question> query = em.createQuery("select q from Question q", Question.class);
       // List<Question> questions = query.getResultList();
        this.questions = query.getResultList();

//        for (Question q : questions)
//        {
//            q.getAnswersList().size();
//        }
//        em.close();
    }

        public void start ()
        {
            for (Question q : questions) {
                showQuestionAndAnswer(q);
            }
            showResults();
        }


        private void showQuestionAndAnswer (Question q)
        {
            System.out.print("\n" + q.getText());
            List<Answer> answer = q.getAnswersList();

            for (int i = 0; i < answer.size(); i++) {
                System.out.println((i + 1) + ")" + answer.get(i).getText());
            }


            System.out.print("Your answer (1- " + answer.size() + "):");
            int choice = scanner.nextInt() - 1;

            if (choice >= 0 && choice < answer.size() && answer.get(choice).isCorrect()) {
                System.out.println("True");
                rightAnswer++;
            } else {
                System.out.print("False, the right answer is :");
                for (Answer a : answer) {
                    if (a.isCorrect()) {
                        System.out.println(a.getText());
                    }
                }
            }

        }

        private void showResults ()
        {

            System.out.println("\n Du hast " + rightAnswer + "von " + questions.size() + "Fragen richtig beantwortet.");
            double percentage = ((double) rightAnswer / questions.size()) * 100;
            System.out.println("Prozentanteil der richtigen Antworten:" + String.format("%.2f", percentage) + "%");
        }



}

