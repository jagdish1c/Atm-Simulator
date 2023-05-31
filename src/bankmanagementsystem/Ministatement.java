package bankmanagementsystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ministatement extends JFrame implements ActionListener {
	String pin;
	public Ministatement(String pin) {
		this.pin=pin;
		setLayout(null);
		setSize(400,600);
		setLocation(20, 30);
		setTitle("Mini statement");
		getContentPane().setBackground(Color.white);
		
		JLabel mini =new JLabel();
		mini.setBounds(20,140,400,200);
		add(mini);
		
		JLabel bank =new JLabel("Bharat Bank");
		bank.setBounds(150,20,100,20);
		add(bank);
		
		JLabel card =new JLabel();
		card.setBounds(20,80,300,20);
		add(card);
		
		try {
			Connections c=new Connections();
			ResultSet rs=c.s.executeQuery("Select * from login where Pin_Number=' 7941'");
			while(rs.next()) {
				card.setText("Card Number : "+"XXXX-XXXX-XXXX-"+rs.getString("card_Number").substring(11,15));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Connections c=new Connections();
			ResultSet rs=c.s.executeQuery("Select * from bank where Pin='"+pin+"'");
			while (rs.next()) {
				mini.setText(mini.getText() +"<html>"+ rs.getString("Date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Ammount")+"<br><br><html>");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	public static void main(String[] args) {
		new Ministatement("");
	}
}
