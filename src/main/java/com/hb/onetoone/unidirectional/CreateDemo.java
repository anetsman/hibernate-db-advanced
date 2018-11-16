package com.hb.onetoone.unidirectional;

import com.hb.onetoone.entity.Instructor;
import com.hb.onetoone.entity.InstructorDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

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
            //create the objects
//            Instructor instructor = new Instructor("Chad", "Darby", "cd@gmail.com");
//
//            InstructorDetails instructorDetails = new InstructorDetails("http://youtube.com", "coding");

            Instructor instructor = new Instructor("Dude", "dudly", "dd@gmail.com");

            InstructorDetails instructorDetails = new InstructorDetails("http://google.com", "jerking");

            //associate objects
            instructor.setInstructorDetails(instructorDetails);

            //begin the transaction
            session.beginTransaction();

            //save the instructor
            //!!!This will also save the instructor details because of CASCADE
            System.out.println("Saving the Instructor: " + instructor);
            session.save(instructor);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
