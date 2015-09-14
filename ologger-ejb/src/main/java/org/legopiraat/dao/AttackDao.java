package org.legopiraat.dao;

import org.legopiraat.entities.Attack;
import org.legopiraat.entities.FleetLoss;
import org.legopiraat.entities.RequestAttack;
import org.legopiraat.service.AttackParser;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Stateless
public class AttackDao {

    @Inject
    private AttackParser attackParser;

    @Inject
    private EntityManager entityManager;

    @Inject
    private PlayerDao playerDao;

    public Attack newAttack(RequestAttack attack) {
        Attack parsedAttack = attackParser.parse(attack);

        entityManager.persist(parsedAttack);

        return parsedAttack;
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

    public Attack convertFleetLossToAttack(FleetLoss fleetLoss) {
        Attack attack = new Attack();

        attack.setMetal(-fleetLoss.getMetal());
        attack.setCrystal(-fleetLoss.getCrystal());
        attack.setDeuterium(-fleetLoss.getDeuterium());
        attack.setPlayer(playerDao.getPlayerByName(fleetLoss.getPlayerName()));
        attack.setDate(getTodaysDate());

        entityManager.persist(attack);

        return attack;
    }

    private String getTodaysDate() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        Calendar calendar = Calendar.getInstance();

        return df.format(calendar.getTime());
    }
}
