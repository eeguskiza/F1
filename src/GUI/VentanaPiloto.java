package GUI;

import Constructores.Piloto;
import Constructores.Premio;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class VentanaPiloto extends JFrame {

    private static final long serialVersionUID = 1L;
    private Piloto piloto;
    private static final int MAX_IMG_SIZE = 300;

    public VentanaPiloto(EditarEscuderia aita, Piloto piloto) {
        this.piloto = piloto;
        this.setTitle("PILOTO");
        this.setSize(550, 950);
        this.setBackground(new Color(65, 85, 99));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int windowWidth = this.getSize().width;
        int x = screenWidth - windowWidth;

        this.setLocation(x, 0);

        JPanel panel = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(65, 85, 99));
                g.fillRect(0, 0, getWidth(), getHeight());

                try {
                    BufferedImage image = ImageIO.read(new File(piloto.getFoto()));
                    int width = image.getWidth();
                    int height = image.getHeight();
                    double aspectRatio = (double) width / height;

                    if (width > height) {
                        if (width > MAX_IMG_SIZE) {
                            width = MAX_IMG_SIZE;
                            height = (int) (MAX_IMG_SIZE / aspectRatio);
                        }
                    } else {
                        if (height > MAX_IMG_SIZE) {
                            height = MAX_IMG_SIZE;
                            width = (int) (MAX_IMG_SIZE * aspectRatio);
                        }
                    }

                    Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                    g.drawImage(scaledImage, (getWidth() - width) / 2, 50, width, height, null);
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("Cambria", Font.BOLD, 20));
                    g.drawString("Nombre: " + piloto.getNombre(), 50, 400);
                    g.drawString("Apellido: " + piloto.getApellidos(), 50, 430);
                    g.drawString("Edad: " + piloto.getEdad(), 50, 460);
                    g.drawString("Nacionalidad: " + piloto.getNacionalidad(), 50, 490);
                    g.drawString("Ocupación: " + piloto.getOcupacion(), 50, 520);
                    g.drawString("Experiencia: " + piloto.getExperiencia() + " años", 50, 550);
                    g.drawString("Habilidad: " + piloto.getHabilidad(), 50, 580);
                    g.drawString("Escudería: " + piloto.getEscuderia(), 50, 610);
                    g.drawString("Premios:", 50, 640);
                    int y = 670;
                    for (Premio premio : piloto.getPremios()) {
                        g.drawString("- " + premio.getNombre() + " (" + premio.getAño() + ")", 50, y);
                        y += 30;
                    }

                } catch (IOException e) {
                    System.out.println("Error al cargar la imagen: " + e.getMessage());
                }
            }
        };

        panel.setLayout(new BorderLayout());

        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.addActionListener(e -> {
            this.setVisible(false);
            aita.setVisible(true);
        });

        panel.add(cerrarButton, BorderLayout.SOUTH);

        this.add(panel);
        this.setVisible(true);
    }
}
