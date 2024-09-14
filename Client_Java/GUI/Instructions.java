package Client_Java.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instructions extends JFrame {
    private JButton backBT;
    private JLabel jLabel1;

    public void displayInstructions(){
        this.setVisible(true);
        initComponents();
        this.setSize(1305, 800);
        setResizable(false);
        repaint();
        validate();

    }
    private void initComponents() {

        this.backBT = new JButton();
        this.jLabel1 = new JLabel();

        this.getContentPane().setLayout((LayoutManager)null);

        this.backBT.setIcon(new ImageIcon("src/Client_Java/res/backBT.png")); // NOI18N
        this.backBT.setBorderPainted(false);
        this.backBT.setContentAreaFilled(false);
        this.getContentPane().add(backBT);
        this.backBT.setBounds(1020, 170,120, 70);
        this.backBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        this.jLabel1.setIcon(new ImageIcon("src/Client_Java/res/InstructionsPage.png")); // NOI18N
        this.getContentPane().add(jLabel1);
        this.jLabel1.setBounds(0, 0, 1290, 770);
    }

    public JButton getBackBT() {
        return backBT;
    }



}
