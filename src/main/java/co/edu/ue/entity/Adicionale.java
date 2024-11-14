package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the adicionales database table.
 * 
 */
@Entity
@Table(name="adicionales")
@NamedQuery(name="Adicionale.findAll", query="SELECT a FROM Adicionale a")
public class Adicionale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adicionalID;

	private String adDescripcion;

	//bi-directional many-to-one association to Pasosadicionale
	@OneToMany(mappedBy="adicionale")
	private List<Pasosadicionale> pasosadicionales;

	public Adicionale() {
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

	public List<Pasosadicionale> getPasosadicionales() {
		return this.pasosadicionales;
	}

	public void setPasosadicionales(List<Pasosadicionale> pasosadicionales) {
		this.pasosadicionales = pasosadicionales;
	}

	public Pasosadicionale addPasosadicionale(Pasosadicionale pasosadicionale) {
		getPasosadicionales().add(pasosadicionale);
		pasosadicionale.setAdicionale(this);

		return pasosadicionale;
	}

	public Pasosadicionale removePasosadicionale(Pasosadicionale pasosadicionale) {
		getPasosadicionales().remove(pasosadicionale);
		pasosadicionale.setAdicionale(null);

		return pasosadicionale;
	}

}