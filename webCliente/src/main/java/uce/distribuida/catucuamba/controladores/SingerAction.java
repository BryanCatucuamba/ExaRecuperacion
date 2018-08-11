package uce.distribuida.catucuamba.controladores;

import java.util.List;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import uce.distribuida.catucuamba.entidades.Singer;

@ManagedBean(name = "singerAction")
@SessionScoped
public class SingerAction  {
    
	private Singer singer;
	private List<Singer> singers;
	
	RestTemplate restTemplate;



	public Singer getSinger() {
		return singer;
	}



	public void setSinger(Singer singer) {
		this.singer = singer;
	}



	public void setSingers(List<Singer> singers) {
		this.singers = singers;
	}
	
	@PostConstruct
	public void inicializar( ) {
		restTemplate = new RestTemplate();
		singer = new Singer();
	}
	


	public List<Singer> getSingers() {
		singers = restTemplate.getForObject("http://localhost:8010/singer/singers" , List.class);
	    System.out.println(singers);
		return singers;
	}


	

}
