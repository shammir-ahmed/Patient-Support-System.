package uio;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class patientPanel {

	private JFrame frame;
	private JTable table;
	private JScrollPane printbtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patientPanel window = new patientPanel();
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
	public patientPanel() {
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
		new fg();
		JLabel tblheader = new JLabel( uio.fg.getUname()+"'s"+""+" "+ "Health Reports");
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
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		JLabel lblNewLabel_2 = new JLabel("New label");
		printbtn.setColumnHeaderView(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Print Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean print = table.print();
					if(!print) {
						JOptionPane.showMessageDialog(null, "Unable to print Document. Please Try again");
					}
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(1035, 398, 152, 35);
		frame.getContentPane().add(btnNewButton);
		new fg();
		
		JButton btnNewButton_1 = new JButton("Log Out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new fg();
				uio.fg.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBackground(Color.PINK);
		btnNewButton_1.setBounds(1197, 398, 110, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\Gradient_builder_2.jpg"));
		lblNewLabel.setBounds(0, 0, 1317, 449);
		frame.getContentPane().add(lblNewLabel);
	}
	private void init() {
		try {
			new fg();
			DbConnection con = new DbConnection();
			String uname = uio.fg.getUname();
			String sql = "SELECT `Name`, `Age`, `Date`, `DoctorName`, `Disease`, `BloodGroup`, `hbp`, `ow`, `dia`, `hiv`, `prescription`, `contact` FROM `allpatientreport` WHERE Name = '"+uname+"'";
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
