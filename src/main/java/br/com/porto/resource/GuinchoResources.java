package br.com.porto.resource;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.porto.beans.Guincho;
import br.com.porto.bo.GuinchoBo;

@Path("/guincho")
public class GuinchoResources {

	private GuinchoBo guinchoBo = new GuinchoBo();

	// Selecionar
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Guincho> selecionar() throws ClassNotFoundException, SQLException, ParseException {
		return (ArrayList<Guincho>) guinchoBo.selecionarBO();
	}

	// Inserir
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserir(Guincho guincho, @Context UriInfo uriInfo)
			throws ClassNotFoundException, SQLException {
		guinchoBo.inserirBO(guincho);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(guincho.getIdGuincho()));
		return Response.created(builder.build()).build();
	}

	// Atualizar
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Guincho guincho, @PathParam("id") Long id)
			throws ClassNotFoundException, SQLException {
		guinchoBo.atualizarBO(guincho);
		return Response.ok().build();
	}

	// Deletar
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("id") Long id) throws ClassNotFoundException, SQLException {
		guinchoBo.deletarBO(id);
		return Response.ok().build();
	}

}
