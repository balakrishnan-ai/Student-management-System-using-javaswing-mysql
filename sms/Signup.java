package sms;

import javax.swing.*;
import java.sql.*;

public class Signup extends JFrame {

    JTextField usernameField;
    JPasswordField passwordField;
    JComboBox<String> roleBox;

    public Signup() {

        setTitle("Signup");
        setSize(350,300);
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

        JLabel role = new JLabel("Role:");
        role.setBounds(30,120,100,25);
        add(role);

        roleBox = new JComboBox<>(new String[]{"ADMIN","STAFF","STUDENT"});
        roleBox.setBounds(130,120,150,25);
        add(roleBox);

        JButton signupBtn = new JButton("Signup");
        signupBtn.setBounds(130,170,100,30);
        add(signupBtn);

        signupBtn.addActionListener(e -> signupUser());
    }

    private void signupUser() {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO users(username,password,role) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, usernameField.getText());
            ps.setString(2, new String(passwordField.getPassword()));
            ps.setString(3, roleBox.getSelectedItem().toString());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,"Signup Successful");
            dispose();
            new Login().setVisible(true);

            con.close();

        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this,"Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    // ✅ MAIN METHOD ADDED
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }
}
