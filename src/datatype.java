import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;


public class datatype {
	public String datatype_prop(String sub,String parent,String database)
	{
		// select table names 
		String table_names[]=new String[20];
		int temp_table_names_length = 0;
		int temp_col_names_length = 0;
		String temp_table_name=null;
		String temp_col_name = null;
		
		
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
				
		}
		table_names = Arrays.stream(table_names)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);*/
		Connection con2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName="+database+";user=sa;password=9838929487");
		Statement st2 = con2.createStatement();
		for(int k=0;k<table_names.length;k++)
		{
			String col_names[]=new String[20];
			String foreign_keys[]=new String[20];
			String columns="SELECT COLUMN_NAME FROM "+database+".INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '"+table_names[k]+"'";
			ResultSet rs2= st2.executeQuery(columns);
			int i2=0;
			//System.out.println(table_names[k]);
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
					table_names[k]=null;
				}
				
			/*	System.out.println(table_names[k]+"--------------");
				for(int kk=0;kk<col_names.length;kk++)
			{
				
				System.out.println(col_names[kk]);
			}*/
				
				temp_table_names_length=table_names.length;
				temp_col_names_length=col_names.length;
				temp_table_name=table_names[k];
				
				if(table_names[k].equalsIgnoreCase(null)==false && table_names[k].equalsIgnoreCase(parent)==false && col_names.length!=0)
				{
					for(int k5=0;k5<col_names.length;k5++)
					{
						temp_col_name=col_names[k5];	
					//return(String.valueOf(table_names.length)+",.,"+String.valueOf(col_names.length)+",.,"+table_names[k]+",.,"+col_names[k5]);
					}
				}
				else
				{
					
				}	
		}
		table_names = Arrays.stream(table_names)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);
		
		
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
		
		return(String.valueOf(temp_table_names_length)+",.,"+String.valueOf(temp_col_names_length)+",.,"+temp_table_name+",.,"+temp_col_name);
		
		
	}
	
	

}
