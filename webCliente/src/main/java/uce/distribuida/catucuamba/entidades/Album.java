package uce.distribuida.catucuamba.entidades;

import java.io.Serializable;
import java.util.Date;

public class Album implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private int singer_id;
	private String title;
	private Date release_date;
	private int version;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSinger_id() {
		return singer_id;
	}
	public void setSinger_id(int singer_id) {
		this.singer_id = singer_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getRelease_date() {
		return release_date;
	}
	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	
	@Override
	public String toString() {
		return "Album [id=" + id + ", singer_id=" + singer_id + ", title=" + title + ", release_date=" + release_date
				+ ", version=" + version + "]";
	}
	
	
	

}
