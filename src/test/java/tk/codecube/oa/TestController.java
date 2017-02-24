package tk.codecube.oa;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService testService;
	
	public TestController() {
		System.out.println("TestController.TestController()");
	}
	
	@RequestMapping("/save")
	public void save(String name){
		TestModel tm = new TestModel();
		tm.setUserName(name);
		tm.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		testService.saveTestInfo(tm);
	}
	
	@RequestMapping("/get")
	public void get(String id){
		TestModel tm = testService.getModel(id);
		System.out.println(tm.toString());
	}
}
