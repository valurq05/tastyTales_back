package co.edu.ue.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.Usuario;

public interface IUsuarioJpa extends JpaRepository<Usuario, Integer>{

}
