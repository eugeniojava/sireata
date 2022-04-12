package br.edu.utfpr.dv.sireata.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.edu.utfpr.dv.sireata.bo.DepartamentoBO;
import br.edu.utfpr.dv.sireata.model.Departamento;

@Path("/departamento")
public class DepartamentoService {
	
	@GET
	@Path("/listar/{campus}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar(@PathParam("campus") int idCampus) {
		try {
			List<Departamento> list = new DepartamentoBO().listarPorCampus(idCampus, true);
			List<DepartamentoJson> ret = new ArrayList<DepartamentoJson>();
			
			for(Departamento d : list) {
				DepartamentoJson departamentoJson = buildDepartamentoJson(d);
				ret.add(departamentoJson);
			}
			
			return Response.ok(ret).build();
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);

			return Response.status(Status.INTERNAL_SERVER_ERROR.ordinal(), e.getMessage()).build();
		}
	}

    private DepartamentoJson buildDepartamentoJson(Departamento departamento) {
    	DepartamentoJson departamentoJson = new DepartamentoJson();
    	departamentoJson.setCodigo(departamento.getIdDepartamento());
    	departamentoJson.setNome(departamento.getNome());
    	return departamentoJson;
    }
	
	public class DepartamentoJson {
		
		private int codigo;
		private String nome;
		
		public DepartamentoJson() {
			this.setCodigo(0);
			this.setNome("");
		}
		
		public int getCodigo() {
			return codigo;
		}
		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		
	}

}
