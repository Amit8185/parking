import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Parking extends JFrame{

    Container c;
    
    Parking(){
        c= getContentPane();
        setSize(900,600);
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER,30,30);
        c.setLayout(fl);

        JLabel label =  new JLabel("PARKING LOCATIONS");
        JButton goback = new JButton("goback");
        goback.setPreferredSize(new Dimension(300, 60));
        goback.setBounds(50,250,100,50);
        goback.setBackground(new Color(160,180,45));

         c.add(label);
         c.add(goback);
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