package co.edu.ue.repository.dto;

public class UsuarioDto {
	
	 private String userDoc;
	 private String userNombre;
	 private String userPassword;
	
	 		
	public String getUserDoc() {
		return userDoc;
	}



	public void setUserDoc(String userDoc) {
		this.userDoc = userDoc;
	}



	public String getUserNombre() {
		return userNombre;
	}



	public void setUserNombre(String userNombre) {
		this.userNombre = userNombre;
	}



	public String getUserPassword() {
		return userPassword;
	}



	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public UsuarioDto() {
	}
	
	public UsuarioDto(String userDoc, String userNombre, String userPassword) {
		super();
		this.userDoc = userDoc;
		this.userNombre = userNombre;
		this.userPassword = userPassword;
	}

	
}
