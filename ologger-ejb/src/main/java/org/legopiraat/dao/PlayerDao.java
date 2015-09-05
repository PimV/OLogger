package org.legopiraat.dao;

import org.legopiraat.entities.Player;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PlayerDao {

    @Inject
    private EntityManager entityManager;

    public void addNewPlayer(Player player) {
        entityManager.persist(player);
    }

    public Player getPlayerByName(String playerName) {
        String query = "SELECT p FROM Player p WHERE p.name = :playerName";
        TypedQuery<Player> typedQuery = entityManager.createQuery(query, Player.class);
        typedQuery.setParameter("playerName", playerName);

        Player player = typedQuery.getSingleResult();


        return player;
    }

    public List<Player> getAllPlayers() {
        String query = "SELECT p FROM Player p";
        TypedQuery typedQuery = entityManager.createQuery(query, Player.class);

        return typedQuery.getResultList();
    }
}
