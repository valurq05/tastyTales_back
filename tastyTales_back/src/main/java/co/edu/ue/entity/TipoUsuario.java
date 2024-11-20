package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the tipo_usuarios database table.
 * 
 */
@Entity
@Table(name="tipo_usuarios")
@NamedQuery(name="TipoUsuario.findAll", query="SELECT t FROM TipoUsuario t")
public class TipoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tip_id")
	private int tipId;

	@Column(name="tip_user")
	private String tipUser;

	/*bi-directional many-to-one association to Dato
	@OneToMany(mappedBy="tipoUsuario")
	private List<Dato> datos;
	 */
	public TipoUsuario() {
	}

	public int getTipId() {
		return this.tipId;
	}

	public void setTipId(int tipId) {
		this.tipId = tipId;
	}

	public String getTipUser() {
		return this.tipUser;
	}

	public void setTipUser(String tipUser) {
		this.tipUser = tipUser;
	}
	
	/*
	public List<Dato> getDatos() {
		return this.datos;
	}

	public void setDatos(List<Dato> datos) {
		this.datos = datos;
	}

	public Dato addDato(Dato dato) {
		getDatos().add(dato);
		dato.setTipoUsuario(this);

		return dato;
	}

	public Dato removeDato(Dato dato) {
		getDatos().remove(dato);
		dato.setTipoUsuario(null);

		return dato;
	}
	 */
}