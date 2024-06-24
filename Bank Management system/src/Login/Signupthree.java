//package Login;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Statement;
//import java.util.EventListener;
//import java.util.Random;
//
//public class Signupthree extends JFrame implements ActionListener {
//    JRadioButton Saving,Current,Fixed,Recurring;
//    JCheckBox atm,internet,mobile,email,cheque,estatement,declaration;
//    JButton submit,cancel;
//    Signupthree() {
//        setLayout(null);
//        JLabel page3 = new JLabel("Page 3:Account Details");
//        page3.setBounds(540,60,800,40);
//        page3.setFont(new Font("Raleway",Font.BOLD,30));
//        add(page3);
//
//        JLabel type=new JLabel("Account Type");
//        type.setBounds(280,120,800,40);
//        type.setFont(new Font("Raleway",Font.BOLD,30));
//        add(type);
//
//        Saving=new JRadioButton("Saving Account");
//        Saving.setBounds(290,170,200,25);
//        add(Saving);
//
//        Current=new JRadioButton("Current Account");
//        Current.setBounds(290,210,200,25);
//        add(Current);
//
//        Fixed=new JRadioButton("Fixed Deposit Account");
//        Fixed.setBounds(500,170,200,25);
//        add(Fixed);
//
//        Recurring=new JRadioButton("Recurring Deposit Account");
//        Recurring.setBounds(500,210,200,25);
//        add(Recurring);
//
//        JLabel Card=new JLabel("Card Number");
//        Card.setBounds(280,250,200,34);
//        Card.setFont(new Font("Raleway",Font.BOLD,30));
//        add(Card);
//        JLabel xx=new JLabel("XXXX-XXXX-XXXX-4184");
//        xx.setBounds(530,250,400,34);
//        xx.setFont(new Font("Raleway",Font.BOLD,23));
//        add(xx);
//        JLabel digit=new JLabel("Your 16 Digit Card Number");
//        digit.setBounds(280,278,400,34);
//        digit.setFont(new Font("Raleway",Font.BOLD,17));
//        add(digit);
//
//        JLabel Pin=new JLabel("PIN:");
//        Pin.setBounds(280,315,400,34);
//        Pin.setFont(new Font("Raleway",Font.BOLD,23));
//        add(Pin);
//
//        JLabel shortX=new JLabel("XXXX");
//        shortX.setBounds(530,310,400,34);
//        shortX.setFont(new Font("Raleway",Font.BOLD,23));
//        add(shortX);
//
//        JLabel digit4=new JLabel("Your 4 Digit Password");
//        digit4.setBounds(280,345,400,25);
//        digit4.setFont(new Font("Raleway",Font.BOLD,17));
//        add(digit4);
//
//        JLabel Services=new JLabel("Services Required:");
//        Services.setBounds(280,390,400,30);
//        Services.setFont(new Font("Raleway",Font.BOLD,30));
//        add(Services);
//
//        atm=new JCheckBox("ATM CARD");
//        atm.setBounds(284,430,200,30);
//        atm.setFont(new Font("Raleway",Font.BOLD,18));
//        add(atm);
//
//        mobile=new JCheckBox("Mobile Banking");
//        mobile.setBounds(284,466,200,30);
//        mobile.setFont(new Font("Raleway",Font.BOLD,18));
//        add(mobile);
//
//        cheque=new JCheckBox("Cheque Book");
//        cheque.setBounds(284,500,200,30);
//        cheque.setFont(new Font("Raleway",Font.BOLD,18));
//        add(cheque);
//
//        internet=new JCheckBox("Internet Banking");
//        internet.setBounds(500,430,200,30);
//        internet.setFont(new Font("Raleway",Font.BOLD,18));
//        add(internet);
//
//        email=new JCheckBox("Email & SMS Alerts");
//        email.setBounds(500,466,200,30);
//        email.setFont(new Font("Raleway",Font.BOLD,18));
//        add(email);
//
//        estatement=new JCheckBox("E-Statement");
//        estatement.setBounds(500,500,400,30);
//        estatement.setFont(new Font("Raleway",Font.BOLD,18));
//        add(estatement);
//
//        declaration=new JCheckBox("I here declares that the above details are correct as the best of my knowledge.");
//        declaration.setBounds(300,560,900,30);
//        declaration.setFont(new Font("Raleway",Font.BOLD,18));
//        add(declaration);
//
//         submit=new JButton("Sign in");
//        submit.setBackground(Color.BLACK);
//        submit.setForeground(Color.white);
//        submit.setBounds(400,600,150,28);
//        submit.addActionListener(this);
//        add(submit);
//
//         cancel=new JButton("Cancel");
//        cancel.setBackground(Color.BLACK);
//        cancel.setForeground(Color.white);
//        cancel.setBounds(680,600,150,28);
//        cancel.addActionListener(this);
//        add(cancel);
//
//        setSize(1500,800);
//        setLocation(8,10);
//        setVisible(true);
//
//    }
//public void actionPerformed (EventListener e){
//        if (e.getSource== submit){
//        String saccount=null;
//        if (Saving.isSelected()){
//            saccount="Saving Account";
//        } else if (Current.isSelected()) {
//            saccount="Current Account";
//        } else if (Fixed.isSelected()) {
//            saccount="Fixed Account";
//        } else if (Recurring.isSelected()) {
//            saccount="Reccuring Account";
//        }
//            Random random=new Random();
//        String cardnumber=""+Math.abs((random.nextLong()%90000000L))+5040936000000000L;
//        String  pinnumber=""+Math.abs((random.nextLong()%90000L)+1000L);
//
//        String facility="";
//        if (atm.isSelected()){
//            facility=facility+"ATM Card";
//        }else if (internet.isSelected()){
//            facility=facility+"Internet Banking";
//        }else if (mobile.isSelected()){
//            facility=facility+"Mobile Banking";
//        } else if (email.isSelected()) {
//            facility=facility+"Email & SMS Alerts";
//        } else if (cheque.isSelected()) {
//            facility=facility+"Cheque Book";
//        } else if (estatement.isSelected()) {
//            facility=facility+"E- Statement";
//        try {
//
//        }
//
//        }catch (Exception ae){
//        }
//
//
//        } else if (e.getSource==cancel) {
//
//        }
//}
//
//
//
//    public static void main(String[] args) {
//        new Signupthree();
//    }
//
//}

package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signupthree extends JFrame implements ActionListener {
    JRadioButton Saving, Current, Fixed, Recurring;
    JCheckBox atm, internet, mobile, email, cheque, estatement, declaration;
    JButton submit, cancel;
    String formno;

    Signupthree(String formno) {
        this.formno=formno;
        setLayout(null);
        JLabel page3 = new JLabel("Page 3:Account Details");
        page3.setBounds(540, 60, 800, 40);
        page3.setFont(new Font("Raleway", Font.BOLD, 30));
        add(page3);

        JLabel type = new JLabel("Account Type");
        type.setBounds(280, 120, 800, 40);
        type.setFont(new Font("Raleway", Font.BOLD, 30));
        add(type);

        Saving = new JRadioButton("Saving Account");
        Saving.setBounds(290, 170, 200, 25);
        Saving.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(Saving);

        Current = new JRadioButton("Current Account");
        Current.setBounds(290, 210, 200, 25);
        Current.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(Current);

        Fixed = new JRadioButton("Fixed Deposit Account");
        Fixed.setBounds(500, 170, 250, 25);
        Fixed.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(Fixed);

        Recurring = new JRadioButton("Recurring Deposit Account");
        Recurring.setBounds(500, 210, 250, 25);
        Recurring.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(Recurring);

        // Group the radio buttons
        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(Saving);
        accountTypeGroup.add(Current);
        accountTypeGroup.add(Fixed);
        accountTypeGroup.add(Recurring);

        JLabel Card = new JLabel("Card Number");
        Card.setBounds(280, 250, 200, 34);
        Card.setFont(new Font("Raleway", Font.BOLD, 30));
        add(Card);

        JLabel xx = new JLabel("XXXX-XXXX-XXXX-4184");
        xx.setBounds(530, 250, 400, 34);
        xx.setFont(new Font("Raleway", Font.BOLD, 23));
        add(xx);

        JLabel digit = new JLabel("Your 16 Digit Card Number");
        digit.setBounds(280, 285, 400, 20);
        digit.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(digit);

        JLabel Pin = new JLabel("PIN:");
        Pin.setBounds(280, 320, 400, 34);
        Pin.setFont(new Font("Raleway", Font.BOLD, 23));
        add(Pin);

        JLabel shortX = new JLabel("XXXX");
        shortX.setBounds(530, 320, 400, 34);
        shortX.setFont(new Font("Raleway", Font.BOLD, 23));
        add(shortX);

        JLabel digit4 = new JLabel("Your 4 Digit Password");
        digit4.setBounds(280, 355, 400, 20);
        digit4.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(digit4);

        JLabel Services = new JLabel("Services Required:");
        Services.setBounds(280, 390, 400, 30);
        Services.setFont(new Font("Raleway", Font.BOLD, 30));
        add(Services);

        atm = new JCheckBox("ATM CARD");
        atm.setBounds(280, 430, 200, 30);
        atm.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(atm);

        mobile = new JCheckBox("Mobile Banking");
        mobile.setBounds(280, 470, 200, 30);
        mobile.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(mobile);

        cheque = new JCheckBox("Cheque Book");
        cheque.setBounds(280, 510, 200, 30);
        cheque.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(cheque);

        internet = new JCheckBox("Internet Banking");
        internet.setBounds(500, 430, 200, 30);
        internet.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(internet);

        email = new JCheckBox("Email & SMS Alerts");
        email.setBounds(500, 470, 200, 30);
        email.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(email);

        estatement = new JCheckBox("E-Statement");
        estatement.setBounds(500, 510, 200, 30);
        estatement.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(estatement);

        declaration = new JCheckBox("I hereby declare that the above details are correct to the best of my knowledge.");
        declaration.setBounds(280, 560, 800, 30);
        declaration.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(declaration);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(380, 620, 150, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(550, 620, 150, 30);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 700);
        setLocation(150, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String accountType = null;
            if (Saving.isSelected()) {
                accountType = "Saving Account";
            } else if (Current.isSelected()) {
                accountType = "Current Account";
            } else if (Fixed.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (Recurring.isSelected()) {
                accountType = "Recurring Deposit Account";
            }

            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if (atm.isSelected()) {
                facility += "ATM CARD, ";
            }
            if (internet.isSelected()) {
                facility += "Internet Banking, ";
            }
            if (mobile.isSelected()) {
                facility += "Mobile Banking, ";
            }
            if (email.isSelected()) {
                facility += "Email & SMS Alerts, ";
            }
            if (cheque.isSelected()) {
                facility += "Cheque Book, ";
            }
            if (estatement.isSelected()) {
                facility += "E-Statement, ";
            }
            if (!declaration.isSelected()) {
                JOptionPane.showMessageDialog(null, "You must declare that the information provided is correct.");
                return;
            }

            try {
                // Your database connection and insert code here
                Conn c1 = new Conn();
                String query = "INSERT INTO signupthree VALUES ('"+formno+"','" + accountType + "', '" + cardNumber + "', '" + pinNumber + "', '" + facility + "')";
                c1.s.executeUpdate(query);
                String query1 = "INSERT INTO Login VALUES ('"+formno+"','" + cardNumber + "','" + pinNumber + "')";
                c1.s.executeUpdate(query1);

               JOptionPane.showMessageDialog(null, "Card Number: "+cardNumber+"\n Pin: '"+pinNumber);
//                setVisible(false);
                // Optionally, you can open another window or close the application here
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else if (e.getSource() == cancel) {
            setVisible(false);

        }
    }

    public static void main(String[] args) {
        new Signupthree("");
    }
}

