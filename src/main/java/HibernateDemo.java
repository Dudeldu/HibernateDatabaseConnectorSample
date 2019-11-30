import dhbw.se.hibernate.demo.Exam;
import dhbw.se.hibernate.demo.Student;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.text.SimpleDateFormat;
import java.util.*;

public class HibernateDemo {
    public static void main(String[] args){
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Exam.class);
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Student me = new Student("Moritz", new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2001"));
            Set<Exam> marks = new HashSet<Exam>();
            Exam exam = new Exam(10);
            marks.add(exam);
            me.setExams(marks);
            session.save(exam);
            int StudentID = (Integer) session.save(me);
            tx.commit();
        }

        catch (Exception e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        session = factory.openSession();
        try {
            tx = session.beginTransaction();
            List students = session.createQuery("FROM Student").list();
            for (Object studentOBJ : students) {
                Student student = (Student) studentOBJ;
                System.out.print("Name: " + student.getName());
                System.out.print(" Id: " + student.getId());
                System.out.print("  Exams: " + student.getExams().size());
                System.out.println(" Birthdate: " + student.getBirthdate());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        factory.close();
    }
}
