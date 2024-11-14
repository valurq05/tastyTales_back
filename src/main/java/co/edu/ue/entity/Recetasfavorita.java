package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the recetasfavoritas database table.
 * 
 */
@Entity
@Table(name="recetasfavoritas")
@NamedQuery(name="Recetasfavorita.findAll", query="SELECT r FROM Recetasfavorita r")
public class Recetasfavorita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int recFavID;

	private int recFavStatus;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="userID")
	private Usuario usuario;

	//bi-directional many-to-one association to Receta
	@ManyToOne
	@JoinColumn(name="recetaID")
	private Receta receta;

	public Recetasfavorita() {
	}

	public int getRecFavID() {
		return this.recFavID;
	}

	public void setRecFavID(int recFavID) {
		this.recFavID = recFavID;
	}

	public int getRecFavStatus() {
		return this.recFavStatus;
	}

	public void setRecFavStatus(int recFavStatus) {
		this.recFavStatus = recFavStatus;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Receta getReceta() {
		return this.receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

}