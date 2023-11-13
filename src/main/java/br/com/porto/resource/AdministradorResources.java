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

import br.com.porto.beans.Administrador;
import br.com.porto.beans.TipoUsuario;
import br.com.porto.bo.AdministradorBo;

@Path("/administrador")
public class AdministradorResources {

	private AdministradorBo administradorBo = new AdministradorBo();

	// Selecionar
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Administrador> selecionar() throws ClassNotFoundException, SQLException {
		return (ArrayList<Administrador>) administradorBo.selecionarBO();
	}

	// Inserir
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserir(Administrador administrador, @Context UriInfo uriInfo)
			throws ClassNotFoundException, SQLException {
		administradorBo.inserirBO(administrador);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(administrador.getIdAdministrador()));
		return Response.created(builder.build()).build();
	}

	// Atualizar
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Administrador administrador, @PathParam("id") Long id)
			throws ClassNotFoundException, SQLException {
		administradorBo.atualizarBO(administrador);
		return Response.ok().build();
	}

	// Deletar
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("id") Long id) throws ClassNotFoundException, SQLException {
		administradorBo.deletarBO(id);
		return Response.ok().build();
	}

}
