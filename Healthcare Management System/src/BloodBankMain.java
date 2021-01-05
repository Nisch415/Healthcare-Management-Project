import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;

public class BloodBankMain extends JFrame {

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
					BloodBankMain frame = new BloodBankMain();
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
	public BloodBankMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1402, 770);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Donor ");
		mnNewMenu.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add New Donor");
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AddNewDonor().setVisible(true);
			}
		});
		mntmNewMenuItem.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Update Details");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new UpdateDonor().setVisible(true);
			}
		});
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("All Donors");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AllDonorDetails().setVisible(true);
			}
		});
		mntmNewMenuItem_2.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Search ");
		mnNewMenu_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Location");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new SearchByLocation().setVisible(true);
			}
		});
		mntmNewMenuItem_3.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Blood Group");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new SearchByBloodGroup().setVisible(true);
			}
		});
		mntmNewMenuItem_4.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_2 = new JMenu("Stock ");
		mnNewMenu_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Increase");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StockIncrease().setVisible(true);
			}
		});
		mntmNewMenuItem_5.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_5.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Decrease");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new StockDecrease().setVisible(true);
			}
		});
		mntmNewMenuItem_6.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_6.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("All Details");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new StockDetails().setVisible(true);
			}
		});
		mntmNewMenuItem_7.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_7.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_3 = new JMenu("Delete ");
		mnNewMenu_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Delete Donor");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new DeleteDonor().setVisible(true);
			}
		});
		mntmNewMenuItem_8.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_8.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		mnNewMenu_3.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_4 = new JMenu("Close ");
		mnNewMenu_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnNewMenu_4.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Home");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		mntmNewMenuItem_10.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_10.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		mnNewMenu_4.add(mntmNewMenuItem_10);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\NISCHALA R\\Desktop\\java\\Healthcare Management System\\images\\BloodBank.png"));
		lblNewLabel.setBounds(0, -11, 1588, 781);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BLOOD BANK ");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(375, 57, 475, 56);
		contentPane.add(lblNewLabel_1);
	}
}
