package org.legopiraat.service;

import org.legopiraat.entities.Attack;
import org.legopiraat.entities.builder.AttackBuilder;

import java.util.List;

public class ResourceCalculator {

    private Attack totalAttack;

    public Attack calculateTotalResources(List<Attack> attacks) {
        initNewTotalAttack();
        attacks.forEach(a -> addToTotal(a));

        return totalAttack;
    }

    private void addToTotal(Attack attack) {
        totalAttack.setMetal(totalAttack.getMetal() + attack.getMetal() + attack.getDebrisMetal());
        totalAttack.setCrystal(totalAttack.getCrystal() + attack.getCrystal() + attack.getDebrisCrystal());
        totalAttack.setDeuterium(totalAttack.getDeuterium() + attack.getDeuterium());
    }

    private void initNewTotalAttack() {
        totalAttack = AttackBuilder.newAttack()
                .withMetal(0L)
                .withCrystal(0L)
                .withDeuterium(0L)
                .build();
    }
}
