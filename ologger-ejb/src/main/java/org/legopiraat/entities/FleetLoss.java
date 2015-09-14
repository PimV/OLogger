package org.legopiraat.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FleetLoss {

    private String playerName;

    private Long metal;
    private Long crystal;
    private Long deuterium;
}
