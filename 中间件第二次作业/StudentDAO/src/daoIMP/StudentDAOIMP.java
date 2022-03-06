package daoIMP;
import bean.Student;
import dao.StudentDAO;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import connection.DataBaseConnection;

public class StudentDAOIMP implements StudentDAO{
	// 添加操作
	    public void insert(Student s){
	      String sql = "INSERT INTO student (id, name) values (?,?)";
	    PreparedStatement pstmt = null;
	    DataBaseConnection conn = null;
	    //针对数据库的具体操作
	    try{
	        conn = new DataBaseConnection();
	        
	        pstmt = conn.getConnection().prepareStatement(sql);
	        pstmt.setLong(1,s.getID());
	        //pstmt.setString(1,s.getID());
	        pstmt.setString(2,s.getName());
	  
	        pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	        }
	     catch(Exception e){  }
	      }

	    public void update(Student s){
	    	String sql = "UPDATE Student set id=?,name=? where id=?";
			PreparedStatement pstmt = null;
			DataBaseConnection conn = null;
			try{
				conn = new DataBaseConnection();

				pstmt = conn.getConnection().prepareStatement(sql);
				pstmt.setLong(1,s.getID());
				//pstmt.setString(1,s.getID());
				pstmt.setString(2,s.getName());

				pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			}
			catch(Exception e){  }
	    }

	    public void delete(String iD){
	    	String sql="delete from student where iD=?";
			PreparedStatement pstmt = null;
			DataBaseConnection conn = null;
			try{
				conn = new DataBaseConnection();

				pstmt = conn.getConnection().prepareStatement(sql);
				pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			}
			catch(Exception e){  }
	    }
	    
	    public List findAll(){
	    	String sql="select * from student";
			PreparedStatement pstmt = null;
			DataBaseConnection conn = null;
			List<Student> list= new LinkedList<Student>() {
			};
			try{
				conn = new DataBaseConnection();

				pstmt = conn.getConnection().prepareStatement(sql);
				ResultSet resultSet=pstmt.executeQuery();
				while(resultSet.next()){
					Student s=new Student();
					s.setID(resultSet.getLong("id"));
					s.setName(resultSet.getString("name"));
					list.add(s);
					}
				return list;
			}
			catch(Exception e){ return null; }
	    }

        public Student findByID(long iD){
        	String sql="select * from student where iD= ?";
			PreparedStatement pstmt = null;
			DataBaseConnection conn = null;
			try{
				conn = new DataBaseConnection();

				pstmt = conn.getConnection().prepareStatement(sql);
				ResultSet resultSet =pstmt.executeQuery();
				Student s=new Student();
				s.setID(resultSet.getLong("id"));
				s.setName(resultSet.getString("name"));
				return s;
			}
			catch(Exception e){ return null;}
        }

                  }
