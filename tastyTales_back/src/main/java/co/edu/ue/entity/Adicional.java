package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the adicionales database table.
 * 
 */
@Entity
@Table(name="adicionales")
@NamedQuery(name="Adicional.findAll", query="SELECT a FROM Adicional a")
public class Adicional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adicionalID;

	private String adDescripcion;

	//bi-directional many-to-one association to PasoAdicional
	@OneToMany(mappedBy="adicional")
	@JsonBackReference
	private List<PasoAdicional> pasoAdicional;

	public Adicional() {
	}

	public int getAdicionalID() {
		return this.adicionalID;
	}

	public void setAdicionalID(int adicionalID) {
		this.adicionalID = adicionalID;
	}

	public String getAdDescripcion() {
		return this.adDescripcion;
	}

	public void setAdDescripcion(String adDescripcion) {
		this.adDescripcion = adDescripcion;
	}

	public List<PasoAdicional> getpasoAdicional() {
		return this.pasoAdicional;
	}

	public void setpasoAdicional(List<PasoAdicional> pasoAdicional) {
		this.pasoAdicional = pasoAdicional;
	}

	public PasoAdicional addpasoAdicional(PasoAdicional pasoAdicional) {
		getpasoAdicional().add(pasoAdicional);
		pasoAdicional.setAdicionale(this);

		return pasoAdicional;
	}

	public PasoAdicional removepasoAdicional(PasoAdicional pasoAdicional) {
		getpasoAdicional().remove(pasoAdicional);
		pasoAdicional.setAdicionale(null);

		return pasoAdicional;
	}

}