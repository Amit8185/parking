import javax.swing.*;
import javax.swing.text.View;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class AddEmployee extends JFrame{

    Container c;
    JLabel LabEid,labEname;
    JTextField txtEid,txtEname;
    JButton btnSave,btnBAck;


    AddEmployee()
    {
        c= getContentPane();
        c.setLayout(null);
        Font f =  new Font("Calibri", Font.BOLD, 30);

        LabEid = new JLabel("enter emp id");
        LabEid.setBounds(250,50,140,50);

        txtEid = new JTextField(15);
        txtEid.setBounds(250,100,140,50);

        labEname=new JLabel("Enter emp");
        labEname.setBounds(250,150,140,50);

        txtEname = new JTextField(15);
        txtEname.setBounds(250,200,140,50);

        btnSave =  new JButton("Add Employee");
        btnSave.setBounds(250,250,140,50);

        btnBAck =  new JButton("Back", null);
        btnBAck.setBounds(250,350,140,50);


        btnSave.setFont(f);
        btnBAck.setFont(f);
        c.add(LabEid);
        c.add(txtEid);
        c.add(labEname);
        c.add(txtEname);
        c.add(btnSave);
        c.add(btnBAck);

        ActionListener a1 =  (ae)->{
            AdminPage a =  new AdminPage();
            dispose();
        };
        btnBAck.addActionListener(a1);
        ActionListener a2 =  (ae)->{
            String username = "root";
            String password = "Amit_2004";
            String url = "jdbc:mysql://localhost:3306/parking";
            try{
                // DriverManager.registerDriver( new com.mysql.cj.jdbc.Driver());
                // String url = "jdbc:mysql://localhost:3306/ems16oct13";

                Connection con  = DriverManager.getConnection(url,username,password);
                String sql = "insert into employee value(?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                int eid = Integer.parseInt(txtEid.getText());
                String ename =  txtEname.getText();
                pst.setInt(1,eid);
                pst.setString(2,ename);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(c," record created");
                txtEid.setText("");
                txtEname.setText("");
                txtEid.requestFocus();
                con.close();

            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(c,e);
            }
        };

        btnSave.addActionListener(a2);
        setTitle("Ems");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);



    }
}