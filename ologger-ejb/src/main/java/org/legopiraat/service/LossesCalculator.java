package org.legopiraat.service;

import org.legopiraat.entities.FleetLoss;
import org.legopiraat.entities.Ship;
import org.legopiraat.entities.enums.Fleet;

import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.Map;

@Stateless
public class LossesCalculator {

    public FleetLoss calculateLosses(String losses) {
        String[] parsedLosses = parseLosses(losses);

        HashMap<Ship, Integer> allShipLosses = createLossMap(parsedLosses);
        FleetLoss fleetLoss = initNewFleetLoss();

        for (Map.Entry<Ship, Integer> entry : allShipLosses.entrySet()) {
            calculateShipLosses(entry.getKey(), entry.getValue(), fleetLoss);
        }

        return fleetLoss;
    }

    private HashMap<Ship, Integer> createLossMap(String[] losses) {
        HashMap<Ship, Integer> allLosses = new HashMap<>();

        for (int i = 1; i < losses.length; i = i + 4) {
            String shipName = losses[i];
            int startAmount = new Integer(losses[i + 1]);
            int endAmount = new Integer(losses[i + 3]);

            if (endAmount < startAmount && startAmount != endAmount) {
                allLosses.put(Fleet.getShip(shipName), startAmount - endAmount);
            }
        }

        return allLosses;
    }

    private FleetLoss calculateShipLosses(Ship ship, int amount, FleetLoss fleetLoss) {
        fleetLoss.setMetal(fleetLoss.getMetal() + (ship.getMetal() * amount));
        fleetLoss.setCrystal(fleetLoss.getCrystal() + (ship.getCrystal() * amount));
        fleetLoss.setDeuterium(fleetLoss.getDeuterium() + (ship.getDeuterium() * amount));

        return fleetLoss;
    }

    private String[] parseLosses(String losses) {
        String partiallyParsed = losses.replaceAll("[{:},]", "");
        String fullParsed = partiallyParsed.replaceAll("[\"]", " ");

        return fullParsed.split(" ");
    }

    private FleetLoss initNewFleetLoss() {
        FleetLoss fleetLoss = new FleetLoss();
        fleetLoss.setMetal(0L);
        fleetLoss.setCrystal(0L);
        fleetLoss.setDeuterium(0L);

        return fleetLoss;
    }
}
