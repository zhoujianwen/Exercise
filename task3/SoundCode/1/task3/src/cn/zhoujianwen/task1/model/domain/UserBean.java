package cn.zhoujianwen.task1.model.domain;

public class UserBean {
	private String userName;
	private String passWord;
	
	
	public UserBean()
	{}
	
	//获取用户名
	public String getUserName() {
		return userName;
	}
	
	//设置用户名
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	//获取密码
	public String getPassWord() {
		return passWord;
	}
	
	//修改密码
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
}
