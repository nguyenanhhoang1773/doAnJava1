import java.util.Date;

public class Message {
	private int idMessage;
	private int idUser;
	private String content;
	private Date timestamp;
	public Message(int idMessage, int idUser, String content, Date timestamp) {
		this.idMessage = idMessage;
		this.idUser = idUser;
		this.content = content;
		this.timestamp = timestamp;
	}
	public int getId() {
		return this.idMessage;
	}
	public String getContent() {
		return this.content;
	}
	public Date getTime() {
		return this.timestamp;
	}
}
