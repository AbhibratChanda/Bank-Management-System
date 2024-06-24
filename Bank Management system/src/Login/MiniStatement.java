package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MiniStatement extends JFrame implements ActionListener {
    String pinnumber;
    JButton back;

    MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(910, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);

        JLabel mini = new JLabel("Indian Bank");
        mini.setForeground(Color.white);
        mini.setFont(new Font("System", Font.BOLD, 16));
        image.add(mini);
        mini.setBounds(20,140,400,200);

        JLabel bank = new JLabel("Indian Bank");
        bank.setForeground(Color.white);
        bank.setBounds(230, 220, 400, 30);
        bank.setFont(new Font("System", Font.BOLD, 16));
        image.add(bank);

        JLabel card = new JLabel("Indian Bank");
        card.setForeground(Color.white);
        card.setBounds(230, 220, 400, 30);
        card.setFont(new Font("System", Font.BOLD, 16));
        image.add(card);

        back=new JButton("Back");
        back.setBounds(350,410,130,25);
        back.addActionListener(this);
        image.add(back);

        try {
            Conn conn = new Conn();
           ResultSet rs= conn.s.executeQuery("select * from login where pin='" + pinnumber +"'");
            while (rs.next()) {
                card.setText("card number:" + rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try{
            Conn conn=new Conn();
            int bal=0;
            ResultSet rs=conn.s.executeQuery("select * from login where pin='" + pinnumber +"'");
                    while(rs.next()){
                        mini.setText(mini.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("mode") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                        if (rs.getString("type").equals("Deposit")){
                            bal+=Integer.parseInt(rs.getString("amount"));
                        }else {
                            bal-=Integer.parseInt(rs.getString("amount"));
                        }
                    }
        }catch (Exception ae){
            System.out.println(ae);
        }
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }


        @Override
        public void actionPerformed (ActionEvent e){
        if (e.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }

        }

    public static void main(String[] args) {
        new MiniStatement("");
    }
    }
