package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the pasos database table.
 * 
 */
@Entity
@Table(name="pasos")
@NamedQuery(name="Paso.findAll", query="SELECT p FROM Paso p")
public class Paso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pasosID;

	private String pasoDescripcion;

	private String pasoTitulo;

	//bi-directional many-to-one association to Receta
	@ManyToOne
	@JoinColumn(name="recetaID")
	@JsonBackReference
	private Receta receta;

	//bi-directional many-to-one association to PasoAdicional
	@OneToMany(mappedBy="paso")
	@JsonBackReference
	private List<PasoAdicional> pasosadicionales;

	public Paso() {
	}

	public int getPasosID() {
		return this.pasosID;
	}

	public void setPasosID(int pasosID) {
		this.pasosID = pasosID;
	}

	public String getPasoDescripcion() {
		return this.pasoDescripcion;
	}

	public void setPasoDescripcion(String pasoDescripcion) {
		this.pasoDescripcion = pasoDescripcion;
	}

	public String getPasoTitulo() {
		return this.pasoTitulo;
	}

	public void setPasoTitulo(String pasoTitulo) {
		this.pasoTitulo = pasoTitulo;
	}

	public Receta getReceta() {
		return this.receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

	public List<PasoAdicional> getPasosadicionales() {
		return this.pasosadicionales;
	}

	public void setPasosadicionales(List<PasoAdicional> pasosadicionales) {
		this.pasosadicionales = pasosadicionales;
	}

	public PasoAdicional addPasosadicionale(PasoAdicional pasosadicionale) {
		getPasosadicionales().add(pasosadicionale);
		pasosadicionale.setPaso(this);

		return pasosadicionale;
	}

	public PasoAdicional removePasosadicionale(PasoAdicional pasosadicionale) {
		getPasosadicionales().remove(pasosadicionale);
		pasosadicionale.setPaso(null);

		return pasosadicionale;
	}

}