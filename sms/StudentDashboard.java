package sms;

package sms;

import javax.swing.*;

public class StudentDashboard extends JFrame {

    public StudentDashboard() {

        setTitle("Student Dashboard");
        setSize(400,200);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Welcome Student!");
        label.setBounds(120,70,200,30);
        add(label);
    }
}
