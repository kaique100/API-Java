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

import br.com.porto.beans.PrestadorServico;
import br.com.porto.beans.PrestadorServico;
import br.com.porto.bo.PrestadorServicoBo;

@Path("/prestadorServico")
public class PrestadorServicoResources {

	private PrestadorServicoBo prestadorServicoBo = new PrestadorServicoBo();

	// Selecionar
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<PrestadorServico> selecionar() throws ClassNotFoundException, SQLException, ParseException {
		return (ArrayList<PrestadorServico>) prestadorServicoBo.selecionarBO();
	}

	// Inserir
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserir(PrestadorServico prestadorServico, @Context UriInfo uriInfo)
			throws ClassNotFoundException, SQLException {
		prestadorServicoBo.inserirBO(prestadorServico);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(prestadorServico.getIdPrestadorServico()));
		return Response.created(builder.build()).build();
	}

	// Atualizar
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(PrestadorServico prestadorServico, @PathParam("id") Long id)
			throws ClassNotFoundException, SQLException {
		prestadorServicoBo.atualizarBO(prestadorServico);
		return Response.ok().build();
	}

	// Deletar
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("id") Long id) throws ClassNotFoundException, SQLException {
		prestadorServicoBo.deletarBO(id);
		return Response.ok().build();
	}

}
