    package com.wavemaker.hibernate.crud;

    import com.wavemaker.hibernate.pojos.Answer;
    import com.wavemaker.hibernate.pojos.Question;
    import org.hibernate.Session;
    import org.hibernate.SessionFactory;
    import org.hibernate.Transaction;

    import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
    import org.hibernate.cfg.Configuration;
    import org.hibernate.service.ServiceRegistry;


    import java.util.ArrayList;
    import java.util.List;

    /**
     * Created by venkateswarluk on 28/7/16.
     */
    public class QuestionBank {

        public static void main(String[] args){

            SessionFactory sessionFactory = buildSessionFactory();

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Question questionOne = new Question();

            List<Answer> answerList = new ArrayList<Answer>();
            Answer answerOne = new Answer();
            answerOne.setAnswer("java is a platform");
            answerOne.setPostedBy("venki");
            answerOne.setQuestion(questionOne);
            answerList.add(answerOne);

            Answer answerTwo = new Answer();
            answerTwo.setAnswer("Java ia proframming language");
            answerTwo.setPostedBy("venkat");
            answerTwo.setQuestion(questionOne);
            answerList.add(answerTwo);



            questionOne.setQname("What is java");
            //questionOne.setAnswerList(answerList);
            session.save(questionOne);

            session.flush();
            transaction.commit();
            session.close();

            System.out.println("Sucessfully Inserted!!!!!!");

        }

        public static SessionFactory buildSessionFactory()
        {
            Configuration configuration = new Configuration().configure("/configuration/hibernate.cfg.xml");
            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
            serviceRegistryBuilder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
            return configuration.buildSessionFactory(serviceRegistry);

        }
    }
