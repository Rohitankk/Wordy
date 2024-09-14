package Client_Java.GUI;

import javax.swing.*;

public class LoginPage extends JFrame {

        public void displayLogin(){
        this.initComponents();
        setSize(1350,800);
        setName("Login");
        setVisible(true);
        this.setResizable(false);
        validate();
    }
        private void initComponents() {

            userNameTF = new JTextField();
            passwordTF = new JPasswordField();
            passwordErrorLabel = new JLabel();
            UserNameErrorLabel = new JLabel();
            LoginButton = new JButton();
            backgroundLabel = new JLabel();

            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            getContentPane().setLayout(null);

            userNameTF.setBackground(new java.awt.Color(240, 231, 155));
            getContentPane().add(userNameTF);
            userNameTF.setBounds(680, 400, 300, 40);

            passwordTF.setBackground(new java.awt.Color(240, 231, 155));

            getContentPane().add(passwordTF);
            passwordTF.setBounds(680, 510, 300, 40);

            passwordErrorLabel.setForeground(new java.awt.Color(255, 51, 51));
            getContentPane().add(passwordErrorLabel);
            passwordErrorLabel.setBounds(680, 550, 190, 30);

            UserNameErrorLabel.setBackground(new java.awt.Color(255, 255, 0));
            UserNameErrorLabel.setForeground(new java.awt.Color(255, 51, 51));
            getContentPane().add(UserNameErrorLabel);
            UserNameErrorLabel.setBounds(680, 450, 180, 16);

            LoginButton.setIcon(new ImageIcon("src/Client_Java/res/LoginButton.png"));
            this.LoginButton.setBorderPainted(false);
            this.LoginButton.setContentAreaFilled(false);
            getContentPane().add(LoginButton);
            LoginButton.setBounds(750, 600, 180, 90);

            backgroundLabel.setIcon(new ImageIcon("src/Client_Java/res/LoginPage.png"));
            getContentPane().add(backgroundLabel);
            backgroundLabel.setBounds(0, -240, 1360, 1250);

            pack();
        }// </editor-fold>

        // Variables declaration - do not modify
        private JButton LoginButton;
        private JLabel UserNameErrorLabel;
        private JLabel backgroundLabel;
        private JLabel passwordErrorLabel;
        private JPasswordField passwordTF;
        private JTextField userNameTF;
        // End of variables declaration


    public JButton getLoginButton() {
        return LoginButton;
    }

    public JLabel getPasswordErrorLabel() {
        return passwordErrorLabel;
    }

    public JPasswordField getPasswordTF() {
        return passwordTF;
    }

    public JTextField getUserNameTF() {
        return userNameTF;
    }

    public JLabel getUserNameErrorLabel() {
        return UserNameErrorLabel;
    }

    public JLabel getBackgroundLabel() {
        return backgroundLabel;
    }

}
