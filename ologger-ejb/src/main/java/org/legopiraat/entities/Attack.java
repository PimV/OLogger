package org.legopiraat.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Attack {

    @Id
    @GeneratedValue
    private Long id;

    private String date;

    @ManyToOne
    private Player player;

    private Long metal;
    private Long crystal;
    private Long deuterium;

    private Long debrisMetal;
    private Long debrisCrystal;
}
