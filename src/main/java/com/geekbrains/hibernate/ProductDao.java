package com.geekbrains.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductDao {

    public Product saveOrUpdate(Product product) {
//        start();
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        Session session = null;
        session = factory.getCurrentSession();
        session.beginTransaction();
        product.getTitle();
        product.getCost();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
        System.out.println("Product saved successfully");
        return product;
    }

    public Product findById(long id) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        Session session = null;
        session = factory.getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        return product;
    }

    public List<Product> findAll() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        Session session = null;
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        session.getTransaction().commit();
        return products;
    }

    public void deleteById(long id) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        Session session = null;
        session = factory.getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.delete(product);
        session.getTransaction().commit();
    }

    private void start() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        Session session = null;
        session = factory.getCurrentSession();
        session.beginTransaction();
    }
}
