package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Guardados.DatosUsuario;

public class InicioSesion extends JFrame {
    private static final long serialVersionUID = 1L;
    private static InicioSesion instance;
    protected JLabel l1, l2;
    protected JTextField tf;
    protected JPasswordField pf;
    protected JButton b1, b2;
    protected JPanel panel1, panel2, panel3;
    private DatosUsuario datosUsuario;

    public InicioSesion() {
        this.datosUsuario = DatosUsuario.getInstance();
        this.setTitle("Inicio de Sesión");
        this.setLayout(new BorderLayout());
        this.setSize(650, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font fuente = new Font("Georgia", Font.BOLD, 30);
        Font fuente2 = new Font("Cambria", Font.ROMAN_BASELINE, 20);

        panel1 = new JPanel(new GridLayout(2, 2));
        panel2 = new JPanel(new GridLayout(1, 2));
        panel3 = new JPanel();

        panel1.setOpaque(false);
        panel2.setOpaque(false);
        panel3.setOpaque(false);

        l1 = new JLabel("Usuario", JLabel.CENTER);
        l1.setFont(fuente);
        l2 = new JLabel("Contraseña", JLabel.CENTER);
        l2.setFont(fuente);
        tf = new JTextField();
        tf.setFont(fuente2);
        pf = new JPasswordField();
        b1 = new JButton(new ImageIcon("login.png"));
        b1.setText("Iniciar Sesión");
        b2 = new JButton(new ImageIcon("register.png"));
        b2.setText("Registrarse");

        panel1.add(l1);
        panel1.add(tf);
        panel1.add(l2);
        panel1.add(pf);
        panel2.add(b1);
        panel2.add(b2);

        ImageIcon logo = new ImageIcon("F1-logo (1).png");
        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(logo);
        panel3.add(logoLabel);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = tf.getText();
                String pass = new String(pf.getPassword());

                if (datosUsuario.validarCredenciales(user, pass)) {
                    JOptionPane.showMessageDialog(InicioSesion.this, "Inicio de sesión exitoso");
                    setVisible(false);
                    MenuInicio m1 = new MenuInicio(user);
                    m1.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(InicioSesion.this, "Contraseña o usuario incorrecto");
                }
            }
        });

        b2.addActionListener(e -> {
        	dispose();
            Registro r1 = Registro.getInstance();
            r1.setVisible(true);
        });

        JPanel contentPane = new JPanel() {
            private static final long serialVersionUID = 1L;

			@Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                Graphics2D g2d = (Graphics2D) grphcs;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0, Color.decode("#ff7e5f"), 0, getHeight(), Color.decode("#b13324"));

                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        contentPane.setLayout(new BorderLayout());

        contentPane.add(panel1, BorderLayout.CENTER);
        contentPane.add(panel2, BorderLayout.SOUTH);
        contentPane.add(panel3, BorderLayout.NORTH);

        this.setContentPane(contentPane);
        setVisible(true);
    }

    public JTextField getTf() {
        return tf;
    }

    public void setTf(JTextField tf) {
        this.tf = tf;
    }

    public JPasswordField getPf() {
        return pf;
    }

    public void setPf(JPasswordField pf) {
        this.pf = pf;
    }

    public JButton getB1() {
        return b1;
    }

    public void setB1(JButton b1) {
        this.b1 = b1;
    }

    public JButton getB2() {
        return b2;
    }

    public void setB2(JButton b2) {
        this.b2 = b2;
    }

    public static InicioSesion getInstance() {
        if (instance == null) {
            instance = new InicioSesion();
        }
        return instance;
    }
}
