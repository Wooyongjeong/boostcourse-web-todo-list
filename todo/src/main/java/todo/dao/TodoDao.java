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
	private static String dburl = "본인의 DB URL을 작성해주세요";
	private static String dbUser = "본인의 DB Username을 작성해주세요";
	private static String dbpasswd = "본인의 DB password을 작성해주세요";
	
	public int addTodo(String title, String name, int sequence) {
		int insertCount = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO todo(title, name, sequence) values(?, ?, ?)";
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, title);
			ps.setString(2, name);
			ps.setInt(3, sequence);
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
		String sql = "select id, title, name, sequence, type, regdate from todo where type = 'TODO' order by regdate";
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
		String sql = "select id, title, name, sequence, type, regdate from todo where type = 'DOING' order by regdate";
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
		String sql = "select id, title, name, sequence, type, regdate from todo where type = 'DONE' order by regdate";
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
