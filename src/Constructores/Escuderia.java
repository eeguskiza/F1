package Constructores;

import java.util.ArrayList;

public class Escuderia {
    private String nombre;
    private String pais;
    private String jefeDeEquipo;
    private String sede;
    private int fundacion;
    private ArrayList<Piloto> pilotos;
    private CocheF1 coche;
    private ArrayList<Tecnico> tecnicos;
    
    public Escuderia() {
        this.nombre = "";
        this.pais = "";
        this.jefeDeEquipo = "";
        this.sede = "";
        this.fundacion = 0;
        this.pilotos = new ArrayList<>();
        this.coche = new CocheF1();
        this.tecnicos = new ArrayList<>();
    }
    
    public Escuderia(String nombre, String pais, String jefeDeEquipo, String sede, int fundacion,
            ArrayList<Piloto> pilotos, CocheF1 coche, ArrayList<Tecnico> tecnicos) {
    		this.nombre = nombre;
    		this.pais = pais;
    		this.jefeDeEquipo = jefeDeEquipo;
    		this.sede = sede;
			this.fundacion = fundacion;
			this.pilotos = pilotos;
			this.coche = coche;
			this.tecnicos = tecnicos;
	}
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getPais() {
        return pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }
    
    public String getJefeDeEquipo() {
        return jefeDeEquipo;
    }
    
    public void setJefeDeEquipo(String jefeDeEquipo) {
        this.jefeDeEquipo = jefeDeEquipo;
    }
    
    public String getSede() {
        return sede;
    }
    
    public void setSede(String sede) {
        this.sede = sede;
    }
    
    public int getFundacion() {
        return fundacion;
    }
    
    public void setFundacion(int fundacion) {
        this.fundacion = fundacion;
    }
    
    

	public ArrayList<Piloto> getPilotos() {
		return pilotos;
	}

	public void setPilotos(ArrayList<Piloto> pilotos) {
		this.pilotos = pilotos;
	}

	public CocheF1 getCoche() {
		return coche;
	}

	public void setCoche(CocheF1 coche) {
		this.coche = coche;
	}

	public ArrayList<Tecnico> getTecnicos() {
		return tecnicos;
	}

	public void setTecnicos(ArrayList<Tecnico> tecnicos) {
		this.tecnicos = tecnicos;
	}

	@Override
	public String toString() {
		return "Escuderia [nombre=" + nombre + ", pais=" + pais + ", jefeDeEquipo=" + jefeDeEquipo + ", sede=" + sede
				+ ", fundacion=" + fundacion + ", pilotos=" + pilotos + ", coche=" + coche + ", tecnicos=" + tecnicos + "]";
	}
	
    
}
