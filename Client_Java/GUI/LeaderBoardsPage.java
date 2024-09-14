package Client_Java.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LeaderBoardsPage extends JFrame {
    public void displayLeaderBoards(){
        this.setVisible(true);
        initComponents();
        this.setSize(1360, 790);
        setResizable(false);
        repaint();
        validate();

    }
    // Variables declaration - do not modify
    private javax.swing.JButton BackButton;
    private javax.swing.JTable LongestWordTable;
    private javax.swing.JTable MostWinsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration

    public void fillTables(String[][] mostWins, String[][] longestWords) {
        String[] winsColumns = {"Name", "Wins"};
        String[] wordColumns = {"Name", "Longest Word"};

        DefaultTableModel model = new DefaultTableModel(mostWins, winsColumns);
        LongestWordTable = new JTable(model);
        LongestWordTable.setBackground(new java.awt.Color(71, 22, 168));
        LongestWordTable.setFont(new java.awt.Font("STXinwei", Font.BOLD, 24));
        LongestWordTable.setForeground(Color.white);
        LongestWordTable.setRowHeight(60);
        LongestWordTable.setGridColor(new java.awt.Color(51, 51, 51));

        jScrollPane1 = new JScrollPane(LongestWordTable);
        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(120, 360, 450, 360);

        DefaultTableModel model2 = new DefaultTableModel(longestWords, wordColumns);
        MostWinsTable = new JTable(model2);
        MostWinsTable.setBackground(new java.awt.Color(255, 189, 89));
        MostWinsTable.setFont(new java.awt.Font("STXinwei", Font.BOLD, 24));
        MostWinsTable.setForeground(Color.white);
        MostWinsTable.setRowHeight(60);
        MostWinsTable.setGridColor(new java.awt.Color(51, 51, 51));

        jScrollPane2 = new JScrollPane(MostWinsTable);
        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(790, 360, 452, 360);
    }

    public void initComponents() {
        BackButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        BackButton.setIcon(new ImageIcon("src/Client_Java/res/backBT.png")); // NOI18N
        BackButton.setBorderPainted(false);
        BackButton.setContentAreaFilled(false);
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BackButton);
        BackButton.setBounds(1230, 10, 120, 60);

        jLabel1.setIcon(new ImageIcon("src/Client_Java/res/LeaderBoardsBG.png")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1360, 760);

        pack();
        setLocationRelativeTo(null);
    }
    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public JButton getBackButton() {
        return BackButton;
    }

    public static void main(String[] args) {
        LeaderBoardsPage l = new LeaderBoardsPage();
        String[][] w = {{"Rohit","Wassup"},{"Melody","What"},{"JohnRex","Gir"}};
        l.fillTables(w,w);
        l.initComponents();
        l.displayLeaderBoards();
    }
}

