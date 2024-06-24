
package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class fastcash extends JFrame implements ActionListener {
    JButton exit,withdrawl,fast,pin,mini,Balance,deposit;
    String pinnumber;
    fastcash(String pinnumber) {
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(910,750, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,700);
        add(image);
        JLabel text=new JLabel("Please Select your Transaction");
        text.setBounds(230,220,400,30);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        deposit=new JButton("Rs 1000");
        deposit.setBounds(170,320,130,25);
        image.add(deposit);
        deposit.addActionListener(this);

        fast=new JButton("Rs 2000");
        fast.setBounds(170,350,130,25);
        image.add(fast);
        fast.addActionListener(this);

        pin=new JButton("Rs 5000");
        pin.setBounds(170,380,130,25);
        image.add(pin);
        pin.addActionListener(this);

        withdrawl=new JButton("Rs 10000");
        withdrawl.setBounds(350,320,130,25);
        image.add(withdrawl);
        withdrawl.addActionListener(this);

        mini=new JButton("Rs 15000");
        mini.setBounds(350,350,130,25);
        image.add(mini);
        mini.addActionListener(this);

        Balance=new JButton("Rs 20000");
        Balance.setBounds(350,380,130,25);
        image.add(Balance);
        Balance.addActionListener(this);

        exit=new JButton("Back");
        exit.setBounds(350,410,130,25);
        exit.addActionListener(this);
        image.add(exit);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton) e.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("Select * from bank where pin = " + pinnumber + "");
                int balance = 0;
                while (rs.next()) {
                    if ((((ResultSet) rs).getString("type").equals("Deposit"))) {
                        balance = balance + Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance = balance + Integer.parseInt(rs.getString("amount"));

                    }
                }
                if (e.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                } else {
                    Date date = new Date();
                    String query = "insert into bank values('" + pinnumber + "','" + date + "','Withdrawl','" + amount + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs" + amount + "Debited Successfully");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    public static void main(String[] args) {
        new fastcash("");
    }

}
