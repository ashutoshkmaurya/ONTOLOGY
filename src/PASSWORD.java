import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.swing.JTextField;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JPasswordField;


public class PASSWORD {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void pass() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PASSWORD window = new PASSWORD();
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
	public PASSWORD() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel info = new JPanel();
		frame.getContentPane().add(info, "name_42226885686708");
		info.setLayout(null);
		
		JLabel lblHere = new JLabel("Here You can set or update or delete password for your:\r\n");
		lblHere.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHere.setToolTipText("");
		lblHere.setBounds(10, 23, 564, 41);
		info.add(lblHere);
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setToolTipText("");
		lblOr.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOr.setBounds(258, 132, 44, 41);
		info.add(lblOr);
		
		JPanel database_password = new JPanel();
		frame.getContentPane().add(database_password, "name_42613585549583");
		database_password.setLayout(null);
		
		JButton btnTable = new JButton("TABLE");
		btnTable.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTable.setBounds(205, 184, 145, 23);
		info.add(btnTable);
		
		JLabel lblNewLabel = new JLabel("Select The Database You Want To Set Password For");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 365, 28);
		database_password.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DATABASE NAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(96, 83, 130, 28);
		database_password.add(lblNewLabel_1);
		
		
		textField = new JTextField();
		textField.setBounds(236, 89, 233, 20);
		database_password.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(96, 132, 122, 20);
		database_password.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(236, 134, 233, 20);
		database_password.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("PASSWORD SAVED");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(96, 232, 134, 20);
		database_password.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PASSWORD ALREADY EXIST FOR THIS DATABASE");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(96, 263, 373, 17);
		database_password.add(lblNewLabel_4);
		
		
		
		JComboBox comboBox = new JComboBox();
		
		JButton btnSetPassword = new JButton("SET PASSWORD");
		btnSetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dbnames[]=new String[20];
				try{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=PASSWORD;user=sa;password=9838929487");
					Statement st = conn.createStatement();
					Statement st2 = conn.createStatement();
					String select_all="select * from database_passwords";
					ResultSet rs = st.executeQuery(select_all);
					int i=0;
					int flag=0;
					while (rs.next()) {			
						dbnames[i]=rs.getString(1);	
						i=i+1;
					}
					dbnames = Arrays.stream(dbnames)
		                     .filter(s -> (s != null && s.length() > 0))
		                     .toArray(String[]::new);
					for(int j=0;j<dbnames.length;j++)
					{						
						if(dbnames[j].equals(textField.getText()))
						{
							flag=1;
						}
					}
					if(flag==1)
					{
						//System.out.println("database password already created");
						lblNewLabel_4.setVisible(true);
					}
					else{
						String save_pass="insert into database_passwords values('"+comboBox.getSelectedItem().toString()+"','"+passwordField.getText()+"')";
						st2.executeUpdate(save_pass);
						btnSetPassword.setVisible(false);
						lblNewLabel_3.setVisible(true);
					}
				}
				catch (SQLException e1)
				{
					System.err.println("SQL EXCEPTION");
				}
				
				catch (ClassNotFoundException e2)
				{
                    System.err.println("Could not load JDBC driver");
				}
				
				
			}
		});
		btnSetPassword.setBounds(319, 165, 150, 23);
		database_password.add(btnSetPassword);
		
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				textField.setText(comboBox.getSelectedItem().toString());
				textField.setEditable(false);
				lblNewLabel_1.setVisible(true);
				textField.setVisible(true);
				lblNewLabel_2.setVisible(true);
				passwordField.setVisible(true);
				btnSetPassword.setVisible(true);
				lblNewLabel_3.setVisible(false);
				lblNewLabel_4.setVisible(false);
			}
		});
		comboBox.setBounds(385, 17, 161, 20);
		database_password.add(comboBox);	
				
		JButton btnDatabse = new JButton("DATABASE");
		btnDatabse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=UNIVERSITY;user=sa;password=9838929487");
					Statement st = conn.createStatement();
					String list_databases="select * from sys.databases WHERE name NOT IN ('master', 'tempdb', 'model', 'msdb','SCHEMA','PASSWORD')";
					ResultSet rs = st.executeQuery(list_databases);
					while (rs.next()) {			
						//System.out.println(rs.getString(1));
						comboBox.addItem(rs.getString(1));
					}
				}
				catch (SQLException e1)
				{
                    System.err.println("SQL EXCEPTION");
				}
				
				catch (ClassNotFoundException e2)
				{
                    System.err.println("Could not load JDBC driver");
				}
				info.setVisible(false);
				lblNewLabel_1.setVisible(false);
				textField.setVisible(false);
				database_password.setVisible(true);
				lblNewLabel_2.setVisible(false);
				passwordField.setVisible(false);
				btnSetPassword.setVisible(false);
				lblNewLabel_3.setVisible(false);
				lblNewLabel_4.setVisible(false);
							
			}
		});
		btnDatabse.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDatabse.setBounds(205, 98, 145, 23);
		info.add(btnDatabse);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
			}
		});
		
	}
}
