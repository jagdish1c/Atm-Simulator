package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class Signup extends JFrame implements ActionListener{
	JLabel pdetails,name,fname,dob,gender,email,maritals,address,city,state,pincode;
	JTextField name1,fname1,date1,email1,address1,city1,state1,pincode1;
	JRadioButton male,female,married,unmarried,other,othermarital;
	JButton back,next;
	
	Signup(){
		getContentPane().setBackground(Color.white);
		setSize(850,800);
		setLocation(350,10);
		setTitle("Automated teller machine ( ATM )");
		setVisible(true);	
		setLayout(null);
		
		 pdetails =new JLabel("Personal information ( Page1 )");
		pdetails.setFont(new Font("Raleway",Font.BOLD,20));
		pdetails.setBounds(300,50,300,40);
		add(pdetails);
		
		 name =new JLabel("Name: ");
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(150,150,200,30);
		add(name);
		
		 fname =new JLabel("Father's Name: ");
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		fname.setBounds(150,200,200,30);
		add(fname);
		
		 dob =new JLabel("Date of Birth: ");
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		dob.setBounds(150,250,200,30);
		add(dob);
		
		 gender =new JLabel("Gender: ");
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		gender.setBounds(150,300,200,30);
		add(gender);
		
		 email =new JLabel("Email-Id: ");
		email.setFont(new Font("Raleway",Font.BOLD,20));
		email.setBounds(150,350,200,30);
		add(email);
		
		
		 maritals =new JLabel("Marital Status: ");
		maritals.setFont(new Font("Raleway",Font.BOLD,20));
		maritals.setBounds(150,400,200,30);
		add(maritals);
		
		 address =new JLabel("Address: ");
		address.setFont(new Font("Raleway",Font.BOLD,20));
		address.setBounds(150,450,200,30);
		add(address);
		
		 city =new JLabel("City: ");
		city.setFont(new Font("Raleway",Font.BOLD,20));
		city.setBounds(150,500,200,30);
		add(city);
		
		 state =new JLabel("State: ");
		state.setFont(new Font("Raleway",Font.BOLD,20));
		state.setBounds(150,550,200,30);
		add(state);
		
		 pincode =new JLabel("Pincode: ");
		pincode.setFont(new Font("Raleway",Font.BOLD,20));
		pincode.setBounds(150,600,200,30);
		add(pincode);
		
		 name1=new JTextField();
		name1.setFont(new Font("Raleway",Font.BOLD,20));
		name1.setBounds(300,150,400,30);
		add(name1);
		
	    fname1=new JTextField();
	   fname1.setFont(new Font("Raleway",Font.BOLD,20));
	   fname1.setBounds(300,200,400,30);
	   add(fname1);
	   
	    date1=new JTextField();
	   date1.setFont(new Font("Raleway",Font.BOLD,20));
	   date1.setBounds(300,250,400,30);
	   add(date1); 
	   
	      male=new JRadioButton("Male");
	    male.setBounds(300,300,80,30);
	    male.setBackground(Color.white);
	    add(male);
	 
	      female=new JRadioButton("Female");
	    female.setBounds(430,300,80,30);
	    female.setBackground(Color.white);
	    add(female);
	    
	    other=new JRadioButton("Other");
	    other.setBounds(580,300,80,30);
	    other.setBackground(Color.white);
	    add(other);
	    
	    ButtonGroup bg=new ButtonGroup();
	    bg.add(male);
	    bg.add(female);
	    bg.add(other);
	    
	    email1=new JTextField();
	   email1.setFont(new Font("Raleway",Font.BOLD,20));
	   email1.setBounds(300,350,400,30);
		add(email1);
		
		  married=new JRadioButton("Married");
		married.setBounds(300,400,80,30);
		married.setBackground(Color.white);
	    add(married);
	 
	      unmarried=new JRadioButton("Unmarried");
	    unmarried.setBounds(430,400,90,30);
	    unmarried.setBackground(Color.white);
	    add(unmarried);
	    
	      othermarital=new JRadioButton("Others");
	    othermarital.setBounds(580,400,80,30);
	    othermarital.setBackground(Color.white);
	    add(othermarital);
	    
	    ButtonGroup bgmarital=new ButtonGroup();
	    bgmarital.add(married);
	    bgmarital.add(unmarried);
	    bgmarital.add(othermarital);
	    
	    
		 address1=new JTextField();
		address1.setFont(new Font("Raleway",Font.BOLD,20));
		address1.setBounds(300,450,400,30);
	    add(address1);
	    
	     city1=new JTextField();
	    city1.setFont(new Font("Raleway",Font.BOLD,20));
	    city1.setBounds(300,500,400,30);
	    add(city1);
	    
	     state1=new JTextField();
	    state1.setFont(new Font("Raleway",Font.BOLD,20));
	    state1.setBounds(300,550,400,30);
	    add(state1); 
	    
	     pincode1=new JTextField();
	    pincode1.setFont(new Font("Raleway",Font.BOLD,20));
		pincode1.setBounds(300,600,400,30);
	    add(pincode1);
	    
	      next =new JButton("Next");
	     next.setBackground(Color.black);
	     next.setForeground(Color.white);
	    next.setBounds(550,670,90,30);
	    next.addActionListener(this);
	    add(next); 
	    
	    back =new JButton("Back");
	     back.setBackground(Color.black);
	     back.setForeground(Color.white);
	    back.setBounds(350,670,90,30);
	    back.addActionListener(this);
	    add(back); 
	}
	 @Override
	public void actionPerformed(ActionEvent e) {
		 String name=name1.getText();
		 String fathername=fname1.getText();
		String dateofbirth=date1.getText(); 
		String gender=null;
		 if(male.isSelected() ) {
			 gender="Male";
		 }else if(female.isSelected()) {
			 gender="Female";
		 }else if(other.isSelected()) {
			 gender="Other";
		 }
		 String emailid=email1.getText();
		 String marital=null;
		 if(married.isSelected() ) {
			 marital="Married";
		 }else if(unmarried.isSelected()) {
			 marital="Unmarried";
		 }else if(othermarital.isSelected()) {
			 marital="Other";
		 } 
		if(e.getSource()== back ) {
			setVisible(false);
			new Login().setVisible(true);
			
		}
		String address=address1.getText();
		String city =city1.getText();
		String state=state1.getText();
		String pincode=pincode1.getText();
		
		try {
			if(name.equals("")) {
			JOptionPane.showMessageDialog(null, "Name is Required");
			}
			else {
				Connections c=new Connections();
				String query="insert into Signup1 values ('"+name+"','"+fathername+"','"+dateofbirth+"','"+gender+"','"+emailid+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
				c.s.executeUpdate(query);
				setVisible(false);
				new Signup2().setVisible(true);
			}
		} catch (Exception e2) {
			System.out.println(e2);
		}
	}
	public static void main(String[] args) {
		new Signup();
	}
}
