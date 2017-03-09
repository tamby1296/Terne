package mrs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class mrAdminMenu extends JFrame {

	private JLabel logo,uniName,adminMenu;
	private JButton programmeButton,studentButton,registerButton,logoutButton;
	private JPanel pN,pS,pW,pE,pC;
	
	//constructor
	public mrAdminMenu(){
		
		super("Admin Menu");
		
		setLayout(new BorderLayout());
		
		//creating components
		logo= new JLabel("LOGO");logo.setBackground(Color.green);logo.setOpaque(true);
		uniName= new JLabel("University of Sharpy");
		adminMenu= new JLabel("ADMIN MENU",SwingConstants.CENTER);adminMenu.setForeground(Color.ORANGE);
		programmeButton= new JButton("Programme");
		studentButton= new JButton("Student");
		registerButton= new JButton("Register");
		logoutButton= new JButton("Log Out");
		//creating panels
		pN= new JPanel();
		pS= new JPanel(); 
		pW= new JPanel();
		pE= new JPanel();
		pC= new JPanel();
		
		//adding panel to frame
		add(pN,BorderLayout.NORTH);
		add(pS,BorderLayout.SOUTH);
		add(pW,BorderLayout.WEST);
		add(pE,BorderLayout.EAST);
		add(pC,BorderLayout.CENTER);
		
		//adding component to respective panel
		pN.setLayout(new BorderLayout());
		pN.add(logo,BorderLayout.CENTER);
		pN.add(logoutButton,BorderLayout.EAST);
		
		pC.setLayout(new GridLayout(4, 1, 10, 10));
		pC.add(adminMenu);
		pC.add(programmeButton);
		pC.add(studentButton);
		pC.add(registerButton);
		
		
	}
	
	
}
