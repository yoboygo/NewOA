package tk.codecube.oa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import tk.codecube.base.BaseModel;

/**
 * Hibernate自动扫包测试类
 * @author bpqqo
 *
 */
@Entity
@Table(name = "TEST_MODEL")
public class TestModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4632165885124880786L;
	
	private String name;

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
