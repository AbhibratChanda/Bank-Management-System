package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
            JButton exit,withdrawl,fast,pin,mini,Balance,deposit;
            String pinnumber;
    Transactions(String pinnumber) {
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
         deposit=new JButton("Deposit");
        deposit.setBounds(170,320,130,25);
        image.add(deposit);
        deposit.addActionListener(this);

         fast=new JButton("Fast Cash");
        fast.setBounds(170,350,130,25);
        image.add(fast);
        fast.addActionListener(this);

         pin=new JButton("Pin Change");
        pin.setBounds(170,380,130,25);
        pin.addActionListener(this);
        image.add(pin);

         withdrawl=new JButton("Cash Withdrawl");
        withdrawl.setBounds(350,320,130,25);
        image.add(withdrawl);
        withdrawl.addActionListener(this);

         mini=new JButton("Mini Statement");
        mini.setBounds(350,350,130,25);
        image.add(mini);
        mini.addActionListener(this);

         Balance=new JButton("Balance Enquiry");
        Balance.setBounds(350,380,130,25);
        image.add(Balance);
        Balance.addActionListener(this);

         exit=new JButton("Exit");
        exit.setBounds(350,410,130,25);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==exit){
            System.exit(0);
        }else if (e.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (e.getSource()==withdrawl) {
            setVisible(false);
            new withdrawn(pinnumber).setVisible(true);
        }else if (e.getSource()==fast) {
            setVisible(false);
            new fastcash(pinnumber).setVisible(true);
        }else if (e.getSource()==pin) {
            setVisible(false);
            new pinchange(pinnumber).setVisible(true);
        }else if (e.getSource()==Balance){
            setVisible(false);
            new Balance_enquiry(pinnumber).setVisible(true);
        } else if (e.getSource()==mini) {
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transactions("");
    }


}
