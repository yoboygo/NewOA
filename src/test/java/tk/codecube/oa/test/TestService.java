package tk.codecube.oa.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tk.codecube.oa.sys.TestModel;

@Service("testService")
public class TestService {

	@Autowired
	private TestDao testDao;
	
	@Transactional
	public void saveTestInfo(TestModel tm){
		testDao.save(tm);
	}
	
	@Transactional(readOnly = true)
	public TestModel getModel(String id){
		return testDao.get(id);
	}
}
