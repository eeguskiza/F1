package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Constructores.Escuderia;

public class Juego extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final String OBSTACLE_IMAGE = "piedra.png";
    private static final String POWERUP_IMAGE_1 = "vida.png";
    private static final String POWERUP_IMAGE_2 = "velocidad.png";
    private JLabel cocheLabel;
    private int cocheX, cocheY, score;
    private MenuInicio aita;
    private Mapa mapa;
    private Obstacle[] obstacles;
    private PowerUp[] powerUps;
    private boolean immortal = false;
    private boolean slowDown = false;
    private ScoreWindow scoreWindow;

    public Juego(MenuInicio aita, Escuderia escuderia, int num) {
        this.aita = aita;
        setTitle("Juego de Coches");
        setSize(1300, 600);
        setLocationRelativeTo(null);
        setResizable(false);

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

        ImageIcon cocheIcon = new ImageIcon(rutasImagenes[num]);
        Image cocheImage = cocheIcon.getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT);
        cocheLabel = new JLabel(new ImageIcon(cocheImage));

        cocheX = 100;
        cocheY = 150;
        cocheLabel.setBounds(cocheX, cocheY, 100, 50);

        score = 0;

        JPanel panelJuego = new JPanel();
        panelJuego.setBackground(Color.DARK_GRAY);

        panelJuego.setLayout(null);
        panelJuego.add(cocheLabel);

        getContentPane().add(panelJuego);

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        moverCoche(0, -10);
                        break;
                    case KeyEvent.VK_DOWN:
                        moverCoche(0, 10);
                        break;
                    case KeyEvent.VK_RIGHT:
                        moverCoche(10, 0);
                        break;
                    case KeyEvent.VK_LEFT:
                        moverCoche(-10, 0);
                        break;
                }
            }
        });

        panelJuego.requestFocus();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                aita.setVisible(true);
            }
        });

        setVisible(true);

        mapa = new Mapa();
        mapa.agregarCoche(cocheLabel);

        obstacles = new Obstacle[10];
        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i] = new Obstacle();
            obstacles[i].setLocation(1200 + i * 200, cocheY + 100 + (int)(Math.random() * 200));
            obstacles[i].setSize(50, 50);
            panelJuego.add(obstacles[i]);
        }

        powerUps = new PowerUp[2];
        for (int i = 0; i < powerUps.length; i++) {
            powerUps[i] = new PowerUp(i);
            powerUps[i].setLocation(1200 + i * 1000, cocheY + 100 + (int)(Math.random() * 200));
            powerUps[i].setSize(50, 50);
            panelJuego.add(powerUps[i]);
        }

        mapa.start();
        scoreWindow = new ScoreWindow();
        scoreWindow.setScore(score);
    }

    public void moverCoche(int dx, int dy) {
        cocheX += dx;
        cocheY += dy;

        // Limitar la posición del coche dentro de la ventana
        cocheX = Math.max(cocheX, 0);
        cocheX = Math.min(cocheX, getContentPane().getWidth() - cocheLabel.getWidth());
        cocheY = Math.max(cocheY, 0);
        cocheY = Math.min(cocheY, getContentPane().getHeight() - cocheLabel.getHeight());

        cocheLabel.setBounds(cocheX, cocheY, 100, 50);
    }

    private void updateScore(int newScore) {
        score = newScore;
        scoreWindow.setScore(score);
    }

    private class Mapa extends Thread {
        private boolean ejecutando;
        private double obstacleSpeed = 5.0;
        private double obstacleIncrement = 0.20;

        public void agregarCoche(JLabel coche) {
            coche.setBounds(cocheX, cocheY, 100, 50);
        }

        public void run() {
            ejecutando = true;
            while (ejecutando) {
                for (Obstacle obstacle : obstacles) {
                    int oldX = obstacle.getX();
                    obstacle.setLocation(obstacle.getX() - (int)obstacleSpeed, obstacle.getY());
                    
                    if (oldX >= cocheX && obstacle.getX() < cocheX) {
                        score++;
                        updateScore(score);
                    }

                    if (obstacle.getX() + obstacle.getWidth() < 0) {
                        obstacle.setLocation(getWidth(), (int)(Math.random() * (getHeight() - 100 - 100)) + 10);
                    }

                    if (obstacle.getBounds().intersects(cocheLabel.getBounds())) {
                        if (immortal) {
                            immortal = false;
                            obstacle.setLocation(getWidth(), (int)(Math.random() * (getHeight() - 100 - 100)) + 10);
                        } else {
                            ejecutando = false;
                            aita.setVisible(true);
                            JOptionPane.showMessageDialog(Juego.this, "¡Te has muerto!" + " Score: " + score);
                            scoreWindow.dispose();
                            dispose();
                        }
                    }
                }

                for (PowerUp powerUp : powerUps) {
                    powerUp.setLocation(powerUp.getX() - (int)obstacleSpeed, powerUp.getY());

                    if (powerUp.getX() + powerUp.getWidth() < 0) {
                        powerUp.setLocation(getWidth(), (int)(Math.random() * (getHeight() - 100 - 100)) + 10);
                    }

                    if (powerUp.getBounds().intersects(cocheLabel.getBounds())) {
                        if (powerUp.getType() == 0) {
                            immortal = true;
                        } else if (powerUp.getType() == 1) {
                            slowDown = true;
                            obstacleSpeed /= 2;
                        }

                        powerUp.setLocation(getWidth(), (int)(Math.random() * (getHeight() - 100 - 100)) + 10);
                    }
                }

                if (slowDown) {
                    obstacleSpeed *= 2;
                    slowDown = false;
                }

                if (score > 1500) {
                    JOptionPane.showMessageDialog(Juego.this, "¡Vas demasiado rapido!");
                    dispose();
                }

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void detener() {
            ejecutando = false;
        }
    }
    private class Obstacle extends JLabel {
        public Obstacle() {
            // Carga la imagen del obstáculo
            ImageIcon obstacleIcon = new ImageIcon(OBSTACLE_IMAGE);
            Image obstacleImage = obstacleIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            setIcon(new ImageIcon(obstacleImage));
            setOpaque(false);
        }
    }
    
    private class PowerUp extends JLabel {
        private int type;  // 0 for immortal, 1 for slow down

        public PowerUp(int type) {
            this.type = type;
            // Carga la imagen del power-up
            String imageRoute = type == 0 ? POWERUP_IMAGE_1 : POWERUP_IMAGE_2;
            ImageIcon powerUpIcon = new ImageIcon(imageRoute);
            Image powerUpImage = powerUpIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            setIcon(new ImageIcon(powerUpImage));
            setOpaque(false);
        }

        public int getType() {
            return type;
        }
    }
}