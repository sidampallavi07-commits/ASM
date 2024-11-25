package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton Login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField; 
    
    
    Login() {
        
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);
        
        ImageIcon i1=new  ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel text=new  JLabel("Welcome To ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,30));
        cardno.setBounds(120,150,400,40);
        add(cardno);
        
        cardTextField=new JTextField();
        cardTextField.setBounds(300, 150,250,30);
        cardTextField.setFont(new Font("Arial", Font.BOLD,15)); 
        add(cardTextField);
        
        JLabel pin=new JLabel("Pin:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);
        
        pinTextField=new JPasswordField();
        cardTextField.setFont(new Font("Arial", Font.BOLD,15)); 
        pinTextField.setBounds(300, 220, 250, 30);
        add(pinTextField);
        
        Login=new JButton("SIGN IN");
        Login.setBounds(300, 300, 100, 30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);
        
        
        
        clear=new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup=new  JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
        
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
             cardTextField.setText("");
             pinTextField.setText("");

        }else
    if (ae.getSource() == Login) {
          Conn conn= new Conn();
          String cardnumber = cardTextField.getText();
          String pinnumber = pinTextField.getText();
          String query ="select * from login where cardnumber = '"+cardnumber+"' and pin ='"+pinnumber+"'";
         try {
           ResultSet rs= conn.s.executeQuery(query);
           if(rs.next()){
               setVisible(false);
               new Transactions(pinnumber).setVisible(true);
           }else{
               JOptionPane.showMessageDialog(null, "Incorrect Card Number and Pin");
           }
        } catch (Exception e) {
             System.out.println(e);
        }
        }else
    if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
            
        }
        
    public static void main(String args[]) {
        new Login();
    }
}

