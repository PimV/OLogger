package org.legopiraat.service;

import org.legopiraat.dao.AttackDao;
import org.legopiraat.entities.Attack;
import org.legopiraat.entities.FleetLoss;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/fleetLoss")
public class FleetResource {

    @Inject
    private LossesCalculator lossCalculator;

    @Inject
    private AttackDao attackDao;

    @POST
    @Path("/calculate")
    @Consumes("application/json")
    @Produces("application/json")
    public Response calculateLosses(String losses) {
        FleetLoss fleetLoss = lossCalculator.calculateLosses(losses);

        return Response.status(Response.Status.OK).entity(fleetLoss).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response addNewFleetLoss(FleetLoss fleetLoss) {
        Attack attack = attackDao.convertFleetLossToAttack(fleetLoss);

        return Response.status(Response.Status.OK).entity(attack).build();
    }
}
