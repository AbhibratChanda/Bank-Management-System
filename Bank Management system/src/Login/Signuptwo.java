package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signuptwo extends JFrame implements ActionListener {
    JLabel Religion,Category,Income,Education,Occupation;
    JLabel Aadhar,Pan,Senior,Existing,Page2;
    JComboBox religion,catagory1,income1,education1,occupation1;
    JRadioButton existing1,existing2,senior1,senior2;
    JTextField aadhar,pan;
    String formno;

    Signuptwo(String formno){
        this.formno=formno;
        setTitle("Automated Teller Machine");
        setLayout(null);

        Page2 =new JLabel("Page 2:Additional Details");
        Page2.setFont(new Font("Raleway",Font.BOLD,21));
        Page2.setBounds(540,80,800,40);
        add(Page2);

        Religion=new JLabel("Religion:");
        Religion.setFont(new Font("Raleway",Font.BOLD,21));
        String religion1[]={"Hindu","Islam","Cristanity","Sikh"};
         religion=new JComboBox(religion1);
        religion.setBounds(430,165,500,24);
        religion.setBackground(Color.WHITE);
        Religion.setBounds(300,160,800,40);
        add(Religion);
        add(religion);

        Category=new JLabel("Category:");
        String catagory[]={"General","OBC","SC","ST"};
         catagory1=new JComboBox(catagory);
        Category.setFont(new Font("Raleway",Font.BOLD,21));
        catagory1.setBounds(430,210,800,25);
        Category.setBounds(300,200,800,40);
        catagory1.setBackground(Color.WHITE);
        add(Category);
        add(catagory1);

        Income=new JLabel("Income:");
        String income[]={"1000-50,000","50,000-1Lakhs","1Lakhs-1Crore","None"};
         income1=new JComboBox(income);
        income1.setBounds(430,250,800,25);
        income1.setBackground(Color.WHITE);
        Income.setFont(new Font("Raleway",Font.BOLD,21));
        Income.setBounds(300,240,800,40);
        add(Income);
        add(income1);

        Education=new JLabel("Educational  Qualification:");
        String education[]={"Class 10th","Class 12th","Under Graduate","Graduate","Bsc","B-Tech"};
         education1=new JComboBox(education);
        education1.setBounds(620,290,600,25);
        education1.setBackground(Color.white);
        Education.setFont(new Font("Raleway",Font.BOLD,21));
        Education.setBounds(300,280,500,40);
        add(Education);
        add(education1);

        Occupation=new JLabel("Occupation:");
        String occupation[]={"Engineer","Doctor","Lawyer","Student","Teacher"};
         occupation1=new JComboBox(occupation);
        occupation1.setBounds(430,330,800,25);
        Occupation.setFont(new Font("Raleway",Font.BOLD,21));
        Occupation.setBounds(300,320,800,40);
        occupation1.setBackground(Color.WHITE);
        add(Occupation);
        add(occupation1);

        Pan=new JLabel("Pan Number:");
         pan=new JTextField();
        pan.setBounds(490,370,600,25);
        Pan.setFont(new Font("Raleway",Font.BOLD,21));
        Pan.setBounds(300,360,800,40);
        add(Pan);
        add(pan);

        Aadhar=new JLabel("Aadhar Number:");
         aadhar=new JTextField();
        aadhar.setBounds(490,410,600,25);
        Aadhar.setFont(new Font("Raleway",Font.BOLD,21));
        Aadhar.setBounds(300,400,800,40);
        add(Aadhar);
        add(aadhar);

        Senior=new JLabel("Senior Citizen:");
         senior1=new JRadioButton("Yes");
         senior2=new JRadioButton("No");
        senior1.setBounds(600,450,60,30);
        senior2.setBounds(800,450,60,30);
        Senior.setFont(new Font("Raleway",Font.BOLD,21));
        Senior.setBounds(300,440,800,40);
        add(Senior);
        add(senior1);
        add(senior2);

        ButtonGroup sen=new ButtonGroup();
        sen.add(senior1);
        sen.add(senior2);

        Existing=new JLabel("Existing Account:");
         existing1=new JRadioButton("Yes");
        existing1.setBounds(600,490,60,30);
         existing2=new JRadioButton("No");
        existing2.setBounds(800, 490, 60, 30);
        Existing.setFont(new Font("Raleway",Font.BOLD,21));
        Existing.setBounds(300,480,800,40);
        add(Existing);
        add(existing1);
        add(existing2);
        ButtonGroup exe=new ButtonGroup();
        exe.add(existing1);
        exe.add(existing2);

        JButton next=new JButton("Next");
        next.setBounds(1000,550,90,27);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);


        setSize(1500,800);
        setLocation(8,10);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){

        String sreligion=(String) religion.getSelectedItem();
        String scatagory1=(String) catagory1.getSelectedItem();
        String sincome=(String) income1.getSelectedItem();
        String seducation=(String) education1.getSelectedItem();
        String soccupation=(String) occupation1.getSelectedItem();
        String sexisting="";
        if(existing1.isSelected()){
            sexisting="Yes";
        } else if (existing2.isSelected()) {
            sexisting="No";
        }
        String ssenior=null;
        if (senior1.isSelected()){
            ssenior="Yes";
        } else if (senior2.isSelected()) {
            ssenior="No";
        }
        String saadhar=aadhar.getText();
        String span=pan.getText();

        try{
            if(span.equals("")){
                JOptionPane.showMessageDialog(null,"Catagory is Required");
            }else {
                Conn c1=new Conn();
                String query1="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scatagory1+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+sexisting+"','"+ssenior+"','"+saadhar+"','"+span+"')";
                c1.s.executeUpdate(query1);
                setVisible(false);
                new Signupthree(formno).setVisible(true);

            }
        }catch (Exception ae){
            System.out.println(ae);
        }
    }




    public static void main(String args[]){
        new Signuptwo("");
    }
}


