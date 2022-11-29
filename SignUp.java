package uio;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class signUp {

	private JFrame frame;
	private JTextField user;
	private JTextField pass;
	private JTextField contact;
	private JTextField age;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signUp window = new signUp();
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
	public signUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Button.background"));
		frame.setBounds(700, 100, 435, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setSize(435, 477);
		frame.setLocationRelativeTo(null);  
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Administrator\\Downloads\\resizedImage (1).png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(155, 48, 196, 99);
		frame.getContentPane().add(lblNewLabel);
		
		user = new JTextField();
		user.setBackground(UIManager.getColor("Button.light"));
		user.setToolTipText("tr");
		user.setBounds(112, 188, 192, 29);
		frame.getContentPane().add(user);
		user.setColumns(10);
		
		pass = new JTextField();
		pass.setBounds(112, 346, 192, 29);
		frame.getContentPane().add(pass);
		pass.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					DbConnection con = new DbConnection();
					String u = user.getText();
					String p = pass.getText();
					String c = contact.getText();
					String a = age.getText();
					String sql = "INSERT INTO `patient`(`username`, `password`,`contact`,`age`) VALUES ('"+u+"','"+p+"','"+c+"','"+a+"')";
					con.s.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "SignUp Successfull");
					frame.setVisible(false);
					new fg();
					uio.fg.main(null);
											
				}catch(Exception error) {
					JOptionPane.showMessageDialog(null,"Error is : "+error);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(142, 386, 134, 36);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(112, 171, 69, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(112, 332, 69, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		contact = new JTextField();
		contact.setBounds(112, 299, 192, 29);
		frame.getContentPane().add(contact);
		contact.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Contact Number");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(111, 275, 115, 22);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Age");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(112, 228, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		age = new JTextField();
		age.setBounds(112, 243, 192, 29);
		frame.getContentPane().add(age);
		age.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\Gradient_builder_2.jpg"));
		lblNewLabel_5.setBounds(0, 0, 419, 438);
		frame.getContentPane().add(lblNewLabel_5);
	}
}
