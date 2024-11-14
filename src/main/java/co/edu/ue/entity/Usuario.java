package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userID;

	private String userDoc;

	private String userNombre;

	private String userPassword;

	//bi-directional many-to-one association to Calificacionreceta
	@OneToMany(mappedBy="usuario")
	private List<Calificacionreceta> calificacionrecetas;

	//bi-directional many-to-one association to Recetasfavorita
	@OneToMany(mappedBy="usuario")
	private List<Recetasfavorita> recetasfavoritas;

	public Usuario() {
	}

	public int getUserID() {
		return this.userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserDoc() {
		return this.userDoc;
	}

	public void setUserDoc(String userDoc) {
		this.userDoc = userDoc;
	}

	public String getUserNombre() {
		return this.userNombre;
	}

	public void setUserNombre(String userNombre) {
		this.userNombre = userNombre;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public List<Calificacionreceta> getCalificacionrecetas() {
		return this.calificacionrecetas;
	}

	public void setCalificacionrecetas(List<Calificacionreceta> calificacionrecetas) {
		this.calificacionrecetas = calificacionrecetas;
	}

	public Calificacionreceta addCalificacionreceta(Calificacionreceta calificacionreceta) {
		getCalificacionrecetas().add(calificacionreceta);
		calificacionreceta.setUsuario(this);

		return calificacionreceta;
	}

	public Calificacionreceta removeCalificacionreceta(Calificacionreceta calificacionreceta) {
		getCalificacionrecetas().remove(calificacionreceta);
		calificacionreceta.setUsuario(null);

		return calificacionreceta;
	}

	public List<Recetasfavorita> getRecetasfavoritas() {
		return this.recetasfavoritas;
	}

	public void setRecetasfavoritas(List<Recetasfavorita> recetasfavoritas) {
		this.recetasfavoritas = recetasfavoritas;
	}

	public Recetasfavorita addRecetasfavorita(Recetasfavorita recetasfavorita) {
		getRecetasfavoritas().add(recetasfavorita);
		recetasfavorita.setUsuario(this);

		return recetasfavorita;
	}

	public Recetasfavorita removeRecetasfavorita(Recetasfavorita recetasfavorita) {
		getRecetasfavoritas().remove(recetasfavorita);
		recetasfavorita.setUsuario(null);

		return recetasfavorita;
	}

}