package com.mrn.students.query;

import com.mrn.students.model.EntityManagerHandler;
import com.mrn.students.model.Student;

public class AddStudentQuery extends AbstractQuery {

    public AddStudentQuery() {
    }

    public void insertNewStudent(Student student) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(student);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }
}
