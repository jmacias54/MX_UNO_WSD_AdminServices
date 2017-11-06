package mx.com.amx.unotv.adminservice.model.request;

import java.util.List;

import mx.com.amx.unotv.adminservice.model.IMagazineNota;

public class MagazineRequest {

	String id_magazine;

	List<IMagazineNota> lista;

	public String getId_magazine() {
		return id_magazine;
	}

	public void setId_magazine(String id_magazine) {
		this.id_magazine = id_magazine;
	}

	public List<IMagazineNota> getLista() {
		return lista;
	}

	public void setLista(List<IMagazineNota> lista) {
		this.lista = lista;
	}
	
	
	
	

}
