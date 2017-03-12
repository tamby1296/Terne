import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.table.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class MR_EnrollModule extends JFrame{
	
	private JButton btnLogout, btnRegister;
	private JTextField txtID, txtName, txtProgramme, txtYear;
	private JLabel lblTitle, lblName, lblID, lblProgramme, lblYear, lblBlank;
	private JPanel pnLogout, pnContent, pnTitle, pnDetails, pnDetail1, pnDetail2, pnDisplay, pnBottom, pnResult;
	private JTable table;
	
	public MR_EnrollModule(){
		super("University Of Sharpy - Enroll to Module");
		Image title = new ImageIcon(this.getClass().getResource("/title.jpg")).getImage();
		
//table	
		Object[] columnNames = {"Module Code", "Module Name", "Credits", "Register"};
        Object[][] data 
        =      	{{"001","Module1","6",false},
        		{"002","Module2","6",false},
        		{"003","Module3","6",false},
        		{"004","Module4","6",false},
        		{"005","Module5","6",false},
        		{"006","Module6","6",false}};
        
        
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
		table = new JTable(model){
			@Override
			public Class getColumnClass(int column) {
	            switch (column) {
	            case 0:
	                return String.class;
	            case 1:
	                return String.class;
	            case 2:
	            	return String.class;
	            default:
	                return Boolean.class;
	            }
			}
			
			@Override
	        public boolean isCellEditable(int row, int column)
	        {
	            // make read only fields except column 0,13,14
	            return column == 3;
	        }
};
		
		table.setRowHeight(20);
		table.setSize(new Dimension(1000,600));
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("SERIF", table.getFont().getStyle(), 16));
//table
		btnLogout = new JButton("LOGOUT");
		btnRegister= new JButton("REGISTER");
		btnRegister.setMaximumSize(new Dimension(150,40));
		btnRegister.setPreferredSize(new Dimension(100,40));
		btnRegister.setMinimumSize(new Dimension(50, 40));
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setMaximumSize(new Dimension(300,20));
		txtID.setPreferredSize(new Dimension(200,20));
		txtID.setMinimumSize(new Dimension(150, 20));
		txtID.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setMaximumSize(new Dimension(300,20));
		txtName.setPreferredSize(new Dimension(200,20));
		txtName.setMinimumSize(new Dimension(150, 20));
		txtName.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
		
		txtProgramme = new JTextField();
		txtProgramme.setEditable(false);
		txtProgramme.setMaximumSize(new Dimension(300,20));
		txtProgramme.setPreferredSize(new Dimension(200,20));
		txtProgramme.setMinimumSize(new Dimension(150, 20));
		txtProgramme.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
		
		txtYear = new JTextField();
		txtYear.setEditable(false);
		txtYear.setMaximumSize(new Dimension(300,20));
		txtYear.setPreferredSize(new Dimension(200,20));
		txtYear.setMinimumSize(new Dimension(150, 20));
		txtYear.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
		
		lblTitle = new JLabel("");
		lblTitle.setIcon(new ImageIcon(title));
		/*lblTitle = new JLabel("UNIVERSITY OF SHARPY");*/
		lblTitle.setFont(new Font(lblTitle.getFont().getName(), lblTitle.getFont().getStyle(), 22));
		lblTitle.setAlignmentX(CENTER_ALIGNMENT);
		
		lblName = new JLabel("Name: ");
		lblName.setFont(new Font("SERIF", lblTitle.getFont().getStyle(), 14));
		lblName.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		
		lblID = new JLabel("ID: ");
		lblID.setFont(new Font("PLAIN", lblTitle.getFont().getStyle(), 14));
		lblID.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		
		lblProgramme = new JLabel("Programme: ");
		lblProgramme.setFont(new Font("SERIF", lblTitle.getFont().getStyle(), 14));
		lblProgramme.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		
		lblYear = new JLabel("Year: ");
		lblYear.setFont(new Font("PLAIN", lblTitle.getFont().getStyle(), 14));
		lblYear.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		
		lblBlank = new JLabel("TABLE");
		lblBlank.setMaximumSize(new Dimension(1200,20));
		lblBlank.setPreferredSize(new Dimension(1000,500));
		lblBlank.setMinimumSize(new Dimension(150, 20));
		
		pnLogout = new JPanel();
		pnContent = new JPanel();
		pnTitle = new JPanel();
		pnDetails = new JPanel();
		pnDetail1 = new JPanel();
		pnDetail2 = new JPanel();
		pnDisplay = new JPanel();
		pnBottom = new JPanel();
		pnResult = new JPanel();
		
		pnLogout.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnLogout.add(btnLogout);
		
		pnBottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnBottom.add(btnRegister);
		
		pnDetail1.setLayout(new BoxLayout(pnDetail1, BoxLayout.Y_AXIS));
		pnDetail1.add(lblID);
		pnDetail1.add(Box.createRigidArea(new Dimension(0,5)));
		pnDetail1.add(lblName);
		pnDetail1.add(Box.createRigidArea(new Dimension(0,5)));
		pnDetail1.add(lblProgramme);
		pnDetail1.add(Box.createRigidArea(new Dimension(0,5)));
		pnDetail1.add(lblYear);
		
		pnDetail2.setLayout(new BoxLayout(pnDetail2, BoxLayout.Y_AXIS));
		pnDetail2.add(txtID);
		pnDetail2.add(Box.createRigidArea(new Dimension(0,5)));
		pnDetail2.add(txtName);
		pnDetail2.add(Box.createRigidArea(new Dimension(0,5)));
		pnDetail2.add(txtProgramme);
		pnDetail2.add(Box.createRigidArea(new Dimension(0,5)));
		pnDetail2.add(txtYear);
		
		pnDetails.setLayout(new BoxLayout(pnDetails, BoxLayout.X_AXIS));
		pnDetails.add(pnDetail1);
		pnDetails.add(Box.createRigidArea(new Dimension(5,0)));
		pnDetails.add(pnDetail2);
		
		pnContent.setLayout(new BoxLayout(pnContent, BoxLayout.Y_AXIS));
		pnContent.add(lblTitle);
		pnContent.add(Box.createRigidArea(new Dimension(0,30)));
		pnContent.add(pnDetails);
		pnContent.add(Box.createRigidArea(new Dimension(0,50)));

//scroll bar for JPane pnContent		
		JScrollPane jScrollPane = new JScrollPane(table);		
		pnContent.add(jScrollPane);
		
		JScrollPane jScroll = new JScrollPane(pnContent);
		jScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		getContentPane().add(jScroll, BorderLayout.CENTER);
//scroll bar for JPane pnContent		
		
		add(pnLogout, BorderLayout.PAGE_START);
		add(pnBottom, BorderLayout.PAGE_END);
				
		ActionHandler h = new ActionHandler();
		btnLogout.addActionListener(h);
		btnRegister.addActionListener(h);
					
	}
	
	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == btnLogout){
				int response = JOptionPane.showConfirmDialog(pnResult, "You are sure to LOGOUT?","LogOut", JOptionPane.OK_CANCEL_OPTION);
				
				if(response == JOptionPane.YES_OPTION){
					System.exit(0);					
				}
			}
			else
				if(event.getSource() == btnRegister){
					
					for (int i = 0; i < table.getRowCount(); i++) {
					     Boolean isChecked = Boolean.valueOf(table.getValueAt(i, 3).toString());
					     if (isChecked) {
					    	 System.out.printf("Row %s is checked \n", i);
					    } else {
					        System.out.printf("Row %s is not checked \n", i);
					    }
					}


						JOptionPane.showMessageDialog(pnResult, "Register SuccessFull");
				}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MR_EnrollModule menu=new MR_EnrollModule();
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setSize(1620,750);
		menu.setVisible(true);
	}

}
