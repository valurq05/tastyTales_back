package co.edu.ue.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Adicional;
import co.edu.ue.repository.jpa.IAdicionalJpa;

@Repository
public class AdicionalRepositoryDao implements IAdicionalRepositoryDao{
	
	@Autowired
	IAdicionalJpa jpa;

	@Override
	public List<Adicional> createAdicional(Adicional adicional) {
		jpa.save(adicional);
		return listAllAdicional();
	}

	@Override
	public Adicional updateAdicional(Adicional adicional) {
		jpa.save(adicional);
		return adicional;
	}

	@Override
	public Adicional findIdAdicional(int id) {
		return jpa.findById(id).orElse(null);
	}

	@Override
	public List<Adicional> listAllAdicional() {
		return jpa.findAll();
	}
}
