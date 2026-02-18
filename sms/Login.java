package sms;

import javax.swing.*;
import java.sql.*;

public class Login extends JFrame {

    JTextField usernameField;
    JPasswordField passwordField;

    public Login() {

        setTitle("Login");
        setSize(350,250);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel user = new JLabel("Username:");
        user.setBounds(30,40,100,25);
        add(user);

        usernameField = new JTextField();
        usernameField.setBounds(130,40,150,25);
        add(usernameField);

        JLabel pass = new JLabel("Password:");
        pass.setBounds(30,80,100,25);
        add(pass);

        passwordField = new JPasswordField();
        passwordField.setBounds(130,80,150,25);
        add(passwordField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(130,130,100,30);
        add(loginBtn);

        JButton signupBtn = new JButton("Signup");
        signupBtn.setBounds(130,170,100,30);
        add(signupBtn);

        loginBtn.addActionListener(e -> loginUser());
        signupBtn.addActionListener(e -> {
            dispose();
            new Signup().setVisible(true);
        });
    }

    private void loginUser() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT role FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, usernameField.getText());
            ps.setString(2, new String(passwordField.getPassword()));

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                String role = rs.getString("role");
                JOptionPane.showMessageDialog(this,"Login as " + role);
                dispose();

                if(role.equals("ADMIN"))
                    new AdminDashboard().setVisible(true);

                else if(role.equals("STAFF"))
                    new StaffDashboard().setVisible(true);

                else if(role.equals("STUDENT"))
                    new StudentDashboard().setVisible(true);

            } else {
                JOptionPane.showMessageDialog(this,"Invalid Credentials");
            }

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
