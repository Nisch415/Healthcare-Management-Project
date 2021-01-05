import static javax.swing.JTable.AUTO_RESIZE_OFF;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


import Project.ConnectionProvider;
import net.proteanit.sql.DbUtils;

import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;

@SuppressWarnings("unused")
public class PatientHistory extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientHistory frame = new PatientHistory();
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
	public PatientHistory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(10, 81, 776, 280);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Patient ID", "Name", "Contact Number", "Age", "Gender", "Blood Group", "Address", "Any Major Ailment", "Symptoms", "Diagnosis", "Medication", "Ward Requirement", "Ward Type"
			}
		));
		scrollPane.setViewportView(table);
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		try
		{
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select patient.* ,patientreport.symptoms,patientreport.diagnosis,patientreport.medications,patientreport.WardReq,patientreport.WardType from patient inner join patientreport where patient.patientID=patientreport.patientID");
			
			while(rs.next())
			{
				model.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13)});
				
				
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
		}
		
		JButton btnNewButton = new JButton("CLOSE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Lucida Sans", Font.BOLD, 20));
		btnNewButton.setBounds(685, 422, 101, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("PATIENT HISTORY");
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(257, 21, 264, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\NISCHALA R\\Desktop\\java\\Healthcare Management System\\images\\JFrameimg.jpg"));
		lblNewLabel_1.setBounds(0, 0, 800, 475);
		contentPane.add(lblNewLabel_1);
	}
}
