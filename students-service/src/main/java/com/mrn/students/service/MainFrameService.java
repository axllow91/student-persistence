package com.mrn.students.service;

import com.mrn.students.model.Student;

import java.util.List;

public interface MainFrameService {
    List<Student> getAllStudents();
    void shutdown();
}
