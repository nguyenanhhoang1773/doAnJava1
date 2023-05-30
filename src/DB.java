
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
public class DB {
		String jdbcUrl = "jdbc:mysql://localhost:3306/doAnJava1";
	    String username = "root";
	    String password = "";
	    Connection connection = null;
	    	public void ConnectDB() {
	        try {
	            connection = DriverManager.getConnection(jdbcUrl, username, password);
	            System.out.println("Kết nối thành công!");
	        } catch (SQLException e) {
	            System.out.println("Kết nối thất bại! Lỗi: " + e.getMessage());
	        } 
	}
	    	public boolean verifyUser (String userName1,String password1) {
	    		try {
	                String sqlQuery = "SELECT * FROM User";
	                Statement statement = connection.createStatement();
	                ResultSet resultSet = statement.executeQuery(sqlQuery);
	                while (resultSet.next()) {
	                    int id = resultSet.getInt("id");
	                    String userName = resultSet.getString("userName");
	                    String password = resultSet.getString("password");
	                    if(userName1.equals(userName) && password.equals(password1)) {
	                    	return true; 
	                    }
	                }
	                resultSet.close();
	                statement.close();
	            } catch (SQLException e) {
	                System.out.println("Lỗi khi lấy dữ liệu từ MySQL: " + e.getMessage());
	            }
				return false;
	    	}
	    	public List<Room> getRoom() {
	    		List<Room> rooms = new ArrayList<>();
	    		try {
	                String sqlQuery = "SELECT * FROM Room";
	                Statement statement = connection.createStatement();
	                ResultSet resultSet = statement.executeQuery(sqlQuery);
	                while (resultSet.next()) {
	                    int id = resultSet.getInt("id");
	                    String name = resultSet.getString("name");
	                    String jsonString = resultSet.getString("json_column");
	                    JsonObject jsonObject = new Gson().fromJson(jsonString, JsonObject.class);
//	                    JsonElement element = jsonObject.get("");
//	                    List<Integer> idMessage = new Gson().fromJson(jsonString, new TypeToken<List<Integer>>() {}.getType());
//	                    
//	                    Room rm = new Room(id, name, .ad)
//	                    rooms.add(rm)
	                    System.out.println("ID: " + id + ", Name: " + name);
	                }
	                resultSet.close();
	                statement.close();
	                System.out.println("Lấy dữ liệu thành công!");
	            } catch (SQLException e) {
	                System.out.println("Lỗi khi lấy dữ liệu từ MySQL: " + e.getMessage());
	            }
	    		 return rooms; 
	    	}
	    	public List<Message> getMessage() {
	    		List<Message> messages = new ArrayList<>();
	    		try {
	                String sqlQuery = "SELECT * FROM Message";
	                Statement statement = connection.createStatement();
	                ResultSet resultSet = statement.executeQuery(sqlQuery);
	                while (resultSet.next()) {
	                    int id = resultSet.getInt("id");
	                    int idUser = resultSet.getInt("idUser");
	                    String content = resultSet.getString("content");
	                    Timestamp timestamp = resultSet.getTimestamp("timestamp");
	                    Date time = new Date(timestamp.getTime());
	                    Message msg = new Message(id,idUser,content,time);
	                    messages.add(msg);
	                }
	                resultSet.close();
	                statement.close();
	                System.out.println("Lấy dữ liệu thành công!");
	            } catch (SQLException e) {
	                System.out.println("Lỗi khi lấy dữ liệu từ MySQL: " + e.getMessage());
	            }
	    		 return messages; 
	    	}
	    		

}
