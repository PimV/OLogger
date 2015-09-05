package org.legopiraat.service;

import org.legopiraat.dao.PlayerDao;
import org.legopiraat.entities.Attack;
import org.legopiraat.entities.RequestAttack;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AttackParser {

    @Inject
    private PlayerDao playerDao;

    private Attack attack;

    public Attack parse(RequestAttack requestAttack) {
        initNewAttack(requestAttack);
        parseAttackInfo(requestAttack.getAttackInfo());

        return attack;
    }

    private void initNewAttack(RequestAttack requestAttack) {
        attack = new Attack();
        attack.setPlayer(playerDao.getPlayerByName(requestAttack.getPlayerName()));
        attack.setDate(requestAttack.getAttackDate());
    }

    private void parseAttackInfo(String attackInfo) {
        String[] parts = attackInfo.split(" |\t|\n");

        int number = 0;

        for (String part : parts) {
            if (isDigit(part)) {
                updateAttack(part, number);
                number++;
            }
        }
    }

    private void updateAttack(String part, int number) {
        switch (number) {
            case 0:
                attack.setMetal(new Long(part.replace(".", "")));
                break;
            case 1:
                attack.setCrystal(new Long(part.replace(".", "")));
                break;
            case 2:
                attack.setDeuterium(new Long(part.replace(".", "")));
                break;
            case 3:
                attack.setDebrisMetal(new Long(part.replace(".", "")));
                break;
            case 4:
                attack.setDebrisCrystal(new Long(part.replace(".", "")));
                break;
        }
    }

    private boolean isDigit(String part) {
        char c = part.charAt(0);
        return (c >= '0' && c <= '9');
    }

    /**
     * Set playerDao only for test purpose.
     *
     * @param dao
     */
    public void setPlayerDao(PlayerDao dao) {
        this.playerDao = dao;
    }
}
