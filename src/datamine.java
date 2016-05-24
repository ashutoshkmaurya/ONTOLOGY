import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Label;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.SMOreg;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SparseInstance;
import weka.core.converters.ArffLoader;
import weka.core.converters.ArffLoader.ArffReader;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.core.converters.ConverterUtils.DataSource;

import java.security.KeyStore.Entry.Attribute;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;

import java.io.FileWriter;

public class datamine {

	protected static final boolean Exception = false;
	private JFrame frame;
	private JTextField openfile;
	private JPanel main;
	private JPanel csvup;
	private JPanel algo;
	private JPanel save;
	private JPanel end;
	private JTextField saveloc;
	private JTextField traindata;
	private JTable table_1;
	private JTextField numInsbox;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void Datamin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					datamine window = new datamine();
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
	public datamine() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 756, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		final JPanel main = new JPanel();
		frame.getContentPane().add(main, "name_15152766276271");
		main.setLayout(null);
		main.setVisible(true);
		
		final JPanel csvup = new JPanel();
		frame.getContentPane().add(csvup, "name_15155700914280");
		csvup.setLayout(null);
		csvup.setVisible(false);
		
		final JPanel end = new JPanel();
		frame.getContentPane().add(end, "name_16033139292199");
		end.setLayout(null);
		end.setVisible(false);
		
		final JPanel listtables = new JPanel();
		frame.getContentPane().add(listtables, "name_45156622898340");
		listtables.setLayout(null);
		listtables.setVisible(false);
		
		JPanel displaytable = new JPanel();
		frame.getContentPane().add(displaytable, "name_45180543923118");
		displaytable.setLayout(null);
		displaytable.setVisible(false);
		
		JPanel convert = new JPanel();
		frame.getContentPane().add(convert, "name_45211865587005");
		convert.setLayout(null);
		
		JPanel shownewtable = new JPanel();
		frame.getContentPane().add(shownewtable, "name_33866450775593");
		shownewtable.setLayout(null);
		
		
		JLabel lblArffFileCreated = new JLabel("=>ARFF FILE CREATED !!!");
		lblArffFileCreated.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblArffFileCreated.setBounds(21, 22, 200, 35);
		convert.add(lblArffFileCreated);
		
		JLabel lblNowApply = new JLabel("=> NOW APPLY NAIVEBAYES CLASSIFIER. ");
		lblNowApply.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNowApply.setBounds(21, 68, 423, 35);
		convert.add(lblNowApply);
		
		JLabel lblClickNextTo = new JLabel("CLICK NEXT TO CONVERT TABLE INTO .ARFF FILE");
		lblClickNextTo.setBounds(241, 347, 309, 23);
		displaytable.add(lblClickNextTo);
		
		JLabel lblClickNext = new JLabel("=> CLICK NEXT TO SAVE NEW TABLE");
		lblClickNext.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClickNext.setBounds(21, 203, 268, 23);
		convert.add(lblClickNext);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblNaivebayesClassifierApplied = new JLabel("=>NAIVEBAYES CLASSIFIER APPLIED");
		lblNaivebayesClassifierApplied.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNaivebayesClassifierApplied.setBounds(21, 154, 303, 14);
		convert.add(lblNaivebayesClassifierApplied);
		lblNaivebayesClassifierApplied.setVisible(false);
		
		JButton btnApplyNb = new JButton("APPLY NB");
		btnApplyNb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//code for NB CLASSIFIER, still needs to be written. NB classifier takes arff file only as into, so we have to take created arff file
				//and predict the missing values and again save the predicted attribute(column) in the same arff file.
				String filefolder2="D:/db2csv/";
				String table_name2=comboBox_1.getSelectedItem().toString();
				String prd[]=new String[1000];
				try{
					//code for NB classifier, to predict missing values of one column
					//load training dataset
					DataSource source = new DataSource(filefolder2+""+table_name2+".arff");
					Instances trainDataset = source.getDataSet();	
					//set class index to the last attribute
					trainDataset.setClassIndex(trainDataset.numAttributes()-1);
					//get number of classes
					int numClasses = trainDataset.numClasses();
					//print out class values in the training dataset
					for(int i = 0; i < numClasses; i++){
						//get class string value using the class index
						String classValue = trainDataset.classAttribute().value(i);
						System.out.println("Class Value "+i+" is " + classValue);
					}
					//create and build the classifier
					NaiveBayes nb = new NaiveBayes();
					nb.buildClassifier(trainDataset);
					//load new dataset
					DataSource source1 = new DataSource(filefolder2+""+table_name2+".arff");
					Instances testDataset = source1.getDataSet();	
					//set class index to the last attribute
					testDataset.setClassIndex(testDataset.numAttributes()-1);
					//loop through the new dataset and make predictions
					System.out.println("===================");
					System.out.println("Actual Class, NB Predicted");
					int numIns=testDataset.numInstances();
					numInsbox.setText(Integer.toString(numIns));
					for (int i = 0; i < testDataset.numInstances(); i++) {
						//get class double value for current instance
						double actualClass = testDataset.instance(i).classValue();
						//get class string value using the class index using the class's int value
						String actual = testDataset.classAttribute().value((int) actualClass);
						//get Instance object of current instance
						Instance newInst = testDataset.instance(i);
						//call classifyInstance, which returns a double value for the class
						double predNB = nb.classifyInstance(newInst);
						//use this value to get string value of the predicted class
						String predString = testDataset.classAttribute().value((int) predNB);
						System.out.println(actual+","+predString);
						prd[i]=predString;
						btnApplyNb.setVisible(false);
						lblNaivebayesClassifierApplied.setVisible(true);
					}
				}
				catch(Exception e1)
				{
					System.out.println("error");
				}
					try{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					System.out.println("ok1");
					Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=check_connection;user=sa;password=9838929487");
					System.out.println("ok2");
					Connection conn2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=updated_check_connection;user=sa;password=9838929487");
					System.out.println("ok3");
					Statement sta = conn.createStatement();
					System.out.println("ok4");
					Statement sta2=conn2.createStatement();
					System.out.println("ok5");
					String Sql1="SELECT * INTO updated_check_connection.."+table_name2+"456 FROM check_connection.."+table_name2;
					//String Sql2 ="SELECT * INTO "+table_name2+" FROM "+table_name2;
					System.out.println(Sql1);
					sta.executeUpdate(Sql1);
					ResultSet res = sta2.executeQuery("select * from "+ table_name2+"456");
	                ResultSetMetaData rsmetadata = res.getMetaData();
	                int colunmCount = rsmetadata.getColumnCount();//colunm count is necessay as the tables are dynamic and we need to figure out the numbers of columns
	                System.out.println(colunmCount);
	                String Columnname=rsmetadata.getColumnName(colunmCount);
	                System.out.println(Columnname);	
					System.out.println("ok7");
					//String droplastcol="update table "+table_name2+"456 set "+Columnname+" = ' '";
					String droplastcol="ALTER TABLE "+table_name2+"456 DROP COLUMN "+Columnname;
					sta2.execute(droplastcol);	
					System.out.println(droplastcol);
					}
					catch(SQLException e)
				{
					//System.out.println("sql error");
				}
				catch (ClassNotFoundException e2){
                    System.err.println("Could not load JDBC driver");
				}
					try{
						String r=numInsbox.getText();
						int row = Integer.parseInt(r);
						for(int d=0;d<row;d++){
							System.out.println(prd[d]);
						}
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						System.out.println("ok1");
						Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=check_connection;user=sa;password=9838929487");
						System.out.println("ok2");
						Connection conn2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=updated_check_connection;user=sa;password=9838929487");
						System.out.println("ok3");
						Statement sta = conn.createStatement();
						System.out.println("ok4");
						Statement sta2=conn2.createStatement();
						System.out.println("ok5");
						ResultSet res = sta.executeQuery("select * from "+ table_name2);
		                ResultSetMetaData rsmetadata = res.getMetaData();
		                int colunmCount = rsmetadata.getColumnCount();//colunm count is necessary as the tables are dynamic and we need to figure out the numbers of columns
						String Columnname=rsmetadata.getColumnName(colunmCount);
						System.out.println(Columnname);
						String createtemp="create table temp("+Columnname+" varchar(50))";
						sta2.execute(createtemp);
						System.out.println("temporaray table created");
						for(int k=0;k<row;k++){
							String insert="insert into temp values ('"+prd[k]+"')";
							//System.out.println(insert);
							sta2.execute(insert);
						}
						
						System.out.println("class values entered in temp table");
						String merge="SELECT t1.*,t2."+Columnname+" INTO NewTable3 FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY (SELECT 1)) AS RN FROM "+table_name2+"456) AS t1 INNER JOIN (SELECT *, ROW_NUMBER() OVER(ORDER BY (SELECT 1)) AS RN FROM temp) AS t2 ON t1.rn = t2.rn";
						sta2.execute(merge);
						String dropRN="ALTER TABLE NewTable3 DROP COLUMN RN";
						sta2.execute(dropRN);
						//code to merge temp table with new table table already created
					}
					catch (Exception e) {
						  e.printStackTrace();
					}
					lblClickNext.setVisible(true);
				
			}
		});
		btnApplyNb.setBounds(155, 120, 115, 23);
		convert.add(btnApplyNb);
		
		
		
		JButton btnNext_1 = new JButton("NEXT");
		btnNext_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					//code for loading list of tables in combo box
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
					Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=updated_check_connection;user=sa;password=9838929487");
					Statement sta = conn.createStatement();			
					String Sql ="SELECT * FROM NewTable3";
					System.out.println(Sql);
					System.out.println("hello");
					ResultSet rs= sta.executeQuery(Sql);
					System.out.println("hello2");
					ResultSetMetaData rsmetadata = rs.getMetaData();
					System.out.println("hello3");
					//it stores number of columns
					int columns=rsmetadata.getColumnCount();
					System.out.println("hello4");
					//this object will pass data into Jtable
					DefaultTableModel dtm=new DefaultTableModel();
					Vector columns_name= new Vector();
					Vector data_rows=new Vector();
					
					for(int i=1;i<=columns;i++){
						columns_name.addElement(rsmetadata.getColumnName(i));
					}
					dtm.setColumnIdentifiers(columns_name);
					
					while(rs.next()){
						
						data_rows=new Vector();
						for(int j=1;j<=columns;j++){
							data_rows.addElement(rs.getString(j));
						}
						dtm.addRow(data_rows);
					}
					//pass default table object into table_1
					table_2.setModel(dtm);
					table_2.setVisible(true);
					//finished
					}
					catch(Exception ex){
					System.out.println("error");	
					}
					convert.setVisible(false);
					shownewtable.setVisible(true);
				}		
		});
		btnNext_1.setBounds(376, 285, 89, 23);
		convert.add(btnNext_1);
		
		
		
		numInsbox = new JTextField();
		numInsbox.setBounds(335, 31, 86, 20);
		convert.add(numInsbox);
		numInsbox.setColumns(10);
		convert.setVisible(false);
		
		JButton btnCsv = new JButton("ARFF");
		btnCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csvup.setVisible(true);
				main.setVisible(false);
			}
		});
		btnCsv.setBounds(257, 86, 172, 23);
		main.add(btnCsv);
		
		JButton btnRelationalDatabase = new JButton("RELATIONAL DATABASE");
		btnRelationalDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// create connection to updated_check_connection database and delete all tables....
				try
				{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=updated_check_connection;user=sa;password=9838929487");
					Statement st = con2.createStatement();
					String Sq ="DECLARE @sql nvarchar(max) = ''; SELECT @sql += 'DROP TABLE ' + QUOTENAME([TABLE_SCHEMA]) + '.' + QUOTENAME([TABLE_NAME]) + ';'FROM [INFORMATION_SCHEMA].[TABLES] WHERE [TABLE_TYPE] = 'BASE TABLE';EXEC SP_EXECUTESQL @sql;";
					st.executeUpdate(Sq);
				}
				catch(Exception ex)
				{
					
				}
				
				listtables.setVisible(true);
				main.setVisible(false);
			}
		});
		btnRelationalDatabase.setBounds(257, 280, 172, 23);
		main.add(btnRelationalDatabase);
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOr.setBounds(335, 188, 46, 14);
		main.add(lblOr);
		
		
		Label label = new Label("SELECT ARFF FILE");
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		label.setBounds(17, 94, 153, 22);
		csvup.add(label);
		
		openfile = new JTextField();
		openfile.setBounds(17, 132, 234, 20);
		csvup.add(openfile);
		openfile.setColumns(10);
		
		JButton btnOpen = new JButton("OPEN");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser=new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String filename=f.getAbsolutePath();
				openfile.setText(filename);
				
			}
		});
		btnOpen.setBounds(286, 131, 89, 23);
		csvup.add(btnOpen);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int row[] = new int[100];
				//String replace[]=new String[100];
				//String prd[]=new String[100];
				String path = openfile.getText();
				String traind = traindata.getText(); 
				File dir = new File(path);
				File dir2= new File(traind);
				try{ //code for NB classifier, to predict missing values of one column
					//load training dataset
					DataSource source = new DataSource(dir2.getCanonicalPath());
					Instances trainDataset = source.getDataSet();	
					//set class index to the last attribute
					trainDataset.setClassIndex(trainDataset.numAttributes()-1);
					//get number of classes
					int numClasses = trainDataset.numClasses();
					//print out class values in the training dataset
					for(int i = 0; i < numClasses; i++){
						//get class string value using the class index
						String classValue = trainDataset.classAttribute().value(i);
						System.out.println("Class Value "+i+" is " + classValue);
					}
					//create and build the classifier
					NaiveBayes nb = new NaiveBayes();
					nb.buildClassifier(trainDataset);
					//load new dataset
					DataSource source1 = new DataSource(dir.getCanonicalPath());
					Instances testDataset = source1.getDataSet();	
					//set class index to the last attribute
					testDataset.setClassIndex(testDataset.numAttributes()-1);
					//loop through the new dataset and make predictions
					System.out.println("===================");
					System.out.println("Actual Class, NB Predicted");
					for (int i = 0; i < testDataset.numInstances(); i++) {
						//get class double value for current instance
						double actualClass = testDataset.instance(i).classValue();
						//get class string value using the class index using the class's int value
						String actual = testDataset.classAttribute().value((int) actualClass);
						//get Instance object of current instance
						Instance newInst = testDataset.instance(i);
						//call classifyInstance, which returns a double value for the class
						double predNB = nb.classifyInstance(newInst);
						//use this value to get string value of the predicted class
						String predString = testDataset.classAttribute().value((int) predNB);
						System.out.println(actual+","+predString);
						//prd[i]=predString;
					}
				    }
					/*for(int k=0;k<prd.length;k++)
					{
						if(prd[k]!=null)
						{
						int col=testDataset.numAttributes();
						int row=testDataset.numInstances();
						BufferedReader reader =
								new BufferedReader(new FileReader(dir));
								ArffReader arff = new ArffReader(reader,',');
								Instances data = arff.getData();
								
								//data.instance(k).setValue(newData.numAttributes() - 1, genre);
						
						//System.out.println(prd[k]);
						}
					}*/
				catch(Exception io)
				{
				} 
				//String javaPath = path.replace("\","/");
				csvup.setVisible(false);
				end.setVisible(true);
			}
		});
		btnNext.setBounds(628, 406, 89, 23);
		csvup.add(btnNext);
		
		JLabel lblLocationToSave = new JLabel("LOCATION TO SAVE ARFF FILE AFTER APPLYING NB ALGO");
		lblLocationToSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLocationToSave.setBounds(17, 191, 414, 14);
		csvup.add(lblLocationToSave);
		
		saveloc = new JTextField();
		saveloc.setBounds(17, 216, 231, 20);
		csvup.add(saveloc);
		saveloc.setColumns(10);
		
		JButton btnBrowse = new JButton("BROWSE");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Display display = new Display();
			    Shell shell = new Shell(display);
			    shell.open();
			    FileDialog dialog = new FileDialog(shell, SWT.SAVE);
			    dialog.setFilterNames(new String[] { "CSV", "All Files (*.*)" });
			    dialog.setFilterExtensions(new String[] { "*.csv", "*.*" }); // Windows
			                                    // wild
			                                    // cards
			    dialog.setFilterPath("c:\\"); // Windows path
			    saveloc.setText(dialog.open());
			    shell.setVisible(false);
			    //while (!shell.isDisposed()) {
			      //if (!display.readAndDispatch())
			        //display.sleep();
			//}
			}
		});
		btnBrowse.setBounds(286, 215, 89, 23);
		csvup.add(btnBrowse);
		
		JLabel lblTariningDataSet = new JLabel("TRAINING DATA SET");
		lblTariningDataSet.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTariningDataSet.setBounds(20, 11, 177, 22);
		csvup.add(lblTariningDataSet);
		
		traindata = new JTextField();
		traindata.setBounds(17, 42, 234, 20);
		csvup.add(traindata);
		traindata.setColumns(10);
		
		JButton button = new JButton("OPEN");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser=new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String filename=f.getAbsolutePath();
				traindata.setText(filename);
			}
		});
		button.setBounds(286, 41, 89, 23);
		csvup.add(button);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); //to close the application on clicking "CLOSE" button
			}
		});
		btnClose.setBounds(336, 233, 89, 23);
		end.add(btnClose);
		
		JLabel lblThankYou = new JLabel("THANK YOU!!!");
		lblThankYou.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThankYou.setBounds(311, 129, 128, 42);
		end.add(lblThankYou);
		
		JLabel lblYourCsvFile = new JLabel("MODIFIED ARFF FILE IS SAVED");
		lblYourCsvFile.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblYourCsvFile.setBounds(235, 43, 365, 29);
		end.add(lblYourCsvFile);
		
		JLabel lblListOfTables = new JLabel("LIST OF TABLES");
		lblListOfTables.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblListOfTables.setBounds(282, 36, 177, 33);
		listtables.add(lblListOfTables);
		
		comboBox_1.setBounds(246, 146, 199, 20);
		listtables.add(comboBox_1);
		
		JButton btnNext_3 = new JButton("NEXT");
		btnNext_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displaytable.setVisible(true);
				listtables.setVisible(false);
			}
		});
		btnNext_3.setBounds(641, 406, 89, 23);
		listtables.add(btnNext_3);
		
		JLabel lblLoadTables = new JLabel("LOAD TABLES");
		lblLoadTables.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLoadTables.setBounds(246, 92, 118, 33);
		listtables.add(lblLoadTables);
		
		
		JButton btnLoad = new JButton("LOAD");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				int itemcount= comboBox_1.getItemCount();
				for(int ii=0;ii<itemcount;ii++)
				{
					 comboBox_1.removeItemAt(0);
				}
				
				String table[] = new String[30];
				int i=0;
				try{
				//code for loading list of tables in combo box
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
				Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=check_connection;user=sa;password=9838929487");
				Statement sta = conn.createStatement();
				String Sql ="use check_connection;SELECT * FROM sys.Tables";
				ResultSet rs = sta.executeQuery(Sql);
				while (rs.next()) {
					table[i]=rs.getString(1);
					//System.out.println(rs.getString(1));
					comboBox_1.addItem(rs.getString(1));
					i=i+1;
				}
				}
				catch(Exception e){
				System.out.println("error");	
				}
				
			}
		});
		btnLoad.setBounds(359, 99, 89, 23);
		listtables.add(btnLoad);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listtables.setVisible(false);
				main.setVisible(true);
			}
		});
		btnBack.setBounds(10, 406, 89, 23);
		listtables.add(btnBack);
		
		JButton btnNext_4 = new JButton("NEXT");
		btnNext_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numInsbox.setVisible(false);
				//path to the folder where you will save your csv files
				FileWriter fw ;
				String filefolder="D:/db2csv/";
				try{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
					Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=check_connection;user=sa;password=9838929487");
					Statement sta = conn.createStatement();
					String table_name=comboBox_1.getSelectedItem().toString(); //storing selected table name in string
					System.out.println(table_name);
					System.out.println("check");
					//select all data from table
	                ResultSet res = sta.executeQuery("select * from "+ table_name);
	                System.out.println("ok");
	                ResultSetMetaData rsmetadata = res.getMetaData();
	                //colunm count is necessay as the tables are dynamic and we need to figure out the numbers of columns
	                int colunmCount = rsmetadata.getColumnCount();
	                try{
	          
	                fw = new FileWriter(filefolder+""+table_name+".csv");
	              //this loop is used to add column names at the top of file , if you do not need it just comment this loop
                    for(int i=1 ; i<=colunmCount ;i++)
                    {
                        fw.append(res.getMetaData().getColumnName(i));
                        if(i!=colunmCount)
                        {
                        fw.append(",");
                        }
             
                    }
                     
                    fw.append(System.getProperty("line.separator"));
                    while(res.next())
                    {
                        for(int i=1;i<=colunmCount;i++)
                        {
                             
                            //you can update it here by using the column type but i am fine with the data so just converting 
                            //everything to string first and then saving
                            if(res.getObject(i)!=null)
                            {
                            String data= res.getObject(i).toString();
                            fw.append(data) ;
                            	if(i!=colunmCount)
                            		{
                            		fw.append(",");
                            		}
                            }
                            else
                            {
                                String data= "null";
                                fw.append(data) ;
                                if(i!=colunmCount)
                        		{
                                fw.append(",");
                        		}
                            }
                             
                        }
                        //new line entered after each row
                        fw.append(System.getProperty("line.separator"));
                    }
                     fw.flush();
                     fw.close();
	                }
				catch(IOException e1)
				{
					System.out.println("error");
				}
				}
	                catch (ClassNotFoundException e2){
	                    System.err.println("Could not load JDBC driver");
	                    }
	                    catch(SQLException e3){
	                    System.err.println("SQLException information");
	                    }
				
				
				// load CSV
			    try{
				CSVLoader loader = new CSVLoader();
			    String loc =comboBox_1.getSelectedItem().toString();
			    loader.setSource(new File(filefolder+""+loc+".csv")); //filefolder+""+table_name+".csv//load the csv file created from table shown
			    Instances data = loader.getDataSet();//get instances object

			    // save ARFF
			    ArffSaver saver = new ArffSaver();
			    saver.setInstances(data);//set the dataset we want to convert
			    //and save as ARFF
			    saver.setFile(new File(filefolder+""+loc+".arff"));//convert the csv file created from shown table to arff file
			    saver.writeBatch();
			    }
			    catch(IOException ex5)
			    {
			    	System.out.println("arff file creation error");
			    }
	                						
				displaytable.setVisible(false);
				lblClickNext.setVisible(false);
				convert.setVisible(true);
				btnApplyNb.setVisible(true);				
			}
		});
		btnNext_4.setBounds(641, 406, 89, 23);
		displaytable.add(btnNext_4);
		
		JButton btnShowTable = new JButton("SHOW TABLE");
		btnShowTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					//code for loading list of tables in combo box
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
					Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=check_connection;user=sa;password=9838929487");
					Statement sta = conn.createStatement();
					String table_name=comboBox_1.getSelectedItem().toString(); //storing selected table name in string				
					String Sql ="SELECT * FROM "+ comboBox_1.getSelectedItem().toString();
					System.out.println(Sql);
					System.out.println("hello");
					ResultSet rs= sta.executeQuery(Sql);
					System.out.println("hello2");
					ResultSetMetaData rsmetadata = rs.getMetaData();
					System.out.println("hello3");
					//it stores number of columns
					int columns=rsmetadata.getColumnCount();
					System.out.println("hello4");
					//this object will pass data into Jtable
					DefaultTableModel dtm=new DefaultTableModel();
					Vector columns_name= new Vector();
					Vector data_rows=new Vector();
					
					for(int i=1;i<=columns;i++){
						columns_name.addElement(rsmetadata.getColumnName(i));
					}
					dtm.setColumnIdentifiers(columns_name);
					
					while(rs.next()){
						
						data_rows=new Vector();
						for(int j=1;j<=columns;j++){
							data_rows.addElement(rs.getString(j));
						}
						dtm.addRow(data_rows);
					}
					//pass default table object into table_1
					table_1.setModel(dtm);
					table_1.setVisible(true);
					//finished
					}
					catch(Exception ex){
					System.out.println("error");	
					}
				
				
			}
		});
		btnShowTable.setBounds(10, 11, 112, 23);
		displaytable.add(btnShowTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 52, 608, 284);
		displaytable.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JButton btnBack_1 = new JButton("BACK");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displaytable.setVisible(false);
				listtables.setVisible(true);
				
			}
		});
		btnBack_1.setBounds(10, 406, 89, 23);
		displaytable.add(btnBack_1);
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 41, 696, 354);
		shownewtable.add(scrollPane_1);
		
		
		
		table_2 = new JTable();
		scrollPane_1.setViewportView(table_2);
		
		JLabel lblTableWithPredicted = new JLabel("TABLE WITH PREDICTED VALUES");
		lblTableWithPredicted.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTableWithPredicted.setBounds(10, 11, 290, 25);
		shownewtable.add(lblTableWithPredicted);
		
		JButton btnClose_1 = new JButton("CLOSE");
		btnClose_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); //to close the application on clicking "CLOSE" button
			}
		});
		btnClose_1.setBounds(641, 406, 89, 23);
		shownewtable.add(btnClose_1);
		
	}
}
