package tk.codecube.oa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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
