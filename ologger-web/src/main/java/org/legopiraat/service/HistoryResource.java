package org.legopiraat.service;

import org.legopiraat.dao.HistoryDao;
import org.legopiraat.dao.PlayerDao;
import org.legopiraat.entities.Attack;
import org.legopiraat.entities.History;
import org.legopiraat.entities.Player;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/history")
public class HistoryResource {

    @Inject
    private HistoryDao historyDao;

    @Inject
    private PlayerDao playerDao;

    @GET
    @Path("{playerName}")
    public Response getHistoryFromPlayer(@PathParam("playerName") String playerName) {
        List<History> history = historyDao.getHistoryFromPlayer(playerName);

        return Response.status(Response.Status.OK)
                .entity(new GenericEntity<List<History>>(history) {
                })
                .build();
    }


}
