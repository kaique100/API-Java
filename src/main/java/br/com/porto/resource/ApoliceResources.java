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

import br.com.porto.beans.Apolice;
import br.com.porto.bo.ApoliceBo;

@Path("/apolice")
public class ApoliceResources {

	private ApoliceBo apoliceBo = new ApoliceBo();

	// Selecionar
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Apolice> selecionar() throws ClassNotFoundException, SQLException, ParseException {
		return (ArrayList<Apolice>) apoliceBo.selecionarBO();
	}

	// Inserir
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserir(Apolice apolice, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		apoliceBo.inserirBO(apolice);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(apolice.getIdApolice()));
		return Response.created(builder.build()).build();
	}

	// Atualizar
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Apolice apolice, @PathParam("id") Long id) throws ClassNotFoundException, SQLException {
		apoliceBo.atualizarBO(apolice);
		return Response.ok().build();
	}

	// Deletar
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("id") Long id) throws ClassNotFoundException, SQLException {
		apoliceBo.deletarBO(id);
		return Response.ok().build();
	}

}
