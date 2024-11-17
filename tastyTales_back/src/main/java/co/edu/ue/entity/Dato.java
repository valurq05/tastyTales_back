package co.edu.ue.entity;

import java.io.Serializable;

import jakarta.persistence.*;


/**
 * The persistent class for the datos database table.
 * 
 */
@Entity
@Table(name="datos")
@NamedQuery(name="Dato.findAll", query="SELECT d FROM Dato d")
public class Dato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dat_id")
	private int datId;

	@Column(name="dat_document")
	private String datDocument;

	@Column(name="dat_email")
	private String datEmail;
	
	@Column(name="dat_lastNames")
	private String datLastNames;

	@Column(name="dat_names")
	private String datNames;

	@Column(name="dat_password")
	private String datPassword;

	//bi-directional many-to-one association to TipoUsuario
	@ManyToOne
	@JoinColumn(name="tip_id")
	/*
	 * Quita el efecto de cascada al momento de mostrar los datos JSON:
	 * @JsonBackReference
	 * 
	 * Pero NO saldran los datos de las tablas las cuales esten anidadas con FK
	 * */
//	private TipoUsuario tipoUsuario;
//
//	public Dato() {
//	}
//
//	public int getDatId() {
//		return this.datId;
//	}

	public void setDatId(int datId) {
		this.datId = datId;
	}

	public String getDatDocument() {
		return this.datDocument;
	}

	public void setDatDocument(String datDocument) {
		this.datDocument = datDocument;
	}

	public String getDatEmail() {
		return this.datEmail;
	}

	public void setDatEmail(String datEmail) {
		this.datEmail = datEmail;
	}

	

	public String getDatLastNames() {
		return datLastNames;
	}

	public void setDatLastNames(String datLastNames) {
		this.datLastNames = datLastNames;
	}

	public String getDatNames() {
		return this.datNames;
	}

	public void setDatNames(String datNames) {
		this.datNames = datNames;
	}

	public String getDatPassword() {
		return this.datPassword;
	}

	public void setDatPassword(String datPassword) {
		this.datPassword = datPassword;
	}

//	public TipoUsuario getTipoUsuario() {
//		return this.tipoUsuario;
//	}
//
//	public void setTipoUsuario(TipoUsuario tipoUsuario) {
//		this.tipoUsuario = tipoUsuario;
//	}

}