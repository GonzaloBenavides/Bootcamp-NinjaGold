package cl.gonzalobenavides.ninjagold.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mensaje {
	
	private String msg;
	private Date fecha;
	
	public Mensaje(){
	}
	
	public Mensaje(String msg, Date fecha){
		this.msg = msg;
		this.fecha = fecha;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	

}
