package br.com.porto.resource;

import java.sql.SQLException;
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

import br.com.porto.beans.TipoUsuario;
import br.com.porto.bo.TipoUsuarioBo;

@Path("/tipoUsuario")
public class TipoUsuarioResources {
	
	TipoUsuarioBo tipoUsuarioBo = new TipoUsuarioBo();
	
	// Selecionar
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<TipoUsuario> selecionar() throws ClassNotFoundException, SQLException{
		return (ArrayList<TipoUsuario>) tipoUsuarioBo.selecionarBO();
	}
	
	
	// Inserir
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserir(TipoUsuario tipoUsuario, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		tipoUsuarioBo.inserirBO(tipoUsuario);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(tipoUsuario.getIdTipoUsuario()));
		return Response.created(builder.build()).build();
	}
	
	
	// Atualizar
	@PUT
	@Path("/{idTipoUsuario}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(TipoUsuario tipoUsuario, @PathParam("idTipoUsuario") int idTipoUsuario) throws ClassNotFoundException, SQLException {
		tipoUsuarioBo.atualizarBO(tipoUsuario);
		return Response.ok().build();
	}
	
	
	// Deletar
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		tipoUsuarioBo.deletarBO(id);
		return Response.ok().build();
	}
	
}
