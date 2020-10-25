package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn=Exception.class)
public class BlogService {
	@Autowired
	BlogRepository repository;

	public List<BlogEntry> findAll(){
		return repository.findAll();
	}

	public BlogEntry findOne(Integer id) {
		Optional<BlogEntry> entry = repository.findById(id);

		if(entry.isPresent()) {
			return entry.get();
		}else {
			return null;
		}
	}

	public BlogEntry register(BlogEntry entry) {
		entry.setCreate_time( LocalDateTime.now() );
		return repository.save(entry);
	}

	public BlogEntry update(BlogEntry entry) {
		entry.setUpdate_time( LocalDateTime.now() );
		return repository.save(entry);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
