package co.edu.ue.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.Dato;

public interface IDatoJPA extends JpaRepository<Dato, Integer> {
	Dato findByDatEmail(String datEmail);
}
