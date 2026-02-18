package sms;



import javax.swing.*;
import java.sql.*;

public class AddStudent extends JFrame {

    JTextField name,email,course;

    public AddStudent() {

        setTitle("Add Student");
        setSize(350,300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel l1 = new JLabel("Name:");
        l1.setBounds(30,30,100,25);
        add(l1);

        name = new JTextField();
        name.setBounds(130,30,150,25);
        add(name);

        JLabel l2 = new JLabel("Email:");
        l2.setBounds(30,70,100,25);
        add(l2);

        email = new JTextField();
        email.setBounds(130,70,150,25);
        add(email);

        JLabel l3 = new JLabel("Course:");
        l3.setBounds(30,110,100,25);
        add(l3);

        course = new JTextField();
        course.setBounds(130,110,150,25);
        add(course);

        JButton save = new JButton("Save");
        save.setBounds(130,160,100,30);
        add(save);

        save.addActionListener(e -> saveStudent());
    }

    private void saveStudent() {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO students(name,email,course) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,name.getText());
            ps.setString(2,email.getText());
            ps.setString(3,course.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,"Student Added");
            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
