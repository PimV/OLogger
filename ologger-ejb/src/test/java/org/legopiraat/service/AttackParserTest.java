package org.legopiraat.service;

import org.junit.Before;
import org.junit.Test;
import org.legopiraat.dao.PlayerDao;
import org.legopiraat.entities.Attack;
import org.legopiraat.entities.RequestAttack;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AttackParserTest {

    private RequestAttack requestAttack;
    private AttackParser attackParser;

    @Before
    public void before() {
        makeRequestAttack();
        attackParser = new AttackParser();
    }

    @Test
    public void testAttackWithoutDebris() {
        PlayerDao dao = mock(PlayerDao.class);
        attackParser.setPlayerDao(dao);

        when(dao.getPlayerByName("legopiraat")).thenReturn(null);

        Attack parsedAttack = attackParser.parse(requestAttack);

        assertThat(parsedAttack.getDate(), is(requestAttack.getAttackDate()));
        assertThat(parsedAttack.getCrystal(), is(69183L));
        assertThat(parsedAttack.getDebrisMetal(), is(0L));
    }

    private void makeRequestAttack() {
        requestAttack = new RequestAttack();

        requestAttack.setAttackDate("3-9-2015");
        requestAttack.setPlayerName("legopiraat");
        requestAttack.setAttackInfo("buit:\t142.377 metaal, 69.183 kristal en 12.728 deuterium.\n" +
                "puinveld: 0 metaal en 0 kristal.");
    }

}
