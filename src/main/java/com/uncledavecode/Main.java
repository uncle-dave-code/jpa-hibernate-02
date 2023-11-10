package com.uncledavecode;

import com.uncledavecode.config.MyPersistenceUnitInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "none");


        try (EntityManagerFactory entityManagerFactory
                     = new HibernatePersistenceProvider().createContainerEntityManagerFactory(new MyPersistenceUnitInfo(), properties)) {
            /* EntityManager -> Persistence Context */
            EntityManager em = entityManagerFactory.createEntityManager();

            em.getTransaction().begin();

            em.getTransaction().commit();
        }
    }
}