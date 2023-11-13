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

import br.com.porto.beans.GuinchoPrestadorServico;
import br.com.porto.bo.GuinchoPrestadorServicoBo;

@Path("/guinchoPrestadorServico")
public class GuinchoPrestadorServicoResources {

	private GuinchoPrestadorServicoBo guinchoPrestadorServicoBo = new GuinchoPrestadorServicoBo();

	// Selecionar
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<GuinchoPrestadorServico> selecionar() throws ClassNotFoundException, SQLException, ParseException {
		return (ArrayList<GuinchoPrestadorServico>) guinchoPrestadorServicoBo.selecionarBO();
	}

	// Inserir
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserir(GuinchoPrestadorServico guinchoPrestadorServico, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		guinchoPrestadorServicoBo.inserirBO(guinchoPrestadorServico);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(guinchoPrestadorServico.getIdGuinchoPrestadorServico()));
		return Response.created(builder.build()).build();
	}

	// Atualizar
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(GuinchoPrestadorServico guinchoPrestadorServico, @PathParam("id") Long id) throws ClassNotFoundException, SQLException {
		guinchoPrestadorServicoBo.atualizarBO(guinchoPrestadorServico);
		return Response.ok().build();
	}

	// Deletar
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("id") Long id) throws ClassNotFoundException, SQLException {
		guinchoPrestadorServicoBo.deletarBO(id);
		return Response.ok().build();
	}

}
