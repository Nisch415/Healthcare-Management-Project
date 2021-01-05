import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import Project.ConnectBloodBank;

public class UpdateDonor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDonor frame = new UpdateDonor();
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
	public UpdateDonor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JLabel lblNewLabel = new JLabel("Update Donor Details");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 26));
		lblNewLabel.setBounds(220, 10, 269, 42);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(29, 76, 708, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Donor ID");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(138, 88, 82, 26);
		contentPane.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textArea.setBounds(528, 272, 209, 90);
		contentPane.add(textArea);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		textField.setBounds(255, 88, 103, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String donorID = textField.getText();
				try
				{
					Connection con = ConnectBloodBank.getCon();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select *from donor where donorID = '"+donorID+"'");
					if(rs.next())
					{
						textField_1.setText(rs.getString(2));
						textField_2.setText(rs.getString(3));
						textField_3.setText(rs.getString(4));
						textField_4.setText(rs.getString(5));
						textField_5.setText(rs.getString(6));
						textField_6.setText(rs.getString(7));
						textField_7.setText(rs.getString(8));
						textField_8.setText(rs.getString(9));
						textField_9.setText(rs.getString(10));
						textArea.setText(rs.getString(11));
						textField.setEditable(false);
						
						
					}
					else
						JOptionPane.showMessageDialog(null, "Donor ID does not exist");
				}
				catch(Exception e1)
				{
					
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnNewButton.setBounds(477, 88, 103, 26);
		contentPane.add(btnNewButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(29, 128, 708, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 153, 104, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Father Name");
		lblNewLabel_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 201, 104, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mother Name");
		lblNewLabel_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 237, 104, 25);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Date of Birth");
		lblNewLabel_5.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 276, 104, 25);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Contact No");
		lblNewLabel_6.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 313, 104, 25);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Gender");
		lblNewLabel_7.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(10, 350, 104, 25);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Email");
		lblNewLabel_8.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(407, 156, 76, 25);
		contentPane.add(lblNewLabel_8);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_1.setBounds(122, 153, 150, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_2.setBounds(122, 201, 150, 23);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_3.setBounds(122, 237, 150, 23);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_4.setBounds(122, 276, 150, 23);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_5.setBounds(122, 313, 150, 23);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_6.setBounds(122, 349, 150, 23);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Blood Group");
		lblNewLabel_9.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(407, 204, 103, 25);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("City");
		lblNewLabel_10.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(407, 237, 76, 25);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Address");
		lblNewLabel_11.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(407, 276, 76, 25);
		contentPane.add(lblNewLabel_11);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_7.setBounds(528, 150, 209, 23);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_8.setBounds(528, 198, 209, 23);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textField_9.setBounds(528, 234, 209, 23);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(29, 388, 708, 2);
		contentPane.add(separator_1_1);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String donorID = textField.getText();
				String name = textField_1.getText();
				String FatherName = textField_2.getText();
				String MotherName = textField_3.getText();
				String dob = textField_4.getText();
				String ContactNo = textField_5.getText();
				String gender = textField_6.getText();
				String email = textField_7.getText();
				String BloodGroup = textField_8.getText();
				String city = textField_9.getText();
				String address = textArea.getText();
				
				try
				{
					Connection con = ConnectBloodBank.getCon();
					Statement st = con.createStatement();
					st.executeUpdate("update donor set name ='"+name+"',FatherName ='"+FatherName+"',MotherName = '"+MotherName+"',dob ='"+dob+"',ContactNo='"+ContactNo+"',gender = '"+gender+"',email='"+email+"',BloodGroup = '"+BloodGroup+"',city ='"+city+"',address='"+address+"' where donorID = '"+donorID+"'");
					JOptionPane.showMessageDialog(null, "Updated!");
					setVisible(false);
					new UpdateDonor().setVisible(true);
					
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"Connection error");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		btnNewButton_1.setBounds(111, 424, 107, 32);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Reset");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				new UpdateDonor().setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		btnNewButton_1_1.setBounds(333, 424, 90, 32);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Close");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
			}
		});
		btnNewButton_1_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		btnNewButton_1_2.setBounds(561, 424, 90, 32);
		contentPane.add(btnNewButton_1_2);
		Image img = new ImageIcon(this.getClass().getResource("/BloodBankJFrame.png")).getImage();
		JLabel lblNewLabel_12 = new JLabel();
		lblNewLabel_12.setIcon(new ImageIcon(img));
		lblNewLabel_12.setBounds(0, 0, 781, 496);
		contentPane.add(lblNewLabel_12);
	}
}
