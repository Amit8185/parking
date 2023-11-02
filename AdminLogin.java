import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class AdminLogin extends JFrame{


    Container c;
    JButton btnAdlogin;

    AdminLogin(){
        c= getContentPane();
        setSize(900,600);
        c.setLayout(null);
//    FlowLayout fl = new FlowLayout(FlowLayout.CENTER,30,30);
//     c.setLayout(fl);
     Font f = new Font("Calibri", Font.BOLD,30);
      


  



     JTextField username = new JTextField("Enter Username");
//     username.setBackground(new Color(50,180,140));
        username.setBounds(50,50,300,50);

     JPasswordField password = new JPasswordField("Enter Password....");

      password.setBackground(Color.WHITE);
     password.setBounds(50,150,300,50);


     JButton goback = new JButton("goback");

     goback.setBounds(50,250,100,50);
//     goback.setBackground(new Color(160,180,45));
        goback.setBackground(Color.BLACK);
        goback.setForeground(Color.CYAN);

     JButton loginbtn = new JButton("Login");
     loginbtn.setPreferredSize(new Dimension(300, 60));
    
     loginbtn.setBounds(50,350,100,50);
//     loginbtn.setBackground(new Color(160,180,45));
        loginbtn.setBackground(Color.BLACK);
        loginbtn.setForeground(Color.CYAN);


     c.add(username);
     c.add(password);
     c.add(goback);
     c.add(loginbtn);
     


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

            String sql = "select * from admin where adname='"+name+"' and adpass='"+secret+"'";

            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery(sql);
            if(rs.next()){

                JOptionPane.showMessageDialog(this,"Admin Login Success");
                dispose();
                AdminPage ho = new AdminPage();
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
    ActionListener a2 = (ae)->{
     Signup lg = new Signup();
     dispose();
    };
    goback.addActionListener(a2);


    loginbtn.addActionListener(a1);

    setTitle("PARKING MANAGEMENT SYSTEM");
       // pack();
              //  setExtendedState(JFrame.MAXIMIZED_BOTH);

    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(true);
    setVisible(true);    
  }

}
