package uce.distribuida.catucuamba.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import uce.distribuida.catucuamba.entidades.Album;
import uce.distribuida.catucuamba.servicios.AlbumServicio;

@RestController
@RequestMapping(value = "/album")
public class AlbumControlador {

	@Autowired
	private AlbumServicio albumServicio;
	
	

	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/albums")
	
	public List<Album> findAll() {
		return albumServicio.listarAlbums();
	}

}
