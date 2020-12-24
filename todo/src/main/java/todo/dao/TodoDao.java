package todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import todo.dto.TodoDto;

public class TodoDao {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";
	
	public int addTodo(TodoDto todo) {
		int insertCount = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO todo(title, name, sequence) values(?, ?, ?)";
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, todo.getTitle());
			ps.setString(2, todo.getName());
			ps.setInt(3, todo.getSequence());
			insertCount = ps.executeUpdate();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return insertCount;
	}
	
	public int updateTodo(long id, String type) {
		int updateCount = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "UPDATE todo SET type = ? WHERE id = ?;";
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, type);
			ps.setLong(2, id);
			
			updateCount = ps.executeUpdate();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return updateCount;
	}
	
	public List<TodoDto> getTodos() {
		List<TodoDto> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "select id, title, name, sequence, type, regdate from todo where type = 'TODO' order by regdate desc";
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			try(ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					long id = rs.getLong(1);
					String title = rs.getString(2);
					String name = rs.getString(3);
					int sequence = rs.getInt(4);
					String type = rs.getString(5);
					Timestamp regDateTimeStamp = rs.getTimestamp(6);
					String regDate = new SimpleDateFormat("yyyy.MM.dd").format(regDateTimeStamp);
					
					TodoDto todo = new TodoDto(id, title, name, sequence, type, regDate);
					list.add(todo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
	public List<TodoDto> getDoings() {
		List<TodoDto> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "select id, title, name, sequence, type, regdate from todo where type = 'DOING' order by regdate desc";
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			try(ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					long id = rs.getLong(1);
					String title = rs.getString(2);
					String name = rs.getString(3);
					int sequence = rs.getInt(4);
					String type = rs.getString(5);
					Timestamp regDateTimeStamp = rs.getTimestamp(6);
					String regDate = new SimpleDateFormat("yyyy.MM.dd").format(regDateTimeStamp);
					
					TodoDto todo = new TodoDto(id, title, name, sequence, type, regDate);
					list.add(todo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public List<TodoDto> getDones() {
		List<TodoDto> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "select id, title, name, sequence, type, regdate from todo where type = 'DONE' order by regdate desc";
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			try(ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					long id = rs.getLong(1);
					String title = rs.getString(2);
					String name = rs.getString(3);
					int sequence = rs.getInt(4);
					String type = rs.getString(5);
					Timestamp regDateTimeStamp = rs.getTimestamp(6);
					String regDate = new SimpleDateFormat("yyyy.MM.dd").format(regDateTimeStamp);
					
					TodoDto todo = new TodoDto(id, title, name, sequence, type, regDate);
					list.add(todo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
}
