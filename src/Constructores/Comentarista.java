package Constructores;
import java.util.ArrayList;

public class Comentarista extends Persona {
	private String estilo;
	private ArrayList <Programa> programas;
	private ArrayList <Premio> premios;
	
	public Comentarista() {
		super();
		this.estilo = "";
		this.programas = null;
		this.premios = null;
	}
	public Comentarista(String nombre, String apellidos, int edad, String nacionalidad, String ocupacion,
			int experiencia, String estilo, ArrayList <Programa> programas, ArrayList <Premio> premios ) {
		super(nombre, apellidos, edad, nacionalidad, ocupacion, experiencia);
		this.estilo = "";
		this.programas = null;
		this.premios = null;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	public ArrayList<Programa> getProgramas() {
		return programas;
	}
	public void setProgramas(ArrayList<Programa> programas) {
		this.programas = programas;
	}
	public ArrayList<Premio> getPremios() {
		return premios;
	}
	public void setPremios(ArrayList<Premio> premios) {
		this.premios = premios;
	}
	
	@Override
	public String toString() {
		return "Comentarista [estilo=" + estilo + ", programas=" + programas + ", premios=" + premios + ", nombre="
				+ nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", nacionalidad=" + nacionalidad
				+ ", ocupacion=" + ocupacion + ", experiencia=" + experiencia + "]";
	}
}

