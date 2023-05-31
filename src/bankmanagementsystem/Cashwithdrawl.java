package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Cashwithdrawl extends JFrame implements ActionListener {
	JButton withdraw,back;
	JTextField ammount;
	String pin;
	public Cashwithdrawl(String pinno) {
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
		
		JLabel text= new JLabel("Enter ammount you want to Withdraw");
		text.setBounds(500,290,400,30);
		text.setForeground(Color.WHITE);
		
		imagelable.add(text);
		
		 ammount=new JTextField();
		ammount.setBounds(400,330,400,30);
		ammount.setFont(new Font("Raleway",Font.BOLD,20));
		add(ammount);
		
		withdraw= new JButton("Withdraw");
		withdraw.setBounds(750,420,150,25);
		withdraw.setBackground(Color.black);
		withdraw.setForeground(Color.white);
		withdraw.addActionListener(this);
		add(withdraw);
		
		back= new JButton("Back");
		back.setBounds(300,420,150,25);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==withdraw) {
			String ammountnumber=ammount.getText();
			Date date =new Date();
			if(ammountnumber.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter Ammount you want to withdraw");
			}
			else {
				try {
					Connections c=new Connections();
					String query="insert into bank values('"+pin+"','"+date+"','withdraw','"+ammountnumber+"')";
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs "+ammountnumber+" withdraw successfully");
					setVisible(false);
					new Transactions("").setVisible(true);
				} catch (SQLException e1) {
					System.out.println(e1);
				}
			}
		}else if(e.getSource()==back) {
			setVisible(false);
			new Transactions(pin).setVisible(true);
		}
	}
	public static void main(String[] args) {
		new Cashwithdrawl("");
	}
}
