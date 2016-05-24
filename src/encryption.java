import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.List;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.ListModel;

import java.awt.Checkbox;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class encryption {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JPasswordField passwordField_3;
	private JTextField textField_1;
	private JPasswordField passwordField_4;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void encryp() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					encryption window = new encryption();
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
	public encryption() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 835, 492);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel welcome = new JPanel();
		frame.getContentPane().add(welcome, "name_35487344831819");
		welcome.setLayout(null);
		
		JPanel change_password = new JPanel();
		frame.getContentPane().add(change_password, "name_35490905233419");
		change_password.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, "name_12105335557570");
		
		JComboBox comboBox_1 = new JComboBox();
		
		JComboBox comboBox = new JComboBox();
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(94, 97, 107, 20);
		
		JButton btnNext_3 = new JButton("NEXT");
		
		JButton btnLoadTable = new JButton("LOAD TABLE");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					if(comboBox.getItemCount()>0)
					{
						int itemCount = comboBox_3.getItemCount();
					    for(int i=0;i<itemCount;i++){
					        comboBox_3.removeItemAt(0);
					     }
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=ADMIN;user=sa;password=9838929487");
						Statement st = con.createStatement();
						String select_encrypted_table="select distinct tb from already_encrypted_col where db='"+comboBox.getSelectedItem().toString()+"'";
						ResultSet rs=st.executeQuery(select_encrypted_table);
						while(rs.next())
						{
							comboBox_3.addItem(rs.getString(1));
						}
						/*List<object> list = new List<object>();
						foreach (object o in comboBox_3.Items)
						    {
						    if (!list.Contains(o))
						        {
						        list.Add(o);
						        }
						    }
						comboBox_3.Items.Clear();
						comboBox_3.Items.AddRange(list.ToArray());*/
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Select Database");
					}
				
				}
				catch(SQLException e1){
					JOptionPane.showMessageDialog(null, "SQL Error");
				}
				catch (ClassNotFoundException e2)
				{
					JOptionPane.showMessageDialog(null, "SQL Connection Error");
				}
				
			}
		});
		btnLoadTable.setBounds(10, 68, 129, 19);
		
		
		JPanel Encrytp_col = new JPanel();
		tabbedPane.addTab("Encrypt Column", null, Encrytp_col, null);
		Encrytp_col.setLayout(null);
		comboBox_1.setBounds(94, 61, 107, 20);
		Encrytp_col.add(comboBox_1);
		
		
		JLabel lblDatabase_1 = new JLabel("DATABASE");
		lblDatabase_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDatabase_1.setBounds(10, 62, 74, 14);
		Encrytp_col.add(lblDatabase_1);
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(269, 224, 520, 163);
		Encrytp_col.add(scrollPane_2);
		
		JTextArea textArea = new JTextArea();
		scrollPane_2.setViewportView(textArea);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}
		});
		comboBox_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {	
			}	
		});
		comboBox_2.setBounds(94, 92, 107, 20);
		Encrytp_col.add(comboBox_2);
		
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					int itemCount = comboBox_2.getItemCount();

				    for(int i=0;i<itemCount;i++){
				        comboBox_2.removeItemAt(0);
				     }
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName="+comboBox_1.getSelectedItem().toString()+";user=sa;password=9838929487");
					Statement st = con.createStatement();
					String select_tables="select * from sys.Tables";
					ResultSet rs=st.executeQuery(select_tables);
					while(rs.next())
					{
						comboBox_2.addItem(rs.getString(1));
					}
					
				}
				catch(SQLException e1){
					JOptionPane.showMessageDialog(null, "SQL Error");
				}
				catch (ClassNotFoundException e2)
				{
					JOptionPane.showMessageDialog(null, "SQL Connection Error");
				}
				
				
				
			}
		});
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(null);
			}
			
		});
		
		
		JLabel lblTable_1 = new JLabel("TABLE");
		lblTable_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTable_1.setBounds(10, 93, 74, 14);
		Encrytp_col.add(lblTable_1);
		
		JLabel lblSelectTheColumns = new JLabel("Select The Columns To Encrypt");
		lblSelectTheColumns.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectTheColumns.setBounds(269, 31, 323, 20);
		Encrytp_col.add(lblSelectTheColumns);
		
		JLabel lblAlreadyEncryptedColumns = new JLabel("Already Encrypted Columns:");
		lblAlreadyEncryptedColumns.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlreadyEncryptedColumns.setBounds(269, 193, 323, 20);
		Encrytp_col.add(lblAlreadyEncryptedColumns);
			
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPasswordField key = new JPasswordField(10);
				JOptionPane.showConfirmDialog(null, key,"Enter Encryption Key",JOptionPane.OK_CANCEL_OPTION); 
				String entered_key=key.getText();
				try
				{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=ADMIN;user=sa;password=9838929487");
					Statement st = con.createStatement();
					String select_username_key="select [key] from keys where username='"+textField.getText().toString()+"'";
					ResultSet rs=st.executeQuery(select_username_key);
						while(rs.next())
						{
							if(rs.getString(1).equals(entered_key))
							{
								// add code to encrypt
								String arr_col_to_encrypt[]=new String[40];
								for(int i2=0;i2<table.getRowCount();i2++)
								{
									Boolean checked=Boolean.valueOf(table.getValueAt(i2,1).toString());
									if(checked)
									{
										arr_col_to_encrypt[i2]=table.getValueAt(i2,0).toString();
									}
								}
								arr_col_to_encrypt = Arrays.stream(arr_col_to_encrypt)
					                     .filter(s -> (s != null && s.length() > 0))
					                     .toArray(String[]::new);
								String arr_pkey[]=new String[2];
								Connection con2=DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName="+comboBox_1.getSelectedItem().toString()+";user=sa;password=9838929487");
								Statement st2=con2.createStatement();
								String select_pkey="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE OBJECTPROPERTY(OBJECT_ID(CONSTRAINT_SCHEMA+'.'+CONSTRAINT_NAME), 'IsPrimaryKey') = 1 AND TABLE_NAME = '"+comboBox_2.getSelectedItem().toString()+"'";
								ResultSet rs3=st2.executeQuery(select_pkey);
								int i=0;
								while(rs3.next())
								{
									arr_pkey[i]=rs3.getString(1);
								}
								arr_pkey = Arrays.stream(arr_pkey)
					                     .filter(s -> (s != null && s.length() > 0))
					                     .toArray(String[]::new);
								AES ob=new AES();
								for(int i3=0;i3<arr_col_to_encrypt.length;i3++)
								{
									String col=arr_col_to_encrypt[i3];
									String arr_val[]=new String[200];
									String arr_encrytp_value[]=new String[200];
									String select_col_values_to_encrypt="select "+arr_pkey[0]+","+arr_col_to_encrypt[i3]+" from "+comboBox_2.getSelectedItem().toString();
									ResultSet rs2=st2.executeQuery(select_col_values_to_encrypt);
									int i4=0,i5=0;
									while(rs2.next())
									{
										ob.setKey(entered_key);
										ob.encrypt(rs2.getString(2).trim());
										arr_val[i4]=rs2.getString(1);
										i4++;
										arr_encrytp_value[i5]=ob.getEncryptedString();
										i5++;
										//String update_encrypted_value="WITH CTE AS(SELECT *,ROW_NUMBER() OVER (ORDER BY (select 100)) AS RowNumber FROM "+comboBox_2.getSelectedItem().toString()+") UPDATE CTE Set "+arr_col_to_encrypt[i3]+"='"+ob.getEncryptedString()+"' WHERE RowNumber ="+i4;
										//st2.execute(update_encrypted_value);
									}
									arr_val = Arrays.stream(arr_val)
						                     .filter(s -> (s != null && s.length() > 0))
						                     .toArray(String[]::new);
									arr_encrytp_value = Arrays.stream(arr_encrytp_value)
						                     .filter(s -> (s != null && s.length() > 0))
						                     .toArray(String[]::new);
									// below code to update encrypted value
									int flag=0;
									for(int i6=0;i6<arr_encrytp_value.length;i6++)
									{
									String update="update "+comboBox_2.getSelectedItem().toString()+" set "+col+"='"+arr_encrytp_value[i6]+"' where "+arr_pkey[0]+"='"+arr_val[i6]+"'";
									st2.execute(update);
									flag++;
									}
									// below code to add encrypted column in already_encrypted_col table
									if(flag==(arr_encrytp_value.length))
									{
										Connection con3=DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=ADMIN;user=sa;password=9838929487");
										Statement st3=con3.createStatement();
										String update_already_encrypted_col="insert into already_encrypted_col values('"+comboBox_1.getSelectedItem().toString()+"','"+comboBox_2.getSelectedItem().toString()+"','"+col+"')";
										st3.execute(update_already_encrypted_col);
										btnNext.setVisible(false);
										JOptionPane.showMessageDialog(null, "Encryption Successful");
										if(comboBox.getItemCount()>0)
										{
											btnLoadTable.setVisible(true);
										}
										else
										{
											btnLoadTable.setVisible(false);
										}
									}
								}
								
							}
							else
							{
								JOptionPane.showMessageDialog(null, "wrong key");
							}
						}
						
				}
				catch(SQLException e1){
					JOptionPane.showMessageDialog(null, "SQL Error");
				}
				catch (ClassNotFoundException e2)
				{
					JOptionPane.showMessageDialog(null, "SQL Connection Error");
				}	
			}
		});
		btnNext.setBounds(700, 398, 89, 23);
		Encrytp_col.add(btnNext);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(279, 62, 494, 126);
		Encrytp_col.add(scrollPane_3);
		
		table = new JTable();
		scrollPane_3.setViewportView(table);
		
		JButton btnNext_1 = new JButton("NEXT");
		btnNext_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=ADMIN;user=sa;password=9838929487");
					Statement st = con.createStatement();
					// code to display already encrypted column from table already_encrypted_col in admin database
					String select_already_encryp_col="select * from already_encrypted_col where db = '"+comboBox_1.getSelectedItem().toString()+"' and tb= '"+comboBox_2.getSelectedItem().toString()+"'";
					ResultSet rs=st.executeQuery(select_already_encryp_col);
					String arr_already_encrypted_col[]=new String[20];
					int i5=0;
					while(rs.next())
					{
						arr_already_encrypted_col[i5]=rs.getString(3);
						String abc=textArea.getText().toString().toLowerCase();
						if(!abc.contains(rs.getString(3).toLowerCase()))
						{
							textArea.append(rs.getString(3));
							textArea.append("\n");
						}
						i5++;
					}
					arr_already_encrypted_col = Arrays.stream(arr_already_encrypted_col)
		                     .filter(s -> (s != null && s.length() > 0))
		                     .toArray(String[]::new);
					// code to diplay tables to encrypt
					Connection con2=DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName="+comboBox_1.getSelectedItem().toString()+";user=sa;password=9838929487");
					Statement st2=con2.createStatement();
					String select_primary_key="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE OBJECTPROPERTY(OBJECT_ID(CONSTRAINT_SCHEMA+'.'+CONSTRAINT_NAME), 'IsPrimaryKey') = 1 AND TABLE_NAME = '"+comboBox_2.getSelectedItem().toString()+"'";
					String arr_pkey[]=new String[2];
					ResultSet rs2=st2.executeQuery(select_primary_key);
					while(rs2.next())
					{
						arr_pkey[0]=rs2.getString(1);
					}
					arr_pkey = Arrays.stream(arr_pkey)
		                     .filter(s -> (s != null && s.length() > 0))
		                     .toArray(String[]::new);
					String select_fkey="SELECT c.NAME 'Parent column name' FROM sys.foreign_key_columns fkc INNER JOIN sys.columns c ON fkc.parent_column_id = c.column_id AND fkc.parent_object_id = c.object_id INNER JOIN sys.columns cref ON fkc.referenced_column_id = cref.column_id AND fkc.referenced_object_id = cref.object_id  where OBJECT_NAME(parent_object_id) = '"+comboBox_2.getSelectedItem().toString()+"'";
					String arr_fkey[]=new String[2];
					ResultSet rs4=st2.executeQuery(select_fkey);
					while(rs4.next())
					{
						arr_fkey[0]=rs4.getString(1);
					}
					arr_fkey = Arrays.stream(arr_fkey)
		                     .filter(s -> (s != null && s.length() > 0))
		                     .toArray(String[]::new);
					String select_col="SELECT COLUMN_NAME FROM "+comboBox_1.getSelectedItem().toString()+".INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '"+comboBox_2.getSelectedItem().toString()+"'";
					String arr_col[]=new String[20];
					ResultSet rs3=st2.executeQuery(select_col);
					int i=0;
					while(rs3.next())
					{
						arr_col[i]=rs3.getString(1);
						i++;
					}
					arr_col = Arrays.stream(arr_col)
		                     .filter(s -> (s != null && s.length() > 0))
		                     .toArray(String[]::new);
					//remove primary key and foreign key from arr_col because primary key and foreign key  should not be encrypted
					for(int i2=0;i2<arr_col.length;i2++)
					{
						for(int i3=0;i3<arr_pkey.length;i3++)
						{
							if(arr_col[i2].equals(arr_pkey[i3]))
							{
								arr_col[i2]=null;
							}
						}
							
					}
					arr_col = Arrays.stream(arr_col)
		                     .filter(s -> (s != null && s.length() > 0))
		                     .toArray(String[]::new);
					
					for(int i2=0;i2<arr_col.length;i2++)
					{
						for(int i3=0;i3<arr_fkey.length;i3++)
						{
							if(arr_col[i2].equals(arr_fkey[i3]))
							{
								arr_col[i2]=null;
							}
						}
							
					}
					arr_col = Arrays.stream(arr_col)
		                     .filter(s -> (s != null && s.length() > 0))
		                     .toArray(String[]::new);
					//remove already encrypted columns from arr_col
					for(int i6=0;i6<arr_already_encrypted_col.length;i6++)
					{
						for(int i7=0;i7<arr_col.length;i7++)
						{
							if(arr_already_encrypted_col[i6].equals(arr_col[i7]))
							{
								arr_col[i7]=null;
							}
						}
					}
					arr_col = Arrays.stream(arr_col)
		                     .filter(s -> (s != null && s.length() > 0))
		                     .toArray(String[]::new);
					//this object will pass data into Jtable
					DefaultTableModel dtm=new DefaultTableModel()
					{
						public Class<?> getColumnClass(int column)
						{
							switch(column)
							{
							case 0:
								return String.class;
							case 1:
								return Boolean.class;
								default :
									return String.class;
							}
						}
					};
					dtm.addColumn("Column");
					dtm.addColumn("Select");	
					for(int i4=0;i4<arr_col.length;i4++)
					{
						dtm.addRow(new Object[0]);
						dtm.setValueAt(arr_col[i4], i4, 0);
						dtm.setValueAt(false, i4, 1);
					}
					//pass default table object into table_1
					table.setModel(dtm);
					table.setVisible(true);
					//finished	
					if(dtm.getRowCount()>0)
					{
						btnNext.setVisible(true);
					}
					else
					{
						btnNext.setVisible(false);
					}
				}
				catch(SQLException e1){
					JOptionPane.showMessageDialog(null, "SQL Error");
				}
				catch (ClassNotFoundException e2)
				{
					JOptionPane.showMessageDialog(null, "SQL Connection Error");
				}
				
				
			}
		});
		btnNext_1.setBounds(112, 123, 89, 23);
		Encrytp_col.add(btnNext_1);
		
		JPanel Decrypt_col = new JPanel();
		tabbedPane.addTab("Decrypt Column", null, Decrypt_col, null);
		Decrypt_col.setLayout(null);
		
		JLabel lblDatabase = new JLabel("DATABASE");
		lblDatabase.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDatabase.setBounds(10, 39, 89, 19);
		Decrypt_col.add(lblDatabase);
		
		JLabel label = new JLabel("TABLE");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(10, 98, 74, 14);
		Decrypt_col.add(label);
		
		
		Decrypt_col.add(comboBox_3);
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		comboBox.setBounds(94, 41, 107, 19);
		Decrypt_col.add(comboBox);
		
		JButton btnNext_2 = new JButton("NEXT");
		btnNext_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					DefaultTableModel dtm=new DefaultTableModel()
					{
						public Class<?> getColumnClass(int column)
						{
							switch(column)
							{
							case 0:
								return String.class;
							case 1:
								return Boolean.class;
								default :
									return String.class;
							}
						}
					};
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=ADMIN;user=sa;password=9838929487");
					Statement st = con.createStatement();
					String select_encrypted_table="select col from already_encrypted_col where db='"+comboBox.getSelectedItem().toString()+"' and tb='"+comboBox_3.getSelectedItem().toString()+"'";
					ResultSet rs=st.executeQuery(select_encrypted_table);
					dtm.addColumn("Column");
					dtm.addColumn("Select");	
					int i=0;
					while(rs.next())
					{
							dtm.addRow(new Object[0]);
							dtm.setValueAt(rs.getString(1), i, 0);
							dtm.setValueAt(false, i, 1);
							i++;	
					}
					//pass default table object into table_1
					table_1.setModel(dtm);
					table_1.setVisible(true);
					//finished	
					if(dtm.getRowCount()>0)
					{
						btnNext_3.setVisible(true);
					}
					else
					{
						btnNext_3.setVisible(false);
					}
						
				}
				catch(SQLException e1){
					JOptionPane.showMessageDialog(null, "SQL Error");
				}
				catch (ClassNotFoundException e2)
				{
					JOptionPane.showMessageDialog(null, "SQL Connection Error");
				}
				
				
				
				
			}
		});
		btnNext_2.setBounds(112, 135, 89, 23);
		Decrypt_col.add(btnNext_2);
		
		JLabel lblSelectTheColumns_1 = new JLabel("Select The Columns To Decrypt");
		lblSelectTheColumns_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectTheColumns_1.setBounds(256, 24, 323, 20);
		Decrypt_col.add(lblSelectTheColumns_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(256, 55, 505, 143);
		Decrypt_col.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		btnNext_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPasswordField key = new JPasswordField(10);
				JOptionPane.showConfirmDialog(null, key,"Enter Encryption Key",JOptionPane.OK_CANCEL_OPTION); 
				String entered_key=key.getText();
				try
				{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=ADMIN;user=sa;password=9838929487");
					Statement st = con.createStatement();
					String select_username_key="select [key] from keys where username='"+textField.getText().toString()+"'";
					ResultSet rs=st.executeQuery(select_username_key);
						while(rs.next())
						{
							if(rs.getString(1).equals(entered_key))
							{
								//store selected column in table to variavle
								// started at 2:13 pm, 2/2/2015
								String arr_col_to_decrypt[]=new String[20];
								for(int i2=0;i2<table_1.getRowCount();i2++)
								{
								Boolean checked=Boolean.valueOf(table_1.getValueAt(i2,1).toString());
								if(checked)
								{
								arr_col_to_decrypt[i2]=table_1.getValueAt(i2,0).toString();
								}
								}
								arr_col_to_decrypt = Arrays.stream(arr_col_to_decrypt).filter(s -> (s != null && s.length()>0)).toArray(String[]::new);
								
								// code to decypt
								// connection with database in combobox and table in combobox and select encrypted column value and decrypt it 
								
								//code to select primary key of table whose column is being decrypted.
								Connection con3=DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName="+comboBox.getSelectedItem().toString()+";user=sa;password=9838929487");
								Statement st3 = con3.createStatement();
								String select_pkey="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE OBJECTPROPERTY(OBJECT_ID(CONSTRAINT_SCHEMA+'.'+CONSTRAINT_NAME), 'IsPrimaryKey') = 1 AND TABLE_NAME = '"+comboBox_3.getSelectedItem().toString()+"'";
								ResultSet rs3=st3.executeQuery(select_pkey);
								String pkey[]=new String[20];
								int ii=0;
								while(rs3.next())
								{
									pkey[ii]=rs3.getString(1);
									ii=ii+1;
								}
								pkey = Arrays.stream(pkey)
					                     .filter(s -> (s != null && s.length() > 0))
					                     .toArray(String[]::new);
								
								AES ob2=new AES();
								for(int i3=0;i3<arr_col_to_decrypt.length;i3++)
								{
									Connection con2=DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName="+comboBox.getSelectedItem().toString()+";user=sa;password=9838929487");
									Statement st2 = con2.createStatement();
									String select_encrypted_col_from_main_db="select "+pkey[0]+","+arr_col_to_decrypt[i3]+" from "+comboBox_3.getSelectedItem().toString();
									ResultSet rs2=st2.executeQuery(select_encrypted_col_from_main_db);
									int i=0;
									int i4=0,i5=0;
									String arr_decrytp_value[]=new String[20];
									String arr_val_pkey[]=new String[20];
									while(rs2.next())
									{
										i=i+1;
										ob2.setKey(entered_key);
										ob2.decrypt(rs2.getString(2));
										arr_val_pkey[i4]=rs2.getString(1);
										i4++;
										arr_decrytp_value[i5]=ob2.getDecryptedString();
										i5++;
										//String update_encrypted_value="WITH CTE AS(SELECT *,ROW_NUMBER() OVER (ORDER BY (select 100)) AS RowNumber FROM "+comboBox_2.getSelectedItem().toString()+") UPDATE CTE Set "+arr_col_to_encrypt[i3]+"='"+ob.getEncryptedString()+"' WHERE RowNumber ="+i4;
										//st2.execute(update_encrypted_value);
									}
									arr_val_pkey = Arrays.stream(arr_val_pkey)
						                     .filter(s -> (s != null && s.length() > 0))
						                     .toArray(String[]::new);
									arr_decrytp_value = Arrays.stream(arr_decrytp_value)
						                     .filter(s -> (s != null && s.length() > 0))
						                     .toArray(String[]::new);
									// below code to update decrypted value
									int flag=0;
									for(int i6=0;i6<arr_decrytp_value.length;i6++)
									{
									String update="update "+comboBox_3.getSelectedItem().toString()+" set "+arr_col_to_decrypt[i3]+"='"+arr_decrytp_value[i6]+"' where "+pkey[0]+"='"+arr_val_pkey[i6]+"'";
									st3.executeUpdate(update);
									flag++;
									}
									// below code to remove encrypted column from already_encrypted_col table
									if(flag==(arr_decrytp_value.length))
									{
										Connection con4=DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=ADMIN;user=sa;password=9838929487");
										Statement st4=con4.createStatement();
										// delete row from already encrypted col
										String update_already_encrypted_col="delete from already_encrypted_col where db='"+comboBox.getSelectedItem().toString()+"' and tb='"+comboBox_3.getSelectedItem().toString()+"'";
										st4.execute(update_already_encrypted_col);
										if(comboBox_3.getItemCount()>0)
										{
											btnNext_3.setVisible(true);
										}
										else
										{
											btnNext_3.setVisible(false);
										}
										JOptionPane.showMessageDialog(null, "Decryption Successful");
										String item_to_delete=comboBox_3.getSelectedItem().toString();
										comboBox.removeItem(item_to_delete);
										btnNext_3.setVisible(false);
									}	
										//String update_decrypted_value="WITH CTE AS(SELECT *,ROW_NUMBER() OVER (ORDER BY (select 100)) AS RowNumber FROM "+comboBox_3.getSelectedItem().toString()+") UPDATE CTE Set "+arr_col_to_decrypt[i3]+"='"+ob2.getDecryptedString()+"' WHERE RowNumber ="+i;
										//st2.execute(update_decrypted_value);
									}
								}
							else
							{
								JOptionPane.showMessageDialog(null, "wrong key");
							}
						}
						
				}
				catch(SQLException e1){
					JOptionPane.showMessageDialog(null, "SQL Error");
				}
				catch (ClassNotFoundException e2)
				{
					JOptionPane.showMessageDialog(null, "SQL Connection Error");
				}	
			}
		});
		btnNext_3.setBounds(673, 209, 89, 23);
		Decrypt_col.add(btnNext_3);
		Decrypt_col.add(btnLoadTable);
		
		JButton btnLoadDatabase = new JButton("LOAD DATABASE");
		btnLoadDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					int itemCount = comboBox.getItemCount();
				    for(int i=0;i<itemCount;i++)
				    {
				        comboBox.removeItemAt(0);
				    }
				    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con1=DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=ADMIN;user=sa;password=9838929487");
					Statement st3 = con1.createStatement();
					String count_rows="SELECT COUNT(*) FROM already_encrypted_col";
					ResultSet rs4=st3.executeQuery(count_rows);
					rs4.next();
					int fl=rs4.getInt(1);
					if(fl==0)
					{
						JOptionPane.showMessageDialog(null, "Nothing Encrypted");
					}
					else
					{
						String select_encrypted_db="select distinct db from already_encrypted_col";
						ResultSet rs3=st3.executeQuery(select_encrypted_db);
						int ii=0;
						while(rs3.next())
						{
							comboBox.addItem(rs3.getString(1));
							ii=ii+1;
						}
						btnLoadTable.setVisible(true);	
					}
				}
				catch(SQLException e1){
					JOptionPane.showMessageDialog(null, "SQL Error");
				}
				catch (ClassNotFoundException e2)
				{
					JOptionPane.showMessageDialog(null, "SQL Connection Error");
				}	
				
			}
		});
		btnLoadDatabase.setBounds(10, 9, 145, 19);
		Decrypt_col.add(btnLoadDatabase);
		
		JPanel keys = new JPanel();
		tabbedPane.addTab("Key", null, keys, null);
		keys.setLayout(null);
		
		JLabel lblEnterUsernameAnd = new JLabel("Enter USERNAME and PASSWORD");
		lblEnterUsernameAnd.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterUsernameAnd.setBounds(263, 38, 374, 24);
		keys.add(lblEnterUsernameAnd);
		
		JLabel lblUsername_1 = new JLabel("USERNAME");
		lblUsername_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername_1.setBounds(185, 108, 118, 14);
		keys.add(lblUsername_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(300, 108, 171, 20);
		keys.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPassword_1 = new JLabel("PASSWORD");
		lblPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword_1.setBounds(185, 148, 105, 14);
		keys.add(lblPassword_1);
		
		passwordField_4 = new JPasswordField();
		passwordField_4.setBounds(300, 148, 171, 20);
		keys.add(passwordField_4);
		
		JButton btnShowKey = new JButton("SHOW KEY");
		btnShowKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=ADMIN;user=sa;password=9838929487");
					Statement st = con.createStatement();
					String select_username_pass="select * from username_pass";
					ResultSet rs=st.executeQuery(select_username_pass);
					int flag=0;
					while(rs.next())
					{
						if(rs.getString(1).equals(textField_1.getText()) && rs.getString(2).equals(passwordField_4.getText()))
						{
							flag=1;
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Wrong Username or Password");
						}
					}
					if(flag==1)
					{
						Connection con2=DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=ADMIN;user=sa;password=9838929487");
						Statement st2 = con2.createStatement();
						String select_key="select * from keys";
						ResultSet rs2=st2.executeQuery(select_key);
						while(rs2.next())
						{
							if(rs2.getString(1).equals(textField_1.getText()))
							{
								JOptionPane.showMessageDialog(null, rs2.getString(2));
							}
							else
							{
								JOptionPane.showMessageDialog(null, "No Key Defined");
							}
						}
					}
					}
					
				catch(SQLException e1){
					JOptionPane.showMessageDialog(null, "SQL Error");
				}
				catch (ClassNotFoundException e2)
				{
					JOptionPane.showMessageDialog(null, "SQL Connection Error");
				}
			}
		});
		btnShowKey.setBounds(380, 199, 96, 23);
		keys.add(btnShowKey);
		
		
		JLabel lblWelcomeAdmin = new JLabel("Welcome Admin!!!!");
		lblWelcomeAdmin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWelcomeAdmin.setBounds(306, 48, 194, 28);
		welcome.add(lblWelcomeAdmin);
		
		textField = new JTextField();
		textField.setBounds(405, 144, 156, 20);
		welcome.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(405, 194, 156, 20);
		welcome.add(passwordField);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setBounds(306, 143, 89, 17);
		welcome.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(306, 193, 89, 17);
		welcome.add(lblPassword);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			textArea.setEditable(false);
				try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=ADMIN;user=sa;password=9838929487");
				Statement st = con.createStatement();
				String select_username_pass="select * from username_pass";
				ResultSet rs=st.executeQuery(select_username_pass);
				while(rs.next())
				{
					if(rs.getString(1).equals(textField.getText()) && rs.getString(2).equals(passwordField.getText()))
					{
						welcome.setVisible(false);
						tabbedPane.setVisible(true);
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=UNIVERSITY;user=sa;password=9838929487");
						Statement st2 = conn.createStatement();
						String list_databases="select * from sys.databases WHERE name NOT IN ('master', 'tempdb', 'model', 'msdb','SCHEMA','PASSWORD','check_connection','updated_check_connection','ADMIN')";
						ResultSet rs2 = st2.executeQuery(list_databases);
						while (rs2.next()) {			
							comboBox_1.addItem(rs2.getString(1));
						}
						Connection con1=DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=ADMIN;user=sa;password=9838929487");
						Statement st3 = con1.createStatement();
						String select_encrypted_db="select db from already_encrypted_col";
						ResultSet rs3=st3.executeQuery(select_encrypted_db);
						int i=0;
						while(rs3.next())
						{
							comboBox.addItem(rs3.getString(1));
							i=i+1;
							btnLoadTable.setVisible(true);
						}
						if(i==0)
						{
							JOptionPane.showMessageDialog(null, "No Database and Tables Encrypted");
							btnLoadTable.setVisible(false);
							
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Wrong Username or Password");
					}
				}
				}
			catch(SQLException e1){
				JOptionPane.showMessageDialog(null, "SQL Error");
			}
			catch (ClassNotFoundException e2)
			{
                System.err.println("Could not load JDBC driver");
			}
			}
		});
		btnLogIn.setBounds(487, 241, 74, 23);
		welcome.add(btnLogIn);
		
		JLabel lblChangePassword = new JLabel("Change Password??????");
		lblChangePassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblChangePassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				welcome.setVisible(false);
				change_password.setVisible(true);
			}
		});
		lblChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblChangePassword.setBounds(132, 333, 206, 28);
		welcome.add(lblChangePassword);
		
		
		JLabel lblOldPassword = new JLabel("Old Password");
		lblOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOldPassword.setBounds(147, 89, 127, 22);
		change_password.add(lblOldPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(284, 93, 163, 20);
		change_password.add(passwordField_1);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewPassword.setBounds(147, 149, 127, 22);
		change_password.add(lblNewPassword);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(284, 153, 163, 20);
		change_password.add(passwordField_2);
		
		JLabel lblConfirmNewPassword = new JLabel("Confirm New Password");
		lblConfirmNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConfirmNewPassword.setBounds(80, 201, 194, 22);
		change_password.add(lblConfirmNewPassword);
		
		passwordField_3 = new JPasswordField();
		passwordField_3.setBounds(284, 205, 163, 20);
		change_password.add(passwordField_3);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setBounds(379, 276, 89, 23);
		change_password.add(btnSave);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				change_password.setVisible(false);
				welcome.setVisible(true);
			}
		});
		btnCancel.setBounds(259, 276, 89, 23);
		change_password.add(btnCancel);
	}
}
