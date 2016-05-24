import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
//import javax.swing.JTextPane;
import javax.swing.JTextArea;

//import org.eclipse.swt.widgets.Display;
//import org.eclipse.swt.widgets.MessageBox;
//import org.eclipse.swt.widgets.Shell;














import java.awt.Label;
import java.awt.List;
//import java.awt.Button;
//import java.awt.List;
//import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

public class schema {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void schem() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					schema window = new schema();
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
	public schema() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {	
		frame = new JFrame();
		frame.setBounds(100, 100, 834, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JButton btnContinue = new JButton("CONTINUE");
		
		JPanel intro = new JPanel();
		frame.getContentPane().add(intro, "name_29119616539266");
		intro.setLayout(null);
		
		JPanel main = new JPanel();
		frame.getContentPane().add(main, "name_28799201576133");
		main.setLayout(null);
		
		JMenuBar menuBar_1 = new JMenuBar();
	    menuBar_1.setBounds(0, 0, 818, 21);
	    main.add(menuBar_1);
	    
	    
	    JMenu mnFile = new JMenu("FILE");
	    menuBar_1.add(mnFile);
	    
	    JMenuItem mntmExit = new JMenuItem("EXIT");
	    mntmExit.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try
				{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=SCHEMA;user=sa;password=9838929487");
					Statement st2 = con.createStatement();
					String delete_data_keys="delete from KEYS";
					String delete_data_columns="delete from COLUMNS";
					st2.executeUpdate(delete_data_keys);
					st2.executeUpdate(delete_data_columns);
					System.exit(0);
					
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
	    mnFile.add(mntmExit);
	    
	    JMenu mnTools = new JMenu("TOOLS");
	    menuBar_1.add(mnTools);
	    
	    JMenu mnSecurity = new JMenu("SECURITY");
	    mnTools.add(mnSecurity);
	    
	    JPanel password_entry = new JPanel();
		frame.getContentPane().add(password_entry, "name_14391947670050");
		password_entry.setLayout(null);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(86, 135, 127, 28);
		password_entry.add(lblPassword);
		
		JPanel show_schema = new JPanel();
		frame.getContentPane().add(show_schema, "name_5722432298053");
		show_schema.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 752, 355);
		show_schema.add(scrollPane);
		
		JPanel owl = new JPanel();
		frame.getContentPane().add(owl, "name_1642169434143");
		owl.setLayout(null);
		
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		
		JLabel lblparentclass = new JLabel("New label");
		lblparentclass.setBounds(652, 32, 46, 14);
		owl.add(lblparentclass);
		
		JLabel lblsubclass = new JLabel("new label2");
		lblsubclass.setBounds(719, 32, 46, 14);
		owl.add(lblsubclass);
		
		JButton btnLoadDataProperty = new JButton("LOAD DATA PROPERTY");
		btnLoadDataProperty.setBounds(121, 422, 182, 23);
		owl.add(btnLoadDataProperty);
		
		JButton btnLoadObjectProperty = new JButton("LOAD OBJECT PROPERTY");
		btnLoadObjectProperty.setBounds(285, 422, 189, 23);
		owl.add(btnLoadObjectProperty);
		
		JButton btnLoadInstances = new JButton("LOAD INSTANCES");
		btnLoadInstances.setBounds(526, 422, 173, 23);
		owl.add(btnLoadInstances);
		
	    
	    JMenuItem mntmPassword = new JMenuItem("PASSWORD");
	    mntmPassword.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		PASSWORD obj = new PASSWORD();
				obj.pass();
	    		
	    	}
	    });
	    mnSecurity.add(mntmPassword);
	    
	    JMenuItem mntmEncryption = new JMenuItem("ENCRYPTION");
	    mntmEncryption.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		encryption obj2 = new encryption();
	    		obj2.encryp();
	    	}
	    });
	    mnSecurity.add(mntmEncryption);
		
	    
	    JComboBox comboBox = new JComboBox();
		comboBox.setBounds(376, 101, 144, 22);
		main.add(comboBox);
		
		
		
		Label label = new Label("Ontology Creation Using  Database Schema.\r\n");
		label.setFont(new Font("Dialog", Font.BOLD, 18));
		label.setBounds(103, 70, 414, 27);
		intro.add(label);
		
		Label label_1 = new Label("Steps for ontology creation are:");
		label_1.setFont(new Font("Dialog", Font.BOLD, 16));
		label_1.setBounds(103, 103, 291, 27);
		intro.add(label_1);
		
		Label label_2 = new Label("1-Retrieve Database Schema.");
		label_2.setFont(new Font("Dialog", Font.BOLD, 14));
		label_2.setBounds(103, 136, 291, 27);
		intro.add(label_2);
		
		Label label_3 = new Label("2-Create OWL File using Schema.");
		label_3.setFont(new Font("Dialog", Font.BOLD, 14));
		label_3.setBounds(103, 156, 291, 27);
		intro.add(label_3);
		
		Label label_4 = new Label("3-Develop Ontology Graph.");
		label_4.setFont(new Font("Dialog", Font.BOLD, 14));
		label_4.setBounds(103, 179, 291, 27);
		intro.add(label_4);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(10, 29, 141, 20);
		owl.add(comboBox_2);	
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(161, 29, 154, 20);
		owl.add(comboBox_3);
		
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=SCHEMA;user=sa;password=9838929487");
					Statement st2 = con.createStatement();
					String delete_data_keys="delete from KEYS";
					String delete_data_columns="delete from COLUMNS";
					st2.executeUpdate(delete_data_keys);
					st2.executeUpdate(delete_data_columns);
										
					Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=UNIVERSITY;user=sa;password=9838929487");
					Statement st = conn.createStatement();
					String list_databases="select * from sys.databases WHERE name NOT IN ('master', 'tempdb', 'model', 'msdb','SCHEMA','PASSWORD','check_connection','updated_check_connection','ADMIN')";
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
				intro.setVisible(false);
				main.setVisible(true);
			}
		});
		btnContinue.setBounds(401, 288, 116, 23);
		intro.add(btnContinue);
		
		
		JLabel lblHello = new JLabel("SELECT DATABASE");
		lblHello.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHello.setBounds(173, 101, 206, 22);
		main.add(lblHello);
		
		
		JLabel lblSelectTable = new JLabel("SELECT TABLE");
		lblSelectTable.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSelectTable.setBounds(173, 155, 160, 22);
		main.add(lblSelectTable);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(376, 155, 144, 22);
		main.add(comboBox_1);
		
		JButton btnShowColumns = new JButton("SHOW COLUMNS");
		btnShowColumns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String colm[]=new String[20];
				try{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName="+comboBox.getSelectedItem().toString()+";user=sa;password=9838929487");
					Statement st123 = conn.createStatement();
					String show_columns="SELECT COLUMN_NAME FROM "+comboBox.getSelectedItem().toString()+".INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '"+comboBox_1.getSelectedItem().toString()+"'" ;
					//System.out.println(show_columns);
					ResultSet rs = st123.executeQuery(show_columns);
					int i=0;
					while (rs.next()) {			
						//System.out.println(rs.getString(1));
						colm[i]=rs.getString(1);
						i=i+1;
					}
					colm = Arrays.stream(colm)
		                     .filter(s -> (s != null && s.length() > 0))
		                     .toArray(String[]::new);    

					
					JOptionPane.showMessageDialog(frame,
							colm,
						    "COLUMNS",
						    JOptionPane.PLAIN_MESSAGE);
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
		btnShowColumns.setBounds(173, 219, 143, 23);
		main.add(btnShowColumns);
		
		JButton btnPrimaryKeys = new JButton("PRIMARY KEYS");
		btnPrimaryKeys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String pkey[]=new String[20];
				try{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName="+comboBox.getSelectedItem().toString()+";user=sa;password=9838929487");
					Statement st123 = conn.createStatement();
					String show_pkey="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE OBJECTPROPERTY(OBJECT_ID(CONSTRAINT_SCHEMA+'.'+CONSTRAINT_NAME), 'IsPrimaryKey') = 1 AND TABLE_NAME = '"+comboBox_1.getSelectedItem().toString()+"'";
					//System.out.println(show_pkey);
					ResultSet rs = st123.executeQuery(show_pkey);
					int i=0;
					while (rs.next()) {			
						//System.out.println(rs.getString(1));
						pkey[i]=rs.getString(1);
						i=i+1;
					}
					pkey = Arrays.stream(pkey)
		                     .filter(s -> (s != null && s.length() > 0))
		                     .toArray(String[]::new);    

					if(pkey.length!=0)
					{
					JOptionPane.showMessageDialog(frame,
							pkey,
						    "PRIMARY KEYS",
						    JOptionPane.PLAIN_MESSAGE);
				}
					else
					{
						JOptionPane.showMessageDialog(frame,
								"NO PRIMARY KEYS",
							    "PRIMARY KEYS",
							    JOptionPane.PLAIN_MESSAGE);
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
		btnPrimaryKeys.setBounds(326, 219, 123, 23);
		main.add(btnPrimaryKeys);
		
		JButton btnForeignKeys = new JButton("FOREIGN KEYS");
		btnForeignKeys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Fkey[]=new String[20];
				try{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName="+comboBox.getSelectedItem().toString()+";user=sa;password=9838929487");
					Statement st123 = conn.createStatement();
					String show_Fkey="SELECT c.NAME 'Parent column name' FROM sys.foreign_key_columns fkc INNER JOIN sys.columns c ON fkc.parent_column_id = c.column_id AND fkc.parent_object_id = c.object_id INNER JOIN sys.columns cref ON fkc.referenced_column_id = cref.column_id AND fkc.referenced_object_id = cref.object_id where OBJECT_NAME(parent_object_id) = '"+comboBox_1.getSelectedItem().toString()+"'";
					//System.out.println(show_Fkey);
					ResultSet rs = st123.executeQuery(show_Fkey);
					int i=0;
					while (rs.next()) {			
						//System.out.println(rs.getString(1));
						Fkey[i]=rs.getString(1);
						i=i+1;
					}
					Fkey = Arrays.stream(Fkey)
		                     .filter(s -> (s != null && s.length() > 0))
		                     .toArray(String[]::new);    

					if(Fkey.length!=0)
					{
					JOptionPane.showMessageDialog(frame,
							Fkey,
						    "FOREIGN KEYS",
						    JOptionPane.PLAIN_MESSAGE);
				}
					else
					{
						JOptionPane.showMessageDialog(frame,
								"NO FOREIGN KEYS",
							    "PRIMARY KEYS",
							    JOptionPane.PLAIN_MESSAGE);
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
		btnForeignKeys.setBounds(459, 219, 128, 23);
		main.add(btnForeignKeys);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//String database_name=comboBox.getSelectedItem().toString();
				String dbnames[]=new String[20];
				String table_names[]=new String[20];
				//String coln[]=new String[20];
				int pass_check=0;
				try{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					
					Connection conn2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=PASSWORD;user=sa;password=9838929487");
					Statement st2 = conn2.createStatement();
					String select_all_databasename="select database_name from database_passwords";
					ResultSet rs2 = st2.executeQuery(select_all_databasename);
					int i=0;
					int flag=0;
					while (rs2.next()) {	
						dbnames[i]=rs2.getString(1);
						i=i+1;	
					}
					dbnames = Arrays.stream(dbnames)
		                     .filter(s -> (s != null && s.length() > 0))
		                     .toArray(String[]::new);
					for(int j=0;j<dbnames.length;j++)
					{						
						if(dbnames[j].equals(comboBox.getSelectedItem().toString()))
						{
							flag=1;
						}
					}
					if(flag==1)
					{
						String Stored_pass="";
						//System.out.println("enter password");
						JPasswordField pwd = new JPasswordField(10);
						int password_input=JOptionPane.showConfirmDialog(null, pwd,"Enter Password",JOptionPane.OK_CANCEL_OPTION); 
						String entered_pass=pwd.getText();
						//System.out.println(pass);
						Connection conn3 = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=PASSWORD;user=sa;password=9838929487");
						Statement st3= conn3.createStatement();
						String select_password="select * from database_passwords where database_name= '"+comboBox.getSelectedItem().toString()+"'";
						//System.out.println(select_password);
						ResultSet rs_pass = st3.executeQuery(select_password);
						while(rs_pass.next())
						{
							//System.out.println(rs_pass.getString(2));
							Stored_pass = rs_pass.getString(2);
						}
						if(entered_pass.equals(Stored_pass))
						{
							Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName="+comboBox.getSelectedItem().toString()+";user=sa;password=9838929487");
							Statement st = conn.createStatement();
							String list_tables_in_database="select * from sys.Tables";
							ResultSet rs = st.executeQuery(list_tables_in_database);
							int j=0;
							while (rs.next()) {			
								//System.out.println(rs.getString(1));
								table_names[j]=rs.getString(1);
								j=j+1;
							}
						}
						else{
							pass_check=1;;
							JOptionPane.showMessageDialog(frame,
								    "Wrong Password.",
								    "Password Error",
								    JOptionPane.ERROR_MESSAGE);
							//System.out.println("wrong password");
						}
					}
					else
					{
					Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName="+comboBox.getSelectedItem().toString()+";user=sa;password=9838929487");
					Statement st = conn.createStatement();
					String list_tables_in_database="select * from sys.Tables";
					ResultSet rs = st.executeQuery(list_tables_in_database);
					int j=0;
					while (rs.next()) {			
						//System.out.println(rs.getString(1));
						table_names[j]=rs.getString(1);
						j=j+1;
					}
					}
					if(pass_check==0)
					{
						table_names = Arrays.stream(table_names)
			                     .filter(s -> (s != null && s.length() > 0))
			                     .toArray(String[]::new);
						for(int l=0;l<table_names.length;l++)
						{
						//System.out.println("TABLE NAME: "+table_names[l]);
						if(l>0)
						{
							textArea.append("\n");
						}
							textArea.append("TABLE NAME : "+table_names[l]+"\n");	
							textArea.append("COLUMN NAME : ");
							Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName="+comboBox.getSelectedItem().toString()+";user=sa;password=9838929487");
							Statement st6 =conn.createStatement();
							String list_columns="SELECT COLUMN_NAME FROM "+comboBox.getSelectedItem().toString()+".INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '"+table_names[l]+"'" ;
							ResultSet rs6 = st6.executeQuery(list_columns);
							int ii=0;
							while (rs6.next()) {			
								if(ii>0)
								{
									textArea.append(", ");
								}
								textArea.append(rs6.getString(1));
								ii=ii+1;
							}
							textArea.append("\nPRIMARY KEYS : ");
							Statement st7 =conn.createStatement();
							String list_primary_key="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE OBJECTPROPERTY(OBJECT_ID(CONSTRAINT_SCHEMA+'.'+CONSTRAINT_NAME), 'IsPrimaryKey') = 1 AND TABLE_NAME = '"+table_names[l]+"'";
							ResultSet rs7=st7.executeQuery(list_primary_key);
							int jj=0;
							while (rs7.next()) {			
								if(jj>0)
								{
									textArea.append(", ");
								}
								textArea.append(rs7.getString(1));
								jj=jj+1;
							}
							textArea.append("\nFOREIGN KEYS : ");
							Statement st8 =conn.createStatement();
							String list_foreign_key="SELECT c.NAME 'Parent column name' FROM sys.foreign_key_columns fkc INNER JOIN sys.columns c ON fkc.parent_column_id = c.column_id AND fkc.parent_object_id = c.object_id INNER JOIN sys.columns cref ON fkc.referenced_column_id = cref.column_id AND fkc.referenced_object_id = cref.object_id where OBJECT_NAME(parent_object_id) = '"+table_names[l]+"'";
							ResultSet rs8=st8.executeQuery(list_foreign_key);
							int kk=0;
							while (rs8.next()) {			
								if(kk>0)
								{
									textArea.append(", ");
								}
								textArea.append(rs8.getString(1));
								kk=kk+1;
							}		
							textArea.append("\n-------------------------------------------------------------");
							}					
						main.setVisible(false);
						show_schema.setVisible(true);
						textArea.setEditable(false);
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
		btnNext.setBounds(586, 357, 89, 23);
		main.add(btnNext);
		
		JButton btnNewButton = new JButton("GO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int itemCount = comboBox_1.getItemCount();

			    for(int i=0;i<itemCount;i++){
			        comboBox_1.removeItemAt(0);
			     }
			    String dbnames[]=new String[20];
				try{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					
					Connection conn2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=PASSWORD;user=sa;password=9838929487");
					Statement st2 = conn2.createStatement();
					String select_all_databasename="select database_name from database_passwords";
					ResultSet rs2 = st2.executeQuery(select_all_databasename);
					int i=0;
					int flag=0;
					while (rs2.next()) {	
						dbnames[i]=rs2.getString(1);
						i=i+1;	
					}
					dbnames = Arrays.stream(dbnames)
		                     .filter(s -> (s != null && s.length() > 0))
		                     .toArray(String[]::new);
					for(int j=0;j<dbnames.length;j++)
					{						
						if(dbnames[j].equals(comboBox.getSelectedItem().toString()))
						{
							flag=1;
						}
					}
					if(flag==1)
					{
						String Stored_pass="";
						//System.out.println("enter password");
						JPasswordField pwd = new JPasswordField(10);
						int password_input=JOptionPane.showConfirmDialog(null, pwd,"Enter Password",JOptionPane.OK_CANCEL_OPTION); 
						String entered_pass=pwd.getText();
						//System.out.println(pass);
						Connection conn3 = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=PASSWORD;user=sa;password=9838929487");
						Statement st3= conn3.createStatement();
						String select_password="select * from database_passwords where database_name= '"+comboBox.getSelectedItem().toString()+"'";
						//System.out.println(select_password);
						ResultSet rs_pass = st3.executeQuery(select_password);
						while(rs_pass.next())
						{
							//System.out.println(rs_pass.getString(2));
							Stored_pass = rs_pass.getString(2);
						}
						if(entered_pass.equals(Stored_pass))
						{
							Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName="+comboBox.getSelectedItem().toString()+";user=sa;password=9838929487");
							Statement st = conn.createStatement();
							String list_tables_in_database="select * from sys.Tables";
							ResultSet rs = st.executeQuery(list_tables_in_database);
							while (rs.next()) {			
								//System.out.println(rs.getString(1));
								comboBox_1.addItem(rs.getString(1));
							}
						}
						else{
							JOptionPane.showMessageDialog(frame,
								    "Wrong Password.",
								    "Password Error",
								    JOptionPane.ERROR_MESSAGE);
							//System.out.println("wrong password");
						}
						
					}
					else
					{
					Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName="+comboBox.getSelectedItem().toString()+";user=sa;password=9838929487");
					Statement st = conn.createStatement();
					String list_tables_in_database="select * from sys.Tables";
					ResultSet rs = st.executeQuery(list_tables_in_database);
					while (rs.next()) {			
						//System.out.println(rs.getString(1));
						comboBox_1.addItem(rs.getString(1));
					}
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
		btnNewButton.setBounds(530, 101, 51, 23);
		main.add(btnNewButton);
		
		JButton btnNext_1 = new JButton("NEXT");
		btnNext_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*codes to store keys in database*/
				lblparentclass.setVisible(false);
				lblsubclass.setVisible(false);
				comboBox_2.setVisible(false);
				comboBox_3.setVisible(false);
				String table_n[]=new String[20];
				String pkey[]=new String[20];
				String fkey[]=new String[20];
				try
				{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection conn2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName="+comboBox.getSelectedItem().toString()+";user=sa;password=9838929487");
					Statement st2 = conn2.createStatement();
					String table_nam="select * from sys.Tables";
					ResultSet rs= st2.executeQuery(table_nam);
					int i=0;
					while(rs.next())
					{
						table_n[i]=rs.getString(1);
						i=i+1;
					}
					table_n = Arrays.stream(table_n)
		                     .filter(s -> (s != null && s.length() > 0))
		                     .toArray(String[]::new);
					Statement st3=conn2.createStatement();				
					for(int ii=0;ii<table_n.length;ii++)
					{
						//String temp_array[]=new String[20];
						String pk="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE OBJECTPROPERTY(OBJECT_ID(CONSTRAINT_SCHEMA+'.'+CONSTRAINT_NAME), 'IsPrimaryKey') = 1 AND TABLE_NAME = '"+table_n[ii]+"'";
						ResultSet rs2=st3.executeQuery(pk);
						int j=0;
						while(rs2.next())
						{	
							j=j+1;
							if(j>1)
							{
								pkey[ii]=pkey[ii]+","+rs2.getString(1);
							}
							else
							{
							pkey[ii]=rs2.getString(1);
							}
							
						}
					}	
						
					for(int ii=0;ii<table_n.length;ii++)
					{
						String fk="SELECT c.NAME 'Parent column name' FROM sys.foreign_key_columns fkc INNER JOIN sys.columns c ON fkc.parent_column_id = c.column_id AND fkc.parent_object_id = c.object_id INNER JOIN sys.columns cref ON fkc.referenced_column_id = cref.column_id AND fkc.referenced_object_id = cref.object_id where OBJECT_NAME(parent_object_id) = '"+table_n[ii]+"'";
						ResultSet rs2=st3.executeQuery(fk);
						int j=0;
						while(rs2.next())
						{
							j=j+1;
							if(j==2)
							{
								fkey[ii]=fkey[ii]+","+rs2.getString(1);
							}
							else
							{
							fkey[ii]=rs2.getString(1);
							}
						}
					}	
					Connection conn3 = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=SCHEMA;user=sa;password=9838929487");
					Statement st4 = conn3.createStatement();
					//Statement st5 = conn3.createStatement();
						for(int y=0;y<table_n.length;y++)
						{
						String store_in_schema ="insert into KEYS (TABLE_NAME,PKEY,FKEY) values('"+table_n[y]+"','"+pkey[y]+"','"+fkey[y]+"')";
						st4.executeUpdate(store_in_schema);
						}					
				}
				catch (SQLException e1)
				{
                    System.err.println("SQL EXCEPTION problem");
				}
				
				catch (ClassNotFoundException e2)
				{
                    System.err.println("Could not load JDBC driver");
				}
				
				show_schema.setVisible(false);
				btnLoadDataProperty.setVisible(false);
				btnLoadObjectProperty.setVisible(false);
				btnLoadInstances.setVisible(false);
				owl.setVisible(true);
				//btnLoadDataPropert
			}	
		});
		btnNext_1.setBounds(673, 407, 89, 23);
		show_schema.add(btnNext_1);
		
		JLabel lblTableDetails = new JLabel("TABLE DETAILS :");
		lblTableDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTableDetails.setBounds(10, 18, 280, 14);
		show_schema.add(lblTableDetails);
		
		
		
		JLabel lblOwlFile = new JLabel("OWL FILE");
		lblOwlFile.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOwlFile.setBounds(339, 32, 189, 17);
		owl.add(lblOwlFile);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 50, 766, 368);
		owl.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		JButton btnLoadOwl = new JButton("LOAD CLASS");
		btnLoadOwl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//codes to CREATE OWL
				String owl_class[]=new String[20];
				String class_with_same_pkey[]=new String[20];
				String class1=null;
				String class2=null;
				String same_pkey = null;
				String subclass=null;
				String parentclass=null;
				try
				{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=SCHEMA;user=sa;password=9838929487");
					Statement st2 = con.createStatement();
					String classs="SELECT TABLE_NAME FROM KEYS WHERE KEYS.PKEY NOT LIKE '%,%'";
					//String classs="select TABLE_NAME FROM KEYS WHERE PKEY<>FKEY";
					ResultSet rs=st2.executeQuery(classs);
					int i=0;
					while(rs.next())
					{
						owl_class[i]=rs.getString(1);
						i=i+1;
					}
					String sub_class=" SELECT TABLE_NAME,PKEY FROM KEYS WHERE PKEY in (SELECT PKEY FROM KEYS GROUP BY PKEY HAVING COUNT(*)>1)";//selecting table with same pkey
					ResultSet rs3=st2.executeQuery(sub_class);
					int j=0;
					while(rs3.next())
					{
						same_pkey=rs3.getString(2);
						class_with_same_pkey[j]=rs3.getString(1);
						j=j+1;
					}
					class_with_same_pkey = Arrays.stream(class_with_same_pkey)
		                     .filter(s -> (s != null && s.length() > 0))
		                     .toArray(String[]::new);
					
					Connection con2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName="+comboBox.getSelectedItem().toString()+";user=sa;password=9838929487");
					Statement st3 = con2.createStatement();
					for(int l=0;l<class_with_same_pkey.length-1;l++)
					{
						for(int ll=l+1;ll<class_with_same_pkey.length;ll++)
						{
					String select_pk_values="select "+same_pkey+" from "+class_with_same_pkey[l]+" as a where exists (select "+same_pkey+" from "+class_with_same_pkey[ll]+" as b where b."+same_pkey+"=a."+same_pkey+")";
					//System.out.println(select_pk_values);
					ResultSet rs4=st3.executeQuery(select_pk_values);
					String check[]=new String[40];
					int c=0;
					while(rs4.next())
					{
						check[c]=rs4.getString(1);
						c=c+1;
					}
					check = Arrays.stream(check)
		                     .filter(s -> (s != null && s.length() > 0))
		                     .toArray(String[]::new);
					if(check.length!=0)
					{
						class1=class_with_same_pkey[l];/////class1, class2 are parent class and subclass....*/
						class2=class_with_same_pkey[ll];
						//System.out.println(class1);
						//System.out.println(class2);
					}
					}
					}
					int num_row1=0,num_row2=0;
					String class1_num_of_rows="SELECT COUNT("+same_pkey+") FROM "+class1; ////query to get number of values in same pkey column of both table
					String class2_num_of_rows="SELECT COUNT("+same_pkey+") FROM "+class2;
					//System.out.println(class1_num_of_rows);
					//System.out.println(class2_num_of_rows);
					ResultSet rs5=st3.executeQuery(class1_num_of_rows);
					while(rs5.next())
					{
						num_row1=rs5.getInt(1);
						//System.out.println(class1);
						//System.out.println(num_row1);
					}
					ResultSet rs6=st3.executeQuery(class2_num_of_rows);
					while(rs6.next())
					{
						num_row2=rs6.getInt(1);
						//System.out.println(class2);
						//System.out.println(num_row2);
					}
					if(num_row2>num_row1)
					{
						parentclass=class2;
						subclass=class1;
						
					}
					else
					{
						parentclass=class1;
						subclass=class2;
					}
					//delete subclass from owl_class[]
					int loc;
					for(int i2=0;i2<owl_class.length;i2++)
					{
						//find subclass in owl_class[]
						if(subclass.equals(owl_class[i2]))
						{
							loc=i2;
							owl_class[i2]=null;
						}
					}
					owl_class = Arrays.stream(owl_class)
		                     .filter(s -> (s != null && s.length() > 0))
		                     .toArray(String[]::new);	
					
					//for(int j3=0;j3<owl_class.length;j3++)
					//{
						//System.out.println(owl_class[j3]);
					//}				
				}
				catch (SQLException e1)
				{
                    System.err.println("SQL EXCEPTION");
				}
				
				catch (ClassNotFoundException e2)
				{
                    System.err.println("Could not load JDBC driver");
				}
				owl_class = Arrays.stream(owl_class)
	                     .filter(s -> (s != null && s.length() > 0))
	                     .toArray(String[]::new);
				File file = new File("C://Users/ASHUTOSH/Desktop/temp_ontology.txt");
				try
				{
					FileReader Reader=new FileReader(file);
					BufferedReader br = new BufferedReader(Reader);
					textArea_1.read(br,null);
					br.close();
				}
				catch(Exception e)
				{
					System.out.println("error in loading header");
				}
				textArea_1.append("<!--////classes//////-->");
				for(int i=0;i<owl_class.length;i++)
				{
					textArea_1.append("\n<owl:Class rdf:about=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+owl_class[i]+"\">");
					textArea_1.append("\n</owl:Class>");
					//System.out.println(owl_class[i]);
				}
				if(parentclass.equals(null) && subclass.equals(null))
				{
				}
				else
				{
					textArea_1.append("\n<owl:Class rdf:about=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+subclass+"\">");
					textArea_1.append("\n<rdfs:subClassOf rdf:resource=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+parentclass+"\"/>");
					textArea_1.append("\n</owl:Class>");
				}
				textArea_1.append("\n<!--////data property//////-->");
				lblparentclass.setText(parentclass);
				lblsubclass.setText(subclass);		
				textArea_1.setEditable(false);
				btnLoadOwl.setVisible(false);
				btnLoadDataProperty.setVisible(true);
			}	
		});
		btnLoadOwl.setBounds(10, 422, 117, 23);
		owl.add(btnLoadOwl);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=SCHEMA;user=sa;password=9838929487");
					Statement st2 = con.createStatement();
					String delete_data_keys="delete from KEYS";
					String delete_data_columns="delete from COLUMNS";
					st2.executeUpdate(delete_data_keys);
					st2.executeUpdate(delete_data_columns);
					System.exit(0);
					
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
		btnClose.setBounds(719, 422, 89, 23);
		owl.add(btnClose);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 818, 21);
		owl.add(menuBar);
		
		JMenu mnFile_1 = new JMenu("FILE");
		menuBar.add(mnFile_1);
		
		JMenuItem mntmSave = new JMenuItem("SAVE");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fs = new JFileChooser(new File("C:\\"));
				fs.setDialogTitle("Save OWL File");
				int result = fs.showSaveDialog(null);
				if(result==JFileChooser.APPROVE_OPTION)
				{
					String content=textArea_1.getText();
					File fi = fs.getSelectedFile();
					try
					{
						FileWriter fw = new FileWriter(fi.getPath());
						fw.write(content);
						fw.flush();
						fw.close();
						
					}
					catch(Exception e2)
					{
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
				}
			}
		});
		mnFile_1.add(mntmSave);
		
		JMenuItem mntmExit_1 = new JMenuItem("EXIT");
		mntmExit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=SCHEMA;user=sa;password=9838929487");
					Statement st2 = con.createStatement();
					String delete_data_keys="delete from KEYS";
					String delete_data_columns="delete from COLUMNS";
					st2.executeUpdate(delete_data_keys);
					st2.executeUpdate(delete_data_columns);
					System.exit(0);
					
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
		mnFile_1.add(mntmExit_1);
		
		btnLoadInstances.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// code for loading instances , by using dataproperty array and object property array
				String dtaprop[]=new String[40];
				String objprop[]=new String[40];
				String class_name[]=new String[40];
				for(int i=0;i<comboBox_2.getItemCount();i++)
				{
					dtaprop[i]=comboBox_2.getItemAt(i).toString();
					//System.out.println(dtaprop[i]);
				}
				dtaprop = Arrays.stream(dtaprop)
		                .filter(s -> (s != null && s.length() > 0))
		                .toArray(String[]::new);
				for(int j=0;j<comboBox_3.getItemCount();j++)
				{
					objprop[j]=comboBox_3.getItemAt(j).toString();
					//System.out.println(objprop[j]);
				}
				objprop = Arrays.stream(objprop)
		                .filter(s -> (s != null && s.length() > 0))
		                .toArray(String[]::new);
				// codes to store class names in array
				for(int i2=0;i2<dtaprop.length;i2++)
				{
					class_name[i2]=dtaprop[i2].split("\\.")[0];
				}
				class_name = Arrays.stream(class_name)
		                .filter(s -> (s != null && s.length() > 0))
		                .toArray(String[]::new);
				//code to remove duplicate values from class_name array
				int size=class_name.length;
				for(int exp=0;exp<size;exp++)
				{
					for(int exp2=exp+1;exp2<size;exp2++)
					{
						if (class_name[exp].equals(class_name[exp2]))
						{
							while (exp2 < (size) - 1)
							{
								 class_name[exp2] = class_name[exp2 + 1];// shifting the values
		                            exp2++;
							}
							size--;
						}
					}
				}
				for(int exp3=size;exp3<class_name.length;exp3++)
				{
					class_name[exp3]=null;
				}
				class_name = Arrays.stream(class_name)
		                .filter(s -> (s != null && s.length() > 0))
		                .toArray(String[]::new);
				/*for(int exp4=0;exp4<class_name.length;exp4++)
				{
					System.out.println(class_name[exp4]);
				}*/
				//codes to add tuples 
				//connection to database, connection to table
				textArea_1.append("\n<!--/////INSTANCES////-->");
				try
				{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName="+comboBox.getSelectedItem().toString()+";user=sa;password=9838929487");
					Statement st2=con.createStatement();
					//count number of dataproperty of one table
					String tab_with_two_fkey[]=new String[5];
					int index=0;
					String table[]=new String[20];
					String obj_prop_with_two_fkey[]=new String[5];
					int index1=0;
					String refered_tab[][]=new String[5][5];
					String select_table_names="select * from sys.tables";
					ResultSet rs0=st2.executeQuery(select_table_names);
					int i0=0;
					while(rs0.next())
					{
						table[i0]=rs0.getString(1);
						i0=i0+1;
					}
					table = Arrays.stream(table)
			                .filter(s -> (s != null && s.length() > 0))
			                .toArray(String[]::new);
					for(int i00=0;i00<table.length;i00++)
					{
						String select_fkey="SELECT c.NAME 'Parent column name' FROM sys.foreign_key_columns fkc INNER JOIN sys.columns c ON fkc.parent_column_id = c.column_id AND fkc.parent_object_id = c.object_id INNER JOIN sys.columns cref ON fkc.referenced_column_id = cref.column_id AND fkc.referenced_object_id = cref.object_id where OBJECT_NAME(parent_object_id) = '"+table[i00]+"'";
						ResultSet rs9=st2.executeQuery(select_fkey);
						int ii=0;
						while(rs9.next())
						{
							ii=ii+1;
						}
						if(ii==2)
						{
							tab_with_two_fkey[index]=table[i00];
							index++;
						}
					}
					tab_with_two_fkey = Arrays.stream(tab_with_two_fkey)
			                .filter(s -> (s != null && s.length() > 0))
			                .toArray(String[]::new);
					/*// referred tables by table having two foreign keys
					String reffered_table_by_table_having_two_fkey="SELECT OBJECT_NAME(f.parent_object_id) AS TableName,COL_NAME(fc.parent_object_id, fc.parent_column_id) AS ColumnName,OBJECT_NAME (f.referenced_object_id) AS ReferenceTableName,COL_NAME(fc.referenced_object_id, fc.referenced_column_id) AS ReferenceColumnName FROM sys.foreign_keys AS f INNER JOIN sys.foreign_key_columns AS fc ON f.OBJECT_ID = fc.constraint_object_id";
					for(int ii4=0;ii4<tab_with_two_fkey.length;ii4++)
					{
						int ii5=0;
						ResultSet rs16=st2.executeQuery(reffered_table_by_table_having_two_fkey);
						while(rs16.next())
						{
							if(rs16.getString(1).equals(tab_with_two_fkey[ii4]))
							{
								refered_tab[ii4][ii5]=rs16.getString(3);
								ii5++;
							}
						}
					}
					// remove null values from two dimensional array refered_tab[][]
					*/
					for(int ii3=0;ii3<tab_with_two_fkey.length;ii3++)
					{
					for(int ii2=0;ii2<comboBox_3.getItemCount();ii2++)
					{
						if(comboBox_3.getItemAt(ii2).toString().contains(tab_with_two_fkey[ii3]))
						{
							obj_prop_with_two_fkey[index1]=comboBox_3.getItemAt(ii2).toString();
							index1++;
						}
					}
					}
					obj_prop_with_two_fkey = Arrays.stream(obj_prop_with_two_fkey)
			                .filter(s -> (s != null && s.length() > 0))
			                .toArray(String[]::new);
					for(int k=0;k<class_name.length;k++)
					{
						String primarykey="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE OBJECTPROPERTY(OBJECT_ID(CONSTRAINT_SCHEMA+'.'+CONSTRAINT_NAME), 'IsPrimaryKey') = 1 AND TABLE_NAME = '"+class_name[k]+"'";
						ResultSet rs=st2.executeQuery(primarykey);
						String abc="";
						while(rs.next())
							{
							abc=rs.getString(1);
							}
						//sql query to count number of rows in abc which is primary key
						String number_of_rows="SELECT COUNT("+abc+") FROM "+class_name[k];
						ResultSet rs2=st2.executeQuery(number_of_rows);
						rs2.next();
						String instance_value[]=new String[rs2.getInt(1)];
						String instanceid="select "+abc+" from "+class_name[k];
						ResultSet rs1=st2.executeQuery(instanceid);
						int i=0;
						while(rs1.next())
						{
							instance_value[i]=rs1.getString(1);
							i=i+1;
						}
						//code to connect to table and select column names except foreighn key column
						String select_primary_key="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE OBJECTPROPERTY(OBJECT_ID(CONSTRAINT_SCHEMA+'.'+CONSTRAINT_NAME), 'IsPrimaryKey') = 1 AND TABLE_NAME = '"+class_name[k]+"'";
						ResultSet rs4=st2.executeQuery(select_primary_key);
						rs4.next();
						String primary_key=rs4.getString(1);
						String select_col_except_fkey="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '"+class_name[k]+"' EXCEPT SELECT c.NAME 'Parent column name' FROM sys.foreign_key_columns fkc INNER JOIN sys.columns c ON fkc.parent_column_id = c.column_id AND fkc.parent_object_id = c.object_id INNER JOIN sys.columns cref ON fkc.referenced_column_id = cref.column_id AND fkc.referenced_object_id = cref.object_id  where   OBJECT_NAME(parent_object_id) = '"+class_name[k]+"'";
						ResultSet rs3=st2.executeQuery(select_col_except_fkey);
						//System.out.println(class_name[k]);
						int i3=0;
						while(rs3.next())
						{
							i3=i3+1; //count number of columns in a table except foriegn key
						}
						String col[]=new String[i3]; // to store columns except foriegn key
						ResultSet rs5=st2.executeQuery(select_col_except_fkey);
						int i2=0;
						while(rs5.next())
						{
							col[i2]=rs5.getString(1);
							i2=i2+1;
						}	
						for(int k3=0;k3<instance_value.length;k3++)
						{
						textArea_1.append("\n<owl:NamedIndividual rdf:about=\"&temp_ontology;"+instance_value[k3]+"\">");
						textArea_1.append("\n<rdf:type rdf:resource=\"&temp_ontology;"+class_name[k]+"\"/>");
						for(int k4=0;k4<col.length;k4++)
						{
						String row="select "+col[k4]+" from "+class_name[k]+" where "+primary_key+ "= '"+instance_value[k3]+"'";
						ResultSet rs6=st2.executeQuery(row);
						rs6.next();
						textArea_1.append("\n<temp_ontology:"+class_name[k]+"."+col[k4]+" rdf:datatype=\"&xsd;string\">"+rs6.getString(1)+"</temp_ontology:"+class_name[k]+"."+col[k4]+">");
						}
						int i6=0;
						for(int k5=0;k5<objprop.length;k5++) // this loop is for finding object property having classes which has two foreign keys
						{
							String str=objprop[k5];
							String[] parts=str.split("-");
							String class_befor_dash=parts[0];
							String class_after_dash=parts[1];
							String fkey_firstpart_table="SELECT c.NAME 'Parent column name' FROM sys.foreign_key_columns fkc INNER JOIN sys.columns c ON fkc.parent_column_id = c.column_id AND fkc.parent_object_id = c.object_id INNER JOIN sys.columns cref ON fkc.referenced_column_id = cref.column_id AND fkc.referenced_object_id = cref.object_id where OBJECT_NAME(parent_object_id) = '"+class_befor_dash+"'";
							String fkey_second_table="SELECT c.NAME 'Parent column name' FROM sys.foreign_key_columns fkc INNER JOIN sys.columns c ON fkc.parent_column_id = c.column_id AND fkc.parent_object_id = c.object_id INNER JOIN sys.columns cref ON fkc.referenced_column_id = cref.column_id AND fkc.referenced_object_id = cref.object_id where OBJECT_NAME(parent_object_id) = '"+class_after_dash+"'";
							String fkey_firsttab[]=new String[2];
							String fkey_Secondtab[]=new String[2];
							//String tab_with_two_fkey[]=new String[5];
							ResultSet rs7=st2.executeQuery(fkey_firstpart_table);
							int i4=0;
							while(rs7.next())
							{
								fkey_firsttab[i4]=rs7.getString(1);
								i4=i4+1;
							}
							fkey_firsttab = Arrays.stream(fkey_firsttab)
					                .filter(s -> (s != null && s.length() > 0))
					                .toArray(String[]::new);
							
							ResultSet rs8=st2.executeQuery(fkey_second_table);
							int i5=0;
							while(rs8.next())
							{
								fkey_Secondtab[i5]=rs8.getString(1);
								i5=i5+1;
							}
							fkey_Secondtab = Arrays.stream(fkey_Secondtab)
					                .filter(s -> (s != null && s.length() > 0))
					                .toArray(String[]::new);
							if(fkey_firsttab.length>1 || fkey_Secondtab.length>1)
							{
								objprop[k5]=null;
							}
							objprop = Arrays.stream(objprop)
					                .filter(s -> (s != null && s.length() > 0))
					                .toArray(String[]::new);
						}
						for(int k6=0;k6<objprop.length;k6++)
						{
						if(objprop[k6].startsWith(class_name[k]) && objprop[k6].contains(class_name[k]))
						{
							String str = objprop[k6];
							String[] parts = str.split("-");
							String class_before_dash=parts[0];
							String class_after_dash=parts[1];
							// check whether foreign key exists for table before dash
							String check_fkey="SELECT c.NAME 'Parent column name' FROM sys.foreign_key_columns fkc INNER JOIN sys.columns c ON fkc.parent_column_id = c.column_id AND fkc.parent_object_id = c.object_id INNER JOIN sys.columns cref ON fkc.referenced_column_id = cref.column_id AND fkc.referenced_object_id = cref.object_id where OBJECT_NAME(parent_object_id) = '"+class_before_dash+"'";
							String fkey_of_class_before_dash="";
							ResultSet rs10=st2.executeQuery(check_fkey);
							int ii3=0;
							while(rs10.next())
							{
								ii3=ii3+1;
								fkey_of_class_before_dash=rs10.getString(1);
							}
							if(ii3>0)
							{
								String val="";
								String tab_name_with_two_fkey="";
								String col_name_of_table_with_two_keys="";
								String Reference_tab_name="";
								String Reference_Col_Name="";
								String c1="";
								String col_of_tab_with_two_fkey[]=new String[5];
								String select_fkey_value_equal_to_primarykey="select "+fkey_of_class_before_dash+" from "+class_name[k]+" where "+primary_key+"='"+instance_value[k3]+"'";
								//System.out.println(select_fkey_value_equal_to_primarykey);
								ResultSet rs11=st2.executeQuery(select_fkey_value_equal_to_primarykey);
								rs11.next();
							    val=rs11.getString(1);
								textArea_1.append("\n<temp_ontology:"+objprop[k6]+" rdf:resource=\"&temp_ontology;"+val+"\"/>");
								String reffered_table_by_table_having_two_fkey="SELECT OBJECT_NAME(f.parent_object_id) AS TableName,COL_NAME(fc.parent_object_id, fc.parent_column_id) AS ColumnName,OBJECT_NAME (f.referenced_object_id) AS ReferenceTableName,COL_NAME(fc.referenced_object_id, fc.referenced_column_id) AS ReferenceColumnName FROM sys.foreign_keys AS f INNER JOIN sys.foreign_key_columns AS fc ON f.OBJECT_ID = fc.constraint_object_id";
								String referred_tab_by_table_with_two_fkey[]=new String[5]; // to store referred table, here table with two fkey will always be one and one only 
								ResultSet rs16=st2.executeQuery(reffered_table_by_table_having_two_fkey);
								int ii5=0;
								while(rs16.next())
								{
									if(rs16.getString(1).equals(tab_with_two_fkey[0]))
									{
										referred_tab_by_table_with_two_fkey[ii5]=rs16.getString(3);
										ii5++;
									}
								}
								referred_tab_by_table_with_two_fkey = Arrays.stream(referred_tab_by_table_with_two_fkey)
						                .filter(s -> (s != null && s.length() > 0))
						                .toArray(String[]::new);
								for(int ii6=0;ii6<referred_tab_by_table_with_two_fkey.length;ii6++)
								{
									if(class_name[k].equals(referred_tab_by_table_with_two_fkey[ii6]))
									{
										for(int ii7=0;ii7<obj_prop_with_two_fkey.length;ii7++)
										{
											if(obj_prop_with_two_fkey[ii7].startsWith(class_name[k]))
											{
												String get_col_names_of_tab_with_two_fkey="SELECT COLUMN_NAME FROM "+comboBox.getSelectedItem().toString()+".INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '"+tab_with_two_fkey[0]+"'";
												ResultSet rs17=st2.executeQuery(get_col_names_of_tab_with_two_fkey);
												int ii8=0;
												while(rs17.next())
												{
													col_of_tab_with_two_fkey[ii8]=rs17.getString(1);
													ii8++;
												}
												col_of_tab_with_two_fkey = Arrays.stream(col_of_tab_with_two_fkey)
										                .filter(s -> (s != null && s.length() > 0))
										                .toArray(String[]::new);
												//below qury is used to get ccommon columns
												
												String get_referred_table_col="SELECT OBJECT_NAME(f.parent_object_id) AS TableName, COL_NAME(fc.parent_object_id, fc.parent_column_id) AS ColumnName, OBJECT_NAME (f.referenced_object_id) AS ReferenceTableName, COL_NAME(fc.referenced_object_id, fc.referenced_column_id) AS ReferenceColumnName FROM sys.foreign_keys AS f INNER JOIN sys.foreign_key_columns AS fc ON f.OBJECT_ID = fc.constraint_object_id";
												ResultSet rs18=st2.executeQuery(get_referred_table_col);
												while(rs18.next())
												{
													if(rs18.getString(3).equals(class_name[k]))
													{
														tab_name_with_two_fkey=rs18.getString(1);
														col_name_of_table_with_two_keys=rs18.getString(2);
														Reference_tab_name=rs18.getString(3);
														Reference_Col_Name=rs18.getString(4);
													}
												}
												for(int ii9=0;ii9<col_of_tab_with_two_fkey.length;ii9++)
												{
													if(!(col_of_tab_with_two_fkey[ii9].equals(col_name_of_table_with_two_keys)))
													{
														c1=col_of_tab_with_two_fkey[ii9];
													}
												}
												// query to get col in table having two fkey, the col is not present on refereed table
												String select_col_from_table_with_two_fkey_not_in_class_name="select "+c1+" from "+tab_with_two_fkey[0]+" where "+col_name_of_table_with_two_keys+"='"+instance_value[k3]+"'";
												ResultSet rs19=st2.executeQuery(select_col_from_table_with_two_fkey_not_in_class_name);
												rs19.next();
												textArea_1.append("\n<temp_ontology:"+obj_prop_with_two_fkey[ii7]+" rdf:resource=\"&temp_ontology;"+rs19.getString(1)+"\"/>");
											}	
										}
										
									}
								}
								//<-------start from here------1:02pm, 29/1/2016....frida	
							}
							else
							{
								//select primary key of table before dash because it is not havving foreign key....for example: Product-Supplier - 
								//here product is having foreign key but in Supplier-product- Supplier is not having foriegn key so select primary key and
								// take foriegn key of table after dash.
								String pk,fk,val1="";
								String select_pkey_of_table_before_dash="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE OBJECTPROPERTY(OBJECT_ID(CONSTRAINT_SCHEMA+'.'+CONSTRAINT_NAME), 'IsPrimaryKey') = 1 AND TABLE_NAME = '"+class_before_dash+"'";
								ResultSet rs12=st2.executeQuery(select_pkey_of_table_before_dash);
								rs12.next();
								pk=rs12.getString(1);
								String select_fkey_of_table_after_dash="SELECT c.NAME 'Parent column name' FROM sys.foreign_key_columns fkc INNER JOIN sys.columns c ON fkc.parent_column_id = c.column_id AND fkc.parent_object_id = c.object_id INNER JOIN sys.columns cref ON fkc.referenced_column_id = cref.column_id AND fkc.referenced_object_id = cref.object_id where OBJECT_NAME(parent_object_id) = '"+class_after_dash+"'";
								ResultSet rs13=st2.executeQuery(select_fkey_of_table_after_dash);
								rs13.next();
								fk=rs13.getString(1);
								String select_for_comp="select "+fk+" from "+class_after_dash;
								ResultSet rs15=st2.executeQuery(select_for_comp);
								int flag=0;
								while(rs15.next())
								{
									if(instance_value[k3].equals(rs15.getString(1)))
									{
										flag=1;
									}
								}
								//select primary key value of table after dash, that is table having foreign key
								//String select_pk_value_of_table_after_dash_equalto_table_before_dash="select "+class_after_dash+"."+primary_key+" from "+class_after_dash+","+class_before_dash+" where "+class_after_dash+"."+fk+"='"+instance_value[k3]+"'";    /////class_before_dash+"."+pk;
								//System.out.println();
								if(flag==1)
								{
								String select_pk_value_of_table_after_dash_equalto_table_before_dash="select "+primary_key+" from "+class_after_dash+" where "+fk+"='"+instance_value[k3]+"'";
								ResultSet rs14=st2.executeQuery(select_pk_value_of_table_after_dash_equalto_table_before_dash);
								rs14.next();                    //stopped at 3:00 am, 29/1/2016, friday
								val1=rs14.getString(1);
								textArea_1.append("\n<temp_ontology:"+objprop[k6]+" rdf:resource=\"&temp_ontology;"+val1+"\"/>");
								}
							}
						}
						}
						
						//<<<<<----------------------start from here , stopped at 12:49am, 28/1/2016------->>>>>>	
						textArea_1.append("\n</owl:NamedIndividual>");		
						}
					}
					textArea_1.append("\n</rdf:RDF>");
				}
				catch (SQLException e1)
				{
                    System.err.println("SQL EXCEPTION");
				}
				
				catch (ClassNotFoundException e2)
				{
                    System.err.println("Could not load JDBC driver");
				} 		
				//comboBox_3.setVisible(false);
				btnLoadInstances.setVisible(false);
			}
		});
		
		btnLoadDataProperty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String table_names[]=new String[20];
				
				try{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=SCHEMA;user=sa;password=9838929487");
					Statement st = con.createStatement();
					String select_all_table_names="SELECT TABLE_NAME FROM KEYS";
					ResultSet rs= st.executeQuery(select_all_table_names);
					int i=0;
					while(rs.next())
					{
						table_names[i]=rs.getString(1);
						i=i+1;
					}
					table_names = Arrays.stream(table_names)
			                .filter(s -> (s != null && s.length() > 0))
			                .toArray(String[]::new);
					/*for(int j=0;j<table_names.length;j++)
					{
						System.out.println(table_names[j]);
							
					}*/
					Connection con2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName="+comboBox.getSelectedItem().toString()+";user=sa;password=9838929487");
					Statement st2 = con2.createStatement();
					//System.out.println(table_names.length);
					for(int k=0;k<table_names.length;k++)
					{
						//System.out.println(table_names.length);
						String col_names[]=new String[20];
						String foreign_keys[]=new String[20];
						String columns="SELECT COLUMN_NAME FROM "+comboBox.getSelectedItem().toString()+".INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '"+table_names[k]+"'";
						ResultSet rs2= st2.executeQuery(columns);
						int i2=0;
						//System.out.println(table_names[k]+"----------------");
						while(rs2.next())
						{
							//System.out.println(rs2.getString(1));
							col_names[i2]=rs2.getString(1);
							i2=i2+1;
						}
						//System.out.println("-----------------");
						col_names = Arrays.stream(col_names)
				                .filter(s -> (s != null && s.length() > 0))
				                .toArray(String[]::new);
						String fkey="SELECT c.NAME 'Parent column name' FROM sys.foreign_key_columns fkc INNER JOIN sys.columns c ON fkc.parent_column_id = c.column_id AND fkc.parent_object_id = c.object_id INNER JOIN sys.columns cref ON fkc.referenced_column_id = cref.column_id AND fkc.referenced_object_id = cref.object_id where OBJECT_NAME(parent_object_id) = '"+table_names[k]+"'";
						ResultSet rs3= st2.executeQuery(fkey);
						int i3=0;
						while(rs3.next())
						{
							//System.out.println(table_names[k]+"----"+rs3.getString(1));
							foreign_keys[i3]=rs3.getString(1);
							i3=i3+1;
						}
						foreign_keys = Arrays.stream(foreign_keys)
				                .filter(s -> (s != null && s.length() > 0))
				                .toArray(String[]::new);
						
						for(int k1=0;k1<foreign_keys.length;k1++)
						{
							for(int k2=0;k2<col_names.length;k2++)
							{
								//System.out.println(table_names[k]+"--------"+foreign_keys[k2]+"-------"+col_names[k1]);
								if(foreign_keys[k1].equalsIgnoreCase(col_names[k2]))
								{
									//System.out.println(col_names[k2]);
									col_names[k2]=null;							
								}		
							}
						}
						col_names = Arrays.stream(col_names)
				                .filter(s -> (s != null && s.length() > 0))
				                .toArray(String[]::new);	
						
							if(col_names.length==0)
							{
								//System.out.println("hello::::::"+table_names[k]);
								table_names[k]=null;
							}
							
							table_names = Arrays.stream(table_names)
							                .filter(s -> (s != null && s.length() > 0))
							                .toArray(String[]::new);
							
						//	System.out.println(table_names[k]+"--------------");
						/*	for(int kk=0;kk<col_names.length;kk++)
						{
							
							System.out.println(col_names[kk]);
						}*/
							//System.out.println(table_names[k]);
							
							if(table_names[k].equalsIgnoreCase(lblparentclass.getText())==true)
							{
								//System.out.println(table_names[k]);
								//stopped: 5:24 am, 26-12-2015; started :25-12-2015, 10:30 pm--------------start here----6:57 pm, 26-12-2015>>>>>
									String sub_class_col[]=new String[20];
									String parent_class_col[]=new String[20];
									String fkeyparent[]=new String[20];
									//Statement st4 = con2.createStatement();
									String col_sub_class="SELECT COLUMN_NAME FROM "+comboBox.getSelectedItem().toString()+".INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '"+lblsubclass.getText()+"'";
									String col_parentclass="SELECT COLUMN_NAME FROM "+comboBox.getSelectedItem().toString()+".INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '"+lblparentclass.getText()+"'";
									//System.out.println(col_sub_class);
									//System.out.println(col_parentclass);	
									ResultSet rs4=st2.executeQuery(col_sub_class);
									int i4=0;
									while(rs4.next())
									{
										//System.out.println("hello");
										//System.out.println(rs4.getString(1));
										sub_class_col[i4]=rs4.getString(1);
										i4=i4+1;
									}
									sub_class_col = Arrays.stream(sub_class_col)
							                .filter(s -> (s != null && s.length() > 0))
							                .toArray(String[]::new);
									ResultSet rs6=st2.executeQuery(col_parentclass);
									int i10=0;
									while(rs6.next())
									{
										//System.out.println(rs4.getString(1));
										parent_class_col[i10]=rs6.getString(1);
										i10=i10+1;
									}
									parent_class_col = Arrays.stream(parent_class_col)
							                .filter(s -> (s != null && s.length() > 0))
							                .toArray(String[]::new);
									// foreign key of parent class
									String fkey_parent="SELECT c.NAME 'Parent column name' FROM sys.foreign_key_columns fkc INNER JOIN sys.columns c ON fkc.parent_column_id = c.column_id AND fkc.parent_object_id = c.object_id INNER JOIN sys.columns cref ON fkc.referenced_column_id = cref.column_id AND fkc.referenced_object_id = cref.object_id where OBJECT_NAME(parent_object_id) = '"+lblparentclass.getText()+"'";
									ResultSet rs7=st2.executeQuery(fkey_parent);
									int i11=0;
									while(rs7.next())
									{
										//System.out.println(rs.getString(1));
										fkeyparent[i11]=rs7.getString(1);
									}
									fkeyparent = Arrays.stream(fkeyparent)
							                .filter(s -> (s != null && s.length() > 0))
							                .toArray(String[]::new);
									for(int i12=0;i12<fkeyparent.length;i12++)
									{
										for(int i13=0;i13<parent_class_col.length;i13++)
										{
											if(parent_class_col[i13].equalsIgnoreCase(fkeyparent[i12]))
											{
												parent_class_col[i13]=null;
												parent_class_col = Arrays.stream(parent_class_col)
										                .filter(s -> (s != null && s.length() > 0))
										                .toArray(String[]::new);
											}
										}
									}
									
									String check2[]=new String[20];
									String same_col=null;
									//System.out.println(col_names[0]);
									//System.out.println(col_names[1]);
									for(int i5=0;i5<parent_class_col.length;i5++)
									{
										//System.out.println("hello");
										for(int i6=0;i6<sub_class_col.length;i6++)
										{	
											//System.out.println(sub_class_col[i5]);
											//System.out.println(col_names[i6]);
											if(parent_class_col[i5].equalsIgnoreCase(sub_class_col[i6]))
											{
												//same_col=sub_class_col[i6];
												//System.out.println(same_col);
												String get_value_commoncol="select "+sub_class_col[i6]+" from "+lblsubclass.getText()+" as a where exists (select "+parent_class_col[i5]+" from "+lblparentclass.getText()+" as b where b."+parent_class_col[i5]+"=a."+sub_class_col[i6]+")";
												ResultSet rs5=st2.executeQuery(get_value_commoncol);
												int i7=0;
												while(rs5.next())
												{
													
													check2[i7]=rs5.getString(1);
													i7=i7+1;
													same_col=sub_class_col[i6];
													//System.out.println(same_col);
												}
											}
											
										}
									}
									check2 = Arrays.stream(check2)
							                .filter(s -> (s != null && s.length() > 0))
							                .toArray(String[]::new);
									if(check2.length!=0)
									{
										comboBox_2.addItem(lblparentclass.getText()+"."+same_col);
										//data_property[k]=lblparentclass.getText()+"."+same_col;
										//System.out.println(data_property[k]);
										textArea_1.append("\n<owl:DatatypeProperty rdf:about=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+lblparentclass.getText()+"."+same_col+"\">");
										textArea_1.append("\n<rdfs:domain rdf:resource=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+lblparentclass.getText()+"\"/>");
										textArea_1.append("\n<owl:equivalentProperty rdf:resource=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+lblsubclass.getText()+"."+same_col+"\"/>");
										textArea_1.append("\n<rdfs:range rdf:resource=\"&xsd;string\"/>");
										textArea_1.append("\n</owl:DatatypeProperty>");
									}
									else
									{
										
									}
									for(int i8=0;i8<parent_class_col.length;i8++)
									{
										if(parent_class_col[i8].equalsIgnoreCase(same_col))
										{
											//System.out.println(parent_class_col[i8]);
											parent_class_col[i8]=null;
										}
									}
									parent_class_col = Arrays.stream(parent_class_col)
							                .filter(s -> (s != null && s.length() > 0))
							                .toArray(String[]::new);
									//System.out.println(parent_class_col.length);
									for(int i9=0;i9<parent_class_col.length;i9++)
									{
										
										comboBox_2.addItem(table_names[k]+"."+parent_class_col[i9]);
										//System.out.println(parent_class_col[i9]);
										//data_property[k]=table_names[k]+"."+parent_class_col[i9];
										//System.out.println(data_property[k]);
										textArea_1.append("\n<owl:DatatypeProperty rdf:about=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+table_names[k]+"."+parent_class_col[i9]+"\">");
										textArea_1.append("\n<rdfs:domain rdf:resource=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+table_names[k]+"\"/>");
										textArea_1.append("\n<rdfs:range rdf:resource=\"&xsd;string\"/>");
										textArea_1.append("\n</owl:DatatypeProperty>");
									}
							}
							
							
							if(table_names[k].equalsIgnoreCase(null)==false && col_names.length!=0 && table_names[k].equalsIgnoreCase(lblparentclass.getText())==false) 
							{
									//System.out.println(table_names[k]);
								for(int k5=0;k5<col_names.length;k5++)
								{
									comboBox_2.addItem(table_names[k]+"."+col_names[k5]);
									//data_property[k]=table_names[k]+"."+col_names[k5];
									//System.out.println(data_property[k]);
									textArea_1.append("\n<owl:DatatypeProperty rdf:about=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+table_names[k]+"."+col_names[k5]+"\">");
									textArea_1.append("\n<rdfs:domain rdf:resource=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+table_names[k]+"\"/>");
									textArea_1.append("\n<rdfs:range rdf:resource=\"&xsd;string\"/>");
									textArea_1.append("\n</owl:DatatypeProperty>");
								}
							}
					}
					//table_names = Arrays.stream(table_names)
			          //      .filter(s -> (s != null && s.length() > 0))
			            //    .toArray(String[]::new);
						/*for(int k4=0;k4<table_names.length;k4++)
						{
							System.out.println(table_names[k4]);
						}*/
					}
					catch (SQLException e1)
					{
			            System.err.println("SQL EXCEPTION");
					}
					
					catch (ClassNotFoundException e2)
					{
			            System.err.println("Could not load JDBC driver");
					}				
				btnLoadDataProperty.setVisible(false);
				btnLoadObjectProperty.setVisible(true);
			}
		});	
		btnLoadObjectProperty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// codes for object property
				String tab_name[]=new String [20];
				try{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName="+comboBox.getSelectedItem().toString()+";user=sa;password=9838929487");
					Statement st = con.createStatement();
					String select_table_names="select * from sys.Tables";
					ResultSet rs= st.executeQuery(select_table_names);
					int i=0;
					while(rs.next())
					{
						tab_name[i]=rs.getString(1); //storing table names in array tab_name[]
						i=i+1;
					}
					tab_name = Arrays.stream(tab_name)
					              .filter(s -> (s != null && s.length() > 0))
					               .toArray(String[]::new);
					textArea_1.append("\n<!--////Object property////-->");
					for(int j=0;j<tab_name.length;j++)
					{
						String select_no_of_foreign_key="SELECT c.NAME 'Parent column name' FROM sys.foreign_key_columns fkc INNER JOIN sys.columns c ON fkc.parent_column_id = c.column_id AND fkc.parent_object_id = c.object_id INNER JOIN sys.columns cref ON fkc.referenced_column_id = cref.column_id AND fkc.referenced_object_id = cref.object_id where OBJECT_NAME(parent_object_id) = '"+tab_name[j]+"'";
						ResultSet rs2 = st.executeQuery(select_no_of_foreign_key);
						int j2=0;
						while(rs2.next())
						{
							j2=j2+1;  //counting number of foreign key in one table
						}
						if(j2==1)
						{
							String fkey=null;
							ResultSet rs3 = st.executeQuery(select_no_of_foreign_key);
							int j3=0;
							while(rs3.next())
							{
								fkey=rs3.getString(1);
								j3=j3+1;
							}
							String refered_table, refered_column;
							String find_ref_tab_col="SELECT OBJECT_NAME(f.parent_object_id) AS TableName, COL_NAME(fc.parent_object_id, fc.parent_column_id) AS ColumnName, OBJECT_NAME (f.referenced_object_id) AS ReferenceTableName, COL_NAME(fc.referenced_object_id, fc.referenced_column_id) AS ReferenceColumnName FROM sys.foreign_keys AS f INNER JOIN sys.foreign_key_columns AS fc ON f.OBJECT_ID = fc.constraint_object_id";
							ResultSet rs4=st.executeQuery(find_ref_tab_col);
							int j4=0;
							while(rs4.next())
							{
								String tab=rs4.getString(1);
								String col=rs4.getString(2);
								if(tab.equals(tab_name[j]) && col.equals(fkey))
								{
									refered_table=rs4.getString(3);
									refered_column=rs4.getString(4);
									comboBox_3.addItem(tab_name[j]+"-"+refered_table);
									textArea_1.append("\n<owl:ObjectProperty rdf:about=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+tab_name[j]+"-"+refered_table+"\">");
									textArea_1.append("\n<rdfs:domain rdf:resource=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+tab_name[j]+"\"/>");
									textArea_1.append("\n<rdfs:range rdf:resource=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+refered_table+"\"/>");
									textArea_1.append("\n</owl:ObjectProperty>");
									comboBox_3.addItem(refered_table+"-"+tab_name[j]);
									textArea_1.append("\n<owl:ObjectProperty rdf:about=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+refered_table+"-"+tab_name[j]+"\">");
									textArea_1.append("\n<rdfs:domain rdf:resource=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+refered_table+"\"/>");
									textArea_1.append("\n<rdfs:range rdf:resource=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+tab_name[j]+"\"/>");
									textArea_1.append("\n<owl:inverseOf rdf:resource=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+tab_name[j]+"-"+refered_table+"\"/>");
									textArea_1.append("\n</owl:ObjectProperty>");
									//System.out.println("<owl:ObjectProperty rdf:ID="+tab_name[j]+"--->"+refered_table);
								}
								j4=j4+1;
							}
							
						}
						if(j2==2)
						{
							String fkey2[]=new String[20];
							ResultSet rs5 = st.executeQuery(select_no_of_foreign_key);
							int j5=0;
							while(rs5.next())
							{
								fkey2[j5]=rs5.getString(1);
								j5=j5+1;
							}
							fkey2 = Arrays.stream(fkey2)
						              .filter(s -> (s != null && s.length() > 0))
						               .toArray(String[]::new);
							String ref_table[]=new String[20];
							for(int j6=0;j6<fkey2.length;j6++)
							{
								String find_ref_tab_col="SELECT OBJECT_NAME(f.parent_object_id) AS TableName, COL_NAME(fc.parent_object_id, fc.parent_column_id) AS ColumnName, OBJECT_NAME (f.referenced_object_id) AS ReferenceTableName, COL_NAME(fc.referenced_object_id, fc.referenced_column_id) AS ReferenceColumnName FROM sys.foreign_keys AS f INNER JOIN sys.foreign_key_columns AS fc ON f.OBJECT_ID = fc.constraint_object_id";
								ResultSet rs6=st.executeQuery(find_ref_tab_col);
								int j7=0;
								while(rs6.next())
								{
									String col=rs6.getString(2);
									if(col.equals(fkey2[j6]))
									{
										ref_table[j6]=rs6.getString(3);
									}
									j7=j7+1;
								}
							}
							ref_table = Arrays.stream(ref_table)
						              .filter(s -> (s != null && s.length() > 0))
						               .toArray(String[]::new);
							for(int j8=0;j8<fkey2.length-1;j8++)
							{
								//System.out.println("hello"+ref_table[j8]);
								//System.out.println("hello"+tab_name[j]);
								//comboBox_3.addItem(ref_table[j8]+"-"+ref_table[j8+1]);
								comboBox_3.addItem(tab_name[j]+"-"+ref_table[j8+1]);
								//textArea_1.append("\n<owl:ObjectProperty rdf:about=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+ref_table[j8]+"-"+ref_table[j8+1]+"\">");
								textArea_1.append("\n<owl:ObjectProperty rdf:about=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+tab_name[j]+"-"+ref_table[j8+1]+"\">");
								textArea_1.append("\n<rdfs:domain rdf:resource=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+ref_table[j8]+"\"/>");
								textArea_1.append("\n<rdfs:range rdf:resource=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+ref_table[j8+1]+"\"/>");
								textArea_1.append("\n</owl:ObjectProperty>");
								//comboBox_3.addItem(ref_table[j8+1]+"-"+ref_table[j8]);
								comboBox_3.addItem(ref_table[j8+1]+"-"+tab_name[j]);
								//textArea_1.append("\n<owl:ObjectProperty rdf:about=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+ref_table[j8+1]+"-"+ref_table[j8]+"\">");
								textArea_1.append("\n<owl:ObjectProperty rdf:about=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+ref_table[j8+1]+"-"+tab_name[j]+"\">");
								textArea_1.append("\n<rdfs:domain rdf:resource=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+ref_table[j8+1]+"\"/>");
								textArea_1.append("\n<rdfs:range rdf:resource=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+ref_table[j8]+"\"/>");
								textArea_1.append("\n<owl:inverseOf rdf:resource=\"https://wiki.csc.calpoly.edu/OntologyTutorial/temp_ontology.owl#"+ref_table[j8]+"-"+ref_table[j8+1]+"\"/>");
								textArea_1.append("\n</owl:ObjectProperty>");
								//System.out.println(tab_name[j]+"------"+fkey2[j8]+"------"+ref_table[j8]);
							}
						}
					}
					//textArea_1.append("\n</rdf:RDF>");
				}
				catch (SQLException e1)
				{
		            System.err.println("SQL EXCEPTION");
				}
				
				catch (ClassNotFoundException e2)
				{
		            System.err.println("Could not load JDBC driver");
				}			
				btnLoadObjectProperty.setVisible(false);
				btnLoadInstances.setVisible(true);
			}
		});
		
		
		
	}
}
