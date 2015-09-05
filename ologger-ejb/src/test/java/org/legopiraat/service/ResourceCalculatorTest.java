package org.legopiraat.service;

import org.junit.Before;
import org.junit.Test;
import org.legopiraat.entities.Attack;
import org.legopiraat.entities.builder.AttackBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ResourceCalculatorTest {

    private ResourceCalculator resourceCalculator;
    private List<Attack> attackList;

    @Before
    public void before() {
        resourceCalculator = new ResourceCalculator();
        attackList = new ArrayList<>();
    }

    @Test
    public void calculateTwoAttacks() {
        createTestAttackAndPuttInList();
        createTestAttackAndPuttInList();

        Attack combinedAttack = resourceCalculator.calculateTotalResources(attackList);

        assertThat(combinedAttack.getMetal(), is(800L));
        assertThat(combinedAttack.getCrystal(), is(400L));
        assertThat(combinedAttack.getDeuterium(), is(400L));
    }

    private void createTestAttackAndPuttInList() {
        Attack attack = AttackBuilder.newAttack()
                .withMetal(200L)
                .withCrystal(200L)
                .withDeuterium(200L)
                .withDebrisMetal(200L)
                .withDebrisCrystal(0L)
                .build();

        attackList.add(attack);
    }
}
