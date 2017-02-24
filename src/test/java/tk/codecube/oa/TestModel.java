package tk.codecube.oa;

import tk.codecube.base.BaseModel;

public class TestModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1601692117243826436L;

	private String id;
	
	private String userName;
	
	private String passWord;

	public String getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
