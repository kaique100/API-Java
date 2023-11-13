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

import br.com.porto.beans.Cliente;
import br.com.porto.bo.ClienteBo;

@Path("/cliente")
public class ClienteResources {

	private ClienteBo clienteBo = new ClienteBo();

	// Selecionar
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public ArrayList<Cliente> selecionar() throws ClassNotFoundException, SQLException, ParseException {
			return (ArrayList<Cliente>) clienteBo.selecionarBO();
		}

		// Inserir
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response inserir(Cliente cliente, @Context UriInfo uriInfo)
				throws ClassNotFoundException, SQLException {
			clienteBo.inserirBO(cliente);
			UriBuilder builder = uriInfo.getAbsolutePathBuilder();
			builder.path(Long.toString(cliente.getIdCliente()));
			return Response.created(builder.build()).build();
		}

		// Atualizar
		@PUT
		@Path("/{id}")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response atualizar(Cliente cliente, @PathParam("id") Long id)
				throws ClassNotFoundException, SQLException {
			clienteBo.atualizarBO(cliente);
			return Response.ok().build();
		}

		// Deletar
		@DELETE
		@Path("/{id}")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response deletar(@PathParam("id") Long id) throws ClassNotFoundException, SQLException {
			clienteBo.deletarBO(id);
			return Response.ok().build();
		}
	
}
