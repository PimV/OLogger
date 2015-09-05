package org.legopiraat.service;

import org.legopiraat.dao.PlayerDao;
import org.legopiraat.entities.Player;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("player")
public class PlayerResource {

    @Inject
    private PlayerDao playerDao;

    @POST
    @Consumes("application/json")
    public Response login(Player player) {
        if(playerDao.getPlayerByName(player.getName()) == null) {
            playerDao.addNewPlayer(player);
        }

        return Response.status(Response.Status.OK).build();
    }
}
