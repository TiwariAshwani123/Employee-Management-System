import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener{
    Random ran = new Random();
    int number = ran.nextInt(99999);
    

    JTextField tname,tfname,taddress,tphone,taaddhar,temail,tsalary,tdesignation;
    JLabel tempid;
    JButton add,back;
    public JDateChooser tdob;
    JComboBox<String> BoxEducation;

    AddEmployee(){

        getContentPane().setBackground(new Color(135,206,235));

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif" , Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        tname = new JTextField();
        tname.setBounds(200,150,150,30);
        // tname.setBackground(new Color(177,252,197));
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600,150,150,30);
        // tfname.setBackground(new Color(177,252,197));
        add(tfname);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(dob);

        //We have to add jar file for JDateChooser
        tdob = new JDateChooser();
        tdob.setBounds(200,200,150,30);
        // tdob.setBackground(new Color(177,252,197));
        add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600,200,150,30);
        // tsalary.setBackground(new Color(177,252,197));
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200,250,150,30);
        // taddress.setBackground(new Color(177,252,197));
        add(taddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600,250,150,30);
        // tphone.setBackground(new Color(177,252,197));
        add(tphone);

        JLabel email = new JLabel("Email");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(email);

        temail = new JTextField();
        temail.setBounds(200,300,150,30);
        // temail.setBackground(new Color(177,252,197));
        add(temail);

        JLabel education = new JLabel("Highest Education");
        education.setBounds(400,300,150,30);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(education);

       String[] items = {"BBA","B.Tech","BCA","BA","BSC","B.COM","MBA","MCA","MA","M.Tech","MSC","PHD"};

        BoxEducation = new JComboBox<>(items);
        BoxEducation.setBounds(600,300,150,30);
        // BoxEducation.setBackground(new Color(177,252,197));
        add(BoxEducation);

        JLabel aaddhar = new JLabel("Aaddhar");
        aaddhar.setBounds(400,350,150,30);
        aaddhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(aaddhar);

        taaddhar = new JTextField();
        taaddhar.setBounds(600,350,150,30);
        // taaddhar.setBackground(new Color(177,252,197));
        add(taaddhar);

        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empid);

        tempid = new JLabel(""+number);
        tempid.setBounds(200,400,150,30);
        tempid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        tempid.setForeground(Color.RED);
        add(tempid);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(50,350,150,30);
        designation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200,350,150,30);
        // tdesignation.setBackground(new Color(177,252,197));
        add(tdesignation);

        add = new JButton("Add");
        add.setBounds(450,550,150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(250,550,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == add){
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String)BoxEducation.getSelectedItem();
            String designation = tdesignation.getText();
            String aaddhar = taaddhar.getText();
            String empID = tempid.getText();

            try{
                conn conn = new conn();

                String query = "insert into employee values('"+name+"' , '"+fname+"', '"+dob+"','"+salary+"' , '"+address+"' , '"+phone+"' , '"+email+"' , '"+education+"' , '"+designation+"' , '"+aaddhar+"' , '"+empID+"')";

                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Added Successfully");
                setVisible(false);
                new Main_class();

            }catch(Exception E){
                E.printStackTrace();
            }

        }

        if(e.getSource()==back){
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}