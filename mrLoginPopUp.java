package moduleRegistrationAssignment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class mrLoginPopUp extends JFrame {
	private JPanel p1,p2;
	private JLabel studentIDLabel,passwordLabel,dummy1,dummy2;
	private JTextField txtStudentID;
	private JTextField txtPassword;
	private JButton loginPageLoginButton;
	private JButton cancelLogin;
	
	//constructor
	public mrLoginPopUp(){
		
		super("Login");
		
		setLayout(new BorderLayout());
		
		//creating components
		p1= new JPanel();
		p2= new JPanel();
		
		studentIDLabel= new JLabel("Student ID :",SwingConstants.RIGHT);
		studentIDLabel.setSize(20,10);
				
		passwordLabel=new JLabel("Password",SwingConstants.RIGHT);
		
		txtStudentID= new JTextField("Student ID",25);
		txtPassword= new JTextField("password",25);
		loginPageLoginButton= new JButton("LOGIN");
		cancelLogin= new JButton("Cancel");
		
		//adding panel
		add(p1,BorderLayout.NORTH);add(p2,BorderLayout.SOUTH);
		//add component to p1
		p1.setLayout(new GridLayout(2, 2,10,10));
		p1.add(studentIDLabel);
		p1.add(txtStudentID);
		p1.add(passwordLabel);
		p1.add(txtPassword);
		//add component to p1
		p2.setLayout(new GridLayout(1,2,10,10));
		p2.add(cancelLogin);
		p2.add(loginPageLoginButton);
		HandlerClass handler = new HandlerClass();
		
		txtStudentID.addActionListener(handler);
		txtPassword.addActionListener(handler);
		loginPageLoginButton.addActionListener(handler);
		cancelLogin.addActionListener(handler);
		
	}
	
	private class HandlerClass implements ActionListener{

		
		public void actionPerformed(ActionEvent event) {
			
		}
		
	}
}
