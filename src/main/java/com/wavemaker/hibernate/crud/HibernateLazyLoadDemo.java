package com.wavemaker.hibernate.crud;

import com.wavemaker.hibernate.pojos.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 * Created by venkateswarluk on 28/7/16.
 */
public class HibernateLazyLoadDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = QuestionBank.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            System.out.println("Session load Example");
            Question question = (Question) session.load(Question.class, 1);
            transaction.commit();
            session.close();
            if(question == null){
                System.out.println("not found");
            }
            else {
                System.out.println("Question is found");
                System.out.println(question.getQid());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
