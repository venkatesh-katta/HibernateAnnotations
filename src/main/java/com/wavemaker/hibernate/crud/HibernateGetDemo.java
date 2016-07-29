package com.wavemaker.hibernate.crud;

import com.wavemaker.hibernate.pojos.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by venkateswarluk on 28/7/16.
 */
public class HibernateGetDemo {
    public static void main(String[] args){
        SessionFactory sessionFactory = QuestionBank.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            Question question = (Question) session.get(Question.class,1);
            transaction.commit();
            session.close();
            if(question == null){
                System.out.println("Question Details Not Found");
            }else{
                System.out.println("Question Details Found !! ");
                System.out.println("Question  ID= " + question.getQid());
                System.out.println("Question Name - "+question.getQname());
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            transaction.commit();
            session.close();
        }
    }
}
