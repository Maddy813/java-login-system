import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;

public class LoginGUI extends JFrame {

    AuthService auth = new AuthService();

    JTextField usernameField;
    JPasswordField passwordField;
    JLabel messageLabel;

    public LoginGUI() {

        setTitle("Login Authentication System");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton registerBtn = new JButton("Register");
        JButton loginBtn = new JButton("Login");

        panel.add(registerBtn);
        panel.add(loginBtn);

        messageLabel = new JLabel("", JLabel.CENTER);
        panel.add(messageLabel);

        add(panel);

        // REGISTER BUTTON
        registerBtn.addActionListener(e -> {
            String user = usernameField.getText();
            String pass = new String(passwordField.getPassword());

            auth.register(user, pass);
            messageLabel.setText("Registered (check console)");
        });

        // LOGIN BUTTON
        loginBtn.addActionListener(e -> {
            String user = usernameField.getText();
            String pass = new String(passwordField.getPassword());

            if (auth.login(user, pass)) {
                JOptionPane.showMessageDialog(this,
                        "Welcome to Secured Page!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Invalid Credentials!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        new LoginGUI().setVisible(true);
    }
}
