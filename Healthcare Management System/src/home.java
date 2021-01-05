import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextArea;

public class home extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int i = 0;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	public home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1550, 839);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setUndecorated(true); 
		
		JButton btnNewButton_1 = new JButton("New Patient Record");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(176, 196, 222));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AddNewPatient().setVisible(true);
		
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		btnNewButton_1.setBounds(73, 69, 255, 58);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Diagnostic information");
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(new Color(176, 196, 222));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new DiagnosticInfo().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		btnNewButton_2.setBounds(73, 169, 255, 58);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Patients History");
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new PatientHistory().setVisible(true);
			}
		});
		btnNewButton_3.setBackground(new Color(176, 196, 222));
		btnNewButton_3.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		btnNewButton_3.setBounds(73, 270, 255, 58);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Update Patient Record");
		btnNewButton_4.setForeground(new Color(0, 0, 0));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new UpdatePatient().setVisible(true);
			}
		});
		btnNewButton_4.setBackground(new Color(176, 196, 222));
		btnNewButton_4.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		btnNewButton_4.setBounds(73, 369, 255, 58);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("About");
		btnNewButton_5.setForeground(new Color(0, 0, 0));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new About().setVisible(true);
			}
		});
		btnNewButton_5.setBackground(new Color(176, 196, 222));
		btnNewButton_5.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		btnNewButton_5.setBounds(73, 468, 255, 58);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Logout");
		btnNewButton_6.setForeground(new Color(0, 0, 0));
		btnNewButton_6.setBackground(new Color(176, 196, 222));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int a = JOptionPane.showConfirmDialog(null , "Do you really want to logout?", "Select", JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					setVisible(false);
					new login().setVisible(true);
				}
			}
		});
		btnNewButton_6.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		btnNewButton_6.setBounds(73, 669, 255, 58);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Blood Bank");
		btnNewButton_7.setForeground(new Color(0, 0, 0));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new BloodBankMain().setVisible(true);
			}
		});
		btnNewButton_7.setBackground(new Color(176, 196, 222));
		btnNewButton_7.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		btnNewButton_7.setBounds(73, 569, 255, 58);
		contentPane.add(btnNewButton_7);
		
		JTextArea txtrCovidSafetyhealthyathome = new JTextArea();
		txtrCovidSafetyhealthyathome.setForeground(new Color(51, 51, 51));
		txtrCovidSafetyhealthyathome.setEditable(false);
		txtrCovidSafetyhealthyathome.setLineWrap(true);
		txtrCovidSafetyhealthyathome.setWrapStyleWord(true);
		txtrCovidSafetyhealthyathome.setText("COVID19 SAFETY!\r\n\r\n#HealthyAtHome\r\n\r\n Maintain at least a 1-metre distance between  yourself and others.\r\n\r\n Make wearing a mask a normal part of being  around other people.\r\n\r\n Avoid the 3Cs: spaces that are closed, crowded or  involve close contact.\r\n\r\n Keep up to date on the latest information from  trusted sources, such as WHO or your local and   national health authorities.\r\n");
		txtrCovidSafetyhealthyathome.setFont(new Font("Lucida Sans", Font.PLAIN, 18));
		txtrCovidSafetyhealthyathome.setBackground(new Color(204, 204, 255));
		txtrCovidSafetyhealthyathome.setBounds(485, 203, 483, 378);
		contentPane.add(txtrCovidSafetyhealthyathome);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\NISCHALA R\\Desktop\\java\\Healthcare Management System\\images\\HomePage.png"));
		lblNewLabel.setBounds(0, 0, 1599, 885);
		contentPane.add(lblNewLabel);
	}
}
