package tk.codecube.oa.sys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import tk.codecube.base.BaseModel;
@Entity
@Table(name="test_model")
public class TestModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1601692117243826436L;

	
	@Column(name="username",length=50)
	private String userName;
	
	@Column(name="password",length=64)
	private String passWord;


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
	
}
