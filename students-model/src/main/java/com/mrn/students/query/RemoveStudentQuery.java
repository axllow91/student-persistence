package com.mrn.students.query;

import com.mrn.students.model.EntityManagerHandler;
import com.mrn.students.model.Student;

import javax.persistence.Query;
import java.util.List;

public class RemoveStudentQuery extends AbstractQuery{

    public RemoveStudentQuery() {
    }

    public List<Student> getAllStudents() {
        open();
        Query query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery("SELECT s FROM Student s");
        List<Student> studentList = query.getResultList();
        return studentList;
    }

    public void removeStudent(Student student) {
        open();
        // remove student
        EntityManagerHandler.INSTANCE.getEntityManager().remove(student);

        // commit the changes
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }
}
