package org.legopiraat.entities.enums;

import org.legopiraat.entities.Ship;

public enum Fleet {

    KLEINVRACHTSHIP(new Ship(2000, 2000, 0)),
    GROOTCRACHTSHIP(new Ship(6000, 6000, 0)),
    LICHTGEVECHTSHIP(new Ship(3000, 1000, 0)),
    ZWAARGEVECHTSHIP(new Ship(6000, 4000, 0)),
    KRUISER(new Ship(20000, 7000, 2000)),
    SLAGSCHIP(new Ship(45000, 15000, 0)),
    BOMMENWERPER(new Ship(50000, 25000, 15000)),
    VERNIETIGER(new Ship(60000, 50000, 15000)),
    INTERCEPTOR(new Ship(30000, 40000, 15000)),
    STERDESDOODS(new Ship(5000000, 4000000, 1000000)),
    KOLONISATIESCHIP(new Ship(10000, 20000, 10000)),
    RECYCLER(new Ship(10000, 6000, 2000)),
    IPR(new Ship(12500, 2500, 10000));

    private Ship ship;

    Fleet(Ship ship) {
        this.ship = ship;
    }

    private Ship getShip() {
        return ship;
    }

    public static Ship getShip(String name) {
        switch (name) {
            case "kleinVrachtschip":
                return Fleet.KLEINVRACHTSHIP.getShip();
            case "grootVrachtschip":
                return Fleet.GROOTCRACHTSHIP.getShip();
            case "lichtGevechtschip":
                return Fleet.LICHTGEVECHTSHIP.getShip();
            case "zwaarGevechtschip":
                return Fleet.ZWAARGEVECHTSHIP.getShip();
            case "kuiser":
                return Fleet.KRUISER.getShip();
            case "slagschip":
                return Fleet.SLAGSCHIP.getShip();
            case "bommenwerper":
                return Fleet.BOMMENWERPER.getShip();
            case "vernietiger":
                return Fleet.VERNIETIGER.getShip();
            case "interceptor":
                return Fleet.INTERCEPTOR.getShip();
            case "sterDesDoods":
                return Fleet.STERDESDOODS.getShip();
            case "kolonisatieschip":
                return Fleet.KOLONISATIESCHIP.getShip();
            case "recycler":
                return Fleet.RECYCLER.getShip();
            case "ipr":
                return Fleet.IPR.getShip();
            default:
                return null;
        }
    }
}
