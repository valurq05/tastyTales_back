package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;


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

	//bi-directional many-to-one association to CalificacionReceta
	@OneToMany(mappedBy="receta")
	@JsonManagedReference
	private List<CalificacionReceta> calificacionrecetas;

	//bi-directional many-to-one association to Paso
	@OneToMany(mappedBy="receta")
	@JsonManagedReference
	private List<Paso> pasos;

	//bi-directional many-to-one association to RecetaCategoria
	@OneToMany(mappedBy="receta")
	@JsonManagedReference
	private List<RecetaCategoria> recetascategorias;

	//bi-directional many-to-one association to RecetaFavorita
	@OneToMany(mappedBy="receta")
	@JsonManagedReference
	private List<RecetaFavorita> recetasfavoritas;

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

	public List<CalificacionReceta> getCalificacionrecetas() {
		return this.calificacionrecetas;
	}

	public void setCalificacionrecetas(List<CalificacionReceta> calificacionrecetas) {
		this.calificacionrecetas = calificacionrecetas;
	}

	public CalificacionReceta addCalificacionreceta(CalificacionReceta calificacionreceta) {
		getCalificacionrecetas().add(calificacionreceta);
		calificacionreceta.setReceta(this);

		return calificacionreceta;
	}

	public CalificacionReceta removeCalificacionreceta(CalificacionReceta calificacionreceta) {
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

	public List<RecetaCategoria> getRecetascategorias() {
		return this.recetascategorias;
	}

	public void setRecetascategorias(List<RecetaCategoria> recetascategorias) {
		this.recetascategorias = recetascategorias;
	}

	public RecetaCategoria addRecetascategoria(RecetaCategoria recetascategoria) {
		getRecetascategorias().add(recetascategoria);
		recetascategoria.setReceta(this);

		return recetascategoria;
	}

	public RecetaCategoria removeRecetascategoria(RecetaCategoria recetascategoria) {
		getRecetascategorias().remove(recetascategoria);
		recetascategoria.setReceta(null);

		return recetascategoria;
	}

	public List<RecetaFavorita> getRecetasfavoritas() {
		return this.recetasfavoritas;
	}

	public void setRecetasfavoritas(List<RecetaFavorita> recetasfavoritas) {
		this.recetasfavoritas = recetasfavoritas;
	}

	public RecetaFavorita addRecetasfavorita(RecetaFavorita recetasfavorita) {
		getRecetasfavoritas().add(recetasfavorita);
		recetasfavorita.setReceta(this);

		return recetasfavorita;
	}

	public RecetaFavorita removeRecetasfavorita(RecetaFavorita recetasfavorita) {
		getRecetasfavoritas().remove(recetasfavorita);
		recetasfavorita.setReceta(null);

		return recetasfavorita;
	}

}