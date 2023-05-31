package bankmanagementsystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transactions extends JFrame implements ActionListener{
	JButton deposite,cashwithdrawl,fastcash,ministatements,pinchange,balanceenquiry,exit;
	String pin;
	public Transactions(String pinnumber) {
		this.pin =pinnumber;
		setLayout(null);
		setSize(1600,900);
		setLocation(0, 0);
		setTitle("Automated teller machine ( ATM )");
		
		ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i1=image.getImage().getScaledInstance(1600, 900, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(i1);
		
		JLabel imagelable= new JLabel(i2);
		imagelable.setBounds(0,0,1600,900);
		add(imagelable);
		
		ImageIcon imagebrand=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image brand=imagebrand.getImage().getScaledInstance(100, 80, Image.SCALE_DEFAULT);
		ImageIcon brandimage=new ImageIcon(brand);
		JLabel brandimg=new JLabel(brandimage);
		brandimg.setBounds(550, 410, 100, 100);
		imagelable.add(brandimg);
		
		JLabel text= new JLabel("Please select your services");
		text.setBounds(520,290,400,30);
		text.setForeground(Color.WHITE);
		imagelable.add(text);
		
		 deposite= new JButton("Deposite");
		deposite.setBounds(300,420,150,25);
		deposite.setBackground(Color.black);
		deposite.setForeground(Color.white);
		deposite.addActionListener(this);
		add(deposite);
		
		 cashwithdrawl= new JButton("Cash withdrawl");
		cashwithdrawl.setBounds(750,420,150,25);
		cashwithdrawl.setBackground(Color.black);
		cashwithdrawl.setForeground(Color.white);
		cashwithdrawl.addActionListener(this);
		add(cashwithdrawl);
		

		 fastcash= new JButton("Fast Cash");
		fastcash.setBounds(300,450,150,25);
		fastcash.setBackground(Color.black);
		fastcash.setForeground(Color.white);
		fastcash.addActionListener(this);
		add(fastcash);
		
		 ministatements= new JButton("Mini Statements");
		ministatements.setBounds(750,450,150,25);
		ministatements.setBackground(Color.black);
		ministatements.setForeground(Color.white);
		ministatements.addActionListener(this);
		add(ministatements);
		
		 pinchange= new JButton("Pinchange");
		pinchange.setBounds(300,480,150,25);
		pinchange.setBackground(Color.black);
		pinchange.setForeground(Color.white);
		pinchange.addActionListener(this);
		add(pinchange);
	
		
		 balanceenquiry= new JButton("Balance Enquiry");
		balanceenquiry.setBounds(750,480,150,25);
		balanceenquiry.setBackground(Color.black);
		balanceenquiry.setForeground(Color.white);
		balanceenquiry.addActionListener(this);
		add(balanceenquiry);
		
		 exit= new JButton("Exit");
		exit.setBounds(525,510,150,25);
		exit.setBackground(Color.black);
		exit.setForeground(Color.white);
		exit.addActionListener(this);
		add(exit);
		
		setUndecorated(true);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==deposite) {
			setVisible(false);
			new Deposite(pin).setVisible(true);
		}
		else if(e.getSource()==cashwithdrawl) {
			new Cashwithdrawl(pin);
		}
		else if(e.getSource()==fastcash) {
			setVisible(false);
			new Fastcash(pin).setVisible(true);
		}
		else if(e.getSource()==ministatements) {
			setVisible(false);
			new Ministatement(pin).setVisible(true);
			System.out.println("Ok");
		}
		else if(e.getSource()==pinchange) {
			setVisible(false);
			new PinChange(pin).setVisible(true);
		}
		else if(e.getSource()==balanceenquiry) {
			setVisible(false);
			new BalanceEnquiry(pin).setVisible(true);
		}
		else if(e.getSource()==exit) {
			System.exit(0);
		}
		
		
	}
	public static void main(String[] args) {
		new Transactions("");
	}
}
