

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{
    JTextField tusername;
    JPasswordField tpassword;
    JButton login,back;

    login(){
        
        JLabel username = new JLabel("Username"); //for writing string username in the frame
        username.setBounds(40,20,100,30);
        username.setForeground(Color.WHITE);
        add(username);
        tusername = new JTextField();  // for textfield of username
        tusername.setBounds(150,20,150,30);
        add(tusername);

        JLabel password = new JLabel("Password");  // for writing string password in the frame
        password.setBounds(40,70,100,30);
        password.setForeground(Color.WHITE);
        add(password);
        tpassword = new JPasswordField();  // for textfield of password
        tpassword.setBounds(150,70,150,30);
        add(tpassword);


        login = new JButton("login");  // for creating a button
        login.setBounds(150,140,150,30); // for changing its coordinates
        login.setBackground(Color.black);  //background colour
        login.setForeground(Color.white);  //font colour
        login.addActionListener(this);  // whenever user click on the button action triggers
        add(login); // used to add button in the frame

        back = new JButton("Back");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        // ImageIcon i1 = new ImageIcon("icons/second.jpg");
        // Image i2 = i1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        // ImageIcon i3 = new ImageIcon(i2);
        // JLabel img = new JLabel(i3);
        // img.setBounds(350,10,600,400);
        // add(img);

        ImageIcon i4 = new ImageIcon("icons/login3.jpeg");
        Image i5 = i4.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel imgg = new JLabel(i6);
        imgg.setBounds(0,0,600,300);
        add(imgg);
        
        
        setSize(600,300);
        setLocation(450,200);
        setLayout(null);
        setVisible(true);
    }

    // what action needs to implement when user click it
    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == login){
            try{
                String usernamee = tusername.getText();
                char[] password2 = tpassword.getPassword();
                String password3 = String.valueOf(password2);
                
                conn conn = new conn();
                String query = "Select * from login where username='"+usernamee+"'and password='"+password3+"'";
                ResultSet rs =  conn.statement.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Main_class();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                }
            }catch(Exception E){
                E.printStackTrace();
            }
        }
        if(e.getSource() == back){
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        new login();
    }
}
