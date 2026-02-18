package sms;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewStudents extends JFrame {

    JTable table;
    DefaultTableModel model;

    public ViewStudents() {

        setTitle("View Students");
        setSize(500,400);
        setLocationRelativeTo(null);

        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Course");

        table = new JTable(model);
        add(new JScrollPane(table));

        loadData();
    }

    private void loadData() {

        try {
            Connection con = DBConnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM students");

            while(rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("course")
                });
            }

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
