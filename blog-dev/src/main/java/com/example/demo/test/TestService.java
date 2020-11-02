package com.example.demo.test;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn=Exception.class)
public class TestService {
	@Autowired
	TestRepository testRepository;

	public List<TestEntity> findAll(){
		return testRepository.findAll();
	}

	public TestEntity findOne(Integer id) {
		Optional<TestEntity> entity = testRepository.findById(id);

		if(entity.isPresent()) {
			return entity.get();
		}else {
			return null;
		}
	}

	public void register(TestEntity entity) {
		testRepository.save(entity);
	}

	public void register(Integer num) throws Exception{
//		for(int i=0; i<3; i++) {
//			testRepository.save(list.get(i));
//		}
		for(int i=0;i<num;i++) {
			testRepository.checkRollback();
		}
	}

	public void delete(Integer id) {
		testRepository.deleteById(id);
	}
}
