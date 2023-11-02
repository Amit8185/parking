//= +

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class SplashWindow extends JFrame
{
    
   Container c;

   JLabel lab;
   SplashWindow()
   {
     MyPanel panel = new MyPanel();
     add(panel);
    c= getContentPane();
    c.setLayout(new FlowLayout());
//    c.setBackground(new Color(0,0,0));


    setUndecorated(true);
    setSize(800,700);
    setLocationRelativeTo(null);
    setVisible(true);

      try{
          Thread.sleep(4000);
          dispose();
          Login l = new Login();
      } catch(Exception e){
        System.out.println("issue"+ e);  
      }
    }

    public class MyPanel extends JPanel implements ActionListener{
        final int PANEL_WIDTH = 900;
        final int PANEL_HEIGHT =  800;
         Image car;
        Timer timer;
        int xVelocity= 5;
        int yVelocity= 2;
        int x= 1;
        int y= 200;
        

      MyPanel(){
       
        setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        car = new ImageIcon("sedan.png").getImage();

        timer = new Timer(5,this);
        timer.start();


    }

    public void paint(Graphics g){
      super.paint(g);
      Graphics g2D = (Graphics2D) g;
      
      g2D.drawImage(car,x,y,null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub4
    
      if(x>= PANEL_WIDTH){
        x = 1;
      }
      x = x + xVelocity;
      repaint();
    } 

 

    }
    
 
 }


