package com.mrn.students.model;

import com.mrn.utils.StringConstants;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

// singleton pattern
public enum EntityManagerHandler {

    INSTANCE;

    // read the data from the persistence.xml
    private EntityManagerFactory entityManagerFactory =
                                    Persistence.createEntityManagerFactory(StringConstants.PERSISTENCE_UNIT);

    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    // create a transaction
    private EntityTransaction entityTransaction = entityManager.getTransaction();

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public EntityTransaction getEntityTransaction() {
        return entityTransaction;
    }

    // this will open the connection to the DB
    public void open() {
        if(!entityTransaction.isActive()) {
            // test if transaction is active
            // otherwise begin the transaction
            entityTransaction.begin();
        }
    }

    public void shutdown() {
        entityManager.close();
        entityManagerFactory.close();
    }

}
