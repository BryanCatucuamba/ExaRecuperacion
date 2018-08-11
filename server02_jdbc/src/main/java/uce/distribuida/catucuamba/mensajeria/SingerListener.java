package uce.distribuida.catucuamba.mensajeria;

import uce.distribuida.catucuamba.entidades.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SingerListener {
	
	
	@Autowired
	RestTemplate rt;
	
	@CachePut(cacheNames="listaCantantes")
    public List<Singer> receiveMessage(Singer singer) {
        System.out.println(">>>>> actualizando lista de cantantes");
        System.out.println("Refrescando datos en cache");
		List<Singer> singers;
		singers = rt.getForObject("http://localhost:9090/api/server01jdbc/singer/singers" , List.class);
	    System.out.println(singers);
	    return singers;
    }

}
