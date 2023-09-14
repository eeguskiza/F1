package GUI;

import java.awt.*;
import javax.swing.*;

import Constructores.CocheF1;
import Constructores.Escuderia;
import Constructores.Piloto;
import Constructores.Premio;
import Constructores.Tecnico;
import Guardados.ContenedorPrincipal;

import java.io.*;
import java.util.ArrayList;

public class MenuInicio extends JFrame {

    private static final long serialVersionUID = 1L;
    private String usuario;
    private ContenedorPrincipal contenedor;
    PantallaGestionEscuderias gestionEscuderias;

    public void notifyPantallaGestionEscuderiasClosed() {
        gestionEscuderias = null;
    }

    public MenuInicio(String usuario) {
        this.usuario = usuario;
        this.setTitle("Inicio");
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Contenedor de datos
        contenedor = new ContenedorPrincipal(1);
        // Panel principal personalizado con imagen de fondo
        JPanel backgroundPanel = new JPanel() {
            private static final long serialVersionUID = 1L;

			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("1120089.jpg");
                Image image = backgroundImage.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new BorderLayout());

        // Título
        JLabel titleLabel = new JLabel("¡Bienvenid@ " + usuario + "!", JLabel.CENTER);
        titleLabel.setFont(new Font("Cambria", Font.BOLD, 50));
        titleLabel.setForeground(Color.WHITE); // Establecer color de texto en blanco

        // Botón Jugar
        JButton jugarButton = new JButton("Jugar");
        jugarButton.setFont(new Font("Cambria", Font.BOLD, 20));
        Dimension buttonSize = new Dimension(200, 50);
        jugarButton.setPreferredSize(buttonSize);

        // Panel para datos
        JPanel datosPanel = new JPanel();
        datosPanel.setOpaque(false); // Hacer el panel transparente
        datosPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        // Label Datos
        JLabel datosLabel = new JLabel("Datos:");
        datosLabel.setFont(new Font("Cambria", Font.BOLD, 20));
        datosLabel.setForeground(Color.WHITE);

        // Botones
        JButton gestionarButton = new JButton("Gestionar");
        JButton cargarButton = new JButton("Cargar");
        JButton guardarButton = new JButton("Guardar");
        JButton salirButton = new JButton("Salir");
        gestionarButton.setFont(new Font("Cambria", Font.BOLD, 20));
        cargarButton.setFont(new Font("Cambria", Font.BOLD, 20));
        guardarButton.setFont(new Font("Cambria", Font.BOLD, 20));
        salirButton.setFont(new Font("Cambria", Font.BOLD, 20));
        int num = 0;

        // Funcionalidad Botones
        gestionarButton.addActionListener(e -> {
            if (gestionEscuderias == null) {
                gestionEscuderias = new PantallaGestionEscuderias(this, contenedor);
            } else {
                gestionEscuderias.setVisible(true);
            }
            this.setVisible(false);
        });

        jugarButton.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                this.setVisible(false);
                new GestionCocheJuego(this, contenedor);
            });
        });

        cargarButton.addActionListener(e -> {
            cargarDatos();
        });

        guardarButton.addActionListener(e -> {
            guardarDatos();
        });

        salirButton.addActionListener(e -> {
            dispose();
        });


        datosPanel.add(datosLabel);
        datosPanel.add(gestionarButton);
        datosPanel.add(cargarButton);
        datosPanel.add(guardarButton);

        JPanel panel = new JPanel();
        panel.setOpaque(false); 
        panel.setLayout(new GridBagLayout());


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER; 
        panel.add(titleLabel, gbc);

        gbc.gridy = 1;
        panel.add(jugarButton, gbc);

        gbc.gridy = 2;
        panel.add(datosPanel, gbc);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setOpaque(false);
        mainPanel.add(panel, BorderLayout.CENTER);

        backgroundPanel.add(mainPanel, BorderLayout.SOUTH);

        this.setContentPane(backgroundPanel);
        this.setVisible(true);
    }

    private void cargarDatos() {
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                String linea;
                ContenedorPrincipal contenedor = new ContenedorPrincipal(); 
                Escuderia escuderiaActual = null;
                Piloto pilotoActual = null;
                CocheF1 cocheActual = null;
                Tecnico tecnicoActual = null;

                while ((linea = reader.readLine()) != null) {
                    if (linea.startsWith("Nombre de la escudería: ")) {
                        String nombreEscuderia = linea.substring("Nombre de la escudería: ".length());
                        escuderiaActual = new Escuderia();
                        escuderiaActual.setNombre(nombreEscuderia);
                        contenedor.agregarEscuderia(escuderiaActual);
                    } else if (linea.startsWith("País: ")) {
                        String pais = linea.substring("País: ".length());
                        escuderiaActual.setPais(pais);
                    } else if (linea.startsWith("Director: ")) {
                        String director = linea.substring("Director: ".length());
                        escuderiaActual.setJefeDeEquipo(director);
                    } else if (linea.startsWith("Sede: ")) {
                        String sede = linea.substring("Sede: ".length());
                        escuderiaActual.setSede(sede);
                    } else if (linea.startsWith("Año de fundación: ")) {
                        int fundacion = Integer.parseInt(linea.substring("Año de fundación: ".length()));
                        escuderiaActual.setFundacion(fundacion);
                    } else if (linea.equals("Pilotos:")) {
                        escuderiaActual.setPilotos(new ArrayList<>());
                    } else if (linea.startsWith("\tNombre: ")) {
                        String nombrePiloto = linea.substring("\tNombre: ".length());
                        pilotoActual = new Piloto();
                        pilotoActual.setNombre(nombrePiloto);
                        escuderiaActual.getPilotos().add(pilotoActual);
                    } else if (linea.startsWith("\tApellido: ")) {
                        String apellidos = linea.substring("\tApellido: ".length());
                        pilotoActual.setApellidos(apellidos);
                    } else if (linea.startsWith("\tEdad: ")) {
                        int edad = Integer.parseInt(linea.substring("\tEdad: ".length()));
                        pilotoActual.setEdad(edad);
                    } else if (linea.startsWith("\tNacionalidad: ")) {
                        String nacionalidad = linea.substring("\tNacionalidad: ".length());
                        pilotoActual.setNacionalidad(nacionalidad);
                    } else if (linea.startsWith("\tOcupación: ")) {
                        String ocupacion = linea.substring("\tOcupación: ".length());
                        pilotoActual.setOcupacion(ocupacion);
                    } else if (linea.startsWith("\tExperiencia: ")) {
                        int experiencia = Integer.parseInt(linea.substring("\tExperiencia: ".length()));
                        pilotoActual.setExperiencia(experiencia);
                    } else if (linea.startsWith("\tHabilidad: ")) {
                        String habilidad = linea.substring("\tHabilidad: ".length());
                        pilotoActual.setHabilidad(habilidad);
                    } else if (linea.startsWith("\tEscudería: ")) {
                        String escuderia = linea.substring("\tEscudería: ".length());
                        pilotoActual.setEscuderia(escuderia);
                    } else if (linea.startsWith("\tPremios: ")) {
                        String premiosLinea = linea.substring("\tPremios: ".length());
                        String[] premiosArray = premiosLinea.split(",");
                        ArrayList<Premio> premios = new ArrayList<>();
                        for (String premio : premiosArray) {
                            premios.add(new Premio());
                        }
                        pilotoActual.setPremios(premios);
                    } else if (linea.startsWith("\tFoto: ")) {
                        String foto = linea.substring("\tFoto: ".length());
                        pilotoActual.setFoto(foto);
                    } else if (linea.equals("Coche:")) {
                        cocheActual = new CocheF1();
                        escuderiaActual.setCoche(cocheActual);
                    } else if (linea.startsWith("\tMarca: ")) {
                        String marca = linea.substring("\tMarca: ".length());
                        cocheActual.setMarca(marca);
                    } else if (linea.startsWith("\tModelo: ")) {
                        String modelo = linea.substring("\tModelo: ".length());
                        cocheActual.setModelo(modelo);
                    } else if (linea.startsWith("\tColor: ")) {
                        String color = linea.substring("\tColor: ".length());
                        cocheActual.setColor(color);
                    } else if (linea.startsWith("\tAño: ")) {
                        int año = Integer.parseInt(linea.substring("\tAño: ".length()));
                        cocheActual.setAño(año);
                    } else if (linea.startsWith("\tPeso: ")) {
                        double vMax = Double.parseDouble(linea.substring("\tPeso: ".length()));
                        cocheActual.setvMax(vMax);
                    } else if (linea.startsWith("\tActivo: ")) {
                        boolean activo = Boolean.parseBoolean(linea.substring("\tActivo: ".length()));
                        cocheActual.setActivo(activo);
                    } else if (linea.startsWith("\tProveedor: ")) {
                        String proveedor = linea.substring("\tProveedor: ".length());
                        cocheActual.setProveedor(proveedor);
                    } else if (linea.startsWith("\tCombustible: ")) {
                        String combustible = linea.substring("\tCombustible: ".length());
                        cocheActual.setCombustible(combustible);
                    } else if (linea.startsWith("\tEscudería: ")) {
                        String escuderia = linea.substring("\tEscudería: ".length());
                        cocheActual.setEscuderia(escuderia);
                    } else if (linea.startsWith("\tRuta de la Foto: ")) {
                        String rutaFoto = linea.substring("\tRuta de la Foto: ".length());
                        cocheActual.setRutaFoto(rutaFoto);
                    } else if (linea.equals("Técnicos:")) {
                        escuderiaActual.setTecnicos(new ArrayList<>());
                    } else if (linea.startsWith("\tNombre: ")) {
                        String nombreTecnico = linea.substring("\tNombre: ".length());
                        tecnicoActual = new Tecnico();
                        tecnicoActual.setNombre(nombreTecnico);
                        escuderiaActual.getTecnicos().add(tecnicoActual);
                    } else if (linea.startsWith("\tApellido: ")) {
                        String apellidos = linea.substring("\tApellido: ".length());
                        tecnicoActual.setApellidos(apellidos);
                    } else if (linea.startsWith("\tEdad: ")) {
                        int edad = Integer.parseInt(linea.substring("\tEdad: ".length()));
                        tecnicoActual.setEdad(edad);
                    } else if (linea.startsWith("\tNacionalidad: ")) {
                        String nacionalidad = linea.substring("\tNacionalidad: ".length());
                        tecnicoActual.setNacionalidad(nacionalidad);
                    } else if (linea.startsWith("\tOcupación: ")) {
                        String ocupacion = linea.substring("\tOcupación: ".length());
                        tecnicoActual.setOcupacion(ocupacion);
                    } else if (linea.startsWith("\tExperiencia: ")) {
                        int experiencia = Integer.parseInt(linea.substring("\tExperiencia: ".length()));
                        tecnicoActual.setExperiencia(experiencia);
                    } else if (linea.startsWith("\tEspecialidad: ")) {
                        String especialidad = linea.substring("\tEspecialidad: ".length());
                        tecnicoActual.setEspecialidad(especialidad);
                    } else if (linea.startsWith("\tFormación: ")) {
                        String formacion = linea.substring("\tFormación: ".length());
                        tecnicoActual.setFormacion(formacion);
                    } else if (linea.startsWith("\tEscudería: ")) {
                        String escuderia = linea.substring("\tEscudería: ".length());
                        tecnicoActual.setEscuderia(escuderia);
                    } else if (linea.equals("------------------------------------------")) {
                        escuderiaActual = null;
                        pilotoActual = null;
                        cocheActual = null;
                        tecnicoActual = null;
                    }
                }

                JOptionPane.showMessageDialog(this, "Datos cargados exitosamente.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al cargar datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void guardarDatos() {
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showSaveDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try (PrintWriter writer = new PrintWriter(archivo)) {
                StringBuilder datos = new StringBuilder();

                for (Escuderia escuderia : contenedor.obtenerEscuderias()) {
                    datos.append("Nombre de la escudería: ").append(escuderia.getNombre()).append("\n");
                    datos.append("País: ").append(escuderia.getPais()).append("\n");
                    datos.append("Director: ").append(escuderia.getJefeDeEquipo()).append("\n");
                    datos.append("Sede: ").append(escuderia.getSede()).append("\n");
                    datos.append("Año de fundación: ").append(escuderia.getFundacion()).append("\n");
                    datos.append("Pilotos:\n");
                    for (Piloto piloto : escuderia.getPilotos()) {
                        datos.append("\tNombre: ").append(piloto.getNombre()).append("\n");
                        datos.append("\tApellido: ").append(piloto.getApellidos()).append("\n");
                        datos.append("\tEdad: ").append(piloto.getEdad()).append("\n");
                        datos.append("\tNacionalidad: ").append(piloto.getNacionalidad()).append("\n");
                        datos.append("\tOcupación: ").append(piloto.getOcupacion()).append("\n");
                        datos.append("\tExperiencia: ").append(piloto.getExperiencia()).append("\n");
                        datos.append("\tHabilidad: ").append(piloto.getHabilidad()).append("\n");
                        datos.append("\tEscudería: ").append(piloto.getEscuderia()).append("\n");
                        datos.append("\tPremios: ").append(piloto.getPremios()).append("\n");
                        datos.append("\tFoto: ").append(piloto.getFoto()).append("\n");
                    }
                    datos.append("Coche:\n");
                    datos.append("\tMarca: ").append(escuderia.getCoche().getMarca()).append("\n");
                    datos.append("\tModelo: ").append(escuderia.getCoche().getModelo()).append("\n");
                    datos.append("\tColor: ").append(escuderia.getCoche().getColor()).append("\n");
                    datos.append("\tAño: ").append(escuderia.getCoche().getAño()).append("\n");
                    datos.append("\tPeso: ").append(escuderia.getCoche().getvMax()).append("\n");
                    datos.append("\tActivo: ").append(escuderia.getCoche().isActivo()).append("\n");
                    datos.append("\tProveedor: ").append(escuderia.getCoche().getProveedor()).append("\n");
                    datos.append("\tCombustible: ").append(escuderia.getCoche().getCombustible()).append("\n");
                    datos.append("\tEscudería: ").append(escuderia.getCoche().getEscuderia()).append("\n");
                    datos.append("\tRuta de la Foto: ").append(escuderia.getCoche().getRutaFoto()).append("\n");

                    datos.append("Técnicos:\n");
                    for (Tecnico tecnico : escuderia.getTecnicos()) {
                        datos.append("\tNombre: ").append(tecnico.getNombre()).append("\n");
                        datos.append("\tApellido: ").append(tecnico.getApellidos()).append("\n");
                        datos.append("\tEdad: ").append(tecnico.getEdad()).append("\n");
                        datos.append("\tNacionalidad: ").append(tecnico.getNacionalidad()).append("\n");
                        datos.append("\tOcupación: ").append(tecnico.getOcupacion()).append("\n");
                        datos.append("\tExperiencia: ").append(tecnico.getExperiencia()).append("\n");
                        datos.append("\tEspecialidad: ").append(tecnico.getEspecialidad()).append("\n");
                        datos.append("\tFormación: ").append(tecnico.getFormacion()).append("\n");
                        datos.append("\tEscudería: ").append(tecnico.getEscuderia()).append("\n");
                    }
                    datos.append("------------------------------------------\n");
                }
                writer.println(datos.toString());

                JOptionPane.showMessageDialog(this, "Datos guardados exitosamente.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
