package Client_Java.GUI;

import javax.swing.*;

public class WinnerPage extends JFrame {
    public void displayWinnerPage(String username){
        this.setVisible(true);
        initComponents();
        WinnerNameLB.setText(username);
        this.setSize(1365 ,775);
        setResizable(false);
        repaint();
        validate();
    }

    public static void main(String[] args) {
        WinnerPage page = new WinnerPage();
        page.displayWinnerPage("Rohit");
    }

    private void initComponents() {

        HomeButton = new JButton();
        WinnerNameLB = new JLabel();
        BackgroundLB = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        HomeButton.setIcon(new ImageIcon("src/Client_Java/res/HomeBT.png")); // NOI18N
        HomeButton.setBorderPainted(false);
        HomeButton.setContentAreaFilled(false);
        getContentPane().add(HomeButton);
        HomeButton.setBounds(215, 380, 320, 90);

        WinnerNameLB.setFont(new java.awt.Font("Sitka Text", 1, 36)); // NOI18N
        WinnerNameLB.setForeground(new java.awt.Color(227, 192, 48));
        WinnerNameLB.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(WinnerNameLB);
        WinnerNameLB.setBounds(920, 570, 190, 50);

        BackgroundLB.setIcon(new ImageIcon("src/Client_Java/res/WinnerPage.png")); // NOI18N
        getContentPane().add(BackgroundLB);
        BackgroundLB.setBounds(0, 0, 1360, 740);

        pack();
    }

    // Variables declaration - do not modify
    private JLabel BackgroundLB;
    private JButton HomeButton;
    private JLabel WinnerNameLB;
    // End of variables declaration


    public JButton getHomeButton() {
        return HomeButton;
    }

    public JLabel getWinnerNameLB() {
        return WinnerNameLB;
    }

    public void setWinnerNameLB(JLabel winnerNameLB) {
        WinnerNameLB = winnerNameLB;
    }
}
