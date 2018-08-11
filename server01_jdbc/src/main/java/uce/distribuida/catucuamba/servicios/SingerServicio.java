package uce.distribuida.catucuamba.servicios;

import java.util.List;

import uce.distribuida.catucuamba.entidades.Singer;

public interface SingerServicio {
	
	List<Singer> listarTodos();

	void crear( Singer obj );
}
