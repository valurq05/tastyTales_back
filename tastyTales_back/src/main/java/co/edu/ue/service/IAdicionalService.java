package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Adicional;

public interface IAdicionalService {
	
	List<Adicional> addAdicionales(Adicional adicional);
	Adicional upAdicional(Adicional adicional);
	Adicional findAdicional(int id);
	List<Adicional> listAllAdicionales();
}
