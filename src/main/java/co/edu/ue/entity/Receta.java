package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the recetas database table.
 * 
 */
@Entity
@Table(name="recetas")
@NamedQuery(name="Receta.findAll", query="SELECT r FROM Receta r")
public class Receta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int recetaID;

	private String recetaDescripcion;

	private int recetaStatus;

	private String recetaTitulo;

	//bi-directional many-to-one association to Calificacionreceta
	@OneToMany(mappedBy="receta")
	private List<Calificacionreceta> calificacionrecetas;

	//bi-directional many-to-one association to Paso
	@OneToMany(mappedBy="receta")
	private List<Paso> pasos;

	//bi-directional many-to-one association to Recetascategoria
	@OneToMany(mappedBy="receta")
	private List<Recetascategoria> recetascategorias;

	//bi-directional many-to-one association to Recetasfavorita
	@OneToMany(mappedBy="receta")
	private List<Recetasfavorita> recetasfavoritas;

	public Receta() {
	}

	public int getRecetaID() {
		return this.recetaID;
	}

	public void setRecetaID(int recetaID) {
		this.recetaID = recetaID;
	}

	public String getRecetaDescripcion() {
		return this.recetaDescripcion;
	}

	public void setRecetaDescripcion(String recetaDescripcion) {
		this.recetaDescripcion = recetaDescripcion;
	}

	public int getRecetaStatus() {
		return this.recetaStatus;
	}

	public void setRecetaStatus(int recetaStatus) {
		this.recetaStatus = recetaStatus;
	}

	public String getRecetaTitulo() {
		return this.recetaTitulo;
	}

	public void setRecetaTitulo(String recetaTitulo) {
		this.recetaTitulo = recetaTitulo;
	}

	public List<Calificacionreceta> getCalificacionrecetas() {
		return this.calificacionrecetas;
	}

	public void setCalificacionrecetas(List<Calificacionreceta> calificacionrecetas) {
		this.calificacionrecetas = calificacionrecetas;
	}

	public Calificacionreceta addCalificacionreceta(Calificacionreceta calificacionreceta) {
		getCalificacionrecetas().add(calificacionreceta);
		calificacionreceta.setReceta(this);

		return calificacionreceta;
	}

	public Calificacionreceta removeCalificacionreceta(Calificacionreceta calificacionreceta) {
		getCalificacionrecetas().remove(calificacionreceta);
		calificacionreceta.setReceta(null);

		return calificacionreceta;
	}

	public List<Paso> getPasos() {
		return this.pasos;
	}

	public void setPasos(List<Paso> pasos) {
		this.pasos = pasos;
	}

	public Paso addPaso(Paso paso) {
		getPasos().add(paso);
		paso.setReceta(this);

		return paso;
	}

	public Paso removePaso(Paso paso) {
		getPasos().remove(paso);
		paso.setReceta(null);

		return paso;
	}

	public List<Recetascategoria> getRecetascategorias() {
		return this.recetascategorias;
	}

	public void setRecetascategorias(List<Recetascategoria> recetascategorias) {
		this.recetascategorias = recetascategorias;
	}

	public Recetascategoria addRecetascategoria(Recetascategoria recetascategoria) {
		getRecetascategorias().add(recetascategoria);
		recetascategoria.setReceta(this);

		return recetascategoria;
	}

	public Recetascategoria removeRecetascategoria(Recetascategoria recetascategoria) {
		getRecetascategorias().remove(recetascategoria);
		recetascategoria.setReceta(null);

		return recetascategoria;
	}

	public List<Recetasfavorita> getRecetasfavoritas() {
		return this.recetasfavoritas;
	}

	public void setRecetasfavoritas(List<Recetasfavorita> recetasfavoritas) {
		this.recetasfavoritas = recetasfavoritas;
	}

	public Recetasfavorita addRecetasfavorita(Recetasfavorita recetasfavorita) {
		getRecetasfavoritas().add(recetasfavorita);
		recetasfavorita.setReceta(this);

		return recetasfavorita;
	}

	public Recetasfavorita removeRecetasfavorita(Recetasfavorita recetasfavorita) {
		getRecetasfavoritas().remove(recetasfavorita);
		recetasfavorita.setReceta(null);

		return recetasfavorita;
	}

}