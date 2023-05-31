package bankmanagementsystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Fastcash extends JFrame implements ActionListener{
	JButton button100,button200,button500,button1000,button2000,button5000,button10000,back;
	String pin;
	public Fastcash(String pinno) {
		this.pin=pinno;
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
		
		JLabel text= new JLabel("Please select Ammount you want to Withdraw");
		text.setBounds(470,290,400,30);
		text.setForeground(Color.WHITE);
		imagelable.add(text);
		
		button100= new JButton("Rs 100");
		button100.setBounds(300,420,150,25);
		button100.setBackground(Color.black);
		button100.setForeground(Color.white);
		button100.addActionListener(this);
		add(button100);
		
		button200= new JButton("Rs 200 ");
		button200.setBounds(750,420,150,25);
		button200.setBackground(Color.black);
		button200.setForeground(Color.white);
		button200.addActionListener(this);
		add(button200);
		

		button500= new JButton("Rs 500");
		button500.setBounds(300,450,150,25);
		button500.setBackground(Color.black);
		button500.setForeground(Color.white);
		button500.addActionListener(this);
		add(button500);
		
		button1000= new JButton("Rs 1000");
		button1000.setBounds(750,450,150,25);
		button1000.setBackground(Color.black);
		button1000.setForeground(Color.white);
		button1000.addActionListener(this);
		add(button1000);
		
		button5000= new JButton("Rs 5000");
		button5000.setBounds(300,480,150,25);
		button5000.setBackground(Color.black);
		button5000.setForeground(Color.white);
		button5000.addActionListener(this);
		add(button5000);
	
		
		button10000= new JButton("Rs 10000");
		button10000.setBounds(750,480,150,25);
		button10000.setBackground(Color.black);
		button10000.setForeground(Color.white);
		button10000.addActionListener(this);
		add(button10000);
		
		 back= new JButton("Back");
		 back.setBounds(525,510,150,25);
		 back.setBackground(Color.black);
		 back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		setUndecorated(true);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			setVisible(false);
			new Transactions(pin).setVisible(true);
		}
		else {
			String ammount=((JButton)e.getSource()).getText().substring(3);
			Connections c=new Connections();
			try {
				ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pin+"'");
				int balance =0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposite")) {
						balance +=Integer.parseInt(rs.getString("ammount"));
					}
					else {
						balance -=	Integer.parseInt(rs.getString("ammount"));
					}
				}
				if(e.getSource()!=back && balance < Integer.parseInt(ammount)) {
					JOptionPane.showMessageDialog(null, "Insufficiant Balance");
					return;
				}
				Date date =new Date();
				String query= "insert into bank values('"+pin+"','"+date+"','Withdrawl','"+ammount+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+ammount+" Debited successfully");
				setVisible(false);
				new Transactions(pin).setVisible(true);
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}
	public static void main(String[] args) {
		new Fastcash("");
	}
}
