package model;

public class GuestBookEntry {
	private String name;
	private String message;
	private int id;
	
	public GuestBookEntry(){}
	public GuestBookEntry(String name, String message,int id){
		this.setName(name);
		this.setMessage(message);
		this.setId(id);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
