package co.edu.ue.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;


/**
 * The persistent class for the calificacionrecetas database table.
 * 
 */
@Entity
@Table(name="calificacionrecetas")
@NamedQuery(name="CalificacionReceta.findAll", query="SELECT c FROM CalificacionReceta c")
public class CalificacionReceta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int califRecID;

	private int calificacion;

	//bi-directional many-to-one association to Receta
	@ManyToOne
	@JoinColumn(name="recetaID")
	@JsonBackReference
	private Receta receta;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="userID")
	@JsonBackReference
	private Usuario usuario;

	public CalificacionReceta() {
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