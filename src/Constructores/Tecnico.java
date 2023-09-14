package Constructores;

public class Tecnico extends Persona {
	private String especialidad;
	private String formacion;
	private String escuderia;
	
	public Tecnico() {
		super();
		this.especialidad = "";
		this.formacion = "";
		this.escuderia = null;
	}
	
	public Tecnico(String nombre, String apellidos, int edad, String nacionalidad, String ocupacion, int experiencia, String especialidad, String formacion, String escuderia) {
		super(nombre, apellidos, edad, nacionalidad, ocupacion, experiencia);
		this.especialidad = especialidad;
		this.formacion = formacion;
		this.escuderia = escuderia;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getFormacion() {
		return formacion;
	}

	public void setFormacion(String formacion) {
		this.formacion = formacion;
	}

	public String getEscuderia() {
		return escuderia;
	}

	public void setEscuderia(String escuderia) {
		this.escuderia = escuderia;
	}

	@Override
	public String toString() {
		return "Tecnico [especialidad=" + especialidad + ", formacion=" + formacion + ", escuderia=" + escuderia
				+ ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", nacionalidad="
				+ nacionalidad + ", ocupacion=" + ocupacion + ", experiencia=" + experiencia + "]";
	}
}
