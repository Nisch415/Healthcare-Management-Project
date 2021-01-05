 import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	
	
	public login() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1546, 839);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);// new code
		
		
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 24));
		lblNewLabel.setBounds(436, 256, 138, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Sans", Font.BOLD, 24));
		lblNewLabel_1.setBounds(436, 337, 138, 40);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Lucida Sans", Font.BOLD, 24));
		textField.setBounds(671, 252, 403, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Lucida Sans", Font.BOLD, 24));
		passwordField.setBounds(671, 337, 403, 50);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("Admin_SagarHospitals") &&  passwordField.getText().equals("admin"))
				{
					setVisible(false);
					new home().setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null,"Incorrect username or password!");
				
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\NISCHALA R\\Desktop\\java\\Healthcare Management System\\images\\Accept-icon.png"));
		btnNewButton.setFont(new Font("Lucida Sans", Font.BOLD, 24));
		btnNewButton.setBounds(671, 484, 145, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(null,"Do you really want to close the application?","Select",JOptionPane.YES_NO_OPTION);
				if(a==0)
					System.exit(0);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\NISCHALA R\\Desktop\\java\\Healthcare Management System\\images\\Button-Close-icon.png"));
		btnNewButton_1.setFont(new Font("Lucida Sans", Font.BOLD, 24));
		btnNewButton_1.setBounds(929, 484, 145, 40);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\NISCHALA R\\Downloads\\586e824b-0aa9-46c3-aa06-c6b0bc67eb90.JPG"));
		lblNewLabel_2.setBounds(36, 24, 151, 174);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("SAGAR HOSPITALS");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Lucida Sans", Font.BOLD, 47));
		lblNewLabel_4.setBounds(483, 24, 563, 69);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("With You. For Life");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Lucida Sans", Font.ITALIC, 24));
		lblNewLabel_5.setBounds(652, 103, 217, 55);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\NISCHALA R\\Desktop\\java\\Healthcare Management System\\images\\FinalLogin.png"));
		lblNewLabel_3.setBounds(0, 0, 1581, 838);
		contentPane.add(lblNewLabel_3);
	}
}
