package model;

public class Admin extends Compte{

	public Admin(int id, String login, String password) {
		super(id, login, password);	
	}
	
	public Admin(String login, String password) {
		super(login, password);	
	}

	public String toString() {
		return "Admin [id=" + id + ", login=" + login + ", password=" + password + "]";
	}
	
	
	
}
