package Client_Java.GUI;

import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

public class RoundWinnerPage extends JFrame {
    private JLabel BackgroundLabel;
    private JLabel RoundWinnerLabel;
    private JButton nextRoundBT;

    public void displayRoundWinner(String name){
        this.setVisible(true);
        initComponents();
        RoundWinnerLabel.setText(name);
        this.setSize(1370 ,775);
        setResizable(false);
        repaint();
        validate();
    }
    public static void main(String[] args) {
       RoundWinnerPage page = new RoundWinnerPage();
        page.Draw();
    }

    private void initComponents() {
        RoundWinnerLabel = new javax.swing.JLabel();
        BackgroundLabel = new javax.swing.JLabel();
        nextRoundBT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        RoundWinnerLabel.setFont(new java.awt.Font("STXinwei", 1, 60)); // NOI18N
        RoundWinnerLabel.setForeground(new java.awt.Color(255, 255, 255));
        RoundWinnerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RoundWinnerLabel.setText("Melody");
        getContentPane().add(RoundWinnerLabel);
        RoundWinnerLabel.setBounds(500, 360, 380, 90);

        this.nextRoundBT.setIcon(new ImageIcon("src/Client_Java/res/StartBT.png"));
        this.nextRoundBT.setBorder(new SoftBevelBorder(0));
        nextRoundBT.setBorderPainted(false);
        nextRoundBT.setContentAreaFilled(false);
        this.nextRoundBT.setBackground(new Color(255, 255, 255, 0));
        this.nextRoundBT.setBounds(603, 480, 200, 100);
        this.getContentPane().add(this.nextRoundBT);


        BackgroundLabel.setIcon(new ImageIcon("src/Client_Java/res/RoundWinner.png")); // NOI18N
        getContentPane().add(BackgroundLabel);
        BackgroundLabel.setBounds(0, 0, 1370, 780);

        pack();
    }// </editor-fold>

    public JLabel getRoundWinnerLabel() {
        return RoundWinnerLabel;
    }

    public JButton getNextRoundBT() {
        return nextRoundBT;
    }

    public void Draw(){
        String name="";
        displayRoundWinner(name);
        BackgroundLabel.setIcon(new ImageIcon("src/Client_Java/res/RoundDraw.png"));
        RoundWinnerLabel.setText("");
        this.nextRoundBT.setBounds(603, 510, 200, 100);
    }

}
