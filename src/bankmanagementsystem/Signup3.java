package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Signup3 extends  JFrame implements ActionListener  {
	JRadioButton button1,button2,button3,button4;
	JButton cancle,submit;
	JCheckBox checkbox1,checkbox2,checkbox3,checkbox4,checkbox5,checkbox6,checkbox7;
	Signup3(){
		setSize(850,800);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Automated teller machine ( ATM )");
		setLocation(350, 10);
		setVisible(true);
		setLayout(null);
		
		    JLabel pdetails=new JLabel("Personal information ( Page 3 )");
			pdetails.setFont(new Font("Raleway",Font.BOLD,20));
			pdetails.setBounds(300,50,300,40);
			add(pdetails);
			
			JLabel type=new JLabel("Account type");
			type.setFont(new Font("Raleway",Font.BOLD,20));
			type.setBounds(150,150,300,40);
			add(type);
			
			button1=new JRadioButton("Savings account.");
			button1.setBounds(150,180,150,20);
			button1.setBackground(Color.white);
			add(button1);
			
			button2=new JRadioButton("Current account.");
			button2.setBounds(350,200,150,20);
			button2.setBackground(Color.white);
			add(button2);
			
			button3=new JRadioButton("Fixed deposite.");
			button3.setBounds(150,200,150,20);
			button3.setBackground(Color.white);
			add(button3);
			
			button4=new JRadioButton("Recurring deposite.");
			button4.setBounds(350,180,150,20);
			button4.setBackground(Color.white);
			add(button4);
			
			ButtonGroup accounttype=new ButtonGroup();
			accounttype.add(button1);
			accounttype.add(button2);
			accounttype.add(button3);
			accounttype.add(button4);
			
			JLabel card=new JLabel("Card Number:");
			card.setFont(new Font("Raleway",Font.BOLD,20));
			card.setBounds(150,250,150,20);
			add(card);
			JLabel cardex=new JLabel("Your 16 Digit card number");
			cardex.setBounds(150,270,150,20);
			add(cardex);
			
			JLabel cardnumber=new JLabel("XXXX-XXXX-XXXX-7438");
			cardnumber.setFont(new Font("Raleway",Font.BOLD,20));
			cardnumber.setBounds(350,260,300,20);
			add(cardnumber);
			
			JLabel pin=new JLabel("Pin Number:");
			pin.setFont(new Font("Raleway",Font.BOLD,20));
			pin.setBounds(150,300,150,20);
			add(pin);
			JLabel pinx=new JLabel("Enter 4 Digit Password");
			pinx.setBounds(150,320,150,20);
			add(pinx);
			
			JLabel pinnumber=new JLabel("XXXX");
			pinnumber.setFont(new Font("Raleway",Font.BOLD,20));
			pinnumber.setBounds(350,310,300,20);
			add(pinnumber);
			
			JLabel service=new JLabel("Service Required");
			service.setFont(new Font("Raleway",Font.BOLD,20));
			service.setBounds(150,380,200,20);
			add(service);
			
			checkbox1=new JCheckBox("ATM Card");
			checkbox1.setBounds(150,400,200,30);
			checkbox1.setBackground(Color.white);
			add(checkbox1);
			
			checkbox2=new JCheckBox("Internet banking");
			checkbox2.setBounds(350,400,200,30);
			checkbox2.setBackground(Color.white);
			add(checkbox2);
			
			checkbox3=new JCheckBox("Mobile banking");
			checkbox3.setBounds(150,430,200,30);
			checkbox3.setBackground(Color.white);
			add(checkbox3);
			
			checkbox4=new JCheckBox("Email & Sms Alerts");
			checkbox4.setBounds(350,430,200,30);
			checkbox4.setBackground(Color.white);
			add(checkbox4);
			
			checkbox5=new JCheckBox("Cheque Book");
			checkbox5.setBounds(150,460,200,30);
			checkbox5.setBackground(Color.white);
			add(checkbox5);
			
			checkbox6=new JCheckBox("E-Statement");
			checkbox6.setBounds(350,460,200,30);
			checkbox6.setBackground(Color.white);
			add(checkbox6);	
			
			checkbox7=new JCheckBox("I hereby declares that above entered details are correct");
			checkbox7.setBounds(150,550,600,30);
			checkbox7.setBackground(Color.white);
			add(checkbox7);	
			
			 cancle=new JButton("Cancle");
			cancle.setBackground(Color.white);
			cancle.setBounds(250,600,80,30);
			cancle.setBackground(Color.black);
			cancle.setForeground(Color.white);
			cancle.addActionListener(this);
			add(cancle);	
			
			 submit=new JButton("Submit");
			submit.setBackground(Color.white);
			submit.setBounds(400,600,80,30);
			submit.setBackground(Color.black);
			submit.setForeground(Color.white);
			submit.addActionListener(this);
			add(submit);	
	}
	String accounttype=null;
	Random random=new Random();
	String 	cardno=" "+Math.abs((random.nextLong()%90000000L))+50409360L;
	String 	pin=" "+Math.abs((random.nextInt()%9000));
	String servicesreq="";
	public void actionPerformed(ActionEvent e) {
		if(button1.isSelected()) {
			accounttype="Savings account";
		}
		else if(button2.isSelected()) {
			accounttype="Current account";
		}
		else if(button3.isSelected()) {
			accounttype=" Fixed deposite";
		}
		else if(button4.isSelected()) {
			accounttype=" Recurring deposite";
		}
		if(e.getSource()==submit && checkbox7.isSelected() && accounttype!=null) {
			JOptionPane.showMessageDialog(null,"card Number: "+cardno+" Pin: "+pin);
			setVisible(false);
			new Login().setVisible(true);
			
		}else if(e.getSource()==cancle) {
			setVisible(false);
			new Login().setVisible(true);
		}
		
		if(checkbox1.isSelected()) {
			servicesreq=servicesreq+"ATM Card + ";
		}
		 if(checkbox2.isSelected()) {
			servicesreq=servicesreq+"Internet banking + ";
		}
		 if(checkbox3.isSelected()) {
			servicesreq=servicesreq+"Mobile banking + ";
		}
		 if(checkbox4.isSelected()) {
			servicesreq=servicesreq+"Email and Sms alerts + ";
		}
		 if(checkbox5.isSelected()) {
			servicesreq=servicesreq+"Cheque book + ";
		}
		 if(checkbox6.isSelected()) {
			servicesreq=servicesreq+"E-Statement";
		}
		if(accounttype==null) {
			JOptionPane.showMessageDialog(null, "Select account type");
		}else {
			try {
				Connections c=new Connections();
			 String query="insert into signup3 values('"+cardno+"','"+pin+"','"+accounttype+"','"+servicesreq+"')";
			 c.s.executeUpdate(query);
			 String query2="insert into login values('"+cardno+"','"+pin+"')";
			 c.s.executeUpdate(query2);
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		
	}
	public static void main(String[] args) {
		Signup3 c=new Signup3();	
	}
}
