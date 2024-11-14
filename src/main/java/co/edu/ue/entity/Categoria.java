package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the categorias database table.
 * 
 */
@Entity
@Table(name="categorias")
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoriaID;

	private String categoriaNombre;

	private int categoriaStatus;

	//bi-directional many-to-one association to Recetascategoria
	@OneToMany(mappedBy="categoria")
	private List<Recetascategoria> recetascategorias;

	public Categoria() {
	}

	public int getCategoriaID() {
		return this.categoriaID;
	}

	public void setCategoriaID(int categoriaID) {
		this.categoriaID = categoriaID;
	}

	public String getCategoriaNombre() {
		return this.categoriaNombre;
	}

	public void setCategoriaNombre(String categoriaNombre) {
		this.categoriaNombre = categoriaNombre;
	}

	public int getCategoriaStatus() {
		return this.categoriaStatus;
	}

	public void setCategoriaStatus(int categoriaStatus) {
		this.categoriaStatus = categoriaStatus;
	}

	public List<Recetascategoria> getRecetascategorias() {
		return this.recetascategorias;
	}

	public void setRecetascategorias(List<Recetascategoria> recetascategorias) {
		this.recetascategorias = recetascategorias;
	}

	public Recetascategoria addRecetascategoria(Recetascategoria recetascategoria) {
		getRecetascategorias().add(recetascategoria);
		recetascategoria.setCategoria(this);

		return recetascategoria;
	}

	public Recetascategoria removeRecetascategoria(Recetascategoria recetascategoria) {
		getRecetascategorias().remove(recetascategoria);
		recetascategoria.setCategoria(null);

		return recetascategoria;
	}

}