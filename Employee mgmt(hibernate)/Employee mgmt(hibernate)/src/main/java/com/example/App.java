package com.example;

import com.example.entity.Employee;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {
      
        Employee emp = new Employee();
        emp.setFirstName("Alice");
        emp.setLastName("Smith");
        emp.setEmail("alice@example.com");
        emp.setSalary(55000.0);
        emp.setDepartment("HR");

        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(emp); 
            tx.commit();
            System.out.println("Employee saved with ID: " + emp.getId());
        } catch (Exception e) {
        	e.printStackTrace();   
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }

     
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Employee fetched = session.get(Employee.class, emp.getId());
            System.out.println("Fetched Employee: " + fetched);
        }

       
        HibernateUtil.shutdown();
    }
}
