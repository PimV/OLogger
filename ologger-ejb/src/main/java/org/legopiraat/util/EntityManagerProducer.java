package org.legopiraat.util;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.io.Serializable;

/**
 * Creates Entity manager for CDI in right percistence context.
 */
@SessionScoped
public class EntityManagerProducer implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "OLogger")
    private EntityManager entityManager;

    /**
     * Produces entityManager for CDI
     *
     * @return entityManager
     */
    @Produces
    public EntityManager getEntityManager() {
        return entityManager;
    }
}