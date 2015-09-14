package org.legopiraat.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ship {

    private int metal;
    private int crystal;
    private int deuterium;

    public Ship(int metal, int crystal, int deuterium) {
        this.metal = metal;
        this.crystal = crystal;
        this.deuterium = deuterium;
    }
}
