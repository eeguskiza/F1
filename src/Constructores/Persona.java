package Constructores;

public abstract class Persona {
	protected String nombre;
	protected String apellidos;
	protected int edad;
	protected String nacionalidad;
	protected String ocupacion;
	protected int experiencia; //cuantos años de experiencia
	
	public Persona() {
		this.nombre = "";
		this.apellidos = "";
		this.edad = 0;
		this.nacionalidad = "";
		this.ocupacion = "";
		this.experiencia = 0;
	}
	
	public Persona(String nombre, String apellidos, int edad, String nacionalidad, String ocupacion, int experiencia) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.nacionalidad = nacionalidad;
		this.ocupacion = ocupacion;
		this.experiencia = experiencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}
	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", nacionalidad="
				+ nacionalidad + ", ocupacion=" + ocupacion + ", experiencia=" + experiencia + "]";
	}

}
