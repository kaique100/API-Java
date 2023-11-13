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

import br.com.porto.beans.Veiculo;
import br.com.porto.bo.VeiculoBo;

@Path("/veiculo")
public class VeiculoResources {

	private VeiculoBo veiculoBo = new VeiculoBo();

	// Selecionar
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Veiculo> selecionar() throws ClassNotFoundException, SQLException, ParseException {
		return (ArrayList<Veiculo>) veiculoBo.selecionarBO();
	}

	// Inserir
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserir(Veiculo veiculo, @Context UriInfo uriInfo)
			throws ClassNotFoundException, SQLException {
		veiculoBo.inserirBO(veiculo);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(veiculo.getIdVeiculo()));
		return Response.created(builder.build()).build();
	}

	// Atualizar
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Veiculo veiculo, @PathParam("id") Long id)
			throws ClassNotFoundException, SQLException {
		veiculoBo.atualizarBO(veiculo);
		return Response.ok().build();
	}

	// Deletar
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("id") Long id) throws ClassNotFoundException, SQLException {
		veiculoBo.deletarBO(id);
		return Response.ok().build();
	}
	
}
