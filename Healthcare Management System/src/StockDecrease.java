import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import Project.ConnectStock;

import javax.swing.ImageIcon;

public class StockDecrease extends JFrame {

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
					StockDecrease frame = new StockDecrease();
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
	public StockDecrease() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 500);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JLabel lblNewLabel = new JLabel("Stock Decrease");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(206, 10, 318, 57);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 78, 726, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Blood Group");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(134, 89, 105, 27);
		contentPane.add(lblNewLabel_1);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
		comboBox.setBounds(249, 89, 52, 27);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Units");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(394, 89, 52, 27);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		textField.setBounds(456, 89, 96, 27);
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
					st.executeUpdate("update stock set units = units - '"+unit1+"' where BloodGroup = '"+BloodGroup+"'");
					JOptionPane.showMessageDialog(null, "Successfully Updated");
					setVisible(false);
					new StockDecrease().setVisible(true);
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btnNewButton.setBounds(629, 89, 112, 27);
		contentPane.add(btnNewButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(30, 140, 726, 2);
		contentPane.add(separator_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(198, 166, 386, 160);
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
		separator_1_1.setBounds(10, 399, 726, 2);
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
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnNewButton_1.setBounds(198, 414, 105, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnNewButton_2.setBounds(465, 414, 96, 27);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\NISCHALA R\\Desktop\\java\\Healthcare Management System\\images\\BloodBankJFrame.png"));
		lblNewLabel_3.setBounds(0, 0, 779, 495);
		contentPane.add(lblNewLabel_3);
		setLocationRelativeTo(null);
	}
}
