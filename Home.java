import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Home extends JFrame
{
    Container c;
    JButton btnPark, btnView ,btnLogout,btnProfile, btnBook;
    JLabel background;
    Home()
    {
        c= getContentPane();
        c.setLayout(null);
//        c.setBackground(new Color(178,190,181));

//        btnPark = new JButton("Available Space ");
//        btnPark.setBounds(250,100,150,100);
        btnBook = new JButton("Book Now !!");
        btnBook.setBounds(100,100,150,100);
        btnBook.setBackground(Color.BLACK);
        btnBook.setForeground(Color.CYAN);
        btnView = new JButton("Exit Parking");
        btnView.setBounds(100,250,150,100);
        btnView.setBackground(Color.BLACK);
        btnView.setForeground(Color.CYAN);
//        c.add(btnPark);
        c.add(btnBook);
        c.add(btnView);
        btnLogout= new JButton("LOGOUT ");
        btnLogout.setBounds(100,400,150,100);
        btnLogout.setBackground(Color.BLACK);
        btnLogout.setForeground(Color.CYAN);
        c.add(btnLogout);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550,200,200,200);
        add(image);




        Font f = new Font("Calibri", Font.BOLD,30);
//        btnPark.setFont(f);
//        btnBook.setFont(f);
//        btnView.setFont(f);
          
       //actionlistener
        ActionListener a1 =(ae)->{
            dispose();
            Booknow bn = new Booknow();

        };
//        ActionListener a2 =(ae)->{
//            Parking bn = new Parking();
//            dispose();
//        };
        ActionListener a3 =(ae)->{
            Records bn = new Records();
            dispose();
        };
       btnBook.addActionListener(a1);
//       btnPark.addActionListener(a2);
       btnView.addActionListener(a3);


        ActionListener a4 = (ae)->{
            Signup h= new Signup();
            dispose();
           };
           btnLogout.addActionListener(a4);
        pack();
    
       
        setTitle("PARKING MANAGEMENT SYSTEM");
        setSize(900,600);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);

    }

  
}