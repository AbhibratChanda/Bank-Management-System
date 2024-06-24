package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

class Balance_enquiry extends JFrame implements ActionListener{
    String pinnumber;
    JButton back;
    Balance_enquiry(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(910, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);

        back = new JButton("Back");
        back.setBounds(350, 410, 130, 25);
        back.addActionListener(this);
        image.add(back);

        Conn c=new Conn();
        int balance=0;

        try{
            ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");

            while(rs.next()){
                if (rs.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }else {
                    balance-=Integer.parseInt(rs.getString("amount"));
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        JLabel text=new JLabel("Your Current Account Balance is Rs"+balance);
        text.setForeground(Color.white);
        text.setBounds(180, 220, 400, 30);
        image.add(text);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
if (e.getSource()==back){
    setVisible(false);
    new Transactions(pinnumber).setVisible(true);
}

    }

    public static void main(String[] args) {
        new Balance_enquiry("");
    }
}