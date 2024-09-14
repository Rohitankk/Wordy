package Client_Java.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {
  public void displayGame(String username){
      this.setVisible(true);
      initComponents();
      this.username = username;
      UserNameLabel.setText(username);
      ProfileLabel.setText(username);
      this.setSize(1370 ,775);
      setResizable(false);
      repaint();
      validate();
  }

    private void initComponents() {

        jTextField1 = new JTextField();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jButton7 = new JButton();
        jButton8 = new JButton();
        jButton9 = new JButton();
        jButton10 = new JButton();
        jButton11 = new JButton();
        jButton12 = new JButton();
        jButton13 = new JButton();
        jButton14 = new JButton();
        jButton15 = new JButton();
        jButton16 = new JButton();
        jButton17 = new JButton();
        ClearButton = new JButton();
        SendWordButton = new JButton();
        TimeLabel = new JLabel();
        InstructionsButton = new JButton();
        jList1 = new JList<>();
        BackgroundLabel = new JLabel();
        this.ProfileLabel = new javax.swing.JLabel();
        this.UserNameLabel = new javax.swing.JLabel();


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // ProfilePictureLabel
        ProfileLabel.setIcon(new ImageIcon("src/Client_Java/res/Profile.png")); // NOI18N
        getContentPane().add(ProfileLabel);
        ProfileLabel.setBounds(10, 10, 100, 120);

        // Player Name Label
        UserNameLabel.setFont(new java.awt.Font("STXinwei", 0, 48)); // NOI18N
        UserNameLabel.setForeground(new java.awt.Color(255, 204, 0));
        getContentPane().add(UserNameLabel);
        UserNameLabel.setBounds(110, 50, 180, 60);

        jTextField1.setEditable(false);
        jTextField1.setBackground(new Color(227, 192, 48));
        jTextField1.setFont(new Font("SansSerif", 1, 48)); // NOI18N
        jTextField1.setForeground(new Color(68, 56, 29));
        jTextField1.setHorizontalAlignment(JTextField.CENTER);
        jTextField1.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(jTextField1);
        jTextField1.setBounds(420, 130, 450, 100);

        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        getContentPane().add(jButton1);
        jButton1.setBounds(420, 370, 82, 110);

        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        getContentPane().add(jButton2);
        jButton2.setBounds(510, 370, 82, 110);

        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        getContentPane().add(jButton3);
        jButton3.setBounds(600, 370, 82, 110);

        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        getContentPane().add(jButton4);
        jButton4.setBounds(690, 370, 82, 110);

        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        getContentPane().add(jButton5);
        jButton5.setBounds(780, 370, 82, 110);

        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        getContentPane().add(jButton6);
        jButton6.setBounds(870, 370, 82, 110);

        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        getContentPane().add(jButton7);
        jButton7.setBounds(960, 370, 82, 110);

        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        getContentPane().add(jButton8);
        jButton8.setBounds(470, 490, 82, 110);

        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        getContentPane().add(jButton9);
        jButton9.setBounds(560, 490, 82, 110);

        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        getContentPane().add(jButton10);
        jButton10.setBounds(650, 490, 82, 110);

        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        getContentPane().add(jButton11);
        jButton11.setBounds(740, 490, 82, 110);

        jButton12.setBorderPainted(false);
        jButton12.setContentAreaFilled(false);
        getContentPane().add(jButton12);
        jButton12.setBounds(830, 490, 82, 110);

        jButton13.setBorderPainted(false);
        jButton13.setContentAreaFilled(false);
        getContentPane().add(jButton13);
        jButton13.setBounds(920, 490, 82, 110);

        jButton14.setBorderPainted(false);
        jButton14.setContentAreaFilled(false);
        getContentPane().add(jButton14);
        jButton14.setBounds(560, 610, 82, 110);

        jButton15.setBorderPainted(false);
        jButton15.setContentAreaFilled(false);
        getContentPane().add(jButton15);
        jButton15.setBounds(650, 610, 82, 110);

        jButton16.setBorderPainted(false);
        jButton16.setContentAreaFilled(false);
        getContentPane().add(jButton16);
        jButton16.setBounds(740, 610, 82, 110);

        jButton17.setBorderPainted(false);
        jButton17.setContentAreaFilled(false);
        getContentPane().add(jButton17);
        jButton17.setBounds(830, 610, 82, 110);

        ClearButton.setBorderPainted(false);
        ClearButton.setIcon(new ImageIcon("src/Client_Java/res/ClearButton.png")); // NOI18N
        ClearButton.setContentAreaFilled(false);
        ClearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ClearButton);
        ClearButton.setBounds(610, 250, 110, 51);

        SendWordButton.setBorderPainted(false);
        SendWordButton.setIcon(new ImageIcon("src/Client_Java/res/SpellButton.png")); // NOI18N
        SendWordButton.setContentAreaFilled(false);
        getContentPane().add(SendWordButton);
        SendWordButton.setBounds(890, 130, 190, 100);

        TimeLabel.setFont(new Font("Serif", 1, 48)); // NOI18N
        TimeLabel.setForeground(new Color(234, 219, 133));
        TimeLabel.setText("10");
        getContentPane().add(TimeLabel);
        TimeLabel.setBounds(640, 30, 70, 60);

        InstructionsButton.setBorderPainted(false);
        InstructionsButton.setIcon(new ImageIcon("src/Client_Java/res/InstructionsBT.png")); // NOI18N
        InstructionsButton.setContentAreaFilled(false);
        InstructionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                InstructionsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(InstructionsButton);
        InstructionsButton.setBounds(30, 600, 100, 120);

        jList1.setBackground(new Color(102, 88, 168,70));
        jList1.setBorder(null);
        jList1.setFont(new Font("Palatino Linotype", 1, 24)); // NOI18N
        jList1.setForeground(new Color(255, 250, 241));

        BackgroundLabel.setIcon(new ImageIcon("src/Client_Java/res/inGame.png")); // NOI18N
        getContentPane().add(BackgroundLabel);
        BackgroundLabel.setBounds(0, 0, 1370, 740);

        pack();
    }// </editor-fold>

    public JButton[] getLetterButtons(){
        JButton[] letterButtons={jButton1, jButton2, jButton3, jButton4, jButton5, jButton6,
                jButton7,jButton8,jButton9, jButton10,jButton11, jButton12, jButton13, jButton14,
                jButton15,jButton16,jButton17};
        return letterButtons;
    }
    private void ClearButtonActionPerformed(ActionEvent evt) {
        getjTextField1().setText(" ");
    }

    private void InstructionsButtonActionPerformed(ActionEvent evt) {
        dispose();
      Instructions instructions = new Instructions();
      instructions.displayInstructions();
      instructions.getBackBT().addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              instructions.dispose();
              displayGame(username);

          }
      });


    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel UserNameLabel;
    private JLabel BackgroundLabel;
    private JButton ClearButton;
    private JButton InstructionsButton;
    private JButton SendWordButton;
    private JLabel TimeLabel;
    private JButton jButton1;
    private JButton jButton10;
    private JButton jButton11;
    private JButton jButton12;
    private JButton jButton13;
    private JButton jButton14;
    private JButton jButton15;
    private JButton jButton16;
    private JButton jButton17;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;
    private JButton jButton9;
    private JList<String> jList1;
    private JTextField jTextField1;
    private javax.swing.JLabel ProfileLabel;
    private String username;
    // End of variables declaration

    public static void main(String[] args) {
        Game game = new Game();
        game.displayGame("Rohit");
    }


    public JButton getClearButton() {
        return ClearButton;
    }

    public JButton getSendWordButton() {
        return SendWordButton;
    }

    public JLabel getTimeLabel() {
        return TimeLabel;
    }

    public void setTimeLabel(JLabel timeLabel) {
        TimeLabel = timeLabel;
    }
}
