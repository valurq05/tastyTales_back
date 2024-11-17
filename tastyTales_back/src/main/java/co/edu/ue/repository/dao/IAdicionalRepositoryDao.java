package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.Adicional;

public interface IAdicionalRepositoryDao {
	List<Adicional> createAdicional(Adicional adicional);
	Adicional updateAdicional(Adicional adicional);
	Adicional findIdAdicional(int id);
	List<Adicional> listAllAdicional();
}
