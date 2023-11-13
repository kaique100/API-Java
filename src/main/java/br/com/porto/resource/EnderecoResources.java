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

import br.com.porto.beans.Endereco;
import br.com.porto.bo.EnderecoBo;

@Path("/endereco")
public class EnderecoResources {

	private EnderecoBo enderecoBo = new EnderecoBo();

	// Selecionar
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Endereco> selecionar() throws ClassNotFoundException, SQLException, ParseException {
		return (ArrayList<Endereco>) enderecoBo.selecionarBO();
	}

	// Inserir
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserir(Endereco endereco, @Context UriInfo uriInfo)
			throws ClassNotFoundException, SQLException {
		enderecoBo.inserirBO(endereco);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(endereco.getIdEndereco()));
		return Response.created(builder.build()).build();
	}

	// Atualizar
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Endereco endereco, @PathParam("id") Long id)
			throws ClassNotFoundException, SQLException {
		enderecoBo.atualizarBO(endereco);
		return Response.ok().build();
	}

	// Deletar
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("id") Long id) throws ClassNotFoundException, SQLException {
		enderecoBo.deletarBO(id);
		return Response.ok().build();
	}

}
