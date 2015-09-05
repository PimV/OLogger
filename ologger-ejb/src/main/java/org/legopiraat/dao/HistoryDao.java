package org.legopiraat.dao;

import org.legopiraat.entities.History;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class HistoryDao {

    @Inject
    private EntityManager entityManager;

    public void addNewHistory(History history) {
        entityManager.persist(history);
    }

    public List<History> getHistoryFromPlayer(String playerName) {
        String query = "SELECT h FROM History h WHERE h.player.name = :playerName";
        TypedQuery<History> typedQuery = entityManager.createQuery(query, History.class);
        typedQuery.setParameter("playerName", playerName);

        return typedQuery.getResultList();
    }
}
