package com.mrn.students.service;

import com.mrn.students.model.Student;

import java.util.List;

public interface RemoveStudentFormService {
    List<Student> getAllStudents();
    void removeStudent(Student student);

}
