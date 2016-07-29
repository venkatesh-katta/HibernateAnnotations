package com.wavemaker.hibernate.crud;

import com.wavemaker.hibernate.pojos.Address;
import com.wavemaker.hibernate.pojos.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by venkateswarluk on 28/7/16.
 */
public class OneTOneDemo {
    public static void main(String[] args){
        SessionFactory sessionFactory = QuestionBank.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try{

            Address addressOne = new Address();
            addressOne.setCity("huderabad");
            addressOne.setState("telangana");
            addressOne.setStreet("ammerpet");

            Address addressTwo = new Address();
            addressTwo.setCity("Vizag");
            addressTwo.setState("Ap");
            addressTwo.setStreet("ongole");

            Student studentOne = new Student();
            studentOne.setName("venki");
            studentOne.setAddress(addressOne);

            Student studentTwo = new Student();
            studentTwo.setName("Sunil");
            studentTwo.setAddress(addressTwo);

            session.save(studentOne);
            session.save(studentTwo);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            transaction.commit();
            session.close();
            System.out.println("Sucessfully inserted");


        }






    }
}
