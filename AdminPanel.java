package uio;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;


public class adminPanel {

	private JFrame frame;
	private JTextField doc_user;
	private JPasswordField doc_pass;
	private JTextField ad_user;
	private JTextField ad_pass;
	@SuppressWarnings("rawtypes")
	private JComboBox cb;
	private JComboBox<String> cb1;
	private JComboBox<String> cb9; 
	private JTextField tech;
	private JPasswordField techp;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminPanel window = new adminPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public adminPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("rawtypes")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(400, 100, 919, 692);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setSize(919, 692);
		frame.setLocationRelativeTo(null);  
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Administrator\\Downloads\\resizedImage__2_-removebg-preview.png"));
		lblNewLabel.setBounds(372, 11, 136, 103);
		frame.getContentPane().add(lblNewLabel);
		
		doc_user = new JTextField();
		doc_user.setBounds(24, 205, 136, 31);
		frame.getContentPane().add(doc_user);
		doc_user.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(24, 180, 75, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		doc_pass = new JPasswordField();
		doc_pass.setBounds(180, 205, 136, 31);
		frame.getContentPane().add(doc_pass);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(180, 180, 69, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Add Doctor");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(24, 141, 117, 28);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Add Admin");
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(450, 140, 193, 31);
		frame.getContentPane().add(lblNewLabel_4);
		
		ad_user = new JTextField();
		ad_user.setBounds(450, 205, 136, 31);
		frame.getContentPane().add(ad_user);
		ad_user.setColumns(10);
		
		ad_pass = new JTextField();
		ad_pass.setBounds(619, 205, 136, 31);
		frame.getContentPane().add(ad_pass);
		ad_pass.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("UserName");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(450, 180, 75, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Password");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(618, 180, 69, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_9 = new JLabel("Delete Patient");
		lblNewLabel_9.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(24, 385, 148, 44);
		frame.getContentPane().add(lblNewLabel_9);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(10, 370, 43, 227);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 139, 862, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 372, 870, 28);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 596, 870, 31);
		frame.getContentPane().add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(877, 370, 36, 227);
		frame.getContentPane().add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(10, 137, 55, 237);
		frame.getContentPane().add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setBounds(876, 137, 27, 237);
		frame.getContentPane().add(separator_6);
		
		JLabel lblNewLabel_7 = new JLabel("Add Technitian");
		lblNewLabel_7.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(24, 235, 168, 31);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_10 = new JLabel("Delete Doctor");
		lblNewLabel_10.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(464, 392, 153, 31);
		frame.getContentPane().add(lblNewLabel_10);
		
		JButton doc_btn = new JButton("ADD");
		doc_btn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String username = doc_user.getText();
				String password = doc_pass.getText();
				System.out.println("+username+,+password+");
				try {
					DbConnection con = new DbConnection();
					String sql = "INSERT INTO `doctor`(`username`, `password`) VALUES ('"+username+"','"+password+"')";
						con.s.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "'"+ username +"'Added Successfully");
						  new adminPanel();
						  adminPanel.main(null);
						  frame.dispose();
				}catch(Exception error) {
					
				}
			}
		});
		doc_btn.setFont(new Font("Tahoma", Font.BOLD, 11));
		doc_btn.setBounds(326, 205, 89, 31);
		frame.getContentPane().add(doc_btn);
		
		
		
		JButton ad_btn = new JButton("ADD");
		ad_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = ad_user.getText();
				String password = ad_pass.getText();
				System.out.println("+username+,+password+");
				try {
					DbConnection con = new DbConnection();
					String sql = "INSERT INTO `admin`(`username`, `password`) VALUES ('"+username+"','"+password+"')";
						con.s.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "'"+ username +"'Added Successfully");
						  new adminPanel();
						  adminPanel.main(null);
						  frame.dispose();
				}catch(Exception error) {
					
				}
			}
		});
		ad_btn.setFont(new Font("Tahoma", Font.BOLD, 11));
		ad_btn.setBounds(777, 205, 89, 31);
		frame.getContentPane().add(ad_btn);
		
		
		
		cb = new JComboBox();
		cb.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void mouseClicked(MouseEvent e) {
				DbConnection con = new DbConnection();
				String sql = "SELECT `username` FROM `patient` WHERE 1";
				try {
					ResultSet rs = con.s.executeQuery(sql);
					while(rs.next()) {
						cb.addItem(rs.getString("username"));
					}
				}catch(Exception error) {
					
				}
			}
		});
		cb.setBounds(23, 426, 226, 31);
		frame.getContentPane().add(cb);
		
		
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String delete = (String)cb.getSelectedItem();
					DbConnection con = new DbConnection();
					String sql = "DELETE FROM patient WHERE username='"+delete+"'";
					try {
						con.s.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "Delete Success");
						  new adminPanel();
						  adminPanel.main(null);
						  frame.dispose();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(276, 426, 126, 31);
		frame.getContentPane().add(btnNewButton_2);
		

		
		cb1 = new JComboBox<String>();
		cb1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DbConnection con = new DbConnection();
				String sql = "SELECT `username` FROM `doctor` WHERE 1";
				try {
					ResultSet rs = con.s.executeQuery(sql);
					while(rs.next()) {
						cb1.addItem(rs.getString("username"));
					}
				}catch(Exception error) {
					
				}
			}
		});
		cb1.setBounds(464, 426, 225, 31);
		frame.getContentPane().add(cb1);
		
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String delete = (String)cb1.getSelectedItem();
				DbConnection con = new DbConnection();
				String sql = "DELETE FROM doctor WHERE username='"+delete+"'";
				try {
					con.s.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Delete Success");
					 new adminPanel();
					 adminPanel.main(null);
					 frame.dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(740, 426, 126, 31);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new fg();
				uio.fg.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(740, 608, 126, 34);
		frame.getContentPane().add(btnNewButton);
		

		
		tech = new JTextField();
		tech.setBounds(24, 304, 136, 31);
		frame.getContentPane().add(tech);
		tech.setColumns(10);
		
		techp = new JPasswordField();
		techp.setBounds(180, 304, 136, 31);
		frame.getContentPane().add(techp);
		
		JButton techbtn = new JButton("ADD");
		techbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = tech.getText();
				@SuppressWarnings("deprecation")
				String password = techp.getText();
				try {
					DbConnection con = new DbConnection();
					String sql = "INSERT INTO `technitian`(`name`, `pass`) VALUES ('"+username+"','"+password+"')";
						con.s.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "'"+ username +"'Added Successfully");
						  new adminPanel();
						  adminPanel.main(null);
						  frame.dispose();
				}catch(Exception error) {
					
				}
			}
		});
		techbtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		techbtn.setBounds(326, 304, 89, 31);
		frame.getContentPane().add(techbtn);
		
		JLabel lblNewLabel_8 = new JLabel("UserName");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(24, 277, 80, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_11 = new JLabel("Password");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11.setBounds(180, 277, 69, 14);
		frame.getContentPane().add(lblNewLabel_11);
		
		cb9 = new JComboBox<String>();
		cb9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DbConnection con = new DbConnection();
				String sql = "SELECT `name` FROM `technitian` WHERE 1";
				try {
					ResultSet rs = con.s.executeQuery(sql);
					while(rs.next()) {
						cb9.addItem(rs.getString("name"));
					}
				}catch(Exception error) {
					
				}
			}
		});
		cb9.setBounds(24, 512, 225, 31);
		frame.getContentPane().add(cb9);
		
		JLabel lblNewLabel_12 = new JLabel("Delete Technitian");
		lblNewLabel_12.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_12.setBounds(24, 468, 208, 35);
		frame.getContentPane().add(lblNewLabel_12);
		
		JButton techDbtn = new JButton("Delete");
		techDbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String delete = (String)cb9.getSelectedItem();
				DbConnection con = new DbConnection();
				String sql = "DELETE FROM technitian WHERE name='"+delete+"'";
				try {
					con.s.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Delete Success");
					  new adminPanel();
					  adminPanel.main(null);
					  frame.dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		techDbtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		techDbtn.setBounds(276, 512, 126, 31);
		frame.getContentPane().add(techDbtn);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\Gradient_builder_2.jpg"));
		lblNewLabel_13.setBounds(0, 0, 913, 653);
		frame.getContentPane().add(lblNewLabel_13);
	
	}
}
