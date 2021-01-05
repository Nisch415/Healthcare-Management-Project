import static javax.swing.JTable.AUTO_RESIZE_OFF;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import Project.ConnectBloodBank;
import net.proteanit.sql.DbUtils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class SearchByLocation extends JFrame {

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
					SearchByLocation frame = new SearchByLocation();
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
	public SearchByLocation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JLabel lblNewLabel = new JLabel("Search Blood Donor By Location");
		lblNewLabel.setBounds(179, 21, 376, 41);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 22));
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 72, 712, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Address");
		lblNewLabel_1.setBounds(179, 84, 74, 25);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String location = textField.getText();
				try
				{
					Connection con = ConnectBloodBank.getCon();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select *from donor where city like '%"+location+"%' or address like '%"+location+"%'");
					table.setAutoResizeMode(AUTO_RESIZE_OFF);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		textField.setBounds(306, 84, 211, 25);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		contentPane.add(textField);
		textField.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(24, 119, 712, 2);
		contentPane.add(separator_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 143, 700, 238);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(24, 405, 712, 2);
		contentPane.add(separator_2);
		
		JButton btnNewButton = new JButton("Print");
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
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnNewButton.setBounds(168, 417, 97, 37);
		contentPane.add(btnNewButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		btnClose.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnClose.setBounds(478, 417, 97, 37);
		contentPane.add(btnClose);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\NISCHALA R\\Desktop\\java\\Healthcare Management System\\images\\BloodBankJFrame.png"));
		lblNewLabel_2.setBounds(0, 0, 780, 491);
		contentPane.add(lblNewLabel_2);
		setLocationRelativeTo(null);
	}
}
