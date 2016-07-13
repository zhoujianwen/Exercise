package chapter06.session.login;

import java.util.Iterator;

public class User implements Iterable<User> {
	
	private String username;
	
	private String password;
	
	public User(){}
	
	public User(String username,String password){
		this.username = username;
		this.password = password;
	}
	
	public String getUsername()
	{
		return this.username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	
	public static void main(String[] args)
	{
		User[] list = new User[3];
		list[0] = new User("a","a");
		list[1] = new User("b","b");
		list[2] = new User("c","c");
		Iterator<User> iterator = list;
		while (iterator.hasNext()) {
			User user =  iterator.next();
			System.out.println(user);
		}
	}

	@Override
	public Iterator<User> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
