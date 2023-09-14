package Constructores;

public class CocheSafety extends Vehiculo {
	private int airbags; 
	private String sistemaFrenos;
	private String sistemaSeguridad;
	private Escuderia escuderia;
	
	public CocheSafety() {
		super();
		this.airbags = 0;
		this.sistemaFrenos = "";
		this.sistemaSeguridad = "";
		this.escuderia = null;
		
	}
	
	public CocheSafety(String marca, String modelo, String color, int año, double vMax, boolean activo, int airbags, 	String sistemaFrenos, String sistemaSeguridad, Escuderia escuderia) {
		super(marca, modelo, color, año, vMax, activo);
		this.airbags = airbags;
		this.sistemaFrenos = sistemaFrenos;
		this.sistemaSeguridad = sistemaSeguridad;
		this.escuderia = escuderia;
	}

	public int getAirbags() {
		return airbags;
	}

	public void setAirbags(int airbags) {
		this.airbags = airbags;
	}

	public String getSistemaFrenos() {
		return sistemaFrenos;
	}

	public void setSistemaFrenos(String sistemaFrenos) {
		this.sistemaFrenos = sistemaFrenos;
	}

	public String getSistemaSeguridad() {
		return sistemaSeguridad;
	}

	public void setSistemaSeguridad(String sistemaSeguridad) {
		this.sistemaSeguridad = sistemaSeguridad;
	}
	public Escuderia getEscuderia() {
		return escuderia;
	}
	public void setEscuderia(Escuderia escuderia) {
		this.escuderia = escuderia;
	}

	@Override
	public String toString() {
		return "CocheSafety [airbags=" + airbags + ", sistemaFrenos=" + sistemaFrenos + ", sistemaSeguridad="
				+ sistemaSeguridad + ", escuderia=" + escuderia + ", marca=" + marca + ", modelo=" + modelo + ", color="
				+ color + ", año=" + año + ", vMax=" + vMax + ", activo=" + activo + "]";
	}



}
