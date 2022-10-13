package com.geekbrains.hibernate;

public class MainDZ {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
//        Product product = new Product();
//        product.setTitle("Apple");
//        product.setCost(76);
//        productDao.saveOrUpdate(product);
//        System.out.println(productDao.findById(4));
//        System.out.println(productDao.findAll());
//        productDao.deleteById(4);
//        System.out.println(productDao.findAll());

        ConsumerDAO consumerDAO = new ConsumerDAO();
//        Consumer consumer = new Consumer();
        consumerDAO.findAllProducts(2);
    }
}
