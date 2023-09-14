package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class ScoreWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private JLabel scoreLabel;
    private int score;

    public ScoreWindow() {
        setTitle("Score");
        setSize(200, 100);
        setLocation(0, 0);
        setResizable(false);

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24));
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setBounds(10, 10, 150, 30);
        score = 0;

        JPanel panelScore = new JPanel();
        panelScore.setBackground(new Color(65, 85, 99));
        panelScore.setLayout(new BorderLayout());
        panelScore.add(scoreLabel, BorderLayout.CENTER);

        getContentPane().add(panelScore);

        setVisible(true);
    }

    public void setScore(int score) {
        this.score = score;
        scoreLabel.setText("Score: " + score);
    }
}
