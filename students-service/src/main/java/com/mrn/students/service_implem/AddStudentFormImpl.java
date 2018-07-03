package com.mrn.students.service_implem;

import com.mrn.students.model.Student;
import com.mrn.students.query.AddStudentQuery;
import com.mrn.students.service.AddStudentFormService;

public class AddStudentFormImpl implements AddStudentFormService {

    private AddStudentQuery addStudentQuery;

    public AddStudentFormImpl() {
        addStudentQuery = new AddStudentQuery();
    }

    public void insertStudent(Student student) {
        addStudentQuery.insertNewStudent(student);
    }
}
