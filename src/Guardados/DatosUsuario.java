package Guardados;

import java.util.HashMap;

public class DatosUsuario {
    private static DatosUsuario instance;
    private HashMap<String, String> usuarios;

    public DatosUsuario() {
        usuarios = new HashMap<>();
        agregarUsuario("Erik", "1111");
        agregarUsuario("", "");
    }

    public static DatosUsuario getInstance() {
        if (instance == null) {
            instance = new DatosUsuario();
        }
        return instance;
    }

    public void agregarUsuario(String usuario, String contrasena) {
        usuarios.put(usuario, contrasena);
    }

    public boolean validarCredenciales(String usuario, String contrasena) {
        String contrasenaAlmacenada = usuarios.get(usuario);
        return contrasenaAlmacenada != null && contrasenaAlmacenada.equals(contrasena);
    }
}


