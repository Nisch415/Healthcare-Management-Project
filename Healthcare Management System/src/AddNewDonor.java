import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import Project.ConnectBloodBank;
import java.awt.SystemColor;


@SuppressWarnings("unused")
public class AddNewDonor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1454566815758085401L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewDonor frame = new AddNewDonor();
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
	public AddNewDonor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 501);
		contentPane = new JPanel();
		
		;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		//setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		
		
		JLabel lblNewLabel_2 = new JLabel("0");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(153, 84, 208, 19);
		contentPane.add(lblNewLabel_2);
		
		try
		{
			int donorID=1;
			String str1 = String.valueOf(donorID);
			
			Connection con = ConnectBloodBank.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select max(donorID) from donor");
			while(rs.next())
			{
				donorID=rs.getInt(1);
				donorID=donorID+1;
				String str=String.valueOf(donorID);
				lblNewLabel_2.setText(str);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		JLabel lblNewLabel = new JLabel("Add New Donor");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 27));
		lblNewLabel.setBounds(239, 10, 251, 52);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(26, 72, 699, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("New Donor ID");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(26, 84, 104, 19);
		contentPane.add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(26, 123, 104, 29);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Father's Name");
		lblNewLabel_3_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(26, 162, 104, 29);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Mother's Name");
		lblNewLabel_3_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(26, 201, 104, 29);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Date of Birth");
		lblNewLabel_3_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_3_3.setBounds(26, 240, 104, 29);
		contentPane.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Contact No");
		lblNewLabel_3_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_3_4.setBounds(26, 279, 104, 29);
		contentPane.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("Gender");
		lblNewLabel_3_5.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_3_5.setBounds(26, 318, 104, 29);
		contentPane.add(lblNewLabel_3_5);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		textField.setBounds(153, 130, 208, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(153, 169, 208, 23);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(153, 208, 208, 23);
		contentPane.add(textField_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(153, 240, 208, 23);
		contentPane.add(dateChooser);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(153, 279, 208, 23);
		contentPane.add(textField_3);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setBackground(SystemColor.control);
		comboBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Male", "Female", "Others"}));
		comboBox.setBounds(153, 324, 208, 23);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_3_6 = new JLabel("Email ");
		lblNewLabel_3_6.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_3_6.setBounds(397, 123, 104, 29);
		contentPane.add(lblNewLabel_3_6);
		
		JLabel lblNewLabel_3_7 = new JLabel("Blood Group");
		lblNewLabel_3_7.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_3_7.setBounds(397, 162, 104, 29);
		contentPane.add(lblNewLabel_3_7);
		
		JLabel lblNewLabel_3_8 = new JLabel("City");
		lblNewLabel_3_8.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_3_8.setBounds(397, 201, 104, 29);
		contentPane.add(lblNewLabel_3_8);
		
		JLabel lblNewLabel_3_10 = new JLabel("Address\r\n");
		lblNewLabel_3_10.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_3_10.setBounds(397, 240, 104, 29);
		contentPane.add(lblNewLabel_3_10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		textField_4.setBounds(511, 129, 162, 23);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JComboBox<Object> comboBox_1 = new JComboBox<Object>();
		comboBox_1.setModel(new DefaultComboBoxModel<Object>(new String[] {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
		comboBox_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		comboBox_1.setBounds(511, 168, 162, 23);
		contentPane.add(comboBox_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		textField_5.setBounds(511, 208, 162, 23);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		textArea.setBounds(511, 244, 162, 71);
		contentPane.add(textArea);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(26, 380, 699, 2);
		contentPane.add(separator_1);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String donorID = lblNewLabel_2.getText();
				String name = textField.getText();
				String FatherName = textField_1.getText();
				String MotherName = textField_2.getText();
				SimpleDateFormat dFormat = new SimpleDateFormat("dd-mm-yyyy");
				String dob = dFormat.format(dateChooser.getDate());
				String ContactNo = textField_3.getText();
				String gender = (String)comboBox.getSelectedItem();
				String email = textField_4.getText();
				String BloodGroup = (String)comboBox_1.getSelectedItem();
				String city = textField_5.getText();
				String address = textArea.getText();
				
				
				try
				{
					Connection con = ConnectBloodBank.getCon();
					Statement st = con.createStatement();
					st.executeUpdate("insert into donor values('"+donorID+"','"+name+"','"+FatherName+"','"+MotherName+"','"+dob+"','"+ContactNo+"','"+gender+"','"+email+"','"+BloodGroup+"','"+city+"','"+address+"')");
					JOptionPane.showMessageDialog(null, "Successfully Updated!");
					setVisible(false);
					
					new AddNewDonor().setVisible(true);
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		btnNewButton.setBounds(86, 410, 85, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				new AddNewDonor().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		btnNewButton_1.setBounds(325, 410, 85, 31);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		btnNewButton_2.setBounds(579, 410, 85, 31);
		contentPane.add(btnNewButton_2);
		
		Image img = new ImageIcon(this.getClass().getResource("/BloodBankJFrame.png")).getImage();
		JLabel lblNewLabel_4 = new JLabel();
		lblNewLabel_4.setBackground(SystemColor.menu);
		lblNewLabel_4.setIcon(new ImageIcon(img));
		lblNewLabel_4.setBounds(0, 0, 782, 501);
		contentPane.add(lblNewLabel_4);
	}
}
