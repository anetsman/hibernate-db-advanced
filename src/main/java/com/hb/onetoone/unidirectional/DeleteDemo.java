package com.hb.onetoone.unidirectional;

import com.hb.onetoone.entity.Instructor;
import com.hb.onetoone.entity.InstructorDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteDemo {
    
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
            session = factory.getCurrentSession();
            session.beginTransaction();

            //get instructor by primary key(id)
            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println("Found instructor: " + instructor);

            //delete the instructors
            if (instructor != null) {
                System.out.println("Deleting instructor...");

                //It will also delete the instructor details object
                session.delete(instructor);
            }

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
