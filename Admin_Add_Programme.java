
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Formatter;

import javax.swing.*;

@SuppressWarnings("serial")
public class Admin_Add_Programme extends JFrame{	
	public static Admin_Add_Programme add=new Admin_Add_Programme();
	
	private JTextField txtName,  txtCode;
	private JLabel lblName, lblCode, lblTitle;
	private JButton btnAdd, btnBack, btnLogout;
	private JPanel pnTop, pnContent, pnLabels, pnText, pnDetails, pnBottom, pnResult;
	
	public Admin_Add_Programme(){
		super("University Of Sharpy - Add Programme");
		Image title = new ImageIcon(this.getClass().getResource("/title.jpg")).getImage();
		
		txtName = new JTextField();
		txtName.setMaximumSize(new Dimension(300,30));
		txtName.setPreferredSize(new Dimension(200,30));
		txtName.setMinimumSize(new Dimension(150, 30));
		
		txtCode = new JTextField();
		txtCode.setMaximumSize(new Dimension(300,30));
		txtCode.setPreferredSize(new Dimension(200,30));
		txtCode.setMinimumSize(new Dimension(150, 30));
				
		lblName = new JLabel("Programme Name: ");
		lblName.setFont(new Font(lblName.getFont().getName(), lblName.getFont().getStyle(), 16));
		lblCode = new JLabel("Programme Code: ");
		lblCode.setFont(new Font(lblCode.getFont().getName(), lblCode.getFont().getStyle(), 16));
		/*lblTitle = new JLabel("UNIVERSITY OF SHARPY");*/
		lblTitle = new JLabel("");
		lblTitle.setIcon(new ImageIcon(title));
		lblTitle.setFont(new Font(lblTitle.getFont().getName(), lblTitle.getFont().getStyle(), 22));
		lblTitle.setAlignmentX(CENTER_ALIGNMENT);
		
		pnTop = new JPanel();
		pnContent = new JPanel();
		pnBottom = new JPanel();
		pnLabels = new JPanel();
		pnText = new JPanel();
		pnDetails = new JPanel();
		pnResult = new JPanel();     
		
		btnAdd = new JButton("ADD");
		btnAdd.setMaximumSize(new Dimension(150,40));
		btnAdd.setPreferredSize(new Dimension(100,40));
		btnAdd.setMinimumSize(new Dimension(50, 40));
		
		btnBack = new JButton("BACK");
		btnBack.setMaximumSize(new Dimension(150,40));
		btnBack.setPreferredSize(new Dimension(100,40));
		btnBack.setMinimumSize(new Dimension(50, 40));
		
		btnLogout = new JButton("LOGOUT");
		
		pnTop.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnTop.add(btnLogout);
				
		pnLabels.setLayout(new BoxLayout(pnLabels, BoxLayout.Y_AXIS));
		pnLabels.add(lblName);
		pnLabels.add(Box.createRigidArea(new Dimension(0,10)));
		pnLabels.add(lblCode);
		
		pnText.setLayout(new BoxLayout(pnText, BoxLayout.Y_AXIS));
		pnText.add(txtName);
		pnText.add(Box.createRigidArea(new Dimension(0,10)));
		pnText.add(txtCode);
		
		
		pnDetails.setLayout(new BoxLayout(pnDetails, BoxLayout.X_AXIS));
		pnDetails.add(pnLabels);
		pnDetails.add(Box.createRigidArea(new Dimension(10,0)));
		pnDetails.add(pnText);
		
		pnContent.setLayout(new BoxLayout(pnContent, BoxLayout.Y_AXIS));
		pnContent.add(lblTitle);
		pnContent.add(Box.createRigidArea(new Dimension(0,50)));
		pnContent.add(pnDetails);
		
		JScrollPane jScroll = new JScrollPane(pnContent);
		jScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		getContentPane().add(jScroll, BorderLayout.CENTER);
		
		pnBottom.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnBottom.add(btnBack);
		pnBottom.add(Box.createRigidArea(new Dimension(500,0)));
		pnBottom.add(btnAdd);
		
		add(pnTop, BorderLayout.PAGE_START);
		add(pnBottom, BorderLayout.PAGE_END);

		myHandler h=new myHandler();
		btnAdd.addActionListener(h);
		btnBack.addActionListener(h);
		btnLogout.addActionListener(h);
		
	}

	class myHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			
			if(event.getSource() == btnAdd){
				if(txtName.getText().equals("") || txtCode.getText().equals("") ){
					JOptionPane.showMessageDialog(pnResult, "Please Fill all details","Trying to Save", JOptionPane.ERROR_MESSAGE);
				}
				else{
					// Save Details.
					int response = JOptionPane.showConfirmDialog(pnResult, "You are sure to SAVE?","Adding ...", JOptionPane.OK_CANCEL_OPTION);
					
					if(response == JOptionPane.YES_OPTION){
						try{
							Formatter outfile = new Formatter("Programme_Details.txt");
							outfile.format("Programe_Name: %s \nProgramme_Code: %s", txtName.getText(),txtCode.getText());
							outfile.close();
							}
							catch (FileNotFoundException fnfe){
							System.out.println(fnfe);
							}
							catch (SecurityException se){
							System.out.println (se);
							}				
							
						JOptionPane.showMessageDialog(pnResult, "Save Successfull","Saving ... ", JOptionPane.PLAIN_MESSAGE);
						txtCode.setText("");
						txtName.setText("");
					}
				}
			}
			else
				if (event.getSource() == btnBack){
					Admin_Add_Programme.closeWindowAdd();
					Admin_Programme.createWindow();
				}
				else
				{
					int response = JOptionPane.showConfirmDialog(pnResult, "You are sure to LOGOUT?","LogOut", JOptionPane.OK_CANCEL_OPTION);
					if (response == JOptionPane.YES_OPTION){
						System.exit(0);					
					}
			}
		}
	}
	
	public static void createWindowAdd(){
		add.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		add.setSize(1020,650);
		add.setVisible(true);
	}
	public static void closeWindowAdd(){
		add.dispose();
	}
}
	

