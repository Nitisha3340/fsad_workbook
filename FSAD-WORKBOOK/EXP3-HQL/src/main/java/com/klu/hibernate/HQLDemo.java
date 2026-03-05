package com.klu.hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class HQLDemo {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        session.save(new Product("Laptop","Electronics",60000,5));
        session.save(new Product("Phone","Electronics",25000,10));
        session.save(new Product("Keyboard","Accessories",1200,20));
        session.save(new Product("Mouse","Accessories",800,25));
        session.save(new Product("Monitor","Electronics",15000,7));

        session.getTransaction().commit();

        Query<Product> q = session.createQuery(
                "from Product order by price asc", Product.class);

        List<Product> list = q.list();

        for(Product p:list){
            System.out.println(p.getName()+" "+p.getPrice());
        }

        session.close();
    }
}