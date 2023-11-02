//= +


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class Signup extends JFrame
{
 Container c;

 Signup()
 {
  c= getContentPane();
  setLayout(null);


  //background


  //login
  JLabel labuser= new JLabel("Set Username");
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

  JLabel lblpassword2 = new JLabel("Enter Password Again");
  lblpassword.setBounds(40,60,100,30);
  lblpassword.setForeground(Color.PINK);
  c.add(lblpassword);

  JPasswordField password2 = new JPasswordField();
  password.setBounds(150,70,150,30);
  c.add(password);

  JButton signup = new JButton("Signup");
  signup.setBounds(150,140,150,30);
  signup.setBackground(Color.BLACK);
  signup.setForeground(Color.CYAN);
  c.add(signup);
  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("second.png"));
  Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
  ImageIcon i3 = new ImageIcon(i2);
  JLabel image = new JLabel(i3);
  image.setBounds(350,0,200,200);
  add(image);


  //ActionListener
  ActionListener a1 = (ae)->{


   String un = "root";
   String pass= "Amit_2004";
   String url = "jdbc:mysql://localhost:3306/parking";
   try {
    // DriverManager.registerDriver( new com.mysql.cj.jdbc.Driver());

    Connection con = DriverManager.getConnection(url, un, pass);
    String sql = "insert into users value(?,?)";


    PreparedStatement pst = con.prepareStatement(sql);
    String user = labuser.getText();
    String secret = "";
    if (lblpassword2 == lblpassword) {
     secret = lblpassword.getText();
    }
    if (username.equals("") || secret.length() < 8 || !secret.matches(".*[A-Z].*") || !secret.matches(".*[^A-Za-z0-9].*")) {
     JOptionPane.showMessageDialog(c, "Invalid username or password!");
     username.setText("");
     password.setText("");
    }
    pst.setString(1,user);
    pst.setString(2,secret);
    pst.executeUpdate();
    JOptionPane.showMessageDialog(c," user created");
    ResultSet rs = pst.executeQuery(sql);

    dispose();
    Login l = new Login();
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


  signup.addActionListener(a1);

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