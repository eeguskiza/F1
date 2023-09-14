package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Guardados.DatosUsuario;

public class Registro extends JFrame {
    private static final long serialVersionUID = 1L;
    private static Registro instance;
    private JLabel l1, l2, l3;
    private JTextField tf;
    private JPasswordField pf, tf1;
    private JButton b1, b2;
    private JPanel panel1, panel2;
    private DatosUsuario datosUsuario;

    private Registro() {
        this.datosUsuario = DatosUsuario.getInstance();
        this.setTitle("Registro");
        this.setSize(650, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font fuente = new Font("Georgia", Font.BOLD, 30);
        Font fuente2 = new Font("Cambria", Font.ROMAN_BASELINE, 20);

        panel1 = new JPanel(new GridLayout(3, 2));
        panel1.setOpaque(false);
        panel2 = new JPanel(new GridLayout(1, 2));
        panel2.setOpaque(false);

        l1 = new JLabel("Usuario", JLabel.CENTER);
        l1.setFont(fuente);
        l2 = new JLabel("Contraseña", JLabel.CENTER);
        l2.setFont(fuente);
        tf = new JTextField();
        tf.setFont(fuente2);
        pf = new JPasswordField();
        l3 = new JLabel("Repetir contraseña", JLabel.CENTER);
        l3.setFont(fuente);
        tf1 = new JPasswordField();
        b1 = new JButton("Atrás");
        b2 = new JButton("Registrarse");

        panel1.add(l1);
        panel1.add(tf);
        panel1.add(l2);
        panel1.add(pf);
        panel1.add(l3);
        panel1.add(tf1);
        panel2.add(b1);
        panel2.add(b2);

        b1.addActionListener(e->{
        	dispose();
            InicioSesion ventanaInicio = InicioSesion.getInstance();
            ventanaInicio.setVisible(true);
        });

        b2.addActionListener(e -> {
            String usuario = tf.getText();
            String contrasena = new String(pf.getPassword());

            if (!usuario.isEmpty() && !contrasena.isEmpty()) {
                datosUsuario.agregarUsuario(usuario, contrasena);
                JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
                dispose();

                if (datosUsuario.validarCredenciales(usuario, contrasena)) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                    MenuInicio m1 = new MenuInicio(usuario);
                    m1.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña o usuario incorrecto");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un usuario y una contraseña válidos");
            }
        });


        InicioSesion inicioSesion = InicioSesion.getInstance();
        inicioSesion.getB1().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Registro r1 = Registro.getInstance();
                r1.setVisible(true);
            }
        });

        inicioSesion.getB2().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = inicioSesion.getTf().getText();
                String pass = new String(inicioSesion.getPf().getPassword());

                if (datosUsuario.validarCredenciales(user, pass)) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                    MenuInicio m1 = new MenuInicio(user);
                    m1.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña o usuario incorrecto");
                }
            }
        });


        this.add(panel1, BorderLayout.CENTER);
        this.add(panel2, BorderLayout.SOUTH);

        JPanel contentPane = new JPanel() {
            private static final long serialVersionUID = 1L;

			@Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                Graphics2D g2d = (Graphics2D) grphcs;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0, Color.decode("#007BFF"), 0, getHeight(), Color.decode("#004A99"));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        contentPane.setLayout(new BorderLayout());

        contentPane.add(panel1, BorderLayout.CENTER);
        contentPane.add(panel2, BorderLayout.SOUTH);

        this.setContentPane(contentPane);
        this.setVisible(true);
    }

    public static Registro getInstance() {
        if (instance == null) {
            instance = new Registro();
        }
        return instance;
    }
}
