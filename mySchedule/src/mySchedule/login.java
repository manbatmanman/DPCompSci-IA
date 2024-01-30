package mySchedule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class login {

    private JFrame frame;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private HashMap<String, String> credentials;

    public static void main(String[] args) {
        login app = new login();
    }

    public login() {
        frame = new JFrame("mySchedule");
        mainPanel = new JPanel(new CardLayout());
        cardLayout = (CardLayout) mainPanel.getLayout();
        credentials = new HashMap<>();

        // Setup Login Panel
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setBackground(Color.decode("#ADD8E6"));  // Light Blue background

        JLabel title = new JLabel("mySchedule");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.BLACK);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel fieldsPanel = new JPanel(new GridLayout(3, 2));
        final JTextField usernameField = new JTextField(10);  // Reduced size
        final JPasswordField passwordField = new JPasswordField(10);  // Reduced size
        passwordField.setEchoChar('•');
        
        JButton loginButton = new JButton("Login");
        JButton signupSwitchButton = new JButton("Sign Up");
        signupSwitchButton.addActionListener(e -> cardLayout.show(mainPanel, "Signup"));

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
         // Inside your login ActionListener in the login class
            if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
                JOptionPane.showMessageDialog(frame, "Login successful!");
                new Menu();  // Transition to Menu
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password.");
            }

        });

        fieldsPanel.add(new JLabel("Username: "));
        fieldsPanel.add(usernameField);
        fieldsPanel.add(new JLabel("Password: "));
        fieldsPanel.add(passwordField);
        fieldsPanel.add(loginButton);
        fieldsPanel.add(signupSwitchButton);

        loginPanel.add(title);
        loginPanel.add(fieldsPanel);

        // Setup Signup Panel
        JPanel signupPanel = new JPanel(new GridLayout(3, 2));
        signupPanel.setBackground(Color.decode("#ADD8E6"));  // Light Blue background
        JTextField newUsernameField = new JTextField(10);  // Reduced size
        JPasswordField newPasswordField = new JPasswordField(10);  // Reduced size
        newPasswordField.setEchoChar('•');
        
        JButton signupButton = new JButton("Sign Up");
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newUsername = newUsernameField.getText();
                String newPassword = new String(newPasswordField.getPassword());
                credentials.put(newUsername, newPassword);
                cardLayout.show(mainPanel, "Login");
            }
        });

        signupPanel.add(new JLabel("New Username: "));
        signupPanel.add(newUsernameField);
        signupPanel.add(new JLabel("New Password: "));
        signupPanel.add(newPasswordField);
        signupPanel.add(new JLabel(""));
        signupPanel.add(signupButton);

        // Main panel and frame setup
        mainPanel.add(loginPanel, "Login");
        mainPanel.add(signupPanel, "Signup");
        cardLayout.show(mainPanel, "Login");
        
        frame.setLayout(new BorderLayout());
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setVisible(true);

}
}
