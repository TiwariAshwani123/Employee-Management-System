import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class UpdateEmployee extends JFrame implements ActionListener{

    JTextField teducation,tfname,taddress,tphone,taaddhar,temail,tsalary,tdesignation;
    JLabel tempid;
    JButton update,back;
    String number;

    UpdateEmployee(String number){

        this.number = number;
        
        getContentPane().setBackground(new Color(135,206,235));

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif" , Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        JLabel tname = new JLabel();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(177,252,197));
        tname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
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

        JLabel tdob = new JLabel();
        tdob.setBounds(200,200,150,30);
        tdob.setFont(new Font("Tahoma",Font.BOLD,20));
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
        email.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(email);

        temail= new JTextField();
        temail.setBounds(200,300,150,30);
        // temail.setBackground(new Color(177,252,197));
        add(temail);
        
        JLabel education = new JLabel("Highest Education");
        education.setBounds(400,300,150,30);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(education);
        
        teducation = new JTextField();
        teducation.setBounds(600,300,150,30);
        // teducation.setBackground(new Color(177,252,197));
        add(teducation);

        JLabel aaddhar = new JLabel("Aaddhar");
        aaddhar.setBounds(400,350,150,30);
        aaddhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(aaddhar);

        JLabel taaddhar = new JLabel();
        taaddhar.setBounds(600,350,150,30);
        taaddhar.setBackground(new Color(177,252,197));
        taaddhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(taaddhar);

        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empid);

        tempid = new JLabel();
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

        update = new JButton("Update");
        update.setBounds(450,550,150,40);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(250,550,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        try{
            conn c = new conn();
            String query = "select * from employee where empId='"+number+"'";
            ResultSet rs = c.statement.executeQuery(query);
            while(rs.next()){
                tname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                tdob.setText(rs.getString("dob"));
                taddress.setText(rs.getString("address"));
                tsalary.setText(rs.getString("salary"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
                teducation.setText(rs.getString("education"));
                taaddhar.setText(rs.getString("aaddhar"));
                tempid.setText(rs.getString("empId"));
                tdesignation.setText(rs.getString("designation"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e ){
        if(e.getSource() == update){
           
            String fname = tfname.getText();          
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = teducation.getText();
            String designation = tdesignation.getText();
            
            try {
                conn c = new conn();

                String query = "update employee set fname = '"+fname+"' , salary = '"+salary+"' , address = '"+address+"' , phone = '"+phone+"' , email = '"+email+"' , education = '"+education+"' , designation = '"+designation+"' where empId = '"+number+"'";

                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Updated Successfully");
                setVisible(false);
                
                new View_Employee();

            } catch (Exception E) {
                E.printStackTrace();
            }
        }

        if(e.getSource() == back){
            setVisible(false);
            new View_Employee();
        }

    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
