package uio;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class doctorPanel {

	private JFrame frame;
	private JTable table;
	private JScrollPane printbtn;
	private JTextField src;
	private JLabel signOut;
	private JButton btnNewButton;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doctorPanel window = new doctorPanel();
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
	public doctorPanel() {
		initialize();
		init();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 100, 1333, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setSize(1333, 488);
		frame.setLocationRelativeTo(null);  
		
		JLabel tblheader = new JLabel("Patients Health Reports");
		tblheader.setBackground(Color.GREEN);
		tblheader.setBounds(486, 11, 504, 90);
		tblheader.setFont(new Font("Segoe Print", Font.PLAIN, 27));
		tblheader.setForeground(Color.BLACK);
		frame.getContentPane().add(tblheader);
		
		printbtn = new JScrollPane();
		printbtn.setBounds(0, 80, 1317, 307);
		frame.getContentPane().add(printbtn);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.setBackground(Color.WHITE);
		printbtn.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Age", "Date", "Doctor Name", "Disease", "Blood Group", "HBP", "OW", "DIA", "HIV", "Prescription", "Contact"
			}
		));
		table.getColumnModel().getColumn(10).setPreferredWidth(300);
		JLabel lblNewLabel_2 = new JLabel("New label");
		printbtn.setColumnHeaderView(lblNewLabel_2);
		
		src = new JTextField();
		src.setBounds(10, 408, 202, 32);
		frame.getContentPane().add(src);
		src.setColumns(10);
		
		JButton srCbtn = new JButton("Search");
		srCbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search = src.getText();
				try {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					DbConnection con = new DbConnection();
					String sql = "SELECT `Name`, `Age`, `Date`, `DoctorName`, `Disease`, `BloodGroup`, `hbp`, `ow`, `dia`, `hiv`, `prescription`, `contact` FROM `allpatientreport` WHERE contact = '"+search+"'";
					ResultSet rs = con.s.executeQuery(sql);
					while(rs.next()) {
						String name = rs.getString("Name");
						String age = String.valueOf(rs.getInt("Age"));
						String date = rs.getString("Date");
						String dname =  rs.getString("DoctorName");
						String disease = rs.getString("Disease");
						String bg =  rs.getString("BloodGroup");
						String sd1 =  rs.getString("hbp");
						String sd2 =  rs.getString("ow");
						String sd3 =  rs.getString("dia");
						String sd4 =  rs.getString("hiv");
						String pres =  rs.getString("prescription");
						String cont =  rs.getString("contact");
						String tbData[] = {name,age,date,dname,disease,bg,sd1,sd2,sd3,sd4,pres,cont};
						DefaultTableModel tbModel = (DefaultTableModel)table.getModel();
						tbModel.addRow(tbData);
					}
				}catch(Exception error){

				}
			}
		});
		srCbtn.setBackground(Color.PINK);
		srCbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		srCbtn.setBounds(229, 407, 130, 35);
		frame.getContentPane().add(srCbtn);
		new fg();
		signOut = new JLabel(uio.fg.getUname()+ "");
		signOut.setFont(new Font("Tahoma", Font.BOLD, 14));
		signOut.setBounds(1085, 417, 130, 23);
		frame.getContentPane().add(signOut);
		
		btnNewButton = new JButton("Logout");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new fg();
				uio.fg.main(null);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(1205, 406, 89, 37);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\Gradient_builder_2.jpg"));
		lblNewLabel.setBounds(0, 0, 1317, 449);
		frame.getContentPane().add(lblNewLabel);
	}
	private void init() {
		try {
			DbConnection con = new DbConnection();
			String sql = "SELECT `Name`, `Age`, `Date`, `DoctorName`, `Disease`, `BloodGroup`, `hbp`, `ow`, `dia`, `hiv`, `prescription`, `contact` FROM `allpatientreport` WHERE 1";
			ResultSet rs = con.s.executeQuery(sql);
			while(rs.next()) {
				String name = rs.getString("Name");
				String age = String.valueOf(rs.getInt("Age"));
				String date = rs.getString("Date");
				String dname =  rs.getString("DoctorName");
				String disease = rs.getString("Disease");
				String bg =  rs.getString("BloodGroup");
				String sd1 =  rs.getString("hbp");
				String sd2 =  rs.getString("ow");
				String sd3 =  rs.getString("dia");
				String sd4 =  rs.getString("hiv");
				String pres =  rs.getString("prescription");
				String cont =  rs.getString("contact");
				String tbData[] = {name,age,date,dname,disease,bg,sd1,sd2,sd3,sd4,pres,cont};
				DefaultTableModel tbModel = (DefaultTableModel)table.getModel();
				tbModel.addRow(tbData);
			}
			
		}catch(Exception error) {	
		}
	}
}
