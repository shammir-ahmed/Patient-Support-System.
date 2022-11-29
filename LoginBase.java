package uio;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import javax.swing.JComboBox;

public class fg {
	private JFrame frame;
	private JPasswordField pass;
	private JTextField user;
	private JComboBox<?> cb;
	public static String uname;
	
	public static String getUname() {
		return uname;
	}
	public static void setUname(String un) {
		uname = un;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fg window = new fg();
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
	public fg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(400, 100, 469, 314);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setSize(469, 314);
		frame.setLocationRelativeTo(null);  
		
		JLabel Headinglvl = new JLabel("Patient Support System");
		Headinglvl.setFont(new Font("Tahoma", Font.BOLD, 30));
		Headinglvl.setBounds(45, 11, 372, 44);
		frame.getContentPane().add(Headinglvl);
		
		JButton signUp = new JButton("Sign Up");
		signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new signUp();
				uio.signUp.main(null);
			}
		});
		signUp.setFont(new Font("Tahoma", Font.BOLD, 11));
		signUp.setBounds(310, 219, 89, 23);
		frame.getContentPane().add(signUp);
		JButton signIn = new JButton("Login");
		signIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DbConnection con = new DbConnection();
					System.out.println(con);
					String userName = user.getText();
					@SuppressWarnings("deprecation")
					String password = pass.getText();
					String Role = (String)cb.getSelectedItem();
					if(Role.equals("patient")) {
						String sql = "select * from patient where username = '"+userName+"' and password = '"+password+"' ";
						ResultSet rs = con.s.executeQuery(sql);
						if(rs.next()) {
							JOptionPane.showMessageDialog(null, "Patient : "+userName+" Loged in Successfully");
							setUname(userName);
							new patientPanel();
							uio.patientPanel.main(null);
							frame.setVisible(false);
						}
						else
							JOptionPane.showMessageDialog(null, "Please check user name and password");
	
					}else if(Role.equals("doctor")) {
						String sql = "select * from doctor where username = '"+userName+"' and password = '"+password+"'";
						ResultSet rs = con.s.executeQuery(sql);
						if(rs.next()) {
							JOptionPane.showMessageDialog(null, "Doctor : "+userName+" Loged in Successfully");
							setUname(userName);
							new doctorPanel();
							uio.doctorPanel.main(null);
							frame.setVisible(false);
						}
						else
							JOptionPane.showMessageDialog(null, "Please check user name and password");
			
					}else if(Role.equals("admin")) {
						String sql = "select * from admin where username = '"+userName+"' and password = '"+password+"'";
						ResultSet rs = con.s.executeQuery(sql);
						if(rs.next()) {
							JOptionPane.showMessageDialog(null,  "Admin : "+userName+" Loged in Successfully");
							setUname(userName);
							frame.setVisible(false);
							new adminPanel();
							uio.adminPanel.main(null);
						}
						else
							JOptionPane.showMessageDialog(null, "Please check user name and password");
					}else if(Role.equals("technetian")) {
						String sql = "select * from technitian where name = '"+userName+"' and pass = '"+password+"'";
						ResultSet rs = con.s.executeQuery(sql);
						if(rs.next()) {
							frame.setVisible(false);
							JOptionPane.showMessageDialog(null,  "Technetian : "+userName+" Loged in Successfully");
							setUname(userName);
							new technetian();
							uio.technetian.main(null);
							
						}
						else
							JOptionPane.showMessageDialog(null, "Please check user name and password");
					}
					else {
						JOptionPane.showMessageDialog(null, "Unknown Error Occured");

					}
					
				}catch(Exception error) {
					error.printStackTrace();
				}
			}
		});
		
		signIn.setFont(new Font("Tahoma", Font.BOLD, 13));
		signIn.setBounds(203, 218, 89, 23);
		frame.getContentPane().add(signIn);
		
		pass = new JPasswordField();
		pass.setBounds(203, 147, 196, 20);
		frame.getContentPane().add(pass);
		
		user = new JTextField();
		user.setBounds(203, 106, 196, 20);
		frame.getContentPane().add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(203, 87, 89, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(203, 129, 89, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Administrator\\Downloads\\resizedImage-removebg-preview.png"));
		lblNewLabel_3.setBounds(-12, 56, 205, 194);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Select Your Role");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(203, 166, 100, 18);
		frame.getContentPane().add(lblNewLabel);
		
		String d[] = {"patient","doctor","technetian","admin"};
		cb = new JComboBox(d);
		cb.setFont(new Font("Tahoma", Font.BOLD, 11));
		cb.setBounds(203, 186, 196, 22);
		frame.getContentPane().add(cb);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\Gradient_builder_2.jpg"));
		lblNewLabel_4.setBounds(-2, 0, 515, 464);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		
	}
}
