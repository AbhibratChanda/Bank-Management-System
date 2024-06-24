//import javax.swing.*;
//import java.awt.*;
//
//class Login extends JFrame {
//
//    Login() {
//        setTitle("Automated Teller Machine");
//        setLayout(new BorderLayout());
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("logo.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel label = new JLabel(i3);
//        add(label, BorderLayout.NORTH);
//
//        setSize(800, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation
//        setLocationRelativeTo(null); // Centering the frame on the screen
//        setVisible(true);
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        new Login();
//    }
//}
package Login;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Main extends JFrame implements ActionListener {
    JButton clear, signup, login,signin;
    JTextField entercardno;
    JPasswordField enterpinno;

    Main() {
        setTitle("Automated Teller Machine");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(-30, 10, 400, 100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(270, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card Number");
        cardno.setFont(new Font("Osward", Font.BOLD, 28));
        cardno.setBounds(100, 150, 400, 40);
        add(cardno);

        JLabel pin = new JLabel("Pin");
        pin.setFont(new Font("Osward", Font.BOLD, 28));
        pin.setBounds(150, 200, 400, 40);
        add(pin);


        entercardno = new JTextField(12);
        entercardno.setBounds(300, 150, 250, 30);
        add(entercardno);

        enterpinno = new JPasswordField(12);
        enterpinno.setBounds(300, 200, 250, 30);
        add(enterpinno);

         signin = new JButton("Sign in");
        signin.setBounds(300, 260, 100, 31);
        signin.addActionListener(this);
        add(signin);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.white);


        clear = new JButton("Clear");
        clear.setBounds(430, 260, 100, 31);
        add(clear);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);

        signup = new JButton("Sign up");
        signup.setBounds(310, 300, 200, 31);
        add(signup);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);

        getContentPane().setBackground(Color.white);


        setSize(800, 400);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clear) {
            entercardno.setText("");
            enterpinno.setText("");
        } else if (e.getSource() == signin) {
            Conn c=new Conn();
            String cardnumber= entercardno.getText();
            String pinnumber=enterpinno.getText();
            String query="Select * from Login where card_Number='"+cardnumber+"'and pin_Number='"+pinnumber+"'";
            try {
                ResultSet rs=c.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card and Pin Number");
                    System.exit(0);


                }
            }catch (Exception ae){
                System.out.println(ae);
            }

            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else if (e.getSource() == signup) {
            setVisible(false);
            new Signupone().setVisible(true);
        }

    }


        public static void main(String[] args) {
            new Main();
        }
    }



