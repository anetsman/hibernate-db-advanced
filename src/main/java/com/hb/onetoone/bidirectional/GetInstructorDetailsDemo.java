package com.hb.onetoone.bidirectional;

import com.hb.onetoone.entity.Instructor;
import com.hb.onetoone.entity.InstructorDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetInstructorDetailsDemo {
    
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class)
                .buildSessionFactory();

        //create a session
        Session session = factory.getCurrentSession();

        try {
            //get a new session
            session.beginTransaction();

            //get the instructor details object
            int id = 222; //id from instructor_detail table
            InstructorDetails instructorDetails = session.get(InstructorDetails.class, id);

            //print the instructor details
            System.out.println("Instructor Details: " + instructorDetails);

            //prints the associated instructor
            System.out.println("the associated Instructor: " + instructorDetails.getInstructor());

            session.getTransaction().commit();

            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //handle connection leak issue
            session.close();

            factory.close();
        }
    }
}
