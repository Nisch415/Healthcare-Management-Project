import java.awt.EventQueue;

import javax.swing.JFrame;
import Project.ConnectionProvider;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.sql.*;

@SuppressWarnings("unused")
public class AddNewPatient extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewPatient frame = new AddNewPatient();
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
	public AddNewPatient() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 500);
		setLocationRelativeTo(null);
		setUndecorated(true); //new code
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.setBounds(659, 444, 110, 33);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
			}
		});
		getContentPane().setLayout(null);
		btnNewButton.setFont(new Font("Lucida Sans", Font.BOLD, 24));
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Patient ID");
		lblNewLabel.setBounds(71, 48, 130, 30);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 17));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(71, 91, 130, 30);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Lucida Sans", Font.BOLD, 17));
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contact No.");
		lblNewLabel_2.setBounds(71, 126, 130, 30);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Lucida Sans", Font.BOLD, 17));
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Age");
		lblNewLabel_3.setBounds(71, 161, 130, 30);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Lucida Sans", Font.BOLD, 17));
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setBounds(71, 196, 130, 30);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setFont(new Font("Lucida Sans", Font.BOLD, 17));
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Blood Group");
		lblNewLabel_5.setBounds(71, 231, 130, 30);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Lucida Sans", Font.BOLD, 17));
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Address");
		lblNewLabel_6.setBounds(71, 269, 120, 30);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setFont(new Font("Lucida Sans", Font.BOLD, 17));
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Any major ailment suffered earlier");
		lblNewLabel_7.setBounds(71, 339, 305, 30);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setFont(new Font("Lucida Sans", Font.BOLD, 17));
		getContentPane().add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setBounds(386, 48, 275, 30);
		textField.setFont(new Font("Lucida Sans", Font.BOLD, 17));
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(386, 88, 275, 30);
		textField_1.setFont(new Font("Lucida Sans", Font.BOLD, 17));
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(386, 123, 275, 30);
		textField_2.setFont(new Font("Lucida Sans", Font.BOLD, 17));
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(386, 158, 275, 30);
		textField_3.setFont(new Font("Lucida Sans", Font.BOLD, 17));
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setBounds(386, 192, 275, 30);
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Male", "Female", "Others"}));
		comboBox.setFont(new Font("Lucida Sans", Font.BOLD, 17));
		getContentPane().add(comboBox);
		
		textField_4 = new JTextField();
		textField_4.setBounds(386, 228, 275, 30);
		textField_4.setFont(new Font("Lucida Sans", Font.BOLD, 17));
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(386, 263, 275, 63);
		textArea.setFont(new Font("Lucida Sans", Font.BOLD, 17));
		getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(386, 333, 275, 63);
		textArea_1.setFont(new Font("Lucida Sans", Font.BOLD, 17));
		getContentPane().add(textArea_1);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				String patientID = textField.getText();
				String name =  textField_1.getText();
				String ContactNumber = textField_2.getText();
				String gender = (String) comboBox.getSelectedItem();
				String age = textField_3.getText();
				String BloodGroup = textField_4.getText();
				String address = textArea.getText();
				String AnyMajorAilment = textArea_1.getText();
				
				try
				{
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					st.executeUpdate("insert into patient values('"+patientID+"', '"+name+"','"+ContactNumber+"','"+age+"','"+gender+"','"+BloodGroup+"','"+address+"','"+AnyMajorAilment+"')");
					JOptionPane.showMessageDialog(new AddNewPatient(), "Successfully Updated!");
								
					setVisible(false); 
					
					new AddNewPatient().setVisible(true);
					
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"Please enter data in correct format");
				}
			}
		});
		btnNewButton_1.setBounds(252, 444, 94, 33);
		btnNewButton_1.setFont(new Font("Lucida Sans", Font.BOLD, 24));
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\NISCHALA R\\Desktop\\java\\Healthcare Management System\\images\\JFrameimg.jpg"));
		lblNewLabel_8.setBounds(0, 0, 800, 500);
		getContentPane().add(lblNewLabel_8);
	}
}
