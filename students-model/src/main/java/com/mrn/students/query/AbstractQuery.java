package com.mrn.students.query;

import com.mrn.students.model.EntityManagerHandler;

public class AbstractQuery {
    public void open() {
        EntityManagerHandler.INSTANCE.open();
    }

    public void shutdown() {
        EntityManagerHandler.INSTANCE.shutdown();
    }
}
