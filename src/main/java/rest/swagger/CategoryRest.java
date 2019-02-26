package rest.swagger;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import model.Category;

import javax.persistence.OptimisticLockException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/categorias")
@Api("Category")
public class CategoryRest {


    @POST
    @Consumes({"application/json", "application/xml"})
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation("Create a category")
    public Response create(Category category) {
        // Grava na Base ..
        return Response.ok("Categoria Criada").build();
    }


    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    @ApiOperation("Deletes a category by id")
    public Response deleteById(@PathParam("id") Long id) {

        // remoção da entidade...

        // Caso a entidade a ser excluída não exista, a resposta abaixo pode ser retornada.
        Response.status(Response.Status.NOT_FOUND).build();

        return Response.noContent().build();
    }

    @GET
    @Produces("application/json")
    @ApiOperation("Lists all the categories")
    public List<Category> listAll(@QueryParam("start") Integer startPosition, @QueryParam("max") Integer maxResult) {

        // Consulta
        final List<Category> resultado = new ArrayList<>();

        return resultado;
    }

    @PUT
    @Path("/{id:[0-9][0-9]*}")
    @Consumes("application/json")
    @ApiOperation("Updates a category")
    public Response update(Category category) {
        try {
            // merge of category
        } catch (OptimisticLockException e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getEntity()).build();
        }
        return Response.ok().build();
    }

}
