import com.mysql.cj.jdbc.Driver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class Records extends JFrame{

    Container c;
    
    Records(){
        c= getContentPane();
        setSize(900,600);
//        c.setBackground(new Color(178,190,181));
        setLayout(null);

        JLabel label =  new JLabel("Exit parking");
        label.setBounds(50,50,100,50);
        JTextField username = new JTextField("Enter Vehile Number");
        username.setBackground(Color.BLACK);
        username.setForeground(Color.CYAN);
        username.setBounds(50,150,100,50);
        JButton payment = new JButton("Pay bill");
        payment.setBackground(Color.BLACK);
        payment.setForeground(Color.CYAN);
        payment.setBounds(50,250,100,50);

        JButton goback = new JButton("goback");
        goback.setBackground(Color.BLACK);
        goback.setForeground(Color.CYAN);
        goback.setBounds(50,450,100,50);

        c.add(label);
        c.add(username);
        c.add(payment);
        c.add(goback);

        //payment portal



        ActionListener a1 = (ae)->{
            String un = "root";
            String pass= "Amit_2004";
            String url = "jdbc:mysql://localhost:3306/parking";
            try{
                DriverManager.registerDriver( new Driver());
                // String url = "jdbc:mysql://localhost:3306/ems16oct13";

                Connection con  = DriverManager.getConnection(url,un,pass);
                String name = username.getText();
                String sql = "delete from vehicles where vnum=?";

                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1,name);
                int count = ps.executeUpdate();
                if(count>0){

                    JOptionPane.showMessageDialog(this,"Exit successfull");


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
            Home h= new Home();
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