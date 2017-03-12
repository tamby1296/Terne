import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class Admin_Programme extends JFrame {
	
	public static Admin_Programme menuProgramme=new Admin_Programme();
		
	private JButton btnAdd, btnModify, btnDelete, btnLogout, btnBack;
	private JLabel lblTitle;
	private JPanel pnLogout, pnContent, pnButtons, pnResult, pnBottom;
	
	public Admin_Programme(){
		super("University Of Sharpy - Admin_Programme");
		
		Image title = new ImageIcon(this.getClass().getResource("/title.jpg")).getImage();
		
		btnAdd = new JButton("ADD PROGRAMME");
		btnAdd.setMaximumSize(new Dimension(300,50));
		btnAdd.setPreferredSize(new Dimension(200,50));
		btnAdd.setMinimumSize(new Dimension(150, 50));
		btnAdd.setAlignmentX(CENTER_ALIGNMENT);
		
		btnModify = new JButton("MODIFY PROGRAMME");
		btnModify.setMaximumSize(new Dimension(300,50));
		btnModify.setPreferredSize(new Dimension(200,50));
		btnModify.setMinimumSize(new Dimension(150, 50));
		btnModify.setAlignmentX(CENTER_ALIGNMENT);
		
		btnDelete = new JButton("DELETE PROGRAMME");
		btnDelete.setMaximumSize(new Dimension(300,50));
		btnDelete.setPreferredSize(new Dimension(200,50));
		btnDelete.setMinimumSize(new Dimension(150, 50));
		btnDelete.setAlignmentX(CENTER_ALIGNMENT);
		
		btnLogout = new JButton("LOGOUT");

		btnBack = new JButton("BACK");
		btnBack.setMaximumSize(new Dimension(150,40));
		btnBack.setPreferredSize(new Dimension(100,40));
		btnBack.setMinimumSize(new Dimension(50, 40));
		
		lblTitle = new JLabel("");
		lblTitle.setIcon(new ImageIcon(title));
		/*lblTitle = new JLabel("UNIVERSITY OF SHARPY");*/
		lblTitle.setFont(new Font(lblTitle.getFont().getName(), lblTitle.getFont().getStyle(), 22));
		lblTitle.setAlignmentX(CENTER_ALIGNMENT);
		
		pnLogout = new JPanel();
		pnContent = new JPanel();
		pnButtons = new JPanel();
		pnBottom  = new JPanel();
		pnResult  = new JPanel();
		
		pnLogout.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnLogout.add(btnLogout);
				
		pnContent.setLayout(new BoxLayout(pnContent, BoxLayout.Y_AXIS));
		pnContent.add(lblTitle);
		pnContent.add(Box.createRigidArea(new Dimension(10,50)));
		pnContent.add(btnAdd);
		pnContent.add(Box.createRigidArea(new Dimension(10,10)));
		pnContent.add(btnModify);
		pnContent.add(Box.createRigidArea(new Dimension(10,10)));
		pnContent.add(btnDelete);
		pnContent.setAlignmentX(CENTER_ALIGNMENT);
		
		JScrollPane jScroll = new JScrollPane(pnContent);
		jScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		getContentPane().add(jScroll, BorderLayout.CENTER);
				
		pnBottom.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnBottom.add(btnBack);
		
		add(pnLogout, BorderLayout.PAGE_START);
		add(pnBottom, BorderLayout.PAGE_END);
		
		myHandler h=new myHandler();
		btnAdd.addActionListener(h);
		btnDelete.addActionListener(h);
		btnModify.addActionListener(h);
		btnLogout.addActionListener(h);
		
	}
	
	class myHandler implements ActionListener {
		public void actionPerformed(ActionEvent event){
			
			if(event.getSource() == btnLogout){
				int response = JOptionPane.showConfirmDialog(pnResult, "You are sure to LOGOUT?","LogOut", JOptionPane.OK_CANCEL_OPTION);
				
				if(response == JOptionPane.YES_OPTION){
					System.exit(0);					
				}
			}
			else
				if(event.getSource() == btnAdd){
					Admin_Add_Programme.createWindowAdd();
					Admin_Programme.closeWindow();
				}
				else
					if(event.getSource() == btnDelete){
						Admin_Delete_Programme.createWindowDeleted();
						Admin_Programme.closeWindow();
					
					}
					else
						if(event.getSource() == btnModify){
							Admin_Delete_Programme.createWindowDeleted();
							Admin_Programme.closeWindow();/*
							Modify_Programme.createWindowModify();
							Admin_Programme.closeWindow();*/
						
						}
		}
	}
	
	public static void createWindow(){
		menuProgramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuProgramme.setSize(1020,650);
		menuProgramme.setVisible(true);
	}
	
	public static void closeWindow(){
		menuProgramme.dispose();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createWindow();
		
	}

}
