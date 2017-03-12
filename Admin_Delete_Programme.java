import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import javax.swing.table.*;
import javax.swing.*;

public class Admin_Delete_Programme extends JFrame{
	public static Admin_Delete_Programme delete=new Admin_Delete_Programme();
	
	private JLabel lblTitle, lblSearch;
	private JButton btnDELETE, btnMODIFY, btnBack, btnLogout, btnSearch;
	private JTextField txtSearch;
	private JPanel pnTop, pnRadioButtons, pnContent, pnDetails, pnBottom, pnResult;
	private JRadioButton rbtnCode, rbtnName;
	private ButtonGroup radioButtons;
	private JTable table;
	
	
	public Admin_Delete_Programme(){	
		super("University Of Sharpy - Delete/Modify Programme");
		Image title = new ImageIcon(this.getClass().getResource("/title.jpg")).getImage();
		
		Object[] columnNames = {"Programme Code", "Programme Name", "Select"};
        Object[][] data 
        =      	{{"001","Programme1",false},
        		{"002","Programme2",false},
        		{"003","Programme3",false},
        		{"004","Programme4",false},
        		{"005","Programme5",false},
        		{"006","Programme6",false}};
        
        
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
		table = new JTable(model){
			@Override
			public Class getColumnClass(int column) {
	            switch (column) {
	            case 0:
	                return String.class;
	            case 1:
	                return String.class;
	            default:
	                return Boolean.class;
	            }
			}
			
			@Override
	        public boolean isCellEditable(int row, int column)
	        {
	            // make read only fields except column 0,13,14
	            return column == 2;
	        }
};

		table.setRowHeight(20);
		table.setSize(new Dimension(1000,600));
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("SERIF", table.getFont().getStyle(), 16));
		
		btnDELETE = new JButton("DELETE");
		btnDELETE.setMaximumSize(new Dimension(150,40));
		btnDELETE.setPreferredSize(new Dimension(100,40));
		btnDELETE.setMinimumSize(new Dimension(50, 40));		
		
		btnMODIFY = new JButton("MODIFY");
		btnMODIFY.setMaximumSize(new Dimension(150,40));
		btnMODIFY.setPreferredSize(new Dimension(100,40));
		btnMODIFY.setMinimumSize(new Dimension(50, 40));
		
		btnBack = new JButton("BACK");
		btnBack.setMaximumSize(new Dimension(150,40));
		btnBack.setPreferredSize(new Dimension(100,40));
		btnBack.setMinimumSize(new Dimension(50, 40));
		
		btnSearch = new JButton("SEARCH");
		btnSearch.setMaximumSize(new Dimension(100,40));
		btnSearch.setPreferredSize(new Dimension(50,40));
		btnSearch.setMinimumSize(new Dimension(20, 40));
		
		btnLogout = new JButton("LOGOUT");
		
		pnTop = new JPanel();
		pnContent = new JPanel();
		pnBottom = new JPanel();
		pnDetails = new JPanel();
		pnResult = new JPanel(); 
		pnRadioButtons = new JPanel();
		
		rbtnCode = new JRadioButton("By Programme Code");
		rbtnName = new JRadioButton("By Programme Name");
		radioButtons = new ButtonGroup();
		
		radioButtons.add(rbtnCode);
		radioButtons.add(rbtnName);
		
		/*lblTitle = new JLabel("UNIVERSITY OF SHARPY");*/
		lblTitle = new JLabel("");
		lblTitle.setIcon(new ImageIcon(title));
		lblTitle.setFont(new Font(lblTitle.getFont().getName(), lblTitle.getFont().getStyle(), 22));
		lblTitle.setAlignmentX(CENTER_ALIGNMENT);
		
		lblSearch = new JLabel("Search");
		
		txtSearch = new JTextField();
		txtSearch.setMaximumSize(new Dimension(300,30));
		txtSearch.setPreferredSize(new Dimension(200,30));
		txtSearch.setMinimumSize(new Dimension(150, 30));
		
		pnTop.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnTop.add(btnLogout);
		
		pnRadioButtons.setLayout(new BoxLayout(pnRadioButtons, BoxLayout.X_AXIS));
		pnRadioButtons.add(lblSearch);
		pnRadioButtons.add(Box.createRigidArea(new Dimension(5,0)));
		pnRadioButtons.add(txtSearch);
		pnRadioButtons.add(Box.createRigidArea(new Dimension(20,0)));
		pnRadioButtons.add(rbtnCode);
		pnRadioButtons.add(Box.createRigidArea(new Dimension(5,0)));
		pnRadioButtons.add(rbtnName);
		pnRadioButtons.add(Box.createRigidArea(new Dimension(5,0)));
		pnRadioButtons.add(btnSearch);
		
		pnDetails.setLayout(new BoxLayout(pnDetails, BoxLayout.X_AXIS));
		pnDetails.add(table);
						
		pnContent.setLayout(new BoxLayout(pnContent, BoxLayout.Y_AXIS));
		pnContent.add(lblTitle);
		pnContent.add(Box.createRigidArea(new Dimension(0,10)));
		pnContent.add(pnRadioButtons);
		pnContent.add(Box.createRigidArea(new Dimension(0,20)));
		pnContent.add(pnDetails);
		
		JScrollPane jScrollPane = new JScrollPane(table);		
		pnContent.add(jScrollPane);		
		
		JScrollPane jScroll = new JScrollPane(pnContent);
		jScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		getContentPane().add(jScroll, BorderLayout.CENTER);
		
		pnBottom.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnBottom.add(btnBack);
		pnBottom.add(Box.createRigidArea(new Dimension(100,0)));
		pnBottom.add(btnDELETE);
		pnBottom.add(Box.createRigidArea(new Dimension(100,0)));
		pnBottom.add(btnMODIFY);
		
		add(pnTop, BorderLayout.PAGE_START);
		add(pnBottom, BorderLayout.PAGE_END);
		
		myHandler h=new myHandler();
		btnDELETE.addActionListener(h);
		btnBack.addActionListener(h);
		btnLogout.addActionListener(h);
		btnMODIFY.addActionListener(h);
	}
	
	class myHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			
			if(event.getSource() == btnDELETE){
				//Delete code
				int response = JOptionPane.showConfirmDialog(pnResult, "Trying To Delete","DELETE", JOptionPane.OK_CANCEL_OPTION);
				if (response == JOptionPane.YES_OPTION){
					
							for (int i = 0; i < table.getRowCount(); i++) {
							     Boolean isChecked = Boolean.valueOf(table.getValueAt(i, 2).toString());
							     if (isChecked) {
							    	 System.out.printf("Row %s is checked \n", i);
								     System.out.println("Delete Data in row" +i);
							    } else {
							        System.out.printf("Row %s is not checked \n", i);
							    }
							}
				JOptionPane.showMessageDialog(pnResult, "Delete Successfull","DELETING ", JOptionPane.PLAIN_MESSAGE);				
				}
			}
			else
				if (event.getSource() == btnBack){
					Admin_Delete_Programme.closeWindowDelete();
					Admin_Programme.createWindow();
				}
				else
					if(event.getSource() == btnMODIFY){
						//Delete code
						int response = JOptionPane.showConfirmDialog(pnResult, "Trying to Modify","MODIFY", JOptionPane.OK_CANCEL_OPTION);
						if (response == JOptionPane.YES_OPTION){
							
									for (int i = 0; i < table.getRowCount(); i++) {
									     Boolean isChecked = Boolean.valueOf(table.getValueAt(i, 2).toString());
									     if (isChecked) {
									    	 System.out.printf("Row %s is checked \n", i);
										     System.out.println("Modifying Data in row" +i);
									    } else {
									        System.out.printf("Row %s is not checked \n", i);
									    }
									}
						JOptionPane.showMessageDialog(pnResult, "Modification Saved","MODIFYING ", JOptionPane.PLAIN_MESSAGE);				
						}
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
	
	public static void createWindowDeleted(){
		delete.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		delete.setSize(1020,650);
		delete.setVisible(true);
	}
	public static void closeWindowDelete(){
		delete.dispose();
	}
}
