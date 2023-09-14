package Main;
import javax.swing.JOptionPane;

import GUI.*;

public class Main {

	public static void main(String[] args) {
		InicioSesion v1 = new InicioSesion();
		v1.setVisible(true);
    	JOptionPane.showMessageDialog(v1, "Si no tiene un usuario, pulse en registrarse.");
	}

}