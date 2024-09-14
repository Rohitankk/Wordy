package Client_Java.GUI;

import javax.swing.*;

public class LoadGameFor5Seconds extends JFrame {
      private JLabel BackgroundLB;

    public void displayLoadingGame(){
        this.setVisible(true);
        initComponents();
        this.setSize(1355 ,775);
        setResizable(false);
        repaint();
        validate();
    }

    public static void main(String[] args) {
        LoadGameFor5Seconds load = new LoadGameFor5Seconds();
        load.displayLoadingGame();
    }
    private void initComponents() {
        BackgroundLB = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        BackgroundLB.setIcon(new ImageIcon("src/Client_Java/res/5seconds.png")); // NOI18N
        getContentPane().add(BackgroundLB);
        BackgroundLB.setBounds(-10, -10, 1370, 790);

        pack();
    }// </editor-fold>

}
