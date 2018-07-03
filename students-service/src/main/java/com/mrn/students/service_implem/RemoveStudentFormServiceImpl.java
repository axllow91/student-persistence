package com.mrn.students.service_implem;

import com.mrn.students.model.Student;
import com.mrn.students.query.RemoveStudentQuery;
import com.mrn.students.service.RemoveStudentFormService;

import java.util.List;

public class RemoveStudentFormServiceImpl implements RemoveStudentFormService {

    private RemoveStudentQuery removeStudentQuery;

    public RemoveStudentFormServiceImpl() {
        removeStudentQuery = new RemoveStudentQuery();
    }

    public List<Student> getAllStudents() {
        return removeStudentQuery.getAllStudents();
    }

    public void removeStudent(Student student) {
        removeStudentQuery.removeStudent(student);
    }
}
