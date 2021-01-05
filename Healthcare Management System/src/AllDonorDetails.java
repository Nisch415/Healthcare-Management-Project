import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.sql.*;
import Project.ConnectBloodBank;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


public class AllDonorDetails extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllDonorDetails frame = new AllDonorDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AllDonorDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 501);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("All Donor Details");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 23));
		lblNewLabel.setBounds(256, 10, 219, 53);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 79, 746, 2);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 114, 708, 232);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Donor ID", "Name", "Father Name", "Mother Name", "Date of Birth", "Contact No", "Gender", "Email", "Blood Group", "City", "Address"
			}
		));
		scrollPane.setViewportView(table);
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		try
		{
			Connection con = ConnectBloodBank.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(" select * from donor ");
			
			while(rs.next())
			{
				model.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)});
				
				
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
		}
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 410, 746, 2);
		contentPane.add(separator_1);
		
		JButton btnNewButton = new JButton("Print");
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					table.print(JTable.PrintMode.NORMAL);
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setBounds(110, 422, 97, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(561, 422, 85, 32);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\NISCHALA R\\Desktop\\java\\Healthcare Management System\\images\\BloodBankJFrame.png"));
		lblNewLabel_1.setBounds(0, 0, 780, 491);
		contentPane.add(lblNewLabel_1);
	}
}
