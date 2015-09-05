package org.legopiraat.service;

import org.legopiraat.dao.AttackDao;
import org.legopiraat.dao.HistoryDao;
import org.legopiraat.dao.PlayerDao;
import org.legopiraat.entities.Attack;
import org.legopiraat.entities.History;
import org.legopiraat.entities.Player;
import org.quartz.*;

import javax.inject.Inject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;

public class DailyResources implements Job {

    @Inject
    private AttackDao attackDao;

    @Inject
    private PlayerDao playerDao;

    @Inject
    private ResourceCalculator resourceCalculator;

    @Inject
    private HistoryDao historyDao;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        List<Player> allPlayers = playerDao.getAllPlayers();

        allPlayers.stream()
                .forEach(this::calculateDailyAttacks);
    }

    private void calculateDailyAttacks(Player player) {
        List<Attack> allAttacks = attackDao.getAllAttacksByPlayerNameAndDate(player.getName(), getYesterdaysDate());

        Attack historyAttack = resourceCalculator.calculateTotalResources(allAttacks);

        History history = new History();

        history.setPlayer(player);
        history.setDate(getTodayDate());
        history.setAttack(historyAttack);

        historyDao.addNewHistory(history);
    }

    private String getTodayDate() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        Calendar calendar = Calendar.getInstance();

        return df.format(calendar.getTime());
    }

    private String getYesterdaysDate() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);

        return df.format(calendar.getTime());
    }
}
