package Constructores;

public class Publico extends Persona {
	private String comportamiento; 
	private String preferencia1;
	private String preferencia2;
	
	public Publico() {
		super();
		this.comportamiento = "";
		this.preferencia1 = "";
		this.preferencia2 = "";
	}
	
	public Publico(String nombre, String apellidos, int edad, String nacionalidad, String ocupacion, int 			experiencia, String comportamiento, String preferencia1, String preferencia2) {
		super(nombre, apellidos, edad, nacionalidad, ocupacion, experiencia);
		this.comportamiento = "";
		this.preferencia1 = "";
		this.preferencia2 = "";
	}

	public String getComportamiento() {
		return comportamiento;
	}

	public void setComportamiento(String comportamiento) {
		this.comportamiento = comportamiento;
	}

	public String getPreferencia1() {
		return preferencia1;
	}

	public void setPreferencia1(String preferencia1) {
		this.preferencia1 = preferencia1;
	}

	public String getPreferencia2() {
		return preferencia2;
	}

	public void setPreferencia2(String preferencia2) {
		this.preferencia2 = preferencia2;
	}

	@Override
	public String toString() {
		return "Publico [comportamiento=" + comportamiento + ", preferencia1=" + preferencia1 + ", preferencia2="
				+ preferencia2 + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", nacionalidad=" + nacionalidad + ", ocupacion=" + ocupacion + ", experiencia=" + experiencia + "]";
	}
}
