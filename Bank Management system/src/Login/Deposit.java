//package Login;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.SQLException;
//import java.util.Date;
//
//public class Deposit extends JFrame implements ActionListener {
//    JButton back,Deposit;
//    JTextField Deposit_amount;
//    String pinnumber;
//    Deposit(String pinnumber) {
//        this.pinnumber=pinnumber;
//        setLayout(null);
//
//        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
//        Image i2= i1.getImage().getScaledInstance(910,750, Image.SCALE_DEFAULT);
//        ImageIcon i3=new ImageIcon(i2);
//        JLabel image=new JLabel(i3);
//        image.setBounds(0,0,900,700);
//        add(image);
//        JLabel text=new JLabel("Enter the amount you want to Deposit");
//        text.setBounds(180,220,400,30);
//        text.setForeground(Color.white);
//        text.setFont(new Font("System",Font.BOLD,16));
//        image.add(text);
//
//        Deposit_amount=new JTextField();
//        Deposit_amount.setBounds(180,260,310,34);
//        Deposit_amount.setBackground(Color.white);
//        add(Deposit_amount);
//
//        Deposit=new JButton("Deposit");
//        Deposit.setBounds(350,380,130,25);
//        image.add(Deposit);
//        Deposit.addActionListener(this);
//
//        back=new JButton("Back");
//        back.setBounds(350,410,130,25);
//        back.addActionListener(this);
//        image.add(back);
//
//        setSize(900,900);
//        setLocation(300,0);
//        setUndecorated(true);
//        setVisible(true);
//    }
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource()==back){
//            setVisible(false);
//            new Transactions(pinnumber).setVisible(true);
//        } else if (e.getSource()==Deposit) {
//            String number=Deposit_amount.getText();
//            Date date=new Date();
//            if (number.equals("")){
//                JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
//            }else {
//                try {
//                    Conn conn=new Conn();
//                    String query="insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
//                    Conn.s.executeQuery(query);
//                    JOptionPane.showMessageDialog(null,"RS"+number+" deposited successfully");
//                    setVisible(false);
//                    new Transactions(pinnumber).setVisible(true);
//                } catch (SQLException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
//        }
//
//    }
//    public static void main(String[] args) {
//        new Deposit("");
//    }
//
//
//}
package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JButton back, deposit;
    JTextField depositAmount;
    String pinnumber;

    Deposit(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(910, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to Deposit");
        text.setBounds(180, 220, 400, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        depositAmount = new JTextField();
        depositAmount.setBounds(180, 260, 310, 34);
        image.add(depositAmount);

        deposit = new JButton("Deposit");
        deposit.setBounds(350, 380, 130, 25);
        image.add(deposit);
        deposit.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(350, 410, 130, 25);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else if (e.getSource() == deposit) {
            String number = depositAmount.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            } else {
                try {
                    int depositAmountInt = Integer.parseInt(number); // Validate numeric input
                    Conn conn = new Conn();
                    String query = "insert into bank values('" + pinnumber + "', '" + date + "', 'Deposit', '" + depositAmountInt + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " deposited successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid numeric amount");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error occurred while depositing: " + ex.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
