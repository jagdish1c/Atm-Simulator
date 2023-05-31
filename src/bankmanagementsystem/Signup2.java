package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

 final public class Signup2 extends JFrame implements ActionListener{
	 JComboBox rel,cat,inc,edu,ocu;
	 JTextField panno,aadharno;
	 JButton nextforpage2,backforpage2;
	 JRadioButton existingaccountyes, existingaccountno,yes ,no;
	String []v= {"Job","Bussiness","Freelancing","Housewife"};
	String []w= {"SSC","HSC","Graduate","Masters","PHD"};
	String []x={"Hindu","Muslim","Sikh","Christian","Ohters"};
	String []y={"General","ST","SC","OBC"};
	String []z= {"15,000-25,000","25,000-35,000","35,000-50,000","< 50,000"}; 
	
	 Signup2(){
		setSize(850,800);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Automated teller machine ( ATM )");
		setLocation(350, 10);
		setVisible(true);
		setLayout(null);
		
		    JLabel pdetails=new JLabel("Personal information ( Page 2 )");
			pdetails.setFont(new Font("Raleway",Font.BOLD,20));
			pdetails.setBounds(300,50,300,40);
			add(pdetails);
			
			JLabel religion =new JLabel("Religion: ");
			religion.setFont(new Font("Raleway",Font.BOLD,20));
			religion.setBounds(150,150,200,30);
			add(religion);
			
				JLabel  category =new JLabel("Category: ");
				category.setFont(new Font("Raleway",Font.BOLD,20));
				category.setBounds(150,200,200,30);
				add(category);
				
				JLabel  income =new JLabel("Income: ");
				income.setFont(new Font("Raleway",Font.BOLD,20));
				income.setBounds(150,250,200,30);
				add(income);
				
				JLabel  education =new JLabel("Education: ");
				education.setFont(new Font("Raleway",Font.BOLD,20));
				education.setBounds(150,300,200,30);
				add(education);
				
				JLabel  occupation =new JLabel("Occuoption: ");
				occupation.setFont(new Font("Raleway",Font.BOLD,20));
				occupation.setBounds(150,350,200,30);
				add(occupation);
				
				JLabel  pancard =new JLabel("PAN Number: ");
				pancard.setFont(new Font("Raleway",Font.BOLD,20));
				pancard.setBounds(150,400,200,30);
				add(pancard);
				
				JLabel  aadhar =new JLabel("Aadhar Number: ");
				aadhar.setFont(new Font("Raleway",Font.BOLD,20));
				aadhar.setBounds(150,450,200,30);
				add(aadhar);
				
				JLabel  seniour =new JLabel("Seniour Citizen: ");
				seniour.setFont(new Font("Raleway",Font.BOLD,20));
				seniour.setBounds(150,500,200,30);
				add(seniour);
				

				JLabel  existingaccount =new JLabel("Existing Account: ");
				existingaccount.setFont(new Font("Raleway",Font.BOLD,20));
				existingaccount.setBounds(150,550,200,30);
				add(existingaccount);
				
				 rel=new JComboBox(x);
				rel.setBounds(350,150,400,30);
				rel.setBackground(Color.white);
				add(rel);
				
				 yes=new JRadioButton("Yes");
				yes.setBounds(350,500,80,30);
				yes.setBackground(Color.white);
				    add(yes);
				 
				      no=new JRadioButton("No");
				    no.setBounds(550,500,80,30);
				    no.setBackground(Color.white);
				    add(no);
				   
				    ButtonGroup bg=new ButtonGroup();
				    bg.add(yes);
				    bg.add(no);
				    
				     cat=new JComboBox(y);
					cat.setBounds(350,200,400,30);
					cat.setBackground(Color.white);
					add(cat);
					
				    inc=new JComboBox(z);
				   inc.setBounds(350,250,400,30);
				   inc.setBackground(Color.white);
				   add(inc);
			
				    edu=new JComboBox(w);
				   edu.setBounds(350,300,400,30);
				   edu.setBackground(Color.white);
				   add(edu);
					 
				  ocu=new JComboBox(v);
				 ocu.setBounds(350,350,400,30);
				 ocu.setBackground(Color.white);
				 add(ocu);
				 
				  panno=new JTextField("");
				 panno.setFont(new Font("Raleway",Font.BOLD,10));
				 panno.setBounds(350,400,400,30);
				 add(panno);
				 
				  aadharno=new JTextField("");
				 aadharno.setFont(new Font("Raleway",Font.BOLD,10));
				 aadharno.setBounds(350,450,400,30);
				 add(aadharno);
						 
				  existingaccountyes=new JRadioButton("Yes");
				 existingaccountyes.setBounds(350,550,80,30);
				 existingaccountyes.setBackground(Color.white);
				add(existingaccountyes);
					 
			    existingaccountno=new JRadioButton("No");
			    existingaccountno.setBounds(550,550,80,30);
			    existingaccountno.setBackground(Color.white);
				add(existingaccountno);
					   
					    ButtonGroup existingaccountbuttongroup=new ButtonGroup();
					    existingaccountbuttongroup.add(existingaccountyes);
					    existingaccountbuttongroup.add(existingaccountno);
					    
					     backforpage2=new JButton("Back");
					    backforpage2.setBounds(350,650,80,30);
					    backforpage2.setBackground(Color.black);
					    backforpage2.setForeground(Color.white);
					    backforpage2.addActionListener(this);
					    add(backforpage2);
					    
					    nextforpage2=new JButton("Next");
					    nextforpage2.setBounds(550,650,80,30);
					    nextforpage2.setBackground(Color.black);
					    nextforpage2.setForeground(Color.white);
					    nextforpage2.addActionListener(this);
					    add(nextforpage2);
	}
	
	public void actionPerformed(ActionEvent e) {
		String religion1=(String)rel.getSelectedItem();
		String category=(String)cat.getSelectedItem();
		String income=(String)inc.getSelectedItem();
		String education=(String)edu.getSelectedItem();
		String occupation=(String)ocu.getSelectedItem();
		String pannumber=panno.getText();
		String aadharnumber=aadharno.getText();
		String existingaccount=null;
		String seniourcitizen=null;
		if(existingaccountyes.isSelected()) {
			existingaccount="Yes";
		}
		else if(existingaccountno.isSelected()) {
			existingaccount="No";
		}
		if(yes.isSelected()) {
			seniourcitizen="Yes";
		} 
		else if(no.isSelected()) {
			seniourcitizen="No";
		}
		try {
			Connections c=new Connections();
			String query1="insert into Signup2 values('"+religion1+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pannumber+"','"+aadharnumber+"','"+seniourcitizen+"','"+existingaccount+"')";
			c.s.executeUpdate(query1);
		} catch (Exception e2) {
			System.out.println(e2);
		}
		if(e.getSource()==nextforpage2) {
			setVisible(false);
			new Signup3().setVisible(true);
		}else if(e.getSource()==backforpage2) {
			setVisible(false);
			new Signup().setVisible(true);
		}
	}
	 public static void main(String[] args) {
		 new Signup2();
	}
}
