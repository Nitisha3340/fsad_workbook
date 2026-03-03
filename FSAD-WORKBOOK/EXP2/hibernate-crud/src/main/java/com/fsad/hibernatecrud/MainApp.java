package com.fsad.hibernatecrud;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fsad.hibernatecrud.entity.Product;

public class MainApp {

    public static void main(String[] args) {

        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p1 = new Product("Laptop", "HP Laptop", 60000, 10);
        Product p2 = new Product("Phone", "Samsung", 30000, 20);

        session.save(p1);
        session.save(p2);

        tx.commit();
        session.close();

        System.out.println("Products inserted");

       
        session = HibernateUtil.getSessionFactory().openSession();
        Product product = session.get(Product.class, 1);
        System.out.println("Fetched Product: " + product.getName());
        session.close();

        
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        Product updateProduct = session.get(Product.class, 1);
        updateProduct.setPrice(65000);
        updateProduct.setQuantity(15);

        session.update(updateProduct);

        tx.commit();
        session.close();

        System.out.println("Product updated");
 
        
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        Product deleteProduct = session.get(Product.class, 2);

        if (deleteProduct != null) {
            session.delete(deleteProduct);
            System.out.println("Product deleted");
        } else {
            System.out.println("Product not found for deletion");
        }

        tx.commit();
        session.close();
     
    }
}
