package bankmanagementsystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;


public class Login extends JFrame implements ActionListener{
	JButton signin,clearbutton,signup;
	JTextField jtext;
	JPasswordField jpin;
	Login(){
		
		
		setSize(800,500);
		setTitle("Automated teller machine ( ATM )");
		setLocation(400, 175);   
		getContentPane().setBackground(Color.WHITE);     
		setLayout(null);
		
		
		ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i1=icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(i1);
		
		//For setting main image.
		JLabel j=new JLabel(i2);
		j.setBounds(70, 10, 100, 100);
		add(j);
		
        //For setting welcome text and font of text.
		JLabel jt=new JLabel("Welcome to ATM");
		jt.setBounds(300,40,400,40);
		jt.setFont(new Font("Osward",Font.BOLD,38));
		add(jt);
		
		//for adding  card number
		JLabel cardNo=new JLabel("Card No : ");
		cardNo.setBounds(80,130,400,40);
		cardNo.setFont(new Font("Raleway",Font.BOLD,25));
		add(cardNo);
		
		//for adding pin number and text fields.
		JLabel pin=new JLabel("Pin : ");
		pin.setBounds(80,190,400,40);
		pin.setFont(new Font("Raleway",Font.BOLD,25));
		add(pin);
		
		JLabel trouble=new JLabel("Any trouble? contact 7021442264 ");
		trouble.setBounds(50,300,300,40);
		trouble.setForeground(Color.RED);
		trouble.setFont(new Font("Raleway",Font.BOLD,10));
		add(trouble);
		
		 jtext=new JTextField();
		jtext.setBounds(290, 140, 320, 30);
		add(jtext);
		
		 jpin=new JPasswordField();
		jpin.setBounds(290, 200, 320, 30);
		jpin.setVisible(true);
		add(jpin);
		
		//For adding sign in button.
		signin=new JButton("Sign in");
		signin.setBounds(290,280,150,30);
		signin.addActionListener(this);
		signin.setBackground(Color.black);
		signin.setForeground(Color.white);
		add(signin);
		
		//For adding Clear button.
		clearbutton=new JButton("Clear");
		clearbutton.setBounds(460,280,150,30);
		clearbutton.addActionListener(this);
		clearbutton.setBackground(Color.black);
		clearbutton.setForeground(Color.white);
		add(clearbutton);
		//For adding sign up button.
		
		 signup=new JButton("Sign Up");
		 signup.setBounds(290,320,320,30);
		 signup.addActionListener(this);
		 signup.setBackground(Color.black);
		 signup.setForeground(Color.white);
		add(signup);
		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {  // method for actionListner
		if(e.getSource()== signin ) {     //if sign in button pressed
			if(jtext.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Enter card and pin number");
			}else {
				try {
					Connections c=new Connections();
					String cardnumber=jtext.getText();
					String pinno=jpin.getText();
					String qury="select * from login where card_Number= '"+cardnumber+"' and Pin_Number ='"+pinno+"'";
					ResultSet rs=c.s.executeQuery(qury);
					if(rs.next()) {
						setVisible(false);
						new Transactions(pinno).setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin Number ");
					}
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		
		}else if(e.getSource()==clearbutton) {    //if clear button pressed
			jtext.setText("");
			jpin.setText("");
		}else if(e.getSource()==signup) {   //if sign up button pressed
			setVisible(false);
			new Signup().setVisible(true);
		}
	}
	public static void main(String[] args) {
		new Login();
	}
}
