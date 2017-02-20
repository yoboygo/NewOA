package tk.codecube.oa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	@Autowired
	private TestDao td;
	
	public void saveTestInfo(TestModel tm){
		td.save(tm);
	}
	
	
	public TestModel getModel(String id){
		return td.get(id);
	}
}
