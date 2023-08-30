package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mariadb://localhost:3306/test";
    	String sql = "SELECT * FROM notice";
        
        Class.forName("org.mariadb.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, "root", "1324");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        if(rs.next()){
    	    System.out.print(rs.getString("TITLE"));
    	}

    	// 리소스 해제
    	rs.close();
    	st.close();
    	con.close();
    }

}
