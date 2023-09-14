package GUI;

import javax.swing.*;

import Constructores.CocheF1;
import Constructores.Escuderia;
import Constructores.Piloto;
import Constructores.Premio;
import Constructores.Tecnico;
import Guardados.ContenedorPrincipal;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PantallaGestionEscuderias extends JFrame {
    private static final long serialVersionUID = 1L;
    private ContenedorPrincipal contenedor;
    private JFrame ventanaActual;
    private int theGref;
    private MenuInicio padre;

    private void notifyWindowClosed() {
        padre.notifyPantallaGestionEscuderiasClosed();
    }

    public PantallaGestionEscuderias(MenuInicio padre, ContenedorPrincipal contenedor) {
        this.contenedor = contenedor;
        this.padre = padre;
        setTitle("GESTIÓN DE DATOS");
        setSize(575, 950);
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int windowHeight = getSize().height;
        int x = 0;
        int y = (screenHeight - windowHeight) / 2;
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(65, 85, 99));

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setOpaque(false);

        JButton[] botones = new JButton[11];
        String[] nombres = {"Aston Martin", "Alpine", "Alpha Tauri", "Alfa Romeo", "Mercedes", "Red Bull", "Ferrari", "McLaren", "Haas", "Williams"};
        String[] rutasImagenes = {
            "AstonMartin.png",
            "alpine.png",
            "alphatauri.png",
            "AlphaRomeo.png",
            "Mercedes.png",
            "RedBull.png",
            "Ferrari.png",
            "Mclaren.png",
            "Haas.png",
            "Williams.png"
        };

        for (int i = 0; i < (botones.length - 1); i++) {
            botones[i] = createEscuderiaButton(nombres[i], rutasImagenes[i]);
        }

        JButton creaLaTuyaButton = new JButton("¡Crea la tuya!");
        creaLaTuyaButton.setForeground(Color.WHITE);
        creaLaTuyaButton.setFont(new Font("Cambria", Font.BOLD, 25));
        creaLaTuyaButton.setOpaque(false);
        creaLaTuyaButton.setContentAreaFilled(false);
        creaLaTuyaButton.setBorderPainted(true);
        creaLaTuyaButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        creaLaTuyaButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        botones[10] = creaLaTuyaButton;

        JButton atrasButton = new JButton("Atrás");
        atrasButton.setForeground(Color.WHITE);
        atrasButton.setFont(new Font("Cambria", Font.BOLD, 16));
        atrasButton.setOpaque(false);
        atrasButton.setContentAreaFilled(false);
        atrasButton.setBorderPainted(true);
        atrasButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        atrasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                notifyWindowClosed();
                padre.setVisible(true);
            }
        });

        for (JButton boton : botones) {
            boton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
            panel.add(boton);
        }

        panel.add(creaLaTuyaButton);
        panel.add(atrasButton);

        for (int i = 0; i < 10; i++) {
            int index = i;
            botones[i].addActionListener(e -> {
                if (ventanaActual != null) {
                    ventanaActual.dispose();
                }

                ArrayList<Escuderia> escu = contenedor.obtenerEscuderias();
                Escuderia izena = escu.get(index);

                String nombre = izena.getNombre();
                String pais = izena.getPais();
                String jefeDeEquipo = izena.getJefeDeEquipo();
                String sede = izena.getSede();
                int fundacion = izena.getFundacion();
                int ancho = 439;

                switch (index) {
                    case 1:
                        ancho = 550;
                        break;
                    case 3:
                        ancho = 534;
                        break;
                    case 5:
                        ancho = 575;
                        break;
                    case 6:
                        ancho = 500;
                        break;
                    case 7:
                        ancho = 534;
                        break;
                    case 8:
                        ancho = 480;
                        break;
                    case 9:
                        ancho = 500;
                        break;
                    default:
                        break;
                }

                EditarEscuderia editarEscuderia = new EditarEscuderia(this, izena, izena.getCoche().getRutaFoto(), ancho, contenedor);
                ventanaActual = editarEscuderia;
            });
        }

        theGref = 0;
        botones[10].addActionListener(e -> {
            ArrayList<Piloto> pilotos11 = new ArrayList<>();
            ArrayList<Tecnico> tecnicos11 = new ArrayList<>();
            ArrayList<Premio> premios11_1 = new ArrayList<>();
            ArrayList<Premio> premios11_2 = new ArrayList<>();
            String rutaCoche10 = "";
            CocheF1 coche11 = new CocheF1("", "", "", 2023, 798.0, true, "", "", "", rutaCoche10);
            Piloto piloto11_1 = new Piloto("", "", 0, "", "Piloto F1", 0, "", "", premios11_1, "");
            Piloto piloto11_2 = new Piloto("", "", 0, "", "Piloto F1", 0, "", "", premios11_2, "");
            pilotos11.add(piloto11_1);
            pilotos11.add(piloto11_2);
            Escuderia escuderia11 = new Escuderia("", "", "", "", 2023, pilotos11, coche11, tecnicos11);

            if (ventanaActual != null) {
                ventanaActual.dispose();
            }

            if (theGref == 0) {
                theGref++;
                String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre de la escuderia:");
                String pais = JOptionPane.showInputDialog(null, "Ingrese el país de la escuderia:");
                String jefeDeEquipo = JOptionPane.showInputDialog(null, "Ingrese el jefe de equipo de la escuderia:");
                String sede = JOptionPane.showInputDialog(null, "Ingrese la sede de la escuderia:");
                String fundacion = JOptionPane.showInputDialog(null, "Ingrese el año de fundación de la escuderia:");
                String rutaImagen = JOptionPane.showInputDialog(null, "Ingrese el nombre de la imagen(logo):");
                ArrayList<Piloto> pilotos = null;
                CocheF1 coche = null;
                ArrayList<Tecnico> tecnicos = null;

                escuderia11.setNombre(nombre);
                escuderia11.setPais(pais);
                escuderia11.setJefeDeEquipo(jefeDeEquipo);
                escuderia11.setSede(sede);
                escuderia11.setFundacion(Integer.parseInt(fundacion));
                contenedor.agregarEscuderia(escuderia11);

                botones[10].removeAll();
                botones[10].setText("");
                botones[10].setLayout(new BorderLayout());
                JLabel titleLabel = new JLabel(nombre);
                titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
                titleLabel.setVerticalAlignment(SwingConstants.BOTTOM);
                titleLabel.setForeground(Color.WHITE);
                titleLabel.setFont(new Font("Cambria", Font.BOLD, 20));
                botones[10].add(titleLabel, BorderLayout.SOUTH);
                ImageIcon icon = new ImageIcon(rutaImagen);
                Image image = icon.getImage().getScaledInstance(284, 75, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(image);
                JLabel imageLabel = new JLabel(scaledIcon);
                imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
                botones[10].add(titleLabel, BorderLayout.SOUTH);
                botones[10].add(imageLabel, BorderLayout.CENTER);
                botones[10].revalidate();
                botones[10].repaint();
                EditarEscuderia editarEscuderia = new EditarEscuderia(PantallaGestionEscuderias.this, escuderia11, rutaImagen, 439, contenedor);
                ventanaActual = editarEscuderia;
            } else {
                ArrayList<Escuderia> escu = contenedor.obtenerEscuderias();
                Escuderia izena = escu.get(10);
                EditarEscuderia editarEscuderia = new EditarEscuderia(this, izena, izena.getCoche().getRutaFoto(), 439, contenedor);
                ventanaActual = editarEscuderia;
            }

        });

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    private JButton createEscuderiaButton(String nombre, String rutaImagen) {
        JButton button = new JButton();
        button.setLayout(new BorderLayout());
        JLabel titleLabel = new JLabel(nombre);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Cambria", Font.BOLD, 20));
        ImageIcon icon = new ImageIcon(rutaImagen);
        Image image = icon.getImage().getScaledInstance(284, 75, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        button.add(titleLabel, BorderLayout.SOUTH);
        button.add(imageLabel, BorderLayout.CENTER);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(true);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        button.addActionListener(e -> {
            System.out.println("Botón " + nombre);
        });
        return button;
    }

    public int getTheGref() {
        return theGref;
    }
}
