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

import br.com.porto.beans.TipoGuincho;
import br.com.porto.beans.TipoGuincho;
import br.com.porto.bo.TipoGuinchoBo;

@Path("/tipoGuincho")
public class TipoGuinchoResourcer {

	private TipoGuinchoBo tipoGuinchoBo = new TipoGuinchoBo();

	// Selecionar
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<TipoGuincho> selecionar() throws ClassNotFoundException, SQLException, ParseException {
		return (ArrayList<TipoGuincho>) tipoGuinchoBo.selecionarBO();
	}

	// Inserir
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserir(TipoGuincho tipoGuincho, @Context UriInfo uriInfo)
			throws ClassNotFoundException, SQLException {
		tipoGuinchoBo.inserirBO(tipoGuincho);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(tipoGuincho.getIdTipoGuincho()));
		return Response.created(builder.build()).build();
	}

	// Atualizar
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(TipoGuincho tipoGuincho, @PathParam("id") Long id)
			throws ClassNotFoundException, SQLException {
		tipoGuinchoBo.atualizarBO(tipoGuincho);
		return Response.ok().build();
	}

	// Deletar
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("id") Long id) throws ClassNotFoundException, SQLException {
		tipoGuinchoBo.deletarBO(id);
		return Response.ok().build();
	}

}
