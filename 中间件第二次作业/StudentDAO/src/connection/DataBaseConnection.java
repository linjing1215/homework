package connection;

import java.sql.*;

public class DataBaseConnection{
    private final String DBDriver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String DBURL ="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=test";
    private final String DBUSER ="sa";
    private final String DBPASSWORD ="loveljing20125";
    private Connection conn = null;
//构造器
    public DataBaseConnection(){
       try{
           Class.forName(DBDriver);
           conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
           }
        catch(Exception e){  }
                                 }

//获得连接
public Connection getConnection(){
return this.conn; }

//关闭连接
public void close() throws SQLException{
    this.conn.close(); }
} 






 


