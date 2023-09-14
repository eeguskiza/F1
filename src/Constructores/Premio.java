package Constructores;

public class Premio {
	private String nombre;
	private String lugar;
	private int año;
	private String motivo;
	
	
	public Premio() {
		super();
		this.nombre = "";
		this.lugar = "";
		this.año = 0;
		this.motivo = "";
	}
	public Premio(String nombre, String lugar, int año, String motivo) {
		super();
		this.nombre = nombre;
		this.lugar = lugar;
		this.año = año;
		this.motivo = motivo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	@Override
	public String toString() {
		return "Premio [nombre=" + nombre + ", lugar=" + lugar + ", año=" + año + ", motivo=" + motivo + "]";
	}

}
