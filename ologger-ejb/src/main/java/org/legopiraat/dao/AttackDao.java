package org.legopiraat.dao;

import org.legopiraat.entities.Attack;
import org.legopiraat.entities.RequestAttack;
import org.legopiraat.service.AttackParser;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class AttackDao {

    @Inject
    private AttackParser attackParser;

    @Inject
    private EntityManager entityManager;

    public void newAttack(RequestAttack attack) {
        Attack parsedAttack = attackParser.parse(attack);

        entityManager.persist(parsedAttack);
    }

    public List<Attack> getAllAttacksByPlayerNameAndDate(String attackDate, String playerName) {
        String query = "SELECT a FROM Attack a WHERE a.date = :attackDate AND a.player.name = :playerName";
        TypedQuery<Attack> typedQuery = entityManager.createQuery(query, Attack.class);
        typedQuery.setParameter("attackDate", attackDate);
        typedQuery.setParameter("playerName", playerName);

        return typedQuery.getResultList();
    }

    public List<Attack> getAllAttacksFromDate(String attackDate) {
        String query = "SELECT a FROM Attack a WHERE a.date = :attackDate";
        TypedQuery<Attack> typedQuery = entityManager.createQuery(query, Attack.class);
        typedQuery.setParameter("attackDate", attackDate);

        return typedQuery.getResultList();
    }

}
