import com.mysql.cj.jdbc.Driver;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.sql.*;

class Booknow extends JFrame{

    Container c;
    JButton btnDone, btnback;

    Booknow()
    {
       c= getContentPane();
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER,30,30);
        c.setLayout(fl);

       //panel
       JPanel vehicle = new JPanel();
       vehicle.setBackground(new Color(0,0,0,70));
       vehicle.setPreferredSize(new Dimension(350, 400));


         JLabel label1 =  new JLabel("Enter Vehicle number");
         vehicle.add(label1);
       JTextField vehinum = new JTextField("");

//       vehinum.setEditable(false);
       vehinum.setPreferredSize(new Dimension(300, 60));
      //  vehicle.add(label1);
       vehicle.add(vehinum);
        //  JLabel label2 =  new JLabel("Enter make and model");
       String[] vehi = {"twowheeler","Fourwheeler","Bus","Truck"};
       JComboBox comboBox= new JComboBox(vehi);
       comboBox.setPreferredSize(new Dimension(300,60));
       vehicle.add(comboBox);


        btnDone = new JButton("Done!!");
        vehicle.add(btnDone);
        //button
         btnback = new JButton("Go back");
          vehicle.add(btnback);
        //actionlistenr

        ActionListener a1 =(ae)->{
            Home h = new Home();
            dispose();
        };
       btnback.addActionListener(a1);
        ActionListener a2 = (ae)->{
            String un = "root";
            String pass= "Amit_2004";
            String url = "jdbc:mysql://localhost:3306/parking";
            try{
                 DriverManager.registerDriver( new Driver());
                // String url = "jdbc:mysql://localhost:3306/ems16oct13";

                Connection con  = DriverManager.getConnection(url,un,pass);

                String sql = "insert into vehicles value(?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                String name = vehinum.getText();
                String model = comboBox.getSelectedItem().toString();
                pst.setString(1,name);
                pst.setString(2,model);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(c," record created");
                vehinum.setText("");
//                comboBox.setSelectedIndex(0);
//                Statement pst = con.createStatement();
//                ResultSet rs = pst.executeQuery(sql);
//                if(rs.next()){
//
//
//                    dispose();
//                    Home h = new Home();
//                }else{
//                    JOptionPane.showMessageDialog(this," Wrong entry");
//                    vehinum.setText("");
//                    comboBox.setSelectedIndex(0);
//                }

                con.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(c,e);
            }

        };
        btnDone.addActionListener(a2);
        //Payment portal
        //Inside Booknow class

        JComboBox paymentMode;
        JTextField amountField;
        JButton payButton, printButton;



        //Existing code

        //Payment mode options
        String[] options = {"Cash", "UPI", "Card"};
        paymentMode = new JComboBox(options);

        //Label and text field for amount
        JLabel label = new JLabel("Enter Amount:");
        amountField = new JTextField(10);

        //Pay button
        payButton = new JButton("Pay");
        payButton.addActionListener(e -> {
            //Payment logic
            String mode = (String)paymentMode.getSelectedItem();
            double amount = Double.parseDouble(amountField.getText());

            JOptionPane.showMessageDialog(this, "Payment of Rs."+amount+" via "+mode+" successful!");
        });

        //Print button
        printButton = new JButton("Print Receipt");
        printButton.addActionListener(e -> {
            //Print receipt logic
        });

        //Add to panel
        vehicle.add(label);
        vehicle.add(amountField);
        vehicle.add(paymentMode);
        vehicle.add(payButton);
//        vehicle.add(printButton);



//Update done button action
        btnDone.addActionListener(e -> {

            //Existing code

            //Show payment controls
            payButton.setVisible(true);
            printButton.setVisible(true);

        });









        c.add(vehicle);
        c.add(vehicle,BorderLayout.CENTER);
       setTitle("PARKING MANAGEMENT SYSTEM");

       setSize(900,600);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setResizable(true);
       setVisible(true);

    }
}