package Constructores;

public class Programa {
	private String nombre;
	private String cadena;
	private int añoInicio;
	private int añoFin;
	
	public Programa(String nombre, String cadena, int añoInicio, int añoFin) {
		super();
		this.nombre = nombre;
		this.cadena = cadena;
		this.añoInicio = añoInicio;
		this.añoFin = añoFin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public int getAñoInicio() {
		return añoInicio;
	}

	public void setAñoInicio(int añoInicio) {
		this.añoInicio = añoInicio;
	}

	public int getAñoFin() {
		return añoFin;
	}

	public void setAñoFin(int añoFin) {
		this.añoFin = añoFin;
	}

	@Override
	public String toString() {
		return "Programa [nombre=" + nombre + ", cadena=" + cadena + ", añoInicio=" + añoInicio + ", añoFin=" + añoFin
				+ "]";
	}
	
	
}
