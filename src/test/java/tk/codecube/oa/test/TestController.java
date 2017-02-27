package tk.codecube.oa.test;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tk.codecube.oa.sys.TestModel;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService testService;
	
	public TestController() {
		System.out.println("TestController.TestController()");
	}
	
	@RequestMapping("/save")
	public void save(String name,HttpServletResponse response) throws IOException{
		TestModel tm = new TestModel();
		tm.setUserName(name);
		tm.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		testService.saveTestInfo(tm);
		response.getOutputStream().print("保存成功~");
	}
	
	@RequestMapping("/get")
	public void get(String id){
		TestModel tm = testService.getModel(id);
		System.out.println(tm.toString());
	}
}
