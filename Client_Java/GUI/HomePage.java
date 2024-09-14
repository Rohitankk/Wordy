package Client_Java.GUI;

import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;


public class HomePage extends JFrame {
    private JLabel background;
    private JButton startGameBT;
    private JButton instructionsBT;
    private JButton LeaderBoardsButton;
    private JButton LogoutButton;
    private javax.swing.JLabel ProfileLabel;
    private javax.swing.JLabel UserNameLabel;


    public void displayHome(String username){
        this.initComponents();
        setSize(1366, 790);
        UserNameLabel.setText(username);
        setName("Home");
        setVisible(true);
        this.setResizable(false);
        validate();
    }

    private void initComponents() {
        this.startGameBT = new JButton();
        this.instructionsBT= new JButton();
        this.background = new JLabel();
        this.ProfileLabel = new javax.swing.JLabel();
        this.UserNameLabel = new javax.swing.JLabel();
        this.LogoutButton= new JButton();
        this.LeaderBoardsButton = new javax.swing.JButton();
        this.getContentPane().setLayout((LayoutManager)null);

        // ProfilePictureLabel
        ProfileLabel.setIcon(new ImageIcon("src/Client_Java/res/Profile.png")); // NOI18N
        getContentPane().add(ProfileLabel);
        ProfileLabel.setBounds(10, 10, 100, 120);

        // Player Name Label
        UserNameLabel.setFont(new java.awt.Font("STXinwei", 0, 48)); // NOI18N
        UserNameLabel.setForeground(new java.awt.Color(255, 204, 0));
        getContentPane().add(UserNameLabel);
        UserNameLabel.setBounds(110, 50, 180, 60);

        // Start Game Button
        this.startGameBT.setIcon(new ImageIcon("src/Client_Java/res/StartBT.png"));
        this.startGameBT.setBorder(new SoftBevelBorder(0));
        startGameBT.setBorderPainted(false);
        startGameBT.setContentAreaFilled(false);
        this.startGameBT.setBackground(new Color(255, 255, 255, 0));
        this.startGameBT.setBounds(603, 480, 200, 100);
        this.getContentPane().add(this.startGameBT);

        // Instructions Button
        this.instructionsBT.setIcon(new ImageIcon("src/Client_Java/res/InstructionsBT.png"));
        this.instructionsBT.setBorder(new SoftBevelBorder(0));
        instructionsBT.setBorderPainted(false);
        instructionsBT.setContentAreaFilled(false);
        instructionsBT.setBackground(new Color(255,255,255,0));
        instructionsBT.setBounds(1210, 610, 110, 120);
        getContentPane().add(instructionsBT);

        // LeaderBoards Button
        LeaderBoardsButton.setIcon(new ImageIcon("src/Client_Java/res/LeaderBoards.png")); // NOI18N
        LeaderBoardsButton.setBorderPainted(false);
        LeaderBoardsButton.setContentAreaFilled(false);
        LeaderBoardsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeaderBoardsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(LeaderBoardsButton);
        LeaderBoardsButton.setBounds(10, 610, 141, 120);

        //Logout Button
        LogoutButton.setIcon(new ImageIcon("src/Client_Java/res/LogoutBT.png")); // NOI18N
        LogoutButton.setBorderPainted(false);
        LogoutButton.setContentAreaFilled(false);

        getContentPane().add(LogoutButton);
        LogoutButton.setBounds(1210, 10, 120, 50);

        //Background
        this.background.setIcon(new ImageIcon("src/Client_Java/res/Home (1).png"));
        this.getContentPane().add(this.background);
        this.background.setBounds(0, 0, 1360, 760);
        this.pack();
    }

    private void LeaderBoardsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public JButton getLogoutButton() {
        return LogoutButton;
    }

    public JButton getStartGameBT() {
        return startGameBT;
    }

    public JButton getInstructionsBT() {
        return instructionsBT;
    }

    public JButton getLeaderBoardsButton() {
        return LeaderBoardsButton;
    }

    public static void main(String[] args) {
        HomePage home = new HomePage();
        home.displayHome("Rohit");
    }

}
