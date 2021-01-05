import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import Project.ConnectBloodBank;
import javax.swing.ImageIcon;

public class DeleteDonor extends JFrame {

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
					DeleteDonor frame = new DeleteDonor();
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
	public DeleteDonor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Donor");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		lblNewLabel.setBounds(260, 10, 218, 46);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(26, 66, 730, 8);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Donor ID");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(138, 84, 101, 27);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		textField.setBounds(249, 84, 106, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textArea.setBounds(541, 268, 204, 86);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Search");
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
						textField_1.setText(rs.getString(1));
						textField_2.setText(rs.getString(2));
						textField_3.setText(rs.getString(3));
						textField_4.setText(rs.getString(4));
						textField_5.setText(rs.getString(5));
						textField_6.setText(rs.getString(6));
						textField_7.setText(rs.getString(7));
						textField_8.setText(rs.getString(8));
						textField_9.setText(rs.getString(9));
						textArea.setText(rs.getString(11));
						textField.setEditable(false);
					}
					else
						JOptionPane.showMessageDialog(null, "Donor ID does not exist!");
				}
				catch(Exception e1)
				{
					
				}
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btnNewButton.setBounds(474, 84, 120, 27);
		contentPane.add(btnNewButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(26, 122, 730, 8);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(26, 140, 101, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Father Name");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(26, 180, 101, 27);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mother Name");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(26, 222, 117, 27);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Date of Birth");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(26, 264, 101, 27);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Contact No");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(26, 306, 101, 27);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Gender");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(26, 347, 101, 27);
		contentPane.add(lblNewLabel_7);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textField_1.setBounds(153, 142, 184, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textField_2.setBounds(153, 183, 184, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.LEFT);
		textField_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textField_3.setBounds(153, 221, 184, 27);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.LEFT);
		textField_4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textField_4.setBounds(153, 264, 184, 27);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.LEFT);
		textField_5.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textField_5.setBounds(153, 305, 184, 27);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.LEFT);
		textField_6.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textField_6.setBounds(153, 347, 184, 27);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Email");
		lblNewLabel_8.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(410, 142, 85, 27);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Blood Group");
		lblNewLabel_9.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(410, 180, 101, 27);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("City");
		lblNewLabel_10.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel_10.setBounds(410, 223, 101, 27);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Address");
		lblNewLabel_11.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel_11.setBounds(410, 264, 101, 27);
		contentPane.add(lblNewLabel_11);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textField_7.setBounds(541, 147, 204, 27);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textField_8.setBounds(541, 187, 204, 27);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textField_9.setBounds(541, 229, 204, 27);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(15, 389, 730, 8);
		contentPane.add(separator_1_1);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String donorID = textField.getText();
				try
				{
					Connection con = ConnectBloodBank.getCon();
					Statement st = con.createStatement();
					st.executeUpdate("delete from donor where donorID ='"+donorID+"'");
					JOptionPane.showMessageDialog(null, "Successfully Deleted");
					setVisible(false);
					new DeleteDonor().setVisible(true);
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnNewButton_1.setBounds(153, 407, 101, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				new DeleteDonor().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnNewButton_2.setBounds(343, 407, 101, 27);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Close");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnNewButton_3.setBounds(520, 407, 101, 27);
		contentPane.add(btnNewButton_3);
		
		Image img = new ImageIcon(this.getClass().getResource("/BloodBankJFrame.png")).getImage();
		JLabel lblNewLabel_12 = new JLabel();
		lblNewLabel_12.setIcon(new ImageIcon(img));
		lblNewLabel_12.setBounds(0, 0, 766, 493);
		contentPane.add(lblNewLabel_12);
		setLocationRelativeTo(null);
	}
}
