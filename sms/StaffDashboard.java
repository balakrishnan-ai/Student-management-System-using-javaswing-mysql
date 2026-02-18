package sms;



import javax.swing.*;

public class StaffDashboard extends JFrame {

    public StaffDashboard() {

        setTitle("Staff Dashboard");
        setSize(400,250);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton viewStudents = new JButton("View Students");
        viewStudents.setBounds(100,80,200,30);
        add(viewStudents);

        viewStudents.addActionListener(e -> new ViewStudents().setVisible(true));
    }
}
