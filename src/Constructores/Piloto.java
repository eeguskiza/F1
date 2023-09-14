package Constructores;

import java.util.ArrayList;

public class Piloto extends Persona {
	private String habilidad; 
	private String escuderia;
	private String foto;
	private ArrayList <Premio> premios;
	
	
	public Piloto() {
		super();
		this.habilidad = "";
		this.escuderia = null;
		this.premios = null;
		this.foto = "";
	}
	
	public Piloto(String nombre, String apellidos, int edad, String nacionalidad, String ocupacion, int experiencia, String habilidad, String escuderia, ArrayList <Premio> premios, String foto){
		super(nombre, apellidos, edad, nacionalidad, ocupacion, experiencia);
		this.habilidad = habilidad;
		this.escuderia = escuderia;
		this.foto = foto;
		this.premios = premios;
	}

	public String getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}

	public String getEscuderia() {
		return escuderia;
	}

	public void setEscuderia(String escuderia) {
		this.escuderia = escuderia;
	}

	public ArrayList<Premio> getPremios() {
		return premios;
	}

	public void setPremios(ArrayList<Premio> premios) {
		this.premios = premios;
	}

	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Piloto [habilidad=" + habilidad + ", escuderia=" + escuderia + ", premios=" + premios + ", nombre="
				+ nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", nacionalidad=" + nacionalidad
				+ ", ocupacion=" + ocupacion + ", experiencia=" + experiencia + "]";
	}


	


}
