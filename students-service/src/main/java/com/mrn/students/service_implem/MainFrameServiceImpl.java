package com.mrn.students.service_implem;

import com.mrn.students.model.Student;
import com.mrn.students.query.MainFrameQuery;
import com.mrn.students.service.MainFrameService;

import java.util.List;

public class MainFrameServiceImpl implements MainFrameService {

    private MainFrameQuery mainFrameQuery;

    public MainFrameServiceImpl() {
        this.mainFrameQuery = new MainFrameQuery();
    }

    public List<Student> getAllStudents() {
        return mainFrameQuery.getStudents();
    }

    public void shutdown() {
        mainFrameQuery.shutdown();
    }
}
