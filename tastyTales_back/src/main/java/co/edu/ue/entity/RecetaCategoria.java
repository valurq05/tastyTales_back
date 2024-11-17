package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the recetascategorias database table.
 * 
 */
@Entity
@Table(name="recetascategorias")
@NamedQuery(name="RecetaCategoria.findAll", query="SELECT r FROM RecetaCategoria r")
public class RecetaCategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int resCatID;

	//bi-directional many-to-one association to Receta
	@ManyToOne
	@JoinColumn(name="recetaID")
	private Receta receta;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="categoriaID")
	private Categoria categoria;

	public RecetaCategoria() {
	}

	public int getResCatID() {
		return this.resCatID;
	}

	public void setResCatID(int resCatID) {
		this.resCatID = resCatID;
	}

	public Receta getReceta() {
		return this.receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}