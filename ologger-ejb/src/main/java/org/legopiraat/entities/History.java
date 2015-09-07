package org.legopiraat.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class History {

    @Id
    @GeneratedValue
    private Long id;

    private String date;

    @OneToOne
    private Player player;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Attack attack;

}
