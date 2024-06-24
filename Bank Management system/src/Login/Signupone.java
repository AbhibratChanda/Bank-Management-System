package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signupone extends JFrame implements ActionListener {
    long random;
    JTextField name1,father1,dob1,Email1,pin1,Address1,state1,city1;
    JRadioButton gender1,gender2,married,unmarried,none;
    JButton next;

    Signupone(){
        setLayout(null);
        Random ran=new Random();
        random=Math.abs((ran.nextLong()%9000L)+1000L);

        JLabel formno=new JLabel("APPLICATION FORM NO:  "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(380,30,800,40);
        getContentPane().setBackground(Color.WHITE);
        add(formno);

        JLabel page1=new JLabel("Page 1:Personal Details");
        page1.setFont(new Font("Raleway",Font.BOLD,21));
        page1.setBounds(540,80,800,40);
        add(page1);

        JLabel name=new JLabel("Name:");
        name1=new JTextField();
        name.setFont(new Font("Raleway",Font.BOLD,21));
        name.setBounds(300,160,800,40);
        name1.setBounds(500,160,500,28);
        add(name);
        add(name1);

        JLabel father=new JLabel("Father's Name:");
         father1=new JTextField();
        father.setFont(new Font("Raleway",Font.BOLD,21));
        father.setBounds(300,200,800,40);
        father1.setBounds(500,200,500,28);
        add(father);
        add(father1);

        JLabel dob=new JLabel("Date of Birth:");
         dob1=new JTextField();
        dob.setFont(new Font("Raleway",Font.BOLD,21));
        dob.setBounds(300,240,800,40);
        dob1.setBounds(500,240,500,28);
        add(dob);
        add(dob1);

        JLabel gender=new JLabel("Gender:");
         gender1=new JRadioButton("Male");
        gender1.setBounds(500,280,70,30);
         gender2=new JRadioButton("Female");
        gender2.setBounds(670,280,70,30);
        gender1.setBackground(Color.white);
        gender2.setBackground(Color.white);
        gender.setFont(new Font("Raleway",Font.BOLD,21));
        gender.setBounds(300,280,800,40);
        add(gender);
        add(gender1);
        add(gender2);
        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(gender1);
        genderButtonGroup.add(gender2);

        JLabel Email=new JLabel("Email Address:");
         Email1=new JTextField();
        Email.setFont(new Font("Raleway",Font.BOLD,21));
        Email.setBounds(300,320,800,40);
        Email1.setBounds(500,320,500,28);
        add(Email);
        add(Email1);

        JLabel maritial=new JLabel("Maritial Status:");
         married=new JRadioButton("Married");
         unmarried=new JRadioButton("Unmarried");
         none=new JRadioButton("None");
        married.setBounds(500,360,70,30);
        unmarried.setBounds(670,360,100,30);
        none.setBounds(840,360,70,30);
        married.setBackground(Color.WHITE);
        unmarried.setBackground(Color.WHITE);
        none.setBackground(Color.white);
        maritial.setFont(new Font("Raleway",Font.BOLD,21));
        maritial.setBounds(300,360,800,40);
        ButtonGroup mar=new ButtonGroup();
        mar.add(married);
        mar.add(unmarried);
        mar.add(none);
        add(maritial);
        add(married);
        add(unmarried);
        add(none);

        JLabel Address=new JLabel("Address:");
         Address1=new JTextField();
        Address.setFont(new Font("Raleway",Font.BOLD,21));
        Address.setBounds(300,400,800,40);
        Address1.setBounds(500,400,500,28);
        add(Address);
        add(Address1);

        JLabel city=new JLabel("City:");
         city1=new JTextField();
        city.setFont(new Font("Raleway",Font.BOLD,21));
        city.setBounds(300,440,800,40);
        city1.setBounds(500,440,500,28);
        add(city);
        add(city1);

        JLabel state=new JLabel("State:");
         state1=new JTextField();
        state.setFont(new Font("Raleway",Font.BOLD,21));
        state.setBounds(300,480,800,40);
        state1.setBounds(500,480,500,28);
        add(state);
        add(state1);

         next=new JButton("Next");
        next.setBounds(900,600,100,27);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        add(next);
        next.addActionListener(this);

        JLabel pin=new JLabel("Pin Code:");
         pin1=new JTextField();
        pin.setFont(new Font("Raleway",Font.BOLD,21));
        pin.setBounds(300,520,800,40);
        pin1.setBounds(500,520,500,28);
        add(pin);
        add(pin1);

        setSize(1500,800);
        setLocation(8,10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        String formno=""+random;
        String pname=name1.getText();
        String fname=father1.getText();
        String pdob=dob1.getText();
        String pgender=null;
        if (gender1.isSelected()){
            pgender="Male";
        }else if (gender2.isSelected()){
            pgender="Female";
        }
        String pemail=Email1.getText();
        String pmaratial=null;
        if (married.isSelected()){
            pmaratial="Married";
        } else if (unmarried.isSelected()) {
            pmaratial="Unmarried";
        } else if (none.isSelected()) {
            pmaratial="None";
        }
        String pAddress=Address1.getText();
        String pcity=city1.getText();
        String pstate=state1.getText();
        String ppin=pin1.getText();

        try{
            if(pname.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else {
                Conn c=new Conn();
                String query="insert into signup values('"+formno+"','"+pname+"','"+fname+"','"+pdob+"','"+pgender+"','"+pemail+"','"+pmaratial+"','"+pAddress+"','"+pcity+"','"+pstate+"','"+ppin+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new Signuptwo(formno).setVisible(true);
            }
        }catch (Exception ae){
            System.out.println(ae);
        }
    }
    public static void main(String args[]){

        new Signupone();
    }
}
