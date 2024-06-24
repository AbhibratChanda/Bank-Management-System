package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class withdrawn extends JFrame implements ActionListener {
    JButton back, Withdraw;
    JTextField WithdrawAmount;
    String pinnumber;

    withdrawn(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(910, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setBounds(180, 220, 400, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        WithdrawAmount = new JTextField();
        WithdrawAmount.setBounds(180, 260, 310, 34);
        image.add(WithdrawAmount);

        Withdraw = new JButton("Withdraw");
        Withdraw.setBounds(350, 380, 130, 25);
        image.add(Withdraw);
        Withdraw.addActionListener(this);

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
        } else if (e.getSource() == Withdraw) {
            String amount=WithdrawAmount.getText();
            if (amount.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount to withdraw");
            }else {
                String with=WithdrawAmount.getText();
                Date date=new Date();
                try {
                    Conn conn=new Conn();
                    String query = "insert into bank values('" + pinnumber + "', '" + date + "', 'withdrawl', '" + with + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Your Rs " + amount + " have been withdrawn");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }catch (Exception ae) {
                JOptionPane.showMessageDialog(null,"Your Rs "+amount+" have not been withdrawn");
                }
            }

        }
    }
    public static void main(String[] args) {
        new withdrawn("");
    }
}
