package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.entity.Adicional;
import co.edu.ue.repository.dao.IAdicionalRepositoryDao;

@Service
public class AdicionalService implements IAdicionalService{

	@Autowired
	IAdicionalRepositoryDao dao;
	
	@Override
	public List<Adicional> addAdicionales(Adicional adicional) {
		dao.createAdicional(adicional);
		return listAllAdicionales();
	}

	@Override
	public Adicional upAdicional(Adicional adicional) {
		dao.updateAdicional(adicional);
		return adicional;
	}

	@Override
	public Adicional findAdicional(int id) {
		return dao.findIdAdicional(id);
	}

	@Override
	public List<Adicional> listAllAdicionales() {
		return dao.listAllAdicional();
	}

}
