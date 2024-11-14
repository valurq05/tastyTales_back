package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the pasosadicionales database table.
 * 
 */
@Entity
@Table(name="pasosadicionales")
@NamedQuery(name="Pasosadicionale.findAll", query="SELECT p FROM Pasosadicionale p")
public class Pasosadicionale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pasAdicID;

	//bi-directional many-to-one association to Paso
	@ManyToOne
	@JoinColumn(name="pasoID")
	private Paso paso;

	//bi-directional many-to-one association to Adicionale
	@ManyToOne
	@JoinColumn(name="adicionalID")
	private Adicionale adicionale;

	public Pasosadicionale() {
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

	public Adicionale getAdicionale() {
		return this.adicionale;
	}

	public void setAdicionale(Adicionale adicionale) {
		this.adicionale = adicionale;
	}

}