import com.mysql.cj.jdbc.Driver;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class View extends JFrame{

    Container c;

    View(){
        c= getContentPane();
        setSize(900,600);
        setLayout(null);

        JLabel label =  new JLabel("Vehicle Records");
        label.setBounds(350,50,100,50);


      JTable table = new JTable();
        table.setBounds(250,100,400,250);
        c.add(table);

        JButton display = new JButton("Display");
        display.setBounds(350,350,100,50);

        JButton goback = new JButton("goback");
        goback.setBounds(350,450,100,50);

        c.add(label);

        c.add(display);

        c.add(goback);

        ActionListener a1 = (ae)-> {
            String un = "root";
            String pass = "Amit_2004";
            String url = "jdbc:mysql://localhost:3306/parking";
            try {


                Connection con = DriverManager.getConnection(url, un, pass);
                Statement st = con.createStatement();

                String sql = "select * from vehicles";

                ResultSet rs = st.executeQuery(sql);

                ResultSetMetaData rsmd= rs.getMetaData();

                DefaultTableModel model = (DefaultTableModel) table.getModel();

                int cols = rsmd.getColumnCount();
                String[] colName= new String[cols];
                for(int i=0;i<cols;i++)
                    colName[i]=rsmd.getColumnName(i+1);
                model.setColumnIdentifiers(colName);


                while (rs.next()){
                    String vnum = rs.getString("vnum");
                    String type = rs.getString("type");

                    String tbData[]={vnum,type};
                   model.addRow(tbData);
                }

            con.close();
        }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(c,e);
            }

        };
        display.addActionListener(a1);
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