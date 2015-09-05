package org.legopiraat.service;

import org.legopiraat.dao.AttackDao;
import org.legopiraat.entities.Attack;
import org.legopiraat.entities.RequestAttack;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@RequestScoped
@Path("/attack")
public class AttackResource {

    @Inject
    private AttackDao attackDao;

    @POST
    @Consumes("application/json")
    public Response newAttack(RequestAttack attack) {
        attackDao.newAttack(attack);

        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("{playerName}/{date}")
    @Produces("application/json")
    public Response getAllAttacksByPlayerNameAndDate(@PathParam("playerName") String playerName, @PathParam("date") String attackDate) {
        List<Attack> allAttacks = attackDao.getAllAttacksByPlayerNameAndDate(attackDate, playerName);

        return Response
                .status(Response.Status.OK)
                .entity(new GenericEntity<List<Attack>>(allAttacks) {
                })
                .build();
    }
}
