//= +


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class Login extends JFrame
{
    Container c;

    Login()
    {
        c= getContentPane();
        setLayout(null);


        //background


        //login
        JLabel labuser= new JLabel("Username");
        labuser.setBounds(40,20,100,30);
        labuser.setForeground(Color.PINK);
        c.add(labuser);

        JTextField username = new JTextField();
        username.setBounds(150,30,150,30);
        c.add(username);


        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40,60,100,30);
        lblpassword.setForeground(Color.PINK);
        c.add(lblpassword);

        JPasswordField password = new JPasswordField();
        password.setBounds(150,70,150,30);
        c.add(password);

        JButton login = new JButton("Login");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.CYAN);
        c.add(login);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("second.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);
        JButton adminlog = new JButton("Admin Login");
        adminlog.setBounds(150,180,150,30);
        adminlog.setBackground(Color.BLACK);
        adminlog.setForeground(Color.CYAN);
        c.add(adminlog);
        //ActionListener
        ActionListener a1 = (ae)->{


            String un = "root";
            String pass= "Amit_2004";
            String url = "jdbc:mysql://localhost:3306/parking";
            try{
                // DriverManager.registerDriver( new com.mysql.cj.jdbc.Driver());

                Connection con  = DriverManager.getConnection(url,un,pass);
                String name = username.getText();
                String secret = password.getText();

                String sql = "select * from users where uname='"+name+"' and upass='"+secret+"'";

                Statement pst = con.createStatement();
                 ResultSet rs = pst.executeQuery(sql);
//                   if (username.equals("") || secret.length() < 8 || !secret.matches(".*[A-Z].*") || !secret.matches(".*[^A-Za-z0-9].*")) {
//                    JOptionPane.showMessageDialog(c, "Invalid username or password!");
//                       username.setText("");
//                       password.setText("");
//                }
                 if(rs.next()){

                    JOptionPane.showMessageDialog(this,"Login Success");
                    dispose();
                    Home ho = new Home();
                              }else{
                    JOptionPane.showMessageDialog(this," Wrong entry");
                      username.setText("");
                      password.setText("");
                }

              con.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(c,e);
            }

        };

        ActionListener a3= (ae)->{
            AdminLogin al = new AdminLogin();
            dispose();
        };


        login.addActionListener(a1);

        adminlog.addActionListener(a3);
        setTitle("PARKING MANAGEMENT SYSTEM");
        // pack();
        //  setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(600,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);

    }
}