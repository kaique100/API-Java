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

import br.com.porto.beans.CategoriaTarifaria;
import br.com.porto.bo.CategoriaTarifariaBo;

@Path("/categoriaTarifaria")
public class CategoriaTarifariaResources {

	private CategoriaTarifariaBo categoriaTarifariaBo = new CategoriaTarifariaBo();

	// Selecionar
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<CategoriaTarifaria> selecionar() throws ClassNotFoundException, SQLException, ParseException {
		return (ArrayList<CategoriaTarifaria>) categoriaTarifariaBo.selecionarBO();
	}

	// Inserir
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserir(CategoriaTarifaria categoriaTarifaria, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		categoriaTarifariaBo.inserirBO(categoriaTarifaria);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(categoriaTarifaria.getIdCategoriaTarifaria()));
		return Response.created(builder.build()).build();
	}

	// Atualizar
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(CategoriaTarifaria categoriaTarifaria, @PathParam("id") Long id) throws ClassNotFoundException, SQLException {
		categoriaTarifariaBo.atualizarBO(categoriaTarifaria);
		return Response.ok().build();
	}

	// Deletar
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("id") Long id) throws ClassNotFoundException, SQLException {
		categoriaTarifariaBo.deletarBO(id);
		return Response.ok().build();
	}

}
