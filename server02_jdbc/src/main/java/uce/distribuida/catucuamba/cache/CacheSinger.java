package uce.distribuida.catucuamba.cache;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import uce.distribuida.catucuamba.entidades.Singer;

@Component
public class CacheSinger {

 	@Autowired
	RestTemplate rt;
	
	@Cacheable("listaCantantes")
	public List<Singer> listarSingers() {
		System.out.println("Guardando datos en cache");
		List<Singer> singers;
		singers = rt.getForObject("http://localhost:9090/api/server01jdbc/singer/singers" , List.class);
	    System.out.println(singers);
		return singers;
	}
	
}
