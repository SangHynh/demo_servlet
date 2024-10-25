package vn.edu.iuh.fit.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.models.PhongBanModel;
import vn.edu.iuh.fit.dtos.PhongBan;

import java.util.List;

@Path("/api/phongban")
public class PhongBanRestController {

    @Inject
    private PhongBanModel phongBanModel;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPhongBan(PhongBan phongBan) {
        try {
            phongBanModel.addPhongBan(phongBan.getTenPhongBan());
            return Response.status(Response.Status.CREATED).entity(phongBan).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error adding phong ban: " + e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listPhongBan() {
        List<PhongBan> phongBanList = phongBanModel.listPhongBan();
        return Response.ok(phongBanList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPhongBan(@PathParam("id") long id) {
        PhongBan phongBan = phongBanModel.findPhongBan(id);
        if (phongBan != null) {
            return Response.ok(phongBan).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("PhongBan not found for ID: " + id).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePhongBan(@PathParam("id") long id, PhongBan phongBan) {
        try {
            phongBanModel.updatePhongBan(id, phongBan.getTenPhongBan());
            return Response.ok(phongBan).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error updating phong ban: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePhongBan(@PathParam("id") long id) {
        try {
            phongBanModel.deletePhongBan(id);
            return Response.noContent().build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error deleting phong ban: " + e.getMessage()).build();
        }
    }
}
