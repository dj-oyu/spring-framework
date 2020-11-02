package com.example.demo.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class BlogTestController {

	@Autowired
	private TestService testService;

	@GetMapping
	public String index(Model model) {
		List<TestEntity> entities = testService.findAll();
		model.addAttribute("entities", entities);
		return "test";
	}

	@GetMapping("{id}/user")
	@ResponseBody
	public String getUser(@PathVariable Integer id) {
		StringBuilder sb = new StringBuilder();
		TestEntity entity = testService.findOne(id);
		sb.append(entity.getUserName()).append(" ")
			.append(entity.getComment());

		return sb.toString();
	}

	@GetMapping("testtest")
	@ResponseBody
	public String testMethod() {
		try {
//			TestEntity test1 = new TestEntity();
//			test1.setId(99);
//			test1.setComment("test1");
//
//			TestEntity test2 = new TestEntity();
//			test2.setId(100);
//			test2.setComment("test2");
//
//			List<TestEntity> list = Arrays.asList(test1, test2);

			testService.register(3);

		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	@GetMapping("{id}/delete")
	public void deleteUser(@PathVariable Integer id) {
		testService.delete(id);
	}

	@PostMapping
	public String registerUser(TestEntity entity) {
		testService.register(entity);
		return "redirect:/test";
	}
}
