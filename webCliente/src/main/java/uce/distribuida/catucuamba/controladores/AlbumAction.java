package uce.distribuida.catucuamba.controladores;

import java.util.List;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.web.client.RestTemplate;
import uce.distribuida.catucuamba.entidades.Album;

@ManagedBean(name = "albumAction")
@SessionScoped
public class AlbumAction {
	
	private Album album;
	private List<Album> albums;
	
	
	
	RestTemplate restTemplate;



	public Album getAlbum() {
		return album;
	}



	public void setAlbum(Album album) {
		this.album = album;
	}



	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	@PostConstruct
	public void inicializar( ) {
		restTemplate = new RestTemplate();
		album = new Album();
	}
	

 
	public List<Album> getAlbums(){
		albums = restTemplate.getForObject("http://localhost:8020/album/albums" , List.class);
	    System.out.println(albums);
		return albums;
	}
	
	
	//metodo refrescar
	
	
	

}