package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pinchange extends JFrame implements ActionListener {
    JButton back, change;
   JPasswordField npin,rpin;
   String pinnumber;

    pinchange(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(910, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);

        JLabel text = new JLabel("Enter the New Pin Number");
        text.setBounds(180, 220, 400, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        JLabel NewPin=new JLabel("Enter PIN");
        NewPin.setBounds(180, 260, 100, 34);
        NewPin.setForeground(Color.white);
        image.add(NewPin);

        npin = new JPasswordField();
        npin.setBounds(270, 260, 170, 31);
        image.add(npin);

        JLabel RePin=new JLabel("Re-Enter PIN");
        RePin.setBounds(180, 300, 100, 34);
        RePin.setForeground(Color.white);
        image.add(RePin);

        rpin = new JPasswordField();
        rpin.setBounds(270, 300, 170, 31);
        image.add(rpin);

        change = new JButton("Change");
        change.setBounds(350, 380, 130, 25);
        image.add(change);
        change.addActionListener(this);

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
        Conn c=new Conn();
        if (e.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else if (e.getSource() == change) {
            String pin=new String(npin.getPassword());
            String recheckpin= new String(rpin.getPassword());
            if (pin.equals(recheckpin)){
        try{
                String query1="update bank set pin='"+rpin+"' where pin='"+pinnumber+"'";
                String query2="update Login set pin='"+rpin+"' where pin='"+pinnumber+"'";
                String query3="update signupthree set pin='"+rpin+"' where pin='"+pinnumber+"'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null,"Your Pin has been Successfully Changed");
            }catch (Exception ae){
                System.out.println(ae);
            }
            }else {
                JOptionPane.showMessageDialog(null,"Please re-enter your Pin");
                return;
            }

        }
    }

    public static void main(String[] args) {
        new pinchange("");
    }
}
