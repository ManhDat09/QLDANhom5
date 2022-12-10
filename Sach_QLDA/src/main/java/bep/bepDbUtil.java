package bep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;


public class bepDbUtil {

	private DataSource dataSource;
	public bepDbUtil(DataSource theDataSource) {
	dataSource = theDataSource;
	}
	public List<bep> getbeps() throws Exception {
	List<bep> beps = new ArrayList<>();
	
	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;
	try {
	// get a connection
	myConn = dataSource.getConnection();
	// create sql statement
	String sql = "select * from bep_buimanhdat order by tenbep";
	myStmt = myConn.createStatement();
	// execute query
	myRs = myStmt.executeQuery(sql);
	// process result set
	while (myRs.next()) {
	// retrieve data from result set row
	int mabep = myRs.getInt("mabep");
	String tenbep = myRs.getString("tenbep");
	float soluong = myRs.getFloat("soluong");
	String Nhasanxuat = myRs.getString("Nhasanxuat");
	float Tonkho = myRs.getFloat("Tonkho");
	float SoNambaohanh = myRs.getFloat("SoNambaohanh");
	// create new student object
	bep tempbep = new bep();
	// add it to the list of students
	beps.add(tempbep);
	}
	return beps;
	}
	finally {
	// close JDBC objects
	close(myConn, myStmt, myRs);
	}
	}
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
	try {
	if (myRs != null) {
	myRs.close();
	}
	if (myStmt != null) {
	myStmt.close();
	}
	if (myConn != null) {
	myConn.close(); // doesn't really close it ... just puts back in connection pool
	    }
	}
	catch (Exception exc) {
	exc.printStackTrace();
	     }
	}
	public void addbep(bep thebep) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		  try {
		// get db connection
		     myConn = dataSource.getConnection();
		// create sql for insert
		    String sql = "insert into bep_buimanhdat " + "(mabep, tenbep, soluong, Nhasanxuat, Tonkho, SoNambaohanh) " + "values (?, ?, ?, ?, ?, ?)";
		   myStmt = myConn.prepareStatement(sql);
		// set the param values for the student
		   myStmt.setInt(1, thebep.getmabep());
		   myStmt.setString(2, thebep.gettenbep());
		   myStmt.setFloat(3, thebep.getsoluong());
		   myStmt.setString(4, thebep.getNhasanxuat());
		   myStmt.setFloat(5, thebep.getTonkho());
		   myStmt.setFloat(6, thebep.getSoNambaohanh());
		   
		// execute sql insert
		   myStmt.execute();
		}
		finally {
		// clean up JDBC objects
		close(myConn, myStmt, null);
		}
	}
	public bep getbep(String thebepmabep) throws Exception {
		bep thebep = null;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int bepmabep;
		try {
		// convert student id to int
		bepmabep = Integer.parseInt(thebepmabep);
		// get connection to database
		myConn = dataSource.getConnection();
		// create sql to get selected student
		String sql = "select * from bep_buimanhdat where mabep=?";
		// create prepared statement
		myStmt = myConn.prepareStatement(sql);
		// set params
		myStmt.setInt(1, bepmabep);
		// execute statement
		myRs = myStmt.executeQuery();
		// retrieve data from result set row
		if (myRs.next()) {
		String tenbep = myRs.getString("tenbep");
		Float soluong = myRs.getFloat("soluong");
		String Nhasanxuat = myRs.getString("Nhasanxuat");
		Float Tonkho = myRs.getFloat("Tonkho");
		Float SoNambaohanh = myRs.getFloat("SoNambaohanh");
		
		// use the studentId during construction
		thebep = new bep();
		}
		else {
		throw new Exception("Could not find student id: " + 
		bepmabep);
		}
		return thebep;
		}
		finally {
		// clean up JDBC objects
		close(myConn, myStmt, myRs);
		}
	}
	public void updatebep(bep thebep) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
		// get db connection
		myConn = dataSource.getConnection();
		// create SQL update statement
		String sql = "update bep_buimanhdat " + "set tenbep=?, soluong=?, Nhasanxuat=?, Tonkho=?, SoNambaohanh=? " + "where mabep=?";
		// prepare statement
		myStmt = myConn.prepareStatement(sql);
		// set params
		myStmt.setString(1, thebep.gettenbep());
		myStmt.setFloat(2, thebep.getsoluong());
		myStmt.setString(3, thebep.getNhasanxuat());
		myStmt.setFloat(4, thebep.getTonkho());
		myStmt.setFloat(5, thebep.getSoNambaohanh());
		myStmt.setInt(6, thebep.getmabep());
		
		// execute SQL statement
		myStmt.execute();

		}
		finally {
		// clean up JDBC objects
		close(myConn, myStmt, null);
		}
	}
	public void deletebep(String thebepmabep) throws Exception {
		// TODO Auto-generated method stub
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
		// convert student id to int
		int bepmabep = Integer.parseInt(thebepmabep);
		// get connection to database
		myConn = dataSource.getConnection();
		// create sql to delete student
		String sql = "delete from bep_buimanhdat where mabep=?";
		// prepare statement
		myStmt = myConn.prepareStatement(sql);
		// set params
		myStmt.setInt(1, bepmabep);
		// execute sql statement
		myStmt.execute();
		}
		finally {
		// clean up JDBC code
		close(myConn, myStmt, null);

		}
		
	}
}

