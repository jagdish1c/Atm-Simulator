package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PinChange extends JFrame implements ActionListener {
	JPasswordField newpintext,renewpintext;
	JButton confirm,back;
	String pin;
	public PinChange(String pinno) {
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
		
		
		
		JLabel text= new JLabel("Change your pin");
		text.setBounds(520,290,400,30);
		text.setForeground(Color.WHITE);
		imagelable.add(text);
	

		JLabel pinnew=new JLabel("New Pin : ");
		pinnew.setBounds(300,410,400,30);
		pinnew.setForeground(Color.WHITE);
		pinnew.setFont(new Font("Raleway",Font.BOLD,20));
		imagelable.add(pinnew);
		
		JLabel pinnewl=new JLabel("Re-enter new Pin : ");
		pinnewl.setBounds(300,450,400,25);
		pinnewl.setForeground(Color.WHITE);
		pinnewl.setFont(new Font("Raleway",Font.BOLD,20));
		imagelable.add(pinnewl);
		
		
		newpintext=new JPasswordField();
		newpintext.setBounds(480,412,350,25);
		newpintext.setFont(new Font("Osward",Font.BOLD,15));
		imagelable.add(newpintext);
		
		renewpintext=new JPasswordField();
		renewpintext.setBounds(480,447,350,25);
		renewpintext.setFont(new Font("Osward",Font.BOLD,15));
		imagelable.add(renewpintext);
		
		
		confirm= new JButton("Confirm");
		confirm.setBounds(750,520,150,25);
		confirm.setBackground(Color.black);
		confirm.setForeground(Color.white);
		confirm.addActionListener(this);
		add(confirm);
		
		back= new JButton("Back");
		back.setBounds(300,520,150,25);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		
		setUndecorated(true);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==confirm) {
				if(newpintext.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter pin number ");
				}
				else {
					if(newpintext.getText().equals(renewpintext.getText())){
						try {
							
							Connections c=new Connections();
							String query1="update bank set Pin = '"+newpintext+"' where Pin='"+pin+"'";
							String query2="update login set Pin_Number = '"+newpintext+"' where Pin_Number='"+pin+"'";
							String query3="update signup3 set Pin_Number='"+newpintext+"' where Pin_Number ='"+pin+"'";
							c.s.executeUpdate(query1);
							c.s.executeUpdate(query2);
							c.s.executeUpdate(query3);
							JOptionPane.showMessageDialog(null, "Pin changed successfully");
							setVisible(false);
							new Transactions("");
						} catch (Exception e2) {
							System.out.println(e2);
						}
						
					}else {
						JOptionPane.showMessageDialog(null,"New pin and re-entered new pin does't matching" );
					}
				}	
		}else {
			setVisible(false);
			new Transactions(pin).setVisible(true);
		}
	}
	public static void main(String[] args) {
		new PinChange("");
	}
}
