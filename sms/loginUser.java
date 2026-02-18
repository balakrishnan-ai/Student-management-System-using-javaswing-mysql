package sms;

private void loginUser() {
    String username = usernameField.getText();
    String password = new String(passwordField.getPassword());

    try {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT role FROM users WHERE username=? AND password=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();
        if(rs.next()) {

            String role = rs.getString("role");

            JOptionPane.showMessageDialog(this, "Login successful as " + role);
            dispose();

            if(role.equals("ADMIN")) {
                new AdminDashboard().setVisible(true);
            }
            else if(role.equals("STAFF")) {
                new StaffDashboard().setVisible(true);
            }
            else if(role.equals("STUDENT")) {
                new StudentDashboard().setVisible(true);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password!");
        }

        con.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
