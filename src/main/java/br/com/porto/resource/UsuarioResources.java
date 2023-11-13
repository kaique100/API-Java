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

import br.com.porto.beans.Usuario;
import br.com.porto.beans.Usuario;
import br.com.porto.bo.UsuarioBo;

@Path("/usuario")
public class UsuarioResources {

	private UsuarioBo usuarioBo = new UsuarioBo();

	// Selecionar
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Usuario> selecionar() throws ClassNotFoundException, SQLException, ParseException {
		return (ArrayList<Usuario>) usuarioBo.selecionarBO();
	}

	// Inserir
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserir(Usuario usuario, @Context UriInfo uriInfo)
			throws ClassNotFoundException, SQLException {
		usuarioBo.inserirBO(usuario);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(usuario.getIdUsuario()));
		return Response.created(builder.build()).build();
	}

	// Atualizar
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Usuario usuario, @PathParam("id") Long id)
			throws ClassNotFoundException, SQLException {
		usuarioBo.atualizarBO(usuario);
		return Response.ok().build();
	}

	// Deletar
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("id") Long id) throws ClassNotFoundException, SQLException {
		usuarioBo.deletarBO(id);
		return Response.ok().build();
	}

}
