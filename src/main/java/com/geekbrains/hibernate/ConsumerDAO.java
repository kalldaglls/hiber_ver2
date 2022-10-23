package com.geekbrains.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ConsumerDAO {

    public Consumer saveOrUpdate(Consumer consumer) {
//        start();
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Consumer.class)
                .buildSessionFactory();
        Session session = null;
        session = factory.getCurrentSession();
        session.beginTransaction();
        consumer.getName();
        session.saveOrUpdate(consumer);
        session.getTransaction().commit();
        System.out.println("Consumer saved successfully");
        return consumer;
    }

    public Consumer findById(long id) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Consumer.class)
                .buildSessionFactory();
        Session session = null;
        session = factory.getCurrentSession();
        session.beginTransaction();
        Consumer consumer = session.get(Consumer.class, id);
        session.getTransaction().commit();
        return consumer;
    }

    public List<Consumer> findAll() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Consumer.class)
                .buildSessionFactory();
        Session session = null;
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Consumer> consumers = session.createQuery("FROM Consumer", Consumer.class).getResultList();
        session.getTransaction().commit();
        return consumers;
    }

    public void deleteById(long id) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Consumer.class)
                .buildSessionFactory();
        Session session = null;
        session = factory.getCurrentSession();
        session.beginTransaction();
        Consumer consumer = session.get(Consumer.class, id);
        session.delete(consumer);
        session.getTransaction().commit();
    }
    @Transactional
    public Consumer findAllProducts(long id) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Consumer.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        Session session = null;
        session = factory.getCurrentSession();
        session.beginTransaction();
        Consumer consumer = session.get(Consumer.class, id);
        System.out.println(consumer);
        session.getTransaction().commit();
        return consumer;
    }

    private void start() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Consumer.class)
                .buildSessionFactory();
        Session session = null;
        session = factory.getCurrentSession();
        session.beginTransaction();
    }
}