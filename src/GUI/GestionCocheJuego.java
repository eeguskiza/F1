package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Constructores.Escuderia;
import Guardados.ContenedorPrincipal;

public class GestionCocheJuego extends JFrame {

	public GestionCocheJuego(MenuInicio padre, ContenedorPrincipal contenedor) {
        this.setTitle("GESTIÓN DE DATOS");
        this.setSize(575, 950);
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        // Establecer la ubicación de la ventana en la parte izquierda
        int windowHeight = this.getSize().height;
        int x = 0; // Coordenada X para la ubicación de la ventana
        int y = (screenHeight - windowHeight) / 2; // Coordenada Y para la ubicación de la ventana

        this.setLocation(x, y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Establecer el fondo gris claro
        getContentPane().setBackground(new Color(65, 85, 99));

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setOpaque(false);

        // Botones de escuderías
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

        // Botón "¡Crea la tuya!"
        JButton creaLaTuyaButton = new JButton("Tu Escuderia");
        creaLaTuyaButton.setForeground(Color.WHITE); // Establecer el color del texto a blanco
        creaLaTuyaButton.setFont(new Font("Cambria", Font.BOLD, 25));
        creaLaTuyaButton.setOpaque(false); // Hacer que el botón no sea transparente
        creaLaTuyaButton.setContentAreaFilled(false); // No rellenar el área del botón
        creaLaTuyaButton.setBorderPainted(true); // Mostrar el borde del botón
        creaLaTuyaButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        creaLaTuyaButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));// Establecer el borde blanco
        botones[10] = creaLaTuyaButton;

        // Botón de "Atrás"
        JButton atrasButton = new JButton("Atrás");
        atrasButton.setForeground(Color.WHITE); // Establecer el color del texto a blanco
        atrasButton.setFont(new Font("Cambria", Font.BOLD, 16));
        atrasButton.setOpaque(false); // Hacer que el botón no sea transparente
        atrasButton.setContentAreaFilled(false); // No rellenar el área del botón
        atrasButton.setBorderPainted(true); // Mostrar el borde del botón
        atrasButton.setBorder(BorderFactory.createLineBorder(Color.WHITE)); // Establecer el borde blanco
        atrasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                padre.setVisible(true);
            }
        });

        // Agregar botones al panel
        for (JButton boton : botones) {
            boton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3)); // Aumentar el grosor del borde
            panel.add(boton);
        }

        panel.add(creaLaTuyaButton);
        panel.add(atrasButton);

        for (int i = 0; i < 10; i++) {
            int index = i;
            botones[i].addActionListener(e -> {
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
                        // Caso por defecto
                        break;
                }
                Juego nuevo = new Juego(padre, izena, index);
                dispose();

            });
        }
        
        botones[10].addActionListener(e -> {
            ArrayList<Escuderia> escu = contenedor.obtenerEscuderias();
            Escuderia izena = escu.get(10);
           
            Juego nuevo = new Juego(padre, izena, 10);
            dispose();

        });



        // Agregar panel al JFrame
        this.add(panel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    private JButton createEscuderiaButton(String nombre, String rutaImagen) {
        JButton button = new JButton();
        button.setLayout(new BorderLayout());

        // Crear etiqueta de título
        JLabel titleLabel = new JLabel(nombre);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        titleLabel.setForeground(Color.WHITE); // Establecer el color del texto a blanco
        titleLabel.setFont(new Font("Cambria", Font.BOLD, 20)); // Aumentar el tamaño de la fuente

        // Crear imagen ajustada al tamaño del botón
        ImageIcon icon = new ImageIcon(rutaImagen);
        Image image = icon.getImage().getScaledInstance(284, 75, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Agregar etiqueta de título e imagen al botón
        button.add(titleLabel, BorderLayout.SOUTH);
        button.add(imageLabel, BorderLayout.CENTER);

        // Configurar propiedades del botón
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(true);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        // Agregar ActionListener al botón
        button.addActionListener(e -> {
            System.out.println("Botón " + nombre);
        });

        return button;
    }
}
