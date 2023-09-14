package GUI;

import javax.swing.*;
import java.awt.*;
import Constructores.CocheF1;

public class VentanaCoche extends JFrame {

    private static final long serialVersionUID = 1L;
    private CocheF1 coche;

    public VentanaCoche(EditarEscuderia aita, String ruta, CocheF1 coche, int ancho) {
        this.coche = coche;
        this.setTitle("COCHE");
        this.setSize(ancho, 950);
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
                ImageIcon imageIcon = new ImageIcon(ruta);
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                g.setColor(new Color(0, 0, 0, 128));
                g.fillRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.WHITE);
                g.setFont(new Font("Cambria", Font.BOLD, 20));
                g.drawString("Marca: " + coche.getMarca(), 50, 100);
                g.drawString("Modelo: " + coche.getModelo(), 50, 130);
                g.drawString("Color: " + coche.getColor(), 50, 160);
                g.drawString("Año: " + coche.getAño(), 50, 190);
                g.drawString("Peso: " + coche.getvMax() + "Kg", 50, 220);
                g.drawString("Activo: " + coche.isActivo(), 50, 250);
                g.drawString("Proveedor: " + coche.getPotencia(), 50, 280);
                g.drawString("Combustible: " + coche.getCombustible(), 50, 310);
                g.drawString("Escudería: " + coche.getEscuderia(), 50, 340);
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
