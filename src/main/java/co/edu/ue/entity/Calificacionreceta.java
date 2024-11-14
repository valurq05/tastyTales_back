package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the calificacionrecetas database table.
 * 
 */
@Entity
@Table(name="calificacionrecetas")
@NamedQuery(name="Calificacionreceta.findAll", query="SELECT c FROM Calificacionreceta c")
public class Calificacionreceta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int califRecID;

	private int calificacion;

	//bi-directional many-to-one association to Receta
	@ManyToOne
	@JoinColumn(name="recetaID")
	private Receta receta;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="userID")
	private Usuario usuario;

	public Calificacionreceta() {
	}

	public int getCalifRecID() {
		return this.califRecID;
	}

	public void setCalifRecID(int califRecID) {
		this.califRecID = califRecID;
	}

	public int getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public Receta getReceta() {
		return this.receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}