package Constructores;

public class CocheF1 extends Vehiculo {
	private String proveedor;
	private String combustible;
	private String escuderia;
	private String rutaFoto;
	
	
	public CocheF1() {
		super();
		this.proveedor = "";
		this.combustible = "";
		this.escuderia = "";
		
	}
	public CocheF1(String marca, String modelo, String color, int año, double vMax, boolean activo, String proveedor, String combustible, String escuderia, String rutaFoto) {
		super(marca, modelo, color, año, vMax, activo);
		this.proveedor = proveedor;
		this.combustible = combustible;
		this.escuderia = escuderia;
		this.rutaFoto = rutaFoto;
		
	}
	public String getPotencia() {
		return proveedor;
	}
	public void setPotencia(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getCombustible() {
		return combustible;
	}
	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}
	public String getEscuderia() {
		return escuderia;
	}
	public void setEscuderia(String escuderia) {
		this.escuderia = escuderia;
	}
	
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getRutaFoto() {
		return rutaFoto;
	}
	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
	}
	@Override
	public String toString() {
		return "CocheF1 [potencia=" + proveedor + ", combustible=" + combustible + ", escuderia=" + escuderia
				+ ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", año=" + año + ", vMax=" + vMax
				+ ", activo=" + activo + "]";
	}

	
}
