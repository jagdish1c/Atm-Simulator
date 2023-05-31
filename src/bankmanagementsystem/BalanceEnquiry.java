package bankmanagementsystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener{
	JButton back;
	String pin;
	public BalanceEnquiry(String pin) {
		this.pin=pin;
		setSize(1600,900);
		setLocation(0, 0);
		setTitle("Automated teller machine ( ATM )");
		
		ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i1=image.getImage().getScaledInstance(1600, 900, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(i1);
		
		JLabel imagelable= new JLabel(i2);
		imagelable.setBounds(0,0,1600,900);
		add(imagelable);
		
		JLabel text= new JLabel("Enter ammount you want to Withdraw");
		text.setBounds(500,290,400,30);
		text.setForeground(Color.WHITE);
		
		back= new JButton("Back");
		back.setBounds(510,490,150,25);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		imagelable.add(back);
		
		Connections c=new Connections();
		int balance =0;
		try {
			ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pin+"'");	
			while(rs.next()) {
				if(rs.getString("type").equals("Deposite")) {
					balance +=Integer.parseInt(rs.getString("ammount"));
				}
				else {
					balance -=	Integer.parseInt(rs.getString("ammount"));
				}
			}
		}
			catch (Exception e) {
				System.out.println(e);
			}
		
		JLabel showbalance=new JLabel("Your Current account balane is : "+ balance);
		showbalance.setBounds(300,350,400,30);
		showbalance.setForeground(Color.WHITE);
		imagelable.add(showbalance);
		
		
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Transactions("").setVisible(true);
		
	}
	public static void main(String[] args) {
		new BalanceEnquiry("");
	}
}
