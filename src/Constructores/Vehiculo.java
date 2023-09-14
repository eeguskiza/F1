package Constructores;

public abstract class Vehiculo {
	protected String marca;
	protected String modelo;
	protected String color;
	protected int año;
	protected double vMax;
	protected boolean activo; //ver si el coche esta en uso o no
	
	public Vehiculo() {
		this.marca = "";
		this.modelo = "";
		this.color = "";
		this.año = 0000;
		this.vMax = 0.0;
		this.activo = false;
	}
	
	public Vehiculo(String marca, String modelo, String color, int año, double vMax, boolean activo) {
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.año = año;
		this.vMax = vMax;
		this.activo = activo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public double getvMax() {
		return vMax;
	}

	public void setvMax(double vMax) {
		this.vMax = vMax;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", año=" + año + ", vMax="
				+ vMax + ", activo=" + activo + "]";
	}
}
