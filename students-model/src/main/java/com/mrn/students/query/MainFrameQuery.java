package com.mrn.students.query;

import com.mrn.students.model.EntityManagerHandler;
import com.mrn.students.model.Student;

import javax.persistence.Query;
import java.util.List;

public class MainFrameQuery extends AbstractQuery {

    public MainFrameQuery() {
    }

    public List<Student> getStudents() {
        // opening the connection
        open();
        Query query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery("SELECT s FROM Student s");
        List<Student> studentList = query.getResultList();
        return studentList;
    }
}
