package sms;

//package sms;

import javax.swing.*;

public class AdminDashboard extends JFrame {

    public AdminDashboard() {

        setTitle("Admin Dashboard");
        setSize(400,300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton addStudent = new JButton("Add Student");
        addStudent.setBounds(100,40,200,30);
        add(addStudent);

        JButton addStaff = new JButton("Add Staff");
        addStaff.setBounds(100,90,200,30);
        add(addStaff);

        JButton viewStudents = new JButton("View Students");
        viewStudents.setBounds(100,140,200,30);
        add(viewStudents);

        addStudent.addActionListener(e -> new AddStudent().setVisible(true));
        addStaff.addActionListener(e -> new AddStaff().setVisible(true));
        viewStudents.addActionListener(e -> new ViewStudents().setVisible(true));
    }
}
