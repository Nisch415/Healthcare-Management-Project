import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import Project.ConnectStock;

import javax.swing.ImageIcon;

public class StockIncrease extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockIncrease frame = new StockIncrease();
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
	public StockIncrease() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 500);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JLabel lblNewLabel = new JLabel("Increase Stock");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 26));
		lblNewLabel.setBounds(242, 10, 261, 51);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 71, 746, 8);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Blood Group");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(67, 89, 95, 34);
		contentPane.add(lblNewLabel_1);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
		comboBox.setBounds(193, 89, 63, 34);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		textField.setBounds(461, 89, 81, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String BloodGroup = (String)comboBox.getSelectedItem();
				String units = textField.getText();
				
				int unit1 = Integer.parseInt(units);
				
				try
				{
					Connection con = ConnectStock.getCon();
					Statement st = con.createStatement();
					st.executeUpdate("update stock set units = units + '"+unit1+"' where BloodGroup = '"+BloodGroup+"'");
					JOptionPane.showMessageDialog(null, "Successfully Updated!");
					setVisible(false);
					new StockIncrease().setVisible(true);
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnNewButton.setBounds(617, 89, 106, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Units");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(388, 89, 63, 34);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 133, 746, 8);
		contentPane.add(separator_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 174, 447, 150);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Blood Group", "Units"
			}
		));
		scrollPane.setViewportView(table);
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		try
		{
			Connection con = ConnectStock.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(" select * from stock ");
			
			while(rs.next())
			{
				model.addRow(new Object[] {rs.getString(1),rs.getString(2)});
				
				
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
		}
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 405, 746, 8);
		contentPane.add(separator_1_1);
		
		JButton btnNewButton_1 = new JButton("Print");
		btnNewButton_1.addActionListener(new ActionListener() {
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
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btnNewButton_1.setBounds(238, 420, 95, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btnNewButton_2.setBounds(478, 423, 85, 30);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\NISCHALA R\\Desktop\\java\\Healthcare Management System\\images\\BloodBankJFrame.png"));
		lblNewLabel_3.setBounds(0, 0, 780, 483);
		contentPane.add(lblNewLabel_3);
	}
}
