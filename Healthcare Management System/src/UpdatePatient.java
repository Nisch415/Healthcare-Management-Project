import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Project.ConnectionProvider;
import java.sql.*;


public class UpdatePatient extends JFrame {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePatient frame = new UpdatePatient();
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
	public UpdatePatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JLabel lblNewLabel = new JLabel("Patient ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		lblNewLabel.setBounds(89, 35, 108, 28);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		textField.setBounds(307, 38, 244, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		lblName.setBounds(89, 80, 108, 28);
		contentPane.add(lblName);
		
		JLabel lblContactNo = new JLabel("Contact No.");
		lblContactNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblContactNo.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		lblContactNo.setBounds(89, 118, 108, 28);
		contentPane.add(lblContactNo);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.LEFT);
		lblAge.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		lblAge.setBounds(89, 156, 108, 28);
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.LEFT);
		lblGender.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		lblGender.setBounds(89, 194, 108, 28);
		contentPane.add(lblGender);
		
		JLabel lblBloodGroupo = new JLabel("Blood Group");
		lblBloodGroupo.setHorizontalAlignment(SwingConstants.LEFT);
		lblBloodGroupo.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		lblBloodGroupo.setBounds(89, 232, 144, 28);
		contentPane.add(lblBloodGroupo);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		lblAddress.setBounds(89, 284, 108, 28);
		contentPane.add(lblAddress);
		
		JLabel lblAnyMajorAilments = new JLabel("Any Major Ailments");
		lblAnyMajorAilments.setHorizontalAlignment(SwingConstants.LEFT);
		lblAnyMajorAilments.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		lblAnyMajorAilments.setBounds(89, 360, 186, 28);
		contentPane.add(lblAnyMajorAilments);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(307, 76, 244, 28);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(307, 114, 244, 28);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(307, 156, 244, 28);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(307, 239, 244, 28);
		contentPane.add(textField_4);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		textArea.setBounds(307, 278, 244, 58);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		textArea_1.setBounds(307, 350, 244, 58);
		contentPane.add(textArea_1);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String patientID = textField.getText();
				
				try
				{
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select *from patient where patientID = '"+patientID+"'");
					if(rs.next())
					{
						textField_1.setText(rs.getString(2));
						textField_2.setText(rs.getString(3));
						textField_3.setText(rs.getString(4));
						textField_5.setText(rs.getString(5));
						textField_4.setText(rs.getString(6));
						textArea.setText(rs.getString(7));
						textArea_1.setText(rs.getString(8));
						textField.setEditable(false);
						
						
					}
					else
						JOptionPane.showMessageDialog(null,"Patient ID does not exist!");
				}
				catch(Exception e1)
				{
					
				}
			}
		});
		btnNewButton.setFont(new Font("Lucida Sans", Font.BOLD, 19));
		btnNewButton.setBounds(604, 41, 108, 36);
		contentPane.add(btnNewButton);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		textField_5.setColumns(10);
		textField_5.setBounds(307, 201, 244, 28);
		contentPane.add(textField_5);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String patientID = textField.getText();
				String name = textField_1.getText();
				String ContactNumber  = textField_2.getText();
				String age = textField_3.getText();
				String gender = textField_5.getText();
				String BloodGroup = textField_4.getText();
				String address = textArea.getText();
				String AnyMajorAilment = textArea_1.getText();
				
				try
				{
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					st.executeUpdate("update patient set name ='"+name+"',ContactNumber = '"+ContactNumber+"',age = '"+age+"',gender = '"+gender+"',BloodGroup = '"+BloodGroup+"', address = '"+address+"', AnyMajorAilment = '"+AnyMajorAilment+"' where patientID = '"+patientID+"'");
					JOptionPane.showMessageDialog(null, "Successfully Updated!");
					setVisible(false);
					
					new UpdatePatient().setVisible(true);
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Please enter data in correct format!");
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Sans", Font.BOLD, 19));
		btnNewButton_1.setBounds(169, 438, 106, 36);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Close");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		btnNewButton_1_1.setFont(new Font("Lucida Sans", Font.BOLD, 19));
		btnNewButton_1_1.setBounds(581, 438, 106, 36);
		contentPane.add(btnNewButton_1_1);
		
		Image img = new ImageIcon(this.getClass().getResource("/JFrameimg.jpg")).getImage();
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 785, 524);
		contentPane.add(lblNewLabel_1);
	}
}
