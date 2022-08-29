package com.vicego.recordtracker.util;

import com.vicego.recordtracker.entity.Person;
import com.vicego.recordtracker.exception.UserNotFoundException;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.UUID;
@Slf4j
public class HibernateUtil {
    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            if (sessionFactory == null) {
                StandardServiceRegistry standardRegistry
                        = new StandardServiceRegistryBuilder()
                        .configure()
                        .build();

                Metadata metadata = new MetadataSources(standardRegistry)
                        .getMetadataBuilder()
                        .build();

                sessionFactory = metadata.getSessionFactoryBuilder().build();
            }
            return sessionFactory;
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }


    public static void savePerson(Person person) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(person);
        session.getTransaction().commit();
        session.close();
        AppUtil.showAlert("Registration success", "You have registered successfully, \nKindly login!!!");
    }


    /*public static Person findById(UUID uuid) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //Query<Person> findPersonQuery = session.createQuery("from Person where id = :id", Person.class);
        //findPersonQuery.setParameter("id", uuid);
//        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
//        Query<Person> findPersonQuery =  builder.createQuery(Person.class);
//
//        Person  person = findPersonQuery.getSingleResult();
        //session.getTransaction().commit();
        session.close();
        return person;
    }*/

    public static Person findByEmail(String email) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query findPersonQuery = session.createQuery("from Person where email = :email", Person.class);
        findPersonQuery.setParameter("email", email);

        if (findPersonQuery.getSingleResult() != null) {
            //return  (Person) findPersonQuery.getSingleResult();
            Person person = (Person) findPersonQuery.getSingleResult();
            session.getTransaction().commit();
            session.close();
            log.info("User login success: {}", person);
            return person;
        }
        //log.info("User with email {} not found", email);
        throw new UserNotFoundException("User not found");
    }

}
