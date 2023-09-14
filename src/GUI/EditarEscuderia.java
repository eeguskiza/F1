package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import Constructores.*;
import Guardados.ContenedorPrincipal;

public class EditarEscuderia extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField paisTextField;
    private JTextField jefeDeEquipoTextField;
    private JTextField sedeTextField;
    private JTextField fundacionTextField;

    public EditarEscuderia(PantallaGestionEscuderias osaba, Escuderia escuderia, String ruta, int ancho, ContenedorPrincipal contenedor) {
        this.setTitle("Editar escuderia");
        this.setSize(825, 950);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int windowWidth = this.getSize().width;
        int x = screenWidth - windowWidth;
        this.setLocation(x, 0);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(40, 57, 71));
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(40, 57, 71));
        JLabel titleLabel = new JLabel(escuderia.getNombre());
        titleLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new GridLayout(4, 2, 10, 10));
        fieldsPanel.setBackground(new Color(65, 85, 99));

        JLabel paisLabel = new JLabel("País:");
        JLabel jefeDeEquipoLabel = new JLabel("Jefe de Equipo:");
        JLabel sedeLabel = new JLabel("Sede:");
        JLabel fundacionLabel = new JLabel("Fundación:");
        paisLabel.setFont(new Font("Arial", Font.BOLD, 16));
        paisLabel.setForeground(Color.WHITE);
        jefeDeEquipoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        jefeDeEquipoLabel.setForeground(Color.WHITE);
        sedeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        sedeLabel.setForeground(Color.WHITE);
        fundacionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        fundacionLabel.setForeground(Color.WHITE);

        paisTextField = new JTextField();
        jefeDeEquipoTextField = new JTextField();
        sedeTextField = new JTextField();
        fundacionTextField = new JTextField();
        paisTextField.setFont(new Font("Lucida Handwriting", Font.PLAIN, 16));
        jefeDeEquipoTextField.setFont(new Font("Lucida Handwriting", Font.PLAIN, 16));
        sedeTextField.setFont(new Font("Lucida Handwriting", Font.PLAIN, 16));
        fundacionTextField.setFont(new Font("Lucida Handwriting", Font.PLAIN, 16));

        fieldsPanel.add(paisLabel);
        fieldsPanel.add(paisTextField);
        fieldsPanel.add(jefeDeEquipoLabel);
        fieldsPanel.add(jefeDeEquipoTextField);
        fieldsPanel.add(sedeLabel);
        fieldsPanel.add(sedeTextField);
        fieldsPanel.add(fundacionLabel);
        fieldsPanel.add(fundacionTextField);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        buttonsPanel.setBackground(new Color(65, 85, 99));

        JButton piloto1Button = new JButton("Piloto 1");
        JButton piloto2Button = new JButton("Piloto 2");
        JButton cochesButton = new JButton("Coche");
        JButton tecnicosButton = new JButton("Cerrar");
        JButton guardarButton = new JButton("Guardar");
        
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        piloto1Button.setFont(buttonFont);
        piloto2Button.setFont(buttonFont);
        cochesButton.setFont(buttonFont);
        tecnicosButton.setFont(buttonFont);
        guardarButton.setFont(buttonFont);

        buttonsPanel.add(cochesButton);
        buttonsPanel.add(Box.createHorizontalGlue());
        buttonsPanel.add(piloto1Button);
        buttonsPanel.add(piloto2Button);
        buttonsPanel.add(Box.createHorizontalGlue());
        buttonsPanel.add(guardarButton); 
        buttonsPanel.add(tecnicosButton);

        panel.add(titlePanel, BorderLayout.NORTH);
        panel.add(fieldsPanel, BorderLayout.CENTER);
        panel.add(buttonsPanel, BorderLayout.SOUTH);
        
        this.setContentPane(panel);
        this.setVisible(true);

        rellenarCampos(escuderia.getPais(), escuderia.getJefeDeEquipo(),
                escuderia.getSede(), escuderia.getFundacion());
        
        cochesButton.addActionListener(e -> {
            CocheF1 coche = escuderia.getCoche();
            VentanaCoche v1 = new VentanaCoche(this, ruta, coche, ancho);
            this.setVisible(false);
        });
        
        tecnicosButton.addActionListener(e -> {
            dispose();
        });
        
        piloto1Button.addActionListener(e -> {
            ArrayList<Piloto> pilotos = escuderia.getPilotos();
            if (!pilotos.isEmpty()) {
                Piloto piloto = pilotos.get(0);
                VentanaPiloto ventanaPiloto = new VentanaPiloto(this, piloto);
                ventanaPiloto.setVisible(true);
                this.dispose();
            }
        });
        
        piloto2Button.addActionListener(e -> {
            ArrayList<Piloto> pilotos = escuderia.getPilotos();
            if (pilotos.size() > 1) {
                Piloto piloto = pilotos.get(1);
                VentanaPiloto ventanaPiloto = new VentanaPiloto(this, piloto);
                ventanaPiloto.setVisible(true);
                this.dispose();
            }
        });
        
        guardarButton.addActionListener(e -> {
            String pais = paisTextField.getText();
            String jefeDeEquipo = jefeDeEquipoTextField.getText();
            String sede = sedeTextField.getText();
            int fundacion = Integer.parseInt(fundacionTextField.getText());
            Escuderia nueva = new Escuderia(
                escuderia.getNombre(),
                pais,
                jefeDeEquipo,
                sede,
                fundacion,
                escuderia.getPilotos(),
                escuderia.getCoche(),
                escuderia.getTecnicos()
            );
            contenedor.actualizarEscuderia(nueva);
            this.dispose();
        });
        
    }

    public void rellenarCampos(String pais, String jefeDeEquipo, String sede, int fundacion) {
        paisTextField.setText(pais);
        jefeDeEquipoTextField.setText(jefeDeEquipo);
        sedeTextField.setText(sede);
        fundacionTextField.setText(String.valueOf(fundacion));
    }
}
