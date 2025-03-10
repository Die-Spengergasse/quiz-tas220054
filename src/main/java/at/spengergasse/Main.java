package at.spengergasse;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("demo")
                .createEntityManager();


        em.close();
    }
}
