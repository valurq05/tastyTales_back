package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the pasosAdicionales database table.
 * 
 */
@Entity
@Table(name="pasosadicionales")
@NamedQuery(name="PasoAdicional.findAll", query="SELECT p FROM PasoAdicional p")
public class PasoAdicional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pasAdicID;

	//bi-directional many-to-one association to Paso
	@ManyToOne
	@JoinColumn(name="pasoID")
	private Paso paso;

	//bi-directional many-to-one association to Adicional
	@ManyToOne
	@JoinColumn(name="adicionalID")
	private Adicional adicional;

	public PasoAdicional() {
	}

	public int getPasAdicID() {
		return this.pasAdicID;
	}

	public void setPasAdicID(int pasAdicID) {
		this.pasAdicID = pasAdicID;
	}

	public Paso getPaso() {
		return this.paso;
	}

	public void setPaso(Paso paso) {
		this.paso = paso;
	}

	public Adicional getAdicional() {
		return this.adicional;
	}

	public void setAdicional(Adicional adicional) {
		this.adicional = adicional;
	}

}