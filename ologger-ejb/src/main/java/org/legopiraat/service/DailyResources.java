package org.legopiraat.service;

import org.legopiraat.dao.AttackDao;
import org.legopiraat.dao.HistoryDao;
import org.legopiraat.dao.PlayerDao;
import org.legopiraat.entities.Attack;
import org.legopiraat.entities.History;
import org.legopiraat.entities.Player;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;

@Startup
@Singleton
public class DailyResources {

    @Inject
    private AttackDao attackDao;

    @Inject
    private PlayerDao playerDao;

    @Inject
    private ResourceCalculator resourceCalculator;

    @Inject
    private HistoryDao historyDao;


    @Schedule(dayOfWeek="*", hour="00", minute = "01", persistent = false)
    public void calculateHistoryForAllPlayers() {
        List<Player> allPlayers = playerDao.getAllPlayers();

        allPlayers.stream()
                .forEach(this::calculateDailyAttacks);
    }

    private void calculateDailyAttacks(Player player) {
        List<Attack> allAttacks = attackDao.getAllAttacksByPlayerNameAndDate(getYesterdaysDate(), player.getName());

        Attack historyAttack = resourceCalculator.calculateTotalResources(allAttacks);

        History history = new History();

        history.setPlayer(player);
        history.setDate(getYesterdaysDate());
        history.setAttack(historyAttack);

        historyDao.addNewHistory(history);
    }

    private String getYesterdaysDate() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);

        return df.format(calendar.getTime());
    }
}
