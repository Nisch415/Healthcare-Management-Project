import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Project.ConnectionProvider;
import net.proteanit.sql.DbUtils;

import java.sql.*;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class DiagnosticInfo extends JFrame {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public int flag = 0;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private final JLabel lblNewLabel_5 = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiagnosticInfo frame = new DiagnosticInfo();
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
	public DiagnosticInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Patient ID");
		lblNewLabel.setBounds(125, 30, 112, 32);
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(272, 30, 112, 32);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Patient ID does not exist!");
		lblNewLabel_1.setVisible(false);
		lblNewLabel_1.setBounds(222, 72, 237, 32);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 119, 724, 72);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBackground(SystemColor.inactiveCaption);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Patient ID", "Name", "Contact Number", "Age", "Gender", "Blood Group", "Address", "Any Major Ailment"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("Symptoms");
		lblNewLabel_2.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(24, 242, 112, 25);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String patientID = textField.getText();
				
				try {
				Connection con = ConnectionProvider.getCon();
				Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = st.executeQuery("SELECT *FROM patient WHERE patientID ='"+patientID+"'");
				table.setModel(DbUtils.resultSetToTableModel(rs));
				if(!rs.first())
				{
					lblNewLabel_1.setVisible(true);
				}
				else
				{
					lblNewLabel_1.setVisible(false);
					textField.setEditable(false);
					flag=1;
				}
					
			}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(new DiagnosticInfo(),e1 );
				}
			}
		});
		btnNewButton.setBounds(518, 30, 106, 32);
		btnNewButton.setFont(new Font("Lucida Sans", Font.BOLD, 17));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2_1 = new JLabel("Diagnosis");
		lblNewLabel_2_1.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(24, 314, 112, 25);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Medication");
		lblNewLabel_2_2.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setBounds(24, 386, 123, 25);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ward Required");
		lblNewLabel_3.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(479, 245, 145, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Type ");
		lblNewLabel_4.setVisible(false);
		lblNewLabel_4.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(479, 292, 145, 25);
		contentPane.add(lblNewLabel_4);
		
		
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setVisible(false);
		comboBox.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"General", "Single", "Duo"}));
		comboBox.setBounds(634, 294, 114, 23);
		contentPane.add(comboBox);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Yes");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chckbxNewCheckBox.isSelected())
				{
					lblNewLabel_4.setVisible(true);
					comboBox.setVisible(true);
				}
				else
				{
					lblNewLabel_4.setVisible(false);
					comboBox.setVisible(false);
				}
				
			}
		});
		chckbxNewCheckBox.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		chckbxNewCheckBox.setBounds(633, 247, 70, 21);
		contentPane.add(chckbxNewCheckBox);
		
		
		
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Lucida Sans", Font.BOLD, 22));
		btnNewButton_2.setBounds(587, 449, 106, 32);
		contentPane.add(btnNewButton_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		textArea.setBounds(157, 224, 250, 63);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		textArea_1.setBounds(157, 295, 250, 64);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		textArea_2.setBounds(157, 369, 250, 70);
		contentPane.add(textArea_2);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(flag==1)
				{
					String patientID =textField.getText();
					String symptoms = textArea.getText();
					String diagnosis = textArea_1.getText();
					String medications = textArea_2.getText();
					String WardReq;
					String WardType;
					
					if(chckbxNewCheckBox.isSelected())
					{
						WardReq = "YES";
						WardType = (String)comboBox.getSelectedItem();
					}
					else
					{
						WardReq="NO";
						WardType="";
					}
					
					try
					{
						Connection con = ConnectionProvider.getCon();
						Statement st = con.createStatement();
						st.executeUpdate("insert into patientreport values('"+patientID+"','"+symptoms+"','"+diagnosis+"','"+medications+"','"+WardReq+"','"+WardType+"')");
						JOptionPane.showMessageDialog(new DiagnosticInfo(), "Successfully Updated!");
						setVisible(false);
						
						new DiagnosticInfo().setVisible(true);
 					}
					catch(Exception e1)
					{
						JOptionPane.showInputDialog(this,e1);
					}
				}
				
				else
					JOptionPane.showMessageDialog(null, "PatientID Field is empty");
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Sans", Font.BOLD, 22));
		btnNewButton_1.setBounds(211, 449, 106, 32);
		contentPane.add(btnNewButton_1);
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\NISCHALA R\\Desktop\\java\\Healthcare Management System\\images\\JFrameimg.jpg"));
		lblNewLabel_5.setBounds(0, 0, 787, 500);
		contentPane.add(lblNewLabel_5);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		
		
		
	}
} 
