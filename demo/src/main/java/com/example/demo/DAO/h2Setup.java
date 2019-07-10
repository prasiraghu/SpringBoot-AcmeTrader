package com.example.demo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class h2Setup {

	@Autowired
	static
	Connection connection;	
	
	public static void insertRecordInTableUsingStatement() 
	{
	    try
	    {
	    	connection = DriverManager.getConnection ("jdbc:h2:mem:testdb", "sa","");
	    	
	        //Set auto commit to false  
//	        connection.setAutoCommit(false);
	         
	        Statement statement = connection.createStatement();
	        String sql =  "CREATE TABLE IF NOT EXISTS STOCK_QUOTES " + 
	            "(STOCK_SYMBOL VARCHAR(10), " + 
	            " MARKET_DATE DATE, " +  
	            " OPEN DECIMAL(10, 4), " +  
	            " HIGH DECIMAL(10, 4), " +
	            " LOW DECIMAL(10, 4), " +
	            " CLOSE DECIMAL(10, 4), " +
	            " VOLUME INT) ";
	        statement.execute(sql);

	        statement.executeUpdate("INSERT INTO STOCK_QUOTES (STOCK_SYMBOL, MARKET_DATE, OPEN, HIGH, LOW, CLOSE, VOLUME) "
	                + "        VALUES ('AAPL', '2018-01-24', 160.36, 160.63, 158.40, 158.97, 20340900)");
	        statement.executeUpdate("INSERT INTO STOCK_QUOTES (STOCK_SYMBOL, MARKET_DATE, OPEN, HIGH, LOW, CLOSE, VOLUME) "
	                + "        VALUES ('AAPL', '2018-01-25', 159.64, 159.92, 158.21, 159.03, 20290900)");
	        statement.executeUpdate("INSERT INTO STOCK_QUOTES (STOCK_SYMBOL, MARKET_DATE, OPEN, HIGH, LOW, CLOSE, VOLUME) "
	                + "        VALUES ('AAPL', '2018-01-26', 159.53, 159.69, 158.77, 159.60, 16120300)");
	        statement.executeUpdate("INSERT INTO STOCK_QUOTES (STOCK_SYMBOL, MARKET_DATE, OPEN, HIGH, LOW, CLOSE, VOLUME) "
	                + "        VALUES ('AAPL', '2018-01-29', 159.06, 159.86, 158.62, 158.70, 18293300)");
	        statement.executeUpdate("INSERT INTO STOCK_QUOTES (STOCK_SYMBOL, MARKET_DATE, OPEN, HIGH, LOW, CLOSE, VOLUME) "
	                + "        VALUES ('AAPL', '2018-01-30', 157.66, 158.22, 156.73, 157.18, 24533800)");
	        statement.executeUpdate("INSERT INTO STOCK_QUOTES (STOCK_SYMBOL, MARKET_DATE, OPEN, HIGH, LOW, CLOSE, VOLUME) "
	                + "        VALUES ('AAPL', '2018-01-31', 157.74, 158.42, 155.92, 156.36, 27468900)");
	        //Close the statement object
	        statement.close();
	         
	        //Commit the record to the DB table
	        connection.commit();
	    }
	    catch(Exception ex) 
	    {
	        System.out.println(ex.toString());
	    }
	         
	}
}
