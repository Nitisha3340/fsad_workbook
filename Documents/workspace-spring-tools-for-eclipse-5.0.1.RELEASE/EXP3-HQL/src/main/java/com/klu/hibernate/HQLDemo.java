package com.klu.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class HQLDemo {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // Insert Products (5–8 records)
        session.save(new Product("Laptop","Electronics",60000,5));
        session.save(new Product("Phone","Electronics",25000,10));
        session.save(new Product("Keyboard","Accessories",1200,20));
        session.save(new Product("Mouse","Accessories",800,25));
        session.save(new Product("Monitor","Electronics",15000,7));
        session.save(new Product("Tablet","Electronics",20000,8));

        tx.commit();

        System.out.println("\n===== PRODUCTS INSERTED =====\n");

        // 1️⃣ Sort by Price ASC
        System.out.println("---- Price Ascending ----");

        Query<Product> q1 = session.createQuery(
                "FROM Product ORDER BY price ASC", Product.class);

        q1.list().forEach(p ->
                System.out.println(p.getName()+" "+p.getPrice()));


        // 2️⃣ Sort by Price DESC
        System.out.println("\n---- Price Descending ----");

        Query<Product> q2 = session.createQuery(
                "FROM Product ORDER BY price DESC", Product.class);

        q2.list().forEach(p ->
                System.out.println(p.getName()+" "+p.getPrice()));


        // 3️⃣ Sort by Quantity (Highest First)
        System.out.println("\n---- Quantity Highest First ----");

        Query<Product> q3 = session.createQuery(
                "FROM Product ORDER BY quantity DESC", Product.class);

        q3.list().forEach(p ->
                System.out.println(p.getName()+" "+p.getQuantity()));


        // 4️⃣ Pagination – First 3
        System.out.println("\n---- First 3 Products ----");

        Query<Product> q4 = session.createQuery(
                "FROM Product", Product.class);

        q4.setFirstResult(0);
        q4.setMaxResults(3);

        q4.list().forEach(p ->
                System.out.println(p.getName()));


        // 5️⃣ Pagination – Next 3
        System.out.println("\n---- Next 3 Products ----");

        Query<Product> q5 = session.createQuery(
                "FROM Product", Product.class);

        q5.setFirstResult(3);
        q5.setMaxResults(3);

        q5.list().forEach(p ->
                System.out.println(p.getName()));


        // 6️⃣ Aggregate Queries

        // Total products
        Long total = session.createQuery(
                "SELECT COUNT(*) FROM Product", Long.class)
                .uniqueResult();

        System.out.println("\nTotal Products: "+total);


        // Quantity > 0
        Long available = session.createQuery(
                "SELECT COUNT(*) FROM Product WHERE quantity > 0", Long.class)
                .uniqueResult();

        System.out.println("Available Products: "+available);


        // Group by description
        System.out.println("\n---- Products Grouped by Description ----");

        List<Object[]> group = session.createQuery(
                "SELECT description, COUNT(*) FROM Product GROUP BY description")
                .list();

        for(Object[] row : group)
            System.out.println(row[0]+" : "+row[1]);


        // Min and Max price
        Object[] prices = (Object[]) session.createQuery(
                "SELECT MIN(price), MAX(price) FROM Product")
                .uniqueResult();

        System.out.println("\nMinimum Price: "+prices[0]);
        System.out.println("Maximum Price: "+prices[1]);


        // 7️⃣ WHERE Price Range
        System.out.println("\n---- Products Price Between 1000 and 30000 ----");

        Query<Product> q6 = session.createQuery(
                "FROM Product WHERE price BETWEEN 1000 AND 30000",
                Product.class);

        q6.list().forEach(p ->
                System.out.println(p.getName()+" "+p.getPrice()));


        // 8️⃣ LIKE Queries

        System.out.println("\n---- Names Starting with 'P' ----");

        session.createQuery(
                "FROM Product WHERE name LIKE 'P%'", Product.class)
                .list()
                .forEach(p -> System.out.println(p.getName()));


        System.out.println("\n---- Names Ending with 'e' ----");

        session.createQuery(
                "FROM Product WHERE name LIKE '%e'", Product.class)
                .list()
                .forEach(p -> System.out.println(p.getName()));


        System.out.println("\n---- Names Containing 'top' ----");

        session.createQuery(
                "FROM Product WHERE name LIKE '%top%'", Product.class)
                .list()
                .forEach(p -> System.out.println(p.getName()));


        System.out.println("\n---- Names Length = 5 ----");

        session.createQuery(
                "FROM Product WHERE length(name)=5", Product.class)
                .list()
                .forEach(p -> System.out.println(p.getName()));


        session.close();
    }
}