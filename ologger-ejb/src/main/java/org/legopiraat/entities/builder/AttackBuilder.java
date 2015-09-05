package org.legopiraat.entities.builder;

import org.legopiraat.entities.Attack;

public class AttackBuilder {

    private Attack attack;

    private AttackBuilder() {
        attack = new Attack();
    }

    public AttackBuilder withMetal(Long metal) {
        attack.setMetal(metal);
        return this;
    }

    public AttackBuilder withCrystal(Long crystal) {
        attack.setCrystal(crystal);
        return this;
    }

    public AttackBuilder withDeuterium(Long deut) {
        attack.setDeuterium(deut);
        return this;
    }

    public AttackBuilder withDebrisMetal(Long metal) {
        attack.setDebrisMetal(metal);
        return this;
    }

    public AttackBuilder withDebrisCrystal(Long crystal) {
        attack.setDebrisCrystal(crystal);
        return this;
    }

    public static AttackBuilder newAttack() {
        return new AttackBuilder();
    }

    public Attack build() {
        return attack;
    }
}
