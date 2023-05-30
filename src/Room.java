import java.util.List;

public class Room {
	private int id;
	private String name;
	private List<Message> messages;
	public Room(int id, String name, List<Message> messages) {
		this.id = id;
		this.name = name;
		this.messages = messages;
	}
	public List<Message> getMesssages () {
		return this.messages;
	}
}
