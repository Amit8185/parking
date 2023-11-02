import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class AdminPage extends JFrame{

    Container c;

    AdminPage(){
        c= getContentPane();
        setSize(900,700);
        c.setLayout(null);

        JLabel label =  new JLabel("Admin page");
        label.setBounds(450,50,140,50);
         c.add(label);




           JButton delete = new JButton("delete employee");
        delete.setBounds(250,150,140,50);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.CYAN);

           JButton addEmp = new JButton("Add Employee");
        addEmp.setBounds(250,250,140,50);
        addEmp.setBackground(Color.BLACK);
        addEmp.setForeground(Color.CYAN);

        JButton goback = new JButton("Logout");
        goback.setBounds(250,350,140,50);
        goback.setBackground(Color.BLACK);
        goback.setForeground(Color.CYAN);

        JButton viewrecords = new JButton("View records");
        viewrecords.setBounds(250,450,140,50);
        viewrecords.setBackground(Color.BLACK);
        viewrecords.setForeground(Color.CYAN);



         c.add(label);
         c.add(goback);

         c.add(addEmp);
         c.add(viewrecords);

         c.add(delete);
        ActionListener a1 = (ae)->{
            AddEmployee al= new AddEmployee();
            dispose();
        };
        addEmp.addActionListener(a1);
         ActionListener a2 = (ae)->{
            AdminLogin al= new AdminLogin();
                    dispose();
           };
           goback.addActionListener(a2);

        ActionListener a3 = (ae)->{
            Delete d= new Delete();
            dispose();
        };
        delete.addActionListener(a3);

        ActionListener a4 = (ae)->{
            View v= new View();
            dispose();
        };
        viewrecords.addActionListener(a4);


        setTitle("PARKING MANAGEMENT SYSTEM");
       // pack();
              //  setExtendedState(JFrame.MAXIMIZED_BOTH);

    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(true);
    setVisible(true);

    }
}