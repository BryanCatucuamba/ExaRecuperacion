package uce.distribuida.catucuamba.servicios;

import java.util.ArrayList;
import java.util.Date;


import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uce.distribuida.catucuamba.cache.CacheSinger;
import uce.distribuida.catucuamba.entidades.Album;
import uce.distribuida.catucuamba.entidades.Singer;
import uce.distribuida.catucuamba.mensajeria.SingerListener;

@Transactional
@Repository
public class AlbumServicioImpl implements AlbumServicio {

	@Autowired
	CacheSinger cache;
	
	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void inicializar() {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Album> listarAlbums() {
		
		String sql = "select * from album";
		
		List<Map<String, Object>> lista1 = jdbcTemplate.queryForList(sql);

		
		List<Singer> lista = cache.listarSingers();
		
		List<Album> ret = new ArrayList<>();
		
lista1.forEach(album -> {
			
			System.out.println(album);
			
			Album dto = new Album();
			
			dto.setId( (Integer) album.get("album_id") );
            dto.setSinger_id((Integer ) album.get("singer_id"));
            dto.setTitle((String) album.get("title"));
            dto.setRelease_date((Date)  album.get("release_date"));
            dto.setVersion( (Integer) album.get("version") );
            ret.add( dto );
			
			
			
			
		});
		

		ret.forEach( s->{
			
			Integer id = s.getId( );
			
			Singer singer = buscarSinger(lista, id);
			
			if( singer!=null ) {
				s.setSingerName( singer.getFirstName( ) + " " + singer.getLastName( ) );
			}
		});
		
		return ret;
	}
	
	public Singer buscarSinger(List<Singer> lista, int id) {
		
		for (Singer singer : lista) {
			if (singer.getId()==id) {
				return singer;
			}
		}
		
		return null;
		
	}

}
