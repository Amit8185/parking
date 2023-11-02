import com.mysql.cj.jdbc.Driver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class Delete extends JFrame{

    Container c;

    Delete(){
        c= getContentPane();
        setSize(900,600);
        setLayout(null);

        JLabel label =  new JLabel("Delete employee Record");
        label.setBounds(50,50,100,50);
        JTextField username = new JTextField("Enter employee id");
        username.setBounds(50,150,100,50);
        JButton payment = new JButton("Delete");
        payment.setBounds(50,250,100,50);

        JButton goback = new JButton("goback");
        goback.setBounds(50,450,100,50);

        c.add(label);
        c.add(username);
        c.add(payment);
        c.add(goback);

        ActionListener a1 = (ae)->{
            String un = "root";
            String pass= "Amit_2004";
            String url = "jdbc:mysql://localhost:3306/parking";
            try{
                DriverManager.registerDriver( new Driver());
                // String url = "jdbc:mysql://localhost:3306/ems16oct13";

                Connection con  = DriverManager.getConnection(url,un,pass);
                String name = username.getText();
                String sql = "delete from employee where eid=?";

                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1,name);
                int count = ps.executeUpdate();
                if(count>0){

                    JOptionPane.showMessageDialog(this,"Deletion successfull");


//                    dispose();
//                    Home h = new Home();
                }else{
                    JOptionPane.showMessageDialog(this," Wrong entry");
                    username.setText("");
                }

                con.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(c,e);
            }

        };
        payment.addActionListener(a1);
        ActionListener a2 = (ae)->{
            AdminPage ap= new AdminPage();
            dispose();
        };
        goback.addActionListener(a2);
        setTitle("PARKING MANAGEMENT SYSTEM");
        // pack();
        //  setExtendedState(JFrame.MAXIMIZED_BOTH);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
    }
}