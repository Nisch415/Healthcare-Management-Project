import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class About extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\NISCHALA R\\Desktop\\aboutImg.jpeg"));
		lblNewLabel.setBounds(193, 0, 566, 141);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Who We Are?");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setForeground(new Color(72, 209, 204));
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 25));
		lblNewLabel_2.setBounds(20, 53, 163, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\NISCHALA R\\Desktop\\pink.png"));
		lblNewLabel_1.setBounds(0, 22, 193, 103);
		contentPane.add(lblNewLabel_1);
		
		JTextArea txtrSagarGroupVentured = new JTextArea();
		txtrSagarGroupVentured.setBackground(new Color(250, 235, 215));
		txtrSagarGroupVentured.setEditable(false);
		txtrSagarGroupVentured.setFont(new Font("Yu Gothic Light", Font.PLAIN, 14));
		txtrSagarGroupVentured.setText("Sagar Group ventured into healthcare services under the capable leadership of Dr. Chandramma D Sagar in the \r\n60s with the establishment of Chandra Nursing Home. Almost four decades later, her legacy and vision was\r\n carried forward by her two sons, Dr. D Hemachandra Sagar and Dr. D Premachandra Sagar. \r\nSagar Hospitals is synonymous with quality healthcare, efficiency, reliability and has set very high standards\r\n in the healthcare sector in the State.");
		txtrSagarGroupVentured.setLineWrap(true);
		txtrSagarGroupVentured.setBounds(23, 151, 707, 141);
		contentPane.add(txtrSagarGroupVentured);
		
		JTextArea txtrDrDeviPrasad = new JTextArea();
		txtrDrDeviPrasad.setBackground(new Color(250, 235, 215));
		txtrDrDeviPrasad.setEditable(false);
		txtrDrDeviPrasad.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		txtrDrDeviPrasad.setText("Dr. Devi Prasad Hegde \r\nConsultant Intensive Care\r\n\r\nDr. Keshav Murthy\r\nPeadiatric Surgeon\r\n\r\nDr. K Subramanyam \r\nCardiologist\r\n\r\nDr. Swati \r\nOpthamologist\r\n\r\nDr. Sudeep K\r\nPhysician\r\n\r\n");
		txtrDrDeviPrasad.setBounds(23, 331, 208, 273);
		contentPane.add(txtrDrDeviPrasad);
		
		JLabel lblNewLabel_3 = new JLabel("Our Doctors");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(20, 302, 163, 34);
		contentPane.add(lblNewLabel_3);
		
		JTextArea txtrBanashankariSagarHospitals = new JTextArea();
		txtrBanashankariSagarHospitals.setEditable(false);
		txtrBanashankariSagarHospitals.setBackground(new Color(250, 235, 215));
		txtrBanashankariSagarHospitals.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		txtrBanashankariSagarHospitals.setText("BANASHANKARI\r\nSagar Hospitals- DSI, Banashankari, Behind DSI campus,\r\nShavige Malleshwara Hills, Kumaraswamy Layout,\r\nBengaluru- 560 078, Karnataka, India\r\n080 4299 9999\r\n\r\nJAYANAGAR\r\nSagar Hospitals, Jayanagar\r\n#44/54, 30th Cross Road, Tilak Nagar, Jayanagar,\r\nBengaluru - 560 041, Karnataka, India\r\n080 4288 8888\r\n");
		txtrBanashankariSagarHospitals.setBounds(267, 331, 400, 247);
		contentPane.add(txtrBanashankariSagarHospitals);
		
		JLabel lblNewLabel_4 = new JLabel("Contact Us");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(267, 302, 145, 28);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("CLOSE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(636, 586, 106, 28);
		contentPane.add(btnNewButton);
	}
}
