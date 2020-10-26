package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class BlogTestController {

	@Autowired
	private BlogRepository testrepository;

//	@GetMapping("testa")
//	public String testA() {
//		try {
//			testrepository.insertTestIdA();
//		}catch(Exception e) {
//			return e.toString();
//		}
//		return "success";
//	}
//
//	@GetMapping("testb")
//	public String testB() {
//		try {
//			testrepository.insertTestIdB();
//		}catch(Exception e) {
//			return e.toString();
//		}
//		return "success";
//	}
//
//	@GetMapping("testc")
//	public String testC() {
//		try {
//		testrepository.insertTestIdC();
//		}catch(Exception e) {
//			return e.toString();
//		}
//		return "success";
//	}
}
